FROM java:8

VOLUME /tmp

# 拷贝文件到容器，也可以直接写成ADD gubo-server-eureka.jar.jar /app/app.jar
ADD eureka-server-0.0.1-SNAPSHOT.jar  eureka-server.jar

RUN bash -c 'touch /eureka-server.jar'

# 开放8761端口
EXPOSE 8761

# 配置容器启动后执行的命令
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eureka-server.jar","--spring.profiles.active=default"]
