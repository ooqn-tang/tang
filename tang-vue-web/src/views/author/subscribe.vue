<template>
  <ul class="list-group article-list">
    <li class="list-group-item" v-for="(item, index) in fansList" :key="index">
      <router-link target="_blank" :to="{ name: 'author_article', params: { username: item.username } }">
        <strong v-text="item.nickname"></strong>
      </router-link>
      <span class="float-end" @click="deleteFansMethod(item.username, index)">取消关注</span>
    </li>
    <li class="list-group-item" @click="loadArticle()">
      获取
    </li>
  </ul>
</template>

<script setup>
import request from 'utils/request'
import { onMounted, ref } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { useStore } from 'vuex'

let router = useRouter()
let route = useRoute()
let store = useStore()

let page = ref({
  number: 0
})
let fansList = ref([])

function findFansList(){
  request({
    url: `/api/fans/list`,
    method: 'get'
  }).then((response) => {
    fansList.value = response.data.content
  })
}

function deleteFansMethod(username, index){
  request({
    url: `/api/fans/${username}`,
    method: 'DELETE'
  }).then((response) => {
    if (response.data > 0) {
      fansList.value.splice(index, 1)
    }
  })
}

onMounted(() => {
  findFansList()
})

</script>

<style scoped>
body {
  overflow-y: scroll;
}
</style>