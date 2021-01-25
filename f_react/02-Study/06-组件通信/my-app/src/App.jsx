import React, {Component} from 'react'
import Little from './Little'
import Big from './Big'

class App extends Component {
    constructor(props) {
        super(props)
        this.state = {}
    }


    render() {
        return (
            <div>
                <Big/>
                <Little/>
            </div>
        )
    }

}

export default App
