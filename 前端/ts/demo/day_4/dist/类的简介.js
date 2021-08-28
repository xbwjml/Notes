"use strict";
class Person {
    constructor() {
        this.name = '孙悟空';
        this.age = 18;
        this.gender = '男';
    }
    fly() {
        console.log('起飞');
    }
}
Person.address = '花果山';
const p1 = new Person();
let p1Name = p1.name;
// let x = Person.age;
// let y = p1.address;
let address = Person.address;
p1.age = 19;
Person.address = '花果山2';
// p1.gender = '女';
