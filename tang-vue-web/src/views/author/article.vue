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
        <span style="
            background: #efefef;
            padding: 0px 5px;
            border-radius: 10px;
            color: #7d7d7d;
          ">专辑 : {{ item.subject.subjectName }}</span>
      </p>
      <span style="
          background: #efefef;
          padding: 0px 5px;
          border-radius: 10px;
          color: #7d7d7d;
        ">{{ item.article.createTime }}</span>

      <div class="btn-group float-end">
        <button class="btn btn-outline-danger float-end blog-btn" v-if="isThisUser"
          @click="deleteArticle(item.article.articleId, index)">
          删除
        </button>
        <router-link class="btn btn-outline-danger float-end blog-btn" v-if="isThisUser" target="_blank"
          :to="{ name: 'article-editor-md', params: { id: item.article.articleId } }">修改</router-link>
        <button class="btn btn-outline-success float-end blog-btn"
          v-if="item.subject == null && isThisUser" data-bs-toggle="modal" data-bs-target="#exampleModal"
          @click="(subjectFrom.articleId = item.article.articleId), (thisItem = item)">
          添加到专辑
        </button>
        <button class="btn btn-outline-warning float-end blog-btn" v-if="item.subject != null && isThisUser"
          data-bs-toggle="modal" data-bs-target="#exampleModal"
          @click="clickSubject(item)">
          修改到专辑
        </button>
      </div>
    </li>
    <li class="list-group-item">
      <a @click="next()">获取</a>
    </li>
  </ul>

  <!-- Modal -->
  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">添加博客到专辑</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <select class="form-select" v-model="subjectFrom.subjectId">
            <option value="">请选择</option>
            <option v-for="(item, index) in subjectList" :key="index" :value="item.subjectId">
              {{ item.subjectName }}
            </option>
          </select>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" ref="close">
            关闭
          </button>
          <button type="button" class="btn btn-primary" @click="updateArticleToSubject">
            保存
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import request from "utils/request";

import { onMounted, ref } from "vue";
import { useRouter } from "vue-router";
import { useStore } from "vuex";
import { useRoute } from "vue-router"

let router = useRouter();
let store = useStore();
let route = useRoute();

let thisUsername = route.params.username;
let isThisUser = route.params.username == store.state.username;
let thisItem = ref({});
let articleList = ref([]);
let page = ref({
  number: 0,
});
let subjectFrom = ref({
  subjectId: "",
});
let subjectList = ref([]);
let close = ref(null);

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

let clickSubject = (item) => {
  subjectFrom.value.articleId = item.article.articleId;
  subjectFrom.value.subjectId = item.subject.subjectId;
  thisItem.value = item
};

let loadSubjectList = () => {
  request({
    url: `/api/subject/username/${route.params.username}`,
    method: "GET",
  }).then((response) => {
    subjectList.value = response.data;
  });
};

let updateArticleToSubject = () => {
  request({
    url: `/api/subject/article`,
    params: { subjectId: subjectFrom.value.subjectId, articleId: subjectFrom.value.articleId },
    method: "PUT",
  }).then((response) => {
    if (response.status == 200) {
      thisItem.value.subject = {
        subjectId: subjectFrom.value.subjectId,
        subjectName: subjectList.value.find((item) => item.subjectId == subjectFrom.value.subjectId).subjectName,
      };
      close.value.click();
    }
  });
};

let deleteArticle = (articleId, index) => {
  request({
    url: `/api/article/${articleId}`,
    method: "DELETE",
  }).then((response) => {
    if (response.data.code == 200) {
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
</style>