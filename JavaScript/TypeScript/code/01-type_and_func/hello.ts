console.log('Hello world')

// 声明变量，指定类型
let age: number
let myName: string = 'ahhTou'
let isBoy: boolean = true
let aNumber: number = +'18'  // 加号可以讲字符串转化为数字
let aString: string = 5 < 3 ? 'BIG' : 'SMALL'

// 任意类型
let any: any = 'hello'

// 泛型
let aNumArr: Array<number> = [1, 2, 3]

// 元组类型
let aTupleArr: [string, number, boolean] = ["ts", 123, true]

for (let i: number = 0; i < 5; i++) {
    console.log(i)
}


// undefined or null
let udf: undefined | null
// udf = '123' // 报错

// void 类型 一般用于规定返回值
function justSay(): void {
    console.log('Hello!')
}

// never 类型 是其他类型的值类型（如 null 和 undefined）, 代表从来不会出现的值
let never: never
// never = undefined // 报错
// never = null   // 报错

/*never = (() => {
    throw  new Error('错误')
})() // 此时可以接受一个抛出异常的自执行函数*/


// 整数
let size: number = 18
// 小数
let score: number = 9.9

// 数组
let names: string[] = ['a', 'b', 'c']
let names2: string[] = new Array('a', 'b', 'c')

// 无参
function sayNoArgs() {
    console.log('hello world')
}

// 有参
function sayWithArgs(sayWhat: string) {
    console.log(sayWhat)
}

// 规定返回类型
function sayAndReturn(sayWhat: string = 'hello world'): boolean {
    console.log(sayWhat)
    return true
}

// 箭头函数
let sayArrowFunc = (sayWhat: string): boolean => {
    return true
}

/*
* 可选参数 函数
* 1. 参数后可以加一个问号表示可选，如 age参数可以传也可以不传
* 2. 可选参数必须放到最后
* */
function getInfo1(name: string, age?: number): string {
    return age ? `${name} ++ ${age}` : `${name} ++ 年龄保密`
}

// 默认参数（默认可选参数） 函数
function getInfo2(name: string, age: number = 20): string {
    return age ? `${name} ++ ${age}` : `${name} ++ 年龄保密`
}


// 剩余参数
function sum(...nums): number {
    return nums.reduce((sum, num) => sum + num)
}

console.log(sum(1, 2, 3, 4))


/*
// 函数重载
function getInfo(name: string): string

function getInfo(age: number): string

function getInfo(str: any): any {
    if (typeof str === 'string') return 'My Name is' + str
    else return 'My Age is ' + str
}

getInfo('hello') // 正确
getInfo(20) // 正确
getInfo(true) // 错误
*/

function getInfo(name: string): string

function getInfo(name: string, age: number): string

function getInfo(name: any, age?: any): any {
    if (age) return 'My Name is' + name + 'My Age is' + age
    else return 'My Age is ' + name
}

getInfo('hello') // 正确
getInfo('hello', 123) //正确
// getInfo(1234) // 报错
