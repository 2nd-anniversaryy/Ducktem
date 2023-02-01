<template>
  <main>
    <section class="main-wrap">
      <h1>{{ $login.state.id }}, 어찌 떠나려는 거야</h1>

      <ul>
        <li>
          <input type="radio" name="chk" id="1" value="1" v-model="reasonForLeave" />
          <label for="1">탈덕/휴덕으로 인해</label>
        </li>
        <li>
          <input type="radio" name="chk" id="2" value="2" v-model="reasonForLeave" />
          <label for="2">원하는 상품이 없어서</label>
        </li>
        <li>
          <input type="radio" name="chk" id="3" value="3" v-model="reasonForLeave" />
          <label for="3">서비스 사용에 장애/에러가 많아서</label>
        </li>
        <li>
          <input type="radio" name="chk" id="4" value="4" v-model="reasonForLeave" />
          <label for="4">서비스 사용 방법이 어려워서</label>
        </li>
        <li>
          <input type="radio" name="chk" id="5" value="5" v-model="reasonForLeave" />
          <label for="5">다른 플랫폼을 사용하려고</label>
        </li>
        <li>
          <input type="radio" name="chk" id="6" value="6" v-model="reasonForLeave" />
          <label for="6">기타사유</label>
        </li>
      </ul>

      <textarea name="" id="" placeholder="더 나은 덕템을 만들 수 있도록 도와주세요!"></textarea>

      <button @click="this.$router.push('/index')" class="btn btn-default">더 생각해볼래요</button>
      <button @click="goToFinalCheck(reasonForLeave)" class="btn btn-cancel">확인</button>
    </section>
  </main>
</template>

<script>
export default {
  data() {
    return {
      reasonForLeave: '',
    };
  },
  methods: {
    goToFinalCheck(reasonForLeave) {
      if (reasonForLeave) {
        this.$router.push('/final-check');
      } else {
        alert('이번 조사는 덕템을 해적사이트에서 벗어나게 해줄겁니다. 재워주세요 제발 탈퇴 이유를 선택해주세요.');
      }
    },
  },
};
</script>

<style scoped>
@import '/css/member/my-page/leave/survey.css';
</style>
