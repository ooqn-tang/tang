<template>
  <el-input
    v-model="queryData"
    class="w-50 m-2"
    placeholder="Pick a date"
    style="width: 200px !important"
    :suffix-icon="Calendar"
  />
  <el-button @click="loadResourceList">搜索</el-button>
  <el-button @click="dialogVisible = true">添加资源</el-button>
  <el-button @click="refresh">刷新请求状态</el-button>
  <el-table
    ref="tableRef"
    row-key="name"
    :data="resourceList"
    style="width: 100%"
  >
    <el-table-column prop="name" label="资源名" width="180" />
    <el-table-column prop="path" label="路径" width="400" />
    <el-table-column prop="type" label="类型">
      <template #default="scope">
        <el-tag v-if="scope.row.type == 'GET'" class="mx-1">GET</el-tag>
        <el-tag v-if="scope.row.type == 'POST'" class="ml-2 mx-1" type="success">POST</el-tag>
        <el-tag v-if="scope.row.type == 'PUT'" class="ml-2 mx-1" type="warning">PUT</el-tag>
        <el-tag v-if="scope.row.type == 'DELETE'" class="ml-2 mx-1" type="danger">DELETE</el-tag>
        <el-tag v-if="scope.row.type == 'MENU'" class="ml-2 mx-1" type="info">菜单</el-tag>
      </template> 
    </el-table-column>
    <el-table-column label="状态" width="400">
      <template #default="scope">
        <el-tag
          :type="scope.row.state == 8 ? 'success' : 'danger'"
          disable-transitions
          >{{ scope.row.state == 8 ? '系统中存在' : '系统中不存在的资源' }}</el-tag>
      </template>
    </el-table-column>
    <el-table-column prop="tag" label="" align="right">
      <template #default="scope">
        <el-button size="small" @click="handleEdit(scope.row),dialogVisible = true">编辑</el-button>
        <el-button size="small" type="danger" @click="deleteResource(scope.row.resourceId)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>

  <el-dialog
    v-model="dialogVisible"
    title="Tips"
    width="60%"
   
    :before-close="handleClose">
    <el-form ref="formRef" :model="formData" label-width="120px">
      <el-form-item label="资源名称">
        <el-input v-model="formData.name"></el-input>
      </el-form-item>
      <el-form-item label="资源路径">
        <el-input v-model="formData.path"></el-input>
      </el-form-item>
      <el-form-item label="请求类型">
        <el-select v-model="formData.type" placeholder="请求类型" style="width:100%">
          <el-option label="GET" value="GET"></el-option>
          <el-option label="POST" value="POST"></el-option>
          <el-option label="PUT" value="PUT"></el-option>
          <el-option label="DELETE" value="DELETE"></el-option>
          <el-option label="菜单" value="MENU"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="描述">
        <el-input v-model="formData.desc" type="textarea"></el-input>
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="insertResource">保存</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script setup>
import { ElMessage, ElMessageBox } from "element-plus";
import request from "utils/request";
import { onMounted, ref } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useStore } from "vuex";

let router = useRouter();
let store = useStore();
let route = useRoute();

let dialogVisible = ref(false)
let resourceList = ref([])
let formData = ref({})
let queryData = ref("")

let refresh = () => {
  request({
    url: `/api/admin/resource/refresh`,
    method: "GET",
  }).then((response) => {
    loadResourceList()
  });
}

let handleEdit = (row) => {
  formData.value = row
}

let handleClose = () => {
  dialogVisible.value = false
}

let loadResourceList = () => {
  request({
    url: `/api/admin/resource`,
    method: "GET",
    params: {
      query: queryData.value
    }
  }).then((response) => {
    resourceList.value = response.data;
  });
}

let insertResource = () => {
  request({
    url: `/api/admin/resource`,
    method: "POST",
    data: formData.value,
  }).then((response) => {
    ElMessage.success("保存成功");
    dialogVisible.value = false
    loadResourceList()
  });
}

let deleteResource = (id) => {
  ElMessageBox.confirm("此操作将永久删除该资源, 是否继续?", "提示", {
    confirmButtonText: "确定",
    cancelButtonText: "取消",
    type: "warning",
  })
    .then(() => {
      request({
        url: `/api/admin/resource/${id}`,
        method: "DELETE",
      }).then((response) => {
        ElMessage.success("删除成功");
        loadResourceList()
      });
    })
    .catch(() => {
      ElMessage.info("已取消删除");
    });
}

onMounted(() => {
  loadResourceList()
})

</script>