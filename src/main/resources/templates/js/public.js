(function(doc, win, undefined) {
    var docEl = doc.documentElement,
        resizeEvt = 'orientationchange' in win ? 'orientationchange' : 'resize',
        recalc = function() {
            var clientWidth = docEl.clientWidth;
            if (clientWidth === undefined) return;
            docEl.style.fontSize = 20 * (clientWidth / 375) + 'px';
        };
    if (doc.addEventListener === undefined) return;
    win.addEventListener(resizeEvt, recalc, false);
    doc.addEventListener('DOMContentLoaded', recalc, false)
})(document, window);

$(function() {
    $(".ly-menu").on("click", function() {
        var id = $(this).attr("data-id");
        if (id == 1) {
            $(this).addClass("ly-cation");
            $(".ly-nav-list").animate({
                right: "0"
            }, 200)
            $(this).attr("data-id", 2);
        } else {
            $(this).removeClass("ly-cation");
            $(".ly-nav-list").animate({
                right: "-8rem"
            }, 200)
            $(this).attr("data-id", 1);
        }
    })
});
setTimeout(function() {
    var number = 0;
    $(".ly-nav li dl").each(function() {
        number = $(this).children("a").length;
        if (number > 0) {
            $(this).siblings().addClass("ly-min");
        }
    })
}, 500);

setTimeout(function() {
    $(".ly-layer").show();
}, 6000)


function closeLayer() {
    $(".ly-layer").hide();
    setInterval(() => {
        $(".ly-layer").show();
    }, 30000)
}
$(".ly-make").click(function() {
    $(".ly-layer").show();
})

$(".ly-layer-btn").click(function() {
    $(".ly-layer").hide();
})

$(".ly-back").on("click", function() {
    $('html,body').animate({ scrollTop: 0 }, 800);
});