FROM java:8

VOLUME /tmp

# 拷贝文件到容器
ADD config-server-0.0.1-SNAPSHOT.jar  config-server.jar

RUN bash -c 'touch /eureka-server.jar'

# 开放8888端口
EXPOSE 8888

# 配置容器启动后执行的命令
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/config-server.jar","--spring.profiles.active=default"]
