<template>
  <div class="row">
    <div class="col-lg-8">
      <div class="input-group mb-2">
        <input type="text" class="form-control search-input" v-model="form.wb" placeholder="请输入" aria-label="请输入" aria-describedby="button-addon2" />
        <button class="btn btn-outline-secondary" type="button" @click="dataList = [] , so()">搜索</button>
      </div>
      <ul class="list-group mb-2 ">
        <li class="list-group-item" v-for="(item, index) in dataList" :key="index">
          <p class="article-title">
            <strong>
              <a href="#" @click="openArticle(item.articleId)">{{ item.title }}</a>
            </strong>
          </p>
          <p style="width: 100%;white-space: nowrap;overflow: hidden;text-overflow: ellipsis;">
            {{ item.synopsis }}
          </p>
        </li>
        <li class="list-group-item">
          <a @click="next()" v-if="!isLoding">获取</a><a v-if="isLoding">加载中...</a>
        </li>
      </ul>
    </div>
    <div class="col-lg-4">
      <notice></notice>
      <info></info>
    </div>
  </div>
</template>

<script setup>
import request from "@utils/request";

import notice from '@components/notice.vue';
import info from '@components/info.vue';

import { onMounted, ref } from "vue";
import { useRouter } from "vue-router";

const router = useRouter();

let dataList = ref([]);
let isLoding = ref(true);
let page = ref({number: 0})
let form = ref({wb: ""})

function so(){
  isLoding.value = true;
  form.value.page = page.value.number
  request({
    url: `/api/article/so`,
    method: "GET",
    params: form.value,
  }).then((res) => {
    page.value = res.data
    dataList.value = dataList.value.concat(res.data.content)
    isLoding.value = false;
  });
};

function next(){
  if(!page.value.last){
    page.value.number += 1
    so();
  }
}

function openArticle(dataId){
  router.push({
    name: "article",
    params: {
      articleId: dataId,
    },
  });
};

onMounted(() => {
  so();
});

</script>