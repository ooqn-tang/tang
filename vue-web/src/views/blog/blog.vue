<template>
  <div class="row">
    <div class="col-md-3 col-lg-3 d-md-inline d-none">
      <div class="list-group mb-2" v-if="showSubject">
        <a class="list-group-item"
          >{{ subject.subjectName }}<span class="float-end">专题</span></a
        >
        <router-link
          @click="blog.blogId = item.blogId"
          :class="item.blogId == blog.blogId ? 'active' : ''"
          v-for="(item, index) in blogList"
          :key="index"
          :to="{ name: 'blog_info', params: {id: item.blogId}}"
          class="list-group-item"
          >{{ item.title }}</router-link
        >
      </div>
      <div class="list-group mb-2">
        <a
          v-for="(item, index) in recommendList"
          class="list-group-item"
          :key="index"
          :href="'/blog/' + item.blogId"
          >{{ item.title }}</a
        >
      </div>
    </div>
    <div class="col-md-9 col-lg-9 pb-5">
      <div class="row">
        <div class="col-lg-8 col-move">
          <div class="card mb-2 blog-body">
            <div class="card-body" v-if="!loading">
              <div>
                <strong>
                  <router-link :to="{ name: 'author_blog', params: { username: blog.username }, }" >{{ blog.nickname }}</router-link>
                </strong>
                .
                <span style="color: rgb(180, 180, 180)">{{blog.createDate}}</span>
                <button
                  v-if="fans == 2"
                  class="btn btn-outline-warning float-end t-b-m-1"
                  @click="fansClick(blog.username)">
                  订阅
                </button>
                <button
                  v-if="fans == 1"
                  class="btn btn-outline-warning float-end t-b-m-1"
                  @click="fansClick(blog.username)">
                  取消订阅
                </button>
              </div>
              <h3>
                <strong>{{ blog.title }}</strong>
              </h3>
              <div class="markdown-body" v-html="blog.text"></div>
            </div>
            <div class="card-body" v-if="loading">
              加载中...
            </div>
          </div>
          <div class="card mb-2">
            <div class="card-body">
              <div>
                <span style="font-size: 16px;color: rgb(0 0 0);font-weight: 600;">标签：</span>
                <span
                  v-for="(item, index) in blog.tagList"
                  :key="index"
                  style="font-size: 16px; color: rgb(220, 53, 69);"
                  >&nbsp;{{ item.tagName }}&nbsp;</span>
                </div>
            </div>
          </div>
          <div class="card mb-2" id="PL" name="PL">
            <div class="card-body">
              <div>没有留言...</div>
            </div>
          </div>
          <div class="card mb-2" >
            <div class="card-body">
              <div class="mb-3">
                <label for="exampleFormControlTextarea1" class="form-label">Example textarea</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
              </div>
              <button type="button" class="btn btn-primary">评论</button>
            </div>
          </div>
          <div class="card mb-2">
            <div class="card-body">
              <a class="blog-title">八点零点零点附近扩大飞机啊撒旦解放</a>
              <div>
                <span>2020.05.27</span>
                <a class="float-end">匿名</a>
              </div>
            </div>
          </div>
          <div class="card mb-2">
            <div class="card-body">
              <a class="blog-title">i俄日额u我i的上空的飞机饿哦五日为ur</a>
              <div>
                <span>2020.05.27</span>
                <a class="float-end">匿名</a>
              </div>
            </div>
          </div>
          <div class="card mb-2">
            <div class="card-body">
              <a class="blog-title">啊卡萨丁积分卡的肌肤健康的房间扩大解放</a>
              <div>
                <span>2020.05.27</span>
                <a class="float-end">匿名</a>
              </div>
            </div>
          </div>
        </div>
        <div class="col-lg-4 col-move">
          <div class="list-group mb-2">
            <a class="list-group-item active">TOP<span class="float-end">🎇</span></a>
            <advertise></advertise>
          </div>
          <div class="card">
            <div class="card-body">
              <p>
                <a href="https://ttcxy.net/post/0b0d396713a54e2fbf714478d740e53e" target="_blank">关于</a>
              </p>
              <p>
                <a
                  href="https://ttcxy.net/post/98b255d539f743e193e398bfa9b97cfd" target="_blank">友情链接</a>
              </p>
              <p>
                <a href="http://beian.miit.gov.cn" target="_blank">湘ICP备20009234号</a>
              </p>
              <a href="/map" class="hidden">地图</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
