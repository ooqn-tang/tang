$(function(){

    //搜索
    $("#searchBtn").click(function () {
        let sv = $("#searchVal").val();
        if (sv!=""){
            window.location.href="/?s="+sv;
        }

    });

    $("#follower").click(function(){
        if ($("#follower").html() =="已关注" ){
            $.ajax({
                type:"delete",
                url:"/fans/"+$("#username").val(),
                contentType: "application/json", //必须这样写
                dataType:"json",
                success:function (data) {
                    if (data.state=='00'){
                        updateToNotGz()
                    } else {
                        alert(data.msg)
                    }
                }
            })
        }else{
            $.ajax({
                type:"POST",
                url:"/fans/"+$("#username").val(),
                contentType: "application/json", //必须这样写
                dataType:"json",
                success:function (data) {
                    if (data.state=='00'){
                        updateToGz();
                    }
                    if (data.state=='44'){
                        alert(data.msg)
                    }
                }
            })
        }

    })

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

    f();


});