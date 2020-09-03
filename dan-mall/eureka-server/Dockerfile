FROM java:8

ARG workdir=/app
VOLUME ${workdir}
WORKDIR ${workdir}

# 拷贝文件到容器，也可以直接写成ADD gubo-server-eureka.jar.jar /app/app.jar
ADD eureka-server-0.0.1-SNAPSHOT.jar  /app/eureka-server.jar


# 配置容器启动后执行的命令
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/eureka-server.jar","--spring.profiles.active=default"]

# 开放8761端口
EXPOSE 8761