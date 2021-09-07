import React from 'react'
import ReactDOM from 'react-dom'

import App from './components/App'
import store from './redux/store'


function render(str) {
    console.log(str)
    ReactDOM.render(
        <App store={store}/>,
        document.getElementById('root')
    )
}

render('普通重绘')

// 订阅监听（state中状态变化了，就会调用重绘）
store.subscribe(function () {
    render('redux重绘')
})
