# Linux常用命令

| 命令                                                         | 说明                       | 备注                                                         |
| ------------------------------------------------------------ | -------------------------- | ------------------------------------------------------------ |
| tar -zcvf xxx.tar.gz [原文件名/目录名]                       | 打包文件到制定目录         |                                                              |
| tar zxvf xxx.tar.gz                                          | 解压缩包                   |                                                              |
| ps -ef\|grep java                                            | 查找Java进程               |                                                              |
| ps aux\|grep java                                            | 查找Java进程               |                                                              |
| cp -r tomcat/. /opt/tomcat/                                  | 复制                       | 将tomcat复制到/opt下的tomcat文件夹                           |
| vim /etc/sysconfig/iptables                                  | 修改防火墙配置             | -A INPUT -m state --state NEW -m tcp -p tcp --dport 8080 -j ACCEPT |
| du -h --max-depth=1                                          | 查看磁盘使用情况           |                                                              |
| uname -a                                                     | 查看系统版本和内核版本     |                                                              |
| scp /data/redis-3.2.7.tar.gz root@192.168.50.149:/data       | 传输文件到另一个服务器上   |                                                              |
| openssl rand -base64 8                                       | 随机生成秘钥               |                                                              |
| sudo sh -c "echo  3 > /proc/sys/vm/drop_caches"              | 清除cached                 |                                                              |
| ls -l /proc/${pid}/cwd                                       | 查找pid对于进程的目录      |                                                              |
| ps -eLf\|grep java -c                                        | 查询Java线程数量           |                                                              |
| ulimit -u                                                    | 查看操作系统允许最大线程数 |                                                              |
| jmap -heap PID                                               | 打印出堆内存相关信息       |                                                              |
| jmap -dump:format=b,file=heap.hprof PID                      | dump内存                   |                                                              |
| git config --global https.proxy http://127.0.0.1:1080 <br />git config --global https.proxy https://127.0.0.1:1080 <br />git config --global http.proxy 'socks5://127.0.0.1:1080' <br />git config --global https.proxy 'socks5://127.0.0.1:1080' | git 设置http代理           |                                                              |
| git config --global --unset http.proxy<br />git config --global --unset https.proxy | git 取消http代理           |                                                              |
| git checkout -b <branch_name> <tag_name>                     | 根据tag号切分支            |                                                              |
|                                                              |                            |                                                              |
|                                                              |                            |                                                              |