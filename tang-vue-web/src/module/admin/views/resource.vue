<template>
  <n-space vertical>
    <n-space>
      <NButton type="primary" @click="loadResourceList">搜索</NButton>
      <NButton type="primary" @click="dialogVisible = true">添加资源</NButton>
      <NButton type="primary" @click="refresh">刷新请求状态</NButton>
    </n-space>
    <n-data-table :columns="columns" :data="resourceList" :bordered="true" />
  </n-space>
</template>

<script setup>
import request from "@common/request";
import { onMounted, ref } from "vue";
import { NButton, NSpace, NDataTable, NModal, NCard, NForm, NFormItem, NInput } from "naive-ui";


let dialogVisible = ref(false)
let resourceList = ref([])
let formData = ref({})
let queryData = ref("")

let columns = [{
  title: '资源名称',
  key: 'name'
}, {
  title: '资源路径',
  key: 'path'
}, {
  title: '请求类型',
  key: 'type'
}]

function refresh(){
  request({
    url: `/api/admin/resource/refresh`,
    method: "GET",
  }).then((res) => {
    loadResourceList()
  });
}

function handleEdit(row){
  formData.value = row
}

function handleClose(){
  dialogVisible.value = false
}

function loadResourceList(){
  request({
    url: `/api/admin/resource`,
    method: "GET",
    params: {
      query: queryData.value
    }
  }).then((res) => {
    resourceList.value = res.data;
  });
}

function updateResource(){
  request({
    url: `/api/admin/resource`,
    method: "PUT",
    data: formData.value,
  }).then((res) => {
    dialogVisible.value = false
    loadResourceList()
  });
}

function insertResource(){
  request({
    url: `/api/admin/resource`,
    method: "POST",
    data: formData.value,
  }).then((res) => {
    dialogVisible.value = false
    loadResourceList()
  });
}


onMounted(() => {
  loadResourceList()
})

</script>