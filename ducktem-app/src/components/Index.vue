<template>
  <main>
    <section class="main-wrap">
      <!-- <div class="banner-container">
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
      </div> -->

      <!-- 배너 -->
      <div class="banner-container">
        <div class="banner-wrap">
          <!-- <div class="inner" v-for="banner in banners" :key="banner">
            <img class="banner" :src="banner.img" v-if="banners[0]" />
          </div> -->
          <div class="inner">
            <img class="banner" :src="banners[index]" />
          </div>
          <!-- <div class="inner">
            <img class="banner" :src="banners[1]" />
          </div>
          <div class="inner">
            <img class="banner" :src="banners[2]" />
          </div> -->
        </div>
        <img class="vector-left" src="/image/icon/꺽쇠.svg" @click="changeBannerLeft" />
        <img class="vector-right" src="/image/icon/꺽쇠.svg" @click="changeBannerRight" />
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

          <li><img src="/image/블랙핑크.jpg" alt="" /><span>블랙핑크</span></li>

          <li><img src="/image/트와이스.jpg" alt="" /><span>트와이스</span></li>

          <li><img src="/image/여자아이들.jpg" alt="" /><span>(여자)아이들</span></li>

          <li><img src="/image/오마이걸.jpg" alt="" /><span>오마이걸</span></li>

          <li><img src="/image/엔믹스.png" alt="" /><span>엔믹스</span></li>

          <li><img src="/image/프로미스나인.jpg" alt="" /><span>프로미스나인</span></li>

          <li><img src="/image/EXO.jpg" alt="" /><span>EXO</span></li>

          <li><img src="/image/NCT127.jpg" alt="" /><span>NCT127</span></li>

          <li><img src="/image/몬스타엑스.jpg" alt="" /><span>몬스타엑스</span></li>

          <li><img src="/image/케플러.jpg" alt="" /><span>케플러</span></li>

          <li><img src="/image/TXT.jpeg" alt="" /><span>TXT</span></li>

          <li><img src="/image/스테이시.png" alt="" /><span>스테이시</span></li>
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

      index: 0,
      banners: [
        '/image/big-banner.png',
        '/image/big-banner1.png',
        '/image/big-banner2.png'
      ]
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
      let myInfoForAuth;
      if (this.$store.state.tokenResponse.access) {
        myInfoForAuth = 'Bearer ' + this.$store.state.tokenResponse.access;
      }
      try {
        const response = await fetch('http://localhost:8080/products', {
          headers: {
            Authorization: myInfoForAuth,
          },
        });
        const json = await response.json();
        this.productList = json;
      } catch (e) {
        this.e = e;
      } finally {
      }
    },

    // 배너 좌우버튼
    changeBannerLeft() {
      if (this.index > 0) {
        this.banners[this.index--];
      }
      console.log('left');
    },

    changeBannerRight() {
      if (this.index < 2) {
        this.banners[this.index++];
      }
      console.log('right');
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
