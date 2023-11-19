<template>
  <ul class="list-group article-list">
    <li class="list-group-item" v-for="(item,index) in collects" :key="index">
      {{ item }}
      <!-- <a target="_blank" :href="item.url" class="article-title">
        <strong>{{item.title}}</strong><span style="float:right">{{item.createDate}}</span>
      </a> -->
    </li>   
    <li class="list-group-item" >
      <a @click="next()">{{huoqu}}</a>
    </li> 
    <li class="list-group-item" v-if="collects.length == 0">
      没有数据
    </li>
  </ul>
</template>

<script setup>
import request from '@utils/request';
import { onMounted,ref } from 'vue';

let page = ref({
  number: 0
})

let huoqu = ref('获取中...')

let collects = ref([])

function collectList(pageNum){
  request({
    url: `/api/collect/list`,
    method: 'GET',
    params:{page: page.value.number}
  }).then((res) => {
    page.value = res.data
    collects.value = collects.value.concat(res.data.content)
  })
}

function next(){
  if (!page.value.last) {
    page.value.number += 1
    collectList(page.value.number)
  }
}

onMounted(() => {
  collectList(page.value.number)
})

</script>

<style scoped>
body{
    overflow-y: scroll;
}
</style>