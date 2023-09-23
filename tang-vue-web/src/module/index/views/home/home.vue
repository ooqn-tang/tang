<template>
  <nav class="navbar navbar-expand navbar navbar-expand-lg navbar-light bg-light t-b-b-1 mb-2" id="top">
    <div class="container-fluid">
      <a class="navbar-brand pc" href="/" style='margin-right: 0px;'>ooqn.com</a>
      <a class="navbar-brand yd" href="/" style='margin-right: 0px;'>🙃</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
        <ul class="navbar-nav me-auto mb-lg-0 pc">
          <li class="nav-item">
            <a class="nav-link active" href="/article">📰文章</a>
          </li>
          <li class="nav-item">
            <router-link class="nav-link active" to="/essay">📝随笔</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link active" to="/author">👨‍🎓作者</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link active" to="/subject">📒专题</router-link>
          </li>
          <li class="nav-item" >
            <router-link class="nav-link active" to="/search">🔍搜索</router-link>
          </li>
          <li class="nav-item" v-if="isAdmin">
            <a class="nav-link active" href="/admin.html">🧙‍♂️管理</a>
          </li>
        </ul>
        <ul class="navbar-nav me-auto mb-lg-0 yd">
          <li class="nav-item dropdown float-start">
            <a class="nav-link active dropdown-toggle" href="#" data-bs-toggle="dropdown">{{title}}</a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="/article">📰文章</a></li>
              <li><a class="dropdown-item" href="/essay">📝随笔</a></li>
              <li><a class="dropdown-item" href="/author">👨‍🎓作者</a></li>
              <li><a class="dropdown-item" href="/subject">📒专题</a></li>
              <li><a class="dropdown-item" href="/dynamic" v-if="isLogin">📒动态</a></li>
            </ul>
          </li>
          <li class="nav-item float-start">
            <router-link class="nav-link active" to="/search">🔍搜索</router-link>
          </li>
        </ul>
        <form class="d-flex d-md-inline">
          <ul class="navbar-nav me-auto">
            <li class="nav-item" v-if="!isLogin">
              <router-link class="nav-link active" to="/login">登录</router-link>
            </li>
            <li class="nav-item" v-if="isLogin">
              <router-link class="nav-link active" to="/message">消息</router-link>
            </li>
            
            <li class="nav-item" v-if="isLogin">
              <span class="nav-link active" @click="createArticle()">投稿</span>
            </li>
            <li class="nav-item" v-if="isLogin">
              <a class="nav-link active" :href="'/author/' + $store.state.username">我的</a>
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

<script setup>
import { ref, computed, onActivated } from 'vue'
import request from 'utils/request'
import { useStore } from 'vuex'
import { useRouter,useRoute } from 'vue-router'

const store = useStore()
const router = useRouter()
const route = useRoute()

let title = ref("菜单")
let isAdmin = computed(() => {
  let admin = false
  if(store.state.author.roleList != null){
    store.state.author.roleList.forEach(role => {
      if(role.roleValue == "ROLE_ADMIN"){
        admin = true;
      }
    });
  }
  return admin
})

let isLogin = computed(() => {
  return store.state.username != null && store.state.username != '' && store.state.username != undefined
})

onActivated(() => {
  if(route.name == 'article'){
    title.value = '文章'
  }else if(route.name == 'subject_index'){
    title.value = '专辑'
  }else if(route.name == 'author_list'){
    title.value = '作者'
  }else{
    title.value = '菜单'
  }
})

function createArticle(){
  request({
    url: `/api/article`,
    method: 'POST'
  }).then((res) => {
    let routeData = router.resolve({name:"article-editor-md",params:{id:res.data}});
    let a = document.createElement("a");           
    a.setAttribute("href", routeData.href);      
    a.setAttribute("target", "_blank");      
    a.setAttribute("id", "article-editor");       
    // 防止反复添加      
    if(!document.getElementById("article-editor")) {                               
        document.body.appendChild(a);      
    }      
    a.click();   
  })
}

</script>

<style>
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
  overflow-y: scroll !important;
}

</style>