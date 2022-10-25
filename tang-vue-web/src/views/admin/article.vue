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
  <el-table :data="noticeList" style="width: 100%">
    <el-table-column label="标题">
      <template #default="scope">
        {{ scope.row.title }}
      </template>
    </el-table-column>
    <el-table-column label="路径" prop="url">
      <template #default="scope">
        {{ scope.row.title }}
      </template>
    </el-table-column>
    <el-table-column align="right">
      <template #header>操作</template>
      <template #default="scope">
        <el-button size="small" type="danger">查看</el-button>
        <el-button size="small" type="danger" @click="editIndex = scope.$index,insertDialogVisible = true">操作</el-button>
        <el-popconfirm confirm-button-text="确认" cancel-button-text="取消" :icon="InfoFilled" icon-color="red" @confirm="deleteNotice(scope.$index, scope.row)" title="是否确认删除?">
          <template #reference>
            <el-button size="small" type="danger">删除</el-button>
          </template>
        </el-popconfirm>
      </template>
    </el-table-column>
  </el-table>

  <el-dialog v-model="insertDialogVisible" title="操作" width="60%" height="80%">
    <el-form ref="formRef" :model="form" label-width="120px">
      <el-form-item label="标题">
        <el-input v-model="form.title"></el-input>
      </el-form-item>
      <el-form-item label="内容">
        <el-input v-model="form.url"></el-input>
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="insertDialogVisible = false">取消</el-button>
        <el-button type="primary" @click="insertNotice()">保存</el-button>
      </span>
    </template>
  </el-dialog>

  <el-dialog v-model="articleInfoDialog" title="操作" width="60%" height="80%">
    <el-form ref="formRef" :model="form" label-width="120px">
      <el-form-item label="标题">
        <el-input v-model="form.title"></el-input>
      </el-form-item>
      <el-form-item label="内容">
        <div>
          
        </div>
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="insertDialogVisible = false">取消</el-button>
        <el-button type="primary" @click="insertNotice()">保存</el-button>
      </span>
    </template>
  </el-dialog>
</template>
  
<script>
import { ElMessage } from "element-plus";
import request from "utils/request";
export default {
  name: "admin_article",
  data() {
    return {
      insertDialogVisible: false,
      articleInfoDialog: false,
      routeName: this.$route.name,
      noticeList: [{}, {}],
      editIndex: -1,
      orderButton: true,
      form: {
        state: ""
      }
    };
  },
  created() { },
  methods: {
    insertNotice() {
      request({
        url: "/api/admin/notice",
        method: "POST",
        data: this.form,
      }).then((response) => {
        ElMessage({ type: 'success', message: '保存成功' })
        this.insertDialogVisible = false
        this.loadRecommend()
        this.form = {}
      });
    },
    deleteNotice(index, row) {
      request({
        url: "/api/admin/notice/" + row.noticeId,
        method: "DELETE",
      }).then((response) => {
        this.noticeList.splice(index, 1)
        ElMessage({ type: 'success', message: '删除成功' })
      });
    },
    updateOrder() {
      console.log(this.noticeList)
      request({
        url: "/api/admin/notice/order",
        method: "PUT",
        data: this.noticeList,
      }).then((response) => {
        this.orderButton = true
        ElMessage({ type: 'success', message: '保存成功' })
      });
    },
    saveNotice(index, row) {
      request({
        url: "/api/admin/notice",
        method: "PUT",
        data: row,
      }).then((response) => {
        this.editIndex = -1
      });
    },
    loadRecommend() {
      request({
        url: "/api/admin/notice",
        method: "GET",
      }).then((response) => {
        this.noticeList = response.data
      });
    },
    moveUpward(index, row) {
      if (index > 0) {
        let upData = this.noticeList[index - 1];
        this.noticeList.splice(index - 1, 1);
        this.noticeList.splice(index, 0, upData);
        this.orderButton = false
      }
    },
    moveDown(index, row) {
      if ((index + 1) == this.noticeList.length) {
      } else {
        let downData = this.noticeList[index + 1];
        this.noticeList.splice(index + 1, 1);
        this.noticeList.splice(index, 0, downData);
        this.orderButton = false
      }
    }
  },
  mounted() {
    this.loadRecommend()
  },
};
</script>