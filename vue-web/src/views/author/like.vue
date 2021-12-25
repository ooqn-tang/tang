<template>
  <ul class="list-group blog-list">
    <li class="list-group-item" v-for="(item,index) in blogList" :key="index">
      <router-link :to="{name: 'blog_info', params: { id: item.blogId}}" class="blog-title">
        <strong><p v-text="item.title"></p></strong>
      </router-link>
      <div class="blog-synopsis">{{item.synopsis}}</div>
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
      blogPage:{
        nextPage:1
      },
      blogList:[]
      
    };
  },
  methods: {
    likeList(pageNum){
      request({
        url: '/api/blog/like/list',
        method: 'GET',
        params:{page:pageNum}
      }).then((response) => {
        this.blogPage = response.data
        this.blogList = this.blogList.concat(response.data.list)
      })
    },
    nextPage(){
      if(!this.blogPage.isLastPage){
        this.likeList(this.blogPage.nextPage)
      }
    }
  },
  mounted(){
    this.likeList(this.blogPage.nextPage)
  }
};
</script>

<style lang="scss">
body{
    overflow-y: scroll;
}
</style>