## Chocolatey

```powershell
PS C:\Users\Mambo> Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))

PS C:\Users\Mambo> choco
Chocolatey v2.4.0
Please run 'choco -?' or 'choco <command> -?' for help menu.

# Upgarde chocolatey
PS C:\Users\Mambo> choco upgrade chocolatey -y

# Upgrades a package or a list of packages
PS C:\Users\Mambo> choco upgrade all -y

# Install AWS Command Line Interface v2
PS C:\Users\Mambo> choco install awscli
```
