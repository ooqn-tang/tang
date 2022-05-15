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
          <button type="button" class="btn btn-outline-secondary float-end  btn-sm">清空</button>
        </div>
        <div class="card-body" style="padding: 0">
          <ul class="list-group article-list">
            <li
              class="list-group-item"
              v-for="(item, index) in dynamicList"
              :key="index"
            >
              <div class="row">
                <div :class="item.coverUrl != '' ? 'col-md-9' : 'col'">
                  <a
                    class="article-title"
                    v-if="item.type == 'video'"
                    :href="'/video/' + item.id"
                  >
                    <strong><p v-text="'📺' + item.title"></p></strong>
                  </a>
                  <a
                    class="article-title"
                    v-if="item.type == 'article'"
                    :href="'/article/' + item.id"
                  >
                    <strong><p v-text="'📰' + item.title"></p></strong>
                  </a>
                  <div class="article-synopsis">{{ item.title }}</div>
                  <p v-if="item.subjectName != null"></p>
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
  name: "dynamic",
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
        url: "/api/dynamic",
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