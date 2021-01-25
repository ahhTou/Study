/*
* Redux 模块
* 1. createStore(reducer)
*
* 2. combineReducers(reducers)
*
* */

export function createStore(reducer) {
    // 内部state
    let state
    const listeners = []
    state = reducer(state, {
        type: '@mini-redux',
    })

    const getState = () => {
        return state
    }
    const dispatch = (action) => {
        // 调用 reducer, 得到一个新的state
        state = reducer(state, action)
        // 调用所有的listeners
        listeners.forEach(listener => listener())
    }
    const subscribe = (listener) => {
        listeners.push(listener)
    }

    return {getState, dispatch, subscribe}
}

// 接受一个包含多个，reducer 函数的对象 , 返回一个新的reducer函数
export function combineReducersSimple(reducers) {
    return (state = {}, action) => { // 这个函数会传给createStore
        // 准备一个用来保存所有新状态的容器对象
        const newState = {}
        Object.keys(reducers).forEach(key => {
            const childReducer = reducers[key] // 得到对应的子reducer函数
            const childState = state[key]
            // 执行reducer ,保存到新的总state总
            newState[key] = childReducer(childState, action)
        })
        return newState
    }
}

export function combineReducers(reducers) {
    return (state = {}, action) => { // 这个函数会传给createStore
        // 准备一个用来保存所有新状态的容器对象
        return Object.keys(reducers).reduce((newState, key) => {
            newState[key] = reducers[key](state[key], action)
            return newState
        }, {})
    }
}
