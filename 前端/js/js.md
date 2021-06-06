# 1.基本

## 1.1 js编写位置

```javascript
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <!-- 可以将js代码写在script标签里 -->
    <script type="text/javascript" >
        alert("我是script标签中的alert");
    </script>

    <!-- 可以将js代码写在外部js文件中，然后通过script标签引入 -->
    <!-- script标签一旦用于引入外部文件了，就不能再编写代码了，即时编写了，浏览器也会忽略 -->
    <script type="text/javascript" src="./demo1.js"></script>

</head>
<body>

    <!-- 可以将js代码写道onClick属性中 -->
    <button onclick="alert('点我干啥?')" >点我点我</button>
    
    <!-- 可以将js代码写在href属性中 -->
    <a href="javascript:alert('又点我?');">我也是</a>
</body>
</html>
```



## 1.2数据类型

```
JS中共有6种数据类型:
	String			字符串
	Number			数值
	Boolean			布尔值
	Null				空值
	Undefined		为定义
	Object			对象
	
其中：Object是引用数据类型，其他的都是基本数据类型.
	
```

```
String 字符串

```

