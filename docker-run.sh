#!/usr/bin/env bash
docker run -p 8000:8000 products-cached
#to change port to 9001 uncomment this:
#docker run -p 9001:9001 oklimenko/docker-spring --server.port=9001