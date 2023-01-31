<template>
  <div class="product-container" v-for="product in this.products" @click="goDetailPage(product.productId, $event)">
    <div><img v-bind:src="product.thumbNail" alt="product-img" /></div>

    <div class="price-wish">
      <span> {{ product.price }}원</span>
      <Wish :wishStatus="product.wishStatus" :id="product.productId" />
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
import Wish from './wish.vue';
export default {
  props: ['products'],
  data() {
    return {
      wishList: [],
    };
  },
  components: { Wish },
  methods: {
    goDetailPage(id, event) {
      if (!event.target.classList.contains('wish')) {
        this.$router.push({ name: 'detail', query: { id: id } });
      }
    },
  },
};
</script>

<style scoped></style>
