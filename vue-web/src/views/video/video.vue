<template>
  <div class="row">
    <div class="col pb-2">
      <div class="row">
        <div class="col-lg-8 move-p-lr-0">
          <div class="card mb-2">
            <div class="card-header">
              {{ video.title }}&nbsp;
              <span class="float-end">{{ video.nickname }}</span>
            </div>
            <div class="card-body" style="padding: 0; height: 500px">
              <video ref="videoPlay" controls style="width: 100%; height: 100%">
                <source type="video/mp4" />
              </video>
            </div>
            <div class="card-footer">
              <div class="row">
                <div class="col-md-6" style="line-height: 31px">
                  10W人在观看
                </div>
                <div class="col-md-6">
                  <div class="input-group input-group-sm">
                    <input
                      type="text"
                      class="form-control"
                      placeholder="输入弹幕"
                      aria-label="输入弹幕"
                      aria-describedby="button-addon2"
                    />
                    <button
                      class="btn btn-primary"
                      type="button"
                      id="button-addon2"
                    >
                      发送弹幕
                    </button>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="card mb-2 move-b-lr-0">
            <div class="card-body">
              <span style="font-size: 16px; color: rgb(0 0 0); font-weight: 600"
                >标签：</span
              >
              <i class="bi bi-alarm"></i>
            </div>
          </div>
          <div class="card mb-2 move-b-lr-0">
            <div class="card-body">
              <a class="article-title">八点零点零点附近扩大飞机啊撒旦解放</a>
              <div>
                <span>2020.05.27</span>
                <a class="float-end">匿名</a>
              </div>
            </div>
          </div>
          <div class="card mb-2 move-b-lr-0">
            <div class="card-body">
              <a class="article-title">i俄日额u我i的上空的飞机饿哦五日为ur</a>
              <div>
                <span>2020.05.27</span>
                <a class="float-end">匿名</a>
              </div>
            </div>
          </div>
          <div class="card mb-2 move-b-lr-0">
            <div class="card-body">
              <a class="article-title"
                >啊卡萨丁积分卡的肌肤健康的房间扩大解放</a
              >
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
export default {
  name: "video_info",
  data() {
    return {
      videoId: this.$route.params.id,
      video: {},
    };
  },
  components: {},
  created() {
    this.loadVideo();
  },
  methods: {
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
  mounted() {},
};
</script>

<style scoped lang="scss">
</style>