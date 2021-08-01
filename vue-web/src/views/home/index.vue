<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light t-b-b-1 mb-2">
    <div class="container-fluid">
      <a class="navbar-brand" href="/">🧩堂堂程序员</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
        <ul class="navbar-nav me-auto mb-lg-0">
          <li class="nav-item">
            <a class="nav-link" href="/blog">😶博客</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/video">📺视频</a>
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
          <li class="nav-item" >
            <router-link class="nav-link" to="/search">🔍搜索</router-link>
          </li>
          
        </ul>
        <form class="d-flex d-md-inline">
          <ul class="navbar-nav me-auto">
            <li class="nav-item" v-if="$store.state.username == ''">
              <router-link class="nav-link" to="/login">🧐登录</router-link>
            </li>
            <li class="nav-item dropdown" v-if="$store.state.username != ''">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                发布
              </a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" @click="createBlog()">文章</a></li>
                <li><a class="dropdown-item" @click="createVideo()">视频</a></li>
              </ul>
            </li>
            <li class="nav-item" v-if="$store.state.username != ''">
              <keep-alive exclude="a">
                <a class="nav-link" :href="'/author/' + $store.state.username">😀我的</a>
              </keep-alive>
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
        this.$router.push({name:"blog-editor",params:{id:response.data}})
      })
    },
    createVideo(){
      this.$router.push({name:"video-editor",params:{id:"kasdjfkasjdfkajsdfk"}})
    }
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