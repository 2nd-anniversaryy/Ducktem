<template>
  <main>
    <section class="main-wrap">
      <h1>{닉네임}, 어찌 떠나려는 거야</h1>

      <ul>
        <li>
          <input id="1" type="radio" name="chk" />
          <label for="1">탈덕/휴덕으로 인해</label>
        </li>
        <li>
          <input id="2" type="radio" name="chk" />
          <label for="2">원하는 상품이 없어서</label>
        </li>
        <li>
          <input id="3" type="radio" name="chk" />
          <label for="3">서비스 사용에 장애/에러가 많아서</label>
        </li>
        <li>
          <input id="4" type="radio" name="chk" />
          <label for="4">서비스 사용 방법이 어려워서</label>
        </li>
        <li>
          <input id="5" type="radio" name="chk" />
          <label for="5">다른 플랫폼을 사용하려고</label>
        </li>
        <li>
          <input id="6" type="radio" name="chk" />
          <label for="6">기타사유</label>
        </li>
      </ul>

      <textarea id="" name="" placeholder="더 나은 덕템을 만들 수 있도록 도와주세요!" />

      <button onclick="location.href='/member/my-page/leave/index.html'" class="btn btn-default">더 생각해볼래요</button>
      <button class="btn btn-cancel">확인</button>
    </section>
  </main>
</template>

<script>
export default {};
</script>

<style scoped>
@import '/css/member/my-page/leave/survey.css';
</style>
