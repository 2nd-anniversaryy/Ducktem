<template>
  <main>

    <div class="update-product-form-wrap">
    <div class="update-product-title">
      <h1>상품 수정</h1>
    </div>

    <form class="update-product-wrap">


      <div class="update-product-image ">
        <div class="input-title">상품 이미지</div>

        <div class="img-input-box">

          <div class="input-box"> <!-- v-for="i in this.imageInputs" -->
            <span class="thumbNail-title">대표 이미지</span>
            <label>
              <input class="d-none file-input" id="img" name="files" type="file" accept="image/*" required @change="imageUpload"/>
              <img class="img-input thumbNail" :src="this.imageSrc[0]" alt="" targetId="0" >
            </label>
            <span v-if="this.isImageDelete[0]" class="img-delete thumbNail" id="0" @click="imageDelete"></span>
          </div>

          <div class="input-box" >
            <label>
              <input class="d-none file-input" id="img" name="files" type="file" accept="image/*"  @change="imageUpload">
              <img class="img-input " :src="this.imageSrc[1]" alt="" targetId="1" >
            </label>
            <span v-if="this.isImageDelete[1]" class="img-delete" id="1" @click="imageDelete"></span>
          </div>

          <div class="input-box">
            <label>
              <input class="d-none file-input" id="img" name="files" type="file" accept="image/*"  @change="imageUpload">
              <img class="img-input " :src="this.imageSrc[2]" alt="" targetId="2">
            </label>
            <span v-if="this.isImageDelete[2]" class="img-delete" id="2" @click="imageDelete"></span>
          </div>

          <div class="input-box">
            <label>
              <input class="d-none file-input" id="img" name="files" type="file" accept="image/*"  @change="imageUpload">
              <img class="img-input " :src="this.imageSrc[3]"  alt="" targetId="3">
            </label>
            <span v-if="this.isImageDelete[3]" class="img-delete" id="3" @click="imageDelete"></span>
          </div>

        </div>

        <div class="img-count">
          <span class="img-num">{{this.imageCount}}</span> <span>/4</span>
        </div>
      </div>

      <div class="update-product-name">
        <div class="input-title">상품 제목</div>
        <div>
          <input type="text" class="input-default"  v-model="this.myProductList.name" name="" id="" />
        </div>
      </div>

      <div class="update-product-price">
        <div class="input-title" >상품 가격</div>
        <div>
          <input type="number" class="input-default" v-model="this.myProductList.price" name="" id="" />
          <span class="input-after">원</span>
        </div>
      </div>

      <div class="update-product-category">
        <div class="input-title" >카테고리</div>
        <input type="text" class="input-default"  v-model="this.categoryResult" name="" id="" disabled/>
        <div>
          <p></p>
        </div>
      </div>

      <div class="update-product-explain">
        <div class="input-title" >상품 설명</div>
        <div>
           <textarea class="input-default input-description" id="description"
                     name="description" type="text" required placeholder="설명을 입력해 주세요." v-model="this.myProductList.description"></textarea>
        </div>
      </div>

      <div class="update-product-condition">
        <div class="input-title">상품 컨디션</div>
        <div class="condition-box">
          <sapn v-for="condition in conditionList">
            <input v-bind:value="condition.name" v-bind:id="condition.id" name="condition" class="d-none" v-model="this.myProductList.condition" type="radio" required>
            <label class="btn condition-btn" v-bind:for="condition.id">{{ condition.name }}</label>
          </sapn>
        </div>
      </div>

      <div class="update-product-tag">
        <label for="tag" class="input-title">상품 태그</label>
        <div>
          <input class="input-default tag-input" id="tag" name="tag-input"
                 type="text" placeholder="태그를 입력해 주세요." v-model="this.newTag">
          <div class="btn btn-default btn-add"  @click="addTag">추가</div>
        </div>
        <div class="tag-box">
                  <span v-for="t in this.myProductList.tags">
                      <div class="btn btn-tag tag-default" @mouseover="this.deleteAppear(t)" @mouseleave="this.deleteDisappear(t)"   >
                            {{ t.name }}
                            <span v-if="t.state" class="tag-delete" :id="t.id" @click.prevent="tagDelete" ></span>
                      </div>
                  </span>

        </div>
      </div>

      <div class="update-product-delivery">
        <div class="input-title">배송 방법</div>

        <div class="product-delivery-box">
          <div v-for="d in this.deliveryTypeList">
            <input v-bind:value="d.name" class="d-none" v-bind:id="d.id+'d'" name="deliveryType" type="radio" v-model="this.myProductList.deliveryType" required>
            <label v-bind:for="d.id+'d'" class="delivery-label general-mail">
                    <span class="label-box">
                      <span class="delivery-icon">{{d.logo}}</span>
                      <span class="delivery-name">{{ d.name }}</span>
                    </span>
            </label>
          </div>
        </div>
      </div>

      <div class="update-product-btn">
        <input class="btn btn-default" type="submit" value="상품 삭제" />
        <input class="btn btn-default" @click="fetchUpdateMyproduct($route.params)" type="submit" value="상품 수정" />
      </div>
    </form>
    </div>
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

      //test
      temp: {},


      //==================여기서부터 작업 시작
      productId:'',
      myProductList: {},
      product:{name:'',price:'',description:'',deliveryType:'',category:'',condition:'',tagNames:[],images:[]},
      //======이미지 수정

      imageIndex:0,
      imageCount: 0,
      imageSrcDefault: '/image/icon/icon-image.svg',
      imageSrc:['/image/icon/icon-image.svg','/image/icon/icon-image.svg','/image/icon/icon-image.svg','/image/icon/icon-image.svg'],
      newImageSrc:[],
      isImageDelete:[false,false,false,false],
      //카테고리
      categoryResult : '',
      //== 상품 컨디션
      conditionList:[{name:"미개봉", id:1},{name:"거의새상품", id:2},{name:"사용감있는깨끗한상품", id:3},{name:"사용흔적이있는상품", id:4},{name:"하자가있는상품", id:5}],
      //태그
      tagIndex:0,
      newTag:null,

      //====================     4번 페이지    ====================
      deliveryTypeList:[{name:"일반우편",id:1,logo:"📮"},{name:"준등기", id:2,logo:"✉️"},{name:"택배", id:3,logo:"📦"}],





    };
  },
  mounted() {
    // this.fetchGetMyInfo();
    console.log(this.$route.query.id)
    this.fetchGetMyProduct(this.$route.query.id);
  },
  watch: {},
  methods: {

    //===수정할 상품 불러오기
    async fetchGetMyProduct(id){
      let myInfoForAuth;
      if (this.$store.state.tokenResponse.access) {
        myInfoForAuth = 'Bearer ' + this.$store.state.tokenResponse.access;
      }
      const response = await fetch(`http://localhost:8080/products/${id}`,{
        headers: {
          Authorization: myInfoForAuth,
        }
      });
      const json = await response.json();

      this.temp = json;
      console.log(this.temp);

      this.myProductList = json;
      //==========화면에 보여주기 위한 코드==============
      //이미지 불러오기, 이미지 갯수 불러오기
      for(let i=0;i<this.myProductList.imgNames.length;i++)
        this.imageSrc[i] = this.myProductList.imgNames[i].imgUrl;
      this.imageCount = this.myProductList.imgNames.length

      //카테고리 결과 조합
      this.categoryResult = this.myProductList.superCategory + '>' + this.myProductList.subCategory;

    },

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
  //==================================여기서부터 작업 시작
    //===이미지 수정
    imageUpload(e){
      if(this.imageCount<4){
        //-- 업로드된 이미지 저장
        let imageFile = e.target.files[0]
        // this.product.images.push({id:this.imageCount,Files:imageFile});
        this.myProductList.images.push({id: this.imageIndex, Files: imageFile}); //test코드
        //-- 업로드된 이미지 뿌려주기

        const url = URL.createObjectURL(imageFile)

        this.imageSrc[this.imageCount] = url
        this.isImageDelete[this.imageCount] = true
        this.imageCount++;
        this.imageIndex++;
      }
      else
        alert("상품은 4개까지만 등록이 가능합니다.")

    },



    imageDelete(e){

      let resultTag = this.myProductList.tagNames.find((tags)=> tags.id == e.target.id)
      let resultTagIndex= this.myProductList.tagNames.indexOf(resultTag);
      this.myProductList.tagNames.splice(resultTagIndex,1)
      this.tagIndex--;



      let resultImage = this.myProductList.images.find((images)=> {
        return images.id == e.target.id
      })
      let resultImageIndex= this.myProductList.images.indexOf(resultImage);

      this.myProductList.images.splice(resultImageIndex,1);
      this.imageSrc.splice(resultImageIndex,1);
      this.imageSrc[3]=this.imageSrcDefault;

      for(let i=0;i<this.myProductList.images.length;i++)
        this.myProductList.images[i].id = i;

      for(let i=0;i<4;i++) {
        if(this.imageSrc[i] == this.imageSrcDefault)
          this.isImageDelete[i] = false;
      }

      this.imageCount--;
      this.imageIndex--;

    },

    //====태그 함수
    deleteAppear(t){
      t.state = true;
    },

    deleteDisappear(t){
      t.state = false;
    },

    addTag() {
      let blankPattern = /^\s+|\s+$/g;

      if(!this.newTag|| (this.newTag.replace(blankPattern, '' ) == "")){
        alert("공백이 입력되었습니다.")
        return;
      }

      if(this.tagIndex < 5) {
        this.myProductList.tagNames.push({id: this.tagIndex, name: this.newTag, state:false})
        this.newTag = ''
        this.tagIndex++;
      }
      else
        alert("태그는 5개까지만입력 가능합니다.")
      this.newTag = ''


    },

    tagDelete(e){
      let resultTag = this.myProductList.tagNames.find((tags)=> tags.id == e.target.id)
      let resultTagIndex= this.myProductList.tagNames.indexOf(resultTag);
      this.myProductList.tagNames.splice(resultTagIndex,1)
      this.tagIndex--;
    },


  },
};
</script>

<style scoped>
@import '/css/member/update-product/index.css';
</style>
