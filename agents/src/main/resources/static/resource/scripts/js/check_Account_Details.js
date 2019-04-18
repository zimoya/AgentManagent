/*查看账户明细功能js*/
$(function () {
    init('2013/10/23 ','',0);
    /**
     * 页码点击事件
     */
    $(".div div span ").click(function () {
        $(this).css("background","ghostwhite");
        $(this).siblings().css("background","");
    })
})
function init(createTime1,createTime2,pageSum){
    //调用ConvertStrToDate方法将字符串转日期
   var  createTime3=ConvertStrToDate(createTime1);
   var  createTime4=ConvertStrToDate(createTime2);

    /*查看账户明细*/
    $.ajax({
        type:"GET",
        url:"/agent/user/UsersDetail",
        data:{createTime1:createTime3,createTime2:createTime4,pageSum:pageSum},
        dataType:"json",
        success:function(data){

            //数据
           $("#div_table table tr:gt(0)").html("");
            $(data.content).each(function (i,e){
                $("#div_table table").append("<tr>\n" +
                    "<td>"+(i+1)+"</td>\n" +
                    "<td>"+e.finatype+"</td>\n" +
                    "<td>￥"+e.operationmoney+"</td>\n" +
                    "<td>￥"+e.balance+"</td>\n" +
                    "<td>"+e.description+"</td>" +
                    "<td>"+e.createtime+"</td></tr>");
            });
            $("div_table .div").remove();
            //页数操作
            if(data.totalPages>1){
                alert("sss");
                $("#div_table .div ").append("<div><span  name='0'>首页</span></div>");
                for (var i=0;0<data.totalPages;i++){
                    $("#div_table .div div").append("<span name='"+i+"'>(i+1))</span>");
                }
                $("#div_table .div div").append("<span  name='"+(data.totalPages-1)+"'>首页</span>");
            }
        },
        error:function(data){
            alert("网络异常");
        }
    });

}
//把字符串日期转为日期
function ConvertStrToDate(datetimeStr) {
    var mydateint = Date.parse(datetimeStr);//数值格式的时间
    if (!isNaN(mydateint)) {
        var mydate = new Date(mydateint);
        return mydate;
    }
    var mydate = new Date(datetimeStr);//字符串格式时间
    var monthstr = mydate.getMonth() + 1;
    if (!isNaN(monthstr)) {//转化成功
        return mydate;
    }//字符串格式时间转化失败
    var dateParts = datetimeStr.split(" ");
    var dateToday = new Date();
    var year = dateToday.getFullYear();
    var month = dateToday.getMonth();
    var day = dateToday.getDate();
    if (dateParts.length >= 1) {
        var dataPart = dateParts[0].split("-");//yyyy-mm-dd  格式时间
        if (dataPart.length == 1) {
            dataPart = dateParts[0].split("/");//yyyy/mm/dd格式时间
        }
        if (dataPart.length == 3) {
            year = Math.floor(dataPart[0]);
            month = Math.floor(dataPart[1]) - 1;
            day = Math.floor(dataPart[2]);
        }
    }
    if (dateParts.length == 2) {//hh:mm:ss格式时间
        var timePart = dateParts[1].split(":");//hh:mm:ss格式时间
        if (timePart.length == 3) {
            var hour = Math.floor(timePart[0]);
            var minute = Math.floor(timePart[1]);
            var second = Math.floor(timePart[2]);
            return new Date(year, month, day, hour, minute, second);
        }
    }
    else {
        return new Date(year, month, day);
    }
}
