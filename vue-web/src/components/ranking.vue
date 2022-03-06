<template>
  <a class="list-group-item active">七日排行榜<span class="float-end">🎇</span></a>
  <a v-for="(item,index) in rankingList" :key="index" v-bind:href="'/video/'+item.videoId" class="list-group-item move-b-lr-0">{{item.title}}</a>
</template>

<script>
import request from 'src/utils/request'
export default {
  name: 'ranking',
  data() {
    return {
      count: 0,
      rankingList:[]
    }
  },
  created() {
  },
  methods: {
    loadRanking(){
        request({
          url: '/api/video/ranking',
          method: 'GET'
        }).then((response) => {
            this.rankingList = response.data
        })
    }
  },
  mounted(){
      this.loadRanking()
  }
}
</script>
