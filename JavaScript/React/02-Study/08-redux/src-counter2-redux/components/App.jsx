import React, {Component} from 'react'
import * as actions from '../redux/actions'

class App extends Component {

    state = {
        title: 'click'
    }

    increment = () => {
        const number = this.select.value * 1

        this.props.store.dispatch(actions.increment(number))

    }
    decrement = () => {
        const number = this.select.value * 1

        this.props.store.dispatch(actions.decrement(number))
    }

    incrementIfOdd = () => {
        const number = this.select.value * 1
        const count = this.props.store.getState()

        if (count % 2 === 0) return

        this.props.store.dispatch(actions.increment(number))
    }

    incrementAsync = () => {
        const number = this.select.value * 1

        setTimeout(() => {
            this.props.store.dispatch(actions.increment(number))
        }, 1000)
    }

    change = () => {
        this.setState({
            title: 'CHANGE'
        })
    }

    render() {
        console.log('App 重绘')
        const count = this.props.store.getState()
        return (
            <div>
                <p>{this.state.title} {count} times</p>
                <div>
                    <select ref={select => this.select = select}>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                    </select>&nbsp;
                    <button onClick={this.increment}>+</button>
                    &nbsp;
                    <button onClick={this.decrement}>-</button>
                    &nbsp;
                    <button onClick={this.incrementIfOdd}>increment it odd</button>
                    &nbsp;
                    <button onClick={this.incrementAsync}>increment async</button>
                    &nbsp;
                    <button onClick={this.change}>重绘</button>
                </div>
            </div>
        )
    }

}

export default App
