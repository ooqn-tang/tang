<template>
  <ul class="list-group blog-list">
    <li class="list-group-item" v-for="(item,index) in likeList" :key="index">
      <router-link :to="{name: 'post', params: { id: item.blogId }}" class="blog-title">
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
    <li class="list-group-item ">
      <a class="" @click="loadBlog()">获取</a>
    </li> 
  </ul>
</template>

<script>
import {likeList} from "/@/api/like"
export default {
  name: "author_like",
  data() {
    return {
      likeList:[]
      
    };
  },
  components: {

  },
  methods: {
    likeListLoad(){
      likeList({"username":this.$route.params.username, "page":1}).then((response) => {
        this.likeList = response.data.list
      })
    }
    
  },
  mounted(){
    this.likeListLoad()
    
  }
};
</script>

<style lang="scss">
body{
    overflow-y: scroll;
}
</style>