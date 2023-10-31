## How to copy ssh public key on windows

- [Windows 10 OpenSSH Equivalent of ssh-copy-id](https://chrisjhart.com/Windows-10-ssh-copy-id/)

```sh
# type publickey | ssh username@host "cat >> .ssh/authorized_keys"
PS C:\Users\Mambo> type $env:USERPROFILE/.ssh/id_rsa.pub | ssh ubuntu@192.168.0.5 "cat >> .ssh/authorized_keys"
```
