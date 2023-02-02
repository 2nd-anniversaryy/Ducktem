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

        <!--    =========================    폼시작   ================= -->

        <!-- ====================     1번 페이지    ==================== -->

        <section id="one" class="reg" v-if="firstPage">
          <h1 class="d-none">상품 정보 form</h1>
          <div class="reg1">
            <div class="title">상품 정보를 입력해주세요</div>

            <form class="reg-form" method="post" enctype="multipart/form-data">
              <!-- ==============================   이미지 입력란 입니다.(미완성)   =============================== -->
              <div class="img-input-container">
                <div class="input-title">상품 이미지</div>

                <div class="img-input-box">
                  <div class="input-box">
                    <!-- v-for="i in this.imageInputs" -->
                    <span class="thumbNail-title">대표 이미지</span>
                    <label>
                      <input class="d-none file-input" id="img" name="files" type="file" accept="image/*" required @change="imageUploadREAL" />
                      <img class="img-input thumbNail" :src="this.imageSrc[0]" alt="" targetId="0" />
                    </label>
                    <span v-if="this.isImageDelete[0]" class="img-delete thumbNail" id="0" @click="imageDelete"></span>
                  </div>

                  <div class="input-box">
                    <label>
                      <input class="d-none file-input" id="img" name="files" type="file" accept="image/*" @change="imageUploadREAL" />
                      <img class="img-input" :src="this.imageSrc[1]" alt="" targetId="1" />
                    </label>
                    <span v-if="this.isImageDelete[1]" class="img-delete" id="1" @click="imageDelete"></span>
                  </div>

                  <div class="input-box">
                    <label>
                      <input class="d-none file-input" id="img" name="files" type="file" accept="image/*" @change="imageUploadREAL" />
                      <img class="img-input" :src="this.imageSrc[2]" alt="" targetId="2" />
                    </label>
                    <span v-if="this.isImageDelete[2]" class="img-delete" id="2" @click="imageDelete"></span>
                  </div>

                  <div class="input-box">
                    <label>
                      <input class="d-none file-input" id="img" name="files" type="file" accept="image/*" @change="imageUploadREAL" />
                      <img class="img-input" :src="this.imageSrc[3]" alt="" targetId="3" />
                    </label>
                    <span v-if="this.isImageDelete[3]" class="img-delete" id="3" @click="imageDelete"></span>
                  </div>

                </div>

                <div class="img-count">
                  <span class="img-num">{{ this.imageCount }}</span> <span>/4</span>
                </div>
              </div>
            </form>
            <!--    상품 제목 입력란입니다.    -->
            <div>
              <label class="input-title" for="title">상품 제목</label>
              <input
                v-model="this.product.name"
                class="input-default"
                id="title"
                name="name"
                type="text"
                required
                placeholder="제목을 입력해 주세요."
              />
            </div>

            <!--    상품 가격 입력란입니다.    -->
            <div class="price-container">
              <label class="input-title" for="price">상품 가격</label>
              <input
                v-model="this.product.price"
                class="input-default inline"
                id="price"
                name="price"
                type="number"
                required
                placeholder="가격을 입력해 주세요."
              />
              <span class="input-detail">원</span>
            </div>

            <div class="btn-container">
              <router-link to="/"><div id="quit-reg" class="btn btn-cancel">취소</div></router-link>
              <div id="first-click" class="btn btn-default" @click="toggle1">다음</div>
            </div>
          </div>
        </section>

        <!-- ====================     2번 페이지    ==================== -->
        <section id="two" class="reg" v-if="secondPage">
          <h1 class="d-none">상품 설명 form</h1>
          <div class="reg2">
            <div class="title">상품 설명을 입력해주세요</div>

            <!--    카테고리 선택란입니다.    -->

            <div>
              <label for="category" class="input-title">카테고리를 선택해주세요</label>
              <div @click="superCategorySelect" class="input-default category-select category-input">
                {{ this.categoryResult }}
              </div>
              <input class="input-default category-select" v-model="this.categoryValue" id="category" name="category" type="hidden" />

              <!-- =====   카테고리 대분류 모달   ====== -->
              <div v-if="superCategoryModal" class="supercategory-select">
                <div class="category-title">카테고리 선택</div>
                <img class="exit" src="/image/icon/icon-close.svg" alt="" @click="modalClose" />

                <div v-for="(s, index) in superCategoryList">
                  <input v-bind:value="s" v-bind:id="index + 1" name="supercategory" type="radio" required v-model="this.productSuperCategoryValue" />
                  <label class="category-select" v-bind:for="index + 1">{{ s.name }}</label>
                </div>

                <div class="btn btn-default next-btn" @click="superCategorySelected">다음</div>
              </div>

              <!--  =====   카테고리 소분류  모달  ====== -->
              <div class="subcategory-select" v-if="this.CategoryModal">
                <div class="category-supercategory">{{ this.productSuperCategoryValue.name }}</div>
                <div class="category-title">하위 카테고리 선택</div>
                <img class="exit" src="/image/icon/icon-close.svg" alt="" @click="modalClose" />
                <div v-for="c in categoryList">
                  <input v-bind:value="c" v-bind:id="c.id" name="categoryId" type="radio" v-model="this.product.category" required />
                  <label class="category-select" v-bind:for="c.id">{{ c.name }}</label>
                </div>
                <div class="btn btn-default next-btn final" @click="categorySelected">선택완료</div>
              </div>
            </div>

            <!--    상품 상세 설명 입력란 입니다.    -->
            <div>
              <label for="description" class="input-title">상품설명</label>
              <textarea
                class="input-default input-description"
                id="description"
                name="description"
                type="text"
                required
                placeholder="설명을 입력해 주세요."
                v-model="this.product.description"
              ></textarea>
            </div>

            <div class="btn-container">
              <div id="second-back" class="btn btn-cancel" @click="toggle1">취소</div>
              <div id="second-click" class="btn btn-default" @click="toggle2">다음</div>
            </div>
          </div>
        </section>

        <!-- ====================     3번 페이지    ==================== -->
        <section id="third" class="reg" v-if="thirdPage">
          <h1 class="d-none">컨디션&태그 form</h1>
          <div class="reg3">
            <div class="title">컨디션과 태그를 입력해주세요</div>

            <!--    상품 상태 입력란 입니다.    -->
            <div class="reg3-condition-container">
              <div class="input-title">상품 컨디션</div>
              <div class="condition-box">
                <sapn v-for="condition in conditionList">
                  <input
                    v-bind:value="condition.name"
                    v-bind:id="condition.id"
                    name="condition"
                    v-model="this.product.condition"
                    type="radio"
                    required
                  />
                  <label class="btn reg-btn" v-bind:for="condition.id">{{ condition.name }}</label>
                </sapn>
              </div>
            </div>

            <!--    상품 태그 입력란 입니다.  -->
            <div class="reg3-tag-container">
              <label for="tag" class="input-title">상품 태그</label>
              <div>
                <input
                  class="input-default tag-input"
                  id="tag"
                  name="tag-input"
                  type="text"
                  placeholder="태그를 입력해 주세요."
                  v-model="this.newTag"
                />
                <div class="btn btn-default btn-add" @click="addTag">추가</div>
              </div>
              <div class="tag-box">
                <span v-for="t in this.product.tagNames">
                  <div class="btn btn-tag tag-default" @mouseover="this.deleteAppear(t)" @mouseleave="this.deleteDisappear(t)">
                    {{ t.name }}
                    <span v-if="t.state" class="tag-delete" :id="t.id" @click.prevent="tagDelete"></span>
                  </div>

                  <!--                  <input class="tag-hiddenBox" type="hidden" name="tag" v-model="t.name" />-->
                </span>
              </div>
            </div>

            <div class="btn-container">
              <div id="third-back" class="btn btn-cancel" @click="toggle2">취소</div>
              <div id="third-click" class="btn btn-default" @click="toggle3">다음</div>
            </div>
          </div>
        </section>

        <!-- ====================     4번 페이지    ==================== -->

        <section id="four" class="reg" v-if="fourthPage">
          <h1 class="d-none">배송 방법 form</h1>
          <div class="reg4">
            <!--    상품 배송 방법 입력란 입니다.    -->
            <div class="title">상품 배송 방법을 선택해주세요.</div>

            <div>
              <div v-for="d in this.deliveryTypeList">
                <input
                  v-bind:value="d.name"
                  class=""
                  v-bind:id="d.id"
                  name="deliveryType"
                  type="radio"
                  v-model="this.product.deliveryType"
                  required
                />
                <label v-bind:for="d.id" class="delivery-label general-mail">
                  <span class="label-box">
                    <span class="delivery-icon">{{ d.logo }}</span>
                    <span class="delivery-name">{{ d.name }}</span>
                  </span>
                </label>
              </div>
            </div>

            <div class="btn-container">
              <div id="fourth-back" class="btn btn-cancel" href="" @click="toggle3">취소</div>
              <button class="btn btn-default sell-btn" @click.prevent="postProduct">등록 완료</button>
            </div>

            <!-- ==================================================     폼 끝   ================================================== -->
          </div>
        </section>
      </section>
    </div>
  </main>
