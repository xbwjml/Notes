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

