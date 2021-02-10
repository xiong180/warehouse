# Centos8装Nginx1.18.0

## 1.搜索Nginx的官网

### http://nginx.org/en/download.html

![image-20201227112014004](Linux装Nginx1.18.0.assets/image-20201227112014004.png)

## 2.找到nginx.1.18.0[Stable version 稳定版]

### (1)因为linux一般以tar.gz/tar.xz为压缩文件

![image-20201227112213960](Linux装Nginx1.18.0.assets/image-20201227112213960.png)

### (2)右键->复制链接

![image-20201227112232547](Linux装Nginx1.18.0.assets/image-20201227112232547.png)

## 3.打开Centos8服务器

### (1)打开/usr/local，新建nginx1.18.0文件夹便于查看

#### mkdir nginx1.18.0，cd nginx1.18.0

![image-20201227112457432](Linux装Nginx1.18.0.assets/image-20201227112457432.png)

### (2)使用wget下载复制的链接

#### wget http://nginx.org/download/nginx-1.18.0.tar.gz

![image-20201227112533219](Linux装Nginx1.18.0.assets/image-20201227112533219.png)

### (3)下载完毕后文件夹结构

![image-20201227112802914](Linux装Nginx1.18.0.assets/image-20201227112802914.png)

## 4.解压和安装其他依赖

### (1)解压

#### tar -xvf nginx-1.18.0.tar.gz

![image-20201227112852747](Linux装Nginx1.18.0.assets/image-20201227112852747.png)

![image-20201227112910441](Linux装Nginx1.18.0.assets/image-20201227112913159.png)

### (2)使用yum安装其他依赖

#### yum -y install gcc zlib zlib-devel pcre-devel openssl openssl-devel

#### 注意：如果安装过就无需安装

![image-20201227113007308](Linux装Nginx1.18.0.assets/image-20201227113007308.png)

![image-20201227113052592](Linux装Nginx1.18.0.assets/image-20201227113052592.png)

## 5.安装Nginx

### (1)进入nginx安装目录

####  cd nginx-1.18.0/

![image-20201227113253574](Linux装Nginx1.18.0.assets/image-20201227113253574.png)

### (2)执行configure命令

#### ./configure --prefix=/usr/local/nginx --with-http_stub_status_module --with-http_ssl_module --with-http_v2_module --with-http_sub_module --with-http_gzip_static_module --with-pcre

![image-20201227113511122](Linux装Nginx1.18.0.assets/image-20201227113511122.png)

![image-20201227113533728](Linux装Nginx1.18.0.assets/image-20201227113533728.png)

### (3)执行make命令

#### make

![image-20201227113706242](Linux装Nginx1.18.0.assets/image-20201227113706242.png)

![image-20201227113741215](Linux装Nginx1.18.0.assets/image-20201227113741215.png)

### (4)执行make install命令

#### make install

![image-20201227113840747](Linux装Nginx1.18.0.assets/image-20201227113840747.png)

![image-20201227113855921](Linux装Nginx1.18.0.assets/image-20201227113855921.png)

## 6.配置nginx.cnf

### (1)打开配置文件

#### vi /usr/local/nginx1.18.0/nginx-1.18.0/conf/nginx.conf

![image-20201227114106852](Linux装Nginx1.18.0.assets/image-20201227114106852.png)

![image-20201227114132756](Linux装Nginx1.18.0.assets/image-20201227114132756.png)

![image-20201227114319958](Linux装Nginx1.18.0.assets/image-20201227114319958.png)

### (2)修改server进行简单配置，按`i`进入`insert`模式

![image-20201227114809307](Linux装Nginx1.18.0.assets/image-20201227114809307.png)

### (3)编辑完成，按`Tab`键底部出现输入框，输入`:wq`回车保存退出

![image-20201227114903657](Linux装Nginx1.18.0.assets/image-20201227114903657.png)

## 7.测试是否安装配置成功

### (1)接上步走，`重启`nginx

#### /usr/local/nginx1.18.0/nginx-1.18.0/sbin/nginx -s reload

![image-20201227115057406](Linux装Nginx1.18.0.assets/image-20201227115057406.png)

#### 发现会报找不到的错误

![image-20201227115523097](Linux装Nginx1.18.0.assets/image-20201227115523097.png)

#### 这是因为在执行./configure命令时，sbin文件是被直接放到了/usr/local/nginx里面

![image-20201227115614603](Linux装Nginx1.18.0.assets/image-20201227115614603.png)

#### 编辑nginx环境变量

##### **vi /etc/profile**

![image-20201227115739033](Linux装Nginx1.18.0.assets/image-20201227115739033.png)

#### 在末尾添加关于nginx的环境变量

##### **export NGINX_HOME=/usr/local/nginx**

##### **export PATH=$PATH:$NGINX_HOME/sbin**

![image-20201227115853475](Linux装Nginx1.18.0.assets/image-20201227115853475.png)

#### 编辑完成，按`Tab`键底部出现输入框，输入`:wq`回车保存退出

![image-20201227115951058](Linux装Nginx1.18.0.assets/image-20201227115951058.png)

#### 让配置生效，输入以下命令

**source /etc/profile**

![image-20201227120033562](Linux装Nginx1.18.0.assets/image-20201227120033562.png)

### (2)设置nginx为系统服务

#### vi /lib/systemd/system/nginx.service

![image-20201227120225771](Linux装Nginx1.18.0.assets/image-20201227120225771.png)

#### 加入以下命令

```html
[Unit]
Description=nginx service
After=network.target 
[Service] 
Type=forking
ExecStart=/usr/local/nginx/sbin/nginx
ExecReload=/usr/local/nginx/sbin/nginx -s reload 
ExecStop=/usr/local/nginx/sbin/nginx -s quit
PrivateTmp=true 
[Install] 
WantedBy=multi-user.target
```

![image-20201227120504448](Linux装Nginx1.18.0.assets/image-20201227120504448.png)

### (3)设置开机自启动

#### systemctl enable nginx

![image-20201227120611614](Linux装Nginx1.18.0.assets/image-20201227120611614.png)

### (4)重启nginx

#### systemctl restart nginx

![image-20201227120737515](Linux装Nginx1.18.0.assets/image-20201227120737515.png)

### (5)访问域名:80测试

#### 出现Welcom to nginx表示成功

![image-20201227120858341](Linux装Nginx1.18.0.assets/image-20201227120858341.png)

