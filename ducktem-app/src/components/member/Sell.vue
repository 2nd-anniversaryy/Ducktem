<template>
  <main class="main">
    <div class="background">
      <section class="wizard-header">
        <h1 class="d-none">위자드 인덱스</h1>
        <span class="line" /> <span class="wizard first"><span class="wizard-index">1</span> </span>
        <span class="wizard"><span class="wizard-index">2</span></span> <span class="wizard"><span class="wizard-index">3</span></span>
        <span class="wizard"><span class="wizard-index">4</span></span>
      </section>

      <section class="main-wrap">
        <h1 class="d-none">상품 등록 form</h1>

        <!-- ==================================================     폼시작   ================================================== -->
        <form class="reg-form" method="post" enctype="multipart/form-data">
          <!-- ==========     1번 페이지    ========== -->
          <section id="one" class="reg">
            <h1 class="d-none">상품 정보 form</h1>
            <div class="reg1">
              <div class="title">상품 정보를 입력해주세요</div>

              <div class="input-container">
                <div class="input-title">상품 이미지</div>

                <div class="input-box-container">
                  <div class="input-box">
                    <span class="thumbNail-title">대표 이미지</span>
                    <input id="img" class="d-none file-input" name="files" type="file" required />
                    <img class="img-input thumbNail" src="/image/icon/icon-image.svg" alt="" />
                    <span class="img-delete thumbNail d-none" />
                  </div>
                  <div class="input-box">
                    <input id="img" class="d-none file-input" name="files" type="file" />
                    <img class="img-input" src="/image/icon/icon-image.svg" alt="" />
                    <span class="img-delete d-none" />
                  </div>
                  <div class="input-box">
                    <input id="img" class="d-none file-input" name="files" type="file" />
                    <img class="img-input" src="/image/icon/icon-image.svg" alt="" />
                    <span class="img-delete d-none" />
                  </div>
                  <div class="input-box">
                    <input id="img" class="d-none file-input" name="files" type="file" />
                    <img class="img-input" src="/image/icon/icon-image.svg" alt="" />
                    <span class="img-delete d-none" />
                  </div>
                </div>

                <div class="img-count"><span class="img-num" /> <span>/4</span></div>
              </div>

              <div>
                <label class="input-title" for="title">상품 제목</label>
                <input id="title" value="" class="input-default" name="name" type="text" required placeholder="제목을 입력해 주세요." />
              </div>

              <div class="price-container">
                <label class="input-title" for="price">상품 가격</label>
                <input
                  id="price"
                  value=""
                  class="input-default inline"
                  name="price"
                  type="number"
                  required
                  placeholder="가격을 입력해 주세요."
                /><span class="input-detail">원</span>
              </div>

              <div class="btn-container">
                <div id="quit-reg" class="btn btn-cancel" href="index.html">취소</div>
                <div id="first-click" class="btn btn-default">다음</div>
              </div>
            </div>
          </section>

          <!-- ==========     2번 페이지    ========== -->
          <section id="two" class="d-none reg">
            <h1 class="d-none">상품 설명 form</h1>
            <div class="reg2">
              <div class="title">상품 설명을 입력해주세요</div>

              <div>
                <label for="category" class="input-title">카테고리</label>
                <input id="category" class="input-default category-select" name="category" type="text" required placeholder="카테고리 선택" />

                <!-- =====   대분류   ====== -->
                <div class="supercategory-select d-none">
                  <div class="category-title">카테고리 선택</div>
                  <img class="exit" src="/image/icon/icon-close.svg" alt="" />

                  <div>
                    <input id="공식굿즈" value="공식굿즈" name="supercategory" type="radio" required />
                    <label class="category-select" for="공식굿즈">공식굿즈</label>
                  </div>

                  <div>
                    <input id="비공식굿즈" value="비공식굿즈" name="supercategory" type="radio" required />
                    <label class="category-select" for="비공식굿즈">비공식굿즈</label>
                  </div>

                  <div>
                    <input id="대리티켓팅" value="대리티켓팅" name="supercategory" type="radio" required />
                    <label class="category-select" for="대리티켓팅">대리티켓팅</label>
                  </div>

                  <div class="btn btn-default next-btn">다음</div>
                </div>

                <!-- =====   공식굿즈   ====== -->
                <div class="subcategory-select d-none">
                  <div class="category-supercategory">공식굿즈</div>
                  <div class="category-title">하위 카테고리 선택</div>
                  <img class="exit" src="/image/icon/icon-close.svg" alt="" />
                  <div>
                    <input id="공식굿즈 > 음반영상물" value="1" name="categoryId" type="radio" required />
                    <label class="category-select" for="공식굿즈 > 음반영상물">음반/영상물</label>
                  </div>

                  <div>
                    <input id="공식굿즈 > 응원도구" value="2" name="categoryId" type="radio" required />
                    <label class="category-select" for="공식굿즈 > 응원도구">응원도구</label>
                  </div>

                  <div>
                    <input id="공식굿즈 > 포토카드" value="3" name="categoryId" type="radio" required />
                    <label class="category-select" for="공식굿즈 > 포토카드">포토카드</label>
                  </div>

                  <div>
                    <input id="공식굿즈 > 포스터포토북" value="4" name="categoryId" type="radio" required />
                    <label class="category-select" for="공식굿즈 > 포스터포토북">포스터/포토북</label>
                  </div>

                  <div>
                    <input id="공식굿즈 > 문구류" value="5" name="categoryId" type="radio" required />
                    <label class="category-select" for="공식굿즈 > 문구류">문구류</label>
                  </div>

                  <div>
                    <input id="공식굿즈 > 기타잡화" value="6" name="categoryId" type="radio" required />
                    <label class="category-select" for="공식굿즈 > 기타잡화">기타잡화</label>
                  </div>

                  <div class="btn btn-default next-btn final">선택완료</div>
                </div>

                <!-- =====   비공식굿즈   ====== -->

                <div class="subcategory-select d-none">
                  <div class="category-supercategory">비공식굿즈</div>
                  <div class="category-title">하위 카테고리 선택</div>
                  <img class="exit" src="/image/icon/icon-close.svg" alt="" />
                  <div>
                    <input id="비공식굿즈 > 음반영상물" value="7" name="categoryId" type="radio" required />
                    <label class="category-select" for="비공식굿즈 > 음반영상물">음반/영상물</label>
                  </div>

                  <div>
                    <input id="비공식굿즈 > 응원도구" value="8" name="categoryId" type="radio" required />
                    <label class="category-select" for="비공식굿즈 > 응원도구">응원도구</label>
                  </div>

                  <div>
                    <input id="비공식굿즈 > 인형" value="9" name="categoryId" type="radio" required />
                    <label class="category-select" for="비공식굿즈 > 인형">인형</label>
                  </div>

                  <div>
                    <input id="비공식굿즈 > 포토카드" value="10" name="categoryId" type="radio" required />
                    <label class="category-select" for="비공식굿즈 > 포토카드">포토카드</label>
                  </div>

                  <div>
                    <input id="비공식굿즈 > 포스터포토북" value="11" name="categoryId" type="radio" required />
                    <label class="category-select" for="비공식굿즈 > 포스터포토북">포스터/포토북</label>
                  </div>

                  <div>
                    <input id="비공식굿즈 > 문구류" value="12" name="categoryId" type="radio" required />
                    <label class="category-select" for="비공식굿즈 > 문구류">문구류</label>
                  </div>

                  <div>
                    <input id="비공식굿즈 > 기타잡화" value="13" name="categoryId" type="radio" required />
                    <label class="category-select" for="비공식굿즈 > 기타잡화">기타잡화</label>
                  </div>

                  <div class="btn btn-default next-btn final">선택완료</div>
                </div>

                <!-- =====   대리티켓팅   ====== -->
                <div class="subcategory-select d-none">
                  <div class="category-supercategory">대리티켓팅</div>
                  <div class="category-title">하위 카테고리 선택</div>
                  <img class="exit" src="/image/icon/icon-close.svg" alt="" />
                  <div>
                    <input id="대리티켓팅 > 능력을사요" value="14" name="categoryId" type="radio" required />
                    <label class="category-select" for="대리티켓팅 > 능력을사요">능력을 사요</label>
                  </div>

                  <div>
                    <input id="대리티켓팅 > 능력을팔아요" value="15" name="categoryId" type="radio" required />
                    <label class="category-select" for="대리티켓팅 > 능력을팔아요">능력을 팔아요</label>
                  </div>

                  <div class="btn btn-default next-btn final">선택완료</div>
                </div>
              </div>

              <div>
                <label for="description" class="input-title">상품설명</label>
                <textarea
                  id="description"
                  value="description"
                  class="input-default input-description"
                  name="description"
                  type="text"
                  required
                  placeholder="설명을 입력해 주세요."
                />
              </div>

              <div class="btn-container">
                <div id="second-back" class="btn btn-cancel" href="index.html">취소</div>
                <div id="second-click" class="btn btn-default">다음</div>
              </div>
            </div>
          </section>

          <!-- ==========     3번 페이지    ========== -->
          <section id="third" class="d-none reg">
            <h1 class="d-none">컨디션&태그 form</h1>
            <div class="reg3">
              <div class="title">컨디션과 태그를 입력해주세요</div>

              <div class="reg3-condition-container">
                <div class="input-title">상품 컨디션</div>

                <input id="condition-미개봉" value="미개봉" name="condition" type="radio" required />
                <label class="btn reg-btn" for="condition-미개봉">미개봉</label>

                <input id="condition-거의새상품" value="거의새상품" name="condition" type="radio" required />
                <label class="btn reg-btn" for="condition-거의새상품">거의새상품</label>

                <input id="condition-사용감있는깨끗한상품" value="사용감있는깨끗한상품" name="condition" type="radio" required />
                <label class="btn reg-btn" for="condition-사용감있는깨끗한상품">사용감 있는 깨끗한 상품</label>

                <input id="condition-사용흔적이있는상품" value="사용흔적이있는상품" name="condition" type="radio" required />
                <label class="btn reg-btn" for="condition-사용흔적이있는상품">사용 흔적이 있는 상품</label>

                <input id="condition-하자가있는상품" vlaue="하자가있는상품" name="condition" type="radio" required />
                <label class="btn reg-btn" for="tag-하자가있는상품">하자가 있는 상품</label>
              </div>

              <div class="reg3-tag-container">
                <label for="tag" class="input-title">상품 태그</label>
                <div>
                  <input id="tag" value="" class="input-default tag-input" name="tag-input" type="text" placeholder="태그를 입력해 주세요." />
                  <div class="btn btn-default btn-add">추가</div>
                </div>
                <div class="tag-box" />
              </div>

              <div class="btn-container">
                <div id="third-back" class="btn btn-cancel" href="">취소</div>
                <div id="third-click" class="btn btn-default">다음</div>
              </div>
            </div>
          </section>

          <!-- ==========     4번 페이지    ========== -->
          <section id="four" class="d-none reg">
            <h1 class="d-none">배송 방법 form</h1>
            <div class="reg4">
              <div class="title">상품 배송 방법을 선택해주세요.</div>

              <div>
                <div>
                  <input id="delivery-일반우편" value="일반우편" class="" name="deliveryType" type="radio" required />
                  <label for="delivery-일반우편" class="delivery-label general-mail">
                    <span class="label-box"><span class="delivery-icon">📮</span><span class="delivery-name">일반우편</span></span>
                  </label>
                </div>

                <div>
                  <input id="delivery-준등기" value="준등기" class="" name="deliveryType" type="radio" required />
                  <label for="delivery-준등기" class="delivery-label semi-post">
                    <span class="label-box"><span class="delivery-icon">✉️</span><span class="delivery-name">준등기</span></span>
                  </label>
                </div>

                <div>
                  <input id="delivery-택배" value="택배" class="" name="deliveryType" type="radio" required />
                  <label for="delivery-택배" class="delivery-label parcel">
                    <span class="label-box"><span class="delivery-icon">📦</span><span class="delivery-name">택배</span></span>
                  </label>
                </div>
              </div>

              <div class="btn-container">
                <div id="fourth-back" class="btn btn-cancel" href="">취소</div>
                <button class="btn btn-default sell-btn">등록 완료</button>
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
export default {};
</script>

<style scoped>
@import '/css/member/sell/index.css';
</style>
