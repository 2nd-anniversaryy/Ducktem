<template>
  <main class="main">

    <div class="background">

      <section class="wizard-header">
        <h1 class="d-none">위자드 인덱스</h1>
        <span class="line"></span>
        <span class="wizard" v-bind:class="{ first: isFirst }"> <span class="wizard-index">1</span></span>
        <span class="wizard" v-bind:class="{ second: isSecond }"><span class="wizard-index">2</span></span>
        <span class="wizard" v-bind:class="{ third: isThird }"><span class="wizard-index">3</span></span>
        <span class="wizard" v-bind:class="{ fourth: isFourth }"><span class="wizard-index">4</span></span>
      </section>


      <section class="main-wrap">
        <h1 class="d-none">상품 등록 form</h1>


        <!--    ==============    폼시작   ================= -->
        <form class="reg-form" method="post" enctype="multipart/form-data">

          <!-- ==========================================================-->
          <!-- ====================     1번 페이지    ==================== -->
          <!-- ==========================================================-->
          <section id="one" class="reg" v-if="firstPage">
            <h1 class="d-none">상품 정보 form</h1>
            <div class="reg1">

              <div class="title">상품 정보를 입력해주세요</div>



              <!-- ==============================   이미지 입력란 입니다.(미완성)   =============================== -->
              <div class="input-container">
                <div class="input-title">상품 이미지</div>

                <div class="input-box-container">
                  <div class="input-box">
                    <span class="thumbNail-title">대표 이미지</span>
                    <input class="d-none file-input" id="img" name="files" type="file" accept="image/*" required v-on="fileChange"/>
                    <img class="img-input thumbNail" src="/image/icon/icon-image.svg" alt="" @click="imageUpload">
                    <span class="img-delete thumbNail d-none" @click="imageDelete"></span>
                  </div>
                  <div class="input-box" v-for="i in this.imageInputs">
<!--                  <div class="input-box" >-->
                    <input class="d-none file-input" id="img" name="files" type="file" accept="image/*" v-on="fileChange">
                    <img class="img-input " src="/image/icon/icon-image.svg" alt="" @click="imageUpload">
                    <span class="img-delete d-none" @click="imageDelete"></span>
                  </div>

