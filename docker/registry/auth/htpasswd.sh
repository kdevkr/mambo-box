#!/bin/sh
docker run --rm ti --entrypoint htpasswd httpd:2-alpine -Bbn {username} {password} >htpasswd
# example
# docker run --rm -ti --entrypoint htpasswd httpd:2-alpine -Bbn mambo mambo >htpasswd
# docker run --rm -ti --entrypoint htpasswd httpd:2-alpine -Bbn mambo mambo | Set-Content -Encoding ASCII htpasswd
