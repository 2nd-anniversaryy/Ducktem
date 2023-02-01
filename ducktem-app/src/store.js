import router from './router';

import { createStore } from 'vuex';
import createPersistedState from 'vuex-persistedstate';

const state = {
  tokenResponse: {
    refresh: null,
    access: null,
  },
  id: null,
  nickName: null,
  // junhyun
  userId: null,
  token: null,
  tokenExpiration: null,
  pwd: null,
};
const getters = {
  refresh: (state) => state.tokenResponse.refresh,
  access: (state) => state.tokenResponse.access,
  id: (state) => state.userId,
  nickname: (state) => state.nickName,
  pwd: (state) => state.pwd,
};
const mutations = {
  // junhyun
  setUser(state, payload) {
    (state.token = payload.token), (state.userId = payload.userId), (state.tokenExpiration = payload.tokenExpiration);
  },
  confirm(state, item) {
    state.id = item.userId;
    state.pwd = item.pwd;
  },
  login(state, item) {
    state.tokenResponse.refresh = item.tokenResponse.refresh;
    state.tokenResponse.access = item.tokenResponse.access;
    state.id = item.userId;
    state.nickname = item.nickName;
  },
  logout(state) {
    state.tokenResponse.access = null;
    state.tokenResponse.refresh = null;
    state.id = null;
    state.nickname = null;
    state.pwd = null;
  },
};
const actions = {
  // junhyun
  async signUp(context, params) {
    const response = await fetch('http://localhost:8080/members/join', {
      method: 'POST',
      body: JSON.stringify(params),
    });

    const responseData = await response.json();

    if (!response.ok) {
      console.log(responseData);
      const error = new Error(responseData.message || '인증에 실패하였습니다.');
      throw error;
    }

    console.log(responseData);
  },

  confirm({ commit }, { id, password }) {
    let params = {
      userId: id,
      pwd: password,
    };

    const response = fetch(`http://localhost:8080/members/confirm`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json', //보내는 형식
      },
      body: JSON.stringify(params),
    })
      .then((response) => {
        return response.text();
      })
      .then((result) => {
        if (result) {
          commit('confirm', params);
        } else {
          console.log('로그인에 실패하였습니다.');
        }
      })
      .then(() => {
        router.push('/survey');
        alert('인증되었습니다.');
      })
      .catch((e) => {
        console.log(e);
        alert('로그인 서버 에러발생');
      });
  },
  delete({ commit }, { id, password }) {
    let params = {
      userId: id,
      pwd: password,
    };

    const response = fetch(`http://localhost:8080/members`, {
      method: 'DELETE',
      headers: {
        'Accept': 'application/json', //받는 형식
        'Content-Type': 'application/json', //보내는 형식
      },
      body: JSON.stringify(params),
    })
      .then((response) => {
        commit('logout');
        alert('삭제되었습니다.');
      })
      .catch((e) => {
        console.log(e);
        alert(e);
        alert('삭제에 실패하였습니다.');
      });
  },

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
  paths: ['tokenResponse.access', 'tokenResponse.refresh', 'id', 'nickname', 'pwd'],
});

const store = createStore({
  state: state,
  getters: getters,
  mutations: mutations,
  actions: actions,
  plugins: [persistedState],
});

export default store;
