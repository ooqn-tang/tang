<template>
  <div v-if="type == 'dl'" id="loginModal" class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title text-center">登录</h4>
      </div>
      <div id="model-body" class="modal-body">
        <label>邮箱/用户名：</label>
        <div class="form-group">
          <input type="text" v-model="loginData.username" placeholder="邮箱/用户名" autocomplete="off" class="form-control"/>
        </div>
        <label>密码：</label>
        <div class="form-group">
          <input type="password" v-model="loginData.password" placeholder="密码" autocomplete="off" class="form-control"/>
        </div>
      </div>
      <div class="modal-footer">
        <div class="btn-group W100 mb10px">
          <button type="button" class="btn btn-primary W100" @click="login()">登录</button>
        </div>
        <div class="btn-group W100 mb10px">
          <button type="button" class="btn btn-primary W100" @click="type = 'zc'">注册</button>
        </div>
        <div class="btn-group W100">
          <router-link to="/" type="button" class="btn btn-default W100">返回首页</router-link>
        </div>
      </div>
    </div>
  </div>

  <div v-if="type == 'zc'" class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title text-center">注册</h4>
      </div>
      <div id="model-body" class="modal-body">
        <label>邮箱：</label>
        <div class="input-group">
          <input type="text" v-model="loginData.mail" placeholder="邮箱号" autocomplete="off" class="form-control">
        </div>
        <label>密码：</label>
        <div class="form-group">
          <input type="password" v-model="loginData.password" placeholder="密码" autocomplete="off" class="form-control"/>
        </div>
        <label>确认密码：</label>
        <div class="form-group">
          <input type="password" v-model="loginData.password1" placeholder="确认密码" autocomplete="off" class="form-control"/>
        </div>
      </div>
      <div class="modal-footer">
        <div class="btn-group W100 mb10px">
          <button type="button" class="btn btn-primary W100" @click="register()">注册</button>
        </div>
        <div class="btn-group W100 mb10px">
          <button type="button" class="btn btn-primary W100" @click="type = 'dl'">登录</button>
        </div>
        <div class="btn-group W100">
          <router-link to="/" type="button" class="btn btn-default W100">返回首页</router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import jwt_decode from "jwt-decode"
import request from 'src/utils/request'
export default {
  name: "login",
  data() {
    return {
      type:"dl",
      loginData:{
        username:"",
        password:"",
        mail:"",
        password1:"",
        'rememberMe':true
      }
    };
  },
  components: {},
  methods: {
    login(){
      request({
        url: '/api/authenticate',
        method: 'post',
        data:this.loginData
    }).then((response) => {
        if(response.code === 200){
          let tokenData = jwt_decode(response.jwt_token)
          localStorage.setItem("token",response.jwt_token)
          localStorage.setItem("author",JSON.stringify(tokenData.author))
          this.$router.push({path:"/author/"+tokenData.sub})
        }
      })
    },
    sendMail(){
      request({
        url: '/api/mail-verify',
        method: 'post',
        params:{mail:this.loginData.username}
    }).then((response) => {
        alert(response.message)
      })
    },
    register(){
      if(this.loginData.password !== this.loginData.password1){
        alert("两次密码不一致")
        return
      }
      request({
        url: '/api/register',
        method: 'post',
        data:this.loginData
    }).then((response) => {
        alert(response.data)
      })
    }
  },
  mounted(){
    localStorage.removeItem("token")
    localStorage.removeItem("author")
  }
};
</script>

<style scope lang="scss">
.W33{
  width: 33%;
}
.W34{
  width: 34%
}
.W100{
  width: 100%;
}
.mb10px{
  margin-bottom: 10px;
}
html,body{
  overflow:hidden;
}

</style>