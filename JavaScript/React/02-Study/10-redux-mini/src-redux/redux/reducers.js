import {combineReducers} from '../libs/redux'
import {ADD_MSG, DECREMENT, INCREMENT} from './action-types'

// 管理count
const initCount = 0

function count(state = initCount, action) {
    console.log(action)
    switch (action.type) {
        case INCREMENT:
            return state + action.data
        case DECREMENT:
            return state - action.data
        default:
            return state
    }
}

const initMsgArr = []

function msgArr(state = initMsgArr, action) {
    console.log(action)
    switch (action.type) {
        case ADD_MSG:
            return [action.data, ...state]
        default:
            return state
    }
}

export default combineReducers({
    count,
    msgArr
})
