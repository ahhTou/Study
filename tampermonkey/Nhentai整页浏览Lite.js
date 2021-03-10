// ==UserScript==
// @name         Nhentai整页浏览Lite
// @namespace    http://tampermonkey.net/
// @version      0.1
// @description  try to take over the world!
// @author       ahhTou
// @match        https://nhentai.net/*
// @grant        none
// ==/UserScript==
const CSS_STYLE = `


`

const config = {
    origin: 'https://nhentai.net/',
    pathname: 'g/',
    btnClass: 'buttons',
    btnName: '整页浏览',
    thumbsID: 'thumbnail-container',
    thumbsClass: 'thumbs',
    wrapperID: 'ahh-tou-wrapper',
    closeID: 'ahh-tou-close',
    webID: 'content',
    width: '80%',
    imgClass: 'ahh-tou-img',
    openWrapperID: 'ahh-tou-open',
    tipsID: 'ahh-tou-load-tips'
}


function isTarget() {
    const {origin, pathname} = config
    const regStr = origin + pathname + '(\\d)*/$'
    const reg = new RegExp(regStr, 'i')
    const path = location.href
    return reg.test(path)
}

function getBtnDiv() {
    const {btnClass} = config
    return document.getElementsByClassName(btnClass)[0]
}

function addFullPageButton($btnLine) {
    const $button = document.createElement('button')
    const $favorite = $btnLine.firstChild
    const {btnName, openWrapperID} = config
    $button.classList.add(...$favorite.classList)
    $button.innerText = btnName
    $button.id = openWrapperID
    $btnLine.append($button)
}

function addPicView(imgArr = []) {
    const $wrapper = document.createElement('div')
    const {wrapperID, closeID, webID, imgClass, openWrapperID, tipsID} = config
    $wrapper.style.width = '100%'
    $wrapper.style.position = 'absolute'
    $wrapper.style.left = 0
    $wrapper.style.zIndex = '9999999999'
    $wrapper.style.background = 'rgb(31,31,31)'
    $wrapper.style.display = 'none'
    $wrapper.id = wrapperID
    let HTML = `
        <div id="${closeID}" style="    position: fixed; 
                                        top: 55px; right: 10px;
                                        padding: 10px;
                                        min-width: 100px;
                                        display: flex;
                                        color: rgb(237,37,83);
                                        justify-content: center;
                                        align-items: center;
                                        flex-direction: column;
                                        border-radius: 6px;
                                        border: 1px solid rgb(237,37,83);
                                        cursor: pointer;" >
         <div style="font-size:10px;">关闭</div>
         <div id="${tipsID}" style="font-size:5px; color: rgb(230,230,230); ">预载 1 / 0 张</div>
        </div>
       
    `
    imgArr.forEach(img => {
        HTML += `<img class="${imgClass}" 
                        width="1200px" 
                        src="${imgArr[0]}" 
                        data-src="${img}"  
                        alt="加载失败"/>`
    })

    $wrapper.innerHTML = HTML

    document.body.append($wrapper)


    const imgElement = document.getElementsByClassName(imgClass)


    let i = 1
    document.getElementById(openWrapperID).addEventListener('click', () => {
        const $tips = document.getElementById(tipsID)
        const imgLen = imgElement.length
        $tips.innerText = '已预载 ' + i++ + '/' + imgLen + '张图片'
        document.getElementById(wrapperID).style.display = 'unset'
        document.getElementById(webID).style.display = 'none'

        const firstPageHeight = imgElement[0].clientHeight
        document.onscroll = () => {
            imgElement.forEach(l => {
                if (l.getBoundingClientRect().top < firstPageHeight * 10) {
                    if (l.src !== l.dataset.src) {
                        l.src = l.dataset.src
                        $tips.innerText = '已预载 ' + i++ + '/' + imgLen + '张图片'
                    }
                }
            })
        }
    })

    document.getElementById(closeID).addEventListener('click', () => {
        console.log('close')
        document.getElementById(wrapperID).style.display = 'none'
        document.getElementById(webID).style.display = 'unset'

        document.onscroll = null
    })

}

function getThumbs() {
    const {thumbsID, thumbsClass} = config
    const reg = /(.*\/\/)t(.*)t(.jpg)/
    const images = []
    document.getElementById(thumbsID)
        .getElementsByClassName(thumbsClass)[0]
        .getElementsByClassName('lazyload').forEach(e => {
        const imgUrl = e.dataset.src.replace(reg, '$1i$2$3')
        images.push(imgUrl)
    })
    return images
}

(function () {
    if (!isTarget()) return
    addFullPageButton(getBtnDiv())
    addPicView(getThumbs())
})()

