<template>
<div class="row clearfix">
    <div class="col-md-9  move-p-lr-0">
      <div class="card mb-2  move-b-lr-0">
        <div class="card-body">
          <h4>{{subjectData.subjectName}}</h4>
          <span>{{subjectData.synopsis}}</span>
          <hr>
          <div>
            <router-link :to="'/author/'+subjectData.author.username">{{subjectData.author.nickname}}</router-link>
            <span class="float-end">{{subjectData.createTime}}</span>
          </div>
        </div>
      </div>
      <ul class="list-group  mb-2 move-b-lr-0">
        <li class="list-group-item move-b-lr-0" v-for="(item,index) in subjectData.articleList" :key="index">
          <router-link :to="{name: 'article_post', params: {id: item.articleId}}" class="article-title">
            <strong><p v-text="item.title"></p></strong>
          </router-link>
          <div class="article-synopsis" style="color: #5f5a5a;">{{item.synopsis}}</div>
          <div>
            <span class="date-color">{{item.createDate}}</span>
          </div>
        </li>
      </ul>
    </div>
    <div class="col-md-3  mb-2  move-p-lr-0">
      <div class="list-group mb-2  move-b-lr-0">
        <notice></notice>
      </div>
      <div class="card mb-2  move-b-lr-0">
        <info></info>
      </div>
    </div>
</div>
 
</template>

<script setup>
import request from 'utils/request'
import { onMounted,ref } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import { useStore } from 'vuex'

import notice from 'components/notice.vue';
import info from 'components/info.vue';

let router = useRouter()
let route = useRoute()
let store = useStore()

let username = store.getters.username
let subjectData = ref({
  subject:{
    subjectName:"∷∷∷∷∷∷∷∷∷",
    synopsis:"∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷",
    createDate:"∷∷∷∷∷∷∷"
  },
  author:{
    username:"∷∷∷∷∷∷∷∷∷",
    nickname:"∷∷∷∷∷∷∷∷∷",
  },
  articleList:[]
})

function loadSubjectById(){
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
body{
    overflow-y: scroll;
}
</style>