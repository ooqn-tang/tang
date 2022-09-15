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
        <button class="btn btn-outline-secondary" type="button" @click="dataList = [] , so()">搜索</button>
      </div>
      <ul class="list-group mb-2 move-b-lr-0">
        <li  class="list-group-item" v-for="(item, index) in dataList" :key="index">
          <a class="article-title">
            <strong><p @click="openArticle(item.articleId)">{{ item.title }}</p></strong>
          </a>
          <div>
            <span class="date-color" style="font-size: 16px; color: #5f5a5a">2020.02.02</span>
            <a href="#" class=" float-end">{{ item.nickname }}</a>
          </div>
        </li>
        <li class="list-group-item" v-if="videoData.nextPage!=0">
          <a @click="next()" v-if="!isLoding">获取{{}}</a><a v-if="isLoding">加载中...</a>
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
        wb: ""
      },
      isLoding:true,
      dataList: [],
      videoData: {},
    };
  },
  computed: {},
  created() {},
  methods: {
    so() {
      this.isLoding = true;
      request({
        url: "/api/article/so",
        method: "GET",
        params: this.form,
      }).then((response) => {
        this.videoData = response.data;
        this.dataList = this.dataList.concat(response.data.list)
        this.isLoding = false;
      });
    },
    next(){
      this.form.page = this.videoData.nextPage;
      this.so();
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