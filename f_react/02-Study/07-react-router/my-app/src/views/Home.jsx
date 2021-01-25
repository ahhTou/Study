import React, {Component} from 'react'
import MyNavLink from '../components/MyNavLink'
import {Switch, Route, Redirect} from 'react-router-dom'
import Msg from './Msg'
import News from './News'

class Home extends Component {
    constructor(props) {
        super(props)
        this.state = {}
    }


    render() {
        return (
            <div>
                <h2>Home</h2>
                <div>
                    <ul className='nac nac-tabs'>
                        <li>
                            <MyNavLink to='/home/news'>News</MyNavLink>
                            <MyNavLink to='/home/msg'>Home</MyNavLink>
                        </li>
                    </ul>

                    <div>
                        <Switch>
                            <Route path='/home/news' component={News}/>
                            <Route path='/home/msg' component={Msg}/>
                            <Redirect to='/home/news'/>
                        </Switch>
                    </div>
                </div>
            </div>
        )
    }

}

export default Home
