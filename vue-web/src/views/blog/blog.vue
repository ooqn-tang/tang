<template>
  <div class="row">
    <div class="col-md-3 col-lg-3 d-md-inline d-none">
      <div class="list-group mb-2" v-if="showSubject">
        <a class="list-group-item active">{{ subject.subjectName }}<span class="float-end">专题</span></a>
        <router-link
          @click="blog.blogId = item.blogId"
          :class="item.blogId == blog.blogId ? 'active2' : ''"
          v-for="(item, index) in blogList"
          :key="index"
          :to="{ name: 'blog_info', params: {id: item.blogId}}"
          class="list-group-item"
          >{{ item.title }}</router-link>
      </div>

      <div class="card mb-2" v-if="recommendList==null">
        <div class="card-body"> 
          <div class="spinner-border" role="status">
            <span class="visually-hidden">Loading...</span>
          </div>
        </div>
      </div>

      <div class="list-group mb-2">
        <a class="list-group-item active">推荐<span class="float-end">🎇</span></a>
        <a v-for="(item, index) in recommendList" class="list-group-item" :key="index" :href="'/blog/' + item.blogId">{{ item.title }}</a>
      </div>
    </div>
    <div class="col-md-9 col-lg-9 pb-5">
      <div class="row">
        <div class="col-lg-8 move-p-lr-0">
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
          <div class="card mb-2 move-b-lr-0">
            <div class="card-body">
                <span style="font-size: 16px;color: rgb(0 0 0);font-weight: 600;">标签：</span>
                <span v-for="(item, index) in blog.tagList" :key="index" style="font-size: 16px; color: rgb(220, 53, 69);">&nbsp;{{ item.tagName }}&nbsp;</span>
            </div>
          </div>
          <div class="card mb-2 move-b-lr-0" id="PL">
            <div class="card-body">
              <span v-if="commentList.length == 0">没有评论</span>
              <div class="comment-list" v-for="(item,index) in commentList" :key="index">
                <p>
                  <strong>
                    <router-link :to="{ name: 'author_blog', params: { username: item.username }, }" >{{ item.nickname }}</router-link>
                  </strong>
                  <span class="float-end">{{item.createDate}}</span>
                </p>
                {{item.content}}<span v-if="item.username == loginUsername" style="color:red;float: right;">删除</span>
              </div> 
            </div>
          </div>
          <div class="card mb-2 move-b-lr-0" >
            <div class="card-body">
              <div class="mb-3">
                <label for="exampleFormControlTextarea1" class="form-label" id="PL_TEXT">Example textarea</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" v-model="commentText"></textarea>
              </div>
              <button type="button" class="btn btn-primary" @click="comment()">评论</button>
            </div>
          </div>
          <div class="card mb-2 move-b-lr-0">
            <div class="card-body">
              <a class="blog-title">八点零点零点附近扩大飞机啊撒旦解放</a>
              <div>
                <span>2020.05.27</span>
                <a class="float-end">匿名</a>
              </div>
            </div>
          </div>
          <div class="card mb-2 move-b-lr-0">
            <div class="card-body">
              <a class="blog-title">i俄日额u我i的上空的飞机饿哦五日为ur</a>
              <div>
                <span>2020.05.27</span>
                <a class="float-end">匿名</a>
              </div>
            </div>
          </div>
          <div class="card mb-2 move-b-lr-0">
            <div class="card-body">
              <a class="blog-title">啊卡萨丁积分卡的肌肤健康的房间扩大解放</a>
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
              <p><a href="/post/0b0d396713a54e2fbf714478d740e53e" target="_blank">关于</a></p>
              <p><a href="/post/98b255d539f743e193e398bfa9b97cfd" target="_blank">友情链接</a></p>
              <p><a href="http://beian.miit.gov.cn" target="_blank">湘ICP备20009234号</a></p>
              <p><a href="/map" class="hidden">地图</a></p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <nav  class="navbar fixed-bottom navbar-light bg-light" style="border-top: 1px solid rgb(206, 206, 206)">
    <div class="container-fluid">
      <div class="col-md-12 col-lg-12">
        <a :class="like == 1 ? 'btn-outline-danger' : 'btn-outline-primary'" class="btn btn-sm mini-but" style="margin-left:0px" @click="likeClick">喜欢</a>
        <a class="btn btn-outline-primary btn-sm mini-but" href="#PL">评论</a>
        <a disabled class="btn btn-outline-primary btn-sm mini-but" >举报</a>
        <a class="btn btn-outline-primary btn-sm mini-but" :href="'/post/' + param.blogId">阅读模式</a>
        <a class="btn btn-outline-primary btn-sm mini-but" href="#top">⬆TOP</a>
      </div>
    </div>
  </nav>
</template>

<script>
import { postBlog, loadRecommend } from "/@/api/blog";
import { selectSubjectBlogList } from "/@/api/subject";
import { like, unlike, isLike } from "/@/api/like";
import { insertFans, deleteFans, isFans } from "/@/api/fans";
import { selectComment, deleteComment, insertComment } from "/@/api/comment";
import 'highlight.js/styles/github.css'
export default {
  name: "blog_info",
  data() {
    return {
      fans: 2,
      loginUsername:this.$store.state.username,
      param: {
        blogId: this.$route.params.id,
      },
      loading:true,
      recommendList: null,
      commentList:[],
      blog: {
        title: "文章不存在",
        username: "admin",
        nickname: "管理员",
        createDate: "2020.03.27",
        text: "文章不存在",
      },
      commentText:"",
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
    comment(){
      var a = {
        dataId:this.param.blogId,
        content:this.commentText
      }
      insertComment(a).then((response) => {
        this.commentList.push(response.data)
      })
    },
    loadComment(){
      selectComment(this.param.blogId,1).then((response) => {
          this.commentList = response.data.list
      })
    },
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
    this.loadComment()
  },
};
</script>

<style scoped lang="scss">
</style>