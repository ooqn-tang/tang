<template>
  <div style="margin: 10px">
    <div class="row mb-3">
      <label class="col-sm-2 col-form-label">头像</label>
      <div class="col-sm-10">
        <div class="form-control">
          <img :src="author.headUrl" onerror='this.src="https://avatars.githubusercontent.com/u/15867678?v=4"' class=" img-thumbnail" style="height: 150px;width:150px" onclick="document.getElementById('imageInput').click()">
          <input type="file" style="display: none;" id="imageInput" @change="uploadImage">
        </div>
      </div>
    </div>
    <div class="row mb-3">
      <label class="col-sm-2 col-form-label">用户名</label>
      <div class="col-sm-10">
        <input class="form-control" disabled v-model="author.username" />
      </div>
    </div>
    <div class="row mb-3">
      <label class="col-sm-2 col-form-label" disabled>邮箱</label>
      <div class="col-sm-10">
        <input
          type="text"
          class="form-control"
          disabled
          v-model="author.mail"
        />
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
        <input
          class="form-control"
          id="inputPassword3"
          v-model="author.signature"
        />
      </div>
    </div>

    <div>
      <button class="btn btn-primary" @click="save">保存信息</button>
      <button class="btn btn-primary float-end" @click="logout">
        退出登录
      </button>
    </div>
  </div>
</template>

<script>
import request from "src/utils/request";
import {removeToken} from "src/utils/token";
export default {
  name: "author_setting",
  data() {
    return {
      author: {
        username: "",
        nickname: "",
        mail: "",
      }
    };
  },
  components: {},
  methods: {
    uploadImage(e){
      let file = e.target.files[0];
      let param = new FormData(); //创建form对象
      param.append("file", file); //通过append向form对象添加数据
      param.append("type", "2"); //通过append向form对象添加数据
      console.log(param.get("file")); //FormData私有类对象，访问不到，可以通过get判断值是否传进去
      request({
        url: "/api/file/upload",
        method: "post",
        data:param,
        headers: { "Content-Type": "multipart/form-data" }
      }).then((response) => {
        this.author.headUrl = import.meta.env.VITE_BASE_API + "api/file/" + response.data
        alert(this.author.headUrl)
      });
    },
    logout() {
      removeToken()
    },
    save() {
      request({
        url: "/api/author",
        method: "PUT",
        data: this.author,
      }).then((response) => {
        alert("保存成功")
        this.selectAuthorLoad();
      });
    },
    selectAuthorLoad() {
      request({
        url: "/api/author/" + this.$route.params.username,
        method: "GET",
      }).then((response) => {
        this.author = response.data;
      });
    },
  },
  mounted() {
    this.selectAuthorLoad();
  },
};
</script>

<style lang="scss">
body {
  overflow-y: scroll;
}
</style>