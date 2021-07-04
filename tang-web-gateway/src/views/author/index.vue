<template>
  <div class="row clearfix">
    <div class="col-md-4 col-md-push-8 col-move">
      <div class="card mb-2">
        <div class="card-body ">
          <strong>{{author.nickname}}</strong>
          <button v-if="fans == 2" class="btn btn-outline-warning float-end" style="padding: 0px 5px 0px 3px;font-size: 13px;" @click="fansClick(author.username)">订阅</button>
          <button v-if="fans == 1" class="btn btn-outline-warning float-end" style="padding: 0px 5px 0px 3px;font-size: 13px;" @click="fansClick(author.username)">取消订阅</button>
          <hr />
          <div>简介：<span>{{author.signature}}</span></div>
        </div>
      </div>
      <div class="list-group mb-2  d-md-inline d-none">
        <a class="list-group-item active" >广播<span class="pull-right">🎇</span></a>
        <advertise></advertise>
      </div>
    </div>
    <div class="col-md-8 col-md-pull-4 mb-2 col-move">
      <div class="card">
        <div class="card-header">
          <ul class="nav justify-content-center">
            <li class="nav-item">
              <a class="nav-link" :class="routeName == 'author_blog'?'nav-link-active':''" @click="selectTypeClick('author_blog')">博客</a>
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
import {selectAuthor} from '/@/api/author'
import {insertFans,deleteFans,isFans} from "/@/api/fans"
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
        insertFans(username).then((response) => {
          this.fans = 1
        })
      }else{
        deleteFans(username).then((response) => {
          this.fans = 2
        })
      }
      
    },
    isFans(){
      isFans(this.thisUsername).then((response) => {
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
      selectAuthor(username).then((response) => {
        this.author = response.data
      })
    },
    
  },
  mounted(){
    this.selectAuthor(this.$route.params.username)
    this.thisUsername = this.$route.params.username
    this.isFans()
  }
};
</script>

<style lang="scss">
body{
    overflow-y: scroll;
}
</style>