# 选择一个包含Java运行时环境的基础镜像
FROM eclipse-temurin:21.0.1_12-jre-ubi9-minimal

# 将工作目录设置为/app
WORKDIR /app

# 将你的项目构建产物（比如JAR文件）复制到Docker镜像中
COPY /root/.jenkins/workspace/tang/tang-server/target/tang-server-0.0.1-SNAPSHOT.jar /app

# 指定Docker容器启动时要运行的命令
CMD ["java", "-jar", "tang-server-0.0.1-SNAPSHOT.jar"]

# docker build -t tang-service .

# docker run tang-service