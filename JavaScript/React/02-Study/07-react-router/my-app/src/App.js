import React, {Component} from 'react'
import {Switch, Route, Redirect} from 'react-router-dom'

import About from './views/About'
import Home from './views/Home'
import MyNavLink from './components/MyNavLink'

class App extends Component {
    constructor(props) {
        super(props)
        this.state = {}
    }


    render() {
        return (
            <div>
                <div className="row">
                    <div className="col-xs-offset-2 col-xs-8">
                        <div className="page-header">Router</div>
                    </div>
                </div>

                <div className="row">
                    <div className="col-xs-2 col-xs-offset-2">
                        <div className="list-group">
                            <MyNavLink className="list-group-item" to="/about">About</MyNavLink>
                            <MyNavLink className="list-group-item" to="/Home">Home</MyNavLink>
                        </div>
                    </div>
                </div>

                <div className="col-xs-6">
                    <div className="panel">
                        <div className="panel-body">
                            <Switch>
                                {/*根据路由显示*/}
                                <Route path='/about' component={About}/>
                                <Route path='/home' component={Home}/>
                                {/*重定向*/}
                                <Redirect to="/about"/>
                            </Switch>
                        </div>
                    </div>
                </div>
            </div>

        )
    }

}

export default App
