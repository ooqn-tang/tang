<template>
  <ul class="list-group article-list">
    <li class="list-group-item" v-for="(item,index) in subjectList" :key="index">
      <router-link :to="{name:'subject_info',params:{subject_id:item.articleSubjectId}}">
        <strong v-text="item.subjectName"></strong>
      </router-link>
      <span class="float-end" data-bs-toggle="modal" data-bs-target="#exampleModal" v-if="isThisUser" @click="updateClick(item.articleSubjectId,item.subjectName,item.synopsis)">编辑</span>
      <div>
        {{item.synopsis}}
      </div>
    </li>   
    <li class="list-group-item " v-if="isThisUser">
      <a data-bs-toggle="modal" data-bs-target="#exampleModal" @click="dataFrom = {} , saveType = 'insert'">创建专辑</a>
    </li> 
  </ul>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">专辑</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div class="mb-3">
          <label for="exampleFormControlInput1" class="form-label">专辑名</label>
          <input class="form-control" id="exampleFormControlInput1" v-model="dataFrom.subjectName">
        </div>
        <div class="mb-3">
          <label for="exampleFormControlTextarea1" class="form-label">描述</label>
          <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"  v-model="dataFrom.synopsis"></textarea>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" @click="save">保存</button>
      </div>
    </div>
  </div>
</div>
</template>

<script>
import request from 'src/utils/request'
export default {
  name: "author_subject",
  data() {
    return {
      saveType:"update",// insert
      thisUsername: this.$route.params.username,
      isThisUser: this.$route.params.username == this.$store.state.username,
      subjectList:[],
      dataFrom:{
        articleSubjectId:"",
        subjectName:"",
        synopsis:""
      }
    };
  },
  methods: {
    save(){
      if(this.saveType == "insert"){
        request({
        url: '/api/subject',
        method: 'POST',
        data:this.dataFrom
        }).then((response) => {
          alert(JSON.stringify(response.data))
        })
      }else{
        request({
          url: '/api/subject',
          method: 'PUT',
          data:this.dataFrom
        }).then((response) => {
          alert(JSON.stringify(response.data))
        })
      }
    },
    updateClick(articleSubjectId,subjectName,synopsis){
      this.dataFrom.articleSubjectId = articleSubjectId;
      this.dataFrom.subjectName = subjectName;
      this.dataFrom.synopsis = synopsis;
      this.saveType = 'update'
    },
    selectSubjectListByUsername(username){
      request({
        url: '/api/subject/username',
        method: 'GET',
        params:{"username":username}
      }).then((response) => {
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