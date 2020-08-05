# 1.开启zk

```
启动zk server
在zk目录/bin, 命令：./zkServer.sh start

如何看zk server 是否已启动？(3种)
1.查看进程: ps -ef|grep zookeeper
2.查看端口: netstat -anp|grep 2181
3.zk自带命令: echo ruok|nc 127.0.0.1 2181
  返回imok就表示已启动。
```

```
使用客户端:
./zkCli.sh
退出客户端：quit
```



# 2.zk例子

```
zookeeper的数据模型的结构与Unix文件系统很类似，整体上可看作是一棵树，每个节点称作一个ZNode,很显然zookeeper集群自身维护了一套数据结构。这个存储结构是一个树形结构，其上的每一个节点，我们称之为"znode",每一个znode默认能存储1MB的数据，每个znode可以通过其路径唯一标识。
```



# 3.znode节点

```
znode维护了一个stat结构，这个stat包含数据变化的版本号，访问控制列表变化，还有时间戳。版本号和时间戳一起，可以让zookeeper验证缓存和协调更新。每次zookeeper的数据发生了，版本号就增加。
```

```bash
[zk: localhost:2181(CONNECTED) 18] get /mytest
javavvvvv333
cZxid = 0x2
ctime = Wed Aug 05 15:50:33 CST 2020
mZxid = 0x6
mtime = Wed Aug 05 15:57:04 CST 2020
pZxid = 0x2
cversion = 0
dataVersion = 1
aclVersion = 0
ephemeralOwner = 0x0
dataLength = 12
numChildren = 0
```

```
总结：znode = path + data + stat
```

```
创建znode节点的4种方式:
1.持久化目录结点；
2.持久化顺序编号目录节点；
3.临时目录节点；
4.临时顺序编号目录节点；
```

