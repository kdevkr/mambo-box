#!/bin/sh

# Download node_exporter from 'https://github.com/prometheus/node_exporter/releases'
VERSION="1.7.0"
ARCH="amd64" # arm64
FILENAME="node_exporter-${VERSION}.linux-${ARCH}"

wget -q --show-progress https://github.com/prometheus/node_exporter/releases/download/v${VERSION}/${FILENAME}.tar.gz
tar -zxvf ${FILENAME}.tar.gz

# Add 'node_exporter' user
if id -u node_exporter > /dev/null 2>&1; then
  echo "\nExist node_exporter user."
else
  echo "\nCreate node_exporter user"
  sudo useradd -rs /bin/false node_exporter
fi

# Install node_exporter
sudo mv ${FILENAME}/node_exporter /usr/local/bin/node_exporter
sudo chown -R node_exporter:node_exporter /usr/local/bin/node_exporter

sudo cat <<EOF > /etc/systemd/system/node_exporter.service
[Unit]
Description=Node Exporter
After=network.target

[Service]
User=node_exporter
Group=node_exporter
ExecStart=/usr/local/bin/node_exporter 

[Install]
WantedBy=default.target
EOF

sudo systemctl daemon-reload
echo "Installed node_exporter."

sudo systemctl start node_exporter.service
sudo systemctl enable node_exporter.service

echo "\nplease check status node_exporter.service using 'sudo systemctl status node_exporter.service'"
