<template>
  <ul class="list-group article-list">
    <li class="list-group-item" v-for="(item, index) in collects">
      <a target="_blank" :href="item.url" class="article-title">
        <strong>{{ item.title }}</strong>
      </a>
      <div class="article-synopsis">{{ item.synopsis }}</div>
      <span class="tag">{{ formatTime(item.createDate) }}</span>
      <div class="btn-group float-end">
        <button class="btn btn-outline-danger float-end btn-sm" v-if="isThisUser"
          @click="deleteCollect(item.url, index)">
          删除
        </button>
      </div>
    </li>
    <li class="list-group-item">
      <a @click="next()">{{ huoqu }}</a>
    </li>
  </ul>
</template>

<script setup>
import { ref } from 'vue';
import { useRoute } from "vue-router";
import { useAuthorStore } from "@common/user";
import { collectListApi, deleteCollectApi } from "@gateway/apis/collect";

import { formatTime } from "@common/utils";

let authorStore = useAuthorStore();
let route = useRoute();

let isThisUser = route.params.username == authorStore.author.username;

let page = ref({
  number: 0
})

let huoqu = ref('获取中...')

let collects = ref([])

function collectList(pageNum) {
  huoqu.value = '获取中...'
  collectListApi({ page: page.value.number }).then((res) => {
    page.value = res.data;
    collects.value = collects.value.concat(res.data.content);
    huoqu.value = '获取';
  })
}

function deleteCollect(url, index) {
  deleteCollectApi({ url: url }).then((res) => {
    collects.value.splice(index, 1);
  })
}

function next() {
  if (!page.value.last) {
    page.value.number += 1;
    collectList(page.value.number);
  }
}

collectList(page.value.number);

</script>

<style scoped>
</style>@src/common/utils