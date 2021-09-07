import React, {Component} from 'react'
import {cloneWithProps} from '../utils'

class Index extends Component {
    state = {
        list: ['按钮1', '按钮2', '不会被改变的按钮', '按钮4'],
    }

    render() {
        return (
            <Son>
                {this.state.list.map((l, index) => (
                    <button
                        key={index}
                        onClick={() => {
                            console.log('我还没被改变')
                        }}>
                        {l}
                    </button>
                ))}
            </Son>
        )
    }
}

class Son extends Component {

    render() {
        return (
            <div>
                {
                    React.Children.map(this.props.children, ((child, index) =>
                            index === 2 ? child : cloneWithProps(child, {
                                'onClick': () => {
                                    console.log('我被改变了!')
                                }
                            })
                    ))
                }
            </div>
        )
    }
}

export default Index
