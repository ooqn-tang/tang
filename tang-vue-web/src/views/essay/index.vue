<template>
  <div class="row">
    <div class="col-md-9 mb-2 move-p-lr-0">
      <div class="card mb-2 move-b-lr-0">
        <div class="card-body p-0">
          <nav class="nav">
            <router-link class="nav-link" :to="{name:'essay_message'}">最新</router-link>
            <a class="nav-link" data-bs-toggle="modal" data-bs-target="#exampleModal" style="color: #0021c5;">发布</a>
            <router-link class="nav-link" :to="{name:'essay_collect'}">收藏</router-link>
            <router-link class="nav-link" :to="{name:'essay_my'}">我的</router-link>
          </nav>
        </div>
      </div>
      <div class="card move-b-lr-0">
        <router-view/>
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

  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">发布</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <textarea class="form-control" placeholder="Leave a comment here" v-model="essay.text" id="floatingTextarea2"
            style="height: 250px"></textarea>
        </div>
        <div class="modal-footer">
          <button type="button" ref="close" class="btn btn-secondary" data-bs-dismiss="modal">关闭</button>
          <button type="button" class="btn btn-primary" @click="insertEssay">发送</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import request from "utils/request";
export default {
  name: "essay_index",
  data() {
    return {
      select: "new",
      essayList: [],
      essay: {}
    };
  },
  created() { },
  methods: {
    clickSelect(text) {
      this.select = text;
    },
    loadEssay() {
      request({
        url: "/api/essay",
        method: "get",
        params: { type: 'essay' }
      }).then((response) => {
        this.essayList = response.data.list
      });
    },
    insertEssay() {
      request({
        url: "/api/essay",
        method: "post",
        data: this.essay
      }).then((response) => {
        this.$refs.close.click();
        this.essayList.unshift(response.data)
        this.essay = {}
      });
    }
  },
  mounted() {
    this.loadEssay()
  },
};
</script>

<style scoped>
strong p,
.card-body p {
  margin: 0px;
}

.red {
  color: red;
}

.t-nav-link {
  margin: 0 20px;
  line-height: 40px;
  float: left;
}
</style>