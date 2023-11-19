<template>
  <n-space vertical>
    <n-form ref="formRef" inline :label-width="80" :model="formValue" :rules="rules" :size="size">
      <n-form-item label="电话号码" path="phone">
        <n-input v-model:value="formValue.phone" placeholder="电话号码" />
      </n-form-item>
      <n-form-item>
        <n-button attr-type="button" @click="handleValidateClick">
          验证
        </n-button>
      </n-form-item>
    </n-form>
  </n-space>
  <n-data-table :columns="columns" :data="articleList" :pagination="pagination" :bordered="true" />
</template>
  
<script setup>
import { onMounted, ref, h } from "vue";
import { NDataTable, NButton, NForm, NFormItem, NInput, NSpace, NButtonGroup } from "naive-ui"
import { deleteArticleApi, loadArticleApi } from "@apis/article"

let articleList = ref([]);
let formRef = ref({})
let formValue = ref({})
let rules = ref({
  phone: {
    required: true,
    message: "请输入姓名",
    trigger: "blur"
  }
})

let columns = [{
  title: "标题",
  key: "title"
},
{
  title: "时间",
  key: "createTime"
},
{
  title: "作者",
  key: "author.nickname"
},
{
  title: '操作',
  key: 'actions',
  width: "250",
  render(row, index) {
    return [
      h(NButton, { size: 'small', onClick: () => sendMail(row) }, { default: () => '查看' }),
      h(NButton, { size: 'small', onClick: () => deleteArticle(index, row) }, { default: () => '删除' })
    ]
  }
}]

let deleteArticle = (index, row) => {
  deleteArticleApi(row.articleId).then((res) => {
    articleList.value.splice(index, 1)
  });
}

let loadArticle = () => {
  loadArticleApi().then((res) => {
    articleList.value = res.data.content
  });
}

onMounted(() => {
  loadArticle()
})

let handleValidateClick = () => {
  formRef.value.validate();
}
</script>