# Centos8装Tomcat9.0.41

## 1.搜索Tomcat的官网

### https://tomcat.apache.org/download-90.cgi

![image-20201227005821216](Linux装Tomcat9.0.41.assets/image-20201227005821216.png)

## 2.找到以tar.gz结尾的列表

### (1)因为linux一般以tar.gz/tar.xz为压缩文件

### (2)右键->复制链接

![image-20201227005846543](Linux装Tomcat9.0.41.assets/image-20201227005846543.png)

## 3.打开Centos8服务器

### (1)打开/usr/local，新建tomcat9.0.41文件夹便于查看

#### mkdir tomcat9.0.41，cd tomcat9.0.41

![image-20201227010340709](Linux装Tomcat9.0.41.assets/image-20201227010340709.png)

### (2)使用wget下载复制的链接

#### wget https://ftp.jaist.ac.jp/pub/apache/tomcat/tomcat-9/v9.0.41/bin/apache-tomcat-9.0.41.tar.gz

![image-20201227010357487](Linux装Tomcat9.0.41.assets/image-20201227010357487.png)

### (3)下载完毕后文件夹结构

![image-20201227010431016](Linux装Tomcat9.0.41.assets/image-20201227010431016.png)

## 4.解压并安装

### (1)解压

#### tar -zxvf apache-tomcat-9.0.41.tar.gz

![image-20201227010605973](Linux装Tomcat9.0.41.assets/image-20201227010605973.png)

![image-20201227010620945](Linux装Tomcat9.0.41.assets/image-20201227010620945.png)

## 5.测试是否安装成功

### (1)进入解压后tomcat9.0.41下的bin目录

![image-20201227010827834](Linux装Tomcat9.0.41.assets/image-20201227010827834.png)

### (2)启动tomcat

#### ./catalina.sh start

![image-20201227010925362](Linux装Tomcat9.0.41.assets/image-20201227010925362.png)

![image-20201227010942165](Linux装Tomcat9.0.41.assets/image-20201227010942165.png)

### (3)访问服务器公网IP:8080查看是否开启tomcat[安全组需开启8080端口]

![image-20201227011315157](Linux装Tomcat9.0.41.assets/image-20201227011315157.png)

### (4)关闭tomcat

#### ./catalina.sh stop

![image-20201227011446925](Linux装Tomcat9.0.41.assets/image-20201227011446925.png)



### ps:注意，这里的tomcat需要先安装JDK，不然会报找不到JAVA类库！！