
let aa : string;

let bb: 6666;

/**可以用 ｜ 声明多个类型 */
let cc : number | boolean | string;
cc = 10;
cc = true;
cc = "ccc";

/**
 * any表示任意类型
 * 若声明变量时不规定类型，那么类型就是any
 */
let d:any ;
d = 10;
d = 'hhh';
d = false;

/**
 * 未知
 */
let e:unknown ;
e = 'kkk';
e = 666;

/**
 * any和unkown的区别：
 *  any类型的值可以赋值给已知类型的变量，
 *  而unkown不行。
 */

/**
 * 类型断言，可以用来告诉解析器变量的实际类型.
 * 语法: 
 *  变量 as 类型 ;
 *  <类型>变量 ;
 * 
 */
let s1= e as string;
let s2 = <string> e;

function fn(a) : never {
    throw new Error("报错");
}