<!--                  <div class="input-box" >-->
<!--                    <input class="d-none file-input" id="img" name="files" type="file" accept="image/*"  @change="fileChange">-->
<!--                    <img class="img-input " src="/image/icon/icon-image.svg" alt="" @click="imageUpload">-->
<!--                    <span class="img-delete d-none" @click="imageDelete"></span>-->
<!--                  </div>-->

                </div>

                <div class="img-count">
                  <span class="img-num">{{this.imageCount}}</span> <span>/4</span>
                </div>
              </div>



              <!-- ==============================   상품 제목 입력란입니다.   =============================== -->
              <div>
                <label class="input-title" for="title">상품 제목</label>
                <input v-model="this.productTitle" class="input-default" id="title" name="name" type="text" required placeholder="제목을 입력해 주세요.">
              </div>

              <!-- ==============================   상품 가격 입력란입니다.   =============================== -->
              <div class="price-container">
                <label class="input-title" for="price">상품 가격</label>
                <input v-model="this.productPrice"  class="input-default inline" id="price" name="price" type="number" required  placeholder="가격을 입력해 주세요.">
                <span class="input-detail">원</span>
              </div>

              <div class="btn-container">
                <router-link to="/"><div id="quit-reg" class="btn btn-cancel" >취소</div></router-link>
                <div id="first-click" class="btn btn-default" @click="toggle1">다음</div>
              </div>


            </div>
          </section>



          <!-- ==========================================================-->
          <!-- ====================     2번 페이지    ==================== -->
          <!-- ==========================================================-->

          <section id="two" class="reg" v-if="secondPage">
            <h1 class="d-none">상품 설명 form</h1>
            <div class="reg2">


              <div class="title">상품 설명을 입력해주세요</div>

              <!-- ==============================   카테고리 선택란입니다.   =============================== -->

              <div>
                <label for="category" class="input-title" >카테고리를 선택해주세요</label>
                <div @click="superCategorySelect" class="input-default category-select category-input" >
                  {{ this.categoryResult }}
                </div>
                <input class="input-default category-select" v-model="this.categoryValue" id="category" name="category" type="hidden">

                <!-- =====   카테고리 대분류 모달   ====== -->
                <div v-if="superCategoryModal" class="supercategory-select">
                  <div class="category-title">카테고리 선택</div>
                  <img class="exit" src="/image/icon/icon-close.svg" alt="" @click="modalClose">

                  <div v-for="(s,index) in superCategoryList">
                    <input v-bind:value="s" v-bind:id="index+1" name="supercategory" type="radio" required  v-model="this.productSuperCategoryValue" @change="superRadioChange($event)">
                    <label class="category-select" v-bind:for="index+1"  >{{ s }}</label>
                  </div>

                  <div class="btn btn-default next-btn" @click="superCategorySelected">다음</div>
                </div>

                <!-- =====   카테고리 소분류 > 공식굿즈 모달  ====== -->
                <div class="subcategory-select " v-if="CategoryModal1">
                  <div class="category-supercategory">{{ this.productSuperCategoryValue }}</div>
                  <div class="category-title">하위 카테고리 선택</div>
                  <img class="exit" src="/image/icon/icon-close.svg" alt="" @click="modalClose">
                  <div v-for="c in categoryList1">
                    <input v-bind:value="c.name" v-bind:id="c.id" name="categoryId" type="radio" v-model="this.productCategoryValue" required @change="radioChange($event)">
                    <label class="category-select" v-bind:for="c.id">{{ c.name }}</label>
                  </div>
                  <div class="btn btn-default next-btn final" @click="categorySelected">선택완료</div>
                </div>


                <!-- =====   카테고리 소분류 > 비공식굿즈 모달  ====== -->
                <div class="subcategory-select" v-if="CategoryModal2">
                  <div class="category-supercategory">{{ this.productSuperCategoryValue }}</div>
                  <div class="category-title">하위 카테고리 선택</div>
                  <img class="exit" src="/image/icon/icon-close.svg" alt="" @click="modalClose">

                  <div  v-for="c in categoryList2">
                    <input v-bind:value="c.name" v-bind:id="c.id" name="categoryId" type="radio" v-model="this.productCategoryValue" required @change="radioChange($event)">
                    <label class="category-select" v-bind:for="c.id">{{ c.name }}</label>
                  </div>

                  <div class="btn btn-default next-btn final" @click="categorySelected">선택완료</div>
                </div>

                <!-- =====   카테고리 소분류 > 대리티켓팅 모달   ====== -->
                <div class="subcategory-select" v-if="CategoryModal3">
                  <div class="category-supercategory">{{ this.productSuperCategoryValue }}</div>
                  <div class="category-title">하위 카테고리 선택</div>
                  <img class="exit" src="/image/icon/icon-close.svg" alt="" @click="modalClose">
                  <div  v-for="c in categoryList3">
                    <input v-bind:value="c.name" v-bind:id="c.id" name="categoryId" type="radio" v-model="this.productCategoryValue" required @change="radioChange($event)">
                    <label class="category-select" v-bind:for="c.id">{{ c.name }}</label>
                  </div>

                  <div class="btn btn-default next-btn final" @click="categorySelected">선택완료</div>
                </div>

              </div>

              <!-- ==============================   상품 상세 설명 입력란 입니다.   =============================== -->
              <div>
                <label for="description" class="input-title">상품설명</label>
                <textarea class="input-default input-description" id="description"
                          name="description" type="text" required placeholder="설명을 입력해 주세요." v-model="this.productDescription"></textarea>
              </div>

              <div class="btn-container">
                <div id="second-back" class="btn btn-cancel" @click="toggle1">취소</div>
                <div id="second-click" class="btn btn-default" @click="toggle2">다음</div>
              </div>


            </div>

          </section>




          <!-- ==========================================================-->
          <!-- ====================     3번 페이지    ==================== -->
          <!-- ==========================================================-->
          <section id="third" class="reg" v-if="thirdPage">
            <h1 class="d-none">컨디션&태그 form</h1>
            <div class="reg3">


              <div class="title">컨디션과 태그를 입력해주세요</div>

              <!-- ==============================   상품 상태 입력란 입니다.   =============================== -->
              <div class="reg3-condition-container">
                <div class="input-title">상품 컨디션</div>
                <sapn v-for="condition in conditionList">
                <input v-bind:value="condition.name" v-bind:id="condition.id" name="condition" v-model="this.productConditionValue" type="radio" required>
                <label class="btn reg-btn" v-bind:for="condition.id">{{ condition.name }}</label>
                </sapn>

              </div>

              <!-- ==============================   상품 태그 입력란 입니다. (미완성)  =============================== -->
              <div class="reg3-tag-container">
                <label for="tag" class="input-title">상품 태그</label>
                <div>
                  <input class="input-default tag-input" id="tag" name="tag-input"
                         type="text" placeholder="태그를 입력해 주세요." v-model="newTag">
                  <div class="btn btn-default btn-add"  @click="addTag">추가</div>
                </div>
                <div class="tag-box">
                  <span v-for="t in this.tagList">
                  <div class="btn btn-tag tag-default">{{ t.name }}</div>
                  <input class="tag-hiddenBox" type="hidden" name="tag" v-model="t.name" />
                  </span>

                </div>

              </div>



              <div class="btn-container">
                <div id="third-back" class="btn btn-cancel"  @click="toggle2">취소</div>
                <div id="third-click" class="btn btn-default" @click="toggle3">다음</div>
              </div>


            </div>
          </section>









          <!-- ==========================================================-->
          <!-- ====================     4번 페이지    ==================== -->
          <!-- ==========================================================-->
          <section id="four" class="reg" v-if="fourthPage">
            <h1 class="d-none">배송 방법 form</h1>
            <div class="reg4">

              <!-- ==============================   상품 배송 방법 입력란 입니다.   =============================== -->
              <div class="title">상품 배송 방법을 선택해주세요.</div>


              <div>
                <div v-for="d in this.deliveryTypeList">
                  <input v-bind:value="d.name" class="" v-bind:id="d.id" name="deliveryType" type="radio" v-model="this.productDeliveryTypeValue" required>
                  <label v-bind:for="d.id" class="delivery-label general-mail">
                    <span class="label-box">
                      <span class="delivery-icon">{{d.logo}}</span>
                      <span class="delivery-name">{{ d.name }}</span>
                    </span>
                  </label>
                </div>
              </div>





              <div class="btn-container">
                <div id="fourth-back" class="btn btn-cancel" href="" @click="toggle3">취소</div>
                <button class="btn btn-default sell-btn" >등록 완료</button>
              </div>

              <!-- ==================================================     폼 끝   ================================================== -->

            </div>
          </section>


        </form>


      </section>
    </div>
  </main>

