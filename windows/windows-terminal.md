## Windows Terminal

- [Install the Windows Terminal from the Microsoft Store.](https://aka.ms/terminal)
- [Windows에 PowerShell 7.5 설치](https://learn.microsoft.com/ko-kr/powershell/scripting/install/installing-powershell-on-windows?view=powershell-7.5)

### $PROFILE

```ps
PS C:\Users\Mambo> New-Item -ItemType File -Path $PROFILE -Force

    Directory: C:\Users\Mambo\Documents\PowerShell

Mode                 LastWriteTime         Length Name
----                 -------------         ------ ----
-a---      2025-09-28 오후 2:18:34              0 Microsoft.PowerShell_profile.ps1

PS C:\Users\Mambo> notepad $PROFILE
```

```ps1
if (Test-Path -Path alias:curl) { Remove-Item alias:curl }

$ChocolateyProfile = "$env:ChocolateyInstall\helpers\chocolateyProfile.psm1"
if (Test-Path($ChocolateyProfile)) {
  Import-Module "$ChocolateyProfile"
}

Import-Module -Name PSReadLine
Import-Module -Name Terminal-Icons
Import-Module -Name Posh-Git
oh-my-posh init pwsh --config "$env:POSH_THEMES_PATH\pure.omp.json" | Invoke-Expression
```

### $PSVersionTable

```ps
❯ $PSVersionTable

Name                           Value
----                           -----
PSVersion                      7.5.3
PSEdition                      Core
GitCommitId                    7.5.3
OS                             Microsoft Windows 10.0.19045
Platform                       Win32NT
PSCompatibleVersions           {1.0, 2.0, 3.0, 4.0…}
PSRemotingProtocolVersion      2.3
SerializationVersion           1.1.0.1
WSManStackVersion              3.0
```

### Install Nerd Fonts

```ps
oh-my-posh font install meslo
```

<img width="1231" height="713" alt="image" src="https://github.com/user-attachments/assets/5b112e1c-0937-4613-984a-0c98b6c836f5" />

