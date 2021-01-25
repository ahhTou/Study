import React, {Component} from 'react'
import PropTypes from 'prop-types'
import {decrement, increment} from '../redux/actions'

class Test extends Component {

    state = {
        num: 0
    }

    increment = () => {
        this.props.store.dispatch(increment(1))
    }
    decrement = () => {
        this.props.store.dispatch(decrement(1))
    }

    render() {
        return (
            <div>
                <h1>{this.props.store.getState().count}</h1>
                <button onClick={this.increment}>+</button>
                <button onClick={this.decrement}>-</button>
            </div>
        )
    }
}

Test.propTypes = {
    store: PropTypes.object.isRequired
}
export default Test
