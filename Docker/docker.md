# 1.Docker三要素

```
1.镜像
	Docker镜像(Image)就是一个只读的模板。镜像可以用来创建Docker容器，一个镜像可以创建很多容器。
	
2.容器
	Docker利用容器(Container)独立运行一个或一组应用。容器是用镜像创建的实例。
	它可以被启动，开始，停止，删除。每个容器都是相互隔离的。

3.仓库
	仓库是集中存放镜像文件的场所。
	仓库分为公开仓库和私有仓库。最大的公开仓库是Docker Hub(https://hub.docker.com)
```



# 2.Docker安装

```bash
参照文档 https://docs.docker.com/engine/install/
根据自己的系统选则安装步骤。
以CentOS7.*为例，步骤如下:
1.$ sudo yum remove docker \
                  docker-client \
                  docker-client-latest \
                  docker-common \
                  docker-latest \
                  docker-latest-logrotate \
                  docker-logrotate \
                  docker-engine

2.$ sudo yum install -y yum-utils

3.$ sudo yum-config-manager \
    --add-repo \
    https://download.docker.com/linux/centos/docker-ce.repo
    
4.$ sudo yum install docker-ce docker-ce-cli containerd.io

5.$ yum list docker-ce --showduplicates | sort -r ##查看可选则的docker引擎版本

6.$ sudo yum install docker-ce-<VERSION_STRING> docker-ce-cli-<VERSION_STRING> 			  containerd.io 
## <VERSION_STRING>为上一步中的版本号,例如我选则19.03.9这一版本,那么我的命令为:
## $ sudo yum install docker-ce-19.03.9 docker-ce-cli-19.03.9 containerd.io 
```

```bash
7.安装完成后,启动docker: 
	$ sudo systemctl start docker

8.用hello-world镜像验证: 
	首先要拉取hello-world镜像,国外的docker仓库访问慢,所以最好配置阿里云镜像加速.
	1)登录 https://promotion.aliyun.com/ntms/act/kubernetes.html
	2)点击"镜像搜索"
	3)点击左侧菜单栏"镜像加速器",按照文档进行配置
	运行 docker run hello-world
	如果出现 Hello from Docker!
This message shows that your installation appears to be working correctly.
	就是成功安装了。
```



# 3.Docker命令

## 3.1基础命令

```bash
查看docker版本: docker version
```

```
查看docker详细信息: docker info
```

```
帮助: docker --help
```

## 3.2镜像命令

```
列出本地镜像: docker images
```

![3.2.1](D:\001LeeMJ\code\01MyOwn\Notes\Docker\pic\3.2.1.jpg)

```
其中:
REPOSITORY  --镜像的仓库源;
TAG			--镜像的标签(版本号);
IMAGE ID	--镜像ID;
CREATED		--创建时间;
SIZE		--镜像大小;
```

```
docker images [options]
其中options的选项:
	-a: 列出本地所有镜像(含中间镜像层);
	-q: 只显示本地镜像ID;
	--digests : 显示镜像的摘要信息;
	--no-trunc : 显示完整信息;
```

```
查找镜像: docker search [options] 镜像名称
--filter=条件   			用来筛选 ;
--limit 				 限制条数;
--no-trunc 				 显示详细信息(不截取长字段);
--format "指定格式"		   按指定格式显示搜索结果;
--stars					 显示不少于指定值条结果;

例: 搜索AUTOMATED的的tomcat镜像的完整信息，并且星数不少于10
docker search --filter=stars=10 --filter=is-AUTOMATED=true --no-trunc tomcat

例: 搜索tomcat镜像，只显示5条结果
docker search --limit 5 tomcat

format: 用指定模板格式自定义格式显示搜索结果
其中
镜像名称 :   .Name
镜像描述 :   .Description
星数    :	   .StarCount
officail是ok: .IsOfficial
automated是ok: .IsAutomated
例： docker search --format "{{.Name}} : {{.StarCount}}" nginx
```

```
下载镜像:
docker pull 镜像名称:版本号
若直接docker pull 镜像名称，则默认拉取latest
```

