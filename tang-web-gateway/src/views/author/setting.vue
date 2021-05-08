<template>
  <form style="margin:10px">
    <div class="row mb-3">
      <label for="inputEmail3" class="col-sm-2 col-form-label">用户名</label>
      <div class="col-sm-10">
        <input type="email" class="form-control " disabled id="inputEmail3" v-model="author.username"/>
      </div>
    </div>
    <div class="row mb-3">
      <label for="inputPassword3" class="col-sm-2 col-form-label"
        >昵称</label
      >
      <div class="col-sm-10">
        <input type="text" class="form-control" v-model='author.nickname' />
      </div>
    </div>
    <div class="row mb-3">
      <label for="inputPassword3" class="col-sm-2 col-form-label"
        >邮箱</label
      >
      <div class="col-sm-10">
        <input type="text" class="form-control" v-model="author.mail" />
      </div>
    </div>
    <div class="row mb-3">
      <label for="inputPassword3" class="col-sm-2 col-form-label"
        >签名</label
      >
      <div class="col-sm-10">
        <input class="form-control" id="inputPassword3" v-model="author.signature" />
      </div>
    </div>
    <button type="submit" class="btn btn-primary">保存</button>
  </form>
</template>

<script>
import {selectAuthor} from "/@/api/author"
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