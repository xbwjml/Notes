(function(){

    abstract class Animal{
        name:string;
        age:number;

        constructor(name: string, age: number){
            this.name = name;
            this.age = age;
        }

        abstract say():void;
    }

    class Dog extends Animal{
        say(): void {
            console.log("旺财");
        }
        
    }

    class Cat extends Animal{
        constructor(name: string, age: number){
            //子类重写构造方法必须调用父类的构造方法
            super(name,age);
        }

        say(): void {
            console.log("喵");
        }
    }


    
    
})();