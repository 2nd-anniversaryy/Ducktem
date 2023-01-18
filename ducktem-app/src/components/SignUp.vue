<template>

    <div class="login-body">

        <!-- ====================     헤더입니다     ==================== -->
        <div class="login-header">
            <h1 class="d-none">로고</h1>

            <div class="login-logo">Ducktem</div>

        </div>


        <!-- ====================     메인입니다     ==================== -->
        <main>
            <section class="signup-form">
                <h1 class="d-none">회원가입</h1>


                <form action="signup">
                    <!-- 백에서 사용할 로그인 함수이름-->

                    <div class="signup-container">



                        <div>
                            <label class="required" for="name">이름</label>
                            <input id="name" name="name" type="text" required autofocus placeholder="이름을 입력해주세요.">
                        </div>


                        <div>
                            <label class="required" for="uid">아이디</label>
                            <input id="uid" name="uid" type="text" required placeholder="아이디를 입력해주세요.">
                        </div>

                        <div>
                            <label class="required" for="password">비밀번호</label>
                            <input id="password" type="password" required placeholder="비밀번호를 입력해주세요.">
                            <input id="password" type="password" required placeholder="비밀번호를 입력해주세요.">
                        </div>

                        <div>
                            <label class="required" for="email">이메일</label>
                            <input id="email" name="email" type="text" required placeholder="이메일을 입력해주세요.">
                        </div>

                        <div>
                            <label class="required" for="phonenumber">휴대폰번호</label>
                            <input id="phonenumber" name="phonenumber" type="text" required
                                placeholder="(-)을 제외하고 입력해주세요">
                        </div>

                        <div>
                            <label for="birthday">생일</label>
                            <input id="birthday" name="birthday" type="date" placeholder="(-)을 제외하고 입력해주세요">
                        </div>


                        <div>
                            <label class="required" for="signup-agree">약관동의</label>
                            <div class="detail">
                                설명을 잘 읽어보시고 동의해주세요. 구구절절.. 구구절절.. 구구절절.. 구구절절.. 구구절절.. 구구절절.. 구구절절.. 구구절절.. 구구절절..
                                구구절절..
                                구구절절.. 구구절절.. 구구절절.. 구구절절.. 구구절절.. 구구절절.. 구구절절.. 구구절절.. 구구절절.. 구구절절.. 구구절절.. 구구절절..
                                구구절절..
                                구구절절.. 구구절절.. 구구절절.. 구구절절.. 구구절절.. 구구절절.. 구구절절.. 구구절절.. 구구절절..설명을 잘 읽어보시고 동의해주세요. 구구절절..
                                구구절절.. 구구절절.. 구구절절.. 구구절절.. 구구절절..설명을 잘 읽어보시고 동의해주세요. 설명을 잘 읽어보시고 동의해주세요. 설명을 잘 읽어보시고
                                동의해주세요. 구구절절.. 구구절절.. 구구절절.. 구구절절.. 구구절절.. 구구절절.. 구구절절..설명을 잘 읽어보시고 동의해주세요. 설명을 잘 읽어보시고
                                동의해주세요. 구구절절..
                            </div>
                            <div class="signup-agree">
                                <span>설명을 잘 읽었고 약관에 동의합니다.</span>
                                <input class="check" id="signup-agree" name="signup-agree" type="checkbox" required>
                            </div>
                        </div>



                    </div>

                    <div>
                        <a href="sign-up-ending.html" class="btn btn-default btn-margin">동의하고 가입하기</a>

                    </div>

                </form>

            </section>

        </main>

    </div>
</template>

<script>
export default {

}
</script>

<style scoped>
@import '/css/sign-up.css';
</style>