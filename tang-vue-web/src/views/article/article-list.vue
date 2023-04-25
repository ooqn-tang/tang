<template>
  <div class="row">
    <div class="col-md-9 mb-2 move-p-lr-0">
      <div class="card mb-2 move-b-lr-0">
        <div class="card-body p-0">
          <nav class="nav">
            <a class="nav-link" :class="selectTag == '' ? 'nav-link-active' : ''" @click="selectTagClick('')">最新</a>
            <a class="nav-link" :class="selectTag == 'gz' ? 'nav-link-active' : ''" @click="selectTagClick('gz')">关注</a>
          </nav>
        </div>
      </div>
      <div class="card move-b-lr-0">
        <div class="card-body article-list p-0">
          <ul class="list-group ">
            <li class="list-group-item " v-for="(item, index) in articleList" :key="index">
              <router-link :to="{ name: 'article_post', params: { id: item.article.articleId } }" class="article-title">
                <strong>
                  <p v-text="item.article.title"></p>
                </strong>
              </router-link>
              <div class="article-synopsis" style="color: #5f5a5a;">{{ item.article.synopsis }}</div>
              <div>
                <span class="date-color" style="font-size: 16px;">{{ item.article.createTime }}</span>
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
    <div class="col-md-3 mb-2 move-p-lr-0">
      <div class="list-group mb-2  move-b-lr-0">
        <notice></notice>
      </div>
      <div class="card mb-2  move-b-lr-0">
        <info></info>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useStore } from 'vuex'
import { useRoute, useRouter } from "vue-router"
import request from 'utils/request'

let store = useStore()
let route = useRoute()

let  selectTag = ref("")
let  selectType = ref(1)
let  page = ref({ number: 0 })
let  articleList = ref([])
let  isLoding = ref(true)

// 生命周期钩子
onMounted(() => {
  loadArticle(page.number)
})

function selectTagClick(selectTag) {
  // page = {
  //   number: 0
  // }
  // selectTag = selectTag;
  // articleList = ref([])
  // loadArticle()
}
function loadArticle() {
  let url = ''
  if (selectTag == 'gz') {
    url = '/api/article/list/gz'
  } else {
    url = '/api/article/list'
  }
  request({
    url: url,
    method: 'get',
    params: { page: page.number }
  }).then((response) => {
    isLoding.value = false
    page.value = response.data
    articleList.value = articleList.value.concat(response.data.content)
  })
}
function next() {
  if (!this.page.last) {
    page.number += 1
    loadArticle()
  }
}

</script>

<style scoped>
strong p,
.card-body p {
  margin: 0px;
}

.red {
  color: red;
}</style>