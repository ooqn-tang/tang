<template>
  <el-form :model="form" label-width="50px">
    <el-form-item label="状态">
      <el-select v-model="form.state" placeholder="please select your zone">
        <el-option label="草稿" value="1" />
        <el-option label="未通过" value="2" />
        <el-option label="已通过" value="3" />
        <el-option label="已删除" value="4" />
      </el-select>
    </el-form-item>
  </el-form>
  <el-table :data="articleList" style="width: 100%" >
    <el-table-column label="标题" show-overflow-tooltip>
      <template #default="scope">
        {{ scope.row.article.title }}
      </template>
    </el-table-column>
    <el-table-column label="时间">
      <template #default="scope">
        {{ scope.row.article.createTime }}
      </template>
    </el-table-column>
    <el-table-column label="作者">
      <template #default="scope">
        {{ scope.row.author.nickname }}
      </template>
    </el-table-column>
    <el-table-column align="right">
      <template #header>操作</template>
      <template #default="scope">
        <el-button size="small" type="danger">查看</el-button>
        <el-popconfirm confirm-button-text="确认" cancel-button-text="取消" :icon="InfoFilled" icon-color="red" @confirm="deleteNotice(scope.$index, scope.row)" title="是否确认删除?">
          <template #reference>
            <el-button size="small" type="danger">删除</el-button>
          </template>
        </el-popconfirm>
      </template>
    </el-table-column>
  </el-table>
</template>
  
<script setup>
import { ElMessage } from "element-plus";
import request from "utils/request";
import { onMounted,ref } from "vue";
import { useRouter, useRoute } from "vue-router";
import { useStore } from "vuex";

let router = useRouter();
let route = useRoute();
let store = useStore();

let articleList = ref([]);
let form = ref({
  state: "1"
});

let deleteNotice = (index, row) => {
  alert(row.articleId)
  request({
    url: `/api/admin/article/${row.articleId}`,
    method: "DELETE",
  }).then((res) => {
    articleList.value.splice(index, 1)
    ElMessage({ type: 'success', message: '删除成功' })
  });
}

let loadArticle = () => {
  request({
    url: `/api/admin/article`,
    method: "GET",
  }).then((response) => {
    articleList.value = response.data.content
  });
}

onMounted(() => {
  loadArticle()
})

</script>