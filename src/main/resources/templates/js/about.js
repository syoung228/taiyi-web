var width = window.innerWidth,
    number = 4

if (width <= 760) {
    number = 1
}

var swiper = new Swiper('.ly-intell', {
    slidesPerView: number,
    spaceBetween: 20,
    slidesPerGroup: 2,
    loop: true,
    autoplay: {
        delay: 3000,
        stopOnLastSlide: false,
        disableOnInteraction: true
    },
    navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
    },
});

var responsibility = new Swiper('.ly-respons', {
    slidesPerView: 1,
    spaceBetween: 0,
    loop: true,
    autoplay: {
        delay: 4000,
        stopOnLastSlide: false,
        disableOnInteraction: true
    },
    pagination: {
        el: '.swiper-pagination',
        clickable: true,
    },
});