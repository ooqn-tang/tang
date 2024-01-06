<template>
  <ul class="list-group article-list">
    <li class="list-group-item" v-for="(item, index) in articleList">
      <router-link :to="{ name: 'article_post', params: { id: item.articleId } }" class="article-title">
        <strong>
          <p v-text="item.title"></p>
        </strong>
      </router-link>
      <div class="article-synopsis">{{ item.synopsis }}</div>
      <span class="tag">{{ formatTime(item.createTime) }}</span>
      <span class="tag" v-if="item.subject != null">{{ item.subject.subjectName }}</span>
      <span class="tag" v-if="item.category != null">{{ item.category.name }}</span>
      <div class="btn-group float-end">
        <button class="btn btn-outline-danger float-end btn-sm ssm" v-if="isThisUser"
          @click="deleteArticle(item.articleId, index)">
          删除
        </button>
        <router-link class="btn btn-outline-danger float-end btn-sm ssm" v-if="isThisUser" target="_blank"
          :to="{ name: 'article-editor-md', query: { article: item.articleId } }">
          修改
        </router-link>
      </div>
    </li>
    <li class="list-group-item">
      <a @click="next()">获取</a>
    </li>
  </ul>
</template>

<script setup>
import request from "@common/request";

import { onMounted, ref } from "vue";
import { useRoute } from "vue-router";
import { useAuthorStore } from "@common/user";
import { formatTime } from "@common/utils";
 
let authorStore = useAuthorStore();
let route = useRoute();

let isThisUser = route.params.username == authorStore.author.username;
let articleList = ref([]);
let page = ref({ number: 0, });
let subjectList = ref([]);

function loadArticleByUsername(pageSize) {
  request({
    url: `/api/article/list/${route.params.username}`,
    method: "get",
    params: { page: pageSize },
  }).then((res) => {
    page.value = res.data;
    articleList.value = articleList.value.concat(res.data.content);
  });
};

function loadSubjectList() {
  request({
    url: `/api/subject/username/${route.params.username}`,
    method: "GET",
  }).then((res) => {
    subjectList.value = res.data;
  });
};

function deleteArticle(articleId, index) {
  // 确认删除
  let l = confirm("确认删除？");
  if (l) {
    request({
      url: `/api/article/${articleId}`,
      method: "DELETE",
    }).then((res) => {
      if (res.status == 200) {
        articleList.value.splice(index, 1);
      }
    });
  }
};

function next() {
  if (page.value.number + 1 < page.value.totalPages) {
    loadArticleByUsername(page.value.number + 1);
  }
};

onMounted(() => {
  loadArticleByUsername(0);
  loadSubjectList();
}); 
</script>

<style scoped>
</style>@src/common/utils