<template>
    <n-space vertical>
      <n-form ref="formRef" inline :label-width="80" :model="formValue" :rules="rules" :size="size">
        <n-form-item label="名称" path="phone">
          <n-input v-model:value="formValue.phone" placeholder="名称" />
        </n-form-item>
        <n-form-item>
          <n-button attr-type="button" @click="handleValidateClick">
            搜索
          </n-button>
        </n-form-item>
        <n-form-item>
          <n-button attr-type="button" @click="insertTemplate">
            增加
          </n-button>
        </n-form-item>
      </n-form>
    </n-space>
    <n-data-table :columns="columns" :data="templateList" :bordered="true" />

    <n-drawer v-model:show="active" :width="800" :placement="placement">
      <n-drawer-content>
        <Codemirror border :options="cmOptions" v-model:value="templateData.context"></Codemirror>
        <template #header>
            <n-space >
              <n-form ref="formRef" inline :label-width="80" :model="formValue" :rules="rules" :size="size">
                <n-form-item label="名称" path="name">
                  <n-input v-model:value="templateData.name" placeholder="名称" />
                </n-form-item>
                <n-form-item label="描述" path="synopsis">
                  <n-input v-model:value="templateData.synopsis" placeholder="描述" />
                </n-form-item>
                <n-form-item>
                  <n-button @click="save()">保存</n-button>
                </n-form-item>
                <n-form-item>
                  <n-button>取消</n-button>
                </n-form-item>
              </n-form>
            </n-space>
        </template>
      </n-drawer-content>
    </n-drawer>
</template>
  
<script setup>
import { ref, computed, h,defineComponent  } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useAuthorStore } from "@common/user";
import Codemirror from 'codemirror-editor-vue3';

import "codemirror/addon/display/placeholder.js";
import "codemirror/mode/javascript/javascript.js";
import "codemirror/addon/display/placeholder.js";
import "codemirror/theme/dracula.css";
import "v-contextmenu/dist/themes/default.css";

import { NButton, NForm, NFormItem, NInput, NDataTable, NSpace, NDrawer,NDrawerContent,useMessage,NMessageProvider  } from "naive-ui";
import { selectTemplateApi,insertTemplateApi,updateTemplateApi,deleteTemplateApi } from "@admin/apis/template"

let router = useRouter();
let route = useRoute();
let authorStore = useAuthorStore();

const message = useMessage()

let templateData = ref({})

let cmOptions = ref({
  mode: "text/javascript", // Language mode
  theme: "dracula", // Theme
})

const formValue = ref({});

const formType = ref("insert");

const valueRef = ref(1);
const panelsRef = ref([1, 2, 3, 4, 5]);

const templateList = ref([{}])
let columns = [{
  title: "名称",
  key: "name",
},
{
  title: "时间",
  key: "createTime"
},{
  title: "描述",
  key: "synopsis"
},
{
  title: '操作',
  key: 'actions',
  width: "250",
  render(row, index) {
    return [
      h(NSpace, [
        h(NButton, { size: 'small', onClick: () =>  updateTemplate(row) }, { default: () => '编辑' }),
        h(NButton, { size: 'small', onClick: () => deleteArticle(index, row) }, { default: () => '删除' })
      ])
    ]
  }
}]

const updateTemplate = (row) => {
  formType.value = "update";
  activate("left");
  templateData.value = row
}

const insertTemplate = () => {
  formType.value = "insert";
  activate("left");
  templateData.value = {}
}

const save = () => {
  if(formType.value == "update"){
    updateTemplateApi(templateData.value).then((res) => {
      message.info("保存成功");
      active.value = false;
    })
  }
  if(formType.value == "insert"){
    insertTemplateApi(templateData.value).then((res) => {
      templateList.value.push(res.data)
      message.info("添加成功");
      active.value = false;
    })
  }
  
}

const active = ref(false);
const placement = ref("left");
const activate = (place) => {
  active.value = true;
  placement.value = place;
};


selectTemplateApi().then((res) => {
  templateList.value = res.data
})

</script>

<style>
.codemirror-container {
  display: block !important;
}

.CodeMirror-hscrollbar {
  left: 0 !important;
}
</style>