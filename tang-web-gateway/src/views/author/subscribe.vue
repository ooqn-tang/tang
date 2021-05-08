<template>
  <ul class="list-group blog-list">
    <li class="list-group-item" v-for="(item,index) in fansList" :key="index">
      <router-link to="/">
        <strong v-text="item.nickname"></strong>
      </router-link>
      <span class="float-end" @click="deleteFansMethod(item.username,index)">取消关注</span>
    </li>   
    <li class="list-group-item ">
      <a class="" @click="loadBlog()">获取</a>
    </li> 
  </ul>
</template>

<script>
import {deleteFans,fansList} from "/@/api/fans"
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
      fansList().then((response) => {
        this.fansList = response.data.list;
      })
    },
    deleteFansMethod(username,index){
      deleteFans(username).then((response) => {
        if(response.code == 200){
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