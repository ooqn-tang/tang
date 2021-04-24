<template>
  <nav role="navigation" class="navbar navbar-default navbar-static-top" style="margin-bottom: 10px;">
        <div class="container">
            <div class="navbar-header">
                <button type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" class="navbar-toggle">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="/" class="navbar-brand">堂堂程序员</a>
            </div>
            <div id="bs-example-navbar-collapse-1" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li><router-link to="/">博客</router-link></li>
                </ul>
                <form class="navbar-form navbar-left">
                    <div id="search" class="input-group"><input autocapitalize="none" autocomplete="off" autocorrect="off" type="text" value="" placeholder="输入关键字" name="s" class="form-control"> <span class="input-group-btn"><button type="button" class="btn btn-default">搜索</button></span></div>
                </form>
                <ul class="nav navbar-nav navbar-right">
                    <li v-if="username == ''"><router-link to="/login">登录</router-link></li>
                    <li v-if="username != ''"><router-link :to="{name:'editor'}">投稿</router-link></li>
                    <li v-if="username != ''"><router-link :to="{name:'author',params:{'username':username}}">我的</router-link></li>
                </ul>
            </div>
        </div>
  </nav>
  <div class="container">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: "home",
  data() {
    return {
      username: this.$store.getters.username
    };
  },
  computed: {
    name() {
      return 
    },
  },
  created() {
  },
  methods: {
  },
  mounted(){
  }
};
</script>

<style scoped lang="scss">
.m-r-5-px{
  margin-right: 5px 
}
.date-color{
  color: rgb(0, 40, 90)
}
p{
  margin: 0px;
}

body{
    overflow-y: scroll;
}

</style>