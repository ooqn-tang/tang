<template>
  <div class="row">
    <div class="col pb-2">
      <div class="row">
        <div class="col-lg-8 move-p-lr-0">
          <div class="card mb-2 move-b-lr-0">
            <div class="card-header">
              {{ video.title }}
              <span class="float-end"><router-link v-if="video.username" :to="{name:'author_article',params:{username: video.username}}" class="float-end">{{video.nickname}}<span style="color: red;padding-left: 5px;font-weight: 800;">L{{video.grade}}</span></router-link></span>
            </div>
            <div class="card-body" style="padding: 0; height: 600px;" id="videoBody">
              <!-- <video
                ref="videoPlay"
                controls
                loop="loop"
                style="width: 100%; height: 100%;">
                <source type="video/mp4" />
              </video> -->
              <div ref="videoRef" style="    height: 100%;" />
            </div>
            <div class="card-footer">
              <div class="row">
                <div class="col" style="line-height: 31px">
                  <div class="badge bg-primary text-wrap mr-10" style="margin-right: 10px;">播放量：{{video.dataCount.view}}</div>
                  <div class="badge text-wrap mr-10" :class="type.like?'bg-primary':'bg-secondary'" @click="like()">点赞({{video.dataCount.like}})</div>
                  <div class="badge text-wrap mr-10" :class="type.coin?'bg-primary':'bg-secondary'" @click="coin()">投币({{video.dataCount.coin}})</div>
                  <div class="badge text-wrap mr-10" :class="type.collect?'bg-primary':'bg-secondary'" @click="collect()">收藏</div>
                </div>
              </div>
            </div>
          </div>
         
          <div
            class="card mb-2 move-b-lr-0"
            style=""
          >
            <div class="card-body" >
               <ul class="nav nav-pills mb-2">
                <li class="nav-item">
                  <a
                    class="nav-link"
                    :class="tagName == 'jj' ? 'active' : ''"
                    @click="st('jj')"
                    aria-current="page"
                    href="#"
                    >简介</a
                  >
                </li>
                <li class="nav-item">
                  <a
                    class="nav-link"
                    :class="tagName == 'pl' ? 'active' : ''"
                    @click="st('pl')"
                    href="#"
                    >评论（{{video.dataCount.comment}}）</a
                  >
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
                  <span style="color: #939393">2020.10.10</span>
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
            <ranking></ranking>
          </div>
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
</template>

<script>
import "highlight.js/styles/github.css";
import request from "src/utils/request";
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
        coin:false,
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
    openVideo(videoId) {
      location.href = '/video/'+videoId
    },
    st(name) {
      this.tagName = name;
    },
    coin(){
      if(this.isLogin)
      request({
        url: "/api/coin/"+this.videoId,
        method: "post"
      }).then((response) => {
        this.video.dataCount.coin += 1
        this.type.coin = true;
      }).catch(e => {
        console.log(e.message)
      });
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
    loadCoin(){
      if(this.isLogin)
      request({
        url: "/api/coin/"+this.videoId,
        method: "get"
      }).then((response) => {
        this.type.coin = (response.data == 1)
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
        //this.$refs.videoPlay.src = response.data.videoUrl;
        //this.$refs.videoPlay.play();
        let dp = new Dplayer({          //初始化视频对象
          container:this.$refs.videoRef,   //指定视频容器节点
          autoplay:true,
          danmaku: {
            id: this.videoId,//必填，视频id, 用于下面api请求时使用
            api: import.meta.env.VITE_BASE_API + 'api/danmaku/',//必填，叫后台提供
           //可选，额外的弹幕,这里是引用了B站具体视频中的弹幕，把aid,cid替换就行
            token:localStorage.getItem("jwt"),
            bottom: '15%',
            unlimited: true,
          },
          video:{
            url:response.data.videoUrl
          }
        })

        let _this = this;

        dp.on('ended',function(){
          _this.$router.push("/video/"+_this.randList[0]['videoId'])
          _this.randList.splice(0,1)
          _this.loadVideo()
          _this.rand(1)
        })
      });
    },
  },
  mounted() {
    this.rand(10);
    this.loadLike();
    this.loadComment();
    this.loadCollect();
    this.loadCoin();
    let _this = this;
    window.onresize = function(){ // 定义窗口大小变更通知事件
      _this.screenWidth = document.documentElement.clientWidth; //窗口宽度
    };
  },
};
</script>

<style lang="scss">
.mr-10{
  margin-right: 10px;
}
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