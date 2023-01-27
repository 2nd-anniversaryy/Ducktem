import router from './router';

import { createStore } from 'vuex';
import createPersistedState from 'vuex-persistedstate';

const state = {
  refreshJwt: null,
  accessJwt: null,
  id: null,
  nickname: null,
};
const getters = {
  refreshJwt: (state) => state.refreshJwt,
  accessJwt: (state) => state.accessJwt,
  id: (state) => state.id,
  nickname: (state) => state.nickname,
};
const mutations = {
  login(state, item) {
    state.refreshJwt = item.headers['refreshJwt'];
    state.accessJwt = item.headers['accessJwt'];
    state.id = item.data['id'];
    state.nickname = item.data['nickname'];
  },
  logout(state) {
    state.refreshJwt = null;
    state.accessJwt = null;
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
        response.json();
        console.log(response);
      })
      .then((result) => {
        console.log(result);
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
  paths: ['refreshJwt', 'accessJwt', 'id', 'nickname'],
});

const store = createStore({
  state: state,
  getters: getters,
  mutations: mutations,
  actions: actions,
  plugins: [persistedState],
});

export default store;
