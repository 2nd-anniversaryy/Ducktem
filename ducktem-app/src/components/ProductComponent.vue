<template>
  <div class="product-container" v-for="product in this.products" @click="goDetailPage(product.productId)">
    <div><img v-bind:src="product.thumbNail" alt="product-img" /></div>

    <div class="price-wish">
      <span> {{ product.price }}원</span>
      <img src="/image/icon/heart.svg" alt="찜" />
    </div>

    <div class="name">
      {{ product.name }}
    </div>

    <div class="time">
      {{ product.regDate }}
    </div>
  </div>
</template>

<script>
export default {
  props: ['products'],
  data() {
    return {};
  },
  methods: {
    goDetailPage(id) {
      this.$router.push({ name: 'detail', query: { id: id } });
    },
  },
};
</script>

<style scoped></style>
