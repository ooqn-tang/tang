<template>
  <el-button type="primary" @click="insertDialogVisible = true">新增</el-button>
  <el-button type="primary" :disabled="orderButton" @click="updateOrder">保存排序</el-button>
  <el-table :data="noticeList" style="width: 100%">
    <el-table-column label="标题">
      <template #default="scope">
        <div v-if="scope.$index == editIndex">
          <el-input v-model="scope.row.title" size="small" placeholder="请输入标题" />
        </div>
        <div v-if="scope.$index != editIndex">
          {{scope.row.title}}
        </div>
      </template>
    </el-table-column>
    <el-table-column label="路径" prop="url">
      <template #default="scope">
        <div v-if="scope.$index == editIndex">
          <el-input v-model="scope.row.url" size="small" placeholder="请输入标题" />
        </div>
        <div v-if="scope.$index != editIndex">
          {{scope.row.url}}
        </div>
      </template>
    </el-table-column>
    <el-table-column align="right">
      <template #header>操作</template>
      <template #default="scope">
        <el-button size="small" @click="moveUpward(scope.$index, scope.row)">上移</el-button>
        <el-button size="small" @click="moveDown(scope.$index, scope.row)">下移</el-button>
        <el-button size="small" type="danger"  v-if="scope.$index == editIndex" @click="saveNotice(scope.$index, scope.row)">保存</el-button>
        <el-button size="small" type="danger" @click="editIndex = scope.$index" v-if="scope.$index != editIndex">编辑</el-button>
        <el-popconfirm
              confirm-button-text="确认"
              cancel-button-text="取消"
              :icon="InfoFilled"
              icon-color="red"
              @confirm="deleteNotice(scope.$index, scope.row)"
              title="是否确认删除?"
            >
              <template #reference>
                <el-button size="small" type="danger">删除</el-button>
              </template>
            </el-popconfirm>
      </template>
    </el-table-column>
  </el-table>

  <el-dialog v-model="insertDialogVisible" title="新增推荐" width="60%">
    <el-form ref="formRef" :model="form" label-width="120px">
    <el-form-item label="标题">
      <el-input v-model="form.title"></el-input>
    </el-form-item>
    <el-form-item label="路径">
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
</template>

<script>
import { ElMessage } from "element-plus";
import request from "src/utils/request";
export default {
  name: "admin_recommend",
  data() {
    return {
      insertDialogVisible:false,
      routeName: this.$route.name,
      noticeList:[{},{}],
      editIndex:-1,
      orderButton:true,
      form:{

      }
    };
  },
  created() {},
  methods: {
    insertNotice(){
      request({
        url: "/api/admin/notice",
        method: "POST",
        data:this.form,
      }).then((response) => {
        ElMessage({type: 'success', message: '保存成功'})
        this.insertDialogVisible = false
        this.loadRecommend()
        this.form = {}
      });
    },
    deleteNotice(index,row){
      request({
        url: "/api/admin/notice/"+row.noticeId,
        method: "DELETE",
      }).then((response) => {
        this.noticeList.splice(index, 1)
        ElMessage({type: 'success', message: '删除成功'})
      });
    },
    updateOrder(){
       request({
        url: "/api/admin/notice/order",
        method: "PUT",
        data:this.noticeList,
      }).then((response) => {
        this.orderButton = true
        ElMessage({type: 'success', message: '保存成功'})
      });
    },
    saveNotice(index,row){
      request({
        url: "/api/admin/notice",
        method: "PUT",
        data:row,
      }).then((response) => {
        this.editIndex = -1
      });
    },
    loadRecommend(){
      request({
        url: "/api/admin/notice",
        method: "GET",
      }).then((response) => {
        this.noticeList = response.data
      });
    },
    moveUpward(index,row) {
      if (index > 0) {
        let upData = this.noticeList[index - 1];
        this.noticeList.splice(index - 1, 1);
        this.noticeList.splice(index, 0, upData);
        this.orderButton = false
      }
    },
    moveDown(index,row) {
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