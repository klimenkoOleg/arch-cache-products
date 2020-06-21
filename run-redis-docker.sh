#!/usr/bin/env bash
docker pull redis
docker run -p 6379:6379 -d --name redis-cache
   \-v /usr/configs:/usr/redis_config
   \redis redis-server /usr/redis_config/redis.conf

docker run -p 6379:6379 -d --name redis-cache \
    -v $(pwd):/usr/redis_config \
   redis redis-server /usr/redis_config/redis.conf

#docker exec -it redis-cache /bin/bash
#redis-cli