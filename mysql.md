

# 1.MySql语法规范

```
1.不区分大小写，但是表名，列名，关键字，建议大写;
2.每条命令最好以分号结尾;
3.注释： 单行：-- 或 #
		多行： /*   */
```



# 2.基础查询介绍

```

```

```sql
注意 + :
1.如果是两个数值型，则相加：
	select 666+1
	输出： 667
2.如果有字符型，则先将字符型转换为数字型再相加：
	select '666'+1    转换成功，输出667
	select 666+'1'	  转换成功，输出667
	select '666'+'1'  转换成功，输出667
	select 'stu'+'666', 'stu转换失败'，输出666
	select 'stu'+'class' ,都转换失败，输出0
3.null 和 任何相加,结果都是 null	
```

```
concat(value1,value2,...)
拼接用这个，全当成字符串拼接
```



# 3.条件查询

```

```

```
模糊查询 like 也不区分大小写
```

```
如果要模糊查询的关键字种包含 % 或 _ 等关键字,例如查找包含 '%hello' 或者 '_world' 的字段。
可以使用转义符 ：select * from table where columnA like '\_world'
或者使用 escape :select * from table where columnA like '$_world' escape '$'
```

```sql
between a and b
左右都是闭区间
```

```
<=> :
对于两个非null得值比较，和 = 一样。
null <=> 非null ,结果是0
null <=>   null ,结果是1
null  =    null,结果是null

<=> 与 = 唯一得区别是：
null  =  null, 结果是 null
null <=> null, 结果是1
```



# 4.排序

```
可以按别名排序
select
	columnA as nickName
	,columnB
from
	table
order by
	nickName
```



# 5.常见函数

```

```



# 6.分组函数

```

```

```
count(column), null不计入统计
count(*),不会忽略null
count(1) = count('任意字符串') = count(常量值)
```



# 7.分组查询

```

```



# 8.连接查询

```

```

```
光join没有其他关键字，默认是inner join
```



# 9.子查询

```

```



# 11.分页查询

```
limit a,b
a为起始索引，从0开始
b为条数
```



# 12.sql顺序

```
书写顺序：

select
	cloumn ...
from
	[表连接]
on
	[连接条件]
where
	[筛选条件]
gruop by
	[分组字段]
having
	[筛选结果集]
order by
	[排序字段]
limit
	[分页]
```

```
执行顺序：

from
join
on [连接条件]
where [筛选条件]
group by [分组条件]
having [筛选结果集]
select 
order by [排序字段]
limit
```



# 13.联合查询

```
语法：

查询语句1
union
查询语句2
union
查询语句3
...

```

```
注意事项：
1.union前后的列数得一致。
2.union前后的列的类型对应顺序最好一致，如果不一致也不报错。
3.union会去掉重复记录，如果不想去重就使用 union all 。
```



# 14.插入

```
插入方式1：
insert into tableName
(col1, col2, col3, ...)
values
(value1, value2, value3, ...)
```

```
注意：
1.列的个数和值的个数必须一致;
2.可以省略列，那就是默认所有列，并且列的顺序按照表中；
```

```
插入方式2：
insert into tableName
set 
	col1=val1,
	col2=val2,
	...
```

```
两种插入方式区别：
1.方式1可以插入多行，方式二不支持：
	insert into tableName
	 (val11,val12,val13)
	,(val21,val22,val23)
	,(val31,val32,val33)
	...
2.方式1支持子查询，方式二不支持
	insert into tableName
	(col1, col2, col3)
	//后面是子查询
	select a, b, c from ....
```



# 15.修改

```
update
	tableName
set 
	colName1 = newValue1
	,colName2 = newValue2
where 
	...
```



# 16.删除

```
delete from tableName
where 
	...
```

```
整表删除的两种方式：
1.delete from tableName;
2.truncate tableName;

区别：
1.truncate效率更高;
2.如果表中有自增列，整表删除后再insert,truncate之后会从1开始，而delete之后会继续自增;
3.truncate没有返回值，delete有返回值(返回删除了几行);
4.truncate删除不能回滚，delete删除能回滚;
```



# 17.DDL

```
库的管理：

创建库: create database 库名;
删除库: drop   database 库名;

```

```
表的管理：
1.创建表：
	create table 表名(
		 列名1 类型1 [约束]
		,列名2 类型2 [约束]
		...
	);
2.修改列名:
	alter table 表名
	change column
		旧列名 新列名 新数据类型;
3.修改列数据类型：
	alter table 表名
	modify column
	列名 新数据类型;
4.添加新列:
	alter table 表名
	add column
	新列名 数据类型;
5.删除列：
	alter table 表名
	drop column
	列名;
6.修改表名：
	alter table 表名 rename to 新表名;
7.删除表：
	drop table 表名;
8.复制表：
	//只复制表结构，不复制数据
	create table 表名 like 旧表名； 
	
	//复制表结构和部分数据
	create table 表名
	select ... from ... where ...
	
	//仅复制某些字段
	create table 表名
	select 字段1，字段2，..
	from 旧表名
	where 0
	
```



# 18.数据类型

```

```

```
整型:	
```

|     类型     | 字节 |               范围               |
| :----------: | :--: | :------------------------------: |
|   Tinyint    |  1   | 有符号：-128~ 127；无符号：0~255 |
|   SmallInt   |  2   |             以此类推             |
|  Mediumint   |  3   |                                  |
| Int, Integer |  4   |                                  |
|    Bigint    |  8   |                                  |

```

```

