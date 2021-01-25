import React, {Component, Fragment} from 'react'

import './App.css'
import Test from './components/test'

class App extends Component {
    render() {
        return (
            <Fragment>
                <Test store={this.props.store}/>
            </Fragment>
        )
    }
}

export default App
