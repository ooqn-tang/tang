<template>
  <ul class="list-group article-list">
    <li
      class="list-group-item"
      v-for="(item, index) in articleList"
      :key="index"
    >
      <router-link
        :to="{ name: 'article_post', params: { id: item.articleId } }"
        class="article-title"
      >
        <strong><p v-text="item.title"></p></strong>
      </router-link>
      <div class="article-synopsis">{{ item.synopsis }}</div>
      <p v-if="item.subjectName != null">
        <span
          style="
            background: #efefef;
            padding: 0px 5px;
            border-radius: 10px;
            color: #7d7d7d;
          "
          >专辑 : {{ item.subjectName }}</span
        >
      </p>
      <span
        style="
          background: #efefef;
          padding: 0px 5px;
          border-radius: 10px;
          color: #7d7d7d;
        "
        >{{ item.createDate }}</span
      >

      <div class="btn-group float-end">
        <button
          class="btn btn-outline-danger float-end blog-btn"
          v-if="isThisUser"
          @click="deleteArticle(item.articleId, index)"
        >
          删除
        </button>
        <router-link
          class="btn btn-outline-danger float-end blog-btn"
          v-if="isThisUser"
          target="_blank"
          :to="{ name: 'article-editor-md', params: { id: item.articleId } }"
          >修改</router-link
        >
        <button
          class="btn btn-outline-success float-end blog-btn"
          style=""
          v-if="item.subjectName == null && isThisUser"
          data-bs-toggle="modal"
          data-bs-target="#exampleModal"
          @click="(subjectFrom.articleId = item.articleId), (thisItem = item)"
        >
          添加到专辑
        </button>
        <button
          class="btn btn-outline-warning float-end blog-btn"
          v-if="item.subjectName != null && isThisUser"
          data-bs-toggle="modal"
          data-bs-target="#exampleModal"
          @click="(subjectFrom.articleId = item.articleId), (thisItem = item)"
        >
          修改到专辑
        </button>
      </div>
    </li>
    <li class="list-group-item">
      <a @click="nextPage()">获取</a>
    </li>
  </ul>

  <!-- Modal -->
  <div
    class="modal fade"
    id="exampleModal"
    tabindex="-1"
    aria-labelledby="exampleModalLabel"
    aria-hidden="true"
  >
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">添加博客到专辑</h5>
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></button>
        </div>
        <div class="modal-body">
          <select class="form-select" v-model="subjectFrom.subjectId">
            <option value="">请选择</option>
            <option
              v-for="(item, index) in subjectList"
              :key="index"
              :value="item.subjectId"
            >
              {{ item.subjectName }}
            </option>
          </select>
        </div>
        <div class="modal-footer">
          <button
            type="button"
            class="btn btn-secondary"
            data-bs-dismiss="modal"
            ref="close"
          >
            关闭
          </button>
          <button
            type="button"
            class="btn btn-primary"
            @click="updateArticleToSubject"
          >
            保存
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import request from "utils/request";
export default {
  name: "author_article",
  data() {
    return {
      thisUsername: this.$route.params.username,
      isThisUser: this.$route.params.username == this.$store.state.username,
      thisItem: {},
      articleList: [],
      articlePage: {
        nextPage: 0,
      },
      subjectFrom: {
        subjectId: "",
      },
      subjectList: [],
    };
  },
  methods: {
    loadArticleByUsername(pageSize) {
      request({
        url: "/api/article/list/" + this.$route.params.username,
        method: "get",
        params: { page: pageSize },
      }).then((response) => {
        if (response.data != undefined) {
          this.articleList = this.articleList.concat(response.data.content);
        }
      });
    },
    loadSubjectList() {
      request({
        url: "/api/subject/username",
        method: "GET",
        params: { username: this.$route.params.username },
      }).then((response) => {
        this.subjectList = response.data.content;
      });
    },
    insertArticleToSubject() {
      let articleId = this.subjectFrom.articleId;
      let subjectId = this.subjectFrom.subjectId;
      request({
        url: "/api/subject/article",
        method: "POST",
        params: { articleId: articleId, subjectId: subjectId },
      }).then((response) => {
        this.thisItem.subjectId = subjectId;
        this.$refs.close.click();
      });
    },
    updateArticleToSubject() {
      let articleId = this.subjectFrom.articleId;
      let subjectId = this.subjectFrom.subjectId;
      request({
        url: "/api/subject/article",
        method: "PUT",
        params: { articleId: articleId, subjectId: subjectId },
      }).then((response) => {
        this.thisItem.subjectId = subjectId;
        for (let i in this.subjectList) {
          let t = this.subjectList[i];
          if (subjectId == t.subjectId) {
            this.thisItem.subjectName = t.subjectName;
          }
        }
        this.$refs.close.click();
      });
    },
    deleteArticle(articleId, index) {
      request({
        url: "/api/article/" + articleId,
        method: "DELETE",
      }).then((response) => {
        this.articleList.splice(index, 1);
      });
    },
    nextPage() {
      if (!this.articlePage.isLastPage) {
        this.loadArticleByUsername(this.articlePage.nextPage);
      }
    },
  },
  mounted() {
    this.loadArticleByUsername(this.articlePage.nextPage);
    this.loadSubjectList();
  },
};
</script>

<style scoped>
body {
  overflow-y: scroll;
}
.blog-btn{
  padding: 0px 5px 0px 3px; font-size: 13px
}
</style>