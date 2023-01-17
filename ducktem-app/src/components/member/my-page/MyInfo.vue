<template>
    <main>
        <section class="main-wrap">
            <section class="regist-prof-img-wrap">
                <div>
                    <img src="/image/profile-img.png" alt="">
                </div>
                <div>
                    <input type="image" src="/image/빈-상품이미지.png" alt="">
                </div>
            </section>

            <section class="input-area">
                <div>
                    <label for="">닉네임</label><input type="text">
                </div>
                <div>
                    <label for="">소개글</label><textarea name="" id=""></textarea>
                </div>
                <div>
                    <label for="">이메일</label><input type="text">
                </div>
                <div>
                    <label for="">비밀번호</label><input type="text">
                </div>
                <div>
                    <label for="">본인인증</label><input type="text">
                </div>
                <div>
                    <label for="">소셜연동</label>
                    <div class="social-area">
                        <div>
                            <label for=""><img src="/image/kakao-logo.png" alt=""><span>카카오톡</span></label>
                            <input type="checkbox" name="" id="kakao">
                            <label class="btn btn-cancel checkd-btn" for="kakao">연동</label>
                        </div>
                        <div>
                            <label for=""><img src="/image/naver-logo.png" alt=""><span>네이버</span></label>
                            <input type="checkbox" name="" id="naver">
                            <label class="btn btn-cancel checkd-btn" for="naver">연동</label>
                        </div>
                        <div>
                            <label for=""><img src="/image/google-logo.png" alt=""><span>구글</span></label>
                            <input type="checkbox" name="" id="google">
                            <label class="btn btn-cancel checkd-btn" for="google">연동</label>
                        </div>
                    </div>
                </div>
                <span>회원탈퇴</span>

                <button class="btn btn-default">저장하기</button>
            </section>
        </section>
    </main>
</template>

<script>
export default {

}
</script>

<style scoped>
    @import '/css/member/my-page/my-info.css'
</style>