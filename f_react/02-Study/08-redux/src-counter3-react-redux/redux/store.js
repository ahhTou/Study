import {createStore} from 'redux'
import {counter} from './reducers'



// 生成一个store对象
const store = createStore(counter) // 内部会第一次调用，得到初始化state（init）

export default store
