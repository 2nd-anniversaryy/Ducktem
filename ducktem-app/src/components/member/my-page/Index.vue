<template>
  <div>
    <main>
      <section class="main-wrap">
        <section class="profile">
          <div>
            <img src="/image/profile-img.png" alt="" />
          </div>
          <div>
            <span>Nickname</span>
          </div>
          <div>
            <a class="btn btn-default" href="">내 정보</a>
          </div>
          <div>
            <span>소개말</span>
          </div>
          <div>
            <a class="btn btn-default keyword-alert-btn" href="">키워드 알림</a>
          </div>
        </section>

        <section class="title">
          <div class="selling-btn"><span>판매중</span><span> 0</span></div>
          <div class="wish-list-btn"><span>찜 상품</span><span> 0</span></div>
        </section>
        <div class="product-flex">
          <section class="product-wrap product-page">
            <div class="product-container">
              <div>
                <img src="/image/example-image0.png" alt="product-img" />
              </div>

              <div class="price-wish">
                <span> 80,000원</span>
                <img src="/image/icon/heart.svg" alt="찜" />
              </div>

              <div class="name">러브다이브미공포</div>

              <div class="time">0일 전</div>
            </div>

            <div class="product-container">
              <div>
                <img src="/image/example-image0.png" alt="product-img" />
              </div>

              <div class="price-wish">
                <span> 80,000원</span>
                <img src="/image/icon/heart.svg" alt="찜" />
              </div>

              <div class="name">러브다이브미공포</div>

              <div class="time">0일 전</div>
            </div>

            <div class="product-container">
              <div>
                <img src="/image/example-image0.png" alt="product-img" />
              </div>

              <div class="price-wish">
                <span> 80,000원</span>
                <img src="/image/icon/heart.svg" alt="찜" />
              </div>

              <div class="name">러브다이브미공포</div>

              <div class="time">0일 전</div>
            </div>

            <div class="product-container">
              <div>
                <img src="/image/example-image0.png" alt="product-img" />
              </div>

              <div class="price-wish">
                <span> 80,000원</span>
                <img src="/image/icon/heart.svg" alt="찜" />
              </div>

              <div class="name">러브다이브미공포</div>

              <div class="time">0일 전</div>
            </div>

            <div class="product-container">
              <div>
                <img src="/image/example-image0.png" alt="product-img" />
              </div>

              <div class="price-wish">
                <span> 80,000원</span>
                <img src="/image/icon/heart.svg" alt="찜" />
              </div>

              <div class="name">러브다이브미공포</div>

              <div class="time">0일 전</div>
            </div>

            <div class="product-container">
              <div>
                <img src="/image/example-image0.png" alt="product-img" />
              </div>

              <div class="price-wish">
                <span> 80,000원</span>
                <img src="/image/icon/heart.svg" alt="찜" />
              </div>

              <div class="name">러브다이브미공포</div>

              <div class="time">0일 전</div>
            </div>
          </section>
        </div>

        <div class="product-flex">
          <section class="d-none product-wrap wishList-page">
            <div class="product-container">
              <div>
                <img src="/image/example-image0.png" alt="product-img" />
              </div>

              <div class="price-wish">
                <span> 80,000원</span>
                <img src="/image/icon/heart.svg" alt="찜" />
              </div>

              <div class="name">러브다이브미공포 WISH TEST</div>

              <div class="time">0일 전</div>
            </div>

            <div class="product-container">
              <div>
                <img src="/image/example-image0.png" alt="product-img" />
              </div>

              <div class="price-wish">
                <span> 80,000원</span>
                <img src="/image/icon/heart.svg" alt="찜" />
              </div>

              <div class="name">러브다이브미공포 WISH TEST</div>

              <div class="time">0일 전</div>
            </div>
          </section>
        </div>
      </section>
    </main>

    <!-- 키워드 알림 버튼 누르면 이거 떠야함~ -->
    <aside class="d-none keyword-alert-wrap">
      <section class="keyword-alert">
        <div class="keyword-alert-title">
          <h1>키워드 알림 설정</h1>
          <img class="keyword-close" src="/image/icon/icon-close.svg" alt="" />
        </div>

        <div class="keyword-alert-category">
          <label for="">카테고리</label>
          <select id="" name="">
            <option value="">전체선택</option>
            <option value="">공식굿즈</option>
            <option value="">비공식굿즈</option>
            <option value="">대리티켓팅</option>
          </select>
        </div>

        <div class="flex-wrap">
          <div class="keyword-alert-input">
            <input type="text" placeholder="키워드를 입력해 주세요(예: #NCT)" />
            <span class="">등록</span>
          </div>
        </div>

        <div class="keyword-alert-count"><span>등록한 키워드</span><span>0/5</span></div>

        <div class="keyword-sort">
          <span class="btn btn-tag">#테스트</span>
          <span class="btn btn-tag">#테스트</span>
          <span class="btn btn-tag">#테스트</span>
        </div>

        <div class="text-sort">
          <span>아름다운 키워드로 아름다운 덕템 만들기</span>
        </div>

        <div class="button-sort">
          <span class="btn btn-default btn-size-control">알림 받기</span>
        </div>
      </section>
    </aside>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
@import '/css/member/my-page/index.css';
</style>
