(function(){

    class Person{
        public name:string;
        private age:number;

        constructor(name:string,age:number){
            this.name = name;
            this.age = age;
        }

        setAge(age:number){
            this.age = age;
        }

        getAge(){
            debugger;
            return this.age;
        }

        get _name(){
            return this.name;
        }

        set _name(name:string){
            this.name = name;
        }

        
    }

    let p1 = new Person('zhangsan',20);
    p1.name = 'xx';
    p1.setAge(21);
    let c = p1.getAge();

    let a = p1._name;
    p1._name = 'hhh';

    debugger;

})();