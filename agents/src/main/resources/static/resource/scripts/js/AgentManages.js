$(function () {
    bindName();
    exit();
})

/**
 * 绑定用户名
 */
function bindName(){
    $.ajax({
        type:"GET",
        url:"/agent/user/userInfo",
        dataType:"json",
        async:false,
        success:function(data){
            $("#names").html(data.name);
        },
        error:function(data){
            alert("网络延迟");
        }
    });
}

/**
 * 退出
 */
function exit(){
    $("#exit").click(function () {
        $.ajax({
            type: "GET",
            url: "/agent/user/logout.json",
            dataType: "json",
            success:function (data) {
                if(data=="true"){
                    location.href="/agent/user/login";
                }
            },
            error:function (data) {
                alert("网络异常")
            }
        })
    })
}