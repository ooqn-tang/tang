<template>
  <div class="row">
    <div class="col-md-9 small-col">
      <div class="row">
        <div class="col-xl-3 col-lg-4 col-md-4 col-12 mb-2" v-for="item in authorList">
          <div class="card ">
            <div class="card-body">
              <p class="card-text text-truncate">
                <router-link target="_blank" :to="{ name: 'author_article', params: { username: item.username } }">
                  <strong v-text="item.nickname"></strong>
                </router-link>
              </p>
              <p class="card-text text-truncate synopsis">简介：{{ item.signature }}</p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="col-md-3 mb-2 small-col">
      <notice></notice>
      <info></info>
    </div>
  </div>
</template>

<script setup>
import { onMounted, ref } from "vue";

import request from '@common/request';

import notice from '@components/notice.vue';
import info from '@components/info.vue';

let authorList = ref([])

function selectAuthor() {
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

<style scoped></style>