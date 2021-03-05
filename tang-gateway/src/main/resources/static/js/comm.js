function comment(vboId,text){
    $.ajax({
        type:"POST",
        url:"/vbo/comment",
        contentType: "application/json",
        data:JSON.stringify({
            "vboId":vboId,
            "text":text
        }),
        success(result) {
           alert(result)
        }
    })
}

function commentBut(id){
    $("#commentHead").html($("#" + id).html())
}