function deleteFans(username){
    $.ajax({
        type:"delete",
        url:"/fans/"+username,
        async:true,
        contentType: "application/json", //必须这样写
        dataType:"json",
        success:function (data) {
            alert(data.data)
            return data.data
        }
    })
}

function insertFans(username){
    $.ajax({
        type:"POST",
        url:"/fans/"+username,
        async:true,
        contentType: "application/json", //必须这样写
        dataType:"json",
        success:function (data) {
            alert(data.data)
            return data.data
        }
    })
}



$(function(){

    //搜索
    $("#searchBtn").click(function () {
        let sv = $("#searchVal").val();
        if (sv!=""){
            window.location.href="/?s="+sv;
        }

    });



    function f() {
        if ($("#username").val()==undefined)
            return

        $.ajax({
            type:"GET",
            url:"/fans/"+$("#username").val(),
            contentType: "application/json", //必须这样写
            success:function (data) {
                if (data.data){
                    updateToGz();
                } else{
                    $("#follower").removeClass("hidden")
                }
            }
        })
    }

    function updateToGz(){
        $("#follower").removeClass("hidden")
        $("#follower").removeClass("btn-success")
        $("#follower").addClass("btn-default")
        $("#follower").html("已关注")
    }

    function updateToNotGz(){
        $("#follower").removeClass("hidden")
        $("#follower").removeClass("btn-default")
        $("#follower").addClass("btn-success")
        $("#follower").html("关注")
    }



});