# 1.redis数据类型

```
注：
在redis中：一个键最大能存储512M。

string
hash
list
set
zset
```

# 2.redis命令

```
启动redis客户端：
再redis包的src里面：  ./redis-cli
启动客户端后，输入命令： ping
出来：PONG 就对了。
```

```
redis键：
详见：
https://www.runoob.com/redis/redis-keys.html
```



# 3.单线程+多路IO复用

```

```



# 3.字符串(String)

```
set stringName stringValue;
get stringNAme stringValue;

字符串常用命令：
https://www.runoob.com/redis/redis-strings.html
```



# 4.哈希(Hash)

```

```

```
hest hashName ket1 value1
hget hashName key1
hmset hashName key1 value1 key2 value2 ...
hget hashName key1

hash常用命令：
https://www.runoob.com/redis/redis-hashes.html
```



# 5.列表(List)

```
Redis列表是最简单的字符串列表，按照插入顺序排序，可以添加一个元素到列表的头部或尾部，一个列表最多可以包含 2^32 -1 个元素。
底层实际是个双向链表，对两端的操作性能很高，通过索引下标的操作中间节点性能会较差。
```

```
lpush keyName value1 value2 value3 ...      向列表左边添加元素
rpush keyName value1 value2 value3 ...      向列表右边添加元素
lpop  keyName	弹出列表最左边的元素(该元素弹出后会被删除)
rpop  keyName	弹出列表最右边的元素(该元素弹出后会被删除)

lrange keyName startIndex endIndex	按索引下标获得元素(从左到右)
lrange keyName 0 -1					查找列表中的所有元素(从左到右)
lindex keyName index				按索引访问列表中的元素

llen keyName						获得列表长度
```



# 6.集合(Set)

```
相比于list,set是可以自动重排的，数据不重复。
set通过哈希表实现。
最多存储 2^32 -1 个元素。
```

```
sadd keyName value1 value2 value3	向名为keyName的set里添加元素
smembers keyName					列出名为keyName的set里的所有元素
sismember keyName value				判断value是不是名为keyName的set里的元素
scard keyName						返回名为keyName的set里的元素的个数
```



# 7.有序集合(ZSet)

```
Redis 有序集合和集合一样也是string类型元素的集合,且不允许重复的成员。
不同的是每个元素都会关联一个double类型的分数。redis正是通过分数来为集合中的成员进行从小到大的排序。
有序集合的成员是唯一的,但分数(score)却可以重复。
```

```
zadd key score1 e1 score2 e2 ...
zrange key startScore endScore

添加相同得元素with不同的分数，会将分数更新；
添加相同分数的元素，可以添加成功，分数重读而已；
```



# 8.实现文章访问量排序

```

```



# 9.redis配置文件

```

```



# 10.Jedis

```

```



# 11.redis事务

```
redis事务是一个单独的隔离操作：事务中的所有命令都会被序列化，按顺序地执行。事务在执行过程中，不会被其他客户端发送来的命令请求所打断。
```

```
redis事务的主要作用就是串联多个命令防止别的命令插队。
```

```
输入multi开始事务；
逐条输入命令加入队列缓存；
输入exec执行队列中的所有操作；
```

```
redis事务三特性：
1.单独的隔离操作：
	事务中的所有命令都会序列化，按顺序地执行。事务在执行的过程中，不会被其他客户端发送来的请求所打断；
2.没有隔离级别的概念：
	队列中的命令没有提交之前都不会实际地执行，因为事务提交前任何指令都不会实际执行，也就不存在传统数据库中事务隔离地问题；
3.不保证原子性：
	同一个事务中如果有一条命令执行失败，则在其后面地命令仍旧会执行。
	注意：如果命令队列中有一条命令语法错误了，则整个事务中的所有命令都不会执行。
```

```java
jedis中使用事务：
		Transaction transaction = jedis.multi();
		transaction.sadd("", "");
		List<Object> list = transaction.exec();
```

```
多线程修改值(多个client连接redis-server操作),使用watch可当作redis的乐观锁操作。
watch keyName;
multi;
...
exec;

若一个线程开启事务之前watch了一个key.在开启事务的过程中，其他线程对这个key进行了修改，则事务执行失败；

解锁是 unwatch;
```



# 12.redis持久化

```
redis是内存数据库，一旦程序退出或服务器断电，则数据也会消失。所以redis提供了持久化功能。
```

