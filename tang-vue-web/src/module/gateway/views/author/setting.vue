<template>

<ul class="list-group article-list">
  <li class="list-group-item">
    <div class="row mb-3">
      <label class="col-2 col-form-label">用户名</label>
      <div class="col-10">
        <input class="form-control" disabled v-model="author.username" />
      </div>
    </div>
    <div class="row mb-3">
      <label class="col-2 col-form-label" disabled>邮箱</label>
      <div class="col-10">
        <input type="text" class="form-control" disabled v-model="author.mail" />
      </div>
    </div>
    <div class="row mb-3">
      <label class="col-2 col-form-label">昵称</label>
      <div class="col-10">
        <input type="text" class="form-control" v-model="author.nickname" />
      </div>
    </div>
    <div class="row mb-3">
      <label class="col-2 col-form-label">签名</label>
      <div class="col-10">
        <input class="form-control" id="inputPassword3" v-model="author.signature" />
      </div>
    </div>
    <div>
      <button class="btn btn-primary" @click="save">保存信息</button>
      <button class="btn btn-primary float-end" @click="logout">退出登录</button>
    </div>
  </li>
</ul>
 
</template>

<script setup>
import request from "@common/request";
import { onMounted, ref } from "vue";
import { useAuthorStore } from "@common/user";

let authorStore = useAuthorStore();

let author = ref({
  username: "************",
  nickname: "********",
  mail: "****************"
});

let username = authorStore.author.username;

function loadAuthor() {
  request({
    url: `/api/author/username/${username}`,
    method: "get",
  }).then((res) => {
    author.value = res.data;
  });
};

function save() {
  request({
    url: `/api/author`,
    method: "put",
    data: author.value
  }).then((res) => {
    alert("保存成功")
  });
};

function logout() {
  authorStore.logout();
  window.location.href = '/'
}

onMounted(() => {
  loadAuthor();
});

</script>

<style scoped></style>