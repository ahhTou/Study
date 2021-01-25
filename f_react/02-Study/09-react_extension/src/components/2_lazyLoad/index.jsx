import React, {Component, lazy, Suspense} from 'react'
import {NavLink, Switch, Route} from 'react-router-dom'
// import About from './About'
// import Home from './Home'

const Home = lazy(() => import('./Home'))

const About = lazy(() => import('./About'))

class Index extends Component {
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
                            <NavLink className="list-group-item" to="/about">About</NavLink>
                            <NavLink className="list-group-item" to="/Home">Home</NavLink>
                        </div>
                    </div>
                </div>

                <div className="col-xs-6">
                    <div className="panel">
                        <div className="panel-body">
                            <Switch>
                                <Suspense fallback={<h1>Loading...</h1>}>
                                    <Route path='/about' component={About}/>
                                    <Route path='/home' component={Home}/>
                                </Suspense>
                                {/*根据路由显示*/}

                                {/*重定向*/}
                                {/*<Redirect to="/about"/>*/}
                            </Switch>
                        </div>
                    </div>
                </div>
            </div>

        )
    }
}

export default Index
