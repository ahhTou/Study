import React, {Component} from 'react'

class Child extends Component {
    state = {
        users: 'errMsg',
        users2: [
            {id: '001', name: 'tom1', age: 18},
            {id: '002', name: 'tom2', age: 19},
            {id: '003', name: 'tom3', age: 20}
        ]
    }



    render() {
        return (
            <div>
                <h2>我是Child</h2>
                {
                    this.state.users.map(userObj => {
                        return <h4 key={userObj.id}>{userObj.name}+++{userObj.age}</h4>
                    })
                }
            </div>
        )
    }
}

export default Child
