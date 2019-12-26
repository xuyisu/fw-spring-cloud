 ### Zipkin Server
 
 1. 下载zipkin.jar
 
 ```bash
 curl -sSL https://zipkin.io/quickstart.sh | bash -s
 ```
 
2. 启动zipkin-server

>指明数据库、rabbitMQ启动。如不指明，默认记录在内存里，重启丢记录

```bash
java -jar zipkin.jar --server.port=9411 --zipkin.storage.type=mysql --zipkin.storage.mysql.db=fw_zipkin --zipkin.storage.mysql.username=root --zipkin.storage.mysql.password=123456 --zipkin.storage.mysql.host=localhost --zipkin.storage.mysql.port=3306 --zipkin.collector.rabbitmq.addresses=localhost:5672 --zipkin.collector.rabbitmq.username=fwcloud  --zipkin.collector.rabbitmq.password=fwcloud
```

[**MySQL脚本地址下载**](https://github.com/openzipkin/zipkin/blob/master/zipkin-storage/mysql-v1/src/main/resources/mysql.sql)
 

