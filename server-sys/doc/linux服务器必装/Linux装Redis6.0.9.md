# Centos8装Redis6.0.9

## 1.搜索Redis的官网

### https://redis.io/download

![image-20201227124549631](Linux装Redis6.0.9.assets/image-20201227124549631.png)

## 2.找到Stable(6.0)[稳定版]

### (1)因为linux一般以tar.gz/tar.xz为压缩文件

![image-20201227124725561](Linux装Redis6.0.9.assets/image-20201227124725561.png)

### (2)右键->复制链接

![image-20201227124708048](Linux装Redis6.0.9.assets/image-20201227124708048.png)

## 3.打开Centos8服务器

### (1)打开/usr/local，新建redis6.0.9文件夹便于查看

#### mkdir redis6.0.9，cd redis6.0.9

![image-20201227124922154](Linux装Redis6.0.9.assets/image-20201227124922154.png)

### (2)使用wget下载复制的链接

#### wget https://download.redis.io/releases/redis-6.0.9.tar.gz?_ga=2.166403582.11592538.1608995554-1176621699.1608995554

![image-20201227125015307](Linux装Redis6.0.9.assets/image-20201227125015307.png)

### (3)下载完毕后文件夹结构

![image-20201227125139470](Linux装Redis6.0.9.assets/image-20201227125139470.png)

## 4.解压并安装

### (1)解压

#### tar -zxvf 'redis-6.0.9.tar.gz?_ga=2.166403582.11592538.1608995554-1176621699.1608995554'

![image-20201227125225748](Linux装Redis6.0.9.assets/image-20201227125225748.png)

![image-20201227125240970](Linux装Redis6.0.9.assets/image-20201227125240970.png)

### (2)检查是否安装GCC

#### gcc --version

#### 注意，gcc版本不宜过低

![image-20201227125343711](Linux装Redis6.0.9.assets/image-20201227125343711.png)

#### 如果没安装的可以执行下面命令

##### **yum -y install gcc**

### (3)安装redis

#### make PREFIX=/usr/local/soft/redis/redis-6.0.9 install

![image-20201227125935129](Linux装Redis6.0.9.assets/image-20201227125935129.png)

![image-20201227130147303](Linux装Redis6.0.9.assets/image-20201227130147303.png)

### (4)进入安装后的redis

#### cd /usr/local/soft/redis/redis-6.0.9

![image-20201227130315815](Linux装Redis6.0.9.assets/image-20201227130315815.png)

### (5)创建conf文件夹作为配置文件夹

#### mkdir conf

![image-20201227130428070](Linux装Redis6.0.9.assets/image-20201227130428070.png)

### (6)把源码目录下的redis.conf复制到安装目录

#### cp /usr/local/redis6.0.9/redis-6.0.9/redis.conf /usr/local/soft/redis/redis-6.0.9/conf/

![image-20201227130647464](Linux装Redis6.0.9.assets/image-20201227130647464.png)

![image-20201227130703093](Linux装Redis6.0.9.assets/image-20201227130703093.png)

### (7)创建redis运行目录

#### mkdir logs data

```html
logs:存放日志
data:存放快照数据
```

![image-20201227130840214](Linux装Redis6.0.9.assets/image-20201227130840214.png)

### (8)修改redis.conf文件

#### vi conf/redis.conf

![image-20201227131057312](Linux装Redis6.0.9.assets/image-20201227131057312.png)

```html
bind 0.0.0.0 /绑定访问的ip,注释 表示所有IP都可链接
daemonize yes //以daemon方式运行
logfile “/usr/local/soft/redis/redis-6.0.9/logs/redis.log” //日志保存目录
dir /usr/local/soft/redis/redis-6.0.9/data //数据保存目录
maxmemory 64MB //使用的最大内存数量
io-threads 1 //#io线程数，看你的服务器是几核的
```

#### 按/搜索对应的，N是下一个

![image-20201227132034312](Linux装Redis6.0.9.assets/image-20201227132034312.png)

#### 将需要修改的都修改完毕后，按`Tab`键底部出现输入框，输入`:wq`回车进行保存

![image-20201227135718587](Linux装Redis6.0.9.assets/image-20201227135718587.png)

### (9)生成供systemd使用的service文件

#### vi /lib/systemd/system/redis.service

![image-20201227135829249](Linux装Redis6.0.9.assets/image-20201227135829249.png)

#### 输入以下代码

```html
[Unit]
Description=Redis
After=network.target

[Service]
Type=forking
PIDFile=/var/run/redis_6379.pid
ExecStart=/usr/local/soft/redis/redis-6.0.9/bin/redis-server /usr/local/soft/redis/redis-6.0.9/conf/redis.conf
ExecReload=/bin/kill -s HUP $MAINPID
ExecStop=/bin/kill -s QUIT $MAINPID
PrivateTmp=true

[Install]
WantedBy=multi-user.target
```

![image-20201227140014462](Linux装Redis6.0.9.assets/image-20201227140014462.png)

#### 按`Tab`键底部出现输入框，输入`:wq`回车进行保存

![image-20201227140036074](Linux装Redis6.0.9.assets/image-20201227140036074.png)

#### 重新加载service文件

##### **systemctl daemon-reload**

![image-20201227140238755](Linux装Redis6.0.9.assets/image-20201227140238755.png)

## 5.测试启动

### (1)启动redis

#### systemctl start redis

![image-20201227144114412](Linux装Redis6.0.9.assets/image-20201227144114412.png)

![image-20201227144223949](Linux装Redis6.0.9.assets/image-20201227144223949.png)

## 6.修改redis密码

### (1)打开redis.cnf配置文件

#### vi /usr/local/soft/redis/redis-6.0.9/conf/redis.conf

![image-20201227144554428](Linux装Redis6.0.9.assets/image-20201227144554428.png)

### (2)搜索requirepass

#### requirepass 你的密码

![image-20201227144713371](Linux装Redis6.0.9.assets/image-20201227144713371.png)

#### 按`Tab`键底部出现输入框，输入`:wq`回车进行保存

![image-20201227144740519](Linux装Redis6.0.9.assets/image-20201227144740519.png)

### (3)重启redis

#### systemctl restart redis

![image-20201227144849506](Linux装Redis6.0.9.assets/image-20201227144849506.png)

## 7.使用redis-cli测试远程连接[服务器安全组需开放6379端口]

### (1)打开redis图形化编辑器，选择连接到Redis服务器

![image-20201227145011202](Linux装Redis6.0.9.assets/image-20201227145011202.png)

### (2)填写相关信息

![image-20201227145159847](Linux装Redis6.0.9.assets/image-20201227145159847.png)

### (3)提示连接成功

![image-20201227145355257](Linux装Redis6.0.9.assets/image-20201227145355257.png)

