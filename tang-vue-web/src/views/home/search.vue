<template>
  <div class="row">
    <div class="col-lg-8 move-p-lr-0">
      <div class="input-group mb-2 move-search">
        <input type="text" class="form-control search-input" v-model="form.wb" placeholder="请输入" aria-label="请输入"
          aria-describedby="button-addon2" />
        <button class="btn btn-outline-secondary" type="button" @click="dataList = [] , so()">搜索</button>
      </div>
      <ul class="list-group mb-2 move-b-lr-0">
        <li class="list-group-item" v-for="(item, index) in dataList" :key="index">
          <p class="article-title">
            <strong>
              <a href="#" @click="openArticle(item.article.articleId)">{{ item.article.title }}</a>
            </strong>
            <a href="#" class=" float-end">{{ item.author.nickname }}</a>
          </p>
        </li>
        <li class="list-group-item">
          <a @click="next()" v-if="!isLoding">获取</a><a v-if="isLoding">加载中...</a>
        </li>
      </ul>
    </div>
    <div class="col-lg-4 move-p-lr-0">
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
import request from "utils/request";

import { onMounted, ref } from "vue";
import { useRouter, useRoute } from "vue-router";
import { useStore } from "vuex";

const route = useRoute();
const router = useRouter();
const store = useStore();

let dataList = ref([]);
let searchText = ref("文章");
let isLoding = ref(true);
let page = ref({
  number: 0
})
let form = ref({
  wb: ""
})

let so = () => {
  isLoding.value = true;
  form.value.page = page.value.number
  request({
    url: `/api/article/so`,
    method: "GET",
    params: form.value,
  }).then((response) => {
    page.value = response.data
    dataList.value = dataList.value.concat(response.data.content)
    isLoding.value = false;
  });
};

let next = () => {
  if(!page.value.last){
    page.value.number += 1
    so();
  }
}

let openArticle = (dataId) => {
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