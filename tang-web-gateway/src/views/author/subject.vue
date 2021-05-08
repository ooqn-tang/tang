<template>
  <ul class="list-group blog-list">
    <li class="list-group-item" v-for="(item,index) in subjectList" :key="index">
      <router-link to="/">
        <strong v-text="item.subjectName"></strong>
      </router-link>
      <span class="float-end">编辑</span>
      <div>
        {{item.synopsis}}
      </div>
    </li>   
    <li class="list-group-item ">
      <a class="" @click="loadBlog()">获取</a>
    </li> 
  </ul>
</template>

<script>
import {selectSubjectListByUsername}from "/@/api/subject"
export default {
  name: "author_subject",
  data() {
    return {
      subjectList:[]
    };
  },
  components: {

  },
  methods: {
    selectSubjectListByUsername(username){
      selectSubjectListByUsername(username).then((response) => {
        this.subjectList = response.data.list
      })
    }
  },
  mounted(){
    this.selectSubjectListByUsername(this.$route.params.username)
  }
};
</script>

<style lang="scss">
body{
    overflow-y: scroll;
}
</style>