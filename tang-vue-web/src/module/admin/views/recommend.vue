<template>
  <n-space vertical>
    <n-space>
      <n-button @click="insertDialogVisible = true">新增</n-button>
      <n-button :disabled="orderButton" @click="updateOrder">保存排序</n-button>
    </n-space>
    <n-data-table :columns="columns" :data="noticeList" :bordered="true" />
  </n-space>
  <n-modal v-model:show="insertDialogVisible" positive-text="确认" negative-text="算了" :mask-closable="true">
    <n-card :bordered="false" style="width: 800px" title="新增推荐" size="huge" role="dialog" aria-modal="true">
      <template #header-extra>
        <n-button type="tertiary" @click="insertDialogVisible = false">关闭</n-button>
      </template>
      <n-form ref="recommendFormRef" :model="recommendForm" :rules="recommendFormRules">
        <n-form-item path="title" label="标题">
          <n-input v-model:value="recommendForm.title" @keydown.enter.prevent />
        </n-form-item>
        <n-form-item path="url" label="路径">
          <n-input v-model:value="recommendForm.url" @keydown.enter.prevent />
        </n-form-item>
      </n-form>
      <template #footer>
        <n-space>
          <n-button type="tertiary" @click="insertNotice">确定</n-button>
          <n-button type="tertiary" @click="insertDialogVisible = false">取消</n-button>
        </n-space>
      </template>
    </n-card>
  </n-modal>
</template>

<script setup>
import request from "@common/request";
import { onMounted, ref, h } from "vue";
import { NButton, NSpace, NDataTable, NModal, NCard, NForm, NFormItem, NInput } from "naive-ui";
import { insertNoticeApi, deleteNoticeApi, updateOrderApi } from "@admin/apis/notice"

let insertDialogVisible = ref(false)
let noticeList = ref([])
let editIndex = ref(-1)
let orderButton = ref(true)
let recommendForm = ref({

})

let insertNotice = () => {
  insertNoticeApi(recommendForm.value).then((res) => {
    insertDialogVisible.value = false
    loadRecommend()
    recommendForm.value = {}
  });
}

let deleteNotice = (index, row) => {
  deleteNoticeApi(row.noticeId).then((res) => {
    noticeList.value.splice(index, 1)
  });
}

let updateOrder = () => {
  updateOrderApi(noticeList.value).then((res) => {
    orderButton.value = true
  });
}

let moveUpward = (index, row) => {
  if (index == 0) {
    return
  }
  let temp = noticeList.value[index - 1]
  noticeList.value[index - 1] = noticeList.value[index]
  noticeList.value[index] = temp
  orderButton.value = false
}

let moveDown = (index, row) => {
  if (index == noticeList.value.length - 1) {
    return
  }
  let temp = noticeList.value[index + 1]
  noticeList.value[index + 1] = noticeList.value[index]
  noticeList.value[index] = temp
  orderButton.value = false
}

let loadRecommend = () => {
  request({
    url: `/api/admin/notice`,
    method: "GET",
  }).then((res) => {
    noticeList.value = res.data
  });
}

let recommendFormRules = [
  {
    title: {
      required: true,
      message: '请再次输入密码',
      trigger: 'input'
    }
  },
  {
    url: {
      required: true,
      message: '请再次输入密码',
      trigger: 'input'
    }
  }
]

let columns = [{
  title: '标题',
  key: 'title'
},
{
  title: '路径',
  key: 'url'
},
{
  title: "Action",
  key: "actions",
  width: "250",
  render(row, index) {
    return [
      h(NSpace, [
        h(NButton, { strong: true, tertiary: true, size: "small", onClick: () => moveUpward(index, row) }, "上"),
        h(NButton, { strong: true, tertiary: true, size: "small", onClick: () => moveDown(index, row) }, "下"),
        h(NButton, { strong: true, tertiary: true, size: "small", type: "primary", onClick: () => play(index, row) }, "编辑"),
        h(NButton, { strong: true, tertiary: true, size: "small", type: "error", onClick: () => deleteNotice(index, row) }, "删除")
      ])
    ];
  }
}]

onMounted(() => {
  loadRecommend()
})

</script>