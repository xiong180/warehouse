# CentOS8使用yum装NodeJs并升级

## 1.安装NodeJs

### (1)使用EPEL安装

#### yum info epel-release

#### 查看是否安装了epel-release包，以下情况说明已安装

![image-20201227151234964](Linux装NodeJs.assets/image-20201227151234964.png)

#### 如果没有的话，则输入yum install epel-release进行安装

### (2)使用yum安装NodeJs

#### sudo yum install nodejs

#### 如果需要输入y/N的输入`y`

![image-20201227151408827](Linux装NodeJs.assets/image-20201227151408827.png)

![image-20201227151454124](Linux装NodeJs.assets/image-20201227151454124.png)

### (3)验证是否安装成功

#### node -v

![image-20201227151533687](Linux装NodeJs.assets/image-20201227151533687.png)

### (附加)如果有安装了nodejs但是需要升级看下面操作

![image-20201227151645969](Linux装NodeJs.assets/image-20201227151645969.png)

## 2.升级NodeJs

### (1)安装n

#### npm install -g n

#### n是nodejs管理工具，是TJ写的，Github: https://github.com/tj/n

![image-20201227151758520](Linux装NodeJs.assets/image-20201227151758520.png)

![image-20201227151829711](Linux装NodeJs.assets/image-20201227151829711.png)

### (2)安装NodeJs最新版本

#### n latest 安装最新版本

#### n 8.11.3 安装指定版本 

![image-20201227151938959](Linux装NodeJs.assets/image-20201227151938959.png)

![image-20201227152013750](Linux装NodeJs.assets/image-20201227152013750.png)

### (3)切换NodeJs版本

#### n

![image-20201227152049860](Linux装NodeJs.assets/image-20201227152049860.png)

![image-20201227152101847](Linux装NodeJs.assets/image-20201227152101847.png)

#### 如果只有一个版本的，则直接回车，反之就按`上下`键选择后`回车`

![image-20201227152230932](Linux装NodeJs.assets/image-20201227152230932.png)

#### 再次查看NodeJs的版本

##### **node -v**

![image-20201227152407033](Linux装NodeJs.assets/image-20201227152407033.png)

#### 发现还是原来的版本，怎么办呢？看下面操作

### (4)切换失效的解决办法

#### 查看node当前安装路径

##### **which node**

![image-20201227152538262](Linux装NodeJs.assets/image-20201227152538262.png)

#### n 默认安装路径是 /usr/local，若你的 node 不是在此路径下，n 切换版本就不能把bin、lib、include、share 复制该路径中，所以我们必须通过N_PREFIX变量来修改 n 的默认node安装路径。

#### 编辑环境配置文件

##### **vim ~/.bash_profile**

![image-20201227152802771](Linux装NodeJs.assets/image-20201227152802771.png)

#### 将以下代码放置于末尾

```
export N_PREFIX=/usr/local #node实际安装位置
export PATH=$N_PREFIX/bin:$PATH
```

![image-20201227152920816](Linux装NodeJs.assets/image-20201227152920816.png)

#### 按`Tab`键之后，输入`:x`或`:wq`回车保存退出

![image-20201227153040341](Linux装NodeJs.assets/image-20201227153040341.png)

#### 执行source使修改生效

**source ~/.bash_profile**

![image-20201227153126322](Linux装NodeJs.assets/image-20201227153126322.png)

#### 再次输入node -v查看版本是否更新

##### **node -v**

![image-20201227153212449](Linux装NodeJs.assets/image-20201227153212449.png)