import router from './router';

import { createStore } from 'vuex';
import createPersistedState from 'vuex-persistedstate';

const state = {
  refresh: null,
  access: null,
  id: null,
  nickname: null,
};
const getters = {
  refreshJwt: (state) => state.refresh,
  accessJwt: (state) => state.access,
  id: (state) => state.id,
  nickname: (state) => state.nickname,
};
const mutations = {
  login(state, item) {
    state.refresh = item.headers['refreshJwt'];
    state.access = item.headers['access'];
    state.id = item.data['id'];
    state.nickname = item.data['nickname'];
  },
  logout(state) {
    state.refresh = null;
    state.access = null;
    state.id = null;
    state.nickname = null;
  },
};
const actions = {
  login({ commit }, { id, password }) {
    let params = {
      userId: id,
      pwd: password,
    };

    const response = fetch(`http://localhost:8080/login`, {
      method: 'POST',
      headers: {
        'Accept': 'application/json', //받는 형식
        'Content-Type': 'application/json', //보내는 형식
      },
      body: JSON.stringify(params),
    })
      .then((response) => {
        return response.json();
      })
      .then((result) => {
        this.$router.push('/index');
      })
      .catch(() => {
        console.log('에러발생 안돼');
      });
  },
  logout() {
    mutations.logout();
  },
};

const persistedState = createPersistedState({
  paths: ['refresh', 'access', 'id', 'nickname'],
});

const store = createStore({
  state: state,
  getters: getters,
  mutations: mutations,
  actions: actions,
  plugins: [persistedState],
});

export default store;
