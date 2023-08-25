<template>
  <el-row>
    <el-col :span="16">
      <div style="margin:10px;">
        <el-input
          v-model="queryData"
          placeholder="用户名/昵称/邮箱/IP"
          class="input-with-select"
          style="padding-bottom: 5px;"
        >
          <template #append>
            <el-button @click="selectAuthor()">搜索</el-button>
          </template>
        </el-input>
        <el-table 
        :data="authorList" 
        highlight-current-row 
        @row-click="rowAuthorClick"
        max-height="800"
        border 
        style="width: 100%;">
          <el-table-column prop="username" label="用户名" width="150" />
          <el-table-column prop="nickname" label="昵称" width="150" />
          <el-table-column prop="mail" label="邮箱" />
          <el-table-column prop="address" label="操作"  width="135">
            <template #default="scope">
              <el-button size="small" @click="handleEdit(scope.$index, scope.row), (dialogVisible = true)" >编辑</el-button>
              <el-button size="small" type="danger" @click="deleteAuthor(scope.row.authorId)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </el-col>
    <el-col :span="8">
      <div style="margin:10px;">
        <el-input v-model="input2" placeholder="" disabled  style="padding-bottom: 5px;">
            <template #prepend>
              <el-button @click="saveAuthorRole">保存权限</el-button>
            </template>
            <template #append>搜索</template>
          </el-input>
        <el-table :data="roleList" ref="multipleTable" @selection-change="checkRole" max-height="800" border style="width: 100%;">
          <el-table-column type="selection" width="40" />
          <el-table-column prop="roleName" label="名称" />
        </el-table></div
    ></el-col>
  </el-row>
</template>

<script setup>
import request from "utils/request";
import { ElMessage } from "element-plus";
import { onMounted,ref } from "vue";

const dialogVisible = ref(false);
const form = ref({});
const input2 = ref("");
const authorList = ref([]);
const roleIdList = ref([]);
const roleList = ref([]);
const queryData = ref("");
const selectAuthorId = ref("");
const roleForm = ref([]);

const checkRole = (selection, row) => {
  roleForm.value = selection;
};

const saveAuthorRole = () => {
  request({
    url: `api/admin/role/author/${selectAuthorId.value}`,
    method: "POST",
    data:roleForm.value
  }).then((res) => {
    roleIdList.value = res.data;
    ElMessage({
      type: 'success',
      message: '删除成功',
    })
  });
};

const rowAuthorClick = (row, column, event) => {
  selectAuthorId.value = row.authorId
  selectRole(row);
};

const selectRole = (row) => {
  request({
    url: `api/admin/role`,
    method: "GET",
  }).then((res) => {
    roleList.value = res.data;
    request({
      url: `api/admin/role/author/${row.authorId}`,
      method: "GET",
    }).then((res) => {
      roleIdList.value = res.data;
    });
  });
};

const selectAuthor = () => {
  request({
    url: `/api/admin/author`,
    method: "GET",
    params: {
      queryData: queryData.value,
    },
  }).then((res) => {
    authorList.value = res.data;
  });
};

const deleteAuthor = (authorId) => {
  request({
    url: `/api/admin/author/${authorId}`,
    method: "DELETE",
  }).then((res) => {
    selectAuthor();
    ElMessage({
      type: 'success',
      message: '删除成功',
    })
  });
};

const handleEdit = (index, row) => {
  form.value = row;
};

const handleDelete = (index, row) => {
  request({
    url: `/api/admin/author/${row.authorId}`,
    method: "DELETE",
  }).then((res) => {
    selectAuthor();
    ElMessage({
      type: 'success',
      message: '删除成功',
    })
  });
};

const handleCreate = () => {
  form.value = {};
  dialogVisible.value = true;
};

const handleSave = () => {
  request({
    url: `/api/admin/author`,
    method: "POST",
    data: form.value,
  }).then((res) => {
    selectAuthor();
    dialogVisible.value = false;
    ElMessage({
      type: 'success',
      message: '保存成功',
    })
  });
};

const handleUpdate = () => {
  request({
    url: `/api/admin/author`,
    method: "PUT",
    data: form.value,
  }).then((res) => {
    selectAuthor();
    dialogVisible.value = false;
    ElMessage({
      type: 'success',
      message: '保存成功',
    })
  });
};

const handleQuery = () => {
  selectAuthor();
};

onMounted(() => {
  selectAuthor();
});

</script>