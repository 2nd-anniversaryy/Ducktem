<template>
    <main>
        <section class="search-result-wrap">
            <h1 class="d-none">검색결과</h1>
            <div>
                <span class="search-result">{{ this.searchQueryName }}</span><span>의 검색결과 {{this.searchQueryCount}}건</span>
            </div>
        </section>

      <section>
        <h1 class="d-none">카테고리</h1>
        <section class="supercategory">
          <h1 class="d-none">대분류</h1>

          <span v-for="s in this.superCategoryList">
                <input v-bind:value="s.id" v-model="this.productSuperCategoryValue" type="radio" name="superCategory"
                       v-bind:id="s.name" @change="superCategorySelected">
                <label v-bind:for="s.name" >{{ s.name }}</label>
          </span>
        </section>


        <section class="subcategory">
          <h1 class="d-none">소분류</h1>

          <input type="checkbox" name="selectAll" v-model="this.selectAll" id="All" @change="this.selectAllSelected">
          <label class="btn btn-default aaa" for="All" >전체보기</label>

          <span v-for="category in this.categoryList" >
                <input v-bind:value="category.id" v-model="this.productCategoryValue" type="checkbox" name="category"
                       v-bind:id="category.id" @change="categorySelected">
                <label class="btn btn-default aaa" v-bind:for="category.id">{{ category.name }}</label>
              </span>

        </section>


        </section>
      <!-- ====================     임시 검색창 입니다. 삭제 예정     ==================== -->
      <section style="border: 1px solid black; background-color: white; border-radius: 20px; width: 300px; padding: 10px;
      position: fixed; bottom: 0px; right:0; z-index: 999; display: flex; flex-direction: column; align-items: center;">
        <div style="text-align: center">구현끝나면삭제예정</div>
        <div>
          <div>대분류 : {{ this.productSuperCategoryValue }} </div>
          <div>소분류 : {{ this.productCategoryValue }} </div>
          <div>
            <input placeholder="임시검색창" v-model="this.query"/>
            <input class="btn btn-default aaa" type="button" value="검색하기" @click.prevent="this.onSearch"/>
          </div>
        </div>
      </section>
      <!-- =========================================================================== -->

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
      superCategoryList: [],
      categoryList:[],
      products: [],
      // ----- 카테고리 inputValue(id로 전송)
      productSuperCategoryValue: "1",
      productCategoryValue: [],
      selectAll: true,

      query:"",
      searchQueryName:"",
      searchQueryCount:"",

    };
  },

  mounted() {
    this.fetchSuperCategory();
  },

  methods: {
    //----- 카테고리 대분류 반환.(아래 카테고리 소분류 반환실행)
    async fetchSuperCategory(){
      const response = await fetch("http://localhost:8080/categorys/super");
      const json = await response.json();
      this.superCategoryList = json;
      await this.fetchCategory();
    },
  //----- 카테고리 소분류 반환.(아래 검색결과 상품목록 반환함수 실행)
    async fetchCategory(){
      const response = await fetch(`http://localhost:8080/categorys?s=${this.productSuperCategoryValue}`);
      const json = await response.json();
      this.categoryList = json;
      for (let i = 0; i < this.categoryList.length; i++)
        this.productCategoryValue.push(this.categoryList[i].id);
      await this.fetchProductsBySearch();
    },
  //----- 검색결과 상품목록 반환
    async fetchProductsBySearch() {
      const response = await fetch(`http://localhost:8080/products/searchByCategory?q=${this.query}&c=${this.productCategoryValue}`);

      const json = await response.json();

      this.products = json['productResult'];
      this.searchQueryCount = json['countResult'];
      console.log();
    },

    onSearch(){
      this.fetchProductsBySearch();
      this.searchQueryName = this.query;
    },


    //----- 카테고리 대분류 선택 시 소분류목록 반환
    superCategorySelected() {
      this.productCategoryValue = [];
      this.selectAll=true;
      this.fetchCategory();

    },
    //----- 카테고리 소분류 선택 시 상품 목록 반환
    categorySelected() {
      if (this.productCategoryValue)
        this.selectAll = false;
      this.fetchProductsBySearch();
    },
    //----- 전체선택시 상품 목록 반환
    selectAllSelected(){
      console.log(this.categoryList);
      if(this.selectAll) {
        this.productCategoryValue=[];
        for (let i = 0; i < this.categoryList.length; i++)
          this.productCategoryValue.push(this.categoryList[i].id);
        this.fetchProductsBySearch();
      }
      else
        this.productCategoryValue=[];
      this.fetchProductsBySearch();
    }

  }
}
</script>

<style scoped>
@import '/css/list.css';
</style>