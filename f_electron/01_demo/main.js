const {app, BrowserWindow} = require('electron')
const path = require('path')
const url = require('url')
const pkg = require('./package.json') // 引用package.json
const ipcMain = require('electron').ipcMain
let win = null

function createWindow() {
    win = new BrowserWindow({
        width: pkg.window.width,
        height: pkg.window.height,
        frame: false,
        transparent: true,
        maximizable: false,
        // resizable: false,
        webPreferences: {
            nodeIntegration: true,
        },
    })
    if (pkg.DEV) {
        win.loadURL('http://localhost:3000/').then(r => {
            console.log(r)
        })
    } else {
        win.loadURL(url.format({
            pathname: path.join(__dirname, './build/index.html'),
            protocol: 'file:',
            slashes: true
        })).then(r => {
            console.log(r)
        })
    }
}

app.whenReady().then(createWindow)

app.on('window-all-closed', () => {
    if (process.platform !== 'darwin') {
        app.quit()
    }
})

app.on('activate', () => {
    if (BrowserWindow.getAllWindows().length === 0) {
        createWindow()
    }
})


// 接收最小化命令
ipcMain.on('window-min', function () {
    win.minimize()
})
// 接收最大化命令
ipcMain.on('window-max', function () {
    if (win.isMaximized()) {
        win.restore()
    } else {
        win.maximize()
    }
})
// 接收关闭命令
ipcMain.on('window-close', function () {
    win.close()
})
