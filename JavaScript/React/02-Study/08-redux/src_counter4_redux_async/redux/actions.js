/*
    包含所有的 action creator
 */

import {DECREMENT, INCREMENT} from './action-types'

export const increment = (number) => ({
    type: INCREMENT,
    data: number,
})

export const decrement = number => ({
    type: DECREMENT,
    data: number,
})

// 同步的action都返回一个对象
// 异步的action都返回一个函数

// 异步action

// 该写法相当于return一个函数
export const incrementAsync = number => (
    dispatch => {
        // 异步的代码
        setTimeout(() => {
            // 1s 之后才回去分化一个增加的action
            dispatch(increment(number))
        }, 1000)
    }
)
