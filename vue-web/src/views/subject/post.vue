<template>
<div class="row clearfix">
    <div class="col-md-9  move-p-lr-0">
      <div class="card mb-2  move-b-lr-0">
        <div class="card-body">
          <h4>{{subjectData.subjectName}}</h4>
          <span>{{subjectData.synopsis}}</span>
          <hr>
          <div>
            <router-link :to="'/author/'+subjectData.username">{{subjectData.nickname}}</router-link>
            <span class="float-end">{{subjectData.createDate}}</span>
          </div>
        </div>
      </div>
      <ul class="list-group  mb-2 move-b-lr-0">
        <li class="list-group-item move-b-lr-0" v-for="(item,index) in subjectData.articleList" :key="index">
          <router-link :to="{name: 'article_info', params: {id: item.articleId}}" class="article-title">
            <strong><p v-text="item.title"></p></strong>
          </router-link>
          <div class="article-synopsis" style="color: #5f5a5a;">{{item.synopsis}}</div>
          <div>
            <span class="date-color">{{item.createDate}}</span>
          </div>
        </li>
      </ul>
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
      subjectData:{}
    };
  },
  created() {
  },
  methods: {
    loadSubjectById(){
      request({
        url: '/api/subject/subjectId',
        method: 'GET',
        params: {
            "subjectId":this.$route.params.subject_id
        }
      }).then((response) => {
        this.subjectData = response.data
      })
    }
  },
  mounted(){
    this.loadSubjectById()
  }
};
</script>

<style scoped lang="scss">
body{
    overflow-y: scroll;
}
</style>