<template>
  <div class="row">
    <div class="col-md-9 mb-2 move-p-lr-0">
      <div class="card move-b-lr-0">
        <div class="card-header">
          <ul class="nav nav-tabs card-header-tabs float-start">
            <li class="nav-item">
              <a
                class="nav-link"
                :class="select == '' ? 'active' : ''"
                aria-current="true"
                href="#"
                @click="selectTag('')"
                >动态</a
              >
              
            </li>
          </ul>
        </div>
        <div class="card-body" style="padding: 0">
          <ul class="list-group article-list">
            <li
              class="list-group-item"
              v-for="(item, index) in dynamicList"
              :key="index"
            >
              <div class="row">
                <div class="col">
                    <strong><a v-text="item.nickname"></a> : </strong><a v-text="item.message"></a>
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
        url: "/api/message",
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