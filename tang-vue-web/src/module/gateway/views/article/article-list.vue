<template>
  <div class="row">
    <div class="col-md-9 mb-2">
      <div class="card mb-2">
        <div class="card-body p-0">
          <nav class="nav">
            <a class="nav-link" :class="selectCategoryId == '0' ? 'nav-link-active' : ''"
              @click="selectCategoryClick({ categoryId: 0 })">全部</a>
            <a v-for="(item, index) in categoryList" :key="index"
              :class="selectCategoryId == item.categoryId ? 'nav-link-active' : ''" class="nav-link"
              @click="selectCategoryClick(item)">{{ item.name }}</a>
          </nav>
        </div>
      </div>
      <div class="card">
        <div class="card-body article-list p-0">
          <ul class="list-group ">
            <li class="list-group-item " v-for="(item, index) in articleList" :key="index">
              <router-link :to="{ name: 'article_post', params: { id: item.articleId } }" class="article-title">
                <strong>
                  <p v-text="item.title"></p>
                </strong>
              </router-link>
              <div class="article-synopsis" style="color: #5f5a5a;">{{ item.synopsis }}</div>
              <div>
                <span class="date-color" style="font-size: 16px;">{{ item.createTime }} </span>
                <span class="date-color" style="font-size: 16px;" v-if="item.category != null"> . {{ item.category.name }}
                </span>
                <span v-for="(item, index) in item.tagList" :key="index"> . <span
                    style="font-size: 16px;color: #dc3545;">{{ item.tagName }}</span></span>
                <router-link :to="{ name: 'author_article', params: { username: item.author.username } }"
                  class="float-end">{{ item.author.nickname }}</router-link>
              </div>
            </li>
            <li class="list-group-item">
              <a @click="next()" v-if="!isLoding">获取</a><a v-if="isLoding">加载中...</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <div class="col-md-3 mb-2">
      <notice></notice>
      <info></info>
    </div>
  </div>
</template>

<script setup>
import request from '@common/request';
import { onMounted, ref } from 'vue';
import notice from '@components/notice.vue';
import info from '@components/info.vue';

let selectCategoryId = ref(0);
let page = ref({ number: 0 });
let articleList = ref([]);
let isLoding = ref(true);
let categoryList = ref([]);

onMounted(() => {
  loadArticle({ categoryId: 0 });
  loadCategoryList();
})

function selectCategoryClick(item){
  selectCategoryId = item.categoryId;
  page.value.number = 0;
  articleList.value = [];
  loadArticle(item);
}

function loadCategoryList(){
  request({
    url: '/api/category/list',
    method: 'get',
    params: { type: "1" }
  }).then((res) => {
    if (res.data.length > 0) {
      categoryList.value = res.data
    }
  })
}

function loadArticle(item){
  let url = '/api/article/list'
  request({
    url: url,
    method: 'get',
    params: { page: page.value.number, categoryId: item.categoryId }
  }).then((res) => {
    isLoding.value = false
    page.value = res.data
    articleList.value = articleList.value.concat(res.data.content)
  })
}

function next(){
  if (!page.last) {
    page.value.number += 1
    loadArticle({ categoryId: selectCategoryId.value })
  }
}

</script>

<style scoped>
strong p,
.card-body p {
  margin: 0px;
}

hr {
  margin: 0 !important;
}

.red {
  color: red;
}
</style>