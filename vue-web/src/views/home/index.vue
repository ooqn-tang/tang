<template>
  <nav class="navbar navbar-expand navbar navbar-expand-lg navbar-light bg-light t-b-b-1 mb-2" id="top">
    <div class="container-fluid">
      <a class="navbar-brand pc" href="/" style='margin-right: 0px;'>堂堂程序员</a>
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
            <a class="nav-link active" href="/video">📺视频</a>
          </li>
          <li class="nav-item">
            <router-link class="nav-link active" to="/essay">📝短文</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link active" to="/subject">📒专题</router-link>
          </li>
          <li class="nav-item" >
            <router-link class="nav-link active" to="/search">🔍搜索</router-link>
          </li>
          <li class="nav-item" v-if="isAdmin">
            <a class="nav-link active" href="/admin">🧙‍♂️管理</a>
          </li>
        </ul>
        <ul class="navbar-nav me-auto mb-lg-0 yd">
          <li class="nav-item dropdown float-start">
            <a class="nav-link active dropdown-toggle" href="#" data-bs-toggle="dropdown">{{title}}</a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="/article">📰文章</a></li>
              <li><a class="dropdown-item" href="/video">📺视频</a></li>
              <li><a class="dropdown-item" href="/essay">短文</a></li>
              <!-- <li><a class="dropdown-item" href="/authors">👨‍🎓作者</a></li> -->
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
            <li class="nav-item pc" v-if="isLogin">
              <router-link class="nav-link active" to="/message">消息</router-link>
            </li>
            <li class="nav-item dropdown" v-if="isLogin">
              <a class="nav-link active dropdown-toggle" href="#" data-bs-toggle="dropdown">投稿</a>
              <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="#" @click="createVideo()">📺视频</a></li>
                <li><a class="dropdown-item" href="#" @click="createArticle()">📰文章</a></li>
              </ul>
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

<script>
import request from 'utils/request'
export default {
  name: "home",
  data() {
    return {
      title:"菜单",
      isAdmin:this.$store.state.roles.indexOf("ROLE_ADMIN") > -1,
      isLogin:this.$store.state.username != null && this.$store.state.username != '' && this.$store.state.username != undefined
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
    createVideo(){
      request({
        url: '/api/video',
        method: 'POST'
      }).then((response) => {
        this.$router.push({name:'video_contribute',params: {id:response.data}})
      })
    },
    createArticle(){
      request({
        url: '/api/article',
        method: 'POST'
      }).then((response) => {
        let routeData = this.$router.resolve({name:"article-editor-md",params:{id:response.data}});
        window.open(routeData.href, '_blank');
        this.$refs.close.click()
      })
    }
  },
  onActivated(){
    alert()
    if(this.$route.name == 'article'){
      this.title = '文章'
    }else if(this.$route.name == 'subject_index'){
      this.title = '专辑'
    }else if(this.$route.name == 'author_list'){
      this.title = '作者'
    }else{
      this.title = '菜单'
    }
  }
};
</script>

<style lang="scss">
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