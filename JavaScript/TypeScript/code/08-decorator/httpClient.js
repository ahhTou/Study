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
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
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
function logMethod(params) {
    return function (target, methodName, desc) {
        // target 原型对象 methodName 方法名字 desc描述
        // 修改装饰器方法
        var oMethod = desc.value;
        desc.value = function () {
            var args = [];
            for (var _i = 0; _i < arguments.length; _i++) {
                args[_i] = arguments[_i];
            }
            args = args.map(function (val) {
                return String(val);
            });
            console.log(args);
        };
    };
}
var HttpClient = /** @class */ (function () {
    function HttpClient() {
    }
    HttpClient.prototype.getData = function () {
        console.log('我是getData');
    };
    __decorate([
        logMethod('xxx')
    ], HttpClient.prototype, "getData");
    return HttpClient;
}());
var http = new HttpClient();
http.getData(123, 321);
