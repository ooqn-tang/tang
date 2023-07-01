<template>
  <div class="m-3">
    <div class="row mb-3">
      <label class="col-sm-2 col-form-label">用户名</label>
      <div class="col-sm-10">
        <input class="form-control" disabled v-model="author.username" />
      </div>
    </div>
    <div class="row mb-3">
      <label class="col-sm-2 col-form-label" disabled>邮箱</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" disabled v-model="author.mail"/>
      </div>
    </div>
    <div class="row mb-3">
      <label class="col-sm-2 col-form-label">昵称</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" v-model="author.nickname" />
      </div>
    </div>
    <div class="row mb-3">
      <label class="col-sm-2 col-form-label">签名</label>
      <div class="col-sm-10">
        <input class="form-control" id="inputPassword3" v-model="author.signature"/>
      </div>
    </div>
    <div>
      <button class="btn btn-primary" @click="save">保存信息</button>
      <button class="btn btn-primary float-end" @click="logout">退出登录</button>
    </div>
  </div>
</template>

<script setup>
import request from "utils/request";
import { removeToken } from "utils/token";
import { onMounted, ref } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useStore } from "vuex";

let router = useRouter();
let route = useRoute();
let store = useStore();

let author = ref({
  username: "",
  nickname: "",
  mail: "",
  headUrl:'https://avatars.githubusercontent.com/u/15867678?v=4'
});

let username = store.state.username;

function loadAuthor(){
  request({
    url: `/api/author/${username}`,
    method: "get",
  }).then((response) => {
    author.value = response.data;
  });
};

function save(){
  request({
    url: `/api/author`,
    method: "put",
    data: author.value
  }).then((response) => {
    alert("保存成功")
  });
};

function logout(){
  removeToken(store)
  window.location.href='/'
}

onMounted(() => {
  loadAuthor();
});

</script>

<style scoped>
body {
  overflow-y: scroll;
}
</style>