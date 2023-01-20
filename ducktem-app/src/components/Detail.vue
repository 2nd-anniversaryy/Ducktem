<template>
    <main>
        <section class="main-wrap">
            <div class="product-img-wrap">
                <img class="product-img" src="/image/product-img.jpg" alt="">
            </div>

            <section class="profile-container">
                <img class="profile-img" src="/image/prof-img.jpg" alt="">
                <h1>미지13</h1>
                <span class="product-count">판매상품 6</span>

                <span class="review-info">★★★★★(2)</span>
            </section>
            <section class="detail-container">
                <div class="detail-container-title">
                    <h1>뉴진스 비공굿 판매(포카, 떡메)</h1>
                    <span class="detail-category">비공식 굿즈 > 문구류</span>
                    <span>1분전</span>
                </div>
                <div class="detail-icon">
                    <div class="">
                        <img src="/image/icon/icon-eye-fill.svg" alt="">
                        <span>6</span>
                    </div>
                </div>
                <p>다니엘해린눌린자국있으나나머지멤찍힘스크래치없슴니다빛번짐인증가넝</p>

            </section>
            <section>
                <ul class="detail-button">
                    <li><a class="btn btn-tag " href="">Newjeans</a></li>
                    <li><a class="btn btn-tag " href="">포카</a></li>
                    <li><a class="btn btn-tag " href="">Aespa</a></li>
                    <li><a class="btn btn-tag " href="">Aespa</a></li>
                    <li><a class="btn btn-tag " href="">Aespa</a></li>
                </ul>
            </section>
            <section class="detail-spec-container">
                <ul>
                    <li>상품상태 거의 새상품</li>
                    <li>배송방법</li>
                </ul>
            </section>
            <section>
                <h1 class="detail-user-others">이 판매자의 다른 물건</h1>
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

            <section class="bottom-bar-wrap">
                <div class="bottom-bar">
                    <div>
                        <img src="/image/icon/heart.svg" alt=""><label for="">2</label>
                    </div>
                    <div>
                        <span>5000원</span>
                    </div>
                    <div>
                        <button class="btn btn-default" @click="goChattingPage">덕템톡</button>
                    </div>
                </div>
            </section>

        </section>
    </main>
</template>

<script>
export default {
    computed: {
        goChattingPage() {
            this.$router.push('/chatting');
        }
    }
}
</script>

<style scoped>
@import '/css/detail.css';
</style>