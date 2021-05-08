<template>
  <div class="row clearfix">
    <div class="col-md-4 col-md-push-8">
      <div class="card margin-bottom10">
        <div class="card-body ">
          <strong>{{author.nickname}}</strong>
          <button class="btn btn-outline-warning float-end" style="padding: 0px 5px 0px 3px;font-size: 13px;" @click="insertFansClick(author.username)">订阅</button>
          <hr />
          <div>简介：<span>{{author.signature}}</span></div>
        </div>
      </div>
      <div class="list-group margin-bottom10 hdl">
        <a class="list-group-item active" >广播<span class="pull-right">🎇</span></a>
        <a target="_blank" href="http://www.ttcxy.net/post/098384e9a34d438480289ad23c8625ba" class="list-group-item">公众号推荐列表</a>
        <a target="_blank" href="http://www.ttcxy.net/post/098384e9a34d438480289ad23c8625ba" class="list-group-item">公众号推荐列表</a>
        <a target="_blank" href="http://www.ttcxy.net/post/098384e9a34d438480289ad23c8625ba" class="list-group-item">公众号推荐列表</a>
        <a target="_blank" href="http://www.ttcxy.net/post/098384e9a34d438480289ad23c8625ba" class="list-group-item">公众号推荐列表</a>
        <a target="_blank" href="http://www.ttcxy.net/post/098384e9a34d438480289ad23c8625ba" class="list-group-item">公众号推荐列表</a>
        <a target="_blank" href="http://www.ttcxy.net/post/098384e9a34d438480289ad23c8625ba" class="list-group-item">公众号推荐列表</a>
        <a target="_blank" href="http://www.ttcxy.net/post/098384e9a34d438480289ad23c8625ba" class="list-group-item">公众号推荐列表</a>
        <a target="_blank" href="http://www.ttcxy.net/post/098384e9a34d438480289ad23c8625ba" class="list-group-item">公众号推荐列表</a>
        <a target="_blank" href="http://www.ttcxy.net/post/098384e9a34d438480289ad23c8625ba" class="list-group-item">公众号推荐列表</a>
        <a target="_blank" href="http://www.ttcxy.net/post/098384e9a34d438480289ad23c8625ba" class="list-group-item">公众号推荐列表</a>
        <a target="_blank" href="http://www.ttcxy.net/post/098384e9a34d438480289ad23c8625ba" class="list-group-item">公众号推荐列表</a>
        <a target="_blank" href="http://www.ttcxy.net/post/098384e9a34d438480289ad23c8625ba" class="list-group-item">公众号推荐列表</a>
        <a target="_blank" href="http://www.ttcxy.net/post/098384e9a34d438480289ad23c8625ba" class="list-group-item">公众号推荐列表</a>
        <a target="_blank" href="http://www.ttcxy.net/post/098384e9a34d438480289ad23c8625ba" class="list-group-item">公众号推荐列表</a>
        <a target="_blank" href="http://www.ttcxy.net/post/098384e9a34d438480289ad23c8625ba" class="list-group-item">公众号推荐列表</a>
      </div>
    </div>
    <div class="col-md-8 col-md-pull-4 margin-bottom10">
      <div class="card">
        <div class="card-header">
          <ul class="nav nav-tabs card-header-tabs">
            <li class="nav-item">
              <a class="nav-link" :class="routeName == 'author_blog'?'active':''" @click="selectTypeClick('author_blog')">博客</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" :class="routeName == 'author_subject'?'active':''" @click="selectTypeClick('author_subject')">专栏</a>
            </li>
            <li class="nav-item">
              <a class="nav-link"  :class="routeName == 'author_subscribe'?'active':''" @click="selectTypeClick('author_subscribe')">订阅</a>
            </li>
            <li class="nav-item">
              <a class="nav-link"  :class="routeName == 'author_like'?'active':''" @click="selectTypeClick('author_like')">喜欢</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" :class="routeName == 'author_setting'?'active':''" @click="selectTypeClick('author_setting')">设置</a>
            </li>
          </ul>
        </div>
        <div class="card-body blog-list">
          <router-view/>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import {selectAuthor} from '/@/api/author'
import {insertFans} from "/@/api/fans"
export default {
  name: "author_index",
  data() {
    return {
      routeName:this.$route.name,
      author:{
        
      },
      thisUsername:"",
      from:{
        page:1
      }
    };
  },
  components: {},
  methods: {
    insertFansClick(username){
      insertFans(username).then((response) => {
        alert(JSON.stringify(response))
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
  }
};
</script>

<style lang="scss">
body{
    overflow-y: scroll;
}
</style>