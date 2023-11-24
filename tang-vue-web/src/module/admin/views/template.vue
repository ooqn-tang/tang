<template>
  <n-tabs type="line" animated>
    <n-tab-pane name="code-list" tab="列表">
      Wonderwall
    </n-tab-pane>
    <n-tab-pane name="edit" tab="编辑">
      <Codemirror border :options="cmOptions"></Codemirror>
    </n-tab-pane>
  </n-tabs>
</template>
  
<script setup>
import { ref } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useAuthorStore } from "@common/user";
import Codemirror from 'codemirror-editor-vue3';

import "codemirror/addon/display/placeholder.js";
import "codemirror/mode/javascript/javascript.js";
import "codemirror/addon/display/placeholder.js";
import "codemirror/theme/dracula.css";
import "v-contextmenu/dist/themes/default.css";

import { NConfigProvider, NButton, NLayout, NLayoutHeader, NLayoutSider, NMenu, NIcon, NGrid, NGridItem, NSpace, NGi, NLayoutContent,NTabs,NTabPane } from "naive-ui";

let router = useRouter();
let route = useRoute();
let authorStore = useAuthorStore();

let cmOptions = ref({
  mode: "text/javascript", // Language mode
  theme: "dracula", // Theme
})

</script>

<style>
.codemirror-container {
  display: block !important;
}
</style>