</template>

<script>
let id = 0

export default {

  data() {
    return {
      //====================     1번 페이지    ====================
      //이미지 입력을 위한 변수
      uploadReady : true,
      imageCount: 0,
      imageInputs : 3,
      imageInput1 : null,
      imageInput2: null,
      //----- 이미지 inputValue(미완성)

      //----- 상품 제목 inputValue
      productTitle:null,

      //----- 상품 가격 inputValue
      productPrice: null,

      //====================     2번 페이지    ====================
      //카테고리 선택
      categoryResult: "카테고리를 선택해주세요.",
      superCategoryModal: false,
      CategoryModal1: false,
      CategoryModal2: false,
      CategoryModal3: false,


      //반복문 돌리기 위한 Data get
      superCategoryList:["공식굿즈","비공식굿즈","대리티켓팅"],
      categoryList1:[{name:"음반/영상물", id:1},{name:"응원도구", id:2}, {name:"포토카드", id:3}, {name:"포스터/포토북", id:4}, {name:"문구류",id:5}, {name:"기타잡화",id:6}],
      categoryList2:[{name:"영상물",id:7}, {name:"응원도구",id:8}, {name:"인형",id:9}, {name:"포토카드",id:10}, {name:"포스터/포토북",id:11}, {name:"문구류",id:12}, {name:"기타잡화",id:13}],
      categoryList3:[{name:"능력을 사요",id:14}, {name:"능력을 팔아요",id:15}],

      // ----- 카테고리 inputValue(name으로 전송됩니다)
      productSuperCategoryValue : null,    //(ex: 공식굿즈)
      productCategoryValue: null,          //(ex: 능력을 팔아요)

      // ----- 상품 상세 설명 inputValue
      productDescription : null,



      //====================     3번 페이지    ====================
      //상품상태
      conditionList:[{name:"미개봉", id:1},{name:"거의새상품", id:2},{name:"사용감있는깨끗한상품", id:3},{name:"사용흔적이있는상품", id:4},{name:"하자가있는상품", id:5}],
      // ----- 상품상태 inputValue
      productConditionValue: null,

      //태그
      newTag:null,
      // ----- 상품태그 inputValue (tagList의 key값이 name으로 저장되어있습니다)
      tagList:[],




      //====================     4번 페이지    ====================
      deliveryTypeList:[{name:"일반우편",id:1,logo:"📮"},{name:"준등기", id:2,logo:"✉️"},{name:"택배", id:3,logo:"📦"}],
      // ----- 배송방법 inputVlaue
      productDeliveryTypeValue: null,




      //  페이지 전환을 위한 변수
      firstPage: true,
      secondPage: false,
      thirdPage: false,
      fourthPage: false,
      isFirst: true,
      isSecond: false,
      isThird: false,
      isFourth: false,

    }
  },
  methods: {
    // ====================     1번 페이지    ====================
    //--이미지 등록 함수
    imageUpload(e){

      let event = new MouseEvent("click", {
        'view': window,
        'bubbles': true,
        'cancelable': true
      });
      let fileInput = e.target.previousElementSibling;

      fileInput.dispatchEvent(event);

      fileInput.oninput = function () {

        let url = fileInput.files[0];

        let reader = new FileReader();
        reader.onload = (evt) => {


          e.target.src = evt.target.result;

        }
        reader.readAsDataURL(url);

        let imgDelete = e.target.nextElementSibling;
        console.log(imgDelete);
        imgDelete.classList.remove("d-none");


      }
      this.imageCount++;

    },

    fileChange(e){
      this.imageInput1=null;

    },

    imageDelete(e){

      this.fileChange();




      // const imgInputBoxContainer = document.querySelector(".input-box-container");
      let imgDelete = e.target;
      //
      imgDelete.parentElement.remove();
      // imgInputBoxContainer.insertAdjacentHTML("beforeend", FileInput);



      this.imageCount--;
      this.imageInputs++;
      console.log(this.imageInputs);
    },

    change() {
      console.log('filechange');
    },


    // <!-- ====================     2번 페이지    ==================== -->
    //--카테고리 선택을 위한 함수
    superCategorySelect(){
      this.superCategoryModal = true;
    },
    modalClose(){
      this.superCategoryModal = false;
      this.CategoryModal1 = false;
      this.CategoryModal2 = false;
      this.CategoryModal3 = false;
    },

    superCategorySelected(){
      if(this.productSuperCategoryValue){
        this.superCategoryModal = false;
        this.productCategoryValue = null;

        switch (this.productSuperCategoryValue) {
          case "공식굿즈":
            this.CategoryModal1 = true;
            break;
          case "비공식굿즈":
            this.CategoryModal2 = true;
            break;
          case "대리티켓팅":
            this.CategoryModal3 = true;
            break;
        }
      }
    },

    categorySelected(){
      if(this.productCategoryValue != null) {
        this.CategoryModal1 = false;
        this.CategoryModal2 = false;
        this.CategoryModal3 = false;
        this.categoryResult = this.productSuperCategoryValue + ' > ' + this.productCategoryValue;
      }
    },






    // <!-- ====================     3번 페이지    ==================== -->
    //태그
    addTag() {
      let blankPattern = /^\s+|\s+$/g;

      if(!this.newTag|| (this.newTag.replace(blankPattern, '' ) == "")){
        alert("공백이 입력되었습니다.")
        return;
      }

      if(id < 5) {
        this.tagList.push({id: id++, name: this.newTag})
        this.newTag = ''
        console.log(id);
      }
      else
        alert("태그는 5개까지만입력 가능합니다.")
        this.newTag = ''



    },

    // <!-- ====================     4번 페이지    ==================== -->








    //  페이지 전환을 위한 함수
    toggle1() {
      this.firstPage = !this.firstPage
      this.secondPage = !this.secondPage

      this.isFirst = !this.isFirst
      this.isSecond = !this.isSecond
    },
    toggle2() {
      this.secondPage = !this.secondPage
      this.thirdPage = !this.thirdPage

      this.isSecond = !this.isSecond
      this.isThird = !this.isThird
    },
    toggle3() {
      this.thirdPage = !this.thirdPage
      this.fourthPage = !this.fourthPage

      this.isThird = !this.isThird
      this.isFourth = !this.isFourth
    },


  }


}
</script>

<style scoped>
@import '/css/member/sell/index.css';
</style>



