<template>
  <div class="row clearfix">
    <div class="col-md-4 col-md-push-8 move-p-lr-0">
      <div class="card mb-2 move-b-lr-0">
        <div class="card-body ">
          <strong>{{author.nickname}}&nbsp;</strong>
          <button v-if="fans == 2" class="btn btn-outline-warning float-end" style="padding: 0px 5px 0px 3px;font-size: 13px;" @click="fansClick(author.username)">订阅</button>
          <button v-if="fans == 1" class="btn btn-outline-warning float-end" style="padding: 0px 5px 0px 3px;font-size: 13px;" @click="fansClick(author.username)">取消订阅</button>
          <hr />
          <div>简介：{{author.signature}}</div>
        </div>
      </div>
      <div class="list-group mb-2 d-md-inline d-none">
        <notice></notice>
      </div>
      
    </div>
    <div class="col-md-8 col-md-pull-4 mb-2 move-p-lr-0">
      <div class="card move-b-lr-0">
        <div class="card-header" v-if="thisUsername == loginUsername">
          <ul class="nav justify-content-center">
            <li class="nav-item">
              <router-link class="nav-link" :class="routeName == 'author_article'?'nav-link-active':''" :to="{name:'author_article'}">文章</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" :class="routeName == 'author_subject'?'nav-link-active':''" :to="{name:'author_subject'}">专栏</router-link>
            </li>
            <li class="nav-item" v-if="thisUsername == loginUsername">
              <router-link class="nav-link"  :class="routeName == 'author_subscribe'?'nav-link-active':''" :to="{name:'author_subscribe'}">订阅</router-link>
            </li>
            <li class="nav-item" v-if="thisUsername == loginUsername">
              <router-link class="nav-link"  :class="routeName == 'author_collect'?'nav-link-active':''" :to="{name:'author_collect'}">收藏</router-link>
            </li>
            <li class="nav-item" v-if="thisUsername == loginUsername">
              <router-link class="nav-link" :class="routeName == 'author_setting'?'nav-link-active':''" :to="{name:'author_setting'}">设置</router-link>
            </li>
          </ul>
        </div>
        <div class="card-header" v-if="thisUsername != loginUsername">
          <ul class="nav justify-content-center">
            <li class="nav-item">
              <router-link class="nav-link" :class="routeName == 'author_article'?'nav-link-active':''" :to="{name:'author_article'}">文章</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" :class="routeName == 'author_subject'?'nav-link-active':''" :to="{name:'author_subject'}">专栏</router-link>
            </li>
          </ul>
        </div>
        <div class="card-body p-0">
          <router-view/>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import request from 'utils/request'
import { useRouter,useRoute } from 'vue-router'
import { useStore } from 'vuex'
import { onMounted,ref,watch } from 'vue'

let router = useRouter()
let route = useRoute()
let store = useStore()

let routeName = ref(route.name)
let author = ref({
  nickname:"∷∷∷∷∷∷∷∷",
  signature:"∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷"
})

let thisUsername = ref("")
let loginUsername = store.state.username
let from = ref({
  page:1
})
let fans = ref(1)

function fansClick(username){
  if(fans.value == 2){
    request({
      url: `/api/fans/${username}`,
      method: 'POST'
    }).then((response) => {
      fans.value = 1
    })
  }else{
    request({
      url: `/api/fans/${username}`,
      method: 'DELETE'
    }).then((response) => {
      fans.value = 2
    })
  }
}

// 监听 routeName 的变化 ， 如果变化获取route name 给 routeName
watch(() => route.name, (val) => {
  routeName.value = val
})

function isFans(){
  request({
    url: `/api/fans/username/${thisUsername}`,
    method: 'get'
  }).then((response) => {
    if(response.data > 0){
      fans.value = 1
    }else{
      fans.value = 2
    }
  })
}

function getAuthor(){
  request({
    url: `/api/author/${thisUsername}`,
    method: 'get'
  }).then((response) => {
    if(response.status == 200){
      author.value = response.data
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
body{
    overflow-y: scroll;
}
.nav-link{
  padding-left: 6px;
  padding-right: 6px;
}
</style>