<template>
  <el-row>
    <el-col :span="14">
      <div style="margin: 10px">
        <el-input
          placeholder="名称/角色值/资源名/资源值"
          class="input-with-select"
          style="padding-bottom: 5px"
        >
          <template #prepend>
            <el-button>新增角色</el-button>
          </template>
          <template #append>
            <el-button>搜索</el-button>
          </template>
        </el-input>
        <el-table
          :data="roleList"
          highlight-current-row
          border
          max-height="400"
          style="width: 100%"
        >
          <el-table-column label="角色名">
            <template #default="scope">
              <div v-if="scope.$index == editIndex">
                <el-input v-model="scope.row.roleName" size="small" placeholder="请输入角色名" />
              </div>
              <div v-if="scope.$index != editIndex">
                {{scope.row.roleName}}
              </div>
            </template>
          </el-table-column>
          <el-table-column prop="roleValue" label="角色值" />
          <el-table-column prop="createTime" label="创建时间" />
          <el-table-column label="操作" width="250">
            <template #default="scope">
              <el-button size="small" @click="editIndex = scope.$index" v-if="editIndex != scope.$index">编辑</el-button>
              <el-button size="small" @click="editIndex = -1" v-if="editIndex == scope.$index">保存</el-button>
              <el-button size="small" @click="(dialogVisible = true),rowRoleClick(scope.row)">权限资源编辑</el-button>
              <el-button size="small" type="danger" @click="deleteResource(scope.row.resourceId)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </el-col>
    <el-col :span="10">
      <div style="margin: 10px">
        <el-input placeholder="" style="padding-bottom: 5px" disabled>
          <template #prepend>
            <el-button @click="saveResourceRole">保存角色</el-button>
          </template>
          <template #append>搜索</template>
        </el-input>
        <el-table
          :data="resourceList"
          ref="multipleTable"
          @selection-change="checkResource"
          border
          max-height="800"
          style="width: 100%"
        >
          <!-- <el-table-column prop="resourceId" label="选择" width="180" /> -->
          <el-table-column type="selection" width="40" />
          <el-table-column prop="name" label="名称" width="180"/>
          <el-table-column prop="path" label="路径" width="180"/>
          <el-table-column prop="type" label="类型" />
        </el-table></div
    ></el-col>
  </el-row>
</template>

<script>
import request from "src/utils/request";
export default {
  name: "admin_role",
  data() {
    return {
      routeName: this.$route.name,
      formInline: { user: "" },
      roleList: [],
      resourceList: null,
      resourceIdList: null,
      selectRoleId:"",
      resourceForm:[],
      editIndex:-1
    };
  },
  computed:{
   
  },
  watch: {
      resourceIdList: {
        handler() {
          this.$nextTick(() => {
            for(let index in this.resourceList){
              if(this.resourceIdList.indexOf(this.resourceList[index].resourceId) > -1){
                this.$refs.multipleTable.toggleRowSelection(this.resourceList[index]);
              }
            }
          });
        }
      },
  },
  created() {
   
  },
  methods: {
    checkResource(selection, row){
      this.resourceForm = selection
    },
    saveResourceRole(){
      request({
        url: "/api/admin/role/resource/"+this.selectRoleId,
        method: "POST",
        data:this.resourceForm
      }).then((response) => {
        alert("添加成功")
      });
    },
    rowRoleClick(row) {
      this.selectRoleId = row.roleId
      this.selectResource(row);
    },
    selectRole() {
      request({
        url: "/api/admin/role",
        method: "GET",
      }).then((response) => {
        this.roleList = response.data;
      });
    },
    selectResource(row) {
      request({
        url: "/api/admin/resource",
        async: false,
        method: "GET",
      }).then((response) => {
        this.resourceList = response.data;
        this.selectResourceIdList(row.roleId);
      });
    },
    selectResourceIdList(id) {
      request({
        url: "/api/admin/resource/role/" + id,
        method: "GET",
      }).then((response) => {
        this.resourceIdList = response.data;
      });
    },
  },
  mounted() {
    this.selectRole();
  },
};
</script>