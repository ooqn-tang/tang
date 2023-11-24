<template>
  <div class="row clearfix">
    <div class="col-md-9 ">
      <div class="row">
        <div class="col-xl-3 col-lg-4 col-md-4 col-12 mb-2" v-for="(item, index) in subjectList"
          :key="index">
          <div class="card ">
            <div class="card-body">
              <p class="card-text text-truncate">
                <router-link :to="{name:'subject_post',params:{subject_id:item.subjectId}}">
                  <strong>{{item.subjectName}}</strong>
                </router-link>
              </p>
              <p class="card-text text-truncate">作者：{{item.author.nickname}}</p>
              <p class="card-text text-truncate">专辑描述：{{item.synopsis}}</p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="col-md-3  mb-2 ">
      <div class="list-group mb-2  ">
        <notice></notice>
      </div>
      <div class="card mb-2  ">
        <info></info>
      </div>
    </div>
  </div>

</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useAuthorStore } from '@common/user'
import { useRouter,useRoute } from 'vue-router'

import notice from '@components/notice.vue';
import info from '@components/info.vue';

import request from '@common/request'

const authorStore = useAuthorStore()
const router = useRouter()

let subjectList = ref([])
let username = authorStore.username

onMounted(() => {
  selectSubjectList()
})

function selectSubjectList() {
  request({
    url: `/api/subject/list`,
    method: 'GET'
  }).then((res) => {
    subjectList.value = res.data.content
  })
}
</script>

<style scoped>
body {
  overflow-y: scroll;
}
</style>