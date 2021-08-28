
class Dog {

    name:string;
    age:number;

    constructor(name: string, age: number){
        debugger;
        this.name = name;
        this.age = age;
    }

    swim(){
        console.log('狗刨');
    }
}

const dog1 = new Dog('旺财',3);