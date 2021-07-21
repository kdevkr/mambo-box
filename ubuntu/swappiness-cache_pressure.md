# Swappiness and Cache Pressure

[Linux simple performance tweaks](https://gist.github.com/Nihhaar/ca550c221f3c87459ab383408a9c3928)

Swappiness은 스왑 활용 지표값으로써 0 ~ 100의 값을 가질 수 있으며 기본적으로 우분투는 60을 기본값을 갖는다. 현재 우분투의 메모리 사용량이 여유롭다면 Swappiness을 10으로 설정한다면 우분투 성능을 향상시킬 수 있다.

Cache Pressure는 캐시로 사용된 메모리를 반환하는 지표로써 vfs_cache_pressure는 기본적으로 100이라는 값을 갖는다. 

```sh
# ubuntu default 60
sudo sysctl vm.swappiness=10
# ubuntu default 100
sudo sysctl vm.vfs_cache_pressure=50


sudo vi /etc/sysctl.d/20-swap.conf
vm.swappiness=10
vm.vfs_cache_pressure=50
```

메모리 사용량이 부족하다면 vfs_cache_pressure을 일반적으로 10000으로 설정하여 캐시로 사용된 메모리를 반환하도록 하는 것 같다.

## Drop memory caches
캐시된 메모리는 지워지지않으므로 주기적으로 비워주어야한다?

```sh
crontab -e
0 1 * * * sync && echo 3 > /proc/sys/vm/drop_caches
```