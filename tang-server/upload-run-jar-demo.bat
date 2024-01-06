@echo off

REM 设置变量
set JAR_FILE=tang-server-0.0.1-SNAPSHOT.jar
set REMOTE_USER=root
set REMOTE_HOST=172.168.1.1
set REMOTE_PASSWORD=askdfkdjfkjd
set REMOTE_PATH=/home/app/tang
set LOCAL_PATH=target\

REM 使用pscp上传文件（你可能需要提供密码或使用SSH密钥）
pscp -pw %REMOTE_PASSWORD% %LOCAL_PATH%%JAR_FILE% %REMOTE_USER%@%REMOTE_HOST%:%REMOTE_PATH%

REM 检查pscp命令的退出状态
if %ERRORLEVEL% neq 0 (
    echo 文件传输失败。
    exit /b %ERRORLEVEL%
)

REM 使用plink运行远程命令（启动JAR文件）
plink -ssh %REMOTE_USER%@%REMOTE_HOST% -pw %REMOTE_PASSWORD% systemctl restart tang.service

msg * "成功！"

echo Done
