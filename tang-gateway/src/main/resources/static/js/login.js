Vue.component('login', {
    template: `
    <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" data-backdrop="static" aria-hidden="true">
        <form>
            <div class="modal-content">
                <!--Modal 标题-->
                <div class="modal-header">
                    <h4 class="modal-title text-center" v-text="title"></h4>
                </div>
                <div class="modal-body" id = "model-body">
                    <!--注册，忘记密码邮箱-->
                    <label v-if="title == '注册' || title == '忘记密码'">邮箱：</label>
                    <div class="form-group" v-if="title == '注册' || title == '忘记密码'">
                        <input type="text" class="form-control" placeholder="邮箱号" v-model="author.mail" autocomplete="off">
                    </div>
                    <!--登录时显示-->
                    <label v-if="title == '登录'">邮箱 / 用户名：</label>
                    <div class="form-group" v-if="title == '登录'">
                        <input type="text" class="form-control" placeholder="用户名" v-model="author.username" autocomplete="off">
                    </div>
                    <label>密码：</label>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="密码" v-model="author.password" autocomplete="off">
                    </div>
                    <label v-if="title == '注册' || title == '忘记密码'">确认密码：</label>
                    <div class="form-group" v-if="title == '注册' || title == '忘记密码'">
                        <input type="password" class="form-control" placeholder="密码" v-model="author.confirmPassword" autocomplete="off">
                    </div>
                    <label v-text="yzm + (mailCount > 0 ? mailCount : '')"></label>
                    <div class="input-group">
                        <input type="text" class="form-control" v-model="author.verify">
                        <span v-if="title == '登录'" class="input-group-addon" style="padding: 0"><img alt="验证码" @click="rImg" v-bind:src="verifyUrl" height="32"/> </span>
                        <span class="input-group-btn" v-if="title != '登录'">
                            <button class="btn btn-default" type="button" @click="sendVerify">获取验证码</button>
                        </span>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="btn-group W100" style="margin-bottom: 10px" v-if="title == '登录'">
                        <button type="button" class="btn btn-primary W100" @click="login()">登录</button>
                    </div>
                    <div class="btn-group W100" style="margin-bottom: 10px" v-if="title == '注册'">
                        <button type="button" class="btn btn-primary W100" @click="register()">确认注册</button>
                    </div>
                    <div class="btn-group W100" style="margin-bottom: 10px" v-if="title == '忘记密码'">
                        <button type="button" class="btn btn-primary W100"  @click="password()">修改密码</button>
                    </div>
                    <div class="btn-group W100" style="margin-bottom: 10px">
                        <a type="button" class="btn btn-default W33" @click="title='登录',yzm='验证码：'">账户登录</a>
                        <a type="button" class="btn btn-default W33" @click="title='注册',yzm='邮箱验证码：'">注册账户</a>
                        <a type="button" class="btn btn-default W34" @click="title='忘记密码',yzm='邮箱验证码：'">忘记密码</a>
                    </div>
                    <div class="btn-group W100">
                        <button type="button" class="btn btn-default W100" data-dismiss="modal">取消登录</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
  `,
    data() {
        return {
            zc: true,
            dl: false,
            title: "登录",
            yzm: "验证码",
            author: {
                username: "",
                password: "",
                confirmPassword: "",
                verify: "",
                mail: "",
                'remember-me': true
            },
            mailCount: 0,
            verifyUrl: ""
        }
    }, methods: {
        login() {
            let _this = this
            $.ajax({
                type: "POST",
                url: "/doLogin",
                contentType: "application/x-www-form-urlencoded",
                data: _this.author,
                dataType: "JSON",
                xhrFields: {
                    withCredentials: true
                },
                error: function (err) {
                    if (err.responseText == "登录成功") {
                        location.reload();
                    } else {
                        alert(err.responseText)
                        _this.rImg()
                    }
                }
            });
        },
        rImg() {
            this.verifyUrl = "/verify?t=" + Date.parse(new Date())
        },
        sendVerify() {
            let _this = this
            _this.mailCount = 60
            $.ajax({
                type: "POST",
                url: "/verifyMail/" + _this.author.mail
            });
            setInterval(() => {
                setTimeout(function () {
                    _this.mailCount -= 1
                }, 0)
            }, 1000)
        },
        register() {
            let _this = this;
            if (this.author.password === this.author.confirmPassword) {
                $.ajax({
                    type: "POST",
                    url: "/author/register",
                    contentType: "application/json;charset=UTF-8",
                    data: JSON.stringify(_this.author),
                    dataType: "JSON",
                    success: function (result) {
                        alert(result)
                    },
                    error(e) {
                        alert(JSON.stringify(e.responseText))
                        _this.rImg()
                    }
                });
                return
            }
            alert("两次密码不一致")
        },
        password() {
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
    mounted() {
        this.rImg()
    }

})


Vue.component('search', {

})

Vue.component('tj', {

})

Vue.component('blog-load', {

})