```
小数：

浮点型：
	float			4字节
	double			8字节
	
定点型:
	decimal(M,D)	M+2字节

float和double 也可以指定 (M,D)
建表时候,decimal不指定括号里的数，默认就是 decimal(10,0)
```

```

```

```
字符型:

较短的文本：
	char
	varchar

较长的文本:
	text
	
较大的二进制:
	blob
```

|  字符类型  | 最多字符数 |  范围   |
| :--------: | :--------: | :-----: |
|  char(M)   |     M      |  0~255  |
| varchar(M) |     M      | 0~65535 |

```
char和varchar区别：
1.char节省空间
2.varchar效率高
3.char可以省略数字，默认为char(1), 而varchar不能省略数字
```

```
mysql 5.0开始，中英文一样，都占一个字符
```

```

```

```
Enum类型：

```

```
Set类型:

```

```
日期型:
```

|   类型    | 字节 | 最小值 | 最大值 |
| :-------: | :--: | :----: | :----: |
|   date    |  4   |        |        |
| datetime  |  8   |        |        |
| timestamp |  4   |        |        |
|   time    |  3   |        |        |
|   year    |  1   |        |        |



# 19.约束

```
六大约束：
	1.非空约束， nut null
	2.默认值约束: default 默认值
	3.主键约束:	primary key 保证该字段的值唯一性且非空
	4.唯一约束:	unique	保证唯一性，可以为空
	5.检查约束:	check [mysql中不支持]
	6.外键约束:	foreign key
```

```
列级约束：
	六大约束语法上都可以做为列级约束,但外键约束没有效果。
	
表级约束：
	除了非空和默认，其他都支持.
```

```
主键约束 vs 非空约束：
1.主键约束也要求非空
2.主键约束不能有null,非空约束最多有一个null
3.一张表中，主键约束只能有1个，非空约束可以有多个
```

```
外键的特点:
1.在从表上设置外键关系
2.从表的外键列的类型和主表的关联列的类型一致或兼容
3.要求主表中的关联列必须是一个key
```

```
标志列，也称自增长列

注意：
1.标志列必须是一个key
2.1个表中最多只能有1个标志列
3.标志列 只能是数值型
```



# 20.事务

```
一条或一组sql语句组成一个执行单元，这个单元要么全部执行，要么全部不执行。
```

```
事务的ACID属性：

1.原子性(Atomicity)
	原子性是指事务是一个不可分割的工作单位，事务中的操作要么都发生，要么都不发生。
	
2.一致性(Consistency)
	事务必须从一个一致性状态变换到另一个一致性状态.

3.隔离性(Isolation)
	一个事务的执行不能被其他事务干扰，即一个事务内部的操作及使用的数据对并发的其他事务是隔离的，并发执行的各个事务之间不能互相干扰。
	
4.持久性(Durability)
	持久性是指一个事务一旦被提交，它对数据库的改变是永久性的，接下来的其他操作和数据库故障不应该对其有任何影响。
```

```
事务的创建：

1.隐式事务：事务没有明显的开始和结束标记.
	比如 insert, update, delete ,这样的一句sql就是一个事务
2.显示事务:具有明显的开始和结束标记
	前提：必须先设置自动提交禁用
	步骤：
		1.set autocommit = 0;
		2.start transaction;
		3.具体的sql语句;
		4.commit;或rollback;
	
```

```
事务并发问题:
对于同时运行的多个事务，当这些事务访问数据库相同的数据时，如果没有采取必要的隔离机制，就会导致各种并发问题。

-脏读：一个事务读取了另一个事务未提交的数据.

-不可重复读：事务T1读取了一条数据，紧接着T2把这条数据改变了，然后事务T1再次读取这条数据，发现两次读取不一致.

-幻读：事务T1根据查询条件condition1查出 n 条数据，紧接着事务T2插入或删除了符合condition11的几条数据，事务T1再次查询，前后两次查询出来的条数不一致.
```

```
事务隔离级别:

1.读未提交(read uncommitted):允许事务读取违背其他事务提交的变更。脏读，不可重复读，幻读会出现.

2.读已提交(read committed):只允许事务读取已经被其他事务提交的变更。可避免脏读，但不可重复读和幻读会出现。

3.可重复读(repeatable read):在一个事务内，多次读取同一个数据都一致，在这个事务结束之前，其他事务不能对该数据进行修改。避免了脏读和不可重复读，但还是可能会有幻读。

4.串行化(serializable):要求事务只能排队执行，不能并发执行.避免了所有问题，但性能最低.

oracle支持两种：读已提交和串行化，默认是读已提交。
mysql支持4种，默认是可重复读。
```

```
保存点 savepoint
```



# 21.视图

```

```

```
创建视图:
create view as 视图名
as
查询语句
```

```
视图的好处：
1.重用sql语句。
2.简化复杂sql操作。
3.保护数据，提高安全性。
```

```
修改视图:
方式1：
	create or replace view 视图名
	as
	查询语句;
方式2:
	alter view 视图名
	as
	查询语句;
```

```
删除视图：
	drop view 视图名1,视图名2,视图名3...
```

```
查看视图：
	和查看表一样
	desc 视图名;
	或者
	show create view 视图名
```

```
更新视图(增删改):
	对于简单视图更新数据，源表的数据也会更新.
	但一下类型的数据是不能更新的:
	1.视图的定义语句里包含以下关键字: 分组函数,distinct,group by,having, union,union all
	2.常量视图
	3.视图的定义语句里包含子查询
	4.视图的定义语句里包含join
	5.视图的定义语句里where子句的子查询引用了from子句中的表
```

```
视图 vs 表:

```

