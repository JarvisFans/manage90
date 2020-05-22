# 打包镜像时确保本机docker进程已启动
# 表示基于什么镜像 FROM <仓库/镜像名:版本>
FROM wujiezero/java8:1.1
# MAINTAINER 作者 邮箱
MAINTAINER felix <zhucf3@asiainfo-sec.com>
# 自定义环境变量 ENV 变量名=""
ENV environment=""
ENV params=""
# 镜像名称 版本 作者
LABEL app="zhucf3/manage90" version="0.0.1" by="Felix"
WORKDIR "/data/support/adminserver"
# 添加文件(如是压缩文件则解压)并重命名
ADD manage90*.jar manage90.jar
# 执行命令
ENTRYPOINT ["sh","-c","java $environment -jar manage90.jar $params"]
VOLUME "/data/support/adminserver/log"