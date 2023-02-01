<template>
  <main>
    <section class="main-wrap">
      <!-- 상품 이미지 -->
      <div class="product-img-wrap">
        <img class="product-img" src="/image/product-img.jpg" alt="" />
      </div>

      <!-- 판매자 프로필 정보 -->
      <section class="profile-container">
        <img class="profile-img" src="/image/prof-img.jpg" alt="" />
        <!-- <h1>{{ detailProduct.regMemberId }}</h1> -->
        <h1>sdlkjflksdjflksdjf</h1>
        <div class="product-count-and-update-product">
          <span class="product-count">판매상품 6</span>
          <span class="update-product">상품수정</span>
        </div>
      </section>

      <div class="line"></div>

      <!-- 상품 상세정보 -->
      <section class="detail-container">
        <div class="detail-container-title">
          <!-- <h1>{{ detailProduct.name }}</h1> -->
          <h1>dsfsdfsdfsdf</h1>
          <!-- <span class="detail-category">{{ detailProduct.superCategory }}>{{ detailProduct.subCategory }}</span> -->
          <span class="detail-category">dfsdfsdf>sdfsdfsdfsdf</span>

          <!-- <span>{{ detailProduct.updateDate }}</span> -->
          <span>14분전</span>

        </div>
        <div class="detail-icon">
          <div class="">
            <img src="/image/icon/icon-eye-fill.svg" alt="" />
            <!-- <span>{{ detailProduct.hit }}</span> -->
            <span>12</span>

          </div>
        </div>

      </section>

      <!-- 상품설명단락 -->
      <!-- <p class="product-explain">{{ detailProduct.description }}</p> -->
      <p class="product-explain">
        맂더라ㅣㅈ더라ㅣㄴ어리ㅏㅇ널맂더라ㅣㅈ더라ㅣㄴ어리ㅏㅇ널맂더라ㅣㅈ더라ㅣㄴ어리ㅏㅇ널
        맂더라ㅣㅈ더라ㅣㄴ어리ㅏㅇ널맂더라ㅣㅈ더라ㅣㄴ어리ㅏㅇ널맂더라ㅣㅈ더라ㅣㄴ어리ㅏㅇ널
        맂더라ㅣㅈ더라ㅣㄴ어리ㅏㅇ널맂더라ㅣㅈ더라ㅣㄴ어리ㅏㅇ널맂더라ㅣㅈ더라ㅣㄴ어리ㅏㅇ널
        맂더라ㅣㅈ더라ㅣㄴ어리맂더라ㅣㅈ더라ㅣㄴ어리맂더라ㅣㅈ더라ㅣㄴ어리
      </p>

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
          <!-- <li>상품상태 {{ detailProduct.condition }}</li> -->
          <li>상품상태: ㄴㅇㄹㄴㅇㄹㄴㅇㄹㄴㅇㄹㄹㄴㅇㄴㅇㄹㄴㅇㄹ</li>

          <li>배송방법: 등기</li>
        </ul>
      </section>

      <div class="line"></div>

      <section class="product-card-component">
        <h1 class="detail-user-others">이 판매자의 다른 물건</h1>
        <div class="product-flex">
          <div class="product-wrap">
            <!--            <product-component :products="otherProductList" />-->
          </div>
        </div>
      </section>

      <!-- 찜, 가격, 톡버튼 -->
      <section class="bottom-bar-wrap">
        <div class="bottom-bar">
          <div class="wish-img-wrap"><img src="/image/icon/heart.svg" alt="" /></div>
          <div class="product-price-wrap">
            <!-- <span class="product-price">{{ detailProduct.price }}</span> -->
            <span class="product-price">80,000원</span>

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
export default {
  data() {
    return {
      detailProduct: [],
      otherProductList: [],
      e1: false,
      e2: false,
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
        const response = await fetch(`http://localhost:8080/products/${this.$route.query.id}`);
        const json = await response.json();
        this.detailProduct = json;
      } catch (e) {
        this.e1 = e;
      } finally {
      }
    },
    async fetchRegMember() {
      try {
        const response = await fetch(`http://localhost:8080`);
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
