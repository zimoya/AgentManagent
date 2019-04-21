$(function () {
    bindFinanceType();
    InitadvancePay();
    FindadvancePay();
})

/**
 * 绑定财务类型
 */
function bindFinanceType(){
    $.ajax({
        type:"GET",
        url:"/agent/finance/financeType.json",
        data:{typeParentId:27},
        dataType:"json",
        async:false,
        success:function (data) {
            $("#u2_input").append(" <option value='0'>请选择</option>");
            $.each(data,function (i,e) {
                $("#u2_input").append("<option value="+e.typeid+">"+e.typename+"</option>")
            })
        },
        error:function (data) {
            alert("网络异常");
        }
    })
}

var page=0;

/**
 * 窗体加载时显示财务信息
 * @constructor
 */
function InitadvancePay(){
    var finatype=$("#u2_input option:selected").val();
    alert(finatype);
    var time1=ConvertStrToDate($("#time1").val());
    var time2=ConvertStrToDate($("#time2").val());
    $.ajax({
        type:"GET",
        url:"/agent/user/UsersDetail",
        data:{finatype:finatype,createTime1:time1,createTime2:time2,pageSum:page},
        dataType: "json",
        success:function (data) {
            $("#tr").siblings().remove();
            $.each(data.content,function (i,e) {
                $("table").append("<tr>" +
                                    "<td>"+i+1+"</td>" +
                                    "<td>"+e.finatype+"</td>" +
                                    "<td>"+e.operationmoney+"</td>" +
                                    "<td>"+e.balance+"</td>" +
                                    "<td>"+e.description+"</td>" +
                                    "<td>"+e.createtime+"</td></tr>")
            })
        },
        error:function (data) {
            alert("网络异常");
        }
    })
}

/**
 * 点击查询绑定预付款信息
 */
function FindadvancePay(){
    $("#img").click(function () {
        alert("Sss");
        InitadvancePay();
    })
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