#!/bin/sh
mkcert -ecdsa -cert-file client.cert -key-file client.key localhost 127.0.0.1 ::1
