let login = new Vue({
    el:"#loginModal",
    data:{
        zc:true,
        dl:false,
        title:"登录",
        yzm:"验证码",
        author:{
            username:"",
            password:"",
            confirmPassword:"",
            verify:"",
            mail:"",
            'remember-me':true
        },
        mailCount:0,
        verifyUrl:""
    },
    methods: {
        login(){
            let _this = this
            $.ajax({
                type:"POST",
                url:"/doLogin",
                contentType: "application/x-www-form-urlencoded",
                data:_this.author,
                dataType:"JSON",
                xhrFields: {
                    withCredentials: true
                },
                error:function (err){
                    if(err.responseText == "登录成功"){
                        location.reload();
                    }else{
                        alert(err.responseText)
                        _this.rImg()
                    }
                }
            });
        },
        rImg(){
            this.verifyUrl = "/verify?t=" + Date.parse(new Date())
        },
        sendVerify(){
            let _this = this
            _this.mailCount = 60
            $.ajax({
                type:"POST",
                url:"/verifyMail/" + _this.author.mail
            });
            setInterval(() => {
                setTimeout(function(){
                    _this.mailCount -= 1
                },0)
            }, 1000)
        },
        register(){
            let _this = this;
            if (this.author.password === this.author.confirmPassword){
                $.ajax({
                    type:"POST",
                    url:"/author/register",
                    contentType: "application/json;charset=UTF-8",
                    data:JSON.stringify(_this.author),
                    dataType:"JSON",
                    success:function(result){
                        alert(result)
                    },
                    error(e){
                        alert(JSON.stringify(e.responseText))
                        _this.rImg()
                    }
                });
                return
            }
            alert("两次密码不一致")
        },
        password(){
            let _this = this;
            if (this.author.password === this.author.confirmPassword) {
                $.ajax({
                    type: "POST",
                    url: "/author/password",
                    contentType: "application/json;charset=UTF-8",
                    data: JSON.stringify(_this.author),
                    dataType: "JSON",
                    success: function (result) {
                        alert(result)
                    }
                });
                return
            }
            alert("两次密码不一致")
        }
    },
    mounted(){
        this.rImg()
    }
})


