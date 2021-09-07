import React, {Component} from 'react'
import Child from './child'

class Parent extends Component {

    state = {
        hasError: false,
    }

    // 用于 修改错误表示符号
    static getDerivedStateFromError(error) {
        // 更新 state 使下一次渲染能够显示降级后的 UI
        return {hasError: true}
    }

    // 用于捕捉 错误
    componentDidCatch(error, errorInfo) {
        console.log('统计错误，发送给后台')
    }

    render() {
        return (
            <div>
                {this.state.hasError ? <h2>请重试</h2> : <Child/>}
            </div>
        )
    }

}

export default Parent
