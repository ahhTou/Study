/*function logClass(params: any) {
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
console.log(http.apiUrl)*/


// 装饰器工厂 可传参
/*function logClass(params: any) {
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

let http: any = new HttpClient()
console.log(http.apiUrl)*/


/*
function logClass(params: any) {
}

function logProperty(params: any) {
    // target 是这个类， attr 是要装饰属性的名称
    return function (target: any, attr: any) {
        console.log('target is', target)
        console.log('attr is', attr)
        target[attr] = params
    }
}

// @logClass
class HttpClient {

    @logProperty('xxx')
    public apiUrl: string | undefined

    constructor() {
    }

    getData() {
    }

}

let http = new HttpClient()
console.log(http.apiUrl)
*/

/*function logMethod(params: any) {
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
http.getData(123, 321)*/
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

let http = new HttpClient()
http.getData('hello')
