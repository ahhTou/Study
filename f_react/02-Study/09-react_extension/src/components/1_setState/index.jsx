import React, {Component} from 'react'

class Demo extends Component {
    state = {
        count: 0
    }

    add = () => {
        /*        const {count} = this.state
                this.setState({
                    // 异步更新
                    count: count + 1
                }, () => {
                    // 在更新后，render()之后调用的回调函数
                    console.log(this.state.count)
                })*/

        // 可以收到 state 和 props
        this.setState((state, props) => {
            return {count: state.count + 1}
        })

        this.setState(state => ({count: state.count + 1}))
    }

    render() {
        return (
            <div>
                <h1>和：{this.state.count}</h1>
                <button onClick={this.add}>点我+1</button>
            </div>
        )
    }
}

export default Demo
