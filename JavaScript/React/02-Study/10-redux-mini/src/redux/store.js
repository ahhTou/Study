import {createStore} from '../libs/redux'
import reducers from './reducers' // 包含多个 reduce

export default createStore(reducers)
