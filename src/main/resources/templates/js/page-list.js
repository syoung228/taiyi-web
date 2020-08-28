$(function() {
    $("#myPage").sPage({
        page: 1, //当前页码，必填
        total: 150, //数据总条数，必填
        pageSize: 10, //每页显示多少条数据，默认10条
        showTotal: false, //是否显示总条数，默认关闭：false
        totalTxt: "共{total}条", //数据总条数文字描述，{total}为占位符，默认"共{total}条"
        noData: false, //没有数据时是否显示分页，默认false不显示，true显示第一页
        showSkip: false, //是否显示跳页，默认关闭：false
        showPN: true, //是否显示上下翻页，默认开启：true
        prevPage: "上一页", //上翻页文字描述，默认“上一页”
        nextPage: "下一页", //下翻页文字描述，默认“下一页”
        fastForward: 5, //快进快退页数，默认0表示不开启快进快退
        backFun: function(page) {
            //点击分页按钮回调函数，返回当前页码
        }
    });
});