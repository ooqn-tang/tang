<template>
  <div class="row">
    <div class="col-md-9 mb-2 move-p-lr-0">
       <div class="card mb-2 move-b-lr-0">
         <div class="card-body p-0">
           <nav class="nav">
              <a class="nav-link" :class="selectTag == ''?'nav-link-active':''" @click="selectTagClick('')">全部</a>
              <a class="nav-link" v-for="(item,index) in allTag" @click="selectTagClick(item.tagName)" :key="index" :class="selectTag == item.tagName?'nav-link-active':''">{{item.tagName}}</a>
            </nav>
         </div>
       </div>
      <div class="card move-b-lr-0">
        <div class="card-header">
          <ul class="nav nav-tabs card-header-tabs">
            <li class="nav-item">
              <a class="nav-link" :class="selectType == 1?'active':''" @click="selectType = 1">文章</a>
            </li>
            <li class="nav-item">
              <a class="nav-link disabled">精选</a>
            </li>
            <li class="nav-item">
              <a class="nav-link disabled">专栏</a>
            </li>
          </ul>
        </div>
        <div class="card-body article-list p-0">
          <ul class="list-group ">
            <li class="list-group-item " v-for="(item,index) in articleList" :key="index">
              <router-link :to="{name: 'article_info', params: { id: item.articleId}}" class="article-title">
                <strong><p v-text="item.title"></p></strong>
              </router-link>
              <div class="article-synopsis" style="color: #5f5a5a;">{{item.synopsis}}</div>
              <div>
                <span class="date-color" style="font-size: 16px;">{{item.createDate}}</span>
                <span v-for="(item,index) in item.tagList" :key="index" > . <span style="font-size: 16px;color: #dc3545;">{{item.tagName}}</span></span>
                <router-link :to="{name:'author_article',params:{username:item.username}}" class="float-end">{{item.nickname}}</router-link>
              </div>
            </li>
            <li class="list-group-item">
              <a @click="next()" v-if="!isLoding">获取</a><a v-if="isLoding">加载中...</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <div class="col-md-3 mb-2 move-p-lr-0">
      <div class="list-group mb-2  move-b-lr-0">
        <notice></notice>
      </div>
      <div class="card mb-2  move-b-lr-0">
        <info></info>
      </div>
    </div>
  </div>
</template>

<script>
import request from 'utils/request'
export default {
  name: "article",
  data() {
    return {
      selectTag:'',
      selectType:1,
      allTag:[],
      articlePage:{
        nextPage:1
      },
      articleList:[],
      isLoding:true
    }
  },
  created(){
    request({
          url: '/api/tag/all',
          method: 'GET'
        }).then((response) => {
          this.allTag = response.data;
        })
  },
  methods: {
    selectTagClick(tagName){
      this.selectTag = tagName
      this.articleList = []
      this.articlePage.nextPage = 1
      this.loadArticle(this.articlePage.nextPage,this.selectTag)
    },
    loadArticle(nextPage,tagName){
      this.isLoding = true
      request({
        url: '/api/article/list',
        method: 'get',
        params:{page:nextPage,tag:tagName}
      }).then((response) => {
        this.articlePage = response.data
        this.articleList = this.articleList.concat(response.data.list)
        this.isLoding = false
      })
    },
    next(){
      if(!this.articlePage.isLastPage){
        this.loadArticle(this.articlePage.nextPage,this.selectTag)
      }
    }
  },
  mounted(){
    this.loadArticle(this.articlePage.nextPage,this.selectTag)
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