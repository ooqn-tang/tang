<template>
  <div style="background-color: #3a94f1;padding:10px">
    <span style="padding: 10px;color:white;font-weight: bold;font-size:26px">视频管理</span>
    <span style="color:white;font-weight: bold;font-size:26px;float:right;padding-left:20px">退出登录</span>
    <span style="color:white;font-weight: bold;font-size:26px;float:right">{{author.nickname}}</span>
  </div>

<el-menu :default-active="routeName" style="width: 150px;float:left;height: calc(100% - 60px);" @close="handleClose">
    <el-menu-item index="admin_video" @click="$router.push({name:'admin_video'})">
      <template #title>视频管理</template>
    </el-menu-item>
    <el-menu-item index="admin_recommend" @click="$router.push({name:'admin_recommend'})">
      <template #title>推荐内容</template>
    </el-menu-item>
    <el-menu-item index="admin_author"  @click="$router.push({name:'admin_author'})">
      <template #title>用户管理</template>
    </el-menu-item>
     <el-menu-item index="admin_role" @click="$router.push({name:'admin_role'})">
      <template #title>角色管理</template>
    </el-menu-item>
    <el-menu-item index="admin_resource" @click="$router.push({name:'admin_resource'})">
      <template #title>资源管理</template>
    </el-menu-item>
    <el-menu-item index="6" @click="$router.push({path:'/'})">
      <template #title>关闭</template>
    </el-menu-item>
    
  </el-menu>

  <div style="padding:10px;width: calc(100% - 150px);float:right;overflow-y: scroll;height: calc(100% - 60px);">
    <router-view/>
  </div>
  
 
  
</template>

<script>
import "element-plus/dist/index.css";
import { ElButton } from "element-plus";
import request from "src/utils/request";
export default {
  name: "admin_recommend",
  data() {
    return {
      routeName: this.$route.name,
      activeIndex: this.$route.name,
      author:{}
    };
  },
  components: { ElButton },
  watch: {
    $route(to, from) {
      this.routeName = this.$route.name;
    },
  },
  created() {},
  methods: {
    selectAuthor(username){
      request({
        url: '/api/author/' + username,
        method: 'GET'
      }).then((response) => {
        this.author = response.data
      })
    },
  },
  mounted() {
    this.selectAuthor(this.$store.state.username)
  },
};
</script>

<style scoped lang="scss">
.el-menu .is-active{
  font-weight: bold;
  font-size: 18px;
}
</style>