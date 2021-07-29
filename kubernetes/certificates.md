# Certificates
쿠버네티스 클러스터 접근을 위한 인증서 발행

```sh Terminal
# cfssl 도구 설치
curl -L https://github.com/cloudflare/cfssl/releases/download/v1.6.0/cfssl_1.6.0_linux_amd64 -o cfssl
curl -L https://github.com/cloudflare/cfssl/releases/download/v1.6.0/cfssljson_1.6.0_linux_amd64 -o cfssljson
curl -L https://github.com/cloudflare/cfssl/releases/download/v1.6.0/cfssl-certinfo_1.6.0_linux_amd64 -o cfssl-certinfo

chmod +x cfssl* 
sudo mv cfssl* /usr/bin/

# 인증서 발행 폴더 이동 및 쿠버네티스 클러스터 루트 CA 인증서 복사
mkdir cert && cd cert
sudo cp /etc/kubernetes/pki/ca* ./

# 하위 인증서 발행 정보 정의
cat <<EOF | tee kube-admin-config.json
{
  "signing": {
    "default": {
      "expiry": "8760h"
    },
    "profiles": {
      "kube-admin": {
        "usages": [
          "signing",
          "key encipherment",
          "server auth",
          "client auth"
        ],
        "expiry": "8760h"
      }
    }
  }
}
EOF

# 하위 인증서 서명 요청 정의
cat <<EOF | tee kube-admin-csr.json
{
  "CN": "kube-admin",
  "hosts": [
    "default.svc.cluster.local",
    "svc.cluster.local",
    "cluster.local",
    "127.0.0.1"
  ],
  "key": {
    "algo": "rsa",
    "size": 2048
  },
  "names":[
    {
      "O": "system:masters"
    }
  ]
}
EOF

# 인증서 발행
sudo cfssl gencert -ca=ca.crt -ca-key=ca.key -config=kube-admin-config.json -profile=kube-admin kube-admin-csr.json | cfssljson -bare kube-admin

2021/07/29 11:54:24 [INFO] generate received request
2021/07/29 11:54:24 [INFO] received CSR
2021/07/29 11:54:24 [INFO] generating key: rsa-2048
2021/07/29 11:54:24 [INFO] encoded CSR
2021/07/29 11:54:24 [INFO] signed certificate with serial number 676004569490732548692263081585410013138370915042
```

> **system:masters**는 쿠버네티스 클러스터의 모든 권한을 가지는 사용자 그룹

