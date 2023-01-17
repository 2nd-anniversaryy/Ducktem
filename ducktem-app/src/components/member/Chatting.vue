<template>
    <div class="total-height">
        <header>
            <section class="header-wrap">
                <div class="backpage-btn-wrap">
                    <img class="backpage-btn" src="/image/talk-icon/back.png" alt="">

                    <h1 class="others">상대방</h1>
                </div>
                <div class="option-btn-wrap">
                    <img class="option-btn" src="/image/talk-icon/점3개옵션.svg" alt="">
                </div>
            </section>

        </header>

        <main>
            <section class="main-wrap">
                <section class="product-info">
                    <div class="product-img-wrap">
                        <img class="product-img" src="/image/product-img.jpg" alt="">
                    </div>
                    <div class="info-flex">
                        <div>
                            <span>거래상태</span>
                            <span>[상품상태] 상품제목 입력구간입니당나귀상목상품품목상품품목상품품목상품품목상품품</span>
                        </div>
                        <span>500,000원</span>
                    </div>
                </section>
                <section class="chatting-padding">
                    <div class="chatting-date-flex">
                        <div class="chatting-date-wrap">
                            <span class="chat-date">00월 00일 몇요일</span>
                        </div>
                    </div>

                    <ul class="chat-text-section">
                        <!-- <li class="send-wrap">
                        <div class="img-wrap">
                            <img class="img" src="/image/talk-icon/human.svg" alt="">
                        </div>
                        <div class="chat-text">
                            동해물과백두산이
                        </div>
                        <div class="chat-text-date">오후 00:00</div>

                    </li>

                    <li class="received-wrap">
                        <div class="img-wrap">
                            <img class="img" src="/image/talk-icon/human.svg" alt="">
                        </div>
                        <div class="chat-text">
                            좀 조용히해라
                        </div>
                        <div class="chat-text-date">오후 00:00</div>
                    </li> -->

                    </ul>
                </section>
                <div class="chat-input-box">
                    <div class="chat-input-area">
                        <div class="tool-box">
                            <img class="btn-bold" src="/image/talk-icon/bold.svg" alt="">
                            <img src="/image/talk-icon/italic.svg" alt="">
                            <img src="/image/talk-icon/취소선.svg" alt="">
                        </div>
                        <div>
                            <input class="chat-input" type="text" placeholder="상대방에게 메시지 보내기">
                        </div>
                        <div class="button-wrap">
                            <div>
                                <img src="/image/talk-icon/camera.svg" alt="">
                            </div>
                            <div>
                                <img src="/image/talk-icon/send-button.svg" class="send-button">
                            </div>
                        </div>
                    </div>
                </div>

            </section>
        </main>
    </div>

</template>

<script>
export default {

}
</script>

<style scoped>
@import '/css/member/chatting/index.css';
</style>