```
RDB(Redis Database):
在指定的时间间隔内将内存中的数据集快照写入磁盘，它恢复时是将快照文件直接读到内存里。

Redis会单独创建(fork)一个子进程来进行持久化，会先将数据写入到一个临时文件中，待持久化过程都结束了，再用这个临时文件替换上一次持久化好的文件。整个过程中，主进程是不进行任何IO操作的。这就确保了极高的性能，如果需要进行大规模数据的恢复，且对于数据的完整性不是很敏感，那么RDB相对于AOF的方式更加高效。RDB的缺点是最后一次持久化后的数据可能丢失。
默认就是RDB。
rdb保存的文件是 dump.rdb ;
配置文件中是：save num1 num2,表示在num1秒内修改了num2次数据，就会触发rdb操作。

触发机制：
1.save的规则满足的情况下，自动触发；
2.执行flushall,也会触发;
3.关闭redis程序，也会触发;

备份就会自动生成一个 dump.rdb;

如何恢复rdb文件？
1.只需要将rdb文件放到redis的启动目录就可以，redis启动的时候会检查 dump.rdb，恢复其中的数据;

rdb优点：
1.适合大规模数据恢复。
2.对数据完整性要求不高的话可以用rdb。

rdb缺点：
1.需要一定的时间间隔。如果redis以外宕机了，最后一次修改的数据就没了。
2.fork进程的时候，会占用一定的内存，
```

```
AOF(Append Only File):
将我们的所有命令都记录下来，恢复的时候将这个文件全部执行一遍。
以日志的形式来记录每个写操作，将redis的所有写的指令记录下来(读操作不记录)，只许追加文件但不允许改文件，redis启动之初会读取该文件重新构建数据，换言之，redis重启会根据日志文件从头到底执行一遍来恢复数据。

aof保存的是appendonly.aof文件;
配置文件中默认是 : appendonly no ,要使用aof的话得改成 yes.

aof记录配置：
appendfsync always   每次修改都会记录sync，消耗性能；
appendfsync everysec 每秒执行一次sync，可能会丢失宕机前最后1秒的数据；
appendfsync no       不执行sync,这个时候操作系统自己同步数据，速度最快；

如果aof文件有错误或损坏，这时候redis是无法启动的，我们需要修复aof文件。redis给我们提供了 redis-check-aof。执行 redis-check-aof --fix  appendonly.aof 即可。

aof优点：
1.若每次修改都同步，则文件完整性更好；
2.若每秒同步一次，可能会丢失最后一秒的数据；
3.若从不同步，则效率最高；

aof缺点：
1.aof文件的大小远远大于 rdb文件，修复速度也比rdb慢;
2.aof运行效率比rdb慢;
3.
```

# 13.redis发布订阅

```

```

# 14.redis主从复制

```
概念：
主从复制，是指将一台redis服务器的数据，复制到其他redis服务器，前者称为主节点，后者称为从结点。数据的复制是单向的，只能从主节点到从结点。Master以写为主，slave以读为主。
默认情况下，每台redis服务器都是主节点；且一个主结点可以有多个从结点，但一个从结点只能有一个主节点。
```

```
主从复制的作用主要包括：
1.数据冗余：主从节点实现类数据的热备份，是持久化之外的一种数据冗余方式；
2.故障恢复：当主节点出现问题时，可以由从结点提供服务，实现快速故障恢复；
3.负载均衡：在主从复制的基础上，配合读写分离，可以由主节点提供写服务，由从结点提供读服务。尤其是在读多写少的情况下，通过多个读结点分担读负载；
4.高可用基石：除了上述作用外，主从复制还是哨兵和集群能够实施的基础，因此说主从复制是redis高可用的基础；
```

```
环境配置：
```

```bash
127.0.0.1:6379> info replication #查看当前库信息
# Replication
role:master	#角色
connected_slaves:0 #从机数量
master_repl_offset:0
repl_backlog_active:0
repl_backlog_size:1048576
repl_backlog_first_byte_offset:0
repl_backlog_histlen:0
```

```
主机可读写，从机只能读不能写。
```

```
主从复制原理：
slave启动成功连接到master后，回发送一个sync同步命令。
master接收到命令，启动后台的存盘进程，同时收集所有接收到的用于修改数据集指令，在后台进程执行完毕后，master将传送整个数据文件到slave,并完成一次同步。
只要是slave重新连接到master，就自动执行全量复制。
```

# 15.redis层层链路

```
相邻的结点，前一个是master,后一个是slave。
这时只有第一个master才能写，其余结点都不能写。

如果第一个master挂掉了，能不能选一个新的老大出来？
答：那只能手动执行slaveof no one 来使自己变成老大。

```

# 16.redis哨兵模式

```

```

