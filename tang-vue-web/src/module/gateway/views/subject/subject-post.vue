<template>
  <div class="row clearfix">
    <div class="col-md-9 small-col">
      <div class="card mb-2">
        <div class="card-body">
          <h4>{{ subjectData.subjectName }}</h4>
          <span>{{ subjectData.synopsis }}</span>
          <hr>
          <div>
            <router-link :to="'/author/' + subjectData.author.username">{{ subjectData.author.nickname }}</router-link>
            <span class="float-end">{{ subjectData.createTime }}</span>
          </div>
        </div>
      </div>
      <ul class="list-group mb-2">
        <li class="list-group-item " v-for="(item, index) in subjectData.dataArray" :key="index">
          <router-link :to="{ name: 'article_post', params: { id: item.articleId } }" class="article-title">
            <strong>
              <p v-text="item.title"></p>
            </strong>
          </router-link>
          <div class="article-synopsis">{{ item.synopsis }}</div>
          <div>
            <span class="date-color">{{ item.createDate }}</span>
          </div>
        </li>
      </ul>
    </div>
    <div class="col-md-3 mb-2 small-col">
      <div class="list-group mb-2">
        <notice></notice>
      </div>
      <div class="card mb-2">
        <info></info>
      </div>
    </div>
  </div>
</template>

<script setup>
import request from '@common/request'
import { onMounted, ref } from 'vue'
import { useRoute } from 'vue-router'

import notice from '@components/notice.vue';
import info from '@components/info.vue';

let route = useRoute()

let subjectData = ref({
  subject: {
    subjectName: "∷∷∷∷∷∷∷∷∷",
    synopsis: "∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷",
    createDate: "∷∷∷∷∷∷∷"
  },
  author: {
    username: "∷∷∷∷∷∷∷∷∷",
    nickname: "∷∷∷∷∷∷∷∷∷",
  },
  dataArray: []
})

function loadSubjectById() {
  request({
    url: `/api/subject/id/${route.params.subject_id}`,
    method: 'GET',
  }).then((res) => {
    subjectData.value = res.data
  })
}

onMounted(() => {
  loadSubjectById()
})

</script>

<style scoped>
body {
  overflow-y: scroll;
}

.article-synopsis {
  color: #5f5a5a;
}
</style>