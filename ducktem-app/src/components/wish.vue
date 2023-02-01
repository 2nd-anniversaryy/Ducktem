<template>
  <div>
    <img v-if="myStatus == 0" @click.prevent="checkClickHandler(id)" class="wish" src="/image/icon/heart.svg" alt="찜" />
    <img v-if="myStatus != 0" @click.prevent="unCheckClickHandler(id)" class="wish checked" src="/image/icon/icon-heart-red.svg" alt="찜" />
  </div>
</template>

<script>
export default {
  props: ['wishStatus', 'id'],
  data() {
    return {
      myStatus: this.$props.wishStatus,
    };
  },
  methods: {
    async checkClickHandler(productId) {
      let myInfoForAuth;
      if (this.$store.state.tokenResponse.access) {
        myInfoForAuth = 'Bearer ' + this.$store.state.tokenResponse.access;
      } else {
        alert('로그인이 필요한 서비스 입니다.');
        this.$router.push('/login');
      }
      try {
        const response = await fetch(`http://localhost:8080/wish/${productId}`, {
          method: 'POST',
          headers: {
            Authorization: myInfoForAuth,
          },
        });
      } catch (e) {
        this.e = e;
      } finally {
        this.myStatus = 1;
      }
    },
    async unCheckClickHandler(productId) {
      let myInfoForAuth;
      if (this.$store.state.tokenResponse.access) {
        myInfoForAuth = 'Bearer ' + this.$store.state.tokenResponse.access;
      }
      try {
        const response = await fetch(`http://localhost:8080/wish/${productId}`, {
          method: 'DELETE',
          headers: {
            Authorization: myInfoForAuth,
          },
        });
      } catch (e) {
        this.e = e;
      } finally {
        this.myStatus = 0;
      }
    },
  },
};
</script>

<style scoped></style>
