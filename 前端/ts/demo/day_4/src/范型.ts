
function fn<T,R>(a:T,b:R): R{

    return b;
}

let a = fn("1",1);
let b = fn<number,string>(6, '666');