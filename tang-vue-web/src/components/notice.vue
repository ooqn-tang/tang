<template>
  <div class="list-group mb-2">
    <a class="list-group-item active">推荐<span class="float-end">🎇</span></a>
    <a class="list-group-item" v-for="(item,index) in advList" v-bind:href="item.url">{{item.title}}</a>
  </div>
</template>

<script setup>
import request from '@common/request'
import { onMounted,ref } from 'vue'
let advList = ref([
  {
    url:"",
    title:"∷∷∷∷∷∷∷∷∷"
  },
  {
    url:"",
    title:"∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷"
  },
  {
    url:"",
    title:"∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷"
  },
  {
    url:"",
    title:"∷∷∷∷∷∷∷∷∷∷∷∷∷"
  },
  {
    url:"",
    title:"∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷"
  },
  {
    url:"",
    title:"∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷"
  },
  {
    url:"",
    title:"∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷"
  },
  {
    url:"",
    title:"∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷"
  },
  {
    url:"",
    title:"∷∷∷∷∷∷∷∷∷∷∷∷"
  },
  {
    url:"",
    title:"∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷"
  },
  {
    url:"",
    title:"∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷"
  },
  {
    url:"",
    title:"∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷"
  },
  {
    url:"",
    title:"∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷"
  },
  {
    url:"",
    title:"∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷"
  }
  
])

let loadNotice = () => {
  request({
    url: `/api/notice/list`,
    method: 'GET'
  }).then((res) => {
      advList.value = res.data
  })
}

onMounted(() => {
  loadNotice()
})

</script>
