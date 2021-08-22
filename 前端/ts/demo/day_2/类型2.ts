let a : {
    name: string,
    age?: number,
    [propName:string]:any,
} ;

a = {
    name:'章三',
    age:20,
    address:'',
    address2:'',
    address3:'',
};

let d : (a:number,b:number) => number ;
d = function(n1,n2){
    return n1+n2;
}

/**
 * 元组，就是固定长度的数组
 */
let h : [string,string] ;
h = ['111','2222'] ;

/**
 * 枚举
 */
enum gender {
    male = 0,
    felame = 1,
}
let person : {
    name:string,
    gender: gender,
    defaultG: gender.male,
}