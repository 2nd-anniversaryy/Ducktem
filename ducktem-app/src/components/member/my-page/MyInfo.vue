<template>
  <main>
    <section class="main-wrap">
      <section class="regist-prof-img-wrap">
        <div>
          <img v-if="!myInfoList.profileUrl" src="/image/profile-img.png" alt="" />
          <img v-if="myInfoList.profileUrl" src="myInfoList.profileUrl" alt="" />
        </div>
        <div>
          <input type="file" accept="image/*" alt="" name="profile-input" @change="changeMyProfile" />
          <label for="profile-input"><img src="/image/빈-상품이미지.png" /></label>
        </div>
      </section>

      <section class="input-area">
        <div><label for="">닉네임</label><input type="text" v-model="myInfoList.nickName" /></div>
        <div><label for="">소개글</label><textarea name="" id="" v-model="myInfoList.intro"></textarea></div>
        <div><label for="">이메일</label><input type="text" v-model="myInfoList.email" /></div>
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
        <span @click="goToLeave">회원탈퇴</span>

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
      profileImage: null,
    };
  },
  mounted() {
    this.fetchGetMyInfo();
  },
  watch: {},
  methods: {
    changeMyProfile(event) {
      this.profileImage = event.target.files[0];
    },
    updateMyInfoBtnClickHandler() {
      this.fetchUpdateMyInfo();
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
      let formData = new FormData();
      formData.append('nickName', this.myInfoList.nickName);
      formData.append('intro', this.myInfoList.intro);
      formData.append('email', this.myInfoList.email);
      formData.append('profileUrl', this.profileImage);

      console.log(this.$store.state.tokenResponse.access);
      try {
        const response = await fetch('http://localhost:8080/members', {
          method: 'PUT',
          headers: {
            Authorization: 'Bearer ' + this.$store.state.tokenResponse.access,
          },
          body: formData,
        }).then(console.log(response));
      } catch (e) {
        this.e = e;
      } finally {
      }
    },
    goToLeave() {
      this.$router.push('leave');
    },
  },
};
</script>

<style scoped>
@import '/css/member/my-page/my-info.css';
</style>
