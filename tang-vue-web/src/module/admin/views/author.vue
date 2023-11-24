<template>
  <n-space vertical>
    <n-space>
      <NButton type="primary" @click="handleCreate">添加</NButton>
      <NButton type="primary" @click="handleUpdate">保存</NButton>
      <NButton type="primary" @click="handleQuery">查询</NButton>
    </n-space>
    <n-data-table :columns="columns" :data="authorList" :bordered="true"/>
  </n-space>
</template>

<script setup>
import request from "@common/request";
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

const queryData = ref("");

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

const handleCreate = () => {
  form.value = {};
  dialogVisible.value = true;
};

const handleUpdate = () => {
  request({
    url: `/api/admin/author`,
    method: "PUT",
    data: form.value,
  }).then((res) => {
    selectAuthor();
    dialogVisible.value = false;
  });
};

const handleQuery = () => {
  selectAuthor();
};

onMounted(() => {
  selectAuthor();
});

</script>