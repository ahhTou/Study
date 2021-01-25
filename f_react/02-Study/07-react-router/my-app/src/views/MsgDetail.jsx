import React, {Component} from 'react'

const allMessage = [
    {id: 1, title: 'message001', content: '我是信息 1'},
    {id: 3, title: 'message003', content: '我是信息 3'},
    {id: 5, title: 'message005', content: '我是信息 5'},
]

class MsgDetail extends Component {
    state = {}

    render() {
        const {id} = this.props.match.params
        const find = allMessage.find(m => m.id === id * 1)
        return (
            <ul>
                <li>ID: {find.id}</li>
                <li>Title: {find.title}</li>
                <li>Content: {find.content}</li>
            </ul>
        )
    }

}

export default MsgDetail