</template>

<script>
let id = 0;

export default {
  props: ['targetId', 'targetid'],
  emits: ['tagDelete'],

  data() {
    return {
      product: { name: '', price: '', description: '', deliveryType: '', category: '', condition: '', tagNames: [], images: [] },
      //====================     1번 페이지    ====================
      //이미지 입력을 위한 변수
      imageIndex: 0,
      imageCount: 0,
      imageSrcDefault: '/image/icon/icon-image.svg',
      imageSrc: ['/image/icon/icon-image.svg', '/image/icon/icon-image.svg', '/image/icon/icon-image.svg', '/image/icon/icon-image.svg'],
      newImageSrc: [],
      isImageDelete: [false, false, false, false],

      //====================     2번 페이지    ====================
      //카테고리 선택
      superCategoryList: [
        { name: '공식굿즈', id: 1 },
        { name: '비공식굿즈', id: 2 },
        { name: '대리티켓팅', id: 3 },
      ],
      categoryList: [],
      superCategoryModal: false,
      CategoryModal: false,
      productSuperCategoryValue: null,
      productCategoryValue: null,
      categoryResult: '카테고리를 선택해주세요.',

      //====================     3번 페이지    ====================
      //상품상태
      conditionList: [
        { name: '미개봉', id: 1 },
        { name: '거의새상품', id: 2 },
        { name: '사용감있는깨끗한상품', id: 3 },
        { name: '사용흔적이있는상품', id: 4 },
        { name: '하자가있는상품', id: 5 },
      ],
      //태그
      tagIndex: 0,
      newTag: null,
      //====================     4번 페이지    ====================
      deliveryTypeList: [
        { name: '일반우편', id: 1, logo: '📮' },
        { name: '준등기', id: 2, logo: '✉️' },
        { name: '택배', id: 3, logo: '📦' },
      ],

      //  페이지 전환을 위한 변수
      firstPage: true,
      secondPage: false,
      thirdPage: false,
      fourthPage: false,
      isFirst: true,
      isSecond: false,
      isThird: false,
      isFourth: false,
    };
  },
  methods: {
    async fetchCategory() {
      const response = await fetch(`http://localhost:8080/categorys?s=${this.productSuperCategoryValue.id}`);
      const json = await response.json();
      this.categoryList = json;
    },

    async postProduct() {
      let formData = new FormData();
      formData.append('name', this.product.name);
      formData.append('price', this.product.price);
      formData.append('description', this.product.description);
      formData.append('deliveryType', this.product.deliveryType);
      formData.append('category', this.product.category);
      formData.append('condition', this.product.condition);
      for (let i in this.product.tagNames) {
        formData.append('tagNames', this.product.tagNames[i].name);
      }
      for (let i in this.product.images) {
        formData.append('files', this.product.images[i]['Files']);
      }

      const response = await fetch(`http://localhost:8080/products`, {
        method: 'POST',
        headers: {
          Accept: 'application/json',
          Authorization: 'Bearer ' + this.$store.state.tokenResponse.access,
        },
        body: formData,
      });

      const id = await response.json();
      this.$router.push({ name: 'detail', query: { id: id } });
    },

    // ====================     1번 페이지    ====================
    //--이미지 등록 함수
    imageUploadREAL(e) {
      if (this.imageCount < 4) {
        //-- 업로드된 이미지 저장
        let imageFile = e.target.files[0];
        // this.product.images.push({id:this.imageCount,Files:imageFile});
        this.product.images.push({ id: this.imageIndex, Files: imageFile }); //test코드
        //-- 업로드된 이미지 뿌려주기

        const url = URL.createObjectURL(imageFile);

        this.imageSrc[this.imageCount] = url;
        this.isImageDelete[this.imageCount] = true;
        this.imageCount++;
        this.imageIndex++;
      } else alert('상품은 4개까지만 등록이 가능합니다.');
    },

    imageDelete(e) {
      let resultTag = this.product.tagNames.find((tags) => tags.id == e.target.id);
      let resultTagIndex = this.product.tagNames.indexOf(resultTag);
      this.product.tagNames.splice(resultTagIndex, 1);
      this.tagIndex--;

      let resultImage = this.product.images.find((images) => {
        return images.id == e.target.id;
      });
      let resultImageIndex = this.product.images.indexOf(resultImage);

      this.product.images.splice(resultImageIndex, 1);
      this.imageSrc.splice(resultImageIndex, 1);
      this.imageSrc[3] = this.imageSrcDefault;

      for (let i = 0; i < this.product.images.length; i++) this.product.images[i].id = i;

      for (let i = 0; i < 4; i++) {
        if (this.imageSrc[i] == this.imageSrcDefault) this.isImageDelete[i] = false;
      }

      this.imageCount--;
      this.imageIndex--;
    },

    // <!-- ====================     2번 페이지    ==================== -->
    //--카테고리 선택을 위한 함수
    superCategorySelect() {
      this.superCategoryModal = true;
    },
    modalClose() {
      this.superCategoryModal = false;
      this.CategoryModal = false;
    },
    superCategorySelected() {
      if (this.productSuperCategoryValue != null) {
        this.fetchCategory();
        this.CategoryModal = true;
        this.superCategoryModal = false;
      }
    },

    categorySelected() {
      this.productCategoryValue = this.product.category.name;
      if (this.productCategoryValue != null) {
        this.productSuperCategoryValue = this.productSuperCategoryValue.name;
        this.CategoryModal = false;
        this.categoryResult = this.productSuperCategoryValue + ' > ' + this.productCategoryValue;
        this.product.category = this.product.category.id;
      }
    },

    // <!-- ====================     3번 페이지    ==================== -->
    //태그
    addTag() {
      let blankPattern = /^\s+|\s+$/g;

      if (!this.newTag || this.newTag.replace(blankPattern, '') == '') {
        alert('공백이 입력되었습니다.');
        return;
      }

      if (this.tagIndex < 5) {
        this.product.tagNames.push({ id: this.tagIndex, name: this.newTag, state: false });
        this.newTag = '';
        this.tagIndex++;
      } else alert('태그는 5개까지만입력 가능합니다.');
      this.newTag = '';
    },

    deleteAppear(t) {
      t.state = true;
    },

    deleteDisappear(t) {
      t.state = false;
    },

    tagDelete(e) {
      let resultTag = this.product.tagNames.find((tags) => tags.id == e.target.id);
      let resultTagIndex = this.product.tagNames.indexOf(resultTag);
      this.product.tagNames.splice(resultTagIndex, 1);
      this.tagIndex--;
    },

    // <!-- ====================     4번 페이지    ==================== -->

    //  페이지 전환을 위한 함수
    toggle1() {
      this.firstPage = !this.firstPage;
      this.secondPage = !this.secondPage;

      this.isFirst = !this.isFirst;
      this.isSecond = !this.isSecond;
    },
    toggle2() {
      this.secondPage = !this.secondPage;
      this.thirdPage = !this.thirdPage;

      this.isSecond = !this.isSecond;
      this.isThird = !this.isThird;
    },
    toggle3() {
      this.thirdPage = !this.thirdPage;
      this.fourthPage = !this.fourthPage;

      this.isThird = !this.isThird;
      this.isFourth = !this.isFourth;
    },
  },
};
</script>

<style scoped>
@import '/css/member/sell/index.css';
</style>
