<template>
  <main>
    <form action="login" method="post" class="main-wrap">
      <div>회원님의 소중한 정보 보호를 위해 비밀번호를 확인해 주세요.</div>

      <div>
        <input type="text" placeholder="아이디" v-model="id" />
      </div>
      <div>
        <input type="password" placeholder="비밀번호" v-model="password" />
      </div>

      <div>
        <button class="btn btn-default" @click.prevent="yesBtnHandeler(id, password)">확인</button>
      </div>
    </form>
  </main>
</template>

<script>
export default {
  data() {
    return {
      id: '',
      password: '',
    };
  },
  methods: {
    async yesBtnHandeler(id, password) {
      let params = {
        userId: id,
        pwd: password,
      };
      if (this.id && this.password) {
        id = this.id; // 아이디
        password = this.password; // 비밀번호
        this.$store.dispatch('save/save', params);
      } else {
        alert('아이디 또는 비밀번호가 입력되지 않았습니다.');
        return false;
      }
    },
  },
};
</script>

<style scoped>
@import '/css/member/my-page/leave/index.css';
</style>
