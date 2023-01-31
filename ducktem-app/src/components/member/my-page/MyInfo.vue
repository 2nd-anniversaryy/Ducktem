<template>
  <main>
    <section class="main-wrap">
      <section class="regist-prof-img-wrap">
        <div>
          <img v-if="!myInfoList.profileUrl" src="/image/profile-img.png" alt="" />
          <img v-if="myInfoList.profileUrl" src="myInfoList.profileUrl" alt="" />
        </div>
        <div>
          <input type="image" src="/image/빈-상품이미지.png" alt="" />
        </div>
      </section>

      <section class="input-area">
        <div><label for="">닉네임</label><input type="text" v-model="myInfoList.nickName" /></div>
        <div><label for="">소개글</label><textarea name="" id="" v-model="myInfoList.intro"></textarea></div>
        <div><label for="">이메일</label><input type="text" v-model="myInfoList.email" /></div>
        <div><label for="">비밀번호</label><input type="text" v-model="confirmPwd" /></div>
        <div><label for="">본인인증</label><input type="text" /></div>
        <div>
          <label for="">소셜연동</label>
          <div class="social-area">
            <div>
              <label for=""><img src="/image/kakao-logo.png" alt="" /><span>카카오톡</span></label>
              <input type="checkbox" name="" id="kakao" />
              <label class="btn btn-cancel checkd-btn" for="kakao">연동</label>
            </div>
            <div>
              <label for=""><img src="/image/naver-logo.png" alt="" /><span>네이버</span></label>
              <input type="checkbox" name="" id="naver" />
              <label class="btn btn-cancel checkd-btn" for="naver">연동</label>
            </div>
            <div>
              <label for=""><img src="/image/google-logo.png" alt="" /><span>구글</span></label>
              <input type="checkbox" name="" id="google" />
              <label class="btn btn-cancel checkd-btn" for="google">연동</label>
            </div>
          </div>
        </div>
        <span>회원탈퇴</span>

        <button class="btn btn-default" @click.prevent="updateMyInfoBtnClickHandler">저장하기</button>
      </section>
    </section>
  </main>
</template>

<script>
export default {
  data() {
    return {
      myInfoList: [],
      confirmPwd: null,
      e: false,
    };
  },
  mounted() {
    this.fetchGetMyInfo();
  },
  watch: {},
  methods: {
    async updateMyInfoBtnClickHandler() {
      if (this.confirmPwd) {
        await this.fetchUpdateMyInfo();
      } else {
        this.confirmPwd = '비밀번호가 틀렸습니다.';
      }
    },
    async fetchGetMyInfo() {
      try {
        const response = await fetch('http://localhost:8080/members/me', {
          headers: {
            Authorization: 'Bearer ' + this.$store.state.tokenResponse.access,
          },
        });
        const json = await response.json();
        this.myInfoList = json;
      } catch (e) {
        this.e = e;
      } finally {
      }
    },
    async fetchUpdateMyInfo() {
      try {
        const response = await fetch('http://localhost:8080/members', {
          method: 'PUT',
          headers: {
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + this.$store.state.tokenResponse.access,
          },
          body: JSON.stringify(this.myInfoList),
        });
        const json = await response.json();
      } catch (e) {
        this.e = e;
      } finally {
      }
    },
  },
};
</script>

<style scoped>
@import '/css/member/my-page/my-info.css';
</style>
