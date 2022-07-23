<template>
  <div class="row">
    <div class="col-md-9 mb-2 move-p-lr-0">
      <ul class="nav nav-tabs">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">动态</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">视频</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">文章</a>
        </li>
      </ul>
      <div class="card move-b-lr-0" style="border-top: 0;border-radius: 0px;">
        <div class="card-body" style="padding:0px">
          <ul class="list-group article-list">
            <li
              class="list-group-item"
              v-for="(item, index) in dynamicList"
              :key="index"
            >
              <div class="row">
                <div class="col">
                  <p>
                    <a target="_blank" :href="'/author/'+item.username">{{ item.nickname }}{{item.title}}</a><span class="float-end">{{item.createTime}}</span>
                  </p>
                  {{item.text}}  <a target="_blank" v-if="item.url != null" :href="item.url">网页链接</a>
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
        <info></info>
      </div>
    </div>
  </div>
</template>

<script>
import request from "utils/request";
export default {
  name: "message",
  data() {
    return {
      authorList: [],
      select: "",
      vList: [{}, {}, {}, {}, {}],
      dynamicList: [],
    };
  },
  methods: {
    selectTag(type) {
      this.select = type;
      request({
        url: "/api/message",
        method: "GET",
        params: { type: type },
      }).then((response) => {
        this.dynamicList = response.data;
      });
    },
    authorListArticleCount() {
      request({
        url: "/api/author/authorListArticleCount",
        method: "GET",
      }).then((response) => {
        this.authorList = response.data.list;
      });
    },
    loadDynamic() {
      request({
        url: "/api/dynamic",
        params:{"type":this.select},
        method: "GET",
      }).then((response) => {
        this.dynamicList = response.data;
      });
    },
  },
  mounted() {
    this.loadDynamic();
  },
};
</script>

<style lang="scss">
body {
  overflow-y: scroll;
}
</style>