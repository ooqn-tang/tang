<template>
  <div style="height:100%;border-left: 1px solid black;border-right:1px solid black;border-bottom: 1px solid black;">
    <div class="head">
      <input type="text" id="title" v-model="articleForm.title" placeholder="标题" />
      <input type="button" id="save" value="发布" class="btn btn-primary" data-bs-toggle="modal"
        data-bs-target="#exampleModal" />
    </div>
    <div class="body">
      <textarea ref="systemForm" @scroll="sysHandleScroll()" id="text" v-model="articleForm.markdown"
        placeholder="可以输入Markdown文本为内容添加样式."></textarea>
      <div ref="externalForm" @scroll="exterHandleScroll()" id="content" v-html="articleForm.text" class="markdown-body">
      </div>
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
            <label for="exampleDataList" class="form-label">专辑</label>
            <div class="mb-3">
              <select class="form-select" v-model="articleForm.subjectId">
                <option value="">请选择专辑</option>
                <option v-for="(item, index) in subjectList" :value="item.subjectId">
                  {{ item.subjectName }}
                </option>
              </select>
            </div>
            <label for="exampleDataList" class="form-label">分类</label>
            <div class="mb-3">
              <select class="form-select" v-model="articleForm.categoryId">
                <option value="">请选择分类</option>
                <option v-for="(item, index) in categoryList" :value="item.categoryId">
                  {{ item.name }}
                </option>
              </select>
            </div>    
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">关闭</button>
            <button type="button" class="btn btn-primary" @click="saveArticle()">发布</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script setup>
import hljs from "highlight.js";
import request from "@common/request";
import { marked } from "marked";
import { onMounted, ref, watch } from 'vue';
import { useRoute,useRouter } from 'vue-router';
import { useAuthorStore } from "@common/user";

const route = useRoute();
const router = useRouter();
const authorStore = useAuthorStore();

marked.setOptions({
  renderer: new marked.Renderer(),
  highlight: function (code) {
    return hljs.highlightAuto(code).value;
  },
  gfm: true,
  tables: true,
  breaks: true,
  pedantic: false,
  smartLists: true,
  smartypants: false,
});

let articleId = ref(route.query.article);
let subjectList = ref([]);
let articleForm = ref({});
let externalForm = ref(null);
let systemForm = ref(null);
let categoryList = ref([]);

onMounted(() => {
  if(!articleId.value){
    request({
      url: `/api/article`,
      method: 'POST'
    }).then((res) => {
      window.history.pushState({}, 0,  window.location.origin + '/article-editor-md?article=' + res.data);
      articleId.value = res.data
      loadSubject();
      loadCategoryList();
      loadArticleAllInfo(articleId.value);
    })
  }else{
    loadSubject();
    loadCategoryList();
    loadArticleAllInfo(articleId.value);
  }
});

function loadArticleAllInfo(articleId){
  request({
    url: `/api/article/load/${articleId}/all`,
    method: "GET",
  }).then((res) => {
    articleForm.value.articleId = articleId;
    articleForm.value.title = res.data.title;
    articleForm.value.synopsis = res.data.synopsis;
    articleForm.value.text = res.data.text;
    articleForm.value.markdown = res.data.markdown;
    articleForm.value.categoryId = res.data.categoryId;
    articleForm.value.subjectId = res.data.subject == null ? "" : res.data.subject.subjectId;
  });
}

function saveArticle(){
  if (articleForm.value.title == undefined || articleForm.value.title == "") {
    alert("请输入标题！")
    return;
  }
  articleForm.value.text = marked(articleForm.value.markdown);
  request({
    url: `/api/article`,
    method: "PUT",
    data: articleForm.value,
  }).then((res) => {
    window.location.href = `/article/${articleForm.value.articleId}`;
  });
}

function loadSubject(){
  request({
    url: `/api/subject/username/${authorStore.username}`,
    method: "GET",
  }).then((res) => {
    subjectList = res.data;
  });
}

function loadCategoryList(){
  request({
    url: `/api/category/all`,
    params: {
      type: 1,
    },
    method: "GET",
  }).then((res) => {
    categoryList.value = res.data;
  });
}

function sysHandleScroll(){
  externalForm.value.scrollTop = systemForm.value.scrollTop;
}

function exterHandleScroll(){
  systemForm.value.scrollTop = externalForm.value.scrollTop;
}

watch(() => articleForm.value.markdown, (value) => {
  articleForm.value.text = marked(value)
})

</script>
<style>
body {
  overflow-y: hidden !important;
}
</style>

<style scoped>
img {
  max-width: 100%;
}

.head {
  height: 40px;
}

.body {
  height: -webkit-calc(100% - 40px);
  height: -moz-calc(100% - 40px);
  height: calc(100% - 40px);
  border-top: 1px solid black;
}

#save {
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

#title {
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

#content {
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

#text {
  width: 50%;
  height: 100%;
  float: left;
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

  #content {
    display: none;
  }
}
</style>