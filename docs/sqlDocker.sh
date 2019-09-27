#!/bin/shd63d2260b15a97e534c
docker run -p 0.0.0.0:3309:3306 --name mysql-project-base -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=eventsdb -d mysql