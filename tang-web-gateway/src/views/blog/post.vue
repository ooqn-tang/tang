<template>
  <div class="row" style="margin-bottom: 50px">
    <div class="col-md-3 col-lg-2" >
      <div class="list-group margin-bottom10" v-if="showSubject">
        <a class="list-group-item">{{subject.subjectName}}<span class="float-end">🎇</span></a>
        <router-link @click="blog.blogId = item.blogId" :class="item.blogId == blog.blogId?'active':''" v-for="(item,index) in blogList" :key="index"  :to="{name: 'post', params: { id: item.blogId }}" 
          class="list-group-item"
          >{{item.title}}</router-link>
      </div>

      <div class="list-group margin-bottom10">
        <a class="list-group-item ">推荐<span class="float-end">🎇</span></a>
        <a class="list-group-item ">推荐<span class="float-end">🎇</span></a>
        <a class="list-group-item ">推荐<span class="float-end">🎇</span></a>
        <a class="list-group-item ">推荐<span class="float-end">🎇</span></a>
        <a class="list-group-item ">推荐<span class="float-end">🎇</span></a>
      </div>
    </div>
    <div class="col-md-9 col-lg-10">
      <div class="row">
        <div class="col-lg-8">
          <div class="card margin-bottom10">
            <div id="blog-body" class="card-body" style="overflow-y: hidden">
              <div>
                <strong>
                  <router-link to="">{{ blog.nickname }}</router-link>
                </strong>
                .
                <span style="color: rgb(180, 180, 180)">{{
                  blog.createDate
                }}</span>
                <button v-if="fans == 2"
                  class="btn btn-outline-warning float-end"
                  style="padding: 0px 5px 0px 3px; font-size: 13px"
                   @click="fansClick(blog.username)"
                >
                  订阅
                </button>
                <button v-if="fans == 1"
                  class="btn btn-outline-warning float-end"
                  style="padding: 0px 5px 0px 3px; font-size: 13px"
                  @click="fansClick(blog.username)"
                >
                  取消订阅
                </button>
              </div>
              <h3>
                <strong>{{ blog.title }}</strong>
              </h3>
              <hr />
              <div class="markdown-body" v-html="blog.text"></div>
            </div>
            <div class="card-footer">
              <button
                :class="like == 1?'btn-outline-danger':'btn-outline-primary'"
                class="btn"
                style="padding: 0px 5px 0px 3px; font-size: 13px"
                @click="likeClick"
              >
                喜欢
              </button>
              <button disabled
                class="btn btn-outline-primary"
                style="
                  padding: 0px 5px 0px 3px;
                  font-size: 13px;
                  margin-left: 5px;
                "
              >
                分享
              </button>
              <button disabled
                class="btn btn-outline-primary"
                style="
                  padding: 0px 5px 0px 3px;
                  font-size: 13px;
                  margin-left: 5px;
                "
              >
                举报
              </button>
              <div class="float-end">
                <span v-for="(item, index) in blog.tagList" :key="index">
                  .
                  <span style="font-size: 10px; color: #a2a2a2">{{
                    item.tagName
                  }}</span></span
                >
              </div>
            </div>
          </div>
          <div class="card margin-bottom10">
            <div class="card-body">
              <div>没有留言...</div>
            </div>
          </div>
          <div class="card margin-bottom10">
            <div class="card-body">
              <a
                href="/post/f0a33f80ede44b45b98ce9f5f0b0bc90"
                class="blog-title"
                >博客园的打赏功能、打赏插件</a
              >
              <div>
                <span>2020.05.27</span>
                <a href="/author/nimin" class="pull-right">匿名</a>
              </div>
            </div>
          </div>
        </div>
        <div class="col-lg-4">
            <div class="list-group margin-bottom10">
              <a class="list-group-item active"
                >广播<span class="pull-right">🎇</span></a
              >
              <a
                target="_blank"
                href="http://www.ttcxy.net/post/098384e9a34d438480289ad23c8625ba"
                class="list-group-item"
                >公众号推荐列表</a
              >
              <a
                target="_blank"
                href="http://www.ttcxy.net/post/98d9f0454fe34b9589e36cdcfc45e02f"
                class="list-group-item"
                >好用的教程</a
              >
              <a
                target="_blank"
                href="http://www.ttcxy.net/post/461196615cb14caaad4cbb58e82c58e6"
                class="list-group-item"
                >可能是目前为止最好的QQ群列表
              </a>
            </div>
            <div class="card">
              <div class="card-body">
                <p>
                  <a
                    href="https://ttcxy.net/post/0b0d396713a54e2fbf714478d740e53e"
                    target="_blank"
                    >关于</a
                  >
                </p>
                <p>
                  <a
                    href="https://ttcxy.net/post/98b255d539f743e193e398bfa9b97cfd"
                    target="_blank"
                    >友情链接</a
                  >
                </p>
                <p>
                  <a href="http://beian.miit.gov.cn" target="_blank"
                    >湘ICP备20009234号</a
                  >
                </p>
                <a href="/map" class="hidden">地图</a>
              </div>
            </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { postBlog } from "/@/api/blog"
import { selectSubjectBlogList } from "/@/api/subject"
import { like,unlike,isLike } from "/@/api/like"
import {insertFans,deleteFans,isFans} from "/@/api/fans"

export default {
  name: "post",
  data() {
    return {
      fans:1,
      param: {
        blogId: this.$route.params.id,
      },
      blog: {
        title: "文章不存在",
        username: "admin",
        nickname: "管理员",
        createDate: "2020.03.27",
        text: "文章不存在",
      },
      subject:[],
      blogList:[],
      showSubject:false,
      like:0
    };
  },
  components: {},
  methods: {
    fansClick(username){
      if(this.fans == 2){
        insertFans(username).then((response) => {
          this.fans = 1
        })
      }else{
        deleteFans(username).then((response) => {
          this.fans = 2
        })
      }
      
    },
    isFans(){
      isFans(this.blog.username).then((response) => {
        if(response.data == 1){
          this.fans = 1
        }else{
          this.fans = 2
        }
      })
    },
    likeClick(){
       if(this.like == 1){
          unlike(this.param.blogId).then((response) => {
            this.like = 0
          })
       }else{
          like(this.param.blogId).then((response) => {
            this.like = 1
          })
       }
      
    },
    isLike(){
      isLike(this.param.blogId).then((response) => {
        this.like = response.data
      })
    },
    loadBlogInfo() {
      postBlog(this.param).then((response) => {
        this.blog = response.data;
        this.isFans()
      });
    },
    selectSubjectBlogList(){
      selectSubjectBlogList(this.param.blogId).then((response) => {
        this.subject = response.data
        if(this.subject != undefined){
          this.blogList = response.data.blogList
          this.showSubject = true
        }
      })
    }
  },
  mounted() {
    this.loadBlogInfo();
    this.selectSubjectBlogList()
    this.isLike()
  },
};
</script>

<style scoped lang="scss">
.red {
  color: red;
}

body {
  overflow-y: scroll;
}
</style>