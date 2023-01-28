<template>
  <main>


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
      <div>{{ this.productSuperCategoryValue }} : 구현끝나면삭제</div>



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
      superCategoryList: [],
      categoryList:[],
      products: [],
      // ----- 카테고리 inputValue(id로 전송)
      productSuperCategoryValue: "1",
      productCategoryValue: [],
      selectAll: true,

    };
  },


  mounted() {
    this.fetchSuperCategory();
    // this.fetchCategory();
    // this.fetchProducts();
    //this.selectAllSelected();
    // this.fetchProductsByCategory();

  },


  methods: {

    async fetchSuperCategory(){
      const response = await fetch("http://localhost:8080/categorys/super");
      const json = await response.json();
      this.superCategoryList = json;
      await this.fetchCategory()
    },

    async fetchCategory(){
      const response = await fetch(`http://localhost:8080/categorys?s=${this.productSuperCategoryValue}`);
      const json = await response.json();
      this.categoryList = json;
      for (let i = 0; i < this.categoryList.length; i++)
        this.productCategoryValue.push(this.categoryList[i].id)
      await this.fetchProductsByCategory();
    },

    // async fetchProducts() {
    //   const response = await fetch(`http://localhost:8080/products`);
    //   const json = await response.json();
    //   this.products = json;
    //
    // },

    async fetchProductsByCategory() {

      const response = await fetch(`http://localhost:8080/products/category?c=${this.productCategoryValue}`);
      const json = await response.json();
      this.products = json;

    },




    //----- 카테고리 대분류 선택 시 소분류 보여지는 함수
    superCategorySelected() {
      this.productCategoryValue = [];
      this.selectAll=true;
      this.fetchCategory();

    },

    categorySelected() {
      if (this.productCategoryValue)
        this.selectAll = false;
      this.fetchProductsByCategory()
    },

     selectAllSelected(){
      console.log(this.categoryList);
      if(this.selectAll) {
        this.productCategoryValue=[];
        for (let i = 0; i < this.categoryList.length; i++)
          this.productCategoryValue.push(this.categoryList[i].id)
         this.fetchProductsByCategory()
      }
      else
        this.productCategoryValue=[];
       this.fetchProductsByCategory()


    }


  }
}
</script>

<style scoped>
@import '/css/list.css';
</style>