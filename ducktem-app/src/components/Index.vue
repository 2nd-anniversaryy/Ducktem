<template>
  <main>
    <section class="main-wrap">
      <div class="banner-container">
        <div class="banner-wrap">
          <div class="inner">
            <img class="banner1" src="/image/big-banner.png" alt="banner" />
          </div>
          <div class="inner">
            <img class="banner2" src="/image/big-banner1.png" alt="banner" />
          </div>
          <div class="inner">
            <img class="banner3" src="/image/big-banner2.png" alt="banner" />
          </div>
        </div>
        <img class="vector-left" src="/image/icon/꺽쇠.svg" alt="" />
        <img class="vector-right" src="/image/icon/꺽쇠.svg" alt="" />
      </div>

      <section>
        <div class="category-image-wrap">
          <div class="category-image" @click="goListPage">
            <img class="gong" src="/image/categ-gong-goods.jpg" />
            <div class="category-text">
              <span>공식 굿즈</span>
              <span>shop Now --></span>
            </div>
          </div>

          <div class="category-image" @click="goListPage">
            <img class="bigong" src="/image/categ-bigong-goods.jpg" />
            <div class="category-text">
              <span>비공식 굿즈</span>
              <span>shop Now --></span>
            </div>
          </div>

          <div class="category-image" @click="goListPage">
            <img class="dari" src="/image/categ-dari.jpg" />
            <div class="category-text">
              <span>대리 티켓팅</span>
              <span>shop Now --></span>
            </div>
          </div>
        </div>
      </section>

      <section>
        <h3 id="title1">최근 인기 키워드</h3>
        <ul class="tag-sort">
          <li><img src="/image/아이브.webp" alt="" /><span>아이브</span></li>

          <li><img src="/image/방탄소년단.jpg" alt="" /><span>BTS</span></li>

          <li><img src="/image/르세라핌.jpg" alt="" /><span>르세라핌</span></li>

          <li><img src="/image/뉴진스.jpg" alt="" /><span>뉴진스</span></li>

          <li><img src="/image/아이브.webp" alt="" /><span>아이브</span></li>

          <li><img src="/image/방탄소년단.jpg" alt="" /><span>BTS</span></li>

          <li><img src="/image/르세라핌.jpg" alt="" /><span>르세라핌</span></li>

          <li><img src="/image/뉴진스.jpg" alt="" /><span>뉴진스</span></li>

          <li><img src="/image/아이브.webp" alt="" /><span>아이브</span></li>

          <li><img src="/image/방탄소년단.jpg" alt="" /><span>BTS</span></li>

          <li><img src="/image/르세라핌.jpg" alt="" /><span>르세라핌</span></li>

          <li><img src="/image/뉴진스.jpg" alt="" /><span>뉴진스</span></li>
        </ul>
      </section>

      <section>
        <h3 id="title2">최근 등록된 상품</h3>
        <div class="product-flex">
          <div class="product-wrap">
            <product-component :products="productList" />
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
      productList: [],
      e: false,
    };
  },
  components: {
    ProductComponent,
  },
  mounted() {
    this.fetchProductList();
  },
  methods: {
    async fetchProductList() {
      try {
        const response = await fetch('http://localhost:8080/products/main', {
          headers: {
            Authorization: 'Bearer ' + this.$store.state.tokenResponse.access,
          },
        });
        const json = await response.json();
        this.productList = json;
      } catch (e) {
        this.e = e;
      } finally {
      }
    },
  },
  computed: {
    goListPage() {
      this.$router.push('/list');
    },
  },
};
</script>

<style scoped>
@import '/css/index.css';
</style>
