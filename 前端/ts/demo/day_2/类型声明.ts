
/**
 * 声明变量类型:
 *      let arg:类型 ;
 * 声明变量并赋值:
 *      let arg:类型 = value ;
 */
let a:number;
a = 99;
let b:boolean = true;

/**
 * 声明函数入参类型:
 *      在入参后面加 :类型
 * 声明函数返回值类型:
 *      函数圆形括号后面加 :类型
 */
function sum(m:number,n:number): number{
    return  m+n;
}
