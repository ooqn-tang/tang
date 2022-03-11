<template>
  <div class="row">
    <div class="col-md-9 mb-2  move-p-lr-0">
      <div class="card  move-b-lr-0">
        <div class="card-header">
          <ul class="nav nav-tabs card-header-tabs">
            <li class="nav-item">
              <a
                class="nav-link"
                :class="select == '' ? 'active' : ''"
                aria-current="true"
                href="#"
                @click="selectTag('')"
                >动态历史</a
              >
            </li>
            <!-- <li class="nav-item">
              <a
                class="nav-link"
                :class="select == 'video' ? 'active' : ''"
                aria-current="true"
                href="#"
                @click="selectTag('video')"
                >视频</a
              >
            </li> -->
            <!-- <li class="nav-item">
              <a
                class="nav-link"
                :class="select == 'article' ? 'active' : ''"
                href="#"
                @click="selectTag('article')"
                >文章</a
              >
            </li> -->
          </ul>
        </div>
        <div class="card-body" style="    padding: 0;">
          <ul class="list-group article-list">
            <li class="list-group-item" v-for="(item, index) in historyList" :key="index">
            <div class="row">
              <div class='col' >
                <a class="article-title" :href="'/article/'+item.dataId" v-if="item.type == 'article'">
                  <p>
                    <strong>📰{{item.title}}</strong>
                  </p>
                   <p>
                    <img :src="item.headUrl" style="height: 24px;width:24px;border-radius: 15px;" onerror='this.src="https://avatars.githubusercontent.com/u/15867678?v=4"'>{{item.nickname}}<span style="float:right">{{item.createTime}}</span>
                  </p>
                </a>
                <a class="article-title" :href="'/video/'+item.dataId"  v-if="item.type == 'video'">
                  <p>
                    <strong>📺{{item.title}}</strong>
                  </p>
                  <p>
                    <img :src="item.headUrl" style="height: 24px;width:24px;border-radius: 15px;" onerror='this.src="https://avatars.githubusercontent.com/u/15867678?v=4"'> {{item.nickname}}<span style="float:right">{{item.createTime}}</span>
                  </p>
                </a>
              </div>
            </div>
            </li>
          </ul>
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
            <a
              href="https://ttcxy.net/post/0b0d396713a54e2fbf714478d740e53e"
              target="_blank"
              >关于</a
            >
          </p>
          <p>
            <a
              href="https://ttcxy.net/post/98b255d539f743e193e398bfa9b97cfd"
              target="_blank"
              >友情链接</a
            >
          </p>
          <p>
            <a href="http://beian.miit.gov.cn" target="_blank"
              >湘ICP备20009234号</a
            >
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
  name: "dynamic",
  data() {
    return {
      historyList:[],
      select:""
    };
  },
  methods: {
    selectTag(type){
      this.select = type
      request({
        url: "/api/view/list",
        method: "GET",
        params:{type:type}
      }).then((response) => {
        this.historyList = response.data.list;
      });
    }
  },
  mounted() {
    this.selectTag("");
  },
};
</script>

<style lang="scss">
body {
  overflow-y: scroll;
}
</style>