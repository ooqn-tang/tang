<template>
  <div style="margin:10px">
    <div class="row mb-3">
      <label class="col-sm-2 col-form-label">用户名</label>
      <div class="col-sm-10">
        <input class="form-control " disabled v-model="author.username"/>
      </div>
    </div>
    <div class="row mb-3">
      <label class="col-sm-2 col-form-label" disabled>邮箱</label
      >
      <div class="col-sm-10">
        <input type="text" class="form-control" disabled v-model="author.mail" />
      </div>
    </div>
    <div class="row mb-3">
      <label class="col-sm-2 col-form-label">昵称</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" v-model='author.nickname' />
      </div>
    </div>
    <div class="row mb-3">
      <label class="col-sm-2 col-form-label">签名</label>
      <div class="col-sm-10">
        <input class="form-control" id="inputPassword3" v-model="author.signature" />
      </div>
    </div>
    
    
    <div>
<button class="btn btn-primary" @click="save">保存信息</button>
<button class="btn btn-primary float-end" @click="logout">退出登录</button>
    </div>
    
  </div>
</template>

<script>
import request from 'src/utils/request'
export default {
  name: "author_setting",
  data() {
    return {
      author:{
        username:"",
        nickname:"",
        mail:"",
      }
    };
  },
  components: {},
  methods: {
    logout(){
      localStorage.removeItem("token")
      localStorage.removeItem("author")
      this.$store.state.username = ""
      window.location.href = "/"
    },
    save(){
      request({
        url: '/api/author',
        method: 'PUT',
        data:this.author
      }).then((response) => {
        this.selectAuthorLoad()
      })
    },
    selectAuthorLoad(){
      request({
        url: '/api/author/' + this.$route.params.username,
        method: 'GET'
      }).then((response) => {
        this.author = response.data
      })
    }
  },
  mounted() {
    this.selectAuthorLoad()
  },
};
</script>

<style lang="scss">
body {
  overflow-y: scroll;
}
</style>