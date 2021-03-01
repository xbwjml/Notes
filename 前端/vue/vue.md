# 1 Vue基础

```
Vue的基础option:
el:
	类型:String
	作用:决定了Vue实例管理哪个DOM
	
data:
	类型:Object | function
	作用:Vue实例对应的数据对象

methods:
	类型:Object
	作用:定义一些方法
```



# 2 Vue的生命周期

```
Vue生命周期如下图所示:
```

![](pic\lifecycle.png)

```
所有的生命周期钩子自动绑定 this 上下文到实例中，因此你可以访问数据，对 property 和方法进行运算。这意味着你不能使用箭头函数来定义一个生命周期方法，这是因为箭头函数绑定了父上下文，因此 this 与你期待的 Vue 实例不同。
```

```
常用生命周期函数:
beforeCreate:
created:
beforeMount:
mounted:
beforeUpdate
updated:
```



# 3 mustache语法

```
mustache语法其实就是双大括号{{}}
略
```



# 4 常用指令

```
v-once:
只渲染元素和组件一次。随后的重新渲染，元素/组件及其所有的子节点将被视为静态内容并跳过。这可以用于优化更新性能

<span v-once>这个将不会改变: {{ msg }}</span>
```

```
v-html:
更新元素的 innerHTML。注意：内容按普通 HTML 插入 - 不会作为 Vue 模板进行编译.
在网站上动态渲染任意 HTML 是非常危险的，因为容易导致 XSS 攻击。只在可信内容上使用 v-html，永不用在用户提交的内容上。

<div v-html="html"></div>
```

```
v-text:

<span v-text="msg"></span>
<!-- 和下面的一样 -->
<span>{{msg}}</span>

若二者同时存在,
<span v-text="msg1">{{msg2}}</span>
则 msg1覆盖msg2
```

```
v-pre:
跳过这个元素和它的子元素的编译过程。可以用来显示原始 Mustache 标签。跳过大量没有指令的节点会加快编译。

<span v-pre>{{ this will not be compiled }}</span>
```

```
v-cloak:
这个指令保持在元素上直到关联实例结束编译。和 CSS 规则如 [v-cloak] { display: none } 一起用时，这个指令可以隐藏未编译的 Mustache 标签直到实例准备完毕。
```



# 5 v-bind

```javascript
不仅仅用来绑定值,还可以用来绑定其他属性,比如style,href等

<div id="app">
    <a  style="margin-top: 20px;" v-bind:href="myUrl">链接</a>
<img v-bind:src="imgUrl" />
    </div>

<script>
    const app = new Vue({
        el : '#app',
        data :{
            myUrl:'http://www.baidu.com',
            imgUrl:'https://cn.vuejs.org/images/lifecycle.png',
        }
    });
</script>
```

```
v-bind: 可以简写成 :
```

```
v-bind:class="{c1:flag1, c2:flag2, c3:flag3}"
由flag的boolean值确定.
```

```
v-bind:style 也是类似
```



# 6 计算属性computed

```
计算属性的结果会被缓存，除非依赖的响应式 property 变化才会重新计算。注意，如果某个依赖 (比如非响应式 property) 在该实例范畴之外，则计算属性是不会被更新的。
```



# 7.v-on

```
绑定事件监听器。事件类型由参数指定。表达式可以是一个方法的名字或一个内联语句，如果没有修饰符也可以省略。

例如:
<div v-on:click="xxx" ></div>

v-on: 可以简写为 @
```

```
v-on还有一些修饰符
.stop, .once, .left 等
```



# 8.v-if,v-show

```
略.
区别:当条件为false时,v-if就没有这个dom,而v-show会有这个dom,只是样式为display:none
```



# 9 v-model

```

```

