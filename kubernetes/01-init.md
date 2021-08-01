# Initialize k8s cluster
쿠버네티스 클러스터를 시작하기 위해서는 kubeadm, kubespray와 같은 쿠버네티스 클러스터 배포 도구를 사용해야한다.

## kubeadm init
```sh Terminal
sudo kubeadm init --apiserver-advertise-address=[호스트 내부 IP] --apiserver-cert-extra-sans=[호스트 외부 IP 또는 DNS] --pod-network-cidr=[파드 네트워크 CIDR 블록]
```

- --apiserver-advertise-address : 마스터 노드의 API 서버 주소 지정
- --apiserver-cert-extra-sans : 클러스터 외부에서 접근할 수 있게 API 서버 인증서에 SAN 추가
- --pod-network-cidr : 파드 네트워크를 구성할 CIDR 블록 지정
- --control-plane-endpoint : 2개 이상의 마스터 노드를 구성할 경우 공유 엔드포인트 지정

**example**
```sh Example
sudo kubeadm init --apiserver-advertise-address=$(hostname -I | awk '{print $1}') --apiserver-cert-extra-sans=$(curl -s https://ifconfig.io/ip) --pod-network-cidr=10.244.0.0/16
```

## Install CNI Plugin
```sh
# flannel
sudo kubectl apply -f https://raw.githubusercontent.com/coreos/flannel/master/Documentation/kube-flannel.yml
# canal
sudo kubectl apply -f https://docs.projectcalico.org/manifests/canal.yaml
```
