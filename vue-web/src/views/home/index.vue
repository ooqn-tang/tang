<template>
  <nav class="navbar navbar-expand navbar navbar-expand-lg navbar-light bg-light t-b-b-1 mb-2" id="top">
    <div class="container-fluid">
      <a class="navbar-brand pc" href="/" style='margin-right: 0px;'>🙃堂堂程序员</a>
      <a class="navbar-brand yd" href="/" style='margin-right: 0px;'>🙃</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
        <ul class="navbar-nav me-auto mb-lg-0 pc">
          <li class="nav-item">
            <a class="nav-link" href="/">🏠主页</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/blog">📰文章</a>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/authors">👨‍🎓作者</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/subject">📒专题</router-link>
          </li>
          <li class="nav-item" >
            <router-link class="nav-link" to="/search">🔍搜索</router-link>
          </li>
        </ul>


        <ul class="navbar-nav me-auto mb-lg-0 yd">
          <li class="nav-item dropdown float-start">
            <a class="nav-link dropdown-toggle" href="#" id="dropdown03" data-bs-toggle="dropdown" aria-expanded="false">{{title}}</a>
            <ul class="dropdown-menu" aria-labelledby="dropdown03">
              <li><a class="dropdown-item" href="/">🏠主页</a></li>
              <li><a class="dropdown-item" href="/blog">📰文章</a></li>
              <li><a class="dropdown-item" href="/authors">👨‍🎓作者</a></li>
              <li><a class="dropdown-item" href="/subject">📒专题</a></li>
            </ul>
          </li>
          <li class="nav-item float-start">
            <router-link class="nav-link" to="/search">🔍搜索</router-link>
          </li>
        </ul>


        <form class="d-flex d-md-inline">
          <ul class="navbar-nav me-auto">
            <li class="nav-item" v-if="$store.state.username == ''">
              <router-link class="nav-link" to="/login">登录</router-link>
            </li>
            <li class="nav-item dropdown" v-if="$store.state.username != ''">
              <a class="nav-link" @click="createBlog()">投稿</a>
            </li>
            <li class="nav-item" v-if="$store.state.username != ''">
              <a class="nav-link" :href="'/author/' + $store.state.username">我的</a>
            </li>
          </ul>
        </form>
      </div>
    </div>
  </nav>
  <div class="container-fluid">
    <router-view/>
  </div>
</template>

<script>
import { createBlog } from "/@/api/blog"
export default {
  name: "home",
  data() {
    return {
      title:"菜单"
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
    createBlog(){
      createBlog().then((response) => {
        let routeData = this.$router.resolve({name:"blog-editor",params:{id:response.data}});
        window.open(routeData.href, '_blank');
        this.$refs.close.click()
      })
    }
  },
  mounted(){
    if(this.$route.name == 'home_index'){
      this.title = '首页'
    }else if(this.$route.name == 'blog'){
      this.title = '文章'
    }else if(this.$route.name == 'subject_index'){
      this.title = '专辑'
    }else{
      this.title = '菜单'
    }
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