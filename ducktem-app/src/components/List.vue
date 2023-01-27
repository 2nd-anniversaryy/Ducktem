<template>
  <main>


    <section>

      <h1 class="d-none">카테고리</h1>
      <section class="supercategory">
        <h1 class="d-none">대분류</h1>

        <span v-for="s in this.superCategoryList">
                <input v-bind:value="s.id" v-model="this.productSuperCategoryValue" type="radio" name="superCategory"
                       v-bind:id="s.name" @change="superCategorySelected">
                <label v-bind:for="s.name">{{ s.name }}</label>
              </span>
      </section>
      <div>{{ this.productSuperCategoryValue }} : 구현끝나면삭제</div>

      <section class="subcategory">
        <h1 class="d-none">소분류</h1>

        <input type="checkbox" name="selectAll" v-model="this.selectAll" id="selectAll" @change="superCategorySelected"><label
          class="btn btn-default aaa" for="selectAll">전체보기</label>

        <span v-for="category in this.categoryList1" v-if="this.isOfficialGoods">
                <input v-bind:value="category.id" v-model="this.productCategoryValue" type="checkbox" name="category"
                       v-bind:id="category.id" @change="categorySelected">
                <label class="btn btn-default aaa" v-bind:for="category.id">{{ category.name }}</label>
              </span>

        <span v-for="category in this.categoryList2" v-if="this.isUnOfficialGoods">
                <input v-bind:value="category.id" v-model="this.productCategoryValue" type="checkbox" name="category"
                       v-bind:id="category.id" @change="categorySelected">
                <label class="btn btn-default aaa" v-bind:for="category.id">{{ category.name }}</label>
              </span>

        <span v-for="category in this.categoryList3" v-if="this.isTicketing">
                <input v-bind:value="category.id" v-model="this.productCategoryValue" type="checkbox" name="category"
                       v-bind:id="category.id" @change="categorySelected">
                <label class="btn btn-default aaa" v-bind:for="category.id">{{ category.name }}</label>
              </span>


      </section>
      <div>{{ this.productCategoryValue }} : 구현끝나면삭제</div>

    </section>



    <div class="option">

      <select>
        <option value="">최신순</option>
        <option value="">높은 가격순</option>
        <option value="">낮은 가격순</option>
        <option value="">인기상품순</option>
      </select>
    </div>

    <section class="product-list">
      <h1 class="d-none">상품목록</h1>


      <div class="product-flex">
        <div class="product-wrap">

          <div class="product-container" v-for="product in this.products">
            <div><img src="/image/example-image0.png" alt="product-img"></div>

            <div class="price-wish">
              <span> {{ product.price }}원</span>
              <img src="/image/icon/heart.svg" alt="찜">
            </div>

            <div class="name">
              {{ product.name }}
            </div>

            <div class="time">
              0일 전
            </div>
          </div>


        </div>
      </div>

    </section>

  </main>
</template>

<script>
export default {
  data() {
    return {
      //DB에서 받으면 수정할 예정.
      superCategoryList: [{name: "공식굿즈", id: 1}, {name: "비공식굿즈", id: 2}, {name: "대리티켓팅", id: 3}],
      categoryList1: [{name: "음반/영상물", id: 1}, {name: "응원도구", id: 2}, {name: "포토카드", id: 3}, {
        name: "포스터/포토북",
        id: 4
      }, {name: "문구류", id: 5}, {name: "기타잡화", id: 6}],
      categoryList2: [{name: "영상물", id: 7}, {name: "응원도구", id: 8}, {name: "인형", id: 9}, {
        name: "포토카드",
        id: 10
      }, {name: "포스터/포토북", id: 11}, {name: "문구류", id: 12}, {name: "기타잡화", id: 13}],
      categoryList3: [{name: "능력을 사요", id: 14}, {name: "능력을 팔아요", id: 15}],

      // ----- 카테고리 inputValue(id로 전송)
      productSuperCategoryValue: "1",
      productCategoryValue: [],

      // //--------------데이터 받아오기=========================================
      products: 10,
      // superCategorys: [],
      // categorys: [],
      // //--------------데이터 받아오기=========================================
      isCategoryChecked: false,


      isOfficialGoods: true,
      isUnOfficialGoods: false,
      isTicketing: false,


      //--임시
      selectAll: true,
      query:"",

    };
  },

  mounted() {
    this.fetchProducts();
  },

  methods: {

    async fetchProducts() {
      const response = await fetch(`http://localhost:8080/products`);
      const json = await response.json();
      this.products = json;
      console.log(this.products);
    },

    async fetchProductsByCategory() {
      const response = await fetch(`http://localhost:8080/products/category?c=${this.productCategoryValue}`);
      const json = await response.json();
      this.products = json;
      console.log(this.products);
    },

    // async fetchSuperCategory(){
    //   const response = await fetch("http://localhost:8080/");
    //   const json = await response.json();
    //   this.superCategorys = json;
    // },
    //
    // async fetchCategory(){
    //   const response = await fetch("http://localhost:8080/");
    //   const json = await response.json();
    //   this.categorys = json;
    // },


    //----- 카테고리 대분류 선택 시 소분류 보여지는 함수
    superCategorySelected() {
      this.productCategoryValue = [];

      switch (this.productSuperCategoryValue) {

        case 1:
          this.isOfficialGoods = true;
          this.isUnOfficialGoods = false;
          this.isTicketing = false;
          break;

        case 2:
          this.isOfficialGoods = false;
          this.isUnOfficialGoods = true;
          this.isTicketing = false;
          break;

        case 3:
          this.isOfficialGoods = false;
          this.isUnOfficialGoods = false;
          this.isTicketing = true;
          break;

      }
    },

    categorySelected() {
      if (this.productCategoryValue)
        this.selectAll = false;
      this.fetchProductsByCategory()
    }


  }
}
</script>

<style scoped>
@import '/css/list.css';
</style>