2<template>
  <el-row>
    <el-col style="padding: 10px">
      <el-form :inline="true" class="demo-form-inline"  >
        <el-form-item label="状态">
          <el-select v-model="form.state" placeholder="请选择">
            <el-option label="已通过" value="1"></el-option>
            <el-option label="待审核" value="2"></el-option>
            <el-option label="已删除" value="4"></el-option>
            <el-option label="未通过" value="5"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="loadCommentList()" >查询</el-button>
        </el-form-item>
      </el-form>
    </el-col>
    <el-col style="padding: 10px">
      <!-- 视频列表 -->
      <el-table v-loading="loading" :data="commentData.list" style="width: 100%" border>
        <el-table-column type="expand" label="开">
          <template #default="props">
            <div style="padding:10px">
              {{ props.row.text }}
            </div>
          </template>
        </el-table-column>
        <el-table-column label="评论人" prop="nickname" />
        <el-table-column label="时间" prop="createDate" />
        <el-table-column label="状态" prop="codeName" />
        <el-table-column label="操作" width="210">
          <template #default="scope">
            <el-button size="small" @click="pass(scope.$index,scope.row,1)" type="primary">通过</el-button>
            <el-button size="small" @click="pass(scope.$index,scope.row,5)" type="primary">不通过</el-button>
            <el-popconfirm
              confirm-button-text="确认"
              cancel-button-text="取消"
              :icon="InfoFilled"
              icon-color="red"
              @confirm="confirmDelete(scope.$index,scope.row)"
              title="是否确认删除?"
            >
              <template #reference>
                <el-button size="small" type="danger">删除</el-button>
              </template>
            </el-popconfirm>
          </template>
        </el-table-column>
      </el-table>
      <br>
      <el-pagination background layout="prev, pager, next" v-model:currentPage="form.page" :page-count="commentData.pages" @current-change="handleCurrentChange" style="text-align: center;"></el-pagination>
    </el-col>
  </el-row>
</template>

<script>
import { ElMessage } from "element-plus";
import request from "utils/request";
export default {
  name: "admin_comment",
  data() {
    return {
      loading:true,
      commentData:{
        page:""
      },
      form:{
        state:"1"
      }
    };
  },
  created() {},
  methods: {
    confirmDelete(index,row) {
      request({
        url: "/api/admin/comment/pass/" + row.commentId,
        method: "put",
        data:{
          state:'4',
          commentId:row.commentId
        }
      }).then((response) => {
        this.commentData.list.splice(index, 1)
        ElMessage({type: 'success', message: '删除成功'})
      });
    },
    pass(index,row,state) {
       request({
        url: "/api/admin/comment/pass/"+row.commentId,
        method: "put",
        data:{
          state:state,
          commentId:row.commentId
        }
      }).then((response) => {
        this.commentData.list.splice(index, 1)
        ElMessage({type: 'success', message: '执行成功'})
      });
    },
    loadCommentList() {
      this.loading = true
      request({
        url: "/api/admin/comment/list",
        method: "get",
        params: this.form,
      }).then((response) => {
        this.loading = false
        this.commentData = response.data;
      });
    },
    handleCurrentChange(number){
      this.form.page = number
      this.loadCommentList()
    }
  },
  mounted() {
    this.loadCommentList()
  },
};
</script>
<style scoped>
.el-form-item{
  margin-bottom: 0px;
}
</style>