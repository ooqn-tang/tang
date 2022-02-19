<template>
<div style="margin:10px">
我的金币:{{creditData}}
<div v-for="(item,index) in creditList" :key="index">
  {{item.createDate}} - {{item.value > 0 ? '增加' : '减少'}} {{item.value}} - {{item.type == 1 ? '金币来源每日播放视频':''}}{{item.type == 2 ? '金币来源每日评论':''}}
</div>
</div>
  
</template>

<script>
import request from 'src/utils/request'
export default {
  name: "author_credit",
  data() {
    return {
      creditData:{},
      creditList:[]
    };
  },
  methods: {
    loadCredit(){
      request({
        url: 'api/credit',
        method: 'GET'
      }).then((response) => {
        this.creditData = response.data
      })
    },
    loadCreditList(){
      request({
        url: 'api/credit/list',
        method: 'GET'
      }).then((response) => {
        this.creditList = response.data.list
      })
    }
  },
  mounted(){
    this.loadCredit()
    this.loadCreditList()
  }
};
</script>

<style lang="scss">
body{
    overflow-y: scroll;
}
</style>