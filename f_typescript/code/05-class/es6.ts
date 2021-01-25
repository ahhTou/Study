/*// 类
function Person() {
    this.name = 'ahhTou'

    this.run = function () { /!*实例方法*!/
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
p.work()*/


// 继承

// 类
function Person() {
    this.name = 'ahhTou'
    this.run = function () { /*实例方法*/
        console.log(this.name + '在运动')
    }
}

/*
function Web() {
    Person.call(this) // 对象冒充 实现继承， 无法继承原型链内属性方法
}*/

/*function Web() {
}

Web.prototype = new Person()  // 原型链 实现继承。 但是 实例化子类的时候没法给父类传参*/


// 原型链 + 对象冒充
/*function Web() {
    Person.call(this)

}

Web.prototype = new Person()
Web.prototype = Person.prototype*/
