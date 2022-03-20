<template>
  <div class="head">
      <input type="text" id="title" v-model="articleData.title" placeholder="标题">
      <input type="button" id="save" value="发布" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
  </div>
  <div class="body">
      <textarea ref="systemForm" @scroll="sysHandleScroll()"  @mouseover="changeFlag(false)" id="text" v-model="articleData.markdown"  placeholder="可以输入Markdown文本为内容添加样式"></textarea>
      <div ref='externalForm' @scroll="exterHandleScroll()" @mouseover="changeFlag(true)" id="content" v-html="articleData.text" class="markdown-body"></div>
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
          <input class="form-check-input" type="checkbox" v-model="selectTagIdList" :id="index" :value="item.articleTagId">
          <label class="form-check-label" :for="index">{{item.tagName}}</label>
        </div>
        <div>
          <select class="form-select" v-model="articleData.subjectId">
            <option value="">请选择专辑</option>
            <option v-for="(item,index) in subjectList" :key="index" :value="item.articleSubjectId">{{item.subjectName}}</option>
          </select>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary">存草稿</button>
        <button type="button" class="btn btn-primary" @click="saveArticle()">发布</button>
      </div>
    </div>
  </div>
</div>

</template>

<script>
import marked from 'marked'
import hljs from "highlight.js"
import 'highlight.js/styles/github.css'
import request from 'utils/request'
marked.setOptions({
  renderer: new marked.Renderer(),
   highlight: function(code) {
      return hljs.highlightAuto(code).value;
    },
  gfm: true,
  tables: true,
  breaks: true,
  pedantic: false,
  smartLists: true,
  smartypants: false
});
export default {
  name: "article-editor",
  data() {
    return {
      thisArticleId:this.$route.params.id,
      selectTagIdList:[],
      articleData:{
      },
      articleSubjectId:"",
      tagName:"",
      subjectList:[],
      subjectMap:{},
      tagList:[],
      tagMap:{},
      authorTagList:[],
    };
  },
  watch :{
    articleData:{
      handler(val){
        if(val.markdown != undefined){
          this.articleData.text = marked(val.markdown)
          this.articleData.synopsis = val.text.replace(/<(style|script|iframe)[^>]*?>[\s\S]+?<\/\1\s*>/gi,'').replace(/<[^>]+?>/g,'').replace(/\s+/g,' ').replace(/ /g,' ').replace(/>/g,' ').substring(0,150).replace(" ","");
        }
        
      },
      deep:true //true 深度监听
    }
  },
  methods: {
      loadArticleAllInfo(articleId){
        request({
          url: '/api/article/load/'+articleId+"/all",
          method: 'GET',
        }).then((response) => {
          this.articleData = response.data
          let tList = response.data.tagList
          for(let v in tList){
            this.selectTagIdList.push(tList[v].articleTagId)
          }
          this.articleData.subjectId = (this.articleData.subjectId == null ? "" : this.articleData.subjectId)
        })
      },
      saveArticle(){
        this.articleData.tagIdList = this.selectTagIdList
        request({
          url: '/api/article',
          method: 'PUT',
          data:this.articleData
        }).then((response) => {
          window.location.href = "/article/" + response.data
        })
      },
      loadSubjectList(){
        request({
          url: '/api/subject/username',
          method: 'GET',
          params:{"username":this.$store.state.username}
        }).then((response) => {
          this.subjectList = response.data.list
          let li = response.data.list
          for(let item in response.data.list){
            this.subjectMap[li[item]["subjectName"]] = li[item]["articleSubjectId"]
          }
        })
      },
      loadAllTagList(){
        request({
          url: '/api/tag/all',
          method: 'GET'
        }).then((response) => {
          this.authorTagList = response.data;
        })
      },
      changeFlag(flag) {
        this.flag = flag
      },
      sysHandleScroll() {
        if (!this.flag) {
          this.$refs.externalForm.scrollTop = this.$refs.systemForm.scrollTop
        }
      },
      exterHandleScroll() {
        if (this.flag) {
          this.$refs.systemForm.scrollTop = this.$refs.externalForm.scrollTop
        }
      }
  },mounted(){
    this.loadSubjectList()
    this.loadAllTagList()
    this.loadArticleAllInfo(this.thisArticleId)
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
    height:-webkit-calc(100% - 40px);
    height:-moz-calc(100% - 40px);
    height:calc(100% - 40px);
    border-top: 1px solid black;
}
#save{
    border-left: 1px #b5adad solid;
    border-bottom: 0px;
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
    font-size: 17px;
    overflow-y: auto;
    resize: none;
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