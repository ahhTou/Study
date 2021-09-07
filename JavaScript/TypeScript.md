# 起步

安装解析TS的工具包

```sh
npm i -g typescript
```



转化为js文件后运行

```sh
tsc hello.ts
node hello.js
```



简化过程

```sh
node .\hello.ts
```



监听

> 一旦ts文件改变，编译的js文件也会改变

```sh
tsc -watch xxx.ts
```



# 类型

> JS类型 变量名 : TS类型 [= 初始值]

```typescript
let age: number
let myName: string = 'ahhTou'
let isBoy: boolean = true
let aNumber: number = +'18'  // 加号可以讲字符串转化为数字
let aString: string = 5 < 3 ? 'BIG' : 'SMALL'

// 多类型
let aNumOrUdf: number | undefined

// 任意类型
let any: any = 'hello'

// 数组
let names: string[] = ['a', 'b', 'c']
let names2: string[] = new Array('a', 'b', 'c')

// 泛型数组
let aNumArr: Array<number> = [1, 2, 3]

// 元组类型数组
let aTupleArr: [string, number, boolean] = ["ts", 123, true]

// never 类型
let udf: undefined | null
udf = '123' // 报错

// void 类型 一般用于规定返回值
function justSay(): void {
    console.log('Hello!')
}

// never 类型 是其他类型的值类型（如 null 和 undefined）, 代表从来不会出现的值
let never: never
never = undefined // 报错
never = null   // 报错

never = (() => {
    throw  new Error('错误')
})() // 此时可以接受一个抛出异常的自执行函数
```



# 函数

```ts
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
```

参数可变

```ts
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
```



 函数重载

```ts

function getInfo(name: string): string

function getInfo(age: number): string

function getInfo(str: any): any {
    if (typeof str === 'string') return 'My Name is' + str
    else return 'My Age is ' + str
}

getInfo('hello') // 正确
getInfo(20) // 正确
getInfo(true) // 错误

...

function getInfo(name: string): string

function getInfo(name: string, age: number): string

function getInfo(name: any, age?: any): any {
    if (age) return 'My Name is' + name + 'My Age is' + age
    else return 'My Age is ' + name
}

getInfo('hello') // 正确
getInfo('hello', 123) //正确
getInfo(1234) // 报错

```

# 类

## es6

最简单的类

```ts
function Person() {
    this.name = 'ahhTou'

    this.run = function () {
        console.log(this.name + '在运动')
    }
}
```

构造函数 \ 原型链重添加方法 \静态方法

```ts
// 类
function Person() {
    this.name = 'ahhTou'

    this.run = function () { /*实例方法*/
        console.log(this.name + '在运动')
    }
}

// 通过原型链添加方法（实例）
Person.prototype.work = function () {
    console.log(this.name + '在工作')
}

// 添加静态方法
Person.dance = () => {
    console.log('在跳舞')
}

let p = new Person()
p.run()
p.work()

```

继承

```ts
// 对象冒充 实现继承， 无法继承原型链内属性方法
function Web() {
    Person.call(this) 
}

...

// 原型链 实现继承。 但是 实例化子类的时候没法给父类传参
function Web() {
}
Web.prototype = new Person()  

...

// 原型链 + 对象冒充
function Web() {
    Person.call(this)
}
Web.prototype = new Person() 
...or
Web.prototype = Person.prototype
```

## ts

定义

```js
class Person {
    name: string // 前面省略了 public

    constructor(n: string) { //构造函数实例化类的时候触发的方法
        this.name = n
    }

    run(): void {
        console.log(this.name)
    }
    
    // 静态方法
    static say(): void {
        console.log('hello')
    }
}
```

继承

```ts
class Web extends Person {
    constructor(name: string) {
        super(name); // 初始化父类
    }
}
```

修饰符

public         :        公有   	  在类里面、子类、类外面都可以访问
protected  :		保护 		在类里面、子类里面可以访间，在类外部没法访问
private       :						 私有 在类里面可以访间，子类、类外部都没法访间



抽象

```ts
abstract class Animal {
    abstract eat(): any
    run() {
    }
}

class Dog extends Animal {
    // 方法必须要重写
    eat(): any {
    } 
}
```

# 对象

类型注解

```ts
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

```



# 接口

```ts
// 接口
interface User {
    name: string,
    age: number,
    text?: string, // 可选
}

let aUser: User = {
    name: '123',
    age: 30,
}

// 加密的函数时接口
interface func {
    (key: string, value: string): string
}

let aFuc: func = (key, val) => {
    return 'aFuc'
}


// 可索引接口
let arr1: number[] = [123, 123]
let arr2: Array<string> = ['123', '321']

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
interface Person extends Animal {
}

// 类可以继承类 也可以实现接口
class Web extends Some implements Person {
    ...
}
```



# 类型推论

```ts
// 类型推论
let a = 1
a = '123' // 警告

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
```

# 类型断言

```ts
// 默认断言为 HTMLElement ，所以没有src属性
let title = document.getElementById('#title')
title.id // 存在！
title.src // 不存在，报错！

// 默认是 HTMLElement, 可以手动指定
let img = document.getElementById('#image') as HTMLImageElement
img.src // 存在！
```



