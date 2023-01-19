<template>
    <div>
        <main class="main-wrap">
            <h1>헬프 센터</h1>

            <div class="line"></div>

            <section class="grid-menu">

                <div class="menu-faq">FAQ</div>
                <div class="menu-question">1:1문의 게시판</div>
                <div class="menu-method">덕템 이용 방법</div>
                <div class="menu-policy">덕템 운영 정책</div>

            </section>

            <!-- ======================= FAQ  ======================= -->
            <section class="faq-page">

                <section class="step-wrap">

                    <h1>FAQ</h1>

                    <div>
                        <h2>step 1</h2>
                        <p>FQA를 확인해주세요. 빠른 해결이 가능할 수 있습니다!</p>
                    </div>

                    <div>
                        <h2>step 2</h2>
                        <p>1:1 문의 게시판에 글을 남겨주세요. 최대한 빠르게 답변 드리겠습니다!</p>
                    </div>

                    <div>
                        <h2>step 3</h2>
                        <p>답변이 남겨지면 톡을 통해 알림을 드립니다! 신속한 해결을 위해 자주 확인해주세요! </p>
                    </div>

                </section>

                <section class="qna-chk-wrap">

                    <div>
                        <img src="/image/icon/question.svg" alt="">
                        <label class="qna-title" for="1">판매할 물건은 어떻게 올리나요?</label>
                        <img class="cramps" src="/image/icon/꺽쇠.svg" alt="">
                    </div>
                    <p class="d-none answer">
                        덕템 웹사이트 상단[판매하기] 버튼을 누르시고 상품의 사진과 정보를 입력하여 등록해주시면 됩니다.
                    </p>

                    <div>
                        <img src="/image/icon/question.svg" alt="">
                        <label class="qna-title" for="2">신고를 하고 싶습니다.</label>
                        <img class="cramps" src="/image/icon/꺽쇠.svg" alt="" for>
                    </div>
                    <p class="d-none answer">
                        상품 관련 신고인 경우,상품 상세화면 상단의 [신고아이콘]을 눌러 상품을 신고 하실 수 있습니다.
                    </p>

                    <div>
                        <img src="/image/icon/question.svg" alt="">
                        <label class="qna-title" for="3">판매금지 상품이 있나요?</label>
                        <img class="cramps" src="/image/icon/꺽쇠.svg" alt="" for>
                    </div>
                    <p class="d-none answer">
                        덕템 이용정책에 따라 아이돌 관련 물품이 아닌 것은 판매금지됩니다.
                    </p>

                    <div>
                        <img src="/image/icon/question.svg" alt="">
                        <label class="qna-title" for="4">내 상품을 공유하고 싶어요.</label>
                        <label class="chk-line" for="4"><img class="cramps" src="/image/icon/꺽쇠.svg" alt="" for></label>
                    </div>
                    <p class="d-none answer">
                        상품 상세화면 상단의[공유 아이콘]을 눌러 상품을 공유할 수 있습니다.
                    </p>

                    <div>
                        <img src="/image/icon/question.svg" alt="">
                        <label class="qna-title" for="5">판매할 물건은 어떻게 올리나요?</label>
                        <label class="chk-line" for="5"><img class="cramps" src="/image/icon/꺽쇠.svg" alt="" for></label>
                    </div>
                    <p class="d-none answer">
                        웹사이트 상단 검색란에 검색어를 입력하여 상품을 검색할 수 있습니다.
                    </p>

                </section>

            </section>
            <!-- ======================= 1:1문의 게시판  ======================= -->
            <section class="d-none question-page">
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


            <!-- ======================= 덕템 이용 방법  ======================= -->

            <section class="d-none method-page">
                <section class="method-btn-container">
                    <div class="manner-category-btn">
                        <span>💁‍♂️</span>
                        <span>회원간 매너</span>
                    </div>
                    <div class="word-category-btn">
                        <span>😆</span>
                        <span>덕질용어 정리</span>
                    </div>
                    <div class="method-category-btn">
                        <span>👩‍💻</span>
                        <span>덕템 이용방법</span>
                    </div>
                </section>

                <section class="manner-category">
                    <h1>💁‍♂️회원간 매너</h1>
                    <p>
                        1) 서로를 존중하는 말로 대화하고, 상대가 불편함을 느낄 수 있는 표현과 거부하는 행동은 삼가해주세요.️️
                        - 욕설, 비방/비하, 명예훼손, 일방적인 반말 등은 ‘비매너’표현입니다
                        - 무리한 가격 에누리, 밤늦은 시간의 덕후톡 대화 요구, 구매 강요 행위 등은 비매너 신고될 수 있습니다.
                        - 아이템의 높은 가격에 대한 조언은 덕후톡으로 이야기 해주세요. 모든 회원들에게 공개되는 아이템 댓글을 통한 조언은 판매회원의 입장에서 거래방해로 여겨질 수 있습니다.
                        - 헬로마켓 운영진, 직원 또는 관계자를 사칭하는 행위는 엄격히 금지합니다.

                        2) 거래 약속은 서로 지키기 위해 노력하고, 부득이한 사정으로 거래를 파기할 경우 상대에게 충분히 양해를 구해주세요.
                        - 상습적인 거래파기나 상대와 직접 만나서 거래를 약속한 후 불이행(연락두절 등)하는 행위는 제재사유가 될 수 있습니다.
                        - 거래피해 상대회원의 개인정보 노출은 자제해주세요. 상대회원으로부터 확인한 정보가 거래와 무관한 타인의 도용된 정보일 경우, 게시한 회원에게 피해가 발생할 수 있습니다.
                        거래피해는 [1:1문의]로 증빙자료와 함께 신고해주세요.
                    </p>
                </section>

                <section class="d-none word-category">
                    <h1>😆덕질용어 정리</h1>
                    <p>
                        거래를 하고 싶은데 용어를 모르시는 분들!🙋🏻‍♀️

                        미공포 : 미공개 포토카드
                        셀포 : 셀카 포토카드
                        컨포 : 컨셉 포토카드. 남이 찍어준 듯한 사진의 포카
                        공방포카 : 공개방송에서 주는 포토카드
                        탑로더 : 플라스틱 포토카드 보호 케이스
                        비공굿 : 비공식 굿즈
                        찍힘하자 : 찍혀서 생기는 하자
                        쓸림하자 : 쓸려서 생기는 하자
                        겹침자국 : 앨범에서 포카외의 구성품과 겹쳐서 생기는 하자
                        공정하자 : 공장에서 만들어질때 생긴 하자
                        미세하자 : 눈에 잘 띄지 않는 하자.
                        빛비춤영상 : 포토카드를 LED로 비춰 하자가 있는지 없는지 확인하는 영상.
                        준미포 : 준등기가격 미 포함.
                        준포/운포 : 준등기 가격 포함/ 운송비 포함.
                        로모카드 : 포토카드를 폴라로이드 처럼 꾸며둔 것
                        비현물 : 온라인 상에서 물건을 보고 구매하는 것
                        현물 : 오프라인으로 직접 물건을 보고 구매하는 것.
                    </p>
                </section>

                <section class="d-none method-category">
                    <h1>👩‍💻덕템 이용방법</h1>
                    <p>
                        1) 아이돌 중고 굿즈 전문 거래 플랫폼입니다. 굿즈 외의 물건은 지양해주세요.
                        - 포토카드, 응원봉, 앨범, 기타 아이돌이 들어간 문구류, 인형 등
                        - 미개봉 상품도 판매가 가능합니다!
                        2) 구매를 하고 싶은 상품은 판매자와 덕후톡을 통해서만 거래가 가능합니다.
                        - 구매를 원하는 상품 판매자와 1:1 덕후톡을 통해 대화 하세요.
                        - 덕후톡에서 비매너 회원은 신고하기 버튼으로 신고 가능하며 신고와 즉시 상대방은 차단됩니다.
                        3) 누구든지 판매를 할 수 있습니다.
                        - 팔고 싶은 굿즈가 있다면 언제든지 내 물건 판매하기를 눌러 물건을 판매할 수 있습니다.
                        - 판매글은 판매 양식 가이드를 참고 하여 작성해주세요.
                    </p>
                </section>
            </section>

            <!-- ======================= 덕템 이용 정책  ======================= -->
            <section class="d-none policy-page">
                <h1>덕템 운영정책✨</h1>

                <p>
                    덕템은 공유를 통해 덕질의 여유와 편리를 제공하는 마켓입니다.
                    누구나 사고 팔고 나누는 공간으로, 다양한 개인들이 모여 자유롭고 편리하게 안전한 거래를 할 수 있습니다.
                    서로 존중하고 배려하는 건강한 개인간거래 문화를 회원 여러분과 함께 만들어가기 위해 아래의 운영정책을 공지합니다.
                    운영정책은 개인간거래에 적합한 원칙과 기준으로 지속적으로 개선해나아가겠습니다.※
                    건강한 마켓 환경과 다수의 정상적인 회원 보호를 위해, 운영정책을 준수하지 않은 경우 덕템운영진은 관련 행위를 확인 후 결과에 따라 주의를 당부하거나, 사전안내 없이 서비스 이용을
                    한시적/영구적으로 일부 또는 전체 제한할 수 있습니다.
                    [1] 아이템/글깨끗한 마켓 환경을 위해 아이템과 글(이미지 포함)은 시스템과 모니터링, 회원신고에 따라 운영됩니다.
                    마켓 내 상업적 홍보(스팸 등), 타 서비스 유도, 도배 행위, 검색노출을 목적으로 한 다수의 키워드 삽입, 게시공간의 성격에 맞지 않는 글, 음란성 글, 잘못된 카테고리 등록,
                    무의미한(장난성) 아이템, 올바르지 않은 가격 아이템(1원 등)의 경우 사전안내 없이 수정 또는 삭제될 수 있습니다.
                    다수의 회원이 선정성(과도한 신체 노출 등), 차별적인 내용(종교, 인종 등), 성적 수치심이나 불쾌감을 유발하는 사유로 불편 신고를 한 아이템/글은 헬로마켓의 판단에 따라 수정
                    권고
                    또는 삭제될 수 있습니다.
                    덕템 서비스에 대해 타 회원에게 오해를 일으키는 등 부정적인 영향을 미칠 수 있거나, 서비스에 방해(피해)가 발생할 수 있는 글은 사전안내 없이 삭제될 수 있습니다.
                    (운영정책 위반으로 조사 중인 사안의 세부정보 또는 결과를 포함하는 내용 포함)
                    1) 거래부적합 아이템아래의 거래부적합 아이템은 이용약관 및 현행 법률에 따라 마켓 내 등록 및 거래를 금지합니다.• - 아이돌 관련 물품이 아닌 모든 것.ex)일반 의류 등 •
                    - 주류
                    • - 담배 • - 의약품 • - 도수 있는 안경, 콘택트렌즈 • - 개인정보(신분증, 게임계정 등) • - 성인용품(콘돔 제외) • - 불법복제품 • - 반려동물
                    ※ 거래부적합 아이템은 [헬프센터>1:1문의게시판]을 통해 덕템운영진에게 알려주세요.
                    [2] 회원간 매너
                    1) 서로를 존중하는 말로 대화하고, 상대가 불편함을 느낄 수 있는 표현과 거부하는 행동은 삼가해주세요. • - 욕설, 비방/비하, 명예훼손, 일방적인 반말 등은
                    ‘비매너’표현입니다 •
                    - 공개된 공간에서의 ‘비매너’ 글(닉네임 포함), 다른 회원의 개인정보 또는 대화내용을 동의없이 공개하는 글, 분쟁을 유도하는 글, 허위사실 유포 등은 금지합니다. • - 상대가
                    성희롱으로 느낄 수 있는 표현은 주의해주세요.(아이템과 관계없는 판매회원의 외모에 대한 표현, 무리한 착샷 요구 등) • - 무리한 가격 에누리, 밤늦은 시간의 덕후톡 대화 요구,
                    구매
                    강요 행위 등은 비매너 신고될 수 있습니다. • - 아이템의 높은 가격에 대한 조언은 덕후톡으로 이야기 해주세요. 모든 회원들에게 공개되는 아이템 댓글을 통한 조언은 판매회원의
                    입장에서
                    거래방해로 여겨질 수 있습니다. • - 상습적으로 마켓 내 구매아이템을 웃돈을 받아 되파는 행위로 신고될 경우 제재 사유가 될 수 있으니 유의해주세요. • - 덕템 운영진, 직원
                    또는
                    관계자를 사칭하는 행위는 엄격히 금지합니다. • - 상습적인 거래파기나 상대와 직접 만나서 거래를 약속한 후 불이행(연락두절 등)하는 행위는 제재사유가 될 수 있습니다. • -
                    거래피해
                    상대회원의 개인정보 노출은 자제해주세요. 상대회원으로부터 확인한 정보가 거래와 무관한 타인의 도용된 정보일 경우, 게시한 회원에게 피해가 발생할 수 있습니다.거래피해는 [헬프센터
                    >
                    1:1문의]로 증빙자료와 함께 신고해주세요.
                    [3] 거래후기
                    덕템 거래후기는 마켓 내 거래를 마치고 서로의 거래경험을 나누는 공간입니다. 거래후기는 추천을 포함하여 모든 회원들에게 공유되며, 다른 회원의 거래에도 도움이 될 수 있습니다.
                    신뢰할 수 있는 정직한 후기 공유를 위해 아래의 유의사항을 준수해주세요.
                    거래후기는 원칙적으로 작성한 회원이 삭제를 할 수 있습니다.
                    '비매너 표현'을 포함한 부적합한 글은 사전안내 없이 삭제될 수 있습니다.
                    후기 대상 회원의 소명요청이 접수될 경우 덕템의 신중한 검토 및 판단에 따라 아래의 부적합한 후기는 수정 또는 삭제될 수 있습니다.‘비매너’ 표현이 포함된 경우허위정보가 포함된
                    경우상대회원의 개인정보 또는 대화내용을 동의없이 공개하는 경우법령 및 상거래의 일반원칙을 위반하는 내용범죄적 행위에 결부된다고 인정되는 경우후기 및 추천을 빌미로 환불, 추가적인
                    보상,
                    상대회원에게 좋은 후기를 남기도록 강요하는 행위
                    다수의 계정을 생성하여 허위후기를 등록하는 부정행위는 금지합니다.

                </p>
            </section>

        </main>
    </div>
</template>
<script>
export default {

}
</script>
<style scoped>
@import '/css/help-center/index.css';
</style>