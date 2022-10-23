<template>
  <ul class="list-group article-list">
    <li class="list-group-item" v-for="(item,index) in collects" :key="index">
      <a target="_blank" :href="item.url" class="article-title">
        <strong>{{item.title}}</strong><span style="float:right">{{item.createDate}}</span>
      </a>
    </li>   
    <li class="list-group-item" >
      <a @click="next()">{{huoqu}}</a>
    </li> 
    <li class="list-group-item" v-if="collects.length == 0">
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
      page:{
        number:0
      },
      collects:[],
      huoqu:"获取中..."
    };
  },
  methods: {
    collectList(pageNum){
      this.huoqu = '获取中...'
      request({
        url: '/api/collect/list',
        method: 'GET',
        params:{page: this.page.number}
      }).then((response) => {
        this.page = response.data
        this.collects = this.collects.concat(response.data.content)
        this.huoqu = '获取'
      })
    },
    next(){
      if (!this.page.last) {
        this.page.number += 1
        this.collectList(this.page.number)
      }
    }
  },
  mounted(){
    this.collectList(this.page.number)
  }
};
</script>

<style scoped>
body{
    overflow-y: scroll;
}
</style>