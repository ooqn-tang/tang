<template>
  <ul class="list-group article-list">
    <li class="list-group-item" v-for="item in fansList">
      <router-link target="_blank" :to="{ name: 'author_article', params: { username: item.username } }">
        <strong v-text="item.nickname"></strong>
      </router-link>
      <button class="btn btn-outline-danger float-end fans-but"
        @click="deleteFansMethod(item.username, index)">取消关注</button>
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

function findFansList() {
  request({
    url: `/api/fans/list`,
    method: 'get'
  }).then((res) => {
    fansList.value = res.data.content
  })
}

function deleteFansMethod(username, index) {
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
.fans-but {
  padding: 0px 5px 0px 3px;
  font-size: 13px;
}
</style>