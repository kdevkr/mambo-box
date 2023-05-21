#### 우분투에서 제공하는 국내 리파지토리 미러를 카카오 미러로 변경

```sh
# http://mirror.kakao.com/
sudo cp /etc/apt/sources.list /etc/apt/sources.list.orig
sudo sed -i 's/kr.archive.ubuntu.com/mirror.kakao.com/g' /etc/apt/sources.list
sudo apt-get update -y
```