let vm = new Vue({
    el: "#app",
    data: {
        blogId:'cb742fa84cdc4e20bb6d9ab4f26688b3',
        username:'bobcbui',
        author:"" == "",
        follower:{
            text:"订阅",
        },
        comments: [],
        content:"",
        pl:1,
        commentUsername:"",
    },
    methods: {
        updateBlog(){
            window.location.href='/editor/'+this.blogId
        },
        likeClick(){
            if (this.author){
                $('#loginModal').modal("show")
                return
            }
            $.ajax({
                type:"GET",
                url:"/blog/like/"+this.blogId+"/insert",
                contentType: "application/json",
                success:function (result) {
                    let lkBut = $("#lkBut")
                    if (result === 1){
                        lkBut.removeClass();
                        lkBut.addClass("btn btn-danger  btn-xs")
                    }else{
                        lkBut.removeClass();
                        lkBut.addClass("btn btn-default btn-xs")
                    }
                }
            })
        },
        followerClick(){
            let _this = this
            if (this.author){
                $('#loginModal').modal("show")
                return
            }
            if (_this.username == null){
                return
            }
            if (_this.follower.text === '已订阅'){
                $.ajax({
                    type:"post",
                    url:"/fans/delete/"+_this.username,
                    contentType: "application/json",
                    dataType:"json",
                    success() {
                        _this.follower.text  = "订阅"
                    },
                    error(e){
                        alert(e)
                    }
                })

            }else{
                $.ajax({
                    type:"post",
                    url:"/fans/insert/"+_this.username,
                    contentType: "application/json",
                    dataType:"json",
                    success() {
                        _this.follower.text  = "已订阅"
                    },
                    error(e){
                        alert(e)
                    }
                })
            }
        },
        loadFollower(){
            if (this.author){
                return
            }
            let _this = this;
            $.ajax({
                type:"GET",
                url:"/fans/"+_this.username,
                contentType: "application/json",
                success:function (result) {
                    if (result){
                        _this.follower.text = '已订阅'
                    } else{
                        _this.follower.text = '订阅'
                    }
                }
            })
        },
        send(){
            let _this = this;
            let dataObject = {
                blogId:this.blogId,
                content:this.content
            };
            $.ajax({
                type:"POST",
                url:"/comment/insert",
                contentType: "application/json", //必须这样写
                dataType:"json",
                data:JSON.stringify(dataObject),
                async:false,
                success:function (result) {
                    _this.content = "";
                    _this.comments.push(result);
                }
            })
        },
        loadComment(){
            $.ajax({
                type:"GET",
                url:"/comment/"+this.blogId,
                contentType: "application/json",
                dataType:"json",
                success:function (result) {
                    sleep(500)
                    vm.comments = result.comments;
                    vm.commentUsername = result.author.username;
                }
            })
        },
        commentClick(){
            if (this.pl % 2 !== 0){
                $("#blog-body").css("height","90px").css("overflow-x","auto");
                $("#commentBody").css("height",(window.innerHeight-254)+"px");
                $(".advertise").addClass("hidden-xs hidden-sm");
            } else{
                $("#blog-body").css("height","").css("overflow-x","");
                $("#commentBody").css("height","");
                $(".advertise").removeClass("hidden-xs hidden-sm");
            }
            this.pl++;
        },
        deleteComment(id,index){
            let _this = this;
            $.ajax({
                type:"POST",
                url:"/comment/delete/"+id,
                contentType: "application/json", //必须这样写
                dataType:"json",
                success:function (data) {
                    _this.comments.splice(index, 1);
                }
            })
        }
    },created(){
        this.loadFollower();
        this.loadComment();
    }
})

let setting = new Vue({
    el: "#setting",
    data:{
        author:{
            nickname:"[[${utsAuthorLogin.nickname}]]",
            signature:"[[${utsAuthorLogin.signature}]]",
            username:'[[${utsAuthorLogin.username}]]'
        }
    }, methods: {
        updateAuthor(){
            let _this = this
            $.ajax({
                type : "POST",
                contentType: "application/json",
                url : "/author/update",
                data : JSON.stringify({
                    nickname:_this.author.nickname,
                    signature:_this.author.signature
                }),
                success(result) {
                    history.go(-1);
                },
                error(e){
                    alert(e.responseText);
                }
            })
        }
    },mounted(){

    }
})

