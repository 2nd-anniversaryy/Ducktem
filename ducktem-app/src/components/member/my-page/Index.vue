<template>
  <div>
    <main>
      <section class="main-wrap">
        <section class="profile">
          <div>
            <img v-if="!myInfo.profileUrl" src="/image/icon/account-human.svg" alt="" />
            <img v-if="myInfo.profileUrl" src="myInfo.profileUrl" alt="" />
          </div>
          <div>
            <span>{{ myInfo.nickName }}</span>
          </div>
          <div>
            <a class="btn btn-default" @click.prevent="goMyInfo">내 정보</a>
          </div>
          <div>
            <span>{{ myInfo.intro }}</span>
          </div>
          <!-- <div>
            <a class="btn btn-default keyword-alert-btn" @click.prevent="">키워드 알림</a>
          </div> -->
        </section>

        <section class="title">
          <div class="selling-btn" @click="fetchMyProductList">판매중 {{ myProductList.length }}</div>
          <div class="wish-list-btn" @click="fetchMyWishList">찜 상품 {{ myWishList.length }}</div>
        </section>
        <div class="product-flex">
          <section v-if="myProduct" class="product-wrap product-page">
            <product-component :products="myProductList" />
          </section>
          <section v-if="myWish" class="product-wrap wish-page">
            <product-component :products="myWishList" />
          </section>
        </div>
      </section>
    </main>

    <!-- 키워드 알림 버튼 누르면 이거 떠야함~ -->
    <aside class="d-none keyword-alert-wrap">
      <section class="keyword-alert">
        <div class="keyword-alert-title">
          <h1>키워드 알림 설정</h1>
          <img class="keyword-close" src="/image/icon/icon-close.svg" alt="" />
        </div>

        <div class="keyword-alert-category">
          <label for="">카테고리</label>
          <select name="" id="">
            <option value="">전체선택</option>
            <option value="">공식굿즈</option>
            <option value="">비공식굿즈</option>
            <option value="">대리티켓팅</option>
          </select>
        </div>

        <div class="flex-wrap">
          <div class="keyword-alert-input">
            <input type="text" placeholder="키워드를 입력해 주세요(예: #NCT)" />
            <span class="">등록</span>
          </div>
        </div>

        <div class="keyword-alert-count"><span>등록한 키워드</span><span>0/5</span></div>

        <div class="keyword-sort">
          <span class="btn btn-tag">#테스트</span>
          <span class="btn btn-tag">#테스트</span>
          <span class="btn btn-tag">#테스트</span>
        </div>

        <div class="text-sort">
          <span>아름다운 키워드로 아름다운 덕템 만들기</span>
        </div>

        <div class="button-sort">
          <span class="btn btn-default btn-size-control">알림 받기</span>
        </div>
      </section>
    </aside>
  </div>
</template>

<script>
import ProductComponent from '../../ProductComponent.vue';

export default {
  data() {
    return {
      myInfo: [],
      myProductList: [],
      myWishList: [],
      myProduct: true,
      myWish: true,
      e1: false,
      e2: false,
    };
  },
  components: {
    ProductComponent,
  },
  mounted() {
    this.fetchMyInfo();
    this.fetchMyWishList();
    this.fetchMyProductList();
  },
  methods: {
    async fetchMyInfo() {
      try {
        const response = await fetch('http://localhost:8080/members/me', {
          headers: {
            Authorization: 'Bearer ' + this.$store.state.tokenResponse.access,
          },
        });
        const json = await response.json();
        this.myInfo = json;
      } catch (e) {
        this.e1 = e;
      } finally {
      }
    },
    async fetchMyWishList() {
      try {
        const response = await fetch('http://localhost:8080/products/wish', {
          headers: {
            Authorization: 'Bearer ' + this.$store.state.tokenResponse.access,
          },
        });
        const json = await response.json();
        this.myWishList = json;
      } catch (e) {
        this.e2 = e;
      } finally {
        this.myProduct = false;
        this.myWish = true;
      }
    },
    async fetchMyProductList() {
      try {
        const response = await fetch('http://localhost:8080/products/me', {
          headers: {
            Authorization: 'Bearer ' + this.$store.state.tokenResponse.access,
          },
        });
        const json = await response.json();
        this.myProductList = json;
      } catch (e) {
        this.e2 = e;
      } finally {
        this.myProduct = true;
        this.myWish = false;
      }
    }
  },

  computed: {
    goMyInfo() {
      this.$router.push('/my-info');
    },
  },
};
</script>

<style scoped>
@import '/css/member/my-page/index.css';
</style>
