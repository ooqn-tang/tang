<template>
  <n-space vertical>
    <n-space>
      <NButton type="primary" @click="handleCreate">添加</NButton>
      <NButton type="primary" @click="handleUpdate">保存</NButton>
      <NButton type="primary" @click="handleQuery">查询</NButton>
    </n-space>
    <n-data-table :columns="columns" :data="roleList" :bordered="true"/>
  </n-space>
</template>

<script setup>
import request from "@common/request";
import { onMounted, ref } from "vue";
import { NButton, NSpace, NDataTable, NModal, NCard, NForm, NFormItem, NInput } from "naive-ui";
import { getRoles } from "@apis/role";

let multipleTable = ref()

let loading = ref(false);
let roleList = ref([]);
let resourceList = ref(null);
let selectRoleId = ref("");
let editIndex = ref(-1);

let columns = [{
  title:"角色名",
  key:"roleName"
},{
  title:"角色值",
  key:"roleValue"
}]


function filterTable(item){
  console.log(item)
}

function saveResourceRoleList(){
  let selectResource = []
  // 向selectResource追加数组
  selectResource.push(...multipleTable.value.getSelectionRows())

  multipleTable.value.data.forEach((item) => {
    if (item._checked) {
      console.log(item);
      selectResource.push(item)
    }
  });
  request({
    url: `/api/admin/role/resource/${selectRoleId.value}`,
    method: "POST",
    data: selectResource,
  }).then((res) => {
    alert("添加成功");
  });
};

let rowRoleClick = (row) => {
  selectRoleId.value = row.roleId;
  selectResource(row);
};

let selectRole = () => {
  loading.value = true;
  getRoles().then((res) => {
    loading.value = false;
    roleList.value = res.data;
  });
};

let selectResource = (row) => {
  multipleTable.value.clearSelection();
  loading.value = true;
  request({
    url: `/api/admin/role/resource/${row.roleId}`,
    method: "GET",
  }).then((res) => {
    loading.value = false;
    res.data.forEach((item) => {
      resourceList.value.forEach((res) => {
        if (item.resourceId == res.resourceId) {
          multipleTable.value.toggleRowSelection(res);
        }
      });
    });
  });
};

let deleteResource = (resourceId) => {
  request({
    url: `/api/admin/role/resource/${resourceId}`,
    method: "DELETE",
  }).then((res) => {
    alert("删除成功");
  });
};

function loadAllResource() {
  request({
    url: `/api/admin/resource`,
    method: "GET",
  }).then((res) => {
    resourceList.value = res.data;
  });
}


onMounted(() => {
  selectRole();
  loadAllResource();
});


</script>