const autoPaging = function () {
  let paddingOfBottom = 300;
  let htmlScrollHeight = html.scrollHeight;
  let htmlScrollTop = html.scrollTop;
  let htmlScrollClientHeight = html.clientHeight;

  let tempHeart = null;

  if (htmlScrollHeight - htmlScrollTop - paddingOfBottom <= htmlScrollClientHeight && updateList) {
    updateList = false;

    fetch(`/${page}`)
      .then((response) => response.json())
      .then((products) => {
        loading.classList.remove('d-none');
        if (products.length < 10) {
          isEndPage = true;
        }
        setTimeout(() => {
          for (let product of products) {
            if (product.status == 1) tempHeart = `<img class="wish" src="/image/icon/icon-heart-red.svg" alt="찜" data-id="${product.productId}">`;
            else tempHeart = `<img class="wish" src="/image/icon/heart.svg" alt="찜" data-id="${product.productId}">`;

            let template = `
   <div class="product-container" data-location="${product.productId}">
      <div><img src=${product.thumbNailImg} alt="product-img"></div>

      <div class="price-wish">
         <span>${product.price} 원</span>
         ${tempHeart}
      </div>

      <div class="name">
         ${product.name}
      </div>

      <div class="time">
         ${product.ntimeAgo}
      </div>
   </div>`;
            productSection.insertAdjacentHTML('beforeend', template);
          }
          updateList = true;
          loading.classList.add('d-none');
        }, 500);
      });
    page++;
    if (isEndPage) {
      window.removeEventListener('scroll', autoPaging);
    }
  }
};
window.addEventListener('scroll', autoPaging);
