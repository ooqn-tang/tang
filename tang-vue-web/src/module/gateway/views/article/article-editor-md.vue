<template>
  <div class="h100 flex">
    <div class="pc b1 m5 w100 mr0">
      <div class="p2 bb1 h40">
        <select class="h100 w100 text-center" v-model="articleForm.subjectId">
          <option>设置专辑</option>
          <option v-for="item in subjectList" :value="item.subjectId">
            {{ item.subjectName }}
          </option>
        </select>
      </div>
      <div v-for="item in subjectArticleList" class="bb1 p5">
        {{ item.title }}
      </div>
      <div class="p2 bb1 h40">
        <button class="h100 w100">增加文章</button>
      </div>

    </div>
    <div class="flex-grow-1 b1 m5">
      <div class="h40 flex">
        <input class="flex-grow-1" type="text" id="title" v-model="articleForm.title" placeholder="标题" />
        <button class='w80px' @click="saveArticle()">保存</button>
      </div>
      <div class="body flex">
        <div class="flex-grow-1 flex flex-column">
          <textarea class="flex-grow-1 w100 bb1" ref="systemForm" @scroll="sysHandleScroll()" id="text"
            v-model="articleForm.markdown" placeholder="可以输入Markdown文本为内容添加样式."></textarea>
          <div class="br1 m-br0">
            <button class="br1 p5" data-bs-toggle="modal" data-bs-target="#exampleModal">属性</button>
            <button class="br1 p5">预览</button>
            <button class="br1 p5">返回</button>
            <button class="br1 p5">撤回修改</button>
          </div>

        </div>
        <div ref="externalForm" @scroll="exterHandleScroll()" id="content" v-html="articleForm.text"
          class="markdown-body"></div>
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
                  <option v-for="item in subjectList" :value="item.subjectId">
                    {{ item.subjectName }}
                  </option>
                </select>
              </div>
              <label for="exampleDataList" class="form-label">分类</label>
              <div class="mb-3">
                <select class="form-select" v-model="articleForm.categoryId">
                  <option value="">请选择分类</option>
                  <option v-for="item in categoryList" :value="item.categoryId">
                    {{ item.name }}
                  </option>
                </select>
              </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">关闭</button>
              <button type="button" class="btn btn-primary" @click="saveArticle()">保存</button>
            </div>
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
import { useRoute, useRouter } from 'vue-router';
import { useAuthorStore } from "@common/user";
import { articleSubjectArticleListApi } from "@gateway/apis/subject";

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
let subjectArticleList = ref([{}, {}, {}, {}, {}, {}, {}, {}]);

onMounted(() => {
  if (!articleId.value) {
    request({
      url: `/api/article`,
      method: 'POST'
    }).then((res) => {
      window.history.pushState({}, 0, window.location.origin + '/article-editor-md?article=' + res.data);
      articleId.value = res.data
      loadSubject();
      loadCategoryList();
      loadArticleAllInfo(articleId.value);
    })
  } else {
    loadSubject();
    loadCategoryList();
    loadArticleAllInfo(articleId.value);
  }
});

function loadArticleAllInfo(articleId) {
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

function saveArticle() {
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
    alert("保存成功")
  });
}

function loadSubject() {
  request({
    url: `/api/subject/username/${authorStore.username}`,
    method: "GET",
  }).then((res) => {
    subjectList = res.data;
  });
}

function selectSubjectArticleList() {
  articleSubjectArticleListApi(articleId.value).then((res) => {
    subjectArticleList.value = res.data;
  });
}

function loadCategoryList() {
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

function sysHandleScroll() {
  externalForm.value.scrollTop = systemForm.value.scrollTop;
}

function exterHandleScroll() {
  systemForm.value.scrollTop = externalForm.value.scrollTop;
}

watch(() => articleForm.value.markdown, (value) => {
  articleForm.value.text = marked(value)
})

onMounted(() => {
  selectSubjectArticleList();
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

.w200px{
  width: 200px;
}

.mr0{
  margin-right: 0px;
}

.h40 {
  height: 40px;
}

.body {
  height: -webkit-calc(100% - 40px);
  height: -moz-calc(100% - 40px);
  height: calc(100% - 40px);
  border-top: 1px solid black;
}


#title {
  background: #ffffff;
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

  .m-br0{
    border-right: 0px;
  }
}

.w80px {
  width: 80px;
}


</style>