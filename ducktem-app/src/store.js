import router from './router';

import { createStore } from 'vuex';
import createPersistedState from 'vuex-persistedstate';

const state = {
  tockenResponse: {
    refresh: null,
    access: null,
  },
  id: null,
  nickname: null,
};
const getters = {
  refresh: (state) => state.tockenResponse.refresh,
  access: (state) => state.tockenResponse.access,
  id: (state) => state.id,
  nickname: (state) => state.nickname,
};
const mutations = {
  login(state, item) {
    state.tockenResponse.access = item.access;
    state.tockenResponse.refresh = item.refresh;
    state.id = item.id;
    state.nickname = item.nickname;
  },
  logout(state) {
    state.access = null;
    state.refresh = null;
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
        if (result) {
          commit('login', result);
          router.push('/index');
        } else {
          console.log('로그인에 실패하였습니다.');
        }
      })
      .catch((e) => {
        console.log(e);
        console.log('로그인 서버 에러발생');
      });
  },
  logout({ commit }) {
    commit('logout');
  },
};

const persistedState = createPersistedState({
  paths: ['access', 'refresh', 'id', 'nickname'],
});

const store = createStore({
  state: state,
  getters: getters,
  mutations: mutations,
  actions: actions,
  plugins: [persistedState],
});

export default store;
