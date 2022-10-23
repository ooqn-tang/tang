<template>
  <div style="background-color: #3a94f1;padding:10px">
    <span style="padding: 10px;color:white;font-weight: bold;font-size:20px">内容管理系统</span>
    
    <span style="float:right;color:white;font-weight: bold;font-size:20px;">
      <span>{{$store.state.author.nickname}}</span>
      &nbsp;
      <span @click="logout">退出</span>
    </span>
  </div>

<el-menu :default-active="routeName" style="width: 70px;float:left;height: calc(100% - 50px);" @close="handleClose">
    <el-menu-item index="admin_article" @click="$router.push({name:'admin_article'})">
      <template #title>文章</template>
    </el-menu-item>
    <el-menu-item index="admin_recommend" @click="$router.push({name:'admin_recommend'})">
      <template #title>推荐</template>
    </el-menu-item>
    <el-menu-item index="admin_author"  @click="$router.push({name:'admin_author'})">
      <template #title>用户</template>
    </el-menu-item>
     <el-menu-item index="admin_role" @click="$router.push({name:'admin_role'})">
      <template #title>角色</template>
    </el-menu-item>
    <el-menu-item index="admin_resource" @click="$router.push({name:'admin_resource'})">
      <template #title>资源</template>
    </el-menu-item>
    <el-menu-item index="6" @click="$router.push({path:'/'})">
      <template #title>门户</template>
    </el-menu-item>
  </el-menu>
  <div style="padding:10px;width: calc(100% - 70px);float:right;overflow-y: scroll;height: calc(100% - 50px);">
    <router-view/>
  </div>
  
</template>

<script>
import request from "utils/request";
export default {
  name: "admin_recommend",
  data() {
    return {
      routeName: this.$route.name,
      activeIndex: this.$route.name
    };
  },
  watch: {
    $route(to, from) {
      this.routeName = this.$route.name;
    },
  },
  created() {},
  methods: {
    logout() {
      localStorage.removeItem("jwt");
      localStorage.removeItem("author");
      this.$store.state.username = "";
      window.location.href = "/";
    }
  },
  mounted() {
    
  },
};
</script>

<style scoped>

body{
  overflow-y: hidden !important;
}
.el-menu-item {
  font-weight: bold;
  font-size: 15px;
}
.el-menu .is-active {
  font-weight: bold;
    font-size: 15px;
    background: rgb(238, 238, 238);
}
</style>