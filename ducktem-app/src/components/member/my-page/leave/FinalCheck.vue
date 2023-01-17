<template>
    <main>
        <section class="main-wrap">
            <h1>이것만은 알고 가(Before U Go)</h1>
            <span>이것만은 알고 가(Before U Go)/ 동방신기(TVXQ!)</span>

            <div>
                <h2>탈퇴 전 확인해주세요!</h2>
                <p>
                    • 덕템 계정을 탈퇴하면 모든 계정 정보가 삭제되며, 복원할 수 없습니다.
                    <br>
                    <br>
                    • 탈퇴 시 서비스 이용 기록을 포함한 모든 정보가 삭제됩니다. 하지만, 본인이 작성한 게시글, 댓글, 평점 등은 자동으로 사라지지 않으니 유의해주세요.
                    <br>
                    <br>
                    • 탈퇴 후에는 회원 정보가 삭제되므로 본인 여부를 확인할 수 있는 방법이 없어, 데이터를 임의로 삭제 혹은 복원해드릴 수 없습니다.
                </p>

            </div>

            <button onclick="location.href='/member/my-page/leave/survey.html'" class="btn btn-default">더
                생각해볼래요</button>
            <button class="btn btn-cancel final-check-btn">확인</button>
        </section>

        <div class="d-none modal-background">
            <div class="modal-box">
                <h1>회원탈퇴가 완료되었습니다.</h1>
                <button onclick="location.href='/index.html'" class="btn btn-cancel">확인</button>
            </div>
        </div>
    </main>
</template>

<script>
export default {

}
</script>

<style scoped>
    @import '/css/member/my-page/leave/final-check.css';
</style>