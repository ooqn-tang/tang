function deleteFans(username){
    $.ajax({
        type:"delete",
        url:"/fans/"+username,
        async:true,
        contentType: "application/json", //必须这样写
        dataType:"json",
        success:function (data) {
            alert(data)
            return data
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
    $("#follower").html("已订阅")
}
function updateToNotGz(){
    $("#follower").removeClass("hidden")
    $("#follower").removeClass("btn-default")
    $("#follower").addClass("btn-success")
    $("#follower").html("订阅")
}
function getQueryVariable(variable){
    let query = window.location.search.substring(1);
    let vars = query.split("&");
    for (let i=0;i<vars.length;i++) {
        let pair = vars[i].split("=");
        if(pair[0] == variable){return pair[1];}
    }
    return null;
}
function UrlUpdateParams(url, name, value) {
    let r = url;
    if (r != null && r != 'undefined' && r != "") {
        value = encodeURIComponent(value);
        let reg = new RegExp("(^|)" + name + "=([^&]*)(|$)");
        let tmp = name + "=" + value;
        if (url.match(reg) != null) {
            r = url.replace(eval(reg), tmp);
        }
        else {
            if (url.match("[\?]")) {
                r = url + "&" + tmp;
            } else {
                r = url + "?" + tmp;
            }
        }
    }
    return r;
}
function sleep(numberMillis) {
    var now = new Date();
    var exitTime = now.getTime() + numberMillis;
    while (true) {
        now = new Date();
        if (now.getTime() > exitTime)
            return;
    }
}
function toData(data){
    let ret = ''
    for(let it in data) {
        ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'
    }
    return ret
}
function changeURLArg(url,arg,arg_val){
    let pattern=arg+'=([^&]*)';
    let replaceText=arg+'='+arg_val;
    if(url.match(pattern)){
        let tmp='/('+ arg+'=)([^&]*)/gi';
        tmp=url.replace(eval(tmp),replaceText);
        return tmp;
    }else{
        if(url.match('[\?]')){
            return url+'&'+replaceText;
        }else{
            return url+'?'+replaceText;
        }
    }
}

String.prototype.signMix= function() {
    if(arguments.length === 0) return this;
    let param = arguments[0], str= this;
    if(typeof(param) === 'object') {
        for(let key in param)
            str = str.replace(new RegExp("\\{" + key + "\\}", "g"), param[key]);
        return str;
    } else {
        for(let i = 0; i < arguments.length; i++)
            str = str.replace(new RegExp("\\{" + i + "\\}", "g"), arguments[i]);
        return str;
    }
}


$.ajaxSetup({
    dataType: "json",
    cache: false,
    xhrFields: {
        withCredentials: true
    },
    complete(xhr) {
        if(xhr.status === 401){
            alert("请登录")
            throw "请登录";
        }
    }
});

let URL = /(https?:\/\/|ftps?:\/\/)?((\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3})(:[0-9]+)?|(localhost)(:[0-9]+)?|([\w]+\.)(\S+)(\w{2,4})(:[0-9]+)?)(\/?([\w#!:.?+=&%@!\-\/]+))?/ig;
let toLink = function (text) {
    text = text.replace(URL, function (url) {
        let urlText = url;
        if (!url.match('^https?:\/\/')) {
            url = 'http://' + url;
        }
        return '<a href="' + urlText + '" target="_blank"><span class="glyphicon glyphicon-link" style="font-size: 12px"></span>网页链接</a>';
    });
    return text;
};