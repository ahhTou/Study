import React, {Component, PureComponent} from 'react'
import './index.css'

class Parent extends PureComponent {
    state = {carName: 'A车', stuArr: ['小张']}

    changeCar = () => {
        // 不更新
        const {stuArr} = this.state
        stuArr.push('小刘')
        this.setState({stuArr})

        // 更新
        this.setState({stuArr: [...stuArr, '小刘']})

    }

    shouldComponentUpdate(nextProps, nextState) {
        return false
    }

    render() {
        console.log('Parent Render')
        const {carName} = this.state
        return (
            <div className="parent">
                <h3>我是Parent组件</h3>
                <span>My Car is {this.state.carName}</span>
                <br/>
                <button onClick={this.changeCar}>Change My Car</button>
                <Child/>
            </div>
        )
    }
}

class Child extends Component {
    render() {
        console.log('Child Render')
        return (
            <div className="child">
                <h3>我是Child组件</h3>
                {/* <div>我收到的车是 {this.props.carName}</div> */}
            </div>
        )
    }
}

export default Parent
