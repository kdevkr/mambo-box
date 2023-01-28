if [ "$EUID" -ne 0 ]
  then echo "### Please run script as sudo or root-user"
  exit
fi

# Update dnf packages
echo "### Update dnf packages"
dnf update -y
dnf install -y vim net-tools

# Kernal Settings
SWAPPINESS=0
OVER_MEM=1
MAX_MAP_COUNT=262144
SOMAXCONN=4096

echo -e "\n### Setting kernel options for redis"
sysctl -w vm.swappiness=$SWAPPINESS
sysctl -w vm.overcommit_memory=$OVER_MEM
sysctl -w vm.max_map_count=$MAX_MAP_COUNT
sysctl -w net.core.somaxconn=$SOMAXCONN

echo -e "\nApply kernel options to the /etc/sysctl.conf so that it will also be reflected on restart"
echo "$ echo \"vm.swappiness=$SWAPPINESS\" >> /etc/sysctl.conf"
echo "$ echo \"vm.overcommit_memory=$OVER_MEM\" >> /etc/sysctl.conf"
echo "$ echo \"vm.max_map_count=$MAX_MAP_COUNT\" >> /etc/sysctl.conf"
echo "$ echo \"net.core.somaxconn=$SOMAXCONN\" >> /etc/sysctl.conf"

# Disable THP
echo -e "\n### Disable THP(Transparent Hugepage)"
echo never > /sys/kernel/mm/transparent_hugepage/enabled


echo "Apply disable THP to the /etc/sysctl.conf so that it will also be reflected on restart"
echo "$ \"echo never > /sys/kernel/mm/transparent_hugepage/enabled\" >> /etc/rc.local"

# Open Files & Max User Processes
NOFILE=65535
NPROC=4096

echo -e "\n### Setting open_files($NOFILE) and max_user_processes($NPROC)"
ulimit -n $NOFILE
ulimit -u $NPROC


echo "Apply ulimit to the /etc/security/limits.conf so that it will also be reflected on restart"
echo "$ \"redis soft    nofile  $NOFILE\" >> /etc/security/limits.conf"
echo "$ \"redis hard    nofile  $NOFILE\" >> /etc/security/limits.conf"
echo "$ \"redis soft    nproc   $NPROC\" >> /etc/security/limits.conf"
echo "$ \"redis hard    nproc   $NPROC\" >> /etc/security/limits.conf"

dnf module enable redis:6 -y
dnf install redis -y

echo -e "\n### Completed!"
