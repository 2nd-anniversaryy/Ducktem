# 내 굿즈 사고 팔땐 덕템 DuckTem

### 중고 아이돌 굿즈를 거래하는 플랫폼입니다. 기존 아이돌 굿즈를 거래하는 사람들은 트위터를 이용하고 있지만, 트위터로 거래하기에는 불편함과 사기위험이 있었기 때문에 그들을 위한 편리한 안전거래 사이트입니다.

### Spring boot로 Rest API형 서버를 만들었고, Vue.js 를 활용하여 웹 페이지를 구현했습니다.

### 기존 Spring MVC에서 Vue와 API형 서버로 바꿨습니다.

[Spring MVC로 만든 DUCKTEM보러가기](https://github.com/gombasan/DuckTemProto)

# 사용 기술 및 개발 환경

- Java
- Spring Boot
- Vue.js
- IntelliJ & VS code
- Gradle
- JPA? MyBatis?
- MariaDB

# 코드 컨벤션

- Java 는 네이버 코딩 컨벤션을 준수함
- intellij formatter를 적용하여 코드 컨벤션 유지
- Vue.js 는 prettier 로 통일.

[그 외 컨벤션 문서](https://donghak-dev.tistory.com/98)

# 브런치 관리 전략

- Github Flow를 사용하여 관리.
- 모든 브런치는 Main 에서 시작하며, 브렌치 이름을 명확하게 구분
- main으로 merge를 할 준비가 완료되었을 때는 꼭 PR을 통해 리뷰를 받고 merge
- commit 메세지는 수정한 파일 하나하나 작성하는것을 기본으로 함
- 로컬브런치에서 merge 금지

[GitHub Flow 관련 링크](https://dongminyoon.tistory.com/39)

# 그 외

- 개발 타임라인은 Github Issues를 적극 활용
- 개발도중 생긴 트러블 슈팅은 WIKI에 작성하여 관리.
