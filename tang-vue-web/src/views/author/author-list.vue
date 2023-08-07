<template>
  <div class="row">
    <div class="col-md-9 mb-2">
      <div class="row">
        <div class="col-xl-3 col-lg-4 col-md-4 col-12 mb-2 move-p-lr-0" v-for="(item, index) in authorList" :key="index">
          <div class="card move-b-lr-0">
            <div class="card-body">
              <p class="card-text text-truncate">
                <router-link target="_blank" :to="{ name: 'author_article', params: { username: item.username } }">
                  <strong v-text="item.nickname"></strong>
                </router-link>
              </p>
              <p class="card-text text-truncate">简介：{{ item.signature }}</p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="col-md-3 mb-2 move-p-lr-0">
      <div class="list-group mb-2 move-b-lr-0">
        <notice></notice>
      </div>
      <div class="card mb-2 move-b-lr-0">
        <info></info>
      </div>
    </div>
  </div>
</template>

<script setup>
import { onMounted, ref } from "vue";

import request from 'utils/request';

let authorList = ref([])

function selectAuthor(){
  request({
    url: `/api/author/selectAuthor`,
    method: 'GET'
  }).then((res) => {
    authorList.value = res.data.content
  })
}

onMounted(() => {
  selectAuthor()
})

</script>

<style scoped>
body {
  overflow-y: scroll;
}
</style>