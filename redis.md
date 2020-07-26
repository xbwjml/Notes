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
