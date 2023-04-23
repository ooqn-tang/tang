<template>
  <ul class="list-group article-list">
    <li class="list-group-item" v-for="(item,index) in fansList" :key="index">
      <router-link target="_blank" :to="{name:'author_article',params:{username:item.username}}">
        <strong v-text="item.nickname"></strong>
      </router-link>
      <span class="float-end" @click="deleteFansMethod(item.username,index)">取消关注</span>
    </li>   
    <li class="list-group-item" @click="loadArticle()">
      获取
    </li> 
  </ul>
</template>

<script>
import request from 'utils/request'
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
    findFansList(){
      request({
        url: `/api/fans/list`,
        method: 'get'
      }).then((response) => {
        this.fansList = response.data.content;
      })
    },
    deleteFansMethod(username,index){
      request({
        url: `/api/fans/${username}`,
        method: 'DELETE'
      }).then((response) => {
        if(response.data > 0){
          this.fansList.splice(index,1)
        }
      })
    }
  },
  mounted(){
    this.findFansList()
  }
};
</script>

<style scoped>
body{
    overflow-y: scroll;
}
</style>