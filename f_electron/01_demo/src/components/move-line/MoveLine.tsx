import React, { Component } from 'react'
import './MoveLine.scss'
import { apiElectron } from '../../utils/api_electron'

class MoveLine extends Component {
    exit() {
        apiElectron.exit()
    }

    render() {
        return (
            <div className="move-line-wrapper">
                <div className="drag" />
                <button onClick={this.exit} className="close">
                    EXIT
                </button>
            </div>
        )
    }
}
export default MoveLine
