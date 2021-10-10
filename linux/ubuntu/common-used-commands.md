# Common Used Commands

## 일반 명령어

```bash
# 사용자 전환 (sudo su ec2-user)
sudo su ubuntu

# 실행가능한 쉘 스크립트 파일로 변경
chmod +x text.sh

# 현재 디렉토리 트리 조회
ll

# ll command not found
alias ll='ls -alF'

# 프로세스 조회
ps -ef | grep sh
ps -ef | grep sh | awk 'NR==1 {print $2}'

# 프로세스 파일 디스크립터 조회
lsof -p $PID | wc -l

# 프로세스 열린 파일 개수 조회
sudo ls /proc/$PID/fd/ | wc -l

# 메모리 사용량 조회
free -w
```

## 파일 관련 명령어
```bash
# 파일 다운로드
wget -O README.md https://raw.githubusercontent.com/kdevkr/kdevkr/main/README.md
curl -o README.md https://raw.githubusercontent.com/kdevkr/kdevkr/main/README.md

# 파일 압축 및 해제
tar -zcvf folder.tar.gz folder
tar -zxvf folder.tar.gz

# vi에서 모든 내용 삭제
# shift + g
:0,.d

# 텍스트를 파일로 저장
cat <<EOF | sudo tee /etc/modules-load.d/crio.conf
overlay
br_netfilter
EOF

# sed 명령어로 문자열 치환
sed -i 's/kr.archive.ubuntu.com/mirror.kakao.com/g' /etc/apt/sources.list
sed -i 's/security.ubuntu.com/mirror.kakao.com/g' /etc/apt/sources.list
sed -i 's/extras.ubuntu.com/mirror.kakao.com/g' /etc/apt/sources.list
```


## 네트워크 관련 명령어
```bash
[ec2-user@ip-192-169-37-31 ~]$ ip a
1: lo: <LOOPBACK,UP,LOWER_UP> mtu 65536 qdisc noqueue state UNKNOWN group default qlen 1000
    link/loopback 00:00:00:00:00:00 brd 00:00:00:00:00:00
    inet 127.0.0.1/8 scope host lo
       valid_lft forever preferred_lft forever
    inet6 ::1/128 scope host
       valid_lft forever preferred_lft forever
2: eth0: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 9001 qdisc pfifo_fast state UP group default qlen 1000
    link/ether 0a:74:10:1e:85:ca brd ff:ff:ff:ff:ff:ff
    inet 192.169.37.31/18 brd 192.169.63.255 scope global dynamic eth0
       valid_lft 3553sec preferred_lft 3553sec
    inet6 fe80::874:10ff:fe1e:85ca/64 scope link
       valid_lft forever preferred_lft forever

[ec2-user@ip-192-169-37-31 ~]$ ifconfig
eth0: flags=4163<UP,BROADCAST,RUNNING,MULTICAST>  mtu 9001
        inet 192.169.37.31  netmask 255.255.192.0  broadcast 192.169.63.255
        inet6 fe80::874:10ff:fe1e:85ca  prefixlen 64  scopeid 0x20<link>
        ether 0a:74:10:1e:85:ca  txqueuelen 1000  (Ethernet)
        RX packets 132472429  bytes 176073195795 (163.9 GiB)
        RX errors 0  dropped 0  overruns 0  frame 0
        TX packets 38365172  bytes 16996986892 (15.8 GiB)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0

[ec2-user@ip-192-169-37-31 ~]$ netstat -tnlp
(No info could be read for "-p": geteuid()=1000 but you should be root.)
Active Internet connections (only servers)
Proto Recv-Q Send-Q Local Address           Foreign Address         State       PID/Program name
tcp        0      0 0.0.0.0:9091            0.0.0.0:*               LISTEN      -
tcp        0      0 127.0.0.1:38885         0.0.0.0:*               LISTEN      -
tcp        0      0 0.0.0.0:111             0.0.0.0:*               LISTEN      -
tcp        0      0 0.0.0.0:22              0.0.0.0:*               LISTEN      -
tcp        0      0 127.0.0.1:25            0.0.0.0:*               LISTEN      -
tcp6       0      0 :::111                  :::*                    LISTEN      -
tcp6       0      0 :::22                   :::*                    LISTEN      -

iptables
traceroute
```


## 디스크 볼륨 관련 명령어

```bash
[ec2-user@ip-192-169-37-31 ~]$ df -hT .
Filesystem     Type  Size  Used Avail Use% Mounted on
/dev/xvda1     xfs   8.0G  2.0G  6.1G  25% /

[ec2-user@ip-192-169-37-31 ~]$ lsblk
NAME    MAJ:MIN RM SIZE RO TYPE MOUNTPOINT
xvda    202:0    0   8G  0 disk
└─xvda1 202:1    0   8G  0 part /
```

## 실행 관련 명령어
```bash
# 쉘 스크립트를 실행하고 로그 파일에 출력
[nohup] sh 실행 쉘 스크립트 > 로그 파일 > 2>&1 [&]
```

