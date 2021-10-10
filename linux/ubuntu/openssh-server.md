```sh
sudo apt-get install openssh-server

ssh-keygen -t rsa -m pem
cd .ssh
ssh-keygen -f id_rsa -e -m pem

# then, print pem.

-----BEGIN RSA PUBLIC KEY-----
MIIBigKCAYEAu+91hMU2R/vyUayqpu0FXtO0VVKu2SgXxqztVR1RD1bI28lvAWKy
dnDOtDP5ChbrFkryj1oPIPwhtT0L6LRPcK7yzyqgZe1H1XIbw55L3dD6CXDlbOZP
XfA3vSAABB50gny/ObS3STnbTtkPw9cvZBhwHvfieoBIGoIym3nkjsGReClEEP90
30mzjGAD57vpXzv8T73l8N27wiioBx25wpe8Ku73NS4oGvHeRrt9wYLYHyENQK9y
UwGPtTdyFtaClrWTRqg4oJigrsKqihgNmvjUywj89zfcdEUxxXBecMIqKYG0vlcz
XbWkzHonuAXQ0E+B3iEw2uvmuIG9QpEGHNisDjSMiH1Nq1PKxJl9OwrulFXmFOOQ
yY77bCiwklbvyaq18wmZeFCatcmpIPWviFnW6TXxssuEvfG4BBMj/WWezb42TyY6
DTNp/MHC3S4pYSPzjfC8bN57RYtxeTy40fvi8lCIahDZ3dn22RwCQy77Vsw00QP+
Fpyw5rfdaLO/AgMBAAE=
-----END RSA PUBLIC KEY-----
```
