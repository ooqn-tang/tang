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

<script>
import { ElMessage } from "element-plus";
import request from "utils/request";
export default {
  name: "admin_author",
  data() {
    return {
      routeName: this.$route.name,
      formInline:{user:""},
      authorList:[],
      roleIdList: [],
      roleList:[],
      queryData:"",
      selectAuthorId:"",
      roleForm:[],
      options:[
        {value:"使用"},{value:"禁用"}
      ],
      value:''
    };
  },
  watch: {
    roleIdList: {
      handler() {
        this.$nextTick(() => {
          for(let index in this.roleList){
            if(this.roleIdList.indexOf(this.roleList[index].roleId) > -1){
              this.$refs.multipleTable.toggleRowSelection(this.roleList[index]);
            }
          }
        });
      }
    }
  },
  created() {},
  methods: {
    checkRole(selection, row){
      this.roleForm = selection
    },
    saveAuthorRole(){
      request({
        url: `api/admin/role/author/${this.selectAuthorId}`,
        method: "POST",
        data:this.roleForm
      }).then((response) => {
        this.roleIdList = response.data;
        ElMessage({
          type: 'success',
          message: '删除成功',
        })
      });
    },
    rowAuthorClick(row, column, event){
      this.selectAuthorId = row.authorId
      this.selectRole(row);
    },
    selectRole(row){
      request({
        url: `api/admin/role`,
        method: "GET",
      }).then((response) => {
        this.roleList = response.data;
        request({
          url: `api/admin/role/author/${row.authorId}`,
          method: "GET",
        }).then((response) => {
          this.roleIdList = response.data;
        });
      });
    },
    selectAuthor(){
      request({
        url: `/api/admin/author`,
        method: "GET",
        params:{queryData:this.queryData}
      }).then((response) => {
        this.authorList = response.data;
      });
    },
    deleteAuthor(authorId){
      request({
        url: `/api/admin/author/${authorId}`,
        method: "DELETE"
      }).then((response) => {
        console.log(response.data)
      });
    }
  },
  mounted() {
    this.selectAuthor()
  },
};
</script>