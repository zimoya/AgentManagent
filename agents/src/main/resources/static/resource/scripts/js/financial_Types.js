$(function () {
    init();
    $(".div div span ").click(function () {
        $(this).css("background","ghostwhite");
        $(this).siblings().css("background","");
    });
    $("#div_insert img").click(function () {
        $("#insert").show();
    });
    $(".esc").click(function () {
        $("input[type=text]").val("");
        $("#insert").hide();
        $("#update").hide();
    });
    $(".up").click(function () {
        var name=$(this).attr("name");
        var id=$(this).attr("id");
        $("#update input[type=text]").val(name);
        $(".upSub").attr("id",id);
        $("#update").show();
    });
});
function init(){
    /*查看财务类型*/
    $.ajax({
        type:"GET",
        url:"/agent/finance/financeType.json",
        data:{typeParentId:27},
        dataType:"json",
        success:function(data){

            //数据
           $("#div_table table tr:gt(0)").html("");
            $(data).each(function (i,e){
                var stats;
                if(e.status==0){
                    stats="启用";
                }else{
                    stats="禁用";
                }
                $("#div_table table").append("<tr>\n" +
                    "<td>"+(i+1)+"</td>\n" +
                    "<td>"+e.typename+"</td>\n" +
                    "<td>"+stats+"</td>\n" +
                    "<td> <div id="+e.typeid+"> <div><a href='javascript:void(0)' class='up' name="+e.typename+" >修改</a></div>"+
                     "<div><a href='javascript:void(0)'  >删除</a> </div>  </div> </td>");
            });
            $("#div_table .div").html("");
          /*  //页数操作
            if(data.totalPages>1){
                var pages=data.totalPages;
                $("#div_table .div ").append("<div><span  names='0'>首页</span></div>");
                for (var i=0;i<pages;i++){
                    $("#div_table .div div").append("<span  names='"+i+"'>"+(i+1)+"</span>");
                }
                $("#div_table .div div").append("<span   names='"+(pages-1)+"'>尾页</span>");
            }*/
        },
        error:function(data){
            alert("网络异常");
        }
    });
}
