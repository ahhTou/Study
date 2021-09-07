import React, {Component} from 'react'
import PropTypes from 'prop-types'

const Context = React.createContext({store: {}})

export class Provider extends Component {
    static propTypes = {
        store: PropTypes.object.isRequired
    }
    static contextType = Context

    render() {
        return (
            <Context.Provider value={this.props.store}>
                {this.props.children}
            </Context.Provider>
        )
    }

}

export function connect(mapStateToProps, mapDispatchToProps) {
    return (WrapComponent) => {
        // 返回一个容器组件
        return class ConnectComponent extends Component {

            static contextType = Context

            constructor(props, context) {
                super(props)
                const stateProps = mapStateToProps(context.getState())

                const dispatchProps = this.bindActionCreators(mapDispatchToProps)

                // 将所有的一般属性都保存到state总
                this.state = {...stateProps}
                // 讲所有的函数类型对象保存到组件对象
                this.dispatchProps = dispatchProps

            }

            /*
            根据包含多个action creator的对象, 返回一个包含多个分发action的函数的对象
             */
            bindActionCreators = (mapDispatchToProps) =>
                Object.keys(mapDispatchToProps).reduce((preDispatchProps, key) => {
                    preDispatchProps[key] = (...args) => {
                        this.context.dispatch(mapDispatchToProps[key](...args))
                    }
                    return preDispatchProps
                }, {})

            componentDidMount() {
                const {context} = this
                // 订阅监听
                context.subscribe(() => {
                    this.setState(mapStateToProps(context.getState()))
                })
            }

            render() {
                return <WrapComponent {...this.state} {...this.dispatchProps} />
            }
        }
    }
}



