<template>
  <div class="admin-nav">
    <span>
      <el-button type="primary" round>内容管理系统</el-button>
      <el-button type="primary" round v-if="isCollapse" @click="isCollapse = !isCollapse">展开</el-button>
      <el-button type="primary" round v-if="!isCollapse" @click="isCollapse = !isCollapse">收起</el-button>
    </span>
    <span class="float-end">
      <el-button type="primary" round>{{$store.state.author.nickname}}</el-button>
      <el-button type="primary" round @click="logout">退出</el-button>
    </span>
  </div>
<div class="admin-main">
  <el-menu default-active="0" class="el-menu-vertical-demo" :collapse="isCollapse">
    <div>
      <template v-for="(item, index) in mList" >
        <el-menu-item :index="index+'-'" @click="openMenu(item)">
          <el-icon><document /></el-icon>
          <template #title>{{ item.mate.name }}</template>
        </el-menu-item>
      </template>
    </div>
    
</el-menu>
<div class="admin-body">
  <router-view/>
</div>
</div>

  
</template>

<script setup>
import { useRoute,useRouter } from "vue-router";
import { useStore } from "vuex";
import { onMounted,ref,watch } from "vue";
import { ElButton, radioGroupEmits } from "element-plus";
import "element-plus/dist/index.css"

let route = useRoute();
let router = useRouter();
let store = useStore();

let isCollapse = ref(false);
let mList = ref([])


let logout = () => {
  localStorage.removeItem("jwt");
  localStorage.removeItem("author");
  store.state.username = "";
  window.location.href = "/";
};

onMounted(() => {
  let adminRouterList = router.getRoutes().filter((item)=>{if(item.name == 'admin'){return item}})
  mList.value = adminRouterList[0].children;
});

watch(route, (to, from) => {

});

let openMenu = (item) => {
  router.push({name:item.name})
}

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

  /*隐藏文字*/
  .el-menu--collapse  .el-submenu__title span{
    display: none;
  }
  /*隐藏 > */
  .el-menu--collapse  .el-submenu__title .el-submenu__icon-arrow{
    display: none;
  }
</style>
