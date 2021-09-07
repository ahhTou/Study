import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        currentTheme: 'light'
    },
    mutations: {
        changeTheme(state, payload) {
            document.documentElement.dataset.theme = payload
            state.currentTheme = payload
        }
    },
    actions: {},
    modules: {}
})
