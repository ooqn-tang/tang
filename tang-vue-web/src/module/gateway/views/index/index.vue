<template>
  <nav class="navbar navbar-expand navbar navbar-expand-lg navbar-light bg-light flex-column p-0 b-b-1" id="top">
    <div class="container-fluid" style="padding: 5px 12px;">
      <a class="navbar-brand pc" href="/" style='margin-right: 0px;'>ooqn.com</a>
      <a class="navbar-brand yd" href="/" style='margin-right: 0px;'>OOQN</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02"
        aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
        <ul class="navbar-nav me-auto mb-lg-0 pc">
          <li class="nav-item" v-for="(item, index) in linkItemList" v-show="item.admin ? store.roles.includes('ROLE_ADMIN') : true">
            <router-link tag="a" :target="item._blank ? '_blank' : ''" class="nav-link active" :to="item.to">
              {{ item.name }}
            </router-link>
          </li>
        </ul>
        <ul class="navbar-nav me-auto mb-lg-0 yd">
          <li class="nav-item dropdown float-start">
            <a class="nav-link active dropdown-toggle" href="#" data-bs-toggle="dropdown">🧮菜单</a>
            <ul class="dropdown-menu">
              <li v-for="(item, index) in linkItemList" v-show="item.admin ? store.roles.includes('ROLE_ADMIN') : true">
                <router-link class="dropdown-item" :to="item.to">{{ item.name }}</router-link>
              </li>
            </ul>
          </li>
          <li class="nav-item float-start">
            <router-link class="nav-link active right-padding-0" to="/search">🔍搜索</router-link>
          </li>
        </ul>
        <form class="d-flex d-md-inline">
          <ul class="navbar-nav me-auto" id="nav-right">
            <li class="nav-item" v-if="!isLogin">
              <router-link class="nav-link active left-padding-0" to="/login">登录</router-link>
            </li>
            <li class="nav-item" v-if="isLogin">
              <router-link class="nav-link active left-padding-0" to="/message">消息</router-link>
            </li>
            <li class="nav-item" v-if="isLogin">
              <a class="nav-link active" href="/article-editor-md" target="_blank">投稿</a>
            </li>
            <li class="nav-item" v-if="isLogin">
              <router-link class="nav-link active right-padding-0" :to="'/author/' + store.author.username">我的</router-link>
            </li>
          </ul>
        </form>
      </div>
    </div>
  </nav>
  <div class="container-fluid bbbb" style="padding-top: 10px; ">
    <router-view />
  </div>
</template>

<script setup>
import { computed } from 'vue'
import { useAuthorStore } from '@common/user';

const store = useAuthorStore();

let linkItemList = [
  { name: "📰文章", to: "/article", admin: false },
  { name: "🗨️聊天", to: "/chat", admin: false },
  { name: "👨‍🎓作者", to: "/author", admin: false },
  { name: "📒专题", to: "/subject", admin: false },
  { name: "🔍搜索", to: "/search", admin: false },
  { name: "🧙‍♂️管理", to: "/admin.html", admin: true, _blank: true }
]

let isLogin = computed(() => {
  return store.author.username != null && store.author.username != '' && store.author.username != undefined;
})

</script>

<style>
.m-r-5-px {
  margin-right: 5px
}

.date-color {
  color: rgb(0, 40, 90)
}

p {
  margin: 0px;
}


.right-padding-0 {
  padding-right: 0px !important;
}

.left-padding-0 {
  padding-left: 0px !important;
}
</style>