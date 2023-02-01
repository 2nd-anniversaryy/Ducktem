<template>
  <main>
    <div class="update-product-title">
      <h1>상품 수정</h1>
    </div>

    <form class="update-product-wrap">
      <div class="update-product-img">
        <div>상품 이미지</div>
        <div>
          <input type="image" src="/image/빈-상품이미지.png" alt="" />
        </div>
      </div>

      <div class="update-product-titlein">
        <div>상품 제목</div>
        <div>
          <input type="text" name="" id="" />
        </div>
      </div>

      <div class="update-product-price">
        <div>가격</div>
        <div>
          <input type="number" name="" id="" />
        </div>
      </div>

      <div class="update-product-category">
        <div>카테고리</div>
        <div>
          <p></p>
        </div>
      </div>

      <div class="update-product-explain">
        <div>상품 설명</div>
        <div>
          <input type="text" name="" id="" />
        </div>
      </div>

      <div class="update-product-condition">
        <div>상품 컨디션</div>
        <div class="check-condition-wrap">
          <input type="radio" name="condition" id="first-btn" /><label class="btn btn-cancel" for="first-btn">미개봉</label>
          <input type="radio" name="condition" id="second-btn" /><label class="btn btn-cancel" for="second-btn">거의 새상품</label>
          <input type="radio" name="condition" id="third-btn" /><label class="btn btn-cancel" for="third-btn">사용흔적이 있는 상품</label>
          <input type="radio" name="condition" id="forth-btn" /><label class="btn btn-cancel" for="forth-btn">하자가 있는 상품</label>
        </div>
      </div>

      <div class="update-product-tag">
        <div>태그</div>
        <div><input type="text" /><input class="btn btn-default" type="submit" value="추가" /></div>
        <div></div>
        <div>
          <span class="btn btn-tag">테스트</span>
          <span class="btn btn-tag">테스트</span>
          <span class="btn btn-tag">테스트</span>
        </div>
      </div>

      <div class="update-product-delivery">
        <div>배송방법</div>
        <div class="delivery-img">
          <input type="radio" name="delivery" id="1" /><label class="delivery1" for="1"><span>📮</span><span>일반우편</span></label>
          <input type="radio" name="delivery" id="2" /><label class="delivery2" for="2"><span>✉️</span><span>준등기</span></label>
          <input type="radio" name="delivery" id="3" /><label class="delivery3" for="3"><span>📦</span><span>택배</span></label>
        </div>
      </div>

      <div class="update-product-btn">
        <input class="btn btn-default" type="submit" value="상품 삭제" />
        <input class="btn btn-default" @click="fetchUpdateMyproduct($route.params)" type="submit" value="상품 수정" />
      </div>
    </form>
  </main>
</template>

<script>
export default {
  data() {
    return {
      myInfoList: [],
      confirmPwd: null,
      e: false,
      profileImage: null,
    };
  },
  mounted() {
    this.fetchGetMyInfo();
  },
  watch: {},
  methods: {
    changeMyProfile(event) {
      this.profileImage = event.target.files[0];
    },
    // async fetchGetMyInfo() {
    //   try {
    //     const response = await fetch('http://localhost:8080/members/me', {
    //       headers: {
    //         Authorization: 'Bearer ' + this.$store.state.tokenResponse.access,
    //       },
    //     });
    //     const json = await response.json();
    //     this.myInfoList = json;
    //   } catch (e) {
    //     this.e = e;
    //   } finally {
    //   }
    // },
    async fetchUpdateMyproduct(id) {
      let formData = new FormData();
      formData.append('nickName', this.myInfoList.nickName);
      formData.append('intro', this.myInfoList.intro);
      formData.append('email', this.myInfoList.email);
      formData.append('profileUrl', this.profileImage);

      console.log(this.$store.state.tokenResponse.access);
      try {
        const response = await fetch(`http://localhost:8080/products/${id}`, {
          method: 'PUT',
          body: formData,
        }).then(console.log(response));
      } catch (e) {
        this.e = e;
      } finally {
      }
    },
    goToLeave() {
      this.$router.push('leave');
    },
  },
};
</script>

<style scoped>
@import '/css/member/update-product/index.css';
</style>
