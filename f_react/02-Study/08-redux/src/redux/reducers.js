import {ADD_COMMENT, DELETE_COMMENT, RECEIVE_COMMENTS} from './action-types'
import {combineReducers} from 'redux'

function comments(state = [], action) {

    switch (action.type) {
        case ADD_COMMENT:
            return [action.data, ...state]
        case DELETE_COMMENT:
            return state.filter((comment, index) => index !== action.data)
        case RECEIVE_COMMENTS:
            return action.data
        default:
            return state
    }

}

function counter(state = 0, action) {
    return state
}

export default combineReducers({
    comments, counter
})

// redux向外暴露的是什么结构
// { counter: 2, comments: [] }
