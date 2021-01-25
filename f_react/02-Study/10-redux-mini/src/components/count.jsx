import React, {Component} from 'react'
import PropTypes from 'prop-types'

class Count extends Component {

    static propTypes = {
        count: PropTypes.number.isRequired,
        increment: PropTypes.func.isRequired,
        decrement: PropTypes.func.isRequired,
    }

    increment = () => this.props.increment(1)

    decrement = () => this.props.decrement(1)


    render() {
        const {increment, decrement} = this
        const {count} = this.props
        return (
            <>
                <h1>{count}</h1>
                <button onClick={increment}>+</button>
                <button onClick={decrement}>-</button>
            </>
        )
    }
}

export default Count
