<template>
  <ul class="list-group article-list">
    <li class="list-group-item" v-for="(item,index) in collects" :key="index">
      <a target="_blank" :href="item.url" class="article-title">
        <strong>{{item.title}}</strong><span class="float-end">{{item.createDate}}</span>
      </a>
      <div class="article-synopsis">{{ item.synopsis }}</div>
      <span class="tag">{{ item.createTime }}</span>
      <div class="btn-group float-end">
        <button class="btn btn-outline-danger float-end blog-btn" v-if="isThisUser" @click="deleteCollect(item.url, index)">
          删除
        </button>
      </div>
    </li>   
    <li class="list-group-item" >
      <a @click="next()">{{huoqu}}</a>
    </li> 
    <li class="list-group-item" v-if="collects.length == 0">
      没有数据
    </li>
  </ul>
</template>

<script setup>
import { onMounted,ref } from 'vue';
import { useRoute } from "vue-router";
import { useStore } from "vuex";
import { collectListApi,deleteCollectApi } from "@apis/collect"

let store = useStore();
let route = useRoute();

let isThisUser = route.params.username == store.state.username;

let page = ref({
  number: 0
})

let huoqu = ref('获取中...')

let collects = ref([])

function collectList(pageNum){
  collectListApi({page: page.value.number}).then((res) => {
    page.value = res.data
    collects.value = collects.value.concat(res.data.content)
  })
}

function deleteCollect(url, index){
  deleteCollectApi({url:url}).then((res) => {
    collects.value.splice(index, 1);
  })
}

function next(){
  if (!page.value.last) {
    page.value.number += 1
    collectList(page.value.number)
  }
}

onMounted(() => {
  collectList(page.value.number)
})

</script>

<style scoped>
body{
    overflow-y: scroll;
}


.tag {
  background: #efefef;
  padding: 0px 5px;
  border-radius: 10px;
  color: #7d7d7d;
  margin-right: 5px;
}
</style>