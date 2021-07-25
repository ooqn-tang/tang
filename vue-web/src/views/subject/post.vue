<template>
<div class="row clearfix">
    <div class="col-md-9 ">
      <div class="card mb-2">
        <div class="card-body">
          <h4>{{subjectData.subjectName}}</h4>
          <span>{{subjectData.synopsis}}</span>
        </div>
      </div>
      <ul class="list-group ">
        <li class="list-group-item " v-for="(item,index) in subjectData.blogList" :key="index">
          <router-link :to="{name: 'blog_info', params: {id: item.blogId}}" class="blog-title">
            <strong><p v-text="item.title"></p></strong>
            </router-link>
          <div class="blog-synopsis" style="color: #5f5a5a;">{{item.synopsis}}</div>
          <div>
            <span class="date-color">{{item.createDate}}</span>
            <span v-for="(item,index) in item.tagList" :key="index" > . <span style="font-size: 10px;color: #a2a2a2;">{{item.tagName}}</span></span>
            <router-link :to="{name:'author_blog',params:{username:item.username}}" class="float-end">{{item.nickname}}</router-link>
          </div>
        </li>
      </ul>
    </div>
    <div class="col-md-3  mb-2 ">
      <div class="list-group mb-2">
        <a class="list-group-item active" >TOP<span class="float-end">🎇</span></a>
        <advertise></advertise>
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
import {loadSubjectById} from "/@/api/subject"
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
      loadSubjectById(this.$route.params.subject_id).then((response) => {
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