# kubectl

## 클러스터 접근 구성 파일 정의
큐브컨트롤이 클러스터 접근 시 사용할 클러스터 접근 구성 파일이라고 하는 kubeconfig를 정의. 기본적으로 $HOME/.kube 폴더에 위치하거나 KUBECONFIG 환경변수를 참조한다. 접근 구성 파일의 이름은 kubeconfig가 아니며 하나 이상의 파일로 클러스터 또는 컨텍스트를 구분할 수 있다.

접근 구성 파일은 큐브컨트롤의 config 명령어 또는 YAML 파일을 직접 정의할 수 있다.

```sh
kubectl config --kubeconfig=config-demo set-cluster kubernetes --server=https://{{API_SERVER}}:6443 --certificate-authority=ca.crt
kubectl config --kubeconfig=config-demo set-credentials admin --client-certificate=admin.pem --client-key=admin-key.pem
kubectl config --kubeconfig=config-demo set-context kubernetes-master --cluster=kubernetes --user=admin
kubectl config --kubeconfig=config-demo use-context kubernetes-master

kubectl config --kubeconfig=config-demo view --minify
```

### 기본 네임스페이스 변경
큐브컨트롤의 기본 네임스페이스는 default 이므로 네임스페이스 지정이 필요한 명령어를 실행할 때 네임스페이스 옵션을 지정해야한다. 주로 사용하는 네임스페이스가 있다면 기본 네임스페이스로 변경하여 사용하자.

```sh 기본 네임스페이스 변경
kubectl config set-context --current --namespace=kube-system
```

### 큐브컨트롤 별칭 지정
큐브컨트롤을 사용할 때 kubectl을 축약한 별칭을 지정하여 사용하기도 한다.

```sh kubectl 별칭
alias k=kubectl
complete -F __start_kubectl k

k get ns

NAME                   STATUS   AGE
default                Active   3d12h
kube-node-lease        Active   3d12h
kube-public            Active   3d12h
kube-system            Active   3d12h
kubernetes-dashboard   Active   36h
```


## 큐브컨트롤 사용 예시
큐브컨트롤의 여러가지 사용 형태를 보여준다.

### 리소스 및 클러스터 정보 조회

```sh 리소스 및 클러스터 정보 조회
# 클러스터에서 사용가능한 리소스 조회
kubectl api-resources

-- result --
NAME                              SHORTNAMES   APIVERSION                             NAMESPACED   KIND
nodes                             no           v1                                     false        Node
pods                              po           v1                                     true         Pod
secrets                                        v1                                     true         Secret
serviceaccounts                   sa           v1                                     true         ServiceAccount
services                          svc          v1                                     true         Service
daemonsets                        ds           apps/v1                                true         DaemonSet
deployments                       deploy       apps/v1                                true         Deployment
--

# 클러스터 정보 조회
kubectl cluster-info

-- result --
Kubernetes control plane is running at https://192.168.0.5:6443
CoreDNS is running at https://192.168.0.5:6443/api/v1/namespaces/kube-system/services/kube-dns:dns/proxy
--
```

### 노드 및 네임스페이스 조회
```sh 
# kubectl get [nodes|node|no]
kubectl get node

# kubectl get [namespaces|namespace|ns]
kubectl get namespace

# kubectl get [RESOURCE] [-A|--all-namespaces]
kubectl pod -A
```

### 디플로이먼트, 서비스, 파드 조회
```sh
# kubectl get [deployments|deployment|deploy] -n kube-system
kubectl get deploy -n kube-system

# kubectl get [pods|pod|po] -n kube-system
kubectl get po -n kube-system

# kubectl get [services|service|svc] -n kubernetes-dashboard
kubectl get svc -n kubernetes-dashboard

-- result --
NAME                        TYPE        CLUSTER-IP      EXTERNAL-IP   PORT(S)         AGE
dashboard-metrics-scraper   ClusterIP   10.108.18.117   <none>        8000/TCP        36h
kubernetes-dashboard        NodePort    10.100.36.145   <none>        443:30868/TCP   36h
--

# kubectl get [serviceaccount|serviceaccount|sa] -n kubernetes-dashboard
kubectl get sa -n kubernetes-dashboard

-- result --
NAME                   SECRETS   AGE
default                1         36h
kubernetes-dashboard   1         36h
--
```

### 리소스 변경 및 jsonpath 표현식 예시
```sh
# 쿠버네티스 대시보드의 서비스 유형을 NodePort로 변경
kubectl patch svc kubernetes-dashboard -n kubernetes-dashboard -p '{"spec": {"type": "NodePort"}}'

# 쿠버네티스 대시보드 서비스의 포트 조회
kubectl get sv kubernetes-dashboard -n kubernetes-dashboard -o jsonpath="{.spec.ports[0].nodePort}" | awk '{print $1}'

# 쿠버네티스 대시보드 사용자의 토큰 조회
kubectl describe secret $(kubectl get secret -n kubernetes-dashboard | grep kubernetes-dashboard-token | awk '{print $1}') -n kubernetes-dashboard

kubectl get secret -n kubernetes-dashboard $(kubectl get sa kubernetes-dashboard -n kubernetes-dashboard -o jsonpath="{.secrets[0].name}") -o jsonpath="{.data.token}" | base64 --decode | awk '{print $1}'
```