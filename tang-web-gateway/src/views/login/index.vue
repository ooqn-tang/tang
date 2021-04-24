<template>
  <div id="loginModal" class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title text-center">登录</h4>
      </div>
      <div id="model-body" class="modal-body">
        <label>邮箱 / 用户名：</label>
        <div class="form-group">
          <input type="text" v-model="loginData.username" placeholder="用户名" autocomplete="off" class="form-control"/>
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
        <div class="btn-group W100">
          <router-link to="/" type="button" class="btn btn-default W100">返回首页</router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { login } from "/@/api/login"
export default {
  name: "login",
  data() {
    return {
      loginData:{
        username:"",
        password:""
      }
    };
  },
  components: {},
  methods: {
    login(){
      login(this.loginData).then((response) => {
        if(response.code === 200){
          this.$store.state.isLogin = true
          this.$router.go(-1)
        }
        
      })
    }
  },
  mounted(){
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