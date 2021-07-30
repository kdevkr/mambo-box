# 큐브컨트롤 치트 시트

[kubectl Cheat Sheet](https://kubernetes.io/ko/docs/reference/kubectl/cheatsheet)  

```sh Terminal
# 클러스터 정보 조회
kubectl cluster-info

# 클러스터에서 지원하는 리소스 목록 조회
kubectl api-resources -o wide

# 클러스터에 존재하는 모든 네임스페이스 조회
kubectl get namespaces # kubectl get namespace

# kubectl get nodes
kubectl get no

# kubectl get pods -n kube-system
kubectl get po -n kube-system

# kubectl get pods in all namespaces
kubectl get po -A

# kubectl get service -n kube-system
kubectl get svc -n kube-system

# kubectl get serviceaccount -n kubernetes-dashboard
kubectl get sa -n kubernetes-dashboard

# kubectl get deployment -n kube-system
kubectl get deploy -n kube-system

# kubectl get persistentvolume -A
kubectl get pv -A

# kubectl get persistentvolumeclaim -A
kubectl get pvc -A

kubectl get configmap -A
kubectl get role -A
kubectl get rolebinding -A
kubectl get clusterrole -A
kubectl get clusterrolebinding -A
kubectl get secret -A
kubectl get quota -A
...

# kubectl config view
kubectl config view --minify

# 쿠버네티스 대시보드 서비스어카운트 토큰 조회
kubectl describe secret $(kubectl get secret -n kubernetes-dashboard | grep kubernetes-dashboard-token | awk '{print $1}') -n kubernetes-dashboard

kubectl get secret -n kubernetes-dashboard $(kubectl get sa kubernetes-dashboard -n kubernetes-dashboard -o jsonpath="{.secrets[0].name}") -o jsonpath="{.data.token}" | base64 --decode | awk '{print $1}'

# 쿠버네티스 대시보드 포트 조회
kubectl get service kubernetes-dashboard -n kubernetes-dashboard -o jsonpath="{.spec.ports[0].nodePort}" | awk '{print $1}'
```