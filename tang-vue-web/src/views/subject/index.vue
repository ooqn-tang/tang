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
              <p class="card-text text-truncate">
                <router-link :to="{name:'subject_info',params:{subject_id:item.subjectId}}">
                  <strong>{{item.subjectName}}</strong>
                </router-link>
                
                </p>
              <p class="card-text text-truncate">作者：{{item.nickname}}</p>
              <p class="card-text text-truncate">专辑描述：{{item.synopsis}}</p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="col-md-3  mb-2  move-p-lr-0">
      <div class="list-group mb-2  move-b-lr-0">
        <notice></notice>
      </div>
      <div class="card mb-2  move-b-lr-0">
        <info></info>
      </div>
    </div>
</div>
 
</template>

<script>
import request from 'utils/request'
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
      request({
        url: '/api/subject/list',
        method: 'GET'
      }).then((response) => {
        this.subjectList = response.data.list
      })
    }
  },
  mounted(){
    this.selectSubjectList()
  }
};
</script>

<style scoped>
body{
    overflow-y: scroll;
}
</style>