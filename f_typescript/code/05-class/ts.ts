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

class Web extends Person {
    constructor(name: string) {
        super(name); // 初始化父类
    }
}

abstract class Animal {
    abstract eat(): any

    run() {
    }
}

class Dog extends Animal {
    eat(): any {
    }
}

