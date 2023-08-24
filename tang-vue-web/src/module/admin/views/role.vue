<template>
  <el-row>
    <el-col :span="14">
      <div style="margin: 10px">
        <el-input
          placeholder="名称/角色值/资源名/资源值"
          class="input-with-select"
          style="padding-bottom: 5px"
        >
          <template #prepend>
            <el-button >新增角色</el-button>
          </template>
          <template #append>
            <el-button>搜索</el-button>
          </template>
        </el-input>
        <el-table
          :data="roleList"
          highlight-current-row
          border
          max-height="400"
          style="width: 100%"
        >
          <el-table-column label="角色名">
            <template #default="scope">
              <div v-if="scope.$index == editIndex">
                <el-input v-model="scope.row.roleName" size="small" placeholder="请输入角色名" />
              </div>
              <div v-if="scope.$index != editIndex">
                {{scope.row.roleName}}
              </div>
            </template>
          </el-table-column>
          <el-table-column prop="roleValue" label="角色值" />
          <el-table-column prop="createTime" label="创建时间" />
          <el-table-column label="操作" width="250">
            <template #default="scope">
              <el-button size="small" @click="editIndex = scope.$index" v-if="editIndex != scope.$index">编辑</el-button>
              <el-button size="small" @click="editIndex = -1" v-if="editIndex == scope.$index">保存</el-button>
              <el-button size="small" @click="(dialogVisible = true),rowRoleClick(scope.row)">权限资源编辑</el-button>
              <el-button size="small" type="danger" @click="deleteResource(scope.row.resourceId)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </el-col>
    <el-col :span="10">
      <div style="margin: 10px">
        <el-input placeholder="" style="padding-bottom: 5px" disabled>
          <template #prepend>
            <el-button @click="saveResourceRoleList">保存角色</el-button>
          </template>
          <template #append>搜索</template>
        </el-input>
        <el-table
         @filter-change="filterTable"
          v-loading="loading"
          :data="resourceList"
          ref="multipleTable"
          border
          max-height="800"
          style="width: 100%">
          <el-table-column type="selection" width="40" />
          <el-table-column prop="name" label="名称" width="180"/>
          <el-table-column prop="path" label="路径" width="180"/>
          <el-table-column prop="type" label="类型" />
        </el-table>
      </div>
    </el-col>
  </el-row>
</template>

<script setup>
import request from "utils/request";
import { onMounted, ref } from "vue";

let multipleTable = ref()

let loading = ref(false);
let roleList = ref([]);
let resourceList = ref(null);
let selectRoleId = ref("");
let editIndex = ref(-1);




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
  request({
    url: `/api/admin/role`,
    method: "GET",
  }).then((res) => {
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