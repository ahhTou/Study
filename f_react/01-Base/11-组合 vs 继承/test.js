function Father(props) {
    return (
        <div>
            <div>Father</div>
            <div>
                {props.children}
            </div>
        </div>
    )

}

function Son() {
    return (
        <div>
            <Father>
                我是传入的内容
            </Father>
        </div>
    )

}

function Father2(props) {
    return (
        <div>
            <div>Father</div>
            <div>
                {props.left}
            </div>
            <div>
                {props.children.mid}
            </div>
            <div>
                {props.right}
            </div>
        </div>
    )

}


function Son2() {
    return (
        <div>
            <Father2
                left={(<div>我是左</div>)}
                right={(<div>我是右</div>)}
            >
                {{
                    mid: <div>我是中间</div>
                }}
            </Father2>
        </div>
    )

}

ReactDOM.render(
    <Son2/>,
    document.getElementById('root')
)


