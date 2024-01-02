<template>
  <n-config-provider :theme-overrides="themeOverrides" style="height: 100%;position: relative">
    <n-message-provider>
      <n-layout position="absolute">
        <n-layout-header class="admin-nav" style="height: 50px; padding: 15px" bordered>
          <n-grid x-gap="12" :cols="3">
            <n-grid-item :span="2">
              <n-button text @click="isCollapse = !isCollapse" color="#ffffff">
                内容管理系统
              </n-button>
              <n-button text @click="isCollapse = !isCollapse" color="#ffffff" style="margin-left: 15px;">
                {{ isCollapse ? '展开' : '关闭' }}
              </n-button>
            </n-grid-item>
            <n-grid-item style="text-align: right;">
              <n-button text @click="logout" color="#ffffff">退出</n-button>
            </n-grid-item>
          </n-grid>
        </n-layout-header>
        <n-layout has-sider position="absolute" style="top: 50px;">
          <n-layout-sider bordered collapse-mode="width" :collapsed-width="54" :width="180" :collapsed="isCollapse"
            show-trigger @collapse="isCollapse = true" @expand="isCollapse = false">
            <n-menu @update:value="onChange" :collapsed="isCollapse" :collapsed-width="50" :collapsed-icon-size="22"
              :options="menuOptions" :render-label="renderMenuLabel" :render-icon="renderMenuIcon"
              :expand-icon="expandIcon" />
          </n-layout-sider>
          <n-layout content-style="padding: 10px;">
            <router-view />
          </n-layout>
        </n-layout>
      </n-layout>
    </n-message-provider>
  </n-config-provider>
</template>

<script setup>
import { useRoute, useRouter } from "vue-router";
import { useAuthorStore } from "@common/user";
import { h, onMounted, ref } from "vue";
import { NConfigProvider, NButton, NLayout, NLayoutHeader, NLayoutSider, NMenu, NIcon, NGrid, NGridItem, NSpace, NMessageProvider } from "naive-ui";
import { BookmarkOutline, CaretDownOutline } from "@vicons/ionicons5";


let router = useRouter();
let authorStore = useAuthorStore();

let isCollapse = ref(false);
let mList = ref([])

const menuOptions = ref([])
let onChange = (value) => {
  router.push({ name: value });
};

let logout = () => {
  localStorage.removeItem("jwt");
  localStorage.removeItem("author");
  window.location.href = "/";
};

const themeOverrides = {
  common: {
    primaryColor: "#3a94f1"
  }
}

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

onMounted(() => {
  let adminRouterList = router.getRoutes().filter((item) => { if (item.name == 'admin') { return item } })
  mList.value = adminRouterList[0].children;
  for (let item of mList.value) {
    if (item.mate.isM) {
      menuOptions.value.push({
        label: item.mate.name,
        key: item.mate.key,
        name: item.name
      })
    }
  }
});
</script>

<style scoped>
.active-but {
  border-bottom: 1px solid white;
  padding-bottom: 3px;
}

.float-end {
  float: right;
}

.n-menu-item-content {
  padding-left: 10px !important;
}

body {
  overflow-y: hidden !important;
}

.admin-nav {
  padding: 10px 20px;
  color: white;
  border-bottom: 1px solid #496fb0;
  background-color: #3a94f1;
}

.admin-main {
  display: flex;
}

.admin-body {
  padding: 10px;
  width: 100%;
  float: right;
  overflow-y: auto;
  height: 100%;
}
</style>

<style>
.n-menu-item-content {
  padding-left: 15px !important;
}

.n-menu-item-content__icon {
  font-size: 22px !important;
}

body {
  overflow-y: hidden !important;
}
</style>