<nav  class="navbar fixed-bottom navbar-light bg-light" style="border-top: 1px solid rgb(206, 206, 206)">
    <div class="container-fluid">
      <div class="col-md-12 col-lg-12">
        <button
            :class="like == 1 ? 'btn-outline-danger' : 'btn-outline-primary'"
            class="btn"
            style="padding: 0px 5px 0px 3px; font-size: 13px"
            @click="likeClick"
          >
            喜欢
          </button>
          <a
            class="btn btn-outline-primary"
            style="padding: 0px 5px 0px 3px; font-size: 13px; margin-left: 5px"
            href="#PL"
          >
            评论
          </a>
          <button
            disabled
            class="btn btn-outline-primary"
            style="padding: 0px 5px 0px 3px; font-size: 13px; margin-left: 5px"
          >
            分享
          </button>

          <button
            disabled
            class="btn btn-outline-primary"
            style="padding: 0px 5px 0px 3px; font-size: 13px; margin-left: 5px"
          >
            举报
          </button>
      </div>
    </div>
  </nav>
</template>

<script>
import { postBlog, loadRecommend } from "/@/api/blog";
import { selectSubjectBlogList } from "/@/api/subject";
import { like, unlike, isLike } from "/@/api/like";
import { insertFans, deleteFans, isFans } from "/@/api/fans";
export default {
  name: "blog_info",
  data() {
    return {
      fans: 2,
      param: {
        blogId: this.$route.params.id,
      },
      loading:true,
      recommendList: [],
      blog: {
        title: "文章不存在",
        username: "admin",
        nickname: "管理员",
        createDate: "2020.03.27",
        text: "文章不存在",
      },
      subject: [],
      blogList: [],
      showSubject: false,
      like: 0,
    };
  },
  components: {},
  created() {
    this.selectSubjectBlogList();
    this.loadBlogInfo();
  },
  methods: {
    fansClick(username) {
      if (this.fans == 2) {
        insertFans(username).then((response) => {
          this.fans = 1;
        });
      } else {
        deleteFans(username).then((response) => {
          this.fans = 2;
        });
      }
    },
    isFans() {
      isFans(this.blog.username).then((response) => {
        if (response.data == 1) {
          this.fans = 1;
        } else {
          this.fans = 2;
        }
      });
    },
    likeClick() {
      if (this.like == 1) {
        unlike(this.param.blogId).then((response) => {
          this.like = 0;
        });
      } else {
        like(this.param.blogId).then((response) => {
          this.like = 1;
        });
      }
    },
    isLike() {
      isLike(this.param.blogId).then((response) => {
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
    loadBlogInfo() {
      postBlog(this.param).then((response) => {
        this.blog = response.data;
        if(this.$store.state.username != ""){
          this.isFans();
        }
        this.loading = false
      });
    },
    selectSubjectBlogList() {
      selectSubjectBlogList(this.param.blogId).then((response) => {
        this.subject = response.data;
        if (this.subject != undefined) {
          this.blogList = response.data.blogList;
          this.showSubject = true;
        }
      });
    },
    loadRecommend() {
      loadRecommend().then((response) => {
        this.recommendList = response.data;
      });
    },
  },
  mounted() {
    if(this.$store.state.username != ""){
      this.isLike();
    }
    
    this.loadRecommend();
  },
};
</script>

<style scoped lang="scss">
</style>