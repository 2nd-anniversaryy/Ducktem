<template>
  <Teleport to="body">
    <img v-if="!wishCheck" @click.prevent="checkClickHandler" class="wish" src="/image/icon/heart.svg" alt="찜" />
    <img v-if="wishCheck" @click.prevent="unCheckClickHandler" class="wish checked" src="/image/icon/icon-heart-red.svg" alt="찜" />
  </Teleport>
</template>

<script>
export default {
  data() {
    return {
      wishCheck: false,
    };
  },
  methods: {
    checkClickHandler(e) {
      this.wishCheck = false;
    },
    unCheckClickHandler(e) {
      this.wishCheck = true;
    },
  },
};
</script>

<style scoped></style>
