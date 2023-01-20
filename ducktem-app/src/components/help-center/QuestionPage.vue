<template lang="">
    <section class="question-page">
                <h1>1:1문의 게시판</h1>

                <section class="question-board">

                    <div class="question-container">
                        <div>
                            <img src="/image/icon/question.svg" alt="">
                            <label class="question-title" for="1">1:1문의 제목입력칸.</label>
                            <img class="cramps" src="/image/icon/꺽쇠.svg" alt="">
                        </div>
                        <div class="question-date">00.00.00</div>
                    </div>
                    <div class="d-none question-answer">
                        질문답변질문답변질문답변질문답변질문답변질문답변질문답변질문답변
                    </div>

                    <div class="question-container">
                        <div>
                            <img src="/image/icon/question.svg" alt="">
                            <label class="question-title" for="1">1:1문의 제목입력칸.</label>
                            <img class="cramps" src="/image/icon/꺽쇠.svg" alt="">
                        </div>
                        <div class="question-date">00.00.00</div>
                    </div>
                    <div class="d-none question-answer">
                        질문답변질문답변질문답변질문답변질문답변질문답변질문답변질문답변
                    </div>

                    <div class="question-container">
                        <div>
                            <img src="/image/icon/question.svg" alt="">
                            <label class="question-title" for="1">1:1문의 제목입력칸.</label>
                            <img class="cramps" src="/image/icon/꺽쇠.svg" alt="">
                        </div>
                        <div class="question-date">00.00.00</div>
                    </div>
                    <div class="d-none question-answer">
                        질문답변질문답변질문답변질문답변질문답변질문답변질문답변질문답변
                    </div>

                    <div class="d-none input-container">
                        <div>
                            <p class="title-input" contenteditable="true" placeholder="제목을 입력해주세요."></p>
                        </div>
                        <div>
                            <p class="detail-input" contenteditable="true" placeholder="내용을 입력해주세요."></p>
                        </div>
                        <!-- <div class="secret-wrap">
                                    <span>비밀글 설정:</span>
                                    <input type="radio" name="비밀글" id="공개글"><label for="공개글">공개글</label>
                                    <input type="radio" name="비밀글" id="비공개글"><label for="비공개글">비공개글</label>
                                </div> -->
                    </div>

                </section>

                <div class="btn-box">
                    <button class="btn btn-default write-btn">글쓰기</button>
                    <button class="d-none btn btn-cancel cancel-btn">취소</button>
                    <button class="d-none btn btn-default regist-btn">등록</button>
                </div>
            </section>
</template>
<script>
export default {

}
</script>
<style scoped>
@import '/css/help-center/index.css';
</style>