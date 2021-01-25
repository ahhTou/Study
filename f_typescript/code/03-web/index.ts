let title = document.getElementById('#title')
title.id // 存在！
// title.src // 不存在！

// 默认是 HTMLElement
let img = document.getElementById('#image') as HTMLImageElement
img.src // 存在！
