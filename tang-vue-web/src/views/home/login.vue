<template>
  <div class="modal" style="display: inline;">
    <div id="loginModal" class="modal-dialog" >
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title text-center">登录</h4>
        </div>
        <div id="model-body" class="modal-body">
          {{ loginData.value }}
          <label>邮箱/用户名：</label>
          <div class="form-group">
            <input type="text" v-model="loginData.username" placeholder="邮箱/用户名" autocomplete="off" class="form-control" />
          </div>
          <label>密码：</label>
          <div class="form-group">
            <input type="password" v-model="loginData.password" placeholder="密码" autocomplete="off" class="form-control" />
          </div>
        </div>
        <div class="modal-footer">
          <div class="btn-group W100">
            <button type="button" class="btn btn-primary" @click="login()">登录</button>
          </div>
          <div class="btn-group W100">
            <router-link to="/register" type="button" class="btn btn-outline-secondary">注册</router-link>
          </div>
          <div class="btn-group W100">
            <router-link to="/" type="button" class="btn btn-outline-secondary">返回首页</router-link>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useStore } from 'vuex'
import { useRoute, useRouter } from "vue-router"
import { createStore } from 'vuex'

import jwt_decode from "jwt-decode"
import request from 'utils/request'

let loginData = ref({rememberMe:true})
let store = useStore()
let route = useRoute()
let router = useRouter()

function login() {
  request({
    url: `/api/authenticate`,
    method: 'post',
    data: loginData.value
  }).then((response) => {
    if (response.status === 200) {
      let authorData = jwt_decode(response.data)
      localStorage.setItem("jwt", response.data)
      localStorage.setItem("authorData", JSON.stringify(authorData))
      router.push({ path: "/author/" + authorData.sub })
    }
  }).catch(e => {
    alert(e.data)
  });
}

onMounted(() => {
 
})

</script>

<style scoped>
.body{
  background-image: url('https://img-s-msn-com.akamaized.net/tenant/amp/entityid/AAOElaZ.img') !important;
}
.W100{
  width: 100% !important;
}
</style>