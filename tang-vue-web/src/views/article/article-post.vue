<template>
  <div class="row">
    <div class="col-md-3 col-lg-3 d-md-inline d-none">
      <div class="list-group mb-2" v-if="articleList.length > 0">
        <a class="list-group-item active">专题</a>
          <a v-for="(item, index) in articleList" class="list-group-item" :class="item.articleId == article.articleId ? 'active2' : ''" :key="index"
          :href="'/article/' + item.articleId">{{ item.title }}</a>
      </div>
      <div class="list-group mb-2">
        <a class="list-group-item active">推荐<span class="float-end">🎇</span></a>
        <a v-for="(item, index) in recommendList" class="list-group-item" :key="index"
          :href="'/article/' + item.articleId">{{ item.title }}</a>
      </div>
    </div>
    <div class="col-md-9 col-lg-9 pb-5">
      <div class="row">
        <div class="col-lg-8 move-p-lr-0">
          <div class="card mb-2 article-body move-b-lr-0">
            <div class="card-body" v-if="!loading">
              <div>
                <strong>
                  {{ article.author.nickname }}
                </strong>
                .
                <span style="color: rgb(180, 180, 180)">{{ article.article.createTime }}</span>
                <button v-if="fans == 2" class="btn btn-outline-warning float-end t-b-m-1"
                  @click="fansClick(article.author.username)">
                  订阅
                </button>
                <button v-if="fans == 1" class="btn btn-outline-warning float-end t-b-m-1"
                  @click="fansClick(article.author.username)">
                  取消订阅
                </button>
              </div>
              <h3>
                <strong>{{ article.article.title }}</strong>
              </h3>
              <div class="markdown-body" v-html="article.articleContext.text"></div>
            </div>
            <div class="card-body" v-if="loading">{{ dataText }}</div>
          </div>
        </div>
        <div class="col-lg-4 move-p-lr-0">
          <div class="list-group mb-2 move-b-lr-0">
            <notice></notice>
          </div>
          <div class="card move-b-lr-0">
            <info></info>
          </div>
        </div>
      </div>
    </div>
  </div>
  <nav class="navbar fixed-bottom navbar-light bg-light" style="border-top: 1px solid rgb(206, 206, 206)">
    <div class="container-fluid">
      <div class="col-md-12 col-lg-12">
        <a :class="collect == 1 ? 'btn-outline-danger' : 'btn-outline-primary'" class="btn btn-sm mini-but" style="margin-left: 0px" @click="collectClick">收藏</a>
        <a class="btn btn-outline-primary btn-sm mini-but" disabled>举报</a>
        <a class="btn btn-outline-primary btn-sm mini-but" :href="'https://blog.ooqn.com/article/' + articleId" target="_blank">阅读模式</a>
        <router-link class="btn btn-outline-primary btn-sm mini-but" v-if="isThisUser" target="_blank" :to="{ name: 'article-editor-md', params: { id: articleId } }">修改</router-link>
        <a class="btn btn-outline-primary btn-sm mini-but" onclick="document.body.scrollTop = document.documentElement.scrollTop = 0">⬆TOP</a>
      </div>
    </div>
  </nav>
</template>

<script setup>
import "highlight.js/styles/github.css";
import request from "utils/request";
import { onMounted, ref } from 'vue';
import { useRoute, useRouter } from "vue-router";
import { useStore } from 'vuex';

const router = useRouter()
const route = useRoute()
const store = useStore()

let fans = ref(1);
let articleId = ref(route.query.value);
let loginUsername = ref("");

let loading = ref(false);
let recommendList = ref([]);
let article = ref({
  article: {},
  author: {},
  articleContext:{}
});
let isThisUser = ref(false)
let subject = ref([]);
let articleList = ref([]);
let collect = ref(0);
let dataText = ref('加载中...')



function fansClick(username) {
  if (fans.value == 2) {
    request({
      url: `/api/fans/${username}`,
      method: "POST",
    }).then((response) => {
      fans.value = 1;
    });
  } else {
    request({
      url: `/api/fans/${username}`,
      method: "DELETE",
    }).then((response) => {
      fans.value = 2;
    });
  }
}
function isFans() {
  request({
    url: `/api/fans/username/${article.value.author.username}`,
    method: "get",
  }).then((response) => {
    if (response.data == 1) {
      fans.value = 1;
    } else {
      fans.value = 2;
    }
  });
}
function collectClick() {
  if (collect == 1) {
    request({
      url: `/api/collect/${articleId}`,
      method: "DELETE",
    }).then((response) => {
      collect = 0;
    });
  } else {
    request({
      url: `/api/collect`,
      method: "POST",
      data: {
        dataId: articleId,
        url: window.location.href,
        title: article.title,
        synopsis: article.synopsis
      }
    }).then((response) => {
      collect = 1;
    });
  }
}
function isLike() {
  request({
    url: `/api/collect/${articleId}`,
    method: "GET",
  }).then((response) => {
    collect = response.data;
  });
}
function loadArticleInfo() {
  request({
    url: `/api/article/load/${articleId}`,
    method: "GET",
  }).then((response) => {
    article.value = response.data
    isThisUser.value = store.state.username == article.value.author.username
    isFans();
  });
}
function selectSubjectArticleList() {
  request({
    url: `/api/subject/article/${articleId}`,
    method: "GET",
  }).then((response) => {
    articleList = response.data;
  });
}
function loadRecommend() {
  request({
    url: `/api/article/recommend`,
    method: "GET",
  }).then((response) => {
    recommendList.value = response.data;
  });
}
function load() {
  articleId = route.params.id;
  if (store.state.username != "") {
    isLike();
  }
  selectSubjectArticleList();
  loadArticleInfo();
}


// 生命周期钩子
onMounted(() => {
  load();
  loadRecommend();
})

</script>

<style scoped>
.classColor {
  color: #ff5c5c;
}</style>