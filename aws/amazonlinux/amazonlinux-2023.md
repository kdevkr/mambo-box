## Amazon Linux 2023

```dockerfile
FROM public.ecr.aws/amazonlinux/amazonlinux:2023-minimal
RUN dnf install -y gcc && dnf clean all
CMD ["python", "--version"]
```

- https://github.com/amazonlinux/amazon-linux-2023
- [public.ecr.aws/amazonlinux/amazonlinux:2023-minimal](https://gallery.ecr.aws/amazonlinux/amazonlinux)
- [amazoncorretto:17-al2023](https://hub.docker.com/layers/library/amazoncorretto/17-al2023/images/sha256-a5d093310ce14b0554bb2c2934158165b4fc29fbcee9d1266fd3babd9d29c536?context=explore)
- [Amazon ECS-optimized Linux AMIs](https://github.com/aws/amazon-ecs-ami/releases)

※ Amazon Linux 2는 2025년 6월 30일에 지원 종료 예정
