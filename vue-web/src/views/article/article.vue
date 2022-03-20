<template>
  <div class="row">
    <div class="col-md-3 col-lg-3 d-md-inline d-none">
      <div class="list-group mb-2" v-if="showSubject">
        <a class="list-group-item active"
          >{{ subject.subjectName }}<span class="float-end">专题</span></a
        >
        <router-link
          :class="item.articleId == article.articleId ? 'active2' : ''"
          :key="index"
          :to="{ name: 'article_info', params: { id: item.articleId } }"
          v-for="(item, index) in articleList"
          class="list-group-item"
          >{{ item.title }}</router-link
        >
      </div>

      <div class="card mb-2" v-if="recommendList == null">
        <div class="card-body">
          <div class="spinner-border" role="status">
            <span class="visually-hidden">Loading...</span>
          </div>
        </div>
      </div>

      <div class="list-group mb-2">
        <a class="list-group-item active"
          >推荐<span class="float-end">🎇</span></a
        >
        <a
          v-for="(item, index) in recommendList"
          class="list-group-item"
          :key="index"
          :href="'/article/' + item.articleId"
          >{{ item.title }}</a
        >
      </div>
    </div>
    <div class="col-md-9 col-lg-9 pb-5">
      <div class="row">
        <div class="col-lg-8 move-p-lr-0">
          <div class="card mb-2 article-body">
            <div class="card-body" v-if="!loading">
              <div>
                <strong>
                  <router-link
                    :to="{
                      name: 'author_article',
                      params: { username: article.username },
                    }"
                    >{{ article.nickname }}</router-link
                  >
                </strong>
                .
                <span style="color: rgb(180, 180, 180)">{{
                  article.createDate
                }}</span>
                <button
                  v-if="fans == 2"
                  class="btn btn-outline-warning float-end t-b-m-1"
                  @click="fansClick(article.username)"
                >
                  订阅
                </button>
                <button
                  v-if="fans == 1"
                  class="btn btn-outline-warning float-end t-b-m-1"
                  @click="fansClick(article.username)"
                >
                  取消订阅
                </button>
              </div>
              <h3>
                <strong>{{ article.title }}</strong>
              </h3>
              <div class="markdown-body" v-html="article.text"></div>
            </div>
            <div class="card-body" v-if="loading">加载中...</div>
          </div>
          <div class="card mb-2 move-b-lr-0">
            <div class="card-body">
              <span style="font-size: 16px; color: rgb(0 0 0); font-weight: 600"
                >标签：</span
              >
              <span
                v-for="(item, index) in article.tagList"
                :key="index"
                style="font-size: 16px; color: rgb(220, 53, 69)"
                >&nbsp;{{ item.tagName }}&nbsp;</span
              >
            </div>
          </div>
          <div class="card mb-2 move-b-lr-0">
            <div class="card-body">
              <a class="article-title">八点零点零点附近扩大飞机啊撒旦解放</a>
              <div>
                <span>2020.05.27</span>
                <a class="float-end">匿名</a>
              </div>
            </div>
          </div>
          <div class="card mb-2 move-b-lr-0">
            <div class="card-body">
              <a class="article-title">i俄日额u我i的上空的飞机饿哦五日为ur</a>
              <div>
                <span>2020.05.27</span>
                <a class="float-end">匿名</a>
              </div>
            </div>
          </div>
          <div class="card mb-2 move-b-lr-0">
            <div class="card-body">
              <a class="article-title">啊卡萨丁积分卡的肌肤健康的房间扩大解放</a>
              <div>
                <span>2020.05.27</span>
                <a class="float-end">匿名</a>
              </div>
            </div>
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
  <nav
    class="navbar fixed-bottom navbar-light bg-light"
    style="border-top: 1px solid rgb(206, 206, 206)"
  >
    <div class="container-fluid">
      <div class="col-md-12 col-lg-12">
        <a
          :class="collect == 1 ? 'btn-outline-danger' : 'btn-outline-primary'"
          class="btn btn-sm mini-but"
          style="margin-left: 0px"
          @click="collectClick"
          >收藏</a
        >
        <a disabled class="btn btn-outline-primary btn-sm mini-but">举报</a>
        <a
          class="btn btn-outline-primary btn-sm mini-but"
          :href="'https://ttcxy.cn/post/' + articleId"
          >阅读模式</a
        >
        <router-link
          class="btn btn-outline-primary btn-sm mini-but"
          v-if="article.username == loginUsername"
          :to="{ name: 'article-editor', params: { id: articleId } }"
          >修改</router-link
        >
        <a class="btn btn-outline-primary btn-sm mini-but" onclick="document.body.scrollTop = document.documentElement.scrollTop = 0">⬆TOP</a>
      </div>
    </div>
  </nav>
</template>

<script>
import "highlight.js/styles/github.css";
import request from "utils/request";
export default {
  name: "article_info",
  data() {
    return {
      fans: 2,
      loginUsername: this.$store.state.username,
      articleId: this.$route.params.id,
      loading: true,
      recommendList: null,
      commentList: [],
      article: {},
      commentText: "",
      subject: [],
      articleList: [],
      showSubject: false,
      collect: 0,
    };
  },
  components: {},
  methods: {
    fansClick(username) {
      if (this.fans == 2) {
        request({
          url: "/api/fans/" + username,
          method: "POST",
        }).then((response) => {
          this.fans = 1;
        });
      } else {
        request({
          url: "/api/fans/" + username,
          method: "DELETE",
        }).then((response) => {
          this.fans = 2;
        });
      }
    },
    isFans() {
      request({
        url: "/api/fans/username/" + this.article.username,
        method: "get",
      }).then((response) => {
        if (response.data == 1) {
          this.fans = 1;
        } else {
          this.fans = 2;
        }
      });
    },
    collectClick() {
      if (this.collect == 1) {
        request({
          url: "/api/collect/"+this.articleId,
          method: "DELETE",
        }).then((response) => {
          this.collect = 0;
        });
      } else {
        request({
          url: "/api/collect/"+this.articleId,
          method: "POST",
        }).then((response) => {
          this.collect = 1;
        });
      }
    },
    isLike() {
      request({
        url: "/api/collect/"+this.articleId,
        method: "GET",
      }).then((response) => {
        this.collect = response.data;
      });
    },
    loadArticleInfo() {
      request({
        url: "/api/article/load/"+this.articleId,
        method: "GET",
      }).then((response) => {
        this.article = response.data;
        if (this.$store.state.username != "") {
          this.isFans();
        }
        this.loading = false;
      });
    },
    selectSubjectArticleList() {
      request({
        url: "/api/subject/article/"+this.articleId,
        method: "GET",
      }).then((response) => {
        this.subject = response.data;
        if (this.subject != "") {
          this.articleList = response.data.articleList;
          this.showSubject = true;
        }
      });
    },
    loadRecommend() {
      request({
        url: "/api/article/recommend",
        method: "GET",
      }).then((response) => {
        this.recommendList = response.data;
      });
    },
    load() {
      this.articleId = this.$route.params.id;
      if (this.$store.state.username != "") {
        this.isLike();
      }
      this.selectSubjectArticleList();
      this.loadArticleInfo();
    },
  },
  mounted() {
    this.load();
    this.loadRecommend();
  },
  watch: {
    $route: "load",
  },
};
</script>

<style scoped lang="scss">
</style>