let blog_vm = new Vue({
    el: "#blog",
    data: {
        blogId:'[[${dtsBlogDto.id}]]',
        username:'[[${dtsBlogDto.username}]]',
        author:"[[${session.SPRING_SECURITY_CONTEXT}]]" == "",
        follower:{
            text:"订阅",
        },
        comments: [],
        content:"",
        pl:1,
        commentUsername:"",
    },
    methods: {
        updateBlog(){
            window.location.href='/editor/'+this.blogId
        },
        likeClick(){
            if (this.author){
                $('#loginModal').modal("show")
                return
            }
            $.ajax({
                type:"GET",
                url:"/blog/like/"+this.blogId+"/insert",
                contentType: "application/json",
                success:function (result) {
                    let lkBut = $("#lkBut")
                    if (result === 1){
                        lkBut.removeClass();
                        lkBut.addClass("btn btn-danger  btn-xs")
                    }else{
                        lkBut.removeClass();
                        lkBut.addClass("btn btn-default btn-xs")
                    }
                }
            })
        },
        followerClick(){
            let _this = this
            if (this.author){
                $('#loginModal').modal("show")
                return
            }
            if (_this.username == null){
                return
            }
            if (_this.follower.text === '已订阅'){
                $.ajax({
                    type:"post",
                    url:"/fans/delete/"+_this.username,
                    contentType: "application/json",
                    dataType:"json",
                    success() {
                        _this.follower.text  = "订阅"
                    },
                    error(e){
                        alert(e)
                    }
                })

            }else{
                $.ajax({
                    type:"post",
                    url:"/fans/insert/"+_this.username,
                    contentType: "application/json",
                    dataType:"json",
                    success() {
                        _this.follower.text  = "已订阅"
                    },
                    error(e){
                        alert(e)
                    }
                })
            }
        },
        loadFollower(){
            if (this.author){
                return
            }
            let _this = this;
            $.ajax({
                type:"GET",
                url:"/fans/"+_this.username,
                contentType: "application/json",
                success:function (result) {
                    if (result){
                        _this.follower.text = '已订阅'
                    } else{
                        _this.follower.text = '订阅'
                    }
                }
            })
        },
        send(){
            let _this = this;
            let dataObject = {
                blogId:this.blogId,
                content:this.content
            };
            $.ajax({
                type:"POST",
                url:"/comment/insert",
                contentType: "application/json", //必须这样写
                dataType:"json",
                data:JSON.stringify(dataObject),
                async:false,
                success:function (result) {
                    _this.content = "";
                    _this.comments.push(result);
                }
            })
        },
        loadComment(){
            $.ajax({
                type:"GET",
                url:"/comment/"+this.blogId,
                contentType: "application/json",
                dataType:"json",
                success:function (result) {
                    sleep(500)
                    blog_vm.comments = result.comments;
                    blog_vm.commentUsername = result.author.username;
                }
            })
        },
        commentClick(){
            if (this.pl % 2 !== 0){
                $("#blog-body").css("height","90px").css("overflow-x","auto");
                $("#commentBody").css("height",(window.innerHeight-254)+"px");
                $(".advertise").addClass("hidden-xs hidden-sm");
            } else{
                $("#blog-body").css("height","").css("overflow-x","");
                $("#commentBody").css("height","");
                $(".advertise").removeClass("hidden-xs hidden-sm");
            }
            this.pl++;
        },
        deleteComment(id,index){
            let _this = this;
            $.ajax({
                type:"POST",
                url:"/comment/delete/"+id,
                contentType: "application/json", //必须这样写
                dataType:"json",
                success:function (data) {
                    _this.comments.splice(index, 1);
                }
            })
        }
    },created(){
        this.loadFollower();
        this.loadComment();
    }
})

