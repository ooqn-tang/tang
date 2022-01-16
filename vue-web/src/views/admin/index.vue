<template>
  <el-menu
    :default-active="activeIndex"
    mode="horizontal"
    background-color="#545c64"
    text-color="#fff"
    active-text-color="#ffd04b"
    @select="handleSelect"
  >
    <el-menu-item index="admin_article" @click="$router.push({name:'admin_article'})">博客管理</el-menu-item>
    <el-menu-item index="admin_author"  @click="$router.push({name:'admin_author'})">用户管理</el-menu-item>
    <el-menu-item index="admin_role"  @click="$router.push({name:'admin_role'})">角色管理</el-menu-item>
    <el-menu-item index="admin_resource"  @click="$router.push({name:'admin_resource'})">资源管理</el-menu-item>
    <el-menu-item index="5" @click="$router.push({path:'/'})">关闭</el-menu-item>
  </el-menu>
  <div style="padding:10px">
    <router-view/>
  </div>
  
 
  
</template>

<script>
import "element-plus/dist/index.css";
import { ElButton } from "element-plus";
import request from "src/utils/request";
export default {
  name: "admin",
  data() {
    return {
      routeName: this.$route.name,
      activeIndex: this.$route.name
    };
  },
  components: { ElButton },
  watch: {
    $route(to, from) {
      this.routeName = this.$route.name;
    },
  },
  created() {},
  methods: {},
  mounted() {},
};
</script>

<style scoped lang="scss">
</style>