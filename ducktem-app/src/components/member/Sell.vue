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


        <!-- ==================================================     폼시작   ================================================== -->
        <form class="reg-form" method="post" enctype="multipart/form-data">

          <!-- ==========     1번 페이지    ========== -->
          <section id="one" class="reg" v-if="firstPage">
            <h1 class="d-none">상품 정보 form</h1>
            <div class="reg1">

              <div class="title">상품 정보를 입력해주세요</div>

              <div class="input-container">
                <div class="input-title">상품 이미지</div>

                <div class="input-box-container">
                  <div class="input-box">
                    <span class="thumbNail-title">대표 이미지</span>
                    <input class="d-none file-input" id="img" name="files" type="file" accept="image/*" required @change="fileChange"/>
                    <img class="img-input thumbNail" src="/image/icon/icon-image.svg" alt="" @click="imageUpload">
                    <span class="img-delete thumbNail d-none" @click="imageDelete"></span>
                  </div>
                  <div class="input-box">
                    <input class="d-none file-input" id="img" name="files" type="file" accept="image/*">
                    <img class="img-input " src="/image/icon/icon-image.svg" alt="" @click="imageUpload">
                    <span class="img-delete d-none" @click="imageDelete"></span>
                  </div>
                  <div class="input-box">
                    <input class="d-none file-input" id="img" name="files" type="file" accept="image/*">
                    <img class="img-input " src="/image/icon/icon-image.svg" alt="" @click="imageUpload">
                    <span class="img-delete d-none" @click="imageDelete"></span>
                  </div>
                  <div class="input-box">
                    <input class="d-none file-input" id="img" name="files" type="file" accept="image/*">
                    <img class="img-input " src="/image/icon/icon-image.svg" alt="" @click="imageUpload">
                    <span class="img-delete d-none" @click="imageDelete"></span>
                  </div>
                </div>

                <div class="img-count">
                  <span class="img-num">{{this.imageCount}}</span> <span>/4</span>
                </div>
              </div>

              <div>
                <label class="input-title" for="title">상품 제목</label> <input value=""
                                                                            class="input-default" id="title" name="name" type="text" required
                                                                            placeholder="제목을 입력해 주세요.">
              </div>

              <div class="price-container">
                <label class="input-title" for="price">상품 가격</label> <input value=""
                                                                            class="input-default inline" id="price" name="price" type="number" required
                                                                            placeholder="가격을 입력해 주세요."><span class="input-detail">원</span>
              </div>

              <div class="btn-container">
                <router-link to="/"><div id="quit-reg" class="btn btn-cancel" >취소</div></router-link>
                <div id="first-click" class="btn btn-default" @click="toggle1">다음</div>
              </div>


            </div>
          </section>








          <!-- ==========     2번 페이지    ========== -->
          <section id="two" class="reg" v-if="secondPage">
            <h1 class="d-none">상품 설명 form</h1>
            <div class="reg2">


              <div class="title">상품 설명을 입력해주세요</div>


              <div>
                <label for="category" class="input-title" >카테고리를 선택해주세요</label>
                <div @click="superCategorySelect" class="input-default category-select category-input" >{{
                    category
                  }}</div>
                <input class="input-default category-select" v-model="this.categoryValue" id="category" name="category" type="hidden">




                <!-- =====   대분류   ====== -->
                <div v-if="superCategoryModal" class="supercategory-select">
                  <div class="category-title">카테고리 선택</div>
                  <img class="exit" src="/image/icon/icon-close.svg" alt="" @click="modalClose">

                  <div>
                    <input value="공식굿즈" id="공식굿즈" name="supercategory" type="radio" required @change="radioChange($event)">
                    <label class="category-select" for="공식굿즈"  >공식굿즈</label>
                  </div>

                  <div>
                    <input value="비공식굿즈" id="비공식굿즈" name="supercategory" type="radio" required @change="radioChange($event)">
                    <label class="category-select" for="비공식굿즈" >비공식굿즈</label>
                  </div>

                  <div>
                    <input value="대리티켓팅" id="대리티켓팅" name="supercategory" type="radio" required @change="radioChange($event)">
                    <label class="category-select" for="대리티켓팅" >대리티켓팅</label>
                  </div>

                  <div class="btn btn-default next-btn" @click="superCategorySelected">다음</div>
                </div>

                <!-- =====   공식굿즈   ====== -->
                <div class="subcategory-select " v-if="CategoryModal1">
                  <div class="category-supercategory">공식굿즈</div>
                  <div class="category-title">하위 카테고리 선택</div>
                  <img class="exit" src="/image/icon/icon-close.svg" alt="" @click="modalClose">
                  <div>
                    <input value="1" id="공식굿즈 > 음반영상물" name="categoryId" type="radio" required @change="radioChange($event)">
                    <label class="category-select" for="공식굿즈 > 음반영상물">음반/영상물</label>
                  </div>

                  <div>
                    <input value="2" id="공식굿즈 > 응원도구" name="categoryId" type="radio" required @change="radioChange($event)">
                    <label class="category-select" for="공식굿즈 > 응원도구">응원도구</label>
                  </div>

                  <div>
                    <input value="3" id="공식굿즈 > 포토카드" name="categoryId" type="radio" required @change="radioChange($event)">
                    <label class="category-select" for="공식굿즈 > 포토카드">포토카드</label>
                  </div>

                  <div>
                    <input value="4" id="공식굿즈 > 포스터포토북" name="categoryId" type="radio" required @change="radioChange($event)">
                    <label class="category-select" for="공식굿즈 > 포스터포토북">포스터/포토북</label>
                  </div>

                  <div>
                    <input value="5" id="공식굿즈 > 문구류" name="categoryId" type="radio" required @change="radioChange($event)">
                    <label class="category-select" for="공식굿즈 > 문구류">문구류</label>
                  </div>

                  <div>
                    <input value="6" id="공식굿즈 > 기타잡화" name="categoryId" type="radio" required @change="radioChange($event)">
                    <label class="category-select" for="공식굿즈 > 기타잡화">기타잡화</label>
                  </div>

                  <div class="btn btn-default next-btn final" @click="categorySelected">선택완료</div>
                </div>


                <!-- =====   비공식굿즈   ====== -->

                <div class="subcategory-select" v-if="CategoryModal2">
                  <div class="category-supercategory">비공식굿즈</div>
                  <div class="category-title">하위 카테고리 선택</div>
                  <img class="exit" src="/image/icon/icon-close.svg" alt="" @click="modalClose">
                  <div>
                    <input value="7" id="비공식굿즈 > 음반영상물" name="categoryId" type="radio" required @change="radioChange($event)">
                    <label class="category-select" for="비공식굿즈 > 음반영상물">음반/영상물</label>
                  </div>

                  <div>
                    <input value="8" id="비공식굿즈 > 응원도구" name="categoryId" type="radio" required @change="radioChange($event)">
                    <label class="category-select" for="비공식굿즈 > 응원도구">응원도구</label>
                  </div>

                  <div>
                    <input value="9" id="비공식굿즈 > 인형" name="categoryId" type="radio" required @change="radioChange($event)">
                    <label class="category-select" for="비공식굿즈 > 인형">인형</label>
                  </div>

                  <div>
                    <input value="10" id="비공식굿즈 > 포토카드" name="categoryId" type="radio" required @change="radioChange($event)">
                    <label class="category-select" for="비공식굿즈 > 포토카드">포토카드</label>
                  </div>

                  <div>
                    <input value="11" id="비공식굿즈 > 포스터포토북" name="categoryId" type="radio" required @change="radioChange($event)">
                    <label class="category-select" for="비공식굿즈 > 포스터포토북">포스터/포토북</label>
                  </div>

                  <div>
                    <input value="12" id="비공식굿즈 > 문구류" name="categoryId" type="radio" required @change="radioChange($event)">
                    <label class="category-select" for="비공식굿즈 > 문구류">문구류</label>
                  </div>

                  <div>
                    <input value="13" id="비공식굿즈 > 기타잡화" name="categoryId" type="radio" required @change="radioChange($event)">
                    <label class="category-select" for="비공식굿즈 > 기타잡화">기타잡화</label>
                  </div>

                  <div class="btn btn-default next-btn final" @click="categorySelected">선택완료</div>
                </div>

                <!-- =====   대리티켓팅   ====== -->
                <div class="subcategory-select" v-if="CategoryModal3">
                  <div class="category-supercategory">대리티켓팅</div>
                  <div class="category-title">하위 카테고리 선택</div>
                  <img class="exit" src="/image/icon/icon-close.svg" alt="" @click="modalClose">
                  <div>
                    <input value="14" id="대리티켓팅 > 능력을사요" name="categoryId" type="radio" required @change="radioChange($event)">
                    <label class="category-select" for="대리티켓팅 > 능력을사요">능력을 사요</label>
                  </div>

                  <div>
                    <input value="15" id="대리티켓팅 > 능력을팔아요" name="categoryId" type="radio" required @change="radioChange($event)">
                    <label class="category-select" for="대리티켓팅 > 능력을팔아요">능력을 팔아요</label>
                  </div>

                  <div class="btn btn-default next-btn final" @click="categorySelected">선택완료</div>
                </div>

              </div>


              <div>
                <label for="description" class="input-title">상품설명</label>
                <textarea value="description" class="input-default input-description" id="description"
                          name="description" type="text" required placeholder="설명을 입력해 주세요."></textarea>
              </div>


              <div class="btn-container">
                <div id="second-back" class="btn btn-cancel" href="index.html" @click="toggle1">취소</div>
                <div id="second-click" class="btn btn-default" @click="toggle2">다음</div>
              </div>


            </div>

          </section>





          <!-- ==========     3번 페이지    ========== -->
          <section id="third" class="reg" v-if="thirdPage">
            <h1 class="d-none">컨디션&태그 form</h1>
            <div class="reg3">


              <div class="title">컨디션과 태그를 입력해주세요</div>


              <div class="reg3-condition-container">
                <div class="input-title">상품 컨디션</div>

                <input value="미개봉" id="condition-미개봉" name="condition" type="radio" required>
                <label class="btn reg-btn" for="condition-미개봉">미개봉</label>

                <input value="거의새상품" id="condition-거의새상품" name="condition" type="radio" required>
                <label class="btn reg-btn" for="condition-거의새상품">거의새상품</label>

                <input value="사용감있는깨끗한상품" id="condition-사용감있는깨끗한상품" name="condition" type="radio"
                       required>
                <label class="btn reg-btn" for="condition-사용감있는깨끗한상품">사용감 있는 깨끗한 상품</label>

                <input value="사용흔적이있는상품" id="condition-사용흔적이있는상품" name="condition" type="radio"
                       required>
                <label class="btn reg-btn" for="condition-사용흔적이있는상품">사용 흔적이 있는 상품</label>

                <input vlaue="하자가있는상품" id="condition-하자가있는상품" name="condition" type="radio" required>
                <label class="btn reg-btn" for="tag-하자가있는상품">하자가 있는 상품</label>

              </div>


              <div class="reg3-tag-container">
                <label for="tag" class="input-title">상품 태그</label>
                <div>
                  <input class="input-default tag-input" id="tag" name="tag-input"
                         type="text" placeholder="태그를 입력해 주세요." v-model="newTag">
                  <div class="btn btn-default btn-add" @click="addTag">추가</div>
                </div>
                <div class="tag-box">
                  <ul>
                    <li class="btn btn-tag tag-default" v-for="tag in tags" :key="tags.id">
                      {{ tag.text }}
                    </li>
                    <input class="tag-hiddenBox" type="hidden" name="tag" value="${tagInput.value}" >
                  </ul>

                </div>

              </div>



              <div class="btn-container">
                <div id="third-back" class="btn btn-cancel" href="" @click="toggle2">취소</div>
                <div id="third-click" class="btn btn-default" @click="toggle3">다음</div>
              </div>


            </div>
          </section>









          <!-- ==========     4번 페이지    ========== -->
          <section id="four" class="reg" v-if="fourthPage">
            <h1 class="d-none">배송 방법 form</h1>
            <div class="reg4">


              <div class="title">상품 배송 방법을 선택해주세요.</div>


              <div>
                <div>
                  <input value="일반우편" class="" id="delivery-일반우편" name="deliveryType" type="radio"
                         required>
                  <label for="delivery-일반우편" class="delivery-label general-mail">
                                        <span class="label-box"><span class="delivery-icon">📮</span><span
                                            class="delivery-name">일반우편</span></span>
                  </label>
                </div>

                <div>
                  <input value="준등기" class="" id="delivery-준등기" name="deliveryType" type="radio"
                         required>
                  <label for="delivery-준등기" class="delivery-label semi-post">
                                        <span class="label-box"><span class="delivery-icon">✉️</span><span
                                            class="delivery-name">준등기</span></span>
                  </label>
                </div>

                <div>
                  <input value="택배" class="" id="delivery-택배" name="deliveryType" type="radio"
                         required>
                  <label for="delivery-택배" class="delivery-label parcel">
                                        <span class="label-box"><span class="delivery-icon">📦</span><span
                                            class="delivery-name">택배</span></span>
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
      price: '',
      title:'',
      img1: '',




      //  페이지 전환을 위한 변수
      firstPage: true,
      secondPage: false,
      thirdPage: false,
      fourthPage: false,
      isFirst: true,
      isSecond: false,
      isThird: false,
      isFourth: false,

      //REG1
      imageCount: 0,
      //REG2
      //--카테고리 선택을 위한 변수
      category: "카테고리를 선택해주세요.",
      superCategoryModal: false,
      CategoryModal1: false,
      CategoryModal2: false,
      CategoryModal3: false,
      superCategoryValue : null,
      categoryValue: null,





      //REG3 태그를 위한 함수
      newTag: '',
      tags: [
        { id: id++, text: '에스파' }
      ]

    }
  },
  methods: {


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



    //  ====================  REG1  ====================
    //--이미지
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

    imageDelete(e){

      const imgInputBoxContainer = document.querySelector(".input-box-container");
      let imgDelete = e.target;

      let FileInput=`
      <div class="input-box">
                            <input class="d-none file-input" id="img" name="files" type="file" accept="image/*">
                            <img class="img-input " src="/image/icon/icon-image.svg" alt="" @click="imageUpload">
                            <span class="img-delete d-none" @click="imageDelete"></span>
                          </div>
      `



      imgDelete.parentElement.remove();
      imgInputBoxContainer.insertAdjacentHTML("beforeend", FileInput);



      this.imageCount--;
    },


    //  ====================   REG2  ====================
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

    radioChange(e){
      this.superCategoryValue = e.target.value;
      this.categoryValue = e.target.id;
    },

    superCategorySelected(e){

      if(this.superCategoryValue && e.target.classList.contains("next-btn")){
        this.superCategoryModal = false;

        switch (this.superCategoryValue) {
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
      console.log(this.categoryValue)
      this.CategoryModal1 = false;
      this.CategoryModal2 = false;
      this.CategoryModal3 = false;
      this.category = this.categoryValue;


    },






    //REG3
    //태그
    addTag() {
      this.todos.push({ id: id++, text: this.newTag })
      this.newTodo = ''
    }

    //REG4



  }


}
</script>

<style scoped>
@import '/css/member/sell/index.css';
</style>



