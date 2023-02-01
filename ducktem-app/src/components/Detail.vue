<template>
  <main>
    <section class="main-wrap">
      <!-- 상품 이미지 -->
      <div class="product-img-wrap">
        <img class="product-img" v-for="imgUrl in this.imgList" src="imgUrl" alt="" />
      </div>

      <!-- 판매자 프로필 정보 -->
      <section class="profile-container">
        <img class="profile-img" src="/image/prof-img.jpg" alt="" />
        <h1>{{ regMemberInfo.nickName }}</h1>
        <div class="product-count-and-update-product">
          <span class="product-count">판매상품 {{ sellProductSize }}</span>
          <span v-if="regMemberInfo.nickName == $store.state.nickname" class="update-product" @click="updateProduct">상품수정</span>
        </div>
      </section>

      <div class="line"></div>

      <!-- 상품 상세정보 -->
      <section class="detail-container">
        <div class="detail-container-title">
          <h1>{{ detailProductInfo.name }}</h1>
          <span class="detail-category">{{ detailProductInfo.superCategory }}+{{ detailProductInfo.subCategory }}</span>

          <span>{{ detailProductInfo.updateDate }}</span>
        </div>
        <div class="detail-icon">
          <div class="">
            <img src="/image/icon/icon-eye-fill.svg" alt="" />
            <span>{{ detailProductInfo.hit }}</span>
          </div>
        </div>
      </section>

      <!-- 상품설명단락 -->
      <!-- <p class="product-explain">{{ detailProduct.description }}</p> -->
      <p class="product-explain">{{ detailProductInfo.description }}</p>

      <!-- 상품 태그 -->
      <section class="product-tag-wrap">
        <ul class="detail-button">
          <li><a class="btn btn-tag" href="">Newjeans</a></li>
          <li><a class="btn btn-tag" href="">포카</a></li>
          <li><a class="btn btn-tag" href="">Aespa</a></li>
          <li><a class="btn btn-tag" href="">Aespa</a></li>
          <li><a class="btn btn-tag" href="">Aespa</a></li>
        </ul>
      </section>

      <!-- 상품 설정 정보 -->
      <section class="detail-spec-container">
        <ul>
          <li>상품상태: {{ detailProductInfo.condition }}</li>

          <li>배송방법: {{ detailProductInfo.condition }}</li>
        </ul>
      </section>

      <div class="line"></div>

      <section class="product-card-component">
        <h1 class="detail-user-others">이 판매자의 다른 물건</h1>
        <div class="product-flex">
          <div class="product-wrap">
            <product-component :products="otherProductList" />
          </div>
        </div>
      </section>

      <!-- 찜, 가격, 톡버튼 -->
      <section class="bottom-bar-wrap">
        <div class="bottom-bar">
          <div class="wish-img-wrap">
            <Wish :wishStatus="detailProductInfo.wishStatus" :id="detailProductInfo.id" />
          </div>
          <div class="product-price-wrap">
            <span class="product-price">{{ detailProductInfo.price }} 원</span>
          </div>
          <div class="chat-btn-wrap">
            <button class="btn btn-default" @click="goChattingPage">덕템톡</button>
          </div>
        </div>
      </section>
    </section>
  </main>
</template>

<script>
import ProductComponent from './ProductComponent.vue';
import Wish from './wish.vue';
export default {
  data() {
    return {
      detailProductInfo: [],
      otherProductList: [],
      regMemberInfo: [],
      imgList: [],
      sellProductSize: null,
      e1: false,
      e2: false,
    };
  },
  components: {
    ProductComponent,
    Wish,
  },
  mounted() {
    this.fetchProductDetail();
  },
  methods: {
    async fetchProductDetail() {
      try {
        const response = await fetch(`http://localhost:8080/products/${this.$route.query.id}`);
        const json = await response.json();
        this.detailProductInfo = json;
        this.sellProductSize = this.detailProductInfo.otherProductsSize;
        this.regMemberInfo = this.detailProductInfo.regMemberInfo;
        this.otherProductList = this.detailProductInfo.otherProducts;
        this.imgList = this.detailProductInfo.imgNames;
      } catch (e) {
        this.e1 = e;
      } finally {
      }
    },
    updateProduct() {
      this.$router.push(`/update-product/${this.$route.query.id}`);
    },
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
