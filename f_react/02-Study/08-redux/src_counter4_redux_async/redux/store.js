import {createStore, applyMiddleware} from 'redux'
import thunk from 'redux-thunk'
import {composeWithDevTools} from 'redux-devtools-extension'

import {counter} from './reducers'


// 生成一个store对象 内部会第一次调用，得到初始化state（init）
const store = createStore(
    counter,
    composeWithDevTools(applyMiddleware(thunk))// 应用异步中间件
)

export default store