# 枚举

```ts
enum Gender {
    Female,
    male,
}

let woman: Gender

let man: Gender

woman = Gender.Female

man = Gender.male

// 默认情况是, 默认指定 0，1，2... ,可以手动指定
enum GenderDefault {
    Female = 0,
    male = 1,
}

// 可以修改为字符串枚举，需要手动指定
enum GenderString {
    Female = 'FEMALE',
    male = 'MALE',
}
```



# 泛型

泛型函数

```ts
// 一个函数 ，输入 一个类型，也返回这个类型
function getData<T>(value: T): T {
    return value
}

getData(123)
getData('hello') // 不报错

getData<number>(123)
getData<number>('hello') // 报错
```



泛型类

```ts
class MinClass {
    public list: number[] = []

    add(num: number) {
        this.list.push(num)
    }

    min(): number {
        return this.list.reduce((total, li) => {
            if (total > li) return li
            else return total
        })
    }
}

class MinClassPro<T> {
    public list: T[] = []

    add(num: T) {
        this.list.push(num)
    }

    min(): T {
        return this.list.reduce((total, li) => {
            if (total > li) return li
            else return total
        })
    }
}
```

实例化

```ts
let a = new MinClassPro()
// 指定初始化类型
let a = new MinClassPro<number>()
```



泛型接口

```ts
interface ConfigFn {
    (val1: string, val2: string): string
}

let setData: ConfigFn = (val1, val2) => {
    return val1 + val2
}


// 1. 使用泛型
interface ConfigFnPro {
    <T>(val1: T, val2: T): T
}

let setDataPro: ConfigFnPro = <T>(val1, val2) => {
    return val1 + val2
}

setDataPro<string>('1', '2')

// 2. 泛型接口
interface ConfigFnProPlus<T> {
    (val1: T, val2: T): T
}

let setDataProPlus: ConfigFnProPlus<string> = (val1, val2) => {
    return val1 + val2
}

setDataProPlus('1', '2')
```



# 命名空间

```ts
namespace A {
    export let a = 123
}

namespace B {
    export let a = 123
}

console.log(A.a)
console.log(B.a)
```

引用

```ts
export namespace A {
    export let a = 123
}

export namespace B {
    export let a = 123
}

console.log(A.a)
console.log(B.a)
```

```ts
import {A} from './name'

console.log(A.a);
```



# 装饰器

配置启动`tsconfig.json`

```json 
{
  "compilerOptions": {
    "experimentalDecorators": true
  }
}
```

## 类装饰器

装饰器

```ts
function logClass(params: any) {
    console.log(params)

    params.prototype.apiUrl = 'xxx'
}

@logClass
class HttpClient {
    constructor() {
    }

    getData() {
    }

}

let http: any = new HttpClient()              
console.log(http.apiUrl)                                         
```



装饰器工程

```ts
// 装饰器工厂 可传参
function logClass(params: any) {
    return function (target) {
        console.log('target is', target)
        console.log('params is', params)
        target.prototype.apiUrl = 'xxx'
    }
}

@logClass('hello')
class HttpClient {
    constructor() {
    }

    getData() {
    }

}
```



重载函数和构造函数

```ts
function logClass(params: any) {
    return class extends params {
        apiUrl: any = '修改后的数据'

        getData() {
        }

    }
}

@logClass
class HttpClient {
    apiUrl: string | undefined

    constructor() {
        this.apiUrl = '修改前的数据'
    }

    getData() {
    }

}
```

## 属性装饰器

```ts
function logProperty(params: any) {
    // target 是这个类， attr 是要装饰属性的名称
    return function (target: any, attr: any) {
        target[attr] = params
    }
}

class HttpClient {
    @logProperty('xxx')
    public apiUrl: string | undefined

}

let http = new HttpClient()
console.log(http.apiUrl)
```



## 方法装饰器

```ts
function logMethod(params: any) {
    return function (target: any, methodName, desc: any) {
        // target 原型对象 methodName 方法名字 desc描述

        // 修改装饰器方法
        let oMethod = desc.value

        // 覆盖方法
        desc.value = function (...args: any[]) {
            args = args.map(val => {
                return String(val)
            })
            console.log(args)
        }

        ...or
        
        // 扩展方法
        desc.value = function (...args: any[]) {
            args = args.map(val => {
                return String(val)
            })
            oMethod.apply(this, args)
            console.log(args)
        }
    }
}

class HttpClient {
    @logMethod('xxx')
    getData(...args: any) {
        console.log(...args)
        console.log('我是getData')
    }

}

let http = new HttpClient()
http.getData(123, 321)
```



## 方法参数装饰器

```ts
function logParams(params: any) {
    return function (target: any, methodParamsName: any, paramsIndex: any) {
        console.log(target)
        console.log(methodParamsName)
        console.log(paramsIndex)
    }
}

class HttpClient {

    getData(@logParams('uuid') args: string) {
        console.log(args)
    }

}
```





## 执行顺序

装饰器执行顺序： 

- 属性装饰器 
- 方法装饰器 
- 方法参数装饰器（右下向上执行。 如 参数装饰器2-参数装饰器1）
- 类装饰器（右下向上执行）