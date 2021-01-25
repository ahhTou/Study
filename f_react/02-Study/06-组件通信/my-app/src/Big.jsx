import React, {Component} from 'react'
import PubSub from 'pubsub-js'

class Big extends Component {
    constructor(props) {
        super(props)
        this.state = {}
    }

    toSend = () => {
        PubSub.publish('toLittle', '来自哥哥的信息')
    }


    render() {
        return (
            <div>
                <div>我是大哥</div>
                <button onClick={this.toSend}>发送消息</button>
            </div>
        )
    }

}

export default Big
