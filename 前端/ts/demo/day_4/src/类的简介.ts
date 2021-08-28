
class Person {

    name:string = '孙悟空';
    age:number = 18;

    static address:string = '花果山';

    readonly gender = '男';

    fly(){
        console.log('起飞');
    }
}

const p1 = new Person();
let p1Name = p1.name;
// let x = Person.age;
// let y = p1.address;
let address = Person.address;

p1.age = 19;
Person.address = '花果山2';
// p1.gender = '女';
