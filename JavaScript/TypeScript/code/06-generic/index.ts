/* 泛型函数 */

// 一个函数 ，输入 一个类型，也返回这个类型
function getData<T>(value: T): T {
    return value
}

getData(123)
getData('hello') // 不报错

getData<number>(123)
// getData<number>('hello') // 报错

/* 泛型类 */
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

let a = new MinClassPro<number>()
a.add(1)
a.add(3)
a.add(5)
a.add(0)
a.add(5)
console.log(a.min())
