import React, {Component} from 'react'

// 用于保存 上下文 对象
const MyContext = React.createContext()

const {Provider, Consumer} = MyContext

class A extends Component {
    state = {
        username: 'tom'
    }

    render() {
        const {username} = this.state
        return (
            <div>
                <h3>我是组件A</h3>
                <h4>我的用户名是: {username}</h4>
                <Provider value={username}>
                    <B/>
                </Provider>
            </div>
        )
    }

}


class B extends Component {
    static contextType = MyContext

    render() {
        return (
            <div>
                <h3>我是组件B</h3>
                <h4>我从A集成的名字是是: {this.context}</h4>
                <C/>
            </div>
        )
    }
}

// class C extends Component {
//     static contextType = MyContext
//
//     render() {
//         return (
//             <div>
//                 <h3>我是组件C</h3>
//                 <h4>我从B集成的名字是是: {this.context}</h4>
//             </div>
//         )
//     }
// }
function C() {
    return (
        <div>
            <h3>我是组件C</h3>
            <h4>
                <Consumer>
                    {
                        value => `我从B集成的名字是是: ${value}`
                    }
                </Consumer>
            </h4>
        </div>
    )
}

export default A
