const {app, BrowserWindow} = require('electron')
let win

function createWindow() {
    win = new BrowserWindow({
        width: 300,
        height: 200,
        frame: false,
        transparent: true,
        maximizable: false,
        // resizable: false,
        webPreferences: {
            nodeIntegration: true,
        },
    })

    win.loadFile('index.html').then(r => {
        console.log(r)
    })
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

const ipcMain = require('electron').ipcMain


//接收最小化命令
ipcMain.on('window-min', function () {
    win.minimize()
})
//接收最大化命令
ipcMain.on('window-max', function () {
    if (win.isMaximized()) {
        win.restore()
    } else {
        win.maximize()
    }
})
//接收关闭命令
ipcMain.on('window-close', function () {
    win.close()
})
