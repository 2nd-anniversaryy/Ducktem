<template>
  <div>
    <img v-if="wishStatus == 0" @click.prevent="checkClickHandler(id)" class="wish" src="/image/icon/heart.svg" alt="찜" />
    <img v-if="wishStatus != 0" @click.prevent="unCheckClickHandler(id)" class="wish checked" src="/image/icon/icon-heart-red.svg" alt="찜" />

    <div>{{ wishStatus }}</div>
  </div>
</template>

<script>
export default {
  props: ['wishStatus', 'id'],
  data() {
    return {};
  },
  methods: {
    checkClickHandler(id) {
      this.wishStatus = 0;
    },
    unCheckClickHandler(id) {
      this.wishStatus = 1;
    },
  },
};
</script>

<style scoped></style>
