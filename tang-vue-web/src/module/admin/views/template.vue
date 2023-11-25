<template>
  <n-layout has-sider style="width: 100%;height: 100%;">
    <n-layout-sider>
      <n-tabs type="line" animated>
        <n-tab-pane name="列表" tab="列表">
          Wonderwall
        </n-tab-pane>
        <n-tab-pane name="编辑" tab="编辑">
          Hey Jude
        </n-tab-pane>
        <n-tab-pane name="Ai" tab="Ai Coding">
          Hey Jude
        </n-tab-pane>
      </n-tabs>
    </n-layout-sider>
    <n-layout-content>
      <!--  -->
      <n-tabs style="height:calc(100% )" v-model:value="valueRef" type="card" :addable="addableRef" :closable="closable"
        tab-style="min-width: 100px;" @close="handleClose" @add="handleAdd">
        <n-tab-pane v-for="panel in panelsRef" :key="panel" :name="panel" style="height: calc(100% - 45px) !important;">
          <Codemirror border :options="cmOptions" ></Codemirror>
        </n-tab-pane>
      </n-tabs>
    </n-layout-content>
  </n-layout>
</template>
  
<script setup>
import { ref, computed, h } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useAuthorStore } from "@common/user";
import Codemirror from 'codemirror-editor-vue3';

import "codemirror/addon/display/placeholder.js";
import "codemirror/mode/javascript/javascript.js";
import "codemirror/addon/display/placeholder.js";
import "codemirror/theme/dracula.css";
import "v-contextmenu/dist/themes/default.css";

import { NConfigProvider, NButton, NLayout, NLayoutHeader, NLayoutSider, NTag, NMenu, NIcon, NGrid, NGridItem, NSpace, NGi, NLayoutContent, NTabs, NTabPane } from "naive-ui";

let router = useRouter();
let route = useRoute();
let authorStore = useAuthorStore();

let cmOptions = ref({
  mode: "text/javascript", // Language mode
  theme: "dracula", // Theme
})

const valueRef = ref(1);
const panelsRef = ref([1, 2, 3, 4, 5]);
const addableRef = computed(() => {
  return {
    disabled: panelsRef.value.length >= 100
  };
});
const closableRef = computed(() => {
  return panelsRef.value.length > 1;
});

function handleAdd() {
  const newValue = Math.max(...panelsRef.value) + 1;
  panelsRef.value.push(newValue);
  valueRef.value = newValue;
}
function handleClose(name) {
  const { value: panels } = panelsRef;
  const nameIndex = panels.findIndex((panelName) => panelName === name);
  if (!~nameIndex)
    return;
  panels.splice(nameIndex, 1);
  if (name === valueRef.value) {
    valueRef.value = panels[Math.min(nameIndex, panels.length - 1)];
  }
}

</script>

<style>
.codemirror-container {
  display: block !important;
}

.CodeMirror-hscrollbar {
  left: 0 !important;
}
</style>