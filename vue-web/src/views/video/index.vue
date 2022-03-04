<template>
  <div class="row">
    <div class="col-md-9">
      <div class="row">
        <div class="col-md-12 mb-2 move-p-lr-0">
          <div class="row">
            <div>
              <div class="card mb-2 move-b-lr-0">
                <div class="card-body p-0">
                  <nav class="nav">
                    <a
                      class="nav-link"
                      :class="selectTag == 'gz' ? 'nav-link-active' : ''"
                      @click="selectTagClick('gz')">关注</a>
                    <a
                      class="nav-link"
                      :class="selectTag == '' ? 'nav-link-active' : ''"
                      @click="selectTagClick('')">最新</a>

                    <a
                      class="nav-link"
                      v-for="(item, index) in videoClassList"
                      @click="selectTagClick(item.value)"
                      :key="index"
                      :class="selectTag == item.value ? 'nav-link-active' : ''">{{ item.name }}</a>
                  </nav>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="col-md-12 mb-2 move-p-lr-0">
          <div class="card move-b-lr-0">
            <div class="card-body" >
              <div class="row">
                <div
                  class="col-md-3 mb-2"
                  v-for="(item, index) in vlist"
                  :key="index"
                  @click="openVideo(item.videoId)"
                >
                  <figure class="figure" style="width:100%" >
                    <img :src="item.coverUrl" style="width:100%">
                    <p class="text-start" style="overflow: hidden;text-overflow:ellipsis;white-space: nowrap;">
                      {{ item.title }}
                    </p>
                    <p><img :src="item.headUrl" style="border-radius: 10px;height: 20px;width: 20px;">&nbsp;&nbsp;{{item.nickname}}&nbsp;&nbsp;{{item.createDate}}</p>
                  </figure>
                </div>
                <div class="d-grid gap-2">
                  <button class="btn btn-outline-secondary" type="button" @click="loadVideoList(videoData.nextPage,selectTag)" v-if="videoData.nextPage > 0">获取更多视频</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="col-md-3 mb-2 move-p-lr-0">
      <div class="list-group mb-2 move-b-lr-0">
        <notice></notice>
      </div>
      <div class="card mb-2 move-b-lr-0">
        <div class="card-body">
          <p>
            <a href="https://ttcxy.net/post/0b0d396713a54e2fbf714478d740e53e" target="_blank">关于</a>
          </p>
          <p>
            <a href="https://ttcxy.net/post/98b255d539f743e193e398bfa9b97cfd" target="_blank">友情链接</a>
          </p>
          <p>
            <a href="http://beian.miit.gov.cn" target="_blank">湘ICP备20009234号</a>
          </p>
          <a href="/map" class="hidden">地图</a>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import request from "src/utils/request";
export default {
  name: "video_index",
  data() {
    return {
      selectTag: "",
      selectType: 1,
      vlist: [],
      videoClassList: [
       
      ],
      videoData: {
        
      },
      articleList: [],
      isLoding: true,
    };
  },
  created() {},
  methods: {
    openVideo(videoId) {
      this.$router.push({ name: "video_info", params: { id: videoId } });
    },
    loadVideoList(page,videoClass) {
      request({
        url: "/api/video",
        method: "get",
        params:{"page":page,"videoClass":videoClass}
      }).then((response) => {
        this.vlist = this.vlist.concat(response.data.list)
        this.videoData = response.data
      });
    },
    loadVideoClassList(){
      request({
        url: "/api/video/class",
        method: "get"
      }).then((response) => {
        this.videoClassList = response.data
      });
    },
    selectTagClick(value){
      this.selectTag = value
      this.vlist = []
      this.videoData.nextPage = 1
      this.loadVideoList(this.videoData.nextPage,this.selectTag)
    }
  },
  mounted() {
    this.loadVideoList();
    this.loadVideoClassList();
  },
};
</script>

<style scoped lang="scss">
strong p,
.card-body p {
  margin: 0px;
}
.red {
  color: red;
}
</style>