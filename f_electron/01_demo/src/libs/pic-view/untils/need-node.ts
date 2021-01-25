let fs: any
let path: any

interface FakeFsI {
    readdir: (url: string, code: string, callback: Function) => void
    writeFile: (path: string, content: string, callback: Function) => void
}
interface FakePathI {
    join: (str1: string, str2: string) => string
}
class FakeFs implements FakeFsI {
    writeFile(path: string, content: string, callback: Function) {
        console.log(path, content)
        callback('err')
    }
    readdir(url: string, code: string, callback: Function) {
        callback('err', [])
    }
}
class FakePath implements FakePathI {
    join(str1: string, str2: string) {
        return str1 + str2
    }
}
try {
    fs = window.require('fs')
    path = window.require('path')
} catch (error) {
    fs = new FakeFs()
    path = new FakePath()
}

export { fs, path }
