import React, {Component, CSSProperties} from 'react';
import MoveLine from "./components/move-line/MoveLine";
import './App.scss'
import {window} from '../package.json'
import doCreate from "./libs/pic-view";

const height = window.height
const width = window.width

interface StateType {
    wrapperStyle: CSSProperties,
}

class App extends Component {
    state: StateType = {
        wrapperStyle: {
            height, width
        }
    }

    create() {

        doCreate(__dirname).then(data => {
            alert(data)
        }).catch(err => {
            alert(err)
        })

    }

    render() {
        return (
            <div className='app-wrapper' style={this.state.wrapperStyle}>
                <MoveLine/>
                <div className='btn-line'>
                    <button onClick={this.create} className='func-btn'>
                        <p className='title1'>为图片生成为HTML</p>
                        <p className='title2'>在当前文件夹创建</p>
                    </button>
                    <button></button>
                </div>
            </div>
        );
    }
}


export default App;
