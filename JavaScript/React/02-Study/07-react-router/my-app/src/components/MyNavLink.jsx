import React, {Component} from 'react'
import {NavLink} from 'react-router-dom'

class MyNavLink extends Component {
    render() {
        return (
            <NavLink {...this.props} activeClassName="activeClass" />
        )
    }

}

export default MyNavLink
