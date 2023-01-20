<template>
  <header>

    <section class="header-wrap">
      <section class="menu">
        <nav class="menu-bar">
          <div class="burger-icon" @click="sideBarOpen()">
            <img class="menu-img" src="/image/icon/menu-black.svg" alt="">
          </div>

          <div class="menu-bar-category active" v-if="sideBarWrap == true">
            <div class="category-login">
              <a href="">로그인/회원가입</a>
            </div>

            <ul class="my-list">
              <li @click="goMyPage">내 상점</li>
              <li>굿즈 판매하기</li>
            </ul>

            <div class="middle-line"><span>카테고리</span></div>

            <div class="category-goods-wrap">
              <div class="category-goods" @click.prevent="goListPage">
                <input type="checkbox" name="" id="category-checkbox"><label for="category-checkbox">공식
                  굿즈</label>
              </div>
              <div class="category-goods" @click.prevent="goListPage">
                <input type="checkbox" name="" id="category-checkbox"><label for="category-checkbox">비공식
                  굿즈</label>
              </div>
              <div class="category-goods" @click.prevent="goListPage">
                <input type="checkbox" name="" id="category-checkbox"><label for="category-checkbox">대리
                  티켓팅</label>
              </div>
            </div>

            <ul class="menu-extra">
              <li @click="goHelpCenter">헬프센터</li>
              <li>1:1문의하기</li>
            </ul>

          </div>
        </nav>

        <img class="logo" src="/image/logo.png" alt="로고" @click="goMain" />
      </section>

      <div class="half-middle-category">
        <a @click.prevent="goListPage">공식 굿즈</a>
        <a @click.prevent="goListPage">비공식 굿즈</a>
        <a @click.prevent="goListPage">대리 티켓팅</a>
        <a @click.prevent="goHelpCenter">헬프센터</a>
        <a>1:1 문의하기</a>
      </div>

      <div class="header-icon">
        <img class="search-icon" src="/image/icon/search.svg" alt="검색" @click="searchBarOpen()">
        <img class="alarm-icon" src="/image/icon/bell.svg" alt="알람" @click="alarmWrapOpen()">
        <img class="chat-icon" src="/image/icon/icon-message.svg" alt="채팅">
      </div>

    </section>

    <!-- 검색 창 -->
    <section class="search-wrap" v-if="searchBarWrap == true">

      <div class="search-input-wrap">
        <img class="search-input-back" src="/image/icon/icon-right.svg" alt="뒤로가기">
        <input class="search-input-text" type="text" placeholder="어떤 상품을 찾으시나요?" value="">
        <img class="search-input-icon" src="/image/icon/search.svg" alt="검색">
      </div>


      <section class="latest-world-list-wrap">
        <div class="latest-world-list-wrap-title-delete">
          <div class="latest-world-list-title">내가 최근에 검색한 키워드</div>
          <div class="latest-world-list-delete">모두 지우기</div>
        </div>
        <div class="latest-word-list">
          <div class="btn btn-tag">
            포카
            <img src="/image/icon/icon-close.svg" class="latest-word-deletekey">
          </div>

        </div>

      </section>

    </section>

    <!-- 알람 창 -->
    <section class="alarm-container" v-if="alarmWrap == true">
      <div class="alarm-title-wrap">
        <h1>알림</h1>
        <div>
          <img src="/image/icon/icon-close.svg" class="alarm-close" @click="alarmWrapOpen()">
        </div>
      </div>
      <hr>

      <div class="date-top-margin">
        <span class="alarm-update-date">00월 00일</span>
        <span class="alarm-list-delete-all">모두 지우기</span>
      </div>
      <hr>

      <section class="alarm-list">
        <img src="/image//icon/human.svg" class="member-profile">

        <div class="alarm-title">상품 찜</div>
        <div class="alarm-description">은비님이 회원님의 상품을 찜 하였습니다.</div>
        <div class="product-img-wrap">
          <img src="/image/product-img.jpg" class="alarm-img">
        </div>
      </section>

    </section>

    <!-- 덕템톡 알림 -->
    <section class="d-none chatting-alarm-container">
      <div class="chatting-alarm-title-wrap">
        <h1>덕템톡</h1>
        <div>
          <img src="/image/icon/icon-close.svg" class="chatting-alarm-close">
        </div>
      </div>

      <hr>

      <div>
        <span class="chatting-alarm-update-date">00월 00일</span>
        <span class="chatting-alarm-list-delete-all">모두 지우기</span>
      </div>
      <hr>

      <section class="chatting-alarm-list">
        <div class="img-wrap">
          <img src="/image/icon/human.svg" class="chatting-member-profile">
        </div>
        <div class="chatting-alarm-username">은비</div>
        <div class="chatting-alarm-description">팔렸나요?</div>
        <div class="chatting-alarm-time">오후 00:00</div>
        <div class="amount-box">
          <div class="chatting-alarm-amount-wrap">
            <span class="chatting-alarm-amount">2</span>
          </div>
        </div>
      </section>

    </section>



  </header>
</template>

<script>
export default {
  data() {
    return {
      sideBarWrap: false,
      searchBarWrap: false,
      alarmWrap: false
    };
  },
  methods: {
    // side bar
    sideBarOpen() {
      if (!this.sideBarWrap) {
        this.sideBarWrap = true;
      }
      else if (this.sideBarWrap) {
        this.sideBarWrap = false;
      }
    },

    searchBarOpen() {
      if (!this.searchBarWrap) {
        this.sideBarWrap = false;
        this.alarmWrap = false;
        this.searchBarWrap = true;
      }
      else if (this.searchBarWrap) {
        this.searchBarWrap = false;
      }
    },
    alarmWrapOpen() {
      if (!this.alarmWrap) {
        this.sideBarWrap = false;
        this.searchBarWrap = false;
        this.alarmWrap = true;
      }
      else if (this.alarmWrap) {
        this.alarmWrap = false;
      }
    }
  },
  computed: {
    goMain() {
      this.$router.push('/');
    },
    goListPage() {
      this.$router.push('/list');
    },
    goHelpCenter() {
      this.$router.push('/help-center');
    },
    goMyPage() {
      this.$router.push('/my-page');
    }

  }
}
</script>

<style>

</style>