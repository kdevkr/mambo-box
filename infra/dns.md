## DNS  

- KT : 168.126.63.1 / 168.126.63.2
- [Cloudflare DNS](https://1.1.1.1/)  
- [Google Public DNS](https://developers.google.com/speed/public-dns/)  

#### DNS 플러시
```shell
# Windows
ipconfig /flushdns

# MacOS
sudo dscacheutil -flushcache; sudo killall -HUP mDNSResponder
```

