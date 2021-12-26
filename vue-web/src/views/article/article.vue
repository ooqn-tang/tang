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
            <div class="card-body">
              <p>
                <a href="/post/0b0d396713a54e2fbf714478d740e53e" target="_blank"
                  >关于</a
                >
              </p>
              <p>
                <a href="/post/98b255d539f743e193e398bfa9b97cfd" target="_blank"
                  >友情链接</a
                >
              </p>
              <p>
                <a href="http://beian.miit.gov.cn" target="_blank"
                  >湘ICP备20009234号</a
                >
              </p>
              <p><a href="/map" class="hidden">地图</a></p>
            </div>
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
          :class="like == 1 ? 'btn-outline-danger' : 'btn-outline-primary'"
          class="btn btn-sm mini-but"
          style="margin-left: 0px"
          @click="likeClick"
          >喜欢</a
        >
        <a disabled class="btn btn-outline-primary btn-sm mini-but">举报</a>
        <a
          class="btn btn-outline-primary btn-sm mini-but"
          :href="'https://ttcxy.cn/post/' + param.articleId"
          >阅读模式</a
        >
        <router-link
          class="btn btn-outline-primary btn-sm mini-but"
          v-if="article.username == loginUsername"
          :to="{ name: 'article-editor', params: { id: article.articleId } }"
          >修改</router-link
        >
        <a class="btn btn-outline-primary btn-sm mini-but" href="#top">⬆TOP</a>
      </div>
    </div>
  </nav>
</template>

<script>
import "highlight.js/styles/github.css";
import request from "src/utils/request";
export default {
  name: "article_info",
  data() {
    return {
      fans: 2,
      loginUsername: this.$store.state.username,
      param: {
        articleId: this.$route.params.id,
      },
      loading: true,
      recommendList: null,
      commentList: [],
      article: {},
      commentText: "",
      subject: [],
      articleList: [],
      showSubject: false,
      like: 0,
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
        url: "/api/fans/is",
        method: "get",
        params: {username:this.article.username},
      }).then((response) => {
        if (response.data == 1) {
          this.fans = 1;
        } else {
          this.fans = 2;
        }
      });
    },
    likeClick() {
      if (this.like == 1) {
        request({
          url: "/api/article/like",
          method: "DELETE",
          params: this.param,
        }).then((response) => {
          this.like = 0;
        });
      } else {
        request({
          url: "/api/article/like",
          method: "POST",
          params: this.param,
        }).then((response) => {
          this.like = 1;
        });
      }
    },
    isLike() {
      request({
        url: "/api/article/like",
        method: "GET",
        params: this.param,
      }).then((response) => {
        this.like = response.data;
      });
    },
    sleep(sm) {
      var now = new Date();
      var exitTime = now.getTime() + sm;
      while (true) {
        now = new Date();
        if (now.getTime() > exitTime) {
          return;
        }
      }
    },
    loadArticleInfo() {
      request({
        url: "/api/article/load",
        method: "GET",
        params: this.param,
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
        url: "/api/subject/article",
        method: "GET",
        params: this.param,
      }).then((response) => {
        this.subject = response.data;
        if (this.subject != undefined) {
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
      this.param.articleId = this.$route.params.id;
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