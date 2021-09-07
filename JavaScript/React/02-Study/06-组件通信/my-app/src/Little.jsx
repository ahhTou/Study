import React, {Component} from 'react'
import PubSub from 'pubsub-js'

class Little extends Component {
    state = {
        msg: '我还没有收到信息'
    }

    componentDidMount() {
        PubSub.subscribe('toLittle', (msgName, msg) => {
            console.log('事件名称为' + msgName)
            this.setState({msg})
        })
    }

    render() {
        return (
            <div>我是小弟: {this.state.msg}</div>
        )
    }

}

export default Little
