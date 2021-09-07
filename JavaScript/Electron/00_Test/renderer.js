let ipcRenderer = require('electron').ipcRenderer

const close = document.getElementById('close')
if (close) {
    close.addEventListener('click', () => {
        //发送关闭命令
        ipcRenderer.send('window-close')
    })
}
