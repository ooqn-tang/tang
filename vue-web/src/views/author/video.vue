<template>
  <ul class="list-group article-list">
    <li class="list-group-item" v-for="(item, index) in vlist" :key="index">
      <div class="row">
        <div class="col-md-3">
          <img
            :src="item.coverUrl"
            class="figure-img img-fluid rounded"
            style="width:100%"
            @click="openVideo(item.videoId)"
          />
        </div>
        <div class="col-md-9">
          <a @click="openVideo(item.videoId)" class="article-title">
            <strong><p v-text="item.title"></p></strong>
          </a>
          <span style="padding: 0 5px;background: #e5e5e5;border-radius: 10px;">{{ item.createDate}}</span>&nbsp;&nbsp;
          <span style="padding: 0 5px;background: #e5e5e5;border-radius: 10px;">播放量:{{item.viewCount}}</span>&nbsp;&nbsp;

          <div class="btn-group float-end">
            <button
              class="btn btn-outline-danger float-end"
              style="padding: 0px 5px 0px 3px; font-size: 13px;border-right: 0;"
              @click="deleteVideo(item.videoId,index)"
            >
              删除
            </button>
            <button
              class="btn btn-outline-danger float-end"
              style="padding: 0px 5px 0px 3px; font-size: 13px"
              target="_blank"
              @click="$router.push({ name: 'video_contribute', params: { id: item.videoId } })"
            >
              修改
            </button>
          </div>
        </div>
      </div>
    </li>
    <li class="list-group-item" v-if="articlePage.nextPage != 0">
      <a @click="nextPage()">{{huoqu}}</a>
    </li>
  </ul>
</template>

<script>
import request from "src/utils/request";
export default {
  name: "author_video",
  data() {
    return {
      thisUsername: this.$route.params.username,
      isThisUser: this.$route.params.username == this.$store.state.username,
      thisItem: {},
      vlist: [],
      articlePage: {
        nextPage: 1,
      },
      subjectFrom: {
        subjectId: "",
      },
      subjectList: [],
      huoqu:"获取中..."
    };
  },
  methods: {
     nextPage(){
       this.articlePage.nextPage += 1
      this.loadArticleByUsername(this.articlePage.nextPage);
    },
    loadArticleByUsername() {
      this.huoqu = '获取中...'
      request({
        url: "/api/video/username/" + this.$route.params.username,
        method: "get",
        params:{page:this.articlePage.nextPage}
      }).then((response) => {
        if (response.data.list != undefined) {
           this.vlist = this.vlist.concat(response.data.list)
           this.articlePage = response.data
        }
        this.huoqu = '获取'
      });
    },
    openVideo(videoId) {
      this.$router.push({ name: "video_info", params: { id: videoId } });
    },
    deleteVideo(videoId,index){
      if(confirm("确认删除？")){
        request({
          url: "/api/video/" + videoId,
          method: "delete",
        }).then((response) => {
          this.vlist.splice(index,1)
        });
      }
    }
  },
  mounted() {
    this.loadArticleByUsername();
  },
};
</script>

<style lang="scss">
body {
  overflow-y: scroll;
}
</style>