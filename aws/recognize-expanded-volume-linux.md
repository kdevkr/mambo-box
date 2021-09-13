실무에서 EC2 인스턴스에서 사용중인 볼륨의 남은 용량이 얼마 남지 않은 상황이 올 수 있다. AWS EBS 볼륨은 인스턴스가 연결되는 도중에도 볼륨 영역을 확장할 수 있다.

- df -hT
- lsblk
- sudo growpart /dev/xvda 1
- sudo resize2fs /dev/xvda1 (ext4)
- sudo xfs_growfs -d /data (xfs)

> https://docs.aws.amazon.com/ko_kr/AWSEC2/latest/UserGuide/recognize-expanded-volume-linux.html