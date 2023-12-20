<template>
  <div class="modal" style="display: inline;">
    <div class="modal-dialog">
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
            <input type="password" v-model="loginData.password" placeholder="密码" autocomplete="off"
              class="form-control" />
          </div>
          <label>确认密码：</label>
          <div class="form-group">
            <input type="password" v-model="loginData.password1" placeholder="确认密码" autocomplete="off"
              class="form-control" />
          </div>
        </div>
        <div class="modal-footer">
          <div class="btn-group w100">
            <button type="button" class="btn btn-primary" @click="register()">注册</button>

          </div>
          <div class="btn-group w100">
            <router-link to="/login" type="button" class="btn btn-outline-secondary">登录</router-link>
          </div>
          <div class="btn-group w100">
            <router-link to="/" type="button" class="btn btn-outline-secondary ">返回首页</router-link>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import request from '@common/request';
import { onMounted,ref } from "vue";

let loginData = ref({
  username: "",
  password: "",
  mail: "",
  password1: "",
  'rememberMe': true
})

function register(){
  if (loginData.value.password !== loginData.value.password1) {
    alert("两次密码不一致")
    return
  }
  request({
    url: `/api/register`,
    method: 'post',
    data: loginData.value
  }).then((res) => {
    alert(res.data)
  }).catch((error) => {
    alert(error.data)
  })
}

onMounted(() => {
  localStorage.removeItem("jwt")
  localStorage.removeItem("author")
})

</script>
<style scoped>
.body{
  background-image: url('https://img-s-msn-com.akamaized.net/tenant/amp/entityid/AAOElaZ.img') !important;
}
.w100{
  width: 100% !important;
}
</style>