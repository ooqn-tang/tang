<template>
  <ul class="list-group article-list">
    <li class="list-group-item" v-for="(item, index) in vlist" :key="index">
      <div class="row">
        <div class="col-md-3">
          <img
            :src="item.coverUrl"
            class="figure-img img-fluid rounded"
            style="width: 100%"
            alt="..."
            @click="openVideo(item.videoId)"
          />
        </div>
        <div class="col-md-9" style="position:relative;min-height: 80px;">
          <a @click="openVideo(item.videoId)" class="article-title">
            <strong><p v-text="item.title"></p></strong>
          </a>
          <div class="article-synopsis">{{ item.title }}</div>

          <span
            style="
              background: #efefef;
              padding: 0px 5px;
              border-radius: 10px;
              color: #7d7d7d;position:absolute;bottom:0;left:0;margin-left:12px
            "
            >{{ item.createDate }}</span
          >

          <div class="btn-group float-end" style="position:absolute;bottom:0;right:0;margin-right:12px">
            <button
              class="btn btn-outline-danger float-end"
              style="padding: 0px 5px 0px 3px; font-size: 13px;border-right: 0;"
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
    <li class="list-group-item">
      <a>获取</a>
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
    };
  },
  methods: {
    loadArticleByUsername() {
      request({
        url: "/api/video/username/" + this.$route.params.username,
        method: "get",
      }).then((response) => {
        if (response.data.list != undefined) {
          this.articlePage = response.data;
          this.vlist = this.vlist.concat(response.data.list);
        }
      });
    },
    openVideo(videoId) {
      this.$router.push({ name: "video_info", params: { id: videoId } });
    },
  },
  mounted() {
    this.loadArticleByUsername(this.articlePage.nextPage);
  },
};
</script>

<style lang="scss">
body {
  overflow-y: scroll;
}
</style>