<template>
  <div class="head">
      <input type="text" id="title" v-model="blogData.title" placeholder="标题">
      <input type="button" id="save" value="发布" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
  </div>
  <div class="body">
      <textarea id="text" v-model="blogData.markdown" @keyup="keyup()" @change="keyup()" placeholder="可以输入Markdown文本为内容添加样式"></textarea>
      <div id="content" v-html="blogData.text" class="markdown-body"></div>
  </div>
  <div class="foot">
      <span>文本块</span>
      <span style="float: right;">帮助</span>
  </div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">发布</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">

        <div class="form-check form-check-inline" v-for="(item,index) in authorTagList" :key="index" style="margin-bottom: 10px;">
          <input class="form-check-input" type="checkbox" v-model="blogData.tagIdList" :id="index" :value="item.blogTagId">
          <label class="form-check-label" :for="index">{{item.tagName}}</label>
        </div>

        <div class="input-group mb-3">
            <input type="text" v-model="tagName" class="form-control" placeholder="标签">
            <button class="btn btn-outline-secondary" type="button" id="button-addon2" @click="insertTag()">添加</button>
        </div>

        <div>
          <select class="form-select" v-model="blogData.subjectId">
            <option value="">请选择专辑</option>
            <option v-for="(item,index) in subjectList" :key="index" :value="item.blogSubjectId">{{item.subjectName}}</option>
          </select>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary">存草稿</button>
        <button type="button" class="btn btn-primary" @click="insertBlog()">发布</button>
      </div>
    </div>
  </div>
</div>

</template>

<script>
import 'https://cdn.bootcdn.net/ajax/libs/marked/1.2.7/marked.min.js'
import { insertBlog,loadSubjectList,loadAuthorAllTagList,insertAuthorTag,insertTag} from "/@/api/blog"
marked.setOptions({
  renderer: new marked.Renderer(),
  gfm: true,
  tables: true,
  breaks: true,
  pedantic: false,
  smartLists: true,
  sanitize:true,
  smartypants: false
});


export default {
  name: "editor",
  data() {
    return {
      blogData:{
        title:"",
        text:"",
        markdown:"",
        synopsis:"",
        tagIdList:[],
        subjectId:""
      },
      blogSubjectId:"",
      tagName:"",
      subjectList:[],
      subjectMap:{},
      tagList:[],
      tagMap:{},
      authorTagList:[]
    };
  },
  methods: {
      keyup(){
        this.blogData.text = marked(this.blogData.markdown)
        this.blogData.synopsis = this.blogData.text.replace(/<(style|script|iframe)[^>]*?>[\s\S]+?<\/\1\s*>/gi,'').replace(/<[^>]+?>/g,'').replace(/\s+/g,' ').replace(/ /g,' ').replace(/>/g,' ').substring(0,150).replace(" ","");
      },
      insertBlog(){
        insertBlog(this.blogData).then((response) => {
          if(response.code == 200){
            window.location.href = "/blog/" + response.data.blogId
          }
        })
      },
      loadSubjectList(){
        loadSubjectList(this.$store.state.username).then((response) => {
          this.subjectList = response.data.list
          let li = response.data.list
          for(let item in response.data.list){
            this.subjectMap[li[item]["subjectName"]] = li[item]["blogSubjectId"]
          }
        })
      },
      loadAuthorAllTagList(){
        loadAuthorAllTagList().then((response) => {
          this.authorTagList = response.data;
        })
      },
      insertTag(){
        insertTag({"tagName":this.tagName}).then((response) => {
          if(response.code == 200){
            insertAuthorTag({"tagId":response.data}).then((response2) => {
              if(response2.code == 200){
                this.loadAuthorAllTagList()
              }else{
                alert(response2.message)
              }
              
            })
          }
        })
      }
  },mounted(){
    this.loadSubjectList()
    this.loadAuthorAllTagList()
  },
  created(){
      
  }
};
</script>
<style>
  body{
    overflow-y: hidden !important;
  }
  
</style>

<style scoped lang="scss">
img{
    max-width: 100%;
}
.head{
    height: 40px;
}
.body{
    height:-webkit-calc(100% - 80px);
    height:-moz-calc(100% - 80px);
    height:calc(100% - 80px);
    border-bottom: 1px solid black;
    border-top: 1px solid black;
    
}
.foot{
    height: 40px;
    background: #f4f4f4;
    line-height: 40px;
    padding:0 10px;
    color: rgb(45, 89, 184);
    font-weight:bold
}
#save{
    border-left: 1px #b5adad solid;
    outline: none;
    width: 90px;
    float: right;
    height: 100%;
    background: #337ab7;
    border-radius: 0;
    color: #fff;
}
#title{
    background: #f4f4f4;
    padding-left: 10px;
    padding-right: 10px;
    font-size: 24px;
    line-height: 30px;
    width: -webkit-calc(100% - 90px);
    width: -moz-calc(100% - 90px);
    width: calc(100% - 90px);
    height: 100%;
    outline: none;
}
#content{
    width: 50%;
    height: 100%;
    float: left;
    background: #fff8eb;
    padding: 10px;
    font-size: 18px;
    overflow-y: auto;
    word-break: break-all;
    word-wrap: break-word;
}
#text{
    width: 50%;
    height: 100%;
    float:left;
    border-right: 1px solid black;
    background-color: #e2e3e4;
    padding: 10px;
    font-size: 18px;
    overflow-y: auto;
}
@media screen and (max-width: 700px) {
    #text {
        width: 100% !important;
        border-right: 0 !important;
    }
    #content{
        display: none;
    }
}
</style>