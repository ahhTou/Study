import React, {Component} from 'react'

class Parent extends Component {
    render() {
        return (
            <div>
                <h3>Parent</h3>
                <A render={name => <B name={name}/>}/>
            </div>
        )
    }
}

class A extends Component {
    state = {name: 'tom'}

    render() {
        const {name} = this.state
        return (
            <div>
                <h3>A</h3>
                {this.props.render(name)}
            </div>
        )
    }
}

class B extends Component {
    render() {
        return (
            <div>
                <h3>B, My Name is {this.props.name}</h3>
            </div>
        )
    }
}


export default Parent
