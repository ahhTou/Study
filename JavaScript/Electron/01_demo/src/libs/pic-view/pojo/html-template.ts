const template = require('./html.json')

class HtmlTemplate {
    header: string
    footer: string
    body: string[]

    constructor() {
        this.header = template.header
        this.footer = template.footer
        this.body = []
    }

    getStr(): string {
        const body = this.body.reduce((res: string, block) => {
            res += block
            return res
        }, '')
        return this.header + body + this.footer
    }

    insertImg(url: string): void {
        this.body.push(`<div class="img-wrapper flex-center"><img src="${url}" alt="图片加载失败"/></div>`)
        this.body.push('\n')
    }


    insertImgArr(url: string[]): void {
        url.forEach(l => this.insertImg(l))
    }

}


function createHtml() {
    return new HtmlTemplate()
}

export {
    createHtml
}
