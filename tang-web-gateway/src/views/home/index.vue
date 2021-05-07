<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light margin-bottom10" style="border-bottom: 1px solid #cecece;">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">🧩堂堂程序员</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <router-link class="nav-link" to="/">😶博客</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/">👨‍🎓作者</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/">🏷标签</router-link>
        </li>
                <li class="nav-item">
          <router-link class="nav-link" to="/">📒专题</router-link>
        </li>
        <li class="nav-item" v-if="username == ''">
          <router-link class="nav-link"  to="/login">🧐登录</router-link>
        </li>
        <li class="nav-item" v-if="username != ''">
          <a class="nav-link"  href="/editor">✒投稿</a>
        </li>
        <li class="nav-item" v-if="username != ''">
          <router-link class="nav-link"  :to="{name:'author_blog',params:{'username':username}}">😀我的</router-link>
        </li>
      </ul>
      <form class="d-flex">
        <input class="form-control me-2">
        <button class="btn btn-outline-success">🔍</button>
      </form>
    </div>
  </div>
</nav>
  <div class="container-fluid">
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