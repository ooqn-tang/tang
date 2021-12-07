<template>
<div class="row clearfix">
    <div class="col-md-9 ">
      <div class="row">
        <div
          class="col-xl-3 col-lg-4 col-md-4 col-12 mb-2 move-p-lr-0"
          v-for="(item, index) in subjectList"
          :key="index"
        >
          <div class="card move-b-lr-0">
            <div class="card-body" style="">
              <p class="card-text text-truncate"><strong><a href="#">{{item.subjectName}}</a></strong></p>
              <p class="card-text text-truncate">作者：{{item.nickname}}</p>
              <p class="card-text text-truncate">专辑描述：{{item.synopsis}}</p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="col-md-3  mb-2 ">
      <div class="list-group mb-2">
        <notice></notice>
      </div>
      <div class="card mb-2">
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
import { selectSubjectList } from '/@/api/subject'
export default {
  name: "subject_index",
  data() {
    return {
      username: this.$store.getters.username,
      subjectList:[]
    };
  },
  created() {
  },
  methods: {
    selectSubjectList(){
      selectSubjectList().then((response) => {
        this.subjectList = response.data.list
      })
    }
  },
  mounted(){
    this.selectSubjectList()
  }
};
</script>

<style scoped lang="scss">
body{
    overflow-y: scroll;
}
</style>