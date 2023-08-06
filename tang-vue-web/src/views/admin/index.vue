<template>
  <div class="admin-nav">
    <span @click="isCollapse = !isCollapse">
      <el-button type="primary" round>内容管理系统</el-button>
      <el-button type="primary" round v-if="isCollapse">展开</el-button>
      <el-button type="primary" round v-if="!isCollapse">收起</el-button>
    </span>
    <span class="float-end">
      <el-button type="primary" round>{{$store.state.author.nickname}}</el-button>
      <el-button type="primary" round @click="logout">退出</el-button>
    </span>
  </div>
<div class="admin-main">
  <el-menu :default-active="routeName" class="el-menu-vertical-demo" :collapse="isCollapse" @open="handleOpen" @close="handleClose">
    <el-menu-item index="admin_article" @click="$router.push({name:'admin_article'})">
      <el-icon><document /></el-icon>
      <template #title>文章</template>
    </el-menu-item>
    <el-menu-item index="admin_recommend" @click="$router.push({name:'admin_recommend'})">
      <el-icon><document /></el-icon>
      <template #title>推荐</template>
    </el-menu-item>
    <el-menu-item index="admin_author"  @click="$router.push({name:'admin_author'})">
      <el-icon><document /></el-icon>
      <template #title>用户</template>
    </el-menu-item>
     <el-menu-item index="admin_role" @click="$router.push({name:'admin_role'})">
      <el-icon><document /></el-icon>
      <template #title>角色</template>
    </el-menu-item>
    <el-menu-item index="admin_resource" @click="$router.push({name:'admin_resource'})">
      <el-icon><document /></el-icon>
      <template #title>资源</template>
    </el-menu-item>
    <el-menu-item index="6" @click="$router.push({path:'/'})">
      <el-icon><setting /></el-icon>
      <template #title>门户</template>
    </el-menu-item>
</el-menu>
<div class="admin-body">
  <router-view/>
</div>
</div>

  
</template>

<script setup>
import request from "utils/request";
import { useRouter, useRoute } from "vue-router";
import { useStore } from "vuex";
import { onMounted,ref,watch } from "vue";
import { ElButton } from "element-plus";

let router = useRouter();
let route = useRoute();
let store = useStore();

let routeName = ref("admin_article");
let activeIndex = ref("admin_article");
let isCollapse = ref(false);


let logout = () => {
  localStorage.removeItem("jwt");
  localStorage.removeItem("author");
  store.state.username = "";
  window.location.href = "/";
};

onMounted(() => {
  
});

watch(route, (to, from) => {
  routeName.value = to.name;
  activeIndex.value = to.name;
});

</script>

<style scoped>

body{
  overflow-y: hidden !important;
}
.el-menu-item {
   font-size: 15px;
}
.el-menu .is-active {
    font-size: 15px;
    background: rgb(238, 238, 238);
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}
.admin-nav{
  background-color: #3a94f1;padding: 10px 20px;color: white;
}
.admin-main{
  display: flex;height: calc(100% - 52px);
}
.admin-body{
  padding:10px;width:100%;float:right;overflow-y: scroll;height: 100%;
}
</style>