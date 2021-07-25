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
import {selectAuthor,updateAuthor} from "/@/api/author"
import {logout} from "/@/api/login"
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
      localStorage.setItem("token","")
      localStorage.setItem("user",{})
      this.$store.state.user = {}
      window.location.href = "/"
    },
    save(){
      updateAuthor(this.author).then((response) => {
        this.selectAuthorLoad()
      })
    },
    selectAuthorLoad(){
      selectAuthor(this.$route.params.username).then((response) => {
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