<template>
  <div class="row clearfix">
    <div class="col-md-4 col-md-push-8 move-p-lr-0">
      <div class="card mb-2 move-b-lr-0">
        <div class="card-body ">
          <strong>{{author.nickname}}</strong>
          <button v-if="fans == 2" class="btn btn-outline-warning float-end" style="padding: 0px 5px 0px 3px;font-size: 13px;" @click="fansClick(author.username)">订阅</button>
          <button v-if="fans == 1" class="btn btn-outline-warning float-end" style="padding: 0px 5px 0px 3px;font-size: 13px;" @click="fansClick(author.username)">取消订阅</button>
          <hr />
          <div>简介：<span>{{author.signature}}</span></div>
        </div>
      </div>
      <div class="list-group mb-2 d-md-inline d-none">
        <notice></notice>
      </div>
      
    </div>
    <div class="col-md-8 col-md-pull-4 mb-2 move-p-lr-0">
      <div class="card move-b-lr-0">
        <div class="card-header" v-if="thisUsername == loginUsername">
          <ul class="nav justify-content-center">
            <li class="nav-item">
              <router-link class="nav-link" :class="routeName == 'author_article'?'nav-link-active':''" :to="{name:'author_article'}">文章</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" :class="routeName == 'author_subject'?'nav-link-active':''" :to="{name:'author_subject'}">专栏</router-link>
            </li>
            <li class="nav-item" v-if="thisUsername == loginUsername">
              <router-link class="nav-link"  :class="routeName == 'author_subscribe'?'nav-link-active':''" :to="{name:'author_subscribe'}">订阅</router-link>
            </li>
            <li class="nav-item" v-if="thisUsername == loginUsername">
              <router-link class="nav-link"  :class="routeName == 'author_collect'?'nav-link-active':''" :to="{name:'author_collect'}">收藏</router-link>
            </li>
            <li class="nav-item" v-if="thisUsername == loginUsername">
              <router-link class="nav-link" :class="routeName == 'author_setting'?'nav-link-active':''" :to="{name:'author_setting'}">设置</router-link>
            </li>
          </ul>
        </div>
        <div class="card-header" v-if="thisUsername != loginUsername">
          <ul class="nav justify-content-center">
            <li class="nav-item">
              <router-link class="nav-link" :class="routeName == 'author_article'?'nav-link-active':''" :to="{name:'author_article'}">文章</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" :class="routeName == 'author_subject'?'nav-link-active':''" :to="{name:'author_subject'}">专栏</router-link>
            </li>
          </ul>
        </div>
        <div class="card-body p-0">
          <router-view/>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import request from 'utils/request'
export default {
  name: "author_index",
  data() {
    return {
      routeName:this.$route.name,
      author:{
        
      },
      thisUsername:"",
      loginUsername:this.$store.state.username,
      from:{
        page:1
      },
      fans:1
    };
  },
  components: {},
  watch:{
    $route(to,from){
      this.routeName = this.$route.name
    }
  },
  methods: {
    fansClick(username){
      if(this.fans == 2){
        request({
          url: '/api/fans/' + username,
          method: 'POST'
        }).then((response) => {
          this.fans = 1
        })
      }else{
        request({
          url: '/api/fans/' + username,
          method: 'DELETE'
        }).then((response) => {
          this.fans = 2
        })
      }
      
    },
    isFans(){
      request({
        url: '/api/fans/username/'+this.thisUsername,
        method: 'get',
      }).then((response) => {
        if(response.data == 1){
          this.fans = 1
        }else{
          this.fans = 2
        }
      })
    },
    selectAuthor(username){
      request({
        url: '/api/author/' + username,
        method: 'GET'
      }).then((response) => {
        this.author = response.data
      })
    },
    
  },
  created(){
    this.selectAuthor(this.$route.params.username)
  },
  mounted(){
    this.thisUsername = this.$route.params.username
    if(this.$store.state.username != ""){
      this.isFans()
    }
  }
};
</script>

<style lang="scss">
body{
    overflow-y: scroll;
}
.nav-link{
  padding-left: 6px;
  padding-right: 6px;
}
</style>