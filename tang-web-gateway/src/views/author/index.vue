<template>
  <div class="row clearfix">
    <div class="col-md-4 col-md-push-8">
      <div class="card margin-bottom10">
        <div class="card-body ">
          <strong>{{author.nickname}}</strong>
          <button class="btn btn-outline-warning float-end" style="padding: 0px 5px 0px 3px;font-size: 13px;">订阅</button>
          <hr />
          <div>简介：<span>{{author.signature}}</span></div>
        </div>
      </div>
      <div class="list-group margin-bottom10">
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
    <div class="col-md-8 col-md-pull-4">
      <div class="card">
        <div class="card-header">
          <ul class="nav nav-tabs card-header-tabs">
            <li class="nav-item">
              <a class="nav-link" :class="selectType == 'author_blog'?'active':''" @click="selectTypeClick('author_blog')">博客</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" :class="selectType == 2?'active':''" @click="selectTypeClick(2)">专栏</a>
            </li>
            <li class="nav-item">
              <a class="nav-link"  :class="selectType == 3?'active':''" @click="selectTypeClick(3)">订阅</a>
            </li>
            <li class="nav-item">
              <a class="nav-link"  :class="selectType == 4?'active':''" @click="selectTypeClick(4)">收藏</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" :class="selectType == 'author_setting'?'active':''" @click="selectTypeClick('author_setting')">设置</a>
              
            </li>
            <li class="nav-item">
              <a class="nav-link"  :class="selectType == 6?'active':''" @click="selectType = 6">关于</a>
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
export default {
  name: "author_index",
  data() {
    return {
      selectType:'',
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
    selectTypeClick(name){
      this.selectType = name;
      this.$router.push({name:name})
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