<template>
  <ul class="list-group article-list">
    <li class="list-group-item" v-for="(item, index) in fansList">
      <router-link target="_blank" :to="{ name: 'author_article', params: { username: item.username } }">
        <strong v-text="item.nickname"></strong>
      </router-link>
      <span class="float-end" @click="deleteFansMethod(item.username, index)">取消关注</span>
      <div class="article-synopsis">{{ item.signature }}</div>
    </li>
    <li class="list-group-item" @click="loadArticle()">
      获取
    </li>
  </ul>
</template>

<script setup>
import request from '@common/request'
import { onMounted, ref } from 'vue'

let fansList = ref([])

function findFansList(){
  request({
    url: `/api/fans/list`,
    method: 'get'
  }).then((res) => {
    fansList.value = res.data.content
  })
}

function deleteFansMethod(username, index){
  request({
    url: `/api/fans/${username}`,
    method: 'DELETE'
  }).then((res) => {
    if (res.data > 0) {
      fansList.value.splice(index, 1)
    }
  })
}

onMounted(() => {
  findFansList()
})

</script>

<style scoped>

</style>