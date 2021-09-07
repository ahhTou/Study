import React, {Component} from 'react'
import {Route} from 'react-router-dom'
import MsgDetail from './MsgDetail'
import MyNavLink from '../components/MyNavLink'

class Msg extends Component {

    state = {
        messages: []
    }

    componentDidMount() {
        setTimeout(() => {
            console.log('done')
            const messages = [
                {id: 1, title: 'message001'},
                {id: 3, title: 'message003'},
                {id: 5, title: 'message005'},
            ]
            this.setState({messages})
        }, 1000)
    }
    showDetail = id => {
        this.props.history.push(`/home/msg/msgDetail/${id}`)
    }

    showDetail2 = id => {
        this.props.history.replace(`/home/msg/msgDetail/${id}`)
    }

    back = () => {
        this.props.history.goBack()
    }

    forward = () => {
        this.props.history.goForward()
    }

    render() {
        return (
            <div>
                <ul>
                    {
                        this.state.messages.map((m, i) => (
                            <li key={i}>
                                <MyNavLink to={`/home/msg/msgDetail/${m.id}`}>{m.title}</MyNavLink>
                                <button onClick={() => this.showDetail(m.id)}>Push查看</button>
                                <button onClick={() => this.showDetail2(m.id)}>Replace查看</button>
                            </li>
                        ))
                    }
                </ul>
                <div>
                    <button onClick={this.back}>回退</button>
                    <button onClick={this.forward}>前进</button>
                </div>
                <Route path='/home/msg/msgDetail/:id' component={MsgDetail}/>
            </div>
        )
    }

}

export default Msg
