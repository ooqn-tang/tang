<template>
  <ul class="list-group article-list">
    <li class="list-group-item" v-for="(item, index) in articleList" :key="index">
      <router-link :to="{ name: 'article_post', params: { id: item.article.articleId } }" class="article-title">
        <strong>
          <p v-text="item.article.title"></p>
        </strong>
      </router-link>
      <div class="article-synopsis">{{ item.article.synopsis }}</div>
      <p v-if="item.subject != null">
        <span class="tag">专辑 : {{ item.subject.subjectName }}</span>
      </p>
      <span class="tag">{{ item.article.createTime }}</span>
      <span v-if="item.category != null" class="tag">{{ item.category.name }}</span>

      <div class="btn-group float-end">
        <button class="btn btn-outline-danger float-end blog-btn" v-if="isThisUser"
          @click="deleteArticle(item.article.articleId, index)">
          删除
        </button>
        <router-link class="btn btn-outline-warning float-end blog-btn" v-if="isThisUser" target="_blank"
          :to="{ name: 'article-editor-md', params: { id: item.article.articleId } }">修改</router-link>
      </div>
    </li>
    <li class="list-group-item">
      <a @click="next()">获取</a>
    </li>
  </ul>
</template>

<script setup>
import request from "utils/request";

import { onMounted, ref } from "vue";
import { useRoute } from "vue-router";
import { useStore } from "vuex";

let store = useStore();
let route = useRoute();

let isThisUser = route.params.username == store.state.username;
let articleList = ref([]);
let page = ref({ number: 0, });
let subjectList = ref([]);

let loadArticleByUsername = (pageSize) => {
  request({
    url: `/api/article/list/${route.params.username}`,
    method: "get",
    params: { page: pageSize },
  }).then((response) => {
    page.value = response.data;
    articleList.value = articleList.value.concat(response.data.content);
  });
};

let loadSubjectList = () => {
  request({
    url: `/api/subject/username/${route.params.username}`,
    method: "GET",
  }).then((response) => {
    subjectList.value = response.data;
  });
};

let deleteArticle = (articleId, index) => {
  request({
    url: `/api/article/${articleId}`,
    method: "DELETE",
  }).then((response) => {
    if (response.status == 200) {
      articleList.value.splice(index, 1);
    }
  });
};

let next = () => {
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
body {
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