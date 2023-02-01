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
  async signUp(context, payload) {
    const response = await fetch('http://localhost:8080/members/join', {
      method: 'POST',
      body: JSON.stringify({
        name: payload.name,
        userId: payload.userId,
        pwd: payload.pwd,
        nickName: payload.nickName,
        email: payload.email,
        phoneNumber: payload.phoneNumber,
        regDate: payload.regDate,
        returnSecureToken: ture,
      }),
    });

    const responseData = await response.json();

    if (!response.ok) {
      console.log(responseData);
      const error = new Error(responseData.message || '인증에 실패하였습니다.');
      throw error;
    }

    console.log(responseData);
    context.commit('setUser', {
      token: responseData.idToken,
      userId: responseData.localId,
      tokenExpiration: responseData.expiresIn,
    });
  },

  confirm({ commit }, { id, password }) {
    let params = {
      userId: id,
      pwd: password,
    };

    const response = fetch(`http://localhost:8080/members`, {
      method: 'GET',
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
          commit('confirm', result);
          if (params.pwd) {
            state.pwd = params.pwd;
          }
          alert('인증되었습니다.');
        } else {
          console.log('로그인에 실패하였습니다.');
        }
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
        return response.json();
      })
      .then(() => {
        alert('삭제되었습니다.');
      })
      .catch((e) => {
        console.log(e);
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
  paths: ['tokenResponse.access', 'tokenResponse.refresh', 'id', 'nickname'],
});

const store = createStore({
  state: state,
  getters: getters,
  mutations: mutations,
  actions: actions,
  plugins: [persistedState],
});

export default store;
