let person: {
    name: string,
    age: number,
    sayHi: () => void,
    sing: (name: string) => void
    sum: (num1: number, num2: number) => number
}

person = {
    name: '123',
    age: 30,
    sayHi: () => console.log('Hi'),
    sing: name => console.log(name),
    sum: (num1, num2) => num1 + num2
}

// 接口
interface User {
    name: string,
    age: number,
}

let aUser: User = {
    name: '123',
    age: 30,
}

// 加密的函数类型接口
interface func {
    (key: string, value: string): string
}

let aFuc: func = (key, val) => {
    return 'aFuc'
}

// 可索引接口
let arr1: number[] = [123, 123]
let arr2: Array<string> = ['123', '321']

// 约束为数组
interface UserArr {
    [index: number]: string
}

let aArr: UserArr = ['123', '321']

// 约束为队形
interface UserObj {
    [index: string]: string
}

let aObj: UserObj = {
    'item': '123'
}

// 类类型接口
interface Animal {
    name: string

    eat(str: string): void
}

class Dog implements Animal {
    name: 'dog'

    eat(str) {
    }
}

// 接口继承, 类继承接口
/*
interface Animal {
}

interface Person extends Animal {
}

class Web implements Person {
}

console.log(aArr[0])
*/

//

// 类型推论
let a = 1
// a = '123' // 警告

let b // 此时类型可以随便修改类型
b = 123
b = '123'


// 类型推论可以保证下面那个作用完全一样
function fun1() {
    return 1 + 2
}

function fun2(): number {
    return 1 + 2
}
