import {getFileArr, writeFile} from './untils/file-utils'
import {createHtml} from './pojo/html-template'
import {filter} from './untils/img-filter'
import {path} from './untils/need-node'

export default async function doCreate(url: string) {
    try {
        return new Promise<any>(async (resolve, reject) => {
            try {
                let arr: string[] = await getFileArr(url)
                arr = filter(arr).map((l: any) => path.join(url, l))

                const h = createHtml()
                h.insertImgArr(arr)

                const newUrl = path.join(url, '_look_plz.html')
                const content = h.getStr()
                if (await writeFile(newUrl, content)) {
                    resolve('文件创建成功')
                }
            } catch (error) {
                reject('文件创建失败')
            }
        })
    } catch (err_1) {
        console.log('出错')
    }
}
