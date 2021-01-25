import React, {Component} from 'react'

class App extends Component {

    state = {
        aFile: ''
    }

    fileUpload = e => {
        console.log('print')
        console.log(e.target.files[0])
    }

    render() {
        const {fileUpload} = this
        return (
            <div className="App">
                <h4>小文件上传</h4>
                <input type='file' onChange={fileUpload}/>
                <button onClick={fileUpload}>上传</button>
            </div>
        )
    }
}


export default App
