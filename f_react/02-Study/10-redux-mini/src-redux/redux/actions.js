import {ADD_MSG, DECREMENT, INCREMENT} from './action-types'

export const increment = num => ({
    type: INCREMENT,
    data: num
})

export const decrement = num => ({
    type: DECREMENT,
    data: num
})

export const addMsg = num => ({
    type: ADD_MSG,
    data: num
})
