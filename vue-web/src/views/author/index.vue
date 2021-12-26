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
      <div class="list-group mb-2  d-md-inline d-none">
        <notice></notice>
      </div>
    </div>
    <div class="col-md-8 col-md-pull-4 mb-2 move-p-lr-0">
      <div class="card move-b-lr-0">
        <div class="card-header">
          <ul class="nav justify-content-center">
            <li class="nav-item">
              <a class="nav-link" :class="routeName == 'author_article'?'nav-link-active':''" @click="selectTypeClick('author_article')">博客</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" :class="routeName == 'author_subject'?'nav-link-active':''" @click="selectTypeClick('author_subject')">专栏</a>
            </li>
            <li class="nav-item" v-if="thisUsername == loginUsername">
              <a class="nav-link"  :class="routeName == 'author_subscribe'?'nav-link-active':''" @click="selectTypeClick('author_subscribe')">订阅</a>
            </li>
            <li class="nav-item" v-if="thisUsername == loginUsername">
              <a class="nav-link"  :class="routeName == 'author_like'?'nav-link-active':''" @click="selectTypeClick('author_like')">喜欢</a>
            </li>
            <li class="nav-item" v-if="thisUsername == loginUsername">
              <a class="nav-link" :class="routeName == 'author_setting'?'nav-link-active':''" @click="selectTypeClick('author_setting')">设置</a>
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
import request from 'src/utils/request'
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
        })(username).then((response) => {
          this.fans = 2
        })
      }
      
    },
    isFans(){
      request({
        url: '/api/fans/is',
        method: 'get',
        params:{
            username:this.thisUsername
        }
      }).then((response) => {
        if(response.data == 1){
          this.fans = 1
        }else{
          this.fans = 2
        }
      })
    },
    selectTypeClick(routeName){
      this.routeName = routeName;
      this.$router.push({name:routeName})
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
</style>