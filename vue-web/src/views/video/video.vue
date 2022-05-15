<template>
  <div class="row">
    <div class="col pb-2">
      <div class="row">
        <div class="col-lg-8 move-p-lr-0">
          <div class="card mb-2 move-b-lr-0">
            <div class="card-header">
              <span>{{ video.title }}</span>
              <span class="float-end">
                <router-link v-if="video.username" :to="{name:'author_article',params:{username: video.username}}" class="float-end">
                  <span>{{video.nickname}}</span>
                </router-link></span>
            </div>
            <div class="card-body" style="padding: 0; height: 600px;" id="videoBody">
              <video style="height: 100%;width:100%;background: black;" ref="videoPlay" controls></video>
            </div>
            <div class="card-footer">
              <div class="row">
                <div class="col" style="line-height: 31px">
                  <div class="badge text-wrap mr-10" :class="type.like?'bg-primary':'bg-secondary'" @click="like()">点赞({{video.dataCount.like}})</div>
                  <div class="badge text-wrap mr-10" :class="type.collect?'bg-primary':'bg-secondary'" @click="collect()">收藏</div>
                  <button type="button" class="btn btn-outline-dark btn-sm float-end" @click="fx">分享</button>
                </div>
              </div>
            </div>
          </div>
          <div class="card mb-2 move-b-lr-0">
            <div class="card-body" >
               <ul class="nav nav-pills mb-2">
                <li class="nav-item">
                  <a class="nav-link" :class="tagName == 'jj' ? 'active' : ''" @click="st('jj')" aria-current="page" href="#">简介</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" :class="tagName == 'pl' ? 'active' : ''" @click="st('pl')" href="#">评论（{{video.dataCount.comment}}）</a>
                </li>
              </ul>
              <div v-if="tagName == 'jj'">
                标题：{{ video.title }}
                <br />
                分类：{{ video.name }}
                <br />
                作者：{{ video.nickname }}
                <br />
                描述：{{ video.describe }}
              </div>
              <ul style="list-style: none; padding: 0px" v-if="tagName == 'pl'">
                <div class="input-group mb-2">
                  <textarea class="form-control" aria-label="With textarea" v-model="text1"></textarea>
                  <span class="input-group-text" @click="comment(text1)">评论</span>
                </div>
                <li
                  style="
                    padding-bottom: 10px;
                    margin-bottom: 10px;
                    border-bottom: 1px solid #c5c5c5;
                  "
                  v-for="(item, index) in pl"
                  :key="index"
                >
                  <strong>{{ item.nickname }}：</strong>{{ item.text }}
                  <span style="color:red" v-if="item.username == loginUsername" @click="deleteComment(item.commentId,index)">删除</span>
                  <br />
                  <span style="color: #939393">{{item}}</span>
                  <span
                    @click="
                      (plinput = index),
                        (commentForm.parentCommentId = item.commentId),commentForm.text = ''
                    "
                    style="color: #939393"
                    >&nbsp;&nbsp;回复</span
                  >
                  <ul style="list-style: none; padding-left: 15px" v-if="item.lower != undefined">
                    <li v-for="(item1, index1) in item.lower" :key="index1">
                      <strong>{{ item1.nickname }}：</strong>{{ item1.text }}
                      <span
                        @click="(plinput = index), (commentForm.parentCommentId = item.commentId), (text2 += '@' + item1.nickname + ' ')"
                        style="color: #939393"
                        >&nbsp;&nbsp;@</span>
                        <span style="color:red" v-if="item1.username == loginUsername" @click="deleteLowerComment(item1.commentId,index1,index)">删除</span>
                    </li>
                  </ul>
                  <span
                    style="color: rgb(45 126 227)"
                    v-if="item.commentCount > 0 && item.lower == undefined"
                    @click="loadLowerComment(item.commentId, index)"
                    >&nbsp;&nbsp;&nbsp;更多评论（{{ item.commentCount }}）</span
                  >
                  <div
                    class="input-group input-group-sm"
                    v-if="index == plinput"
                  >
                    <input
                      type="text"
                      class="form-control"
                      placeholder="评论"
                      aria-label="评论"
                      aria-describedby="button-addon2"
                      v-model="text2"
                    />
                    <button
                      class="btn btn-primary"
                      type="button"
                      @click="comment(text2)"
                    >
                      评论
                    </button>
                  </div>
                </li>
              </ul>
            </div>
          </div>
        </div>
        <div class="col-lg-4 move-p-lr-0">
          <ul class="list-group mb-2 move-b-lr-0">
            <li class="list-group-item active">推荐视频
             
              </li>
            <li v-for="(item,index) in randList" :key="index"  class="list-group-item move-b-lr-0 m-active">
              <img :src="item.coverUrl" style="width:100px;float:left;width:40%"   @click="openVideo(item.videoId)"> 
              <div style="padding-left: 10px;float:left;position:relative;width:50%;height:100%"   @click="openVideo(item.videoId)">
                <span>{{item.nickname}}</span>
                <br>
                {{item.title}}
              </div>
            </li>
          </ul>
          <div class="list-group mb-2 move-b-lr-0">
            <notice></notice>
          </div>
          <div class="card mb-2 move-b-lr-0">
            <info></info>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import "highlight.js/styles/github.css";
