var mySwiper = new Swiper('.ly-ban', {
    autoplay: {
        delay: 5000,
        stopOnLastSlide: false,
        disableOnInteraction: true
    },
    loop: true,
    pagination: {
        el: '.swiper-pagination',
        clickable: true
    }
});

$(".ly-case-btn li").eq(0).addClass("ly-active");
$(".ly-case-list").eq(0).addClass("ly-active");
$(".ly-case-btn").on("click","li", function () {
    let id = $(this).index();
    $(this).addClass("ly-active").siblings().removeClass("ly-active");
    $(".ly-case-list").removeClass("ly-active");
    $(".ly-case-list").eq(id).addClass("ly-active");
})

$(".ly-news-btn li").eq(0).addClass("ly-active");
$(".ly-news-list").eq(0).addClass("ly-active");
$(".ly-news-btn").on("click","li", function () {
    let id = $(this).index();
    $(this).addClass("ly-active").siblings().removeClass("ly-active");
    $(".ly-news-list").removeClass("ly-active");
    $(".ly-news-list").eq(id).addClass("ly-active");
})


$(".ly-progress-lists li").eq(0).addClass("ly-active");
$(".ly-progress-lists").on("click","li", function () {
    let id = $(this).index();
    $(this).addClass("ly-active").siblings().removeClass("ly-active");
})



$(".ly-xi li").eq(0).addClass("ly-active");
$(".ly-wen").eq(0).addClass("ly-active");
$(".ly-xi").on("click","li", function () {
    let id = $(this).index();
    $(this).addClass("ly-active").siblings().removeClass("ly-active");
    $(".ly-wen").removeClass("ly-active");
    $(".ly-wen").eq(id).addClass("ly-active");
})




