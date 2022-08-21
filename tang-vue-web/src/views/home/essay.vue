<template>
  <div class="row">
    <div class="col-md-9 mb-2 move-p-lr-0">
      <div class="card mb-2 move-b-lr-0">
        <div class="card-body p-0">
            <a class="t-nav-link" :class="select == 'new' ? 'nav-link-active' : ''" @click="clickSelect('new')">最新</a>
            <a class="t-nav-link float-end" data-bs-toggle="modal" data-bs-target="#exampleModal">发布</a>
        </div>
      </div>
      <div class="card move-b-lr-0">
        <div class="card-body article-list p-0">
          <ul class="list-group">
            <li class="list-group-item" v-for="(item, index) in essayList" :key="index">
              <p>
                <router-link :to="{name:'author_article',params:{username : item.username}}">{{item.nickname}}</router-link>
                <span class="float-end">{{item.createTime}}</span>
              </p>
              {{item.text}}
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
  
  <div
    class="modal fade"
    id="exampleModal"
    tabindex="-1"
    aria-labelledby="exampleModalLabel"
    aria-hidden="true"
  >
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">发布</h5>
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></button>
        </div>
        <div class="modal-body">
           <textarea class="form-control" placeholder="Leave a comment here" v-model="essay.text" id="floatingTextarea2" style="height: 250px"></textarea>
        </div>
        <div class="modal-footer">
          <button type="button"  ref="close" class="btn btn-secondary" data-bs-dismiss="modal">关闭</button>
          <button type="button" class="btn btn-primary" @click="insertEssay">发送</button>
        </div>
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
      essayList: [],
      essay:{}
    };
  },
  created() {},
  methods: {
    clickSelect(text) {
      this.select = text;
    },
    loadEssay() {
      request({
        url: "/api/essay",
        method: "get",
        params:{type:'essay'}
      }).then((response) => {
       this.essayList = response.data.list
      });
    },
    insertEssay(){
      request({
        url: "/api/essay",
        method: "post",
        data:this.essay
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

<style scoped lang="scss">
strong p,
.card-body p {
  margin: 0px;
}
.red {
  color: red;
}
.t-nav-link{
margin: 0 20px;
line-height: 40px;
float: left;
}
</style>