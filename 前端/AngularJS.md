# 1.前言

## 1.1AngularJS几大特性

```bash
* MVC
* 模块化
* 双向数据绑定
* 指令系统
```

## 1.2 MVC简介

```
1) MVC组成
		模型(model): 用于存储数据.
		视图(view):  用于展示数据.
		控制器(controller): 用于初始化模型.	
```

## 1.3 引入angularjs库

```javascript
下载 angularjs的库，用js引入，如:
<script src="../0Source/angular-1.2.29/angular.js"></script>
```



# 2.模块与控制器

## 2.1模块

```javascript
//注册模块,通过module函数
//第一个参数是这个模块的名字,第二个参数是这个模块所依赖摩模块,若不依赖，则传空数组
//返回刚刚创建的模块对象
var my = angular.module('myApp',[]);
```

## 2.2控制器

```javascript
var module = angular.module('myModule',[]);

//第一个参数是控制器的名称
//第二个参数是数组,数组中的最后一项是函数，区域前几项都是函数的入参
module.controller('HelloCtrl',['$scope',function(a){
	console.log(a);
}]);
```

## 2.3监视器

```javascript
//回调函数里两个入参，第一个是新值，第二个是旧值
$scope.$watch('user.name',function(now,old){
  console.log('old is : '+old);
  console.log('now is : '+now);
})
```



# 3.指令