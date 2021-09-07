import { fs } from './need-node'

function getFileArr(url: string): Promise<any> {
    return new Promise<any>((resolve, reject) => {
        fs.readdir(url, 'utf8', (err: any, data: []) => {
            if (err) {
                console.log('get file arr 出错')
                reject('err')
            } else {
                resolve(data)
            }
        })
    })
}

function writeFile(url: string, content: string): Promise<any> {
    return new Promise<any>((resolve, reject) => {
        fs.writeFile(url, content, (err: any) => {
            if (!err) {
                resolve(true)
            } else {
                resolve(false)
            }
        })
    })
}

export { getFileArr, writeFile }
