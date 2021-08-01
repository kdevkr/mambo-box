# Prerequisite
쿠버네티스 클러스터 구성을 위한 사전 작업을 정리한다.

## 시스템 요구사항
쿠버네티스 클러스터를 구성하는 각 호스트는 다음의 요구사항을 충족해야한다.

- 2코어 이상의 CPU
- 2GB 이상의 메모리

## 사전 작업

- 호스트의 메모리 스왑 기능을 비활성화
- 오버레이 및 브릿지 네트워크 필터 커널 모듈 활성화
- iptables 브릿지 트래픽 허용

```sh Terminal
# 메모리 스왑 기능 비활성화
sudo swapoff -a && sudo sed -i '/ swap / s/^\(.*\)$/#\1/g' /etc/fstab

# 오버레이 및 브릿지 네트워크 필터 커널 모듈 활성화
cat <<EOF | sudo tee /etc/modules-load.d/crio.conf
overlay
br_netfilter
EOF

sudo modprobe overlay
sudo modprobe br_netfilter

# iptables 브릿지 트래픽 허용
cat <<EOF | sudo tee /etc/sysctl.d/99-kubernetes-cri.conf
net.bridge.bridge-nf-call-iptables  = 1
net.ipv4.ip_forward                 = 1
net.bridge.bridge-nf-call-ip6tables = 1
EOF

# 변경사항 적용
sudo sysctl --system

# 기본 패키지 설치
sudo apt-get update
sudo apt-get install -y apt-transport-https ca-certificates curl

# CRI-O 컨테이너 런타임 설치
echo "deb https://download.opensuse.org/repositories/devel:/kubic:/libcontainers:/stable/xUbuntu_20.04/ /" | sudo tee /etc/apt/sources.list.d/devel:kubic:libcontainers:stable.list
echo "deb http://download.opensuse.org/repositories/devel:/kubic:/libcontainers:/stable:/cri-o:/1.21/xUbuntu_20.04/ /" | sudo tee /etc/apt/sources.list.d/devel:kubic:libcontainers:stable:cri-o:1.21.list

curl -L https://download.opensuse.org/repositories/devel:kubic:libcontainers:stable:cri-o:1.21/xUbuntu_20.04/Release.key | sudo apt-key add -
curl -L https://download.opensuse.org/repositories/devel:/kubic:/libcontainers:/stable/xUbuntu_20.04/Release.key | sudo apt-key add -

sudo apt-get update
sudo apt-get install -y cri-o cri-o-runc
sudo apt-mark hold cri-o cri-o-runc
sudo systemctl daemon-reload
sudo systemctl enable crio --now

# 쿠버네티스 관련 패키지 설치
sudo curl -fsSLo /usr/share/keyrings/kubernetes-archive-keyring.gpg https://packages.cloud.google.com/apt/doc/apt-key.gpg
echo "deb [signed-by=/usr/share/keyrings/kubernetes-archive-keyring.gpg] https://apt.kubernetes.io/ kubernetes-xenial main" | sudo tee /etc/apt/sources.list.d/kubernetes.list

sudo apt-get update
sudo apt-get install -y kubelet kubeadm kubectl
sudo apt-mark hold kubelet kubeadm kubectl
```