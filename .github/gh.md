# Github CLI

```ps
# gh auth login --with-token < mytoken.txt
> Get-Content .\GH_TOKEN.txt | gh auth login --with-token

❯ gh auth status                                                                               
github.com                                                                                     
  ✓ Logged in to github.com account mambo-EIP (keyring)
  - Active account: true
  - Git operations protocol: https
  - Token: github_pat_11ASSV3QI0lwrsWFjER2bI_***********************************************************

❯ gh auth switch -u mambo-EIP                                                                  
✓ Switched active account for github.com to mambo-EIP
```
