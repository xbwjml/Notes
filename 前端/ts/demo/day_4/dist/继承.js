"use strict";
(function () {
    class Animal {
        constructor(name, age) {
            this.name = name;
            this.age = age;
        }
    }
    class Dog extends Animal {
        say() {
            console.log("旺财");
        }
    }
    class Cat extends Animal {
        constructor(name, age) {
            //子类重写构造方法必须调用父类的构造方法
            super(name, age);
        }
        say() {
            console.log("喵");
        }
    }
})();
