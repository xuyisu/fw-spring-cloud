FROM openjdk:8u212-jre
MAINTAINER xuyisu 727517292@qq.com

COPY ./target/fw-cloud-docker-1.0-SNAPSHOT.jar /fwcloud/fw-cloud-docker-1.0-SNAPSHOT.jar

ENTRYPOINT ["java", "-Xmx256m", "-jar", "/fwcloud/fw-cloud-docker-1.0-SNAPSHOT.jar"]