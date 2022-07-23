<template>
  <div class="row">
    <div class="col-md-9 mb-2 move-p-lr-0">
      <div class="card mb-2 move-b-lr-0">
        <div class="card-body p-0">
          <nav class="nav">
            <a
              class="nav-link"
              :class="select == 'new' ? 'nav-link-active' : ''"
              @click="clickSelect('new')"
              >最新</a
            >
            <a
              class="nav-link"
              :class="select == 'random' ? 'nav-link-active' : ''"
              @click="clickSelect('random')"
              >随机</a
            >
            <a
              class="nav-link"
              :class="select == 'attention' ? 'nav-link-active' : ''"
              @click="clickSelect('attention')"
              >关注</a
            >
          </nav>
        </div>
      </div>
      <div class="card move-b-lr-0">
        <div class="card-body article-list p-0">
          <ul class="list-group">
            <li
              class="list-group-item"
              v-for="(item, index) in essayList"
              :key="index"
            >
              是的是的
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
  name: "essay",
  data() {
    return {
      select: "new",
      essayList: [{}],
    };
  },
  created() {},
  methods: {
    clickSelect(text) {
      this.select = text;
    },
    loadEssay() {
      request({
        url: "/api/dynamic",
        method: "get",
      }).then((response) => {
       this.essayList = response.data
      });
    },
  },
  mounted() {},
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