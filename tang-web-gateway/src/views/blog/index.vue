<template>
  <div class="row">
    <div class="col-md-9 margin-bottom10 ">
       <div class="card margin-bottom10"  >
         <div class="card-body " style="padding:0px;">
           <nav class="nav">
             <a class="nav-link active" href="#">全部</a>
          <a class="nav-link" href="#">Java</a>
          <a class="nav-link" href="#">Python</a>
          <a class="nav-link" href="#">Web前端</a>
          <a class="nav-link" href="#">Android/IOS</a>
          <a class="nav-link" href="#">数据库</a>
          <a class="nav-link" href="#">面试</a>
          <a class="nav-link" href="#">算法</a>
          <a class="nav-link" href="#">故事</a>
          <a class="nav-link" href="#">开源项目</a>
           </nav>
         </div>
       </div>
      
      <div class="card">
        <div class="card-header">
          <ul class="nav nav-tabs card-header-tabs">
            <li class="nav-item">
              <a class="nav-link active" aria-current="true" href="#">博客</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">精选</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">专栏</a>
            </li>
          </ul>
        </div>
        <div class="card-body blog-list">
          <ul class="list-group ">
            <li class="list-group-item " v-for="(item,index) in blogData" :key="index">
              <router-link :to="{name: 'post', params: { id: item.blogId }}" class="blog-title">
                <strong><p v-text="item.title"></p></strong>
                </router-link>
              <div class="blog-synopsis">{{item.synopsis}}</div>
              <div>
                <span class="date-color">{{item.createDate}}</span>
                <span v-for="(item,index) in item.tagList" :key="index">{{item.tagName}}</span>
                <router-link :to="{name:'author',params:{username:item.username}}" class="float-end">{{item.nickname}}</router-link>
              </div>
            </li>
            <li class="list-group-item ">
              <a class="" @click="loadBlog()">获取</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <div class="col-md-3  margin-bottom10 ">
      <div class="list-group margin-bottom10">
        <a class="list-group-item active" >广播<span class="pull-right ">🎇</span></a>
        <a target="_blank" href="http://www.ttcxy.net/post/098384e9a34d438480289ad23c8625ba" class="list-group-item ">公众号推荐列表</a>
      </div>
      <div class="card margin-bottom10">
        <div class="card-body">
          <p>
            <a href="https://ttcxy.net/post/0b0d396713a54e2fbf714478d740e53e" target="_blank">关于</a>
          </p>
          <p>
            <a href="https://ttcxy.net/post/98b255d539f743e193e398bfa9b97cfd" target="_blank">友情链接</a>
          </p>
          <p>
            <a href="http://beian.miit.gov.cn" target="_blank">湘ICP备20009234号</a>
          </p>
          <a href="/map" class="hidden">地图</a>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { blogList } from "/@/api/blog"
export default {
  name: "blog",
  data() {
    return {
      param:{
        page:1
      },
      blogData:[],
      thisBlogPage:{},
      msg: 'Hello Vue 3.0 + Vite',
       messageList: [{},{}],
    }
  },
  components: {
    
  },
  methods: {
    loadBlog(){
      if(this.param.page > 0){
        blogList(this.param).then((response) => {
          this.thisBlogPage = response.data
          this.blogData = this.blogData.concat(response.data.list)
          this.param.page = response.data.nextPage
        })
      }
      
    }
  },
  mounted(){
    this.loadBlog()
  }
}
</script>

<style scoped lang="scss">
strong p,.card-body p{
  margin: 0px;
}
.red {
  color: red;
}


</style>