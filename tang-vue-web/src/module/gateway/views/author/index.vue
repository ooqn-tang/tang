<template>
  <div class="row clearfix">
    <div class="col-md-4 col-md-push-8 small-col">
      <div class="card mb-2 ">
        <div class="card-body ">
          <strong>{{ author.nickname }}</strong>
          <button class="btn btn-outline-warning float-end  btn-sm ssm" @click="fansClick(author.username)"
            v-text="fans == 2 ? '订阅' : '取消订阅'"></button>
          <hr />
          <div>简介：{{ author.signature }}</div>
        </div>
      </div>
      <div class="d-md-inline  d-none">
        <notice></notice>
        <info></info>
      </div>

    </div>
    <div class="col-md-8 col-md-pull-4 mb-2 small-col">

      <div class="card mb-2 ">
        <div class="card-body p-0">
          <ul class="nav justify-content-center">
            <li class="nav-item">
              <router-link class="nav-link p-2" :class="routeName == 'author_article' ? 'nav-link-active' : ''"
                :to="{ name: 'author_article' }">文章</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link p-2" :class="routeName == 'author_subject' ? 'nav-link-active' : ''"
                :to="{ name: 'author_subject' }">专栏</router-link>
            </li>
            <li class="nav-item" v-if="thisUsername == loginUsername">
              <router-link class="nav-link p-2" :class="routeName == 'author_subscribe' ? 'nav-link-active' : ''"
                :to="{ name: 'author_subscribe' }">订阅</router-link>
            </li>
            <li class="nav-item" v-if="thisUsername == loginUsername">
              <router-link class="nav-link p-2" :class="routeName == 'author_collect' ? 'nav-link-active' : ''"
                :to="{ name: 'author_collect' }">收藏</router-link>
            </li>
            <li class="nav-item" v-if="thisUsername == loginUsername">
              <router-link class="nav-link p-2" :class="routeName == 'author_setting' ? 'nav-link-active' : ''"
                :to="{ name: 'author_setting' }">设置</router-link>
            </li>
          </ul>
        </div>
      </div>
      <router-view />
    </div>
  </div>
</template>

<script setup>
import request from '@common/request'
import { useRouter, useRoute } from 'vue-router'
import { useAuthorStore } from '@common/user'
import { onMounted, ref, watch } from 'vue'

import notice from '@components/notice.vue';
import info from '@components/info.vue';

let router = useRouter()
let route = useRoute()
let authorStore = useAuthorStore()

let routeName = ref(route.name)
let author = ref({
  nickname: "∷∷∷∷∷∷∷∷",
  signature: "∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷"
})

let thisUsername = ref("")
let loginUsername = authorStore.author.username
let from = ref({
  page: 1
})
let fans = ref(1)

function fansClick(username) {
  if (fans.value == 2) {
    request({
      url: `/api/fans/${username}`,
      method: 'POST'
    }).then((register) => {
      fans.value = 1
    })
  } else {
    request({
      url: `/api/fans/${username}`,
      method: 'DELETE'
    }).then((res) => {
      fans.value = 2
    })
  }
}

// 监听 routeName 的变化 ， 如果变化获取route name 给 routeName
watch(() => route.name, (val) => {
  routeName.value = val
})

function isFans() {
  request({
    url: `/api/fans/username/${thisUsername}`,
    method: 'get'
  }).then((res) => {
    if (res.data > 0) {
      fans.value = 1
    } else {
      fans.value = 2
    }
  })
}

function getAuthor() {
  request({
    url: `/api/author/username/${thisUsername}`,
    method: 'get'
  }).then((res) => {
    if (res.status == 200) {
      author.value = res.data
    }
  })
}

onMounted(() => {
  thisUsername = router.currentRoute.value.params.username
  getAuthor()
  isFans()
})

</script>

<style scoped>
.nav-link {
  padding-left: 6px;
  padding-right: 6px;
}

.nav-link-active{
  color: rgb(255, 67, 67);
}

</style>