import request from "utils/request";
import Dplayer from 'dplayer';
export default {
  name: "video_info",
  data() {
    return {
      loginUsername: this.$store.state.username,
      isLogin:this.$store.state.username != null && this.$store.state.username != '' && this.$store.state.username != undefined,
      videoId: this.$route.params.id,
      randList:[],
      screenWidth: document.documentElement.clientWidth,
      video: {
        dataCount:{}
      },
      text1:'',
      text2:'',
      tagName: "jj",
      plinput: -1,
      pl: [
        { text: "1212", zpl: [{ text: "123123" }] },
        { text: "1212", zpl: [{ text: "123123" }] },
        { text: "1212", zpl: [{ text: "123123" }] },
      ],
      thisIndex: -1,
      commentForm: {},
      type:{
        like:false,
        collect:false,

      }
    };
  },
  components: {},
  watch:{
    'screenWidth':function(val){
      var oIframe = document.getElementById("videoBody");
    },
    '$route':function(to,from){
      this.videoId = to.params.id
    }
  },
  created() {
    this.loadVideo();
  },
  methods: {
    fx(){
      navigator.clipboard.writeText(window.location.href)
      alert("复制分享链接成功")
    },
    openVideo(videoId) {
      location.href = '/video/'+videoId
    },
    st(name) {
      this.tagName = name;
    },
    like(){
      if(this.isLogin)
      if(this.type.like){
        request({
          url: "/api/like/"+this.videoId,
          method: "delete"
        }).then((response) => {
          this.type.like = false;
          this.video.dataCount.like -= 1
        });
      }else{
        request({
          url: "/api/like/"+this.videoId,
          method: "post"
        }).then((response) => {
          this.type.like = true;
          this.video.dataCount.like += 1
        });
      }
    },
    rand(num){
      request({
        url: "/api/video/rand",
        method: "get",
        params:{
          num:num
        }
      }).then((response) => {
        this.randList = this.randList.concat(response.data)
      });
    },
    collect(){
      if(this.isLogin)
      if(this.type.collect){
        request({
          url: "/api/collect/"+this.videoId,
          method: "DELETE",
        }).then((response) => {
          this.type.collect = false
        });
      }else{
        request({
          url: "/api/collect/"+this.videoId,
          method: "POST",
        }).then((response) => {
          this.type.collect = true
        });
      }
    },
    loadCollect(){
      if(this.isLogin)
      request({
        url: "/api/collect/"+this.videoId,
        method: "GET",
      }).then((response) => {
        this.type.collect = (response.data == 1)
      });
    },
    loadLike(){
      if(this.isLogin)
      request({
        url: "/api/like/"+this.videoId,
        method: "get"
      }).then((response) => {
        this.type.like = (response.data == 1)
      });
    },
    deleteComment(commentId,index){
      request({
        url: "/api/comment/"+commentId,
        method: "delete"
      }).then((response) => {
        this.pl.splice(index, 1);
      });
    },
    deleteLowerComment(commentId,index,pIndex){
      request({
        url: "/api/comment/"+commentId,
        method: "delete"
      }).then((response) => {
        this.pl[pIndex].lower.splice(index, 1);
      });
    },
    comment(text) {
      if(!this.isLogin){
        alert("需要登录")
        return        
      }

      this.commentForm.text = text
      this.commentForm.dataId = this.videoId;
      if ("" == this.commentForm.text || undefined == this.commentForm.text) {
        return;
      }
      request({
        url: "/api/comment",
        method: "post",
        data: this.commentForm,
      }).then((response) => {
        if (
          this.commentForm.parentCommentId != undefined &&
          this.commentForm.parentCommentId != ""
        ) {
          this.loadLowerComment(this.commentForm.parentCommentId, this.plinput);
        }else{
          this.loadComment()
        }
        this.commentForm.text = "";
        this.text1 = "";
        this.text2 = "";
      });
    },
    loadComment() {
      request({
        url: "/api/comment/" + this.videoId,
        method: "get",
      }).then((response) => {
        this.pl = response.data.list;
      });
    },
    loadLowerComment(commentId, index) {
      this.pl[index].lower = "";
      request({
        url: "/api/comment/lower/" + commentId,
        method: "get",
      }).then((response) => {
        this.pl[index].lower = response.data.list;
      });
    },
    loadVideo() {
      request({
        url: "/api/video/" + this.videoId,
        method: "get",
      }).then((response) => {
        this.video = response.data;
        this.$refs.videoPlay.src = response.data.videoUrl;
        this.$refs.videoPlay.play();
      });
    },
  },
  mounted() {
    this.rand(10);
    this.loadLike();
    this.loadComment();
    this.loadCollect();
    let _this = this;
    window.onresize = function(){ 
      // 定义窗口大小变更通知事件
      _this.screenWidth = document.documentElement.clientWidth; //窗口宽度
    };
  },
};
</script>

<style lang="scss">

.dplayer-comment-setting-type label span{
  width:50px !important;
}
.dplayer-comment-setting-type{
  display: none;
}
.form-check-input:checked {
    background-color: hsl(320, 100%, 50%);
    border-color: hsl(320, 100%, 50%);
}
.dplayer-notice{
  display: none;
}
</style>