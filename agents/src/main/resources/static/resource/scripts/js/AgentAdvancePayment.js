$(function () {
    bindFinanceType();
    advancePay();
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
        success:function (data) {
            $.each(data,function (i,e) {
                $("#u2_input").append("<option value="+e.typeid+">"+e.typename+"</option>")
            })
        },
        error:function (data) {
            alert("网络异常");
        }
    })
}

/**
 * 绑定预付款信息
 */
function advancePay(){
    var option=$("#u2_input option:selected")
    alert(option.val());
}