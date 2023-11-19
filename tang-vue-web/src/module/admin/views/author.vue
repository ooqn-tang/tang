<template>
  <n-space vertical>
    <n-space>
      <NButton type="primary" @click="handleCreate">添加</NButton>
      <NButton type="primary" @click="handleUpdate">保存</NButton>
      <NButton type="primary" @click="handleQuery">查询</NButton>
    </n-space>
    <n-data-table :columns="columns" :data="authorList" :pagination="pagination" :bordered="true"/>
  </n-space>
</template>

<script setup>
import request from "@utils/request";
import { onMounted,ref,h } from "vue";
import { NButton, NSpace, NDataTable } from "naive-ui";

const dialogVisible = ref(false);
const form = ref({});
const authorList = ref([]);
const columns = [{
  title: "用户名",
  key: "username"
},
{
  title: "昵称",
  key: "nickname"
},
{
  title: "邮箱",
  key: "mail"
},
{
  title: '操作',
  key: 'actions',
  width: "250",
  render(row) {
    return h(
      NButton, {
      size: 'small',
      onClick: () => sendMail(row)
    }, {
      default: () => '查看'
    }
    )
  }
}]
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
  });
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
    // ElMessage({      type: 'success',      message: '删除成功',    })
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
    // ElMessage({      type: 'success',      message: '删除成功',    })
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
    // ElMessage({      type: 'success',      message: '保存成功',    })
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
    // ElMessage({      type: 'success',      message: '保存成功',    })
  });
};

const handleQuery = () => {
  selectAuthor();
};

onMounted(() => {
  selectAuthor();
});

</script>