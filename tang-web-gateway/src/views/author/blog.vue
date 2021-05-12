<template>
  <ul class="list-group blog-list">
    <li class="list-group-item" v-for="(item,index) in blogList" :key="index">
      <router-link :to="{name: 'post', params: { id: item.blogId }}" class="blog-title">
        <strong><p v-text="item.title"></p></strong>
      </router-link>
      <div class="blog-synopsis">{{item.synopsis}}</div>
      <div>
        <span>{{item.createDate}}</span>
        <div class="btn-group float-end">
          <button class="btn btn-outline-dark float-end" style="padding: 0px 5px 0px 3px;font-size: 13px;" disabled>编辑</button>
          <button class="btn btn-outline-dark float-end" style="padding: 0px 5px 0px 3px;font-size: 13px;">删除</button>
          <button class="btn btn-outline-dark float-end" style="padding: 0px 5px 0px 3px;font-size: 13px;" data-bs-toggle="modal" data-bs-target="#exampleModal"  @click="subjectFrom.blogId = item.blogId">添加到专辑</button>
      </div>
    </li>   
    <li class="list-group-item ">
      <a class="" @click="loadBlog()">获取</a>
    </li> 
  </ul>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">添加博客到专辑</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <select class="form-select" v-model="subjectFrom.subjectId">
          <option value="">请选择</option>
          <option v-for="(item,index) in subjectList" :key="index" :value="item.blogSubjectId">{{item.subjectName}}</option>
        </select>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" @click="insertBlogToSubject">保存</button>
      </div>
    </div>
  </div>
</div>

</template>

<script>
import {loadBlogByUsername,loadSubjectList} from '/@/api/blog'
import {insertBlogToSubject,selectSubjectListByUsername} from '/@/api/subject'
export default {
  name: "author_blog",
  data() {
    return {
      blogList:[
        
      ],
      subjectFrom:{
        subjectId:""
      },
      subjectList:[],
    };
  },
  components: {

  },
  methods: {
    loadBlogByUsername(){
      loadBlogByUsername(this.$route.params.username,{}).then((response) => {
        this.blogList = response.data.list
      })
    },
    loadSubjectList(){
      selectSubjectListByUsername(this.$route.params.username).then((response) => {
        this.subjectList = response.data.list
      })
    },
    insertBlogToSubject(){
       alert(JSON.stringify(this.subjectFrom))
      let blogId = this.subjectFrom.blogId;
      let subjectId = this.subjectFrom.subjectId;
     
      insertBlogToSubject(blogId, subjectId).then((response) => {
        alert(JSON.stringify(response.data))
      })
    }
  },
  mounted(){
    this.loadBlogByUsername() 
    this.loadSubjectList()
  }
};
</script>

<style lang="scss">
body{
    overflow-y: scroll;
}
</style>