let author_vm = new Vue({
    el: "#author",//绑定元素
    //所有数据都放在数据属性中
    data:{
        author: '[[${session.SPRING_SECURITY_CONTEXT}]]' == '',
        isLoginUser:[[${session.SPRING_SECURITY_CONTEXT != null}]], // 表示登录的用户
        isThisUser:[[${session.SPRING_SECURITY_CONTEXT !=null && session.SPRING_SECURITY_CONTEXT.authentication.principal.username == username}]], // 表示访问自己的首页
        username:'[[${utsAuthorLogin.username}]]',
        fansList:[],
        showFans:false,
        update:true,
        selectType:"author.html",
        pageNum:1,
        follower:"订阅",
        show:false,
        blogList: [],
        blog:{
            list:[],
            isFirstPage:false,
            isLastPage:true,
        }
    }, methods: {
        logout(){
            if(confirm("确认退出账号吗？")){
                $.ajax({ url: "/logout", type: 'get', async: false})
                history.go(0)
            }
        },
        updateBlog(id){
            window.open('/editor/'+id)
        },
        cl(){
            this.pageNum = 1
        },
        deleteBlog(item,index){
            let _this = this;
            if(confirm("确认删除吗？")){
                $.ajax({
                    type:"GET",
                    url:"/blog/delete/"+item.id,
                    contentType: "application/json",
                    dataType: "text",
                    success:function (result) {
                        _this.blogList.splice(index,1)
                    }
                })
            }
        },
        followerClick(){
            if (this.author){
                $('#loginModal').modal("show")
                return
            }
            let _this = this;
            let type,text;
            if (_this.follower === '已订阅'){
                type = "delete";
                text = "订阅"
            } else{
                type = "insert";
                text = "已订阅"
            }
            $.ajax({
                type:"post",
                url:"/fans/" + type + "/" + _this.username,
                contentType: "application/json", //必须这样写
                dataType:"json",
                success:function (result) {
                    _this.follower = text;
                }
            })
        },
        loadFans(){
            let _this = this;
            if (this.isLoginUser){
                $.ajax({
                    type:"GET",
                    url:"/fans/"+ _this.username,
                    contentType: "application/json", //必须这样写
                    success:function (result) {
                        if (result){
                            _this.follower = '订阅'
                        } else{
                            _this.follower = '已订阅'
                        }
                    }
                })
            }
        },
        more(page){
            this.pageNum = page
            this.page()
        },
        loadAuthor() {
            let _this = this;
            _this.show = false
            _this.update = true;
            _this.selectType = "author"
            $.ajax({
                type:"GET",
                url:"/blog/home/"+_this.username,
                contentType: "application/json", //必须这样写
                data:{
                    page:_this.pageNum
                },
                success:function (result) {
                    _this.blog = result
                    _this.blogList = _this.blogList.concat(result.list)
                    sleep(300)
                    _this.show = true
                }
            })
        },
        like(){
            let _this = this;
            _this.show = false
            this.update = false;
            this.selectType = "like"
            $.ajax({
                type:"GET",
                url:"/blog/like",
                contentType: "application/json", //必须这样写
                data:{
                    page:_this.pageNum,
                    username:_this.username
                },
                success:function (result) {
                    _this.blog = result
                    _this.blogList = _this.blogList.concat(result.list)
                    sleep(300)
                    _this.show = true
                }
            })
        },
        fans(){
            if (this.showFans){
                this.showFans = false;
                return
            }
            let _this = this;
            $.ajax({
                type:"GET",
                url:"/fans/list",
                contentType: "application/json", //必须这样写
                success:function (result) {
                    _this.fansList = result
                    _this.showFans = true;
                }
            })
        },
        page(){
            let type = this.selectType
            this.blog = {}
            this.show = false
            if (type === "author"){
                this.loadAuthor()
            }
            if (type === "like"){
                this.like()
            }
        }
    },mounted(){
        this.loadFans()
        this.loadAuthor()
    }
})

let index_vm = new Vue({
    el: "#index",//绑定元素
    data(){
        return {
            pageNum:1,
            show:false,
            blogList:[],
            tagList:["java","python","C++","C#","Vue","JS","Pandas","爬虫","日志","openpyxl","springboot","db2","redis","mangodb","springsecurity","程序员","游戏","相亲"],
            blog:{
                list:[],
                isFirstPage:false,
                isLastPage:true,
            }
        }
    }, methods: {
        st(tag){
            this.show = false
            this.blogList = []
            this.search(tag)
        },
        page(){
            let search;
            this.show = false
            try{
                search = getQueryVariable("s");
            }catch(err){
                console.log(err)
            }
            if (search !== null){
                this.search(search)
            }else{
                this.blogs()
            }
        },
        blogs(){
            let _this = this

            $.ajax({
                type:"GET",
                url:"/blog/blogs",
                contentType: "application/json",
                data:{
                    page:_this.pageNum
                },
                success(result) {
                    _this.blog =result
                    _this.blogList = _this.blogList.concat(result.list)
                    sleep(500)
                    _this.show = true
                },error(){
                    alert("加载失败了？")
                }
            })
        },
        search(search){
            let _this = this
            $.ajax({
                type:"GET",
                url:"/blog/so",
                contentType: "application/json",
                data:{
                    page:_this.pageNum,
                    search:search
                },
                success:function (result) {
                    _this.blog = result
                    _this.blogList = _this.blogList.concat(result.list)
                    sleep(500)
                    _this.show = true
                },error(){
                    alert("加载失败了？")
                }
            })
        }
    },mounted(){
        this.page()
    }
})