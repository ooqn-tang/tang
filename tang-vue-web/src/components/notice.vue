<template>
  <a class="list-group-item active">推荐<span class="float-end">🎇</span></a>
  <a v-for="(item,index) in advList" :key="index" v-bind:href="item.url" class="list-group-item move-b-lr-0">{{item.title}}</a>
</template>

<script>
import request from 'utils/request'
export default {
  name: 'notice',
  data() {
    return {
      count: 0,
      advList:[]
    }
  },
  created() {
  },
  methods: {
    loadNotice(){
      request({
        url: '/api/notice/list',
        method: 'GET'
      }).then((response) => {
          this.advList = response.data
      })
    }
  },
  mounted(){
      this.loadNotice()
  }
}
</script>
