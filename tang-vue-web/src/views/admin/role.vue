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
            <el-button>新增角色</el-button>
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
            <el-button @click="saveResourceRole">保存角色</el-button>
          </template>
          <template #append>搜索</template>
        </el-input>
        <el-table
          v-loading="loading"
          :data="resourceList"
          ref="multipleTable"
          @selection-change="checkResource"
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
import { onMounted, reactive, ref, watch } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useStore } from "vuex";

let router = useRouter();
let route = useRoute();
let store = useStore();

let loading = ref(false);
let routeName = ref(route.name);
let formInline = reactive({ user: "" });
let roleList = ref([]);
let resourceList = ref(null);
let resourceIdList = ref(null);
let selectRoleId = ref("");
let resourceForm = ref([]);
let editIndex = ref(-1);

let checkResource = (selection, row) => {
  resourceForm.value = selection;
};

let saveResourceRole = () => {
  request({
    url: `/api/admin/role/resource/${selectRoleId.value}`,
    method: "POST",
    data: resourceForm.value,
  }).then((response) => {
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
  }).then((response) => {
    loading.value = false;
    roleList.value = response.data;
  });
};

let selectResource = (row) => {
  loading.value = true;
  request({
    url: `/api/admin/role/resource/${row.roleId}`,
    method: "GET",
  }).then((response) => {
    loading.value = false;
    resourceList.value = response.data;
    resourceIdList.value = response.data.map((item) => item.resourceId);
  });
};

let deleteResource = (resourceId) => {
  request({
    url: `/api/admin/role/resource/${resourceId}`,
    method: "DELETE",
  }).then((response) => {
    alert("删除成功");
  });
};


onMounted(() => {
  selectRole();
});


watch(resourceIdList, () => {
  for (let index in resourceList.value) {
    if (resourceIdList.value.indexOf(resourceList.value[index].resourceId) > -1) {
      $refs.multipleTable.toggleRowSelection(resourceList.value[index]);
    }
  }
});

</script>