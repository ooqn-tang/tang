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
                    <a class="nav-link" :class="selectClassId == 'gz' ? 'nav-link-active' : ''" @click="selectClassClick('gz')">关注</a>
                    <a class="nav-link" :class="selectClassId == '' ? 'nav-link-active' : ''" @click="selectClassClick('')">最新</a>
                    <a class="nav-link" v-for="(item, index) in videoClassList" @click="selectClassClick(item.classId)" :key="index" :class="selectClassId == item.classId ? 'nav-link-active' : ''">{{ item.className }}</a>
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
                >
                  <figure class="figure" style="width:100%" >
                    <img :src="item.coverUrl" style="width:100%"  @click="openVideo(item.videoId)">
                    <p class="text-start" style="overflow: hidden;text-overflow:ellipsis;white-space: nowrap;"  @click="openVideo(item.videoId)">
                      {{ item.title }}
                    </p>
                    <p style="font-size:10px">
                      <!-- <img :src="item.headUrl" style="border-radius: 10px;height: 20px;width: 20px;">&nbsp;&nbsp; -->
                    <router-link  v-if="item.username" :to="{name:'author_video',params:{username: item.username}}">{{item.nickname}}</router-link><span style="float:right">{{item.createDate}}</span></p>
                    
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
         <info></info>
      </div>
    </div>
  </div>
</template>

<script>
import request from "utils/request"
export default {
  name: "video_index",
  data() {
    return {
      zz:false,
      selectClassId: "",
      selectType: 1,
      vlist: [],
      videoTagList: [],
      videoData: {
        
      },
      articleList: [],
      isLoding: true,
    };
  },
  created() {
    
  },
  methods: {
    loadClass(){
      request({
        url: "/api/class",
        method: "get",
        params:{"type":"video"}
      }).then((response) => {
        this.videoClassList = response.data
      });
    },
    openVideo(videoId) {
      this.$router.push({ name: "video_info", params: { id: videoId } });
    },
    loadVideoList(page,classId) {
      request({
        url: "/api/video",
        method: "get",
        params:{"page":page,"classId":classId}
      }).then((response) => {
        this.vlist = this.vlist.concat(response.data.list)
        this.videoData = response.data
      });
    },
    selectClassClick(value){
      this.selectClassId = value
      this.vlist = []
      this.videoData.nextPage = 1
      this.loadVideoList(this.videoData.nextPage,this.selectClassId)
    }
  },
  mounted() {
    this.loadVideoList(1,this.selectClassId);
    this.loadClass()
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