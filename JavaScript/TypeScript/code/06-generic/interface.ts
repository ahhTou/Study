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
