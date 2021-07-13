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
import {likeList} from "/@/api/like"
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
    likeListLoad(pageSize){
      likeList({"username":this.$route.params.username,page:pageSize}).then((response) => {
        this.blogPage = response.data
        this.blogList = this.blogList.concat(response.data.list)
      })
    },
    nextPage(){
      if(!this.blogPage.isLastPage){
        this.likeListLoad(this.blogPage.nextPage)
      }
    }
  },
  mounted(){
    this.likeListLoad(this.blogPage.nextPage)
  }
};
</script>

<style lang="scss">
body{
    overflow-y: scroll;
}
</style>