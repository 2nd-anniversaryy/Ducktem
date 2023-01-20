



<template>
    <main>


        <section>
            <!-- class="category" -->
            <h1 class="d-none">카테고리</h1>
            <section class="supercategory">
                <h1 class="d-none">대분류</h1>
                <span><a href="">공식굿즈 </a></span>
                <span><a href="">비공식굿즈</a></span>
                <span><a href="">대리티켓팅</a></span>
            </section>

            <section class="subcategory">
                <h1 class="d-none">소분류</h1>
                <input type="checkbox" name="" id="1-btn"><label class="btn btn-default aaa" for="1-btn">전체보기</label>
                <input type="checkbox" name="" id="2-btn"><label class="btn btn-default aaa" for="2-btn">음반/영상물</label>
                <input type="checkbox" name="" id="3-btn"><label class="btn btn-default aaa" for="3-btn">응원도구</label>
                <input type="checkbox" name="" id="4-btn"><label class="btn btn-default aaa" for="4-btn">포토카드</label>
                <input type="checkbox" name="" id="5-btn"><label class="btn btn-default aaa" for="5-btn">포스터/포토북</label>
                <input type="checkbox" name="" id="6-btn"><label class="btn btn-default aaa" for="6-btn">문구류</label>
                <input type="checkbox" name="" id="7-btn"><label class="btn btn-default aaa" for="7-btn">기타잡화</label>
            </section>

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

                    <div class="product-container">
                        <div><img src="/image/example-image0.png" alt="product-img"></div>

                        <div class="price-wish">
                            <span> 80,000원</span>
                            <img src="/image/icon/heart.svg" alt="찜">
                        </div>

                        <div class="name">
                            러브다이브미공포
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
  data(){
    return{
      products: [],
      superCategorys: [],
      categorys: []
    };
  },

  methods: {

    async fetchSuperCategory(){

      const response = await fetch("http://localhost:8080/")

    }

  }
}
</script>

<style scoped>
@import '/css/list.css';
</style>