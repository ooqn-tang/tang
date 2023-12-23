<template>
  <div class="modal" style="display: inline;">
    <div id="loginModal" class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title text-center">登录</h4>
        </div>
        <div id="model-body" class="modal-body">
          {{ loginData.value }}
          <label>邮箱/用户名：</label>
          <div class="form-group">
            <input type="text" v-model="loginData.username" placeholder="邮箱/用户名" autocomplete="off"
              class="form-control" />
          </div>
          <label>密码：</label>
          <div class="form-group">
            <input type="password" v-model="loginData.password" placeholder="密码" autocomplete="off"
              class="form-control" />
          </div>
        </div>
        <div class="modal-footer">
          <div class="btn-group w100">
            <button type="button" class="btn btn-primary" @click="login()">登录</button>
          </div>
          <div class="btn-group w100">
            <router-link to="/register" type="button" class="btn btn-outline-secondary">注册</router-link>
          </div>
          <div class="btn-group w100">
            <router-link to="/" type="button" class="btn btn-outline-secondary">返回首页</router-link>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from "vue-router"

import { authenticateApi, rolesApi, authorApi } from '@gateway/apis/login'

let loginData = ref({ rememberMe: true })
let router = useRouter()

async function login() {
  let loginRes = await authenticateApi(loginData.value);
  if (loginRes.status === 200) {
    localStorage.setItem("jwt", loginRes.data)
    let authorRes = await authorApi();
    let rolesRes = await rolesApi();
    localStorage.setItem("author", JSON.stringify(authorRes.data))
    localStorage.setItem("roles", JSON.stringify(rolesRes.data))
    router.push({ path: "/author/" + authorRes.data.username })
  }
}
</script>

<style scoped>
.body {
  background-image: url('https://img-s-msn-com.akamaized.net/tenant/amp/entityid/AAOElaZ.img') !important;
}
</style>