<template>
  <div class="login-body">
    <div class="login-header">
      <h1 class="d-none">로고</h1>

      <div class="login-logo">Ducktem</div>
    </div>

    <main class="login-main">
      <section class="login-form">
        <h1 class="d-none">로그인</h1>

        <form action="login" method="post">
          <!-- 백에서 사용할 로그인 함수이름-->

          <div class="login-input-container">
            <div>
              <label class="required" for="uid">아이디</label>
              <input id="uid" name="userId" type="text" required autofocus placeholder="아이디를 입력해주세요." v-model="id" />
            </div>

            <div>
              <label class="required" for="password">비밀번호</label>
              <input id="password" name="pwd" type="password" required placeholder="비밀번호를 입력해주세요." v-model="password" />
            </div>
          </div>

          <div class="login-form-option">
            <div class="login-keep">
              <input type="radio" id="autologin" name="autologin" value="1" />
              <label for="autologin">자동로그인</label>
            </div>

            <div class="find-id-pwd">
              <span><a href="">아이디찾기 </a></span>|
              <span><a href="">비밀번호 찾기</a></span>
            </div>
          </div>

          <div class="btn-container">
            <div>
              <button class="btn btn-default" @click.prevent="login()">로그인</button>
            </div>

            <div class="signup">
              <a class="btn signup-btn" href="">회원가입</a>
            </div>
          </div>
        </form>
      </section>

      <!-- ========     로그인 옵션 부분     ======== -->
      <section class="login-option">
        <h1 class="d-none">로그인 옵션</h1>
        <div>
          <a href="" class="login-with kakao">카카오로 로그인하기</a>
        </div>
        <div>
          <a href="" class="login-with naver">네이버로 로그인하기</a>
        </div>
        <div>
          <a href="" class="login-with facebook">페이스북으로 로그인하기</a>
        </div>
        <div>
          <a href="" class="login-with google">구글로 로그인하기</a>
        </div>
      </section>
    </main>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data() {
    return {
      id: '',
      password: '',
    };
  },
  methods: {
    login() {
      // 아이디와 패스워드 입력여부 확인
      if (this.id && this.password) {
        let id = this.id; // 아이디
        let password = this.password; // 비밀번호
        this.$store.dispatch('login', { id, password }); // 로그인
      } else {
        alert('아이디 또는 비밀번호가 입력되지 않았습니다.');
        return false;
      }
    },
  },
};
</script>

<style scoped>
@import '/css/login.css';
</style>
