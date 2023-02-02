<template>
  <main>
    <section class="main-wrap">
      <!-- 상품 이미지 -->
      <div class="product-img-wrap">
        <img class="product-img" v-for="imgUrl in this.imgList" :src="imgUrl.imgUrl" alt="" />
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
          <span class="detail-category">{{ detailProductInfo.superCategory }}>{{ detailProductInfo.subCategory }}</span>

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
          <li v-for="tag in tags">
            <a class="btn btn-tag" href="">{{ tag.name }}</a>
          </li>
        </ul>
      </section>

      <!-- 상품 설정 정보 -->
      <section class="detail-spec-container">
        <ul>
          <li>상품상태: {{ detailProductInfo.condition }}</li>

          <li>배송방법: {{ detailProductInfo.deliveryType }}</li>
        </ul>
      </section>

      <div class="line"></div>

      <section class="product-card-component">
        <h1 class="detail-user-others">이 판매자의 다른 물건</h1>
        <div class="product-flex">
          <div class="product-wrap"><product-component :products="otherProductList" :pageName="true" @refresh="fetchProductDetail" /></div>
        </div>
      </section>

      <!-- 찜, 가격, 톡버튼 -->
      <section class="bottom-bar-wrap">
        <div class="bottom-bar">
          <div class="wish-img-wrap">
            <img v-if="myBottomWishStatus != 1" class="wish" @click.prevent="checkBottomWishClickHandler()" src="/image/icon/heart.svg" alt="찜" />
            <img
              v-if="myBottomWishStatus == 1"
              class="wish checked"
              @click.prevent="unCheckBottomWishClickHandler()"
              src="/image/icon/icon-heart-red.svg"
              alt="찜"
            />
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
export default {
  data() {
    return {
      detailProductInfo: [],
      otherProductList: [],
      regMemberInfo: [],
      imgList: [],
      tags: [],
      deliveryType: null,
      sellProductSize: null,
      e1: false,
      e2: false,
      myBottomWishStatus: '',
    };
  },
  components: {
    ProductComponent,
  },
  mounted() {
    this.fetchProductDetail();
  },
  methods: {
    async checkBottomWishClickHandler() {
      let myInfoForAuth;
      if (this.$store.state.tokenResponse.access) {
        myInfoForAuth = 'Bearer ' + this.$store.state.tokenResponse.access;
      } else {
        alert('로그인이 필요한 서비스 입니다.');
        this.$router.push('/login');
      }
      try {
        const response = await fetch(`http://localhost:8080/wish/${this.$route.query.id}`, {
          method: 'POST',
          headers: {
            Authorization: myInfoForAuth,
          },
        });
      } catch (e) {
        this.e = e;
      } finally {
        this.myBottomWishStatus = 1;
      }
    },
    async unCheckBottomWishClickHandler() {
      let myInfoForAuth;
      if (this.$store.state.tokenResponse.access) {
        myInfoForAuth = 'Bearer ' + this.$store.state.tokenResponse.access;
      }
      try {
        const response = await fetch(`http://localhost:8080/wish/${this.$route.query.id}`, {
          method: 'DELETE',
          headers: {
            Authorization: myInfoForAuth,
          },
        });
      } catch (e) {
        this.e = e;
      } finally {
        this.myBottomWishStatus = 0;
      }
    },
    async fetchProductDetail() {
      let myInfoForAuth;
      if (this.$store.state.tokenResponse.access) {
        myInfoForAuth = 'Bearer ' + this.$store.state.tokenResponse.access;
      }
      try {
        const response = await fetch(`http://localhost:8080/products/${this.$route.query.id}`, {
          headers: {
            Authorization: myInfoForAuth,
          },
        });
        const json = await response.json();
        this.detailProductInfo = json;
        this.sellProductSize = this.detailProductInfo.otherProductsSize;
        this.regMemberInfo = this.detailProductInfo.regMemberInfo;
        this.otherProductList = this.detailProductInfo.otherProducts;
        this.myBottomWishStatus = this.detailProductInfo.wishStatus;
        this.imgList = this.detailProductInfo.imgNames;
        this.tags = this.detailProductInfo.tags;
        this.deliveryType = this.detailProductInfo.deliveryType;
      } catch (e) {
        this.e1 = e;
      } finally {
      }
      // console.log(this.imgList);
    },
    updateProduct() {
      this.$router.push({ path: `/update-product/${this.$route.query.id}`, query: { id: `${this.$route.query.id}` } });
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
