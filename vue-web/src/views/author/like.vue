<template>
  <ul class="list-group article-list">
    <li class="list-group-item" v-for="(item,index) in articleList" :key="index">
      <router-link :to="{name: 'article_info', params: { id: item.articleId}}" class="article-title">
        <strong><p v-text="item.title"></p></strong>
      </router-link>
      <div class="article-synopsis">{{item.synopsis}}</div>
      <div>
        <span>{{item.createDate}}</span>
        <a class="float-end">
          {{item.nickname}}
        </a>
      </div>
    </li>   
    <li class="list-group-item">
      <a @click="nextPage()">获取</a>
    </li> 
  </ul>
</template>

<script>
import request from 'src/utils/request'
export default {
  name: "author_like",
  data() {
    return {
      articlePage:{
        nextPage:1
      },
      articleList:[]
      
    };
  },
  methods: {
    likeList(pageNum){
      request({
        url: '/api/article/like/list',
        method: 'GET',
        params:{page:pageNum}
      }).then((response) => {
        this.articlePage = response.data
        this.articleList = this.articleList.concat(response.data.list)
      })
    },
    nextPage(){
      if(!this.articlePage.isLastPage){
        this.likeList(this.articlePage.nextPage)
      }
    }
  },
  mounted(){
    this.likeList(this.articlePage.nextPage)
  }
};
</script>

<style lang="scss">
body{
    overflow-y: scroll;
}
</style>