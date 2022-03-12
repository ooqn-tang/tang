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
        <ranking></ranking>
      </div>
      <div class="list-group mb-2 move-b-lr-0">
        <notice></notice>
      </div>
      <div class="card mb-2 move-b-lr-0">
        <div class="card-header" @click="zz = true">
        赞助
        </div>
        <div class="card-body" v-if="zz">
          <img src="/kittens.jpg" style="width:100%">
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
      zz:false,
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