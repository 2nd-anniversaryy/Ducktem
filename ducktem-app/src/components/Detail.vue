<template>
  <main>
    <section class="main-wrap">
      <div class="product-img-wrap">
        <img class="product-img" src="/image/product-img.jpg" alt="" />
      </div>

      <section class="profile-container">
        <img class="profile-img" src="/image/prof-img.jpg" alt="" />
        <h1>{{ detailProduct.regMemberId }}</h1>
        <span class="product-count">판매상품 6</span>

        <span class="review-info">★★★★★(2)</span>
      </section>
      <section class="detail-container">
        <div class="detail-container-title">
          <h1>{{ detailProduct.name }}</h1>
          <span class="detail-category">{{ detailProduct.superCategory }}>{{ detailProduct.subCategory }}</span>
          <span>{{ detailProduct.updateDate }}</span>
        </div>
        <div class="detail-icon">
          <div class="">
            <img src="/image/icon/icon-eye-fill.svg" alt="" />
            <span>{{ detailProduct.hit }}</span>
          </div>
        </div>
        <p>{{ detailProduct.description }}</p>
      </section>
      <section>
        <ul class="detail-button">
          <li><a class="btn btn-tag" href="">Newjeans</a></li>
          <li><a class="btn btn-tag" href="">포카</a></li>
          <li><a class="btn btn-tag" href="">Aespa</a></li>
          <li><a class="btn btn-tag" href="">Aespa</a></li>
          <li><a class="btn btn-tag" href="">Aespa</a></li>
        </ul>
      </section>
      <section class="detail-spec-container">
        <ul>
          <li>상품상태 {{ detailProduct.condition }}</li>
          <li>배송방법</li>
        </ul>
      </section>
      <section>
        <h1 class="detail-user-others">이 판매자의 다른 물건</h1>
        <div class="product-flex">
          <div class="product-wrap">
            <!--            <product-component :products="otherProductList" />-->
          </div>
        </div>
      </section>

      <section class="bottom-bar-wrap">
        <div class="bottom-bar">
          <div><img src="/image/icon/heart.svg" alt="" /><label for="">2</label></div>
          <div>
            <span>{{ detailProduct.price }}</span>
          </div>
          <div>
            <button class="btn btn-default" @click="goChattingPage">덕템톡</button>
          </div>
        </div>
      </section>
    </section>
  </main>
</template>

<script>
import ProductComponent from './ProductComponent.vue';
export default {
  data() {
    return {
      detailProduct: [],
      otherProductList: [],
      e1: false,
      e2: false,
      id: null,
    };
  },
  components: {
    ProductComponent,
  },
  mounted() {
    this.fetchProductDetail();
    this.fetchRegMember();
    // this.fetchProductList();
  },
  methods: {
    async fetchProductDetail() {
      try {
        const response = await fetch('http://localhost:8080/products/3');
        const json = await response.json();
        this.detailProduct = json;
      } catch (e) {
        this.e1 = e;
      } finally {
      }
    },
    async fetchRegMember() {
      try {
        const response = await fetch('http://localhost:8080');
        const json = await response.json();
        this.detailProduct = json;
      } catch (e) {
        this.e1 = e;
      } finally {
      }
    },
    // async fetchProductList() {
    //   try {
    //     const response = await fetch('http://localhost:8080/products');
    //     const json = await response.json();
    //     this.productList = json;
    //   } catch (e) {
    //     this.e2 = e;
    //   } finally {
    //   }
    // },
  },
  computed: {
    goChattingPage() {
      this.$router.push('/chatting');
    },
  },
};
</script>

<style scoped>
@import '/css/detail.css';
</style>
