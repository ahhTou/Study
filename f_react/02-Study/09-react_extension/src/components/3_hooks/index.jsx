import React from 'react'
import ReactDOM from 'react-dom'

class Demo extends React.Component {
    state = {count: 0}

    myRef = React.createRef()

    show = () => {
        console.log(this.myRef.current.value)
    }

    add = () => {
        this.setState(state => ({
            count: state.count + 1
        }))
    }

    unmount = () => {
        ReactDOM.unmountComponentAtNode(document.getElementById('app'))
    }

    componentDidMount() {
        this.timer = setInterval(() => {
            this.setState(state => ({count: state.count + 1}))
        }, 1000)
    }

    componentWillUnmount() {
        clearInterval(this.timer)
    }

    render() {
        return (
            <div>
                <input type={'text'} ref={this.myRef}/>
                <h2>和 -> {this.state.count + 1}</h2>
                <button onClick={this.add}>+1</button>
                <button onClick={this.unmount}>卸载</button>
                <button onClick={this.show}>点我提示</button>
            </div>
        )
    }

}


function Demo2() {

    // 首次调用后不会再执行
    // 第一个参数是State 值， 第二个是改变 值的 方法，每次新值都要重新写
    const [count, setCount] = React.useState(0)
    const [name, setName] = React.useState('tom')

    const myRef = React.useRef()

    function add() {
        // setCount(count + 1) // 写法1
        setCount(count => count + 1) // 写法2
    }

    function unmount() {
        ReactDOM.unmountComponentAtNode(document.getElementById('app'))
    }

    function changeName() {
        // setCount(count + 1) // 写法1
        setName(() => 'jack') // 写法2
    }

    function show() {
        console.log(myRef.current.value)
    }

    React.useEffect(() => {
        // 第二个参数什么都不传 : 任何值改变时调用
        // 第二参数为空数组 : 仅在初始化时调用
        // 第三个参数指定state : 指定的state改变时调用
        // 返回的函数,相当于 componentWillUnmount
        let timer = setInterval(() => {
            setCount(count => count + 1)
        }, 1000)

        return () => {
            clearInterval(timer)
        }
    }, [])

    return (
        <div>
            <input type={'text'} ref={myRef}/>
            <h2>和 -> {count}</h2>
            <h2>名字 -> {name}</h2>
            <button onClick={add}>+1</button>
            <button onClick={changeName}>+1</button>
            <button onClick={unmount}>卸载</button>
            <button onClick={show}>点我提示</button>
        </div>
    )
}


export default Demo2
