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
              <a class="nav-link active" aria-current="true" href="#">博客</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">专栏</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">收藏</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">设置</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">关于</a>
            </li>
          </ul>
        </div>
        <div class="card-body blog-list">
          <ul class="list-group">
            <li class="list-group-item" v-for="(item,index) in blogList" :key="index">
              <router-link :to="{name: 'post', params: { id: item.blogId }}" class="blog-title">
                <strong><p v-text="item.title"></p></strong>
              </router-link>
              <div class="blog-synopsis">{{item.synopsis}}</div>
              <div>
                <span>{{item.createDate}}</span>
                <div class="btn-group pull-right">
                </div>
              </div>
            </li>
            <li class="list-group-item">
              <a>获取</a>
            </li>
          </ul>
        </div>
      </div>

      
    </div>
  </div>
</template>

<script>
import {selectAuthor} from '/@/api/author'
import {loadBlogByUsername} from '/@/api/blog'
export default {
  name: "author",
  data() {
    return {
      author:{
        
      },
      blogList:[
        
      ],
      thisUsername:"",
      from:{
        page:1
      }
    };
  },
  components: {},
  methods: {
    selectAuthor(username){
      selectAuthor(username).then((response) => {
        this.author = response.data
      })
    },
    loadBlogByUsername(){
      loadBlogByUsername(this.thisUsername,this.from).then((response) => {
        this.blogList = response.data.list
      })
    }
  },
  mounted(){
    this.selectAuthor(this.$route.params.username)
    this.thisUsername = this.$route.params.username
    this.loadBlogByUsername()
  }
};
</script>

<style lang="scss">
body{
    overflow-y: scroll;
}
</style>