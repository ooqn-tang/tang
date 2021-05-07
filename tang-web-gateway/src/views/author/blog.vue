<template>
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
  </ul>

</template>

<script>
import {loadBlogByUsername} from '/@/api/blog'
export default {
  name: "authorBlog",
  data() {
    return {
      blogList:[
        
      ],
    };
  },
  components: {

  },
  methods: {
    loadBlogByUsername(){
      loadBlogByUsername(this.thisUsername,this.from).then((response) => {
        this.blogList = response.data.list
      })
    }
  },
  mounted(){
    this.loadBlogByUsername() 
  }
};
</script>

<style lang="scss">
body{
    overflow-y: scroll;
}
</style>