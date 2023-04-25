<template>
  <div class="row">
    <div class="col-md-3 col-lg-3 d-md-inline d-none">
      <div class="list-group mb-2" v-if="articleList.length > 0">
        <a class="list-group-item active">专题</a>
        <router-link :class="item.articleId == article.articleId ? 'active2' : ''" :key="index"
          :to="{ name: 'article_post', params: { id: item.articleId } }" v-for="(item, index) in articleList"
          class="list-group-item">{{ item.title }}</router-link>
      </div>

      <div class="card mb-2" v-if="recommendList == null">
        <div class="card-body">
          <div class="spinner-border" role="status">
            <span class="visually-hidden">{{ dataText }}</span>
          </div>
        </div>
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
          <div class="card mb-2 article-body">
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
              <div class="markdown-body" v-html="article.article.text"></div>
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
        <a :class="collect == 1 ? 'btn-outline-danger' : 'btn-outline-primary'" class="btn btn-sm mini-but"
          style="margin-left: 0px" @click="collectClick">收藏</a>
        <a disabled class="btn btn-outline-primary btn-sm mini-but">举报</a>
        <a class="btn btn-outline-primary btn-sm mini-but" :href="'https://ttcxy.cn/article/' + articleId">阅读模式</a>
        <a class="btn btn-outline-primary btn-sm mini-but"
          onclick="document.body.scrollTop = document.documentElement.scrollTop = 0">⬆TOP</a>
      </div>
    </div>
  </nav>
</template>

<script setup name="article_post">
import { ref, onMounted } from 'vue'
import { createStore } from 'vuex'
import { useStore } from 'vuex'
import { useRoute, useRouter } from "vue-router"
import "highlight.js/styles/github.css";
import request from "utils/request";

const router = useRouter()
const route = useRoute()
const store = useStore()

let fans = ref(1);
let articleId = ref(route.query.value);
let loginUsername = ref("");
let loading = ref(false);
let recommendList = ref(null);
let article = ref({
  article: {},
  author: {}
});
let subject = ref([]);
let articleList = ref([]);
let collect = ref(0);
let dataText = ref('加载中...')



function fansClick(username) {
  if (fans == 2) {
    request({
      url: `/api/fans/${username}`,
      method: "POST",
    }).then((response) => {
      fans = 1;
    });
  } else {
    request({
      url: `/api/fans/${username}`,
      method: "DELETE",
    }).then((response) => {
      fans = 2;
    });
  }
}
function isFans() {
  request({
    url: `/api/fans/username/${article.author.username}`,
    method: "get",
  }).then((response) => {
    if (response.data == 1) {
      fans = 1;
    } else {
      fans = 2;
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
    recommendList = response.data;
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
  //loadRecommend();
})

</script>

<style scoped>
.classColor {
  color: #ff5c5c;
}</style>