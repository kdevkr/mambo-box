#### 리눅스 사용자 추가
루트 사용자 계정으로 mambo라는 이름의 사용자를 추가하고 비밀번호 설정

```shell
sudo adduser mambo
sudo passwd mambo
Changing password for user mambo.
New password: 
Retype new password: 
passwd: all authentication tokens updated successfully.
```

#### 사용자에게 sudo 권한 부여
```shell
usermod -aG wheel mambo

# sudo visudo
# mambo  ALL=(ALL)       NOPASSWD: ALL
```

#### 사용자 삭제
```shell
sudo userdel -r mambo 
```
