<template>
  <ul class="list-group article-list">
    <li class="list-group-item" v-for="(item,index) in articleList" :key="index">
      <router-link :to="{name: 'article_post', params: { id: item.dataId}}" class="article-title" v-if="item.type == 1">
        <strong><p>📰{{item.title}}</p></strong>
      </router-link>
      <router-link :to="{name: 'video_info', params: { id: item.dataId}}" class="article-title" v-if="item.type == 2">
        <strong><p>📺{{item.title}}</p></strong>
      </router-link>
      <div class="article-synopsis">{{item.synopsis}}</div>
      <div>
        <span>{{item.createDate}}</span>
        <a class="float-end">
          {{item.nickname}}
        </a>
      </div>
    </li>   
    <li class="list-group-item" v-if="!this.articlePage.isLastPage">
      <a @click="nextPage()">{{huoqu}}</a>
    </li> 
    <li class="list-group-item" v-if="articleList.length == 0">
      没有数据
    </li>
  </ul>
</template>

<script>
import request from 'utils/request'
export default {
  name: "author_collect",
  data() {
    return {
      articlePage:{
        nextPage:1
      },
      articleList:[],
      huoqu:"获取中..."
    };
  },
  methods: {
    collectList(pageNum){
      this.huoqu = '获取中...'
      request({
        url: '/api/collect/list',
        method: 'GET',
        params:{page:pageNum}
      }).then((response) => {
        this.articlePage = response.data
        this.articleList = this.articleList.concat(response.data.list)
        this.huoqu = '获取'
      })
    },
    nextPage(){
      if(!this.articlePage.isLastPage){
        this.collectList(this.articlePage.nextPage)
      }
    }
  },
  mounted(){
    this.collectList(this.articlePage.nextPage)
  }
};
</script>

<style scoped>
body{
    overflow-y: scroll;
}
</style>