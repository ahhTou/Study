interface emptyIpcRender {
    send: (name: string) => void
}

class EmptyIpcRender implements emptyIpcRender {
    send(name: string) {
        if (name === 'window-close') {
            window.close()
        }
    }
}

let ipcRenderer: any
try {
    ipcRenderer = window.require('electron').ipcRenderer
} catch (err) {
    console.log('无法处理 electron 事件')
    ipcRenderer = new EmptyIpcRender()
}


export function exit(): void {
    ipcRenderer.send('window-close')
}

export const apiElectron = {
    exit
}
