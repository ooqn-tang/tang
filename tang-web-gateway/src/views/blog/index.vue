<template>
  <div class="row">
    <div class="col-md-9 margin-bottom10">
       <div class="card margin-bottom10"  >
         <div class="card-body " style="padding:0px;">
           <nav class="nav">
              <a class="nav-link" :class="selectTag == ''?'nav-link-active':''" @click="selectTagClick('')">全部</a>
              <a class="nav-link" :class="selectTag == 'Java'?'nav-link-active':''" @click="selectTagClick('Java')">Java</a>
              <a class="nav-link" :class="selectTag == 'Python'?'nav-link-active':''" @click="selectTagClick('Python')">Python</a>
              <a class="nav-link" :class="selectTag == 'Web前端'?'nav-link-active':''" @click="selectTagClick('Web前端')">Web前端</a>
              <a class="nav-link" :class="selectTag == 'Android'?'nav-link-active':''" @click="selectTagClick('Android')">Android</a>
              <a class="nav-link" :class="selectTag == '数据库'?'nav-link-active':''" @click="selectTagClick('数据库')">数据库</a>
              <a class="nav-link" :class="selectTag == '面试'?'nav-link-active':''" @click="selectTagClick('面试')">面试</a>
              <a class="nav-link" :class="selectTag == '算法'?'nav-link-active':''" @click="selectTagClick('算法')">算法</a>
              <a class="nav-link" :class="selectTag == '故事'?'nav-link-active':''" @click="selectTagClick('故事')">故事</a>
              <a class="nav-link" :class="selectTag == '开源项目'?'nav-link-active':''" @click="selectTagClick('开源项目')">开源项目</a>
            </nav>
         </div>
       </div>
      
      <div class="card">
        <div class="card-header">
          <ul class="nav nav-tabs card-header-tabs">
            <li class="nav-item">
              <a class="nav-link" :class="selectType == 1?'active':''" @click="selectType = 1">博客</a>
            </li>
            <li class="nav-item">
              <a class="nav-link disabled">精选</a>
            </li>
            <li class="nav-item">
              <a class="nav-link disabled">专栏</a>
            </li>
          </ul>
        </div>
        <div class="card-body blog-list">
          <ul class="list-group ">
            <li class="list-group-item " v-for="(item,index) in blogList" :key="index">
              <router-link :to="{name: 'blog_info', params: { id: item.blogId}}" class="blog-title">
                <strong><p v-text="item.title"></p></strong>
                </router-link>
              <div class="blog-synopsis" style="color: #5f5a5a;">{{item.synopsis}}</div>
              <div>
                <span class="date-color">{{item.createDate}}</span>
                <span v-for="(item,index) in item.tagList" :key="index" > . <span style="font-size: 10px;color: #a2a2a2;">{{item.tagName}}</span></span>
                <router-link :to="{name:'author_blog',params:{username:item.username}}" class="float-end">{{item.nickname}}</router-link>
              </div>
            </li>
            <li class="list-group-item">
              <a @click="nextPage()">获取</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <div class="col-md-3  margin-bottom10 ">
      <div class="list-group margin-bottom10">
        <a class="list-group-item active" >广播<span class="pull-right ">🎇</span></a>
        <advertise></advertise>
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
      selectTag:'',
      selectType:1,
      blogPage:{
        nextPage:1
      },
      blogList:[]
    }
  },
  methods: {
    selectTagClick(tagName){
      this.selectTag = tagName
      this.blogList = []
      this.loadBlog(this.blogPage.nextPage,this.selectTag)
    },
    loadBlog(nextPage,tagName){
      blogList({page:nextPage,tag:tagName}).then((response) => {
        console.log(response.data)
        this.blogPage = response.data
        this.blogList = this.blogList.concat(response.data.list)
      })
    },
    nextPage(){
      if(!this.blogPage.isLastPage){
        this.loadBlog(this.blogPage.nextPage,this.selectTag)
      }
    }
  },
  mounted(){
    this.loadBlog(this.blogPage.nextPage,this.selectTag)
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