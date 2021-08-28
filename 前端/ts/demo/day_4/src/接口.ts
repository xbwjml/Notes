(function(){

    interface interF {
        age:number;
        address:string;
    }
    interface interF {
        hobby:string,
    }

    const obj : interF = {
        age:19,
        address:'中国',
        hobby:'eat',
    }

    class School implements interF{
        age: number;
        address: string;
        hobby: string;

        constructor(age:number, address:string, hobby:string){
            this.age= age;
            this.address= address;
            this.hobby= hobby;
        }

    }

})();