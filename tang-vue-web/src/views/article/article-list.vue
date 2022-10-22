<template>
  <div class="row">
    <div class="col-md-9 mb-2 move-p-lr-0">
       <div class="card mb-2 move-b-lr-0">
         <div class="card-body p-0">
           <nav class="nav">
              <a class="nav-link" :class="selectTag == ''?'nav-link-active':''" @click="selectTagClick('')">最新</a>
              <a class="nav-link" :class="selectTag == 'gz' ? 'nav-link-active' : ''" @click="selectTagClick('gz')">关注</a>
            </nav>
         </div>
       </div>
      <div class="card move-b-lr-0">
        <div class="card-body article-list p-0">
          <ul class="list-group ">
            <li class="list-group-item " v-for="(item,index) in articleList" :key="index">
              <router-link :to="{name: 'article_post', params: { id: item.articleId}}" class="article-title">
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
      page:{
        number:0
      },
      articleList:[],
      isLoding:true
    }
  },
  created(){
   
  },
  methods: {
    selectTagClick(selectTag){
      this.page = {
        number:0
      }
      this.selectTag = selectTag;
      this.articleList=[]
      this.loadArticle()
    },
    loadArticle(){
      let url = ''
      if(this.selectTag == 'gz'){
        url = '/api/article/list/gz'
      }else{
        url = '/api/article/list'
      }
      this.isLoding = true
      request({
        url: url,
        method: 'get',
        params:{page: this.page.number}
      }).then((response) => {
        this.isLoding = false
        this.page = response.data
        this.articleList = this.articleList.concat(response.data.content)
      })
    },
    next(){
      if(!this.page.last){
        this.page.number += 1
        this.loadArticle()
      }
    }
  },
  mounted(){
    this.loadArticle(this.page.number)
  }
}
</script>

<style scoped>
strong p,.card-body p{
  margin: 0px;
}
.red {
  color: red;
}
</style>