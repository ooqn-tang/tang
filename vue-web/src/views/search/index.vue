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
        <button
          class="btn btn-outline-secondary search-button"
          type="button"
          id="button-addon2"
          @click="so">
          搜索
        </button>
      </div>
      <ul class="list-group mb-2 move-b-lr-0">
        <li class="list-group-item" v-for="(item, index) in videoList" :key="index">
          <a class="article-title">
            <strong><p @click="openVideo(item.videoId)">{{ item.title }}</p></strong>
          </a>
          <div>
            <span class="date-color" style="font-size: 16px; color: #5f5a5a">2020.02.02</span>
            <span> . <span style="font-size: 16px; color: #dc3545">Java</span></span>
            <a class="float-end">{{ item.nickname }}</a>
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
      },
      videoList: [],
      videoData: {},
    };
  },
  computed: {},
  created() {},
  methods: {
    so() {
      this.form.page = this.videoData.nextPage;
      request({
        url: "/api/video/so",
        method: "GET",
        params: this.form,
      }).then((response) => {
        this.videoList = response.data.list;
      });
    },
    openVideo(videoId) {
      this.$router.push({ name: "video_info", params: { id: videoId } });
    },
  },
  mounted() {
    this.so();
  },
};
</script>