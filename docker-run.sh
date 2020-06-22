#!/usr/bin/env bash
docker run -p 8000:8000 --env-file docker-env.txt --network host products-cached
