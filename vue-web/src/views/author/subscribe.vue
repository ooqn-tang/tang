<template>
  <ul class="list-group article-list">
    <li class="list-group-item" v-for="(item,index) in fansList" :key="index">
      <router-link target="_blank" :to="{name:'author_article',params:{username:item.username}}">
        <strong v-text="item.nickname"></strong>
      </router-link>
      <span class="float-end" @click="deleteFansMethod(item.username,index)">取消关注</span>
    </li>   
    <li class="list-group-item ">
      <a class="" @click="loadArticle()">获取</a>
    </li> 
  </ul>
</template>

<script>
import request from 'src/utils/request'
export default {
  name: "author_subscribe",
  data() {
    return {
      fansList:[]
    };
  },
  components: {

  },
  methods: {
    fansListMethod(){
      request({
        url: '/api/fans/list',
        method: 'get'
      }).then((response) => {
        this.fansList = response.data.list;
      })
    },
    deleteFansMethod(username,index){
      request({
        url: '/api/fans/' + username,
        method: 'DELETE'
      }).then((response) => {
        if(response.data.code == 200){
          this.fansList.splice(index,1)
        }
      })
    }
  },
  mounted(){
    this.fansListMethod()
  }
};
</script>

<style lang="scss">
body{
    overflow-y: scroll;
}
</style>