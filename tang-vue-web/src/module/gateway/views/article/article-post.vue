<template>
  <div class="row">
    <div class="col-md-9 col-lg-9 pb-5">
      <div class="row">
        <div class="col-lg-12 small-col">
          <div class="card mb-2 article-body ">
            <div class="card-body" v-if="!loading">
              <h3 id="title">
                <strong>{{ article.title }}</strong>
              </h3>
              <div>
                <strong>
                  {{ article.author.nickname }}
                </strong>
                .
                <span class="time-font">{{ article.createTime }}</span>
                <button v-if="fans == 2" class="btn btn-outline-warning float-end t-b-m-1"
                  @click="fansClick(article.author.username)">
                  订阅
                </button>
                <button v-if="fans == 1" class="btn btn-outline-warning float-end t-b-m-1"
                  @click="fansClick(article.author.username)">
                  取消订阅
                </button>
                <hr>
              </div>
              <div class="markdown-body" v-html="article.text"></div>
            </div>
            <div class="card-body" v-if="loading">{{ dataText }}</div>
          </div>

          <div class="card mb-2 article-body ">
            <div class="card-body">
              <label for="exampleFormControlTextarea1" class="form-label">评论</label>
              <div class="mb-2">
                <textarea class="form-control" rows="3" placeholder="输入的内容不包含标签的内容会在最后追加标签中的内容。"
                  v-model="remark.text"></textarea>
              </div>
              <button class="btn btn-outline-secondary btn-sm" type="button">表情🙂</button>
              <button class="btn btn-outline-secondary btn-sm float-end" type="button" @click="sendRemark">发送</button>
            </div>
          </div>

          <div class="card mb-2 article-body" v-for="item in remarkList">
            <div class="card-body">
              <p style="color: rgb(0, 89, 255);">{{ item.author != null ? item.author.nickname : "未知" }}</p>
              <p>{{ item.text }}</p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="col-md-3 col-lg-3 d-md-inline small-col">
      <div class="list-group mb-2" v-if="articleList.length > 0">
        <a class="list-group-item active">专题</a>
        <router-link v-for="item in articleList" class="list-group-item"
          :class="item.articleId == article.articleId ? 'active2' : ''" :to="'/article/' + item.articleId">
          <div>{{ item.title }}</div>
        </router-link>
      </div>
      <div class="list-group mb-2">
        <a class="list-group-item active">推荐<span class="float-end">🎇</span></a>
        <a v-for="item in recommendList" class="list-group-item" :href="'/article/' + item.articleId">{{ item.title }}</a>
      </div>
      <notice></notice>
      <info></info>
    </div>
  </div>
  <nav class="navbar fixed-bottom navbar-light bg-light foot-navbar">
    <div class="container-fluid">
      <div class="col-md-12 col-lg-12 small-col">
        <a :class="collect == 1 ? 'btn-outline-danger' : 'btn-outline-primary'" class="btn btn-sm mini-but m-l-0"
          @click="collectClick">收藏</a>
        <a class="btn btn-outline-primary btn-sm mini-but" disabled>举报</a>
        <a class="btn btn-outline-primary btn-sm mini-but" :href="'https://www.ooqn.com/article/' + articleId"
          target="_blank">阅读模式</a>
        <router-link class="btn btn-outline-primary btn-sm mini-but" v-if="isThisUser" target="_blank"
          :to="{ name: 'article-editor-md', query: { article: articleId } }">修改</router-link>
        <a class="btn btn-outline-primary btn-sm mini-but"
          onclick="document.body.scrollTop = document.documentElement.scrollTop = 0">⬆TOP</a>
      </div>
    </div>
  </nav>
</template>

<script setup>
import "highlight.js/styles/github.css";
import request from "@common/request";
import { onMounted, ref, watch } from 'vue';
import { useRoute } from "vue-router";
import { useAuthorStore } from "@common/user";
import notice from '@components/notice.vue';
import info from '@components/info.vue';
import { insertCollectApi, deleteCollectApi, isCollectApi } from "@gateway/apis/collect";
import { deleteRemarkApi, selectRemarkApi, insertRemarkApi } from "@gateway/apis/remark"
import { articleSubjectArticleListApi } from "@gateway/apis/subject"

const route = useRoute()
const store = useAuthorStore()

let fans = ref(1);
let articleId = ref(route.query.value);

let loading = ref(false);
let recommendList = ref([]);
let article = ref({
  author: {}
});
let remarkList = ref([{ remarkId: '1', text: 'alksdjfkajsdf' }, { remarkId: '1', text: 'alksdjfkajsdf' }])
let isThisUser = ref(false)
let articleList = ref([]);
let collect = ref(0);
let dataText = ref('加载中...');

let remark = ref({

})

function fansClick(username) {
  if (fans.value == 2) {
    request({
      url: `/api/fans/${username}`,
      method: "POST",
    }).then((res) => {
      fans.value = 1;
    });
  } else {
    request({
      url: `/api/fans/${username}`,
      method: "DELETE",
    }).then((res) => {
      fans.value = 2;
    });
  }
}

function sendRemark() {
  remark.value.dataId = articleId;
  insertRemarkApi(remark.value).then((res) => {
    remarkList.value.unshift(res.data);
    remark.value.text = "";
  });
}

function selectRemark() {
  selectRemarkApi(articleId, 0).then((res) => {
    remarkList.value = res.data.content;
  })
}


function isFans() {
  request({
    url: `/api/fans/username/${article.value.author.username}`,
    method: "get",
  }).then((res) => {
    if (res.data == 1) {
      fans.value = 1;
    } else {
      fans.value = 2;
    }
  });
}

function collectClick() {
  if (collect.value >= 1) {
    deleteCollectApi({ url: window.location.href }).then((res) => {
      collect.value = 0;
    });
  } else {
    insertCollectApi({
      dataId: articleId,
      url: window.location.href,
      title: article.value.title,
      synopsis: article.value.synopsis
    }).then((res) => {
      collect.value = 1;
    });
  }
}

function isCollect() {
  isCollectApi({ url: window.location.href }).then((res) => {
    collect.value = res.data;
  });
}

function loadArticleInfo() {
  request({
    url: `/api/article/load/${articleId}`,
    method: "GET",
  }).then((res) => {
    article.value = res.data
    isThisUser.value = store.username == article.value.author.username
    isFans();
  });
}

function selectSubjectArticleList() {
  articleSubjectArticleListApi(articleId).then((res) => {
    articleList.value = res.data;
  });
}

function loadRecommend() {
  request({
    url: `/api/article/recommend`,
    method: "GET",
  }).then((res) => {
    recommendList.value = res.data;
  });
}

function load() {
  articleId = route.params.id;
  if (store.username != "") {
    isCollect();
  }
  selectSubjectArticleList();
  loadArticleInfo();
}


// 生命周期钩子
onMounted(() => {
  load();
  loadRecommend();
  selectRemark();
})

watch(() => route.params.id, () => {
  load();
  //loadRecommend();
  selectRemark();
  // 跳转到顶部
  document.body.scrollTop = document.documentElement.scrollTop = 0
})




</script>

<style scoped>
.classColor {
  color: #ff5c5c;
}

.m-l-0 {
  margin-left: 0px;
}

.foot-navbar {
  border-top: 1px solid rgb(206, 206, 206);
}

.time-font {
  color: rgb(180, 180, 180);
}
</style>