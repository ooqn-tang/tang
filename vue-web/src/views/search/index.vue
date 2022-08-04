<template>
  <div class="row">
    <div class="col-lg-8 move-p-lr-0">
      <div class="input-group mb-2 move-search">
        <input
          type="text"
          class="form-control search-input"
          v-model="form.wb"
          placeholder="请输入"
          aria-label="请输入"
          aria-describedby="button-addon2"/>
        <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">搜索</button>
        <ul class="dropdown-menu dropdown-menu-end">
          <li><a class="dropdown-item" href="#" @click="form.type = 'video' , so()">视频</a></li>
          <li><a class="dropdown-item" href="#" @click="form.type = 'article' , so()">文章</a></li>
        </ul>
      </div>
      <ul class="list-group mb-2 move-b-lr-0" v-if="form.type == 'video'">
        <li  class="list-group-item move-b-lr-0" v-for="(item, index) in dataList" :key="index">
          <a class="article-title">
            <strong><p @click="openVideo(item.videoId)">{{ item.title }}</p></strong>
          </a>
          <div>
            <span class="date-color" style="font-size: 16px; color: #5f5a5a">2020.02.02</span>
            <a href="#" class=" float-end">{{ item.nickname }}</a>
          </div>
        </li>
      </ul>

      <ul class="list-group mb-2 move-b-lr-0" v-if="form.type == 'article'">
        <li  class="list-group-item" v-for="(item, index) in dataList" :key="index">
          <a class="article-title">
            <strong><p @click="openArticle(item.articleId)">{{ item.title }}</p></strong>
          </a>
          <div>
            <span class="date-color" style="font-size: 16px; color: #5f5a5a">2020.02.02</span>
            <a href="#" class=" float-end">{{ item.nickname }}</a>
          </div>
        </li>
      </ul>
    </div>
    <div class="col-lg-4 move-p-lr-0">
      <div class="list-group mb-2 move-b-lr-0">
        <notice></notice>
      </div>
      <div class="card mb-2 move-b-lr-0">
        <info></info>
      </div>
    </div>
  </div>
</template>

<script>
import request from "utils/request";
export default {
  name: "search_index",
  data() {
    return {
      searchText: "视频",
      form: {
        wb: "",
        type: "video"
      },
      dataList: [],
      videoData: {},
    };
  },
  computed: {},
  created() {},
  methods: {
    so() {
      this.form.page = this.videoData.nextPage;
      request({
        url: "/api/"+this.form.type+"/so",
        method: "GET",
        params: this.form,
      }).then((response) => {
        this.dataList = response.data.list;
      });
    },
    openVideo(videoId) {
      this.$router.push({ name: "video_info", params: { id: videoId } });
    },
    openArticle(dataId) {
      this.$router.push({ name: "article_info", params: { id: dataId } });
    },
  },
  mounted() {
    this.so();
  },
};
</script>