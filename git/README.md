# Git

## 깃 업데이트

### Windows
```powershell
git update-git-for-windows
Git for Windows 2.32.0.windows.2 (64-bit)
Up to date
```

### MacOS
```zsh
brew update git
```

### Ubuntu
```bash
sudo add-apt-repository ppa:git-core/ppa -y
sudo apt-get update
sudo apt-get install git -y
```

## 특정 사용자의 권한으로 리파지토리 클론하기

```sh
git clone https://<account or token>@github.com/username/repo.git -b branchname --single-branch
```