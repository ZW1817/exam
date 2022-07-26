import { createStore } from 'vuex'
import createPersistedState from "vuex-persistedstate";

const s = createStore({
    // 存储账户信息
    state: {
        user: {},
    },

    // 用于变更store中的值
    mutations: {
        add(state, users) {
            state.user = users;
            // console.log(this.$store.state.user);
        },
    },
    actions: {},
    getters: {},
    moudels: {},
    plugins: [
        createPersistedState({
            storage: window.sessionStorage,
        }),
    ],

});

export default s;