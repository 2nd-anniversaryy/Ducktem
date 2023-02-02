<template>
    <main class="sign-up-ending">
        <div>
            <img class="" src="/image/icon/balloons.svg" alt="축하이미지">
        </div>

        <div class="strong">환영합니다!</div>
        <div class="light">
            <div>지금 바로 덕템의 다양한 서비스를</div>
            <div>이용하실 수 있습니다.</div>
        </div>

        <div class="btn1">
            <a class="btn btn-default" href="index.html" @click.prevent="goLogin">로그인하러 가기</a>
        </div>
    </main>
</template>

<script>
export default {
    data() {
        return {

        }
    },
    methods: {
        goLogin() {
            this.$router.push('/login');
        }
    },
}
</script>

<style scoped>
@import '/css/sign-up.css';
</style>