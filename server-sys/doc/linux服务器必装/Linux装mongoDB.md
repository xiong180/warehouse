# Centos8安装MongoDB4.4.2

## 1.搜索MongoDB的官网

### https://www.mongodb.com/try/download/community

![image-20201227154857678](Linux装mongoDB.assets/image-20201227154857678.png)

## 2.勾选RedHat/Centos8.0/tgz

### (1)因为linux一般以tar.gz/tar.xz为压缩文件

### (2)点击Download

![image-20201227194244071](Linux装mongoDB.assets/image-20201227194244071.png)

### (3)右键->复制链接

![image-20201227155102291](Linux装mongoDB.assets/image-20201227155102291.png)

## 3.打开Centos服务器

### (1)打开/usr/local，新建mongoDB4.4.2文件夹便于查看

#### mkdir mongoDB4.4.2，cd mongoDB4.4.2

![image-20201227155311347](Linux装mongoDB.assets/image-20201227155311347.png)

### (2)使用wget下载复制的链接

#### wget https://fastdl.mongodb.org/linux/mongodb-linux-x86_64-rhel80-4.4.2.tgz

![image-20201227194947638](Linux装mongoDB.assets/image-20201227194947638.png)

### (3)下载完毕后文件夹结构

![image-20201227194914514](Linux装mongoDB.assets/image-20201227194914514.png)

## 4.解压并安装

### (1)解压

#### tar -zxvf mongodb-linux-x86_64-rhel80-4.4.2.tgz

![image-20201227194801344](Linux装mongoDB.assets/image-20201227194801344.png)

![image-20201227194904867](Linux装mongoDB.assets/image-20201227194904867.png)

### (2)修改名字为mongodb-4.4.2

#### mv mongodb-linux-x86_64-rhel62-4.4.2 mongodb-4.4.2

![image-20201227195042710](Linux装mongoDB.assets/image-20201227195042710.png)

### (2)配置系统环境变量

#### vi /etc/profile

```html
#mongodb环境变量
export PATH=$PATH:/usr/local/mongoDB4.4.2/mongodb-4.4.2/bin
```



![image-20201227163550629](Linux装mongoDB.assets/image-20201227163550629.png)

#### 按`Tab`键在底部输入框输入`:wq`或`:x`回车保存

![image-20201227163531970](Linux装mongoDB.assets/image-20201227163531970.png)

### (3)创建MongoDB数据存放文件夹和日志记录文件夹

#### mkdir -p /data/db

#### mkdir -p /logs

![image-20201227170345251](Linux装mongoDB.assets/image-20201227170345251.png)

#### 进入bin目录下：cd /usr/local/mongoDB4.4.2/mongodb-4.4.2/bin

![image-20201227170536120](Linux装mongoDB.assets/image-20201227170536120.png)

#### 创建mongodb.conf配置文件：vim mongodb.conf

![image-20201227170605376](Linux装mongoDB.assets/image-20201227170605376.png)

```html
dbpath = /data/db #数据文件存放目录
logpath = /logs/mongodb.log #日志文件存放目录
port = 27017 #端口
fork = true #以守护程序的方式启用，即在后台运行
#auth=true #需要认证。如果放开注释，就必须创建MongoDB的账号，使用账号与密码才可远程访问，第一次安装建议注释
bind_ip=0.0.0.0 #允许远程访问，或者直接注释，127.0.0.1是只允许本地访问
```

![image-20201227171121589](Linux装mongoDB.assets/image-20201227171121589.png)

#### 最后“Esc”，输入“:wq”保存退出vim编辑模式即可。

## 5.启动MongoDB

### (1)进入bin目录下，加载配置文件方式启动：

#### 	cd /usr/local/mongoDB4.4.2/mongodb-4.4.2/bin

![image-20201227171359319](Linux装mongoDB.assets/image-20201227171359319.png)

#### ./mongod  -f  mongodb.conf

![image-20201227195418491](Linux装mongoDB.assets/image-20201227195418491.png)

## 6.修改MongoDB密码

### (1)连接mongodb

#### mongo

![image-20201228000617561](Linux装mongoDB.assets/image-20201228000617561.png)

### (2)与管理数据库连接。

#### use admin;

![image-20201228000649319](Linux装mongoDB.assets/image-20201228000649319.png)

#### db.createUser({user:"账号",pwd:"密码",roles:[  {role:"clusterAdmin", db:"admin" } ]});

![image-20201228001355119](Linux装mongoDB.assets/image-20201228001355119.png)

#### 输入：show users;查看是否创建成功

![image-20201228001426244](Linux装mongoDB.assets/image-20201228001426244.png)