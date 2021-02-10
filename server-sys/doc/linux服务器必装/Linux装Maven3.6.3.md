# Centos8装Maven3.6.3

## 1.搜索Maven的官网

### https://maven.apache.org/download.cgi?Preferred=https%3A%2F%2Fftp.jaist.ac.jp%2Fpub%2Fapache%2F

![image-20201226232306156](Linux装Maven3.6.3.assets/image-20201226232306156.png)

## 2.找到以tar.gz结尾的列表

### (1)因为linux一般以tar.gz/tar.xz为压缩文件

### (2)右键->复制链接

![image-20201226232531489](Linux装Maven3.6.3.assets/image-20201226232531489.png)

## 3.打开Centos8服务器

### (1)打开/usr/local，新建maven3.6.3文件夹便于查看

#### mkdir maven3.6.3，cd maven3.6.3

![image-20201226232719654](Linux装Maven3.6.3.assets/image-20201226232719654.png)

### (2)使用wget下载复制的链接

#### wget https://downloads.apache.org/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz

![image-20201226232840970](Linux装Maven3.6.3.assets/image-20201226232840970.png)

### (3)下载完毕后文件夹结构

![image-20201226232929759](Linux装Maven3.6.3.assets/image-20201226232929759.png)

## 4.解压并安装

### (1)解压

#### tar -zxvf apache-maven-3.6.3-bin.tar.gz

![image-20201226233146773](Linux装Maven3.6.3.assets/image-20201226233146773.png)

![image-20201226233209512](Linux装Maven3.6.3.assets/image-20201226233209512.png)

### (2)配置环境变量

#### vim /etc/profile

![image-20201226233344829](Linux装Maven3.6.3.assets/image-20201226233344829.png)

![image-20201226233312652](Linux装Maven3.6.3.assets/image-20201226233312652.png)

#### 在文件最后加上下面代码，按`i`进入`insert`模式

##### export MAVEN_HOME=/usr/local/maven3.6.3/apache-maven-3.6.3  # 这里是自己最终解压后的maven目录

##### export PATH=$MAVEN_HOME/bin:$PATH

![image-20201226233847928](Linux装Maven3.6.3.assets/image-20201226233847928.png)

#### 编辑完成，按`Tab`键底部出现输入框，输入`:wq`回车保存退出

![image-20201226234008448](Linux装Maven3.6.3.assets/image-20201226234008448.png)

### (3)重新加载系统配置文件

#### source /etc/profile

![image-20201226234127830](Linux装Maven3.6.3.assets/image-20201226234127830.png)

![image-20201226234245654](Linux装Maven3.6.3.assets/image-20201226234245654.png)

## 5.测试是否安装成功

### mvn -v

![image-20201227005633139](Linux装Maven3.6.3.assets/image-20201227005633139.png)

### ps:注意，这里的maven需要先安装JDK，不然会报找不到JAVA类库！！