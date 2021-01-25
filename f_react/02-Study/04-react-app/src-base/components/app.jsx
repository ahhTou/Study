import React, {Component} from 'react'
import logo from '../logo.svg'

class App extends Component {
    constructor(props) {
        super(props)
        this.state = {}
    }


    render() {
        return (
            <div>
                <img className='logo' src={logo} alt="没有加载成功 "/>
                <p className='title'>React App 组件</p>
            </div>
        )
    }

}

export default App
