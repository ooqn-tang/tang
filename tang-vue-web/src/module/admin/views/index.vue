<template>
  <div class="admin-nav">
    <div>
      <n-button type="info" round @click="isCollapse = !isCollapse">内容管理系统</n-button>
      <n-button round @click="logout" type="info" style="float:right">退出</n-button>
    </div>
  </div>
  <n-layout has-sider style="height: calc(100% - 54px)">
    <n-layout-sider bordered collapse-mode="width" :collapsed-width="50" :width="180" :collapsed="isCollapse" show-trigger @collapse="isCollapse = true" @expand="isCollapse = false">
      <n-menu @update:value="onChange" :collapsed="isCollapse" :collapsed-width="50" :collapsed-icon-size="22" :options="menuOptions" :render-label="renderMenuLabel" :render-icon="renderMenuIcon" :expand-icon="expandIcon" />
    </n-layout-sider>
    <n-layout style="padding:5px">
      <router-view/>
    </n-layout>
  </n-layout>
</template>

<script setup>
import { useRoute, useRouter } from "vue-router";
import { useStore } from "vuex";
import { h,onMounted, ref, watch } from "vue";
import { NButton, NSpace, NLayout, NLayoutSider, NMenu,NIcon  } from "naive-ui";
import "element-plus/dist/index.css"
import { BookmarkOutline, CaretDownOutline } from "@vicons/ionicons5";

let route = useRoute();
let router = useRouter();
let store = useStore();

let isCollapse = ref(false);
let mList = ref([])

let onChange = (value) => {
  router.push({ name: value });
};

let logout = () => {
  localStorage.removeItem("jwt");
  localStorage.removeItem("author");
  store.state.username = "";
  window.location.href = "/";
};

onMounted(() => {
  let adminRouterList = router.getRoutes().filter((item) => { if (item.name == 'admin') { return item } })

  mList.value = adminRouterList[0].children;

  for(let item of mList.value){
    if(item.mate.isM){
      menuOptions.value.push({
        label: item.mate.name,
        key: item.mate.key,
        name: item.name
      })
    }
  }
  
});

watch(route, (to, from) => {

});

let openMenu = (item) => {
  router.push({ name: item.name })
}

const menuOptions = ref([
  // {
  //   label: "且听风吟",
  //   key: "hear-the-wind-sing",
  //   href: "https://baike.baidu.com/item/%E4%B8%94%E5%90%AC%E9%A3%8E%E5%90%9F/3199"
  // },
  // {
  //   label: "寻羊冒险记",
  //   key: "a-wild-sheep-chase",
  //   disabled: true
  // }
]);


let renderMenuLabel = (option) => {
  if ("href" in option) {
    return h(
      "a",
      { href: option.href, target: "_blank" },
      option.label
    );
  }
  return option.label;
}
 let renderMenuIcon = (option) => {
  if (option.key === "sheep-man")
    return true;
  if (option.key === "food")
    return null;
  return h(NIcon, null, { default: () => h(BookmarkOutline) });
}
let expandIcon = () => {
  return h(NIcon, null, { default: () => h(CaretDownOutline) });
}

</script>


<style scoped>
.float-end {
  float: right;
}

.n-menu-item-content{
  padding-left: 10px !important;
}

body {
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

.admin-nav {
  background-color: #3a94f1;
  padding: 10px 20px;
  color: white;
}

.admin-main {
  display: flex;
  height: calc(100% - 52px);
}

.admin-body {
  padding: 10px;
  width: 100%;
  float: right;
  overflow-y: auto;
  height: 100%;
}

/*隐藏文字*/
.el-menu--collapse .el-submenu__title span {
  display: none;
}

/*隐藏 > */
.el-menu--collapse .el-submenu__title .el-submenu__icon-arrow {
  display: none;
}
</style>

<style>
  .n-menu-item-content{
    padding-left: 15px !important;
  }
</style>