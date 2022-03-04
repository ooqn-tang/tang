<template>
<div style="margin:10px">
<strong>硬币余额:{{coinData}}</strong>
<hr>
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">时间</th>
      <th scope="col">金额</th>
      <th scope="col">原因</th>
    </tr>
  </thead>
  <tbody>
    <tr v-for="(item,index) in coinList" :key="index">
      <td>{{item.createTime}}</td>
      <td>{{item.coinValue}}</td>
      <td>{{item.cause}}</td>
    </tr>
  </tbody>
</table>

</div>
  
</template>

<script>
import request from 'src/utils/request'
export default {
  name: "author_coin",
  data() {
    return {
      coinData:{},
      coinList:[]
    };
  },
  methods: {
    loadCoin(){
      request({
        url: 'api/coin',
        method: 'GET'
      }).then((response) => {
        this.coinData = response.data
      })
    },
    loadCoinList(){
      request({
        url: 'api/coin/list',
        method: 'GET'
      }).then((response) => {
        this.coinList = response.data.list
      })
    }
  },
  mounted(){
    this.loadCoin()
    this.loadCoinList()
  }
};
</script>

<style lang="scss">
body{
    overflow-y: scroll;
}
</style>