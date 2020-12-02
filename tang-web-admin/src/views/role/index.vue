<template>
  <div class="app-container">
    <div class="t-block">
      <el-row>
        <el-button type="primary">添加资源</el-button>
        <el-button type="warning" @click="roleDialog = true,roleForm = {},saveType = 'insert'">添加角色</el-button>
        <el-button type="warning">角色<i class="el-icon-back" />资源</el-button>
      </el-row>
    </div>

    <el-row>
      <el-col :span="14">
        <div class="t-block">
          <el-row>
            <div style=" margin-bottom: 4px; font-size: large;">权限</div>
          </el-row>
          <el-row>
            <el-table
              :data="roleList"
              border
              height="500"
            >
              <el-table-column
                type="selection"
                width="39"
              />
              <el-table-column
                fixed
                prop="roleName"
                label="角色名"
                width="150"
              />
              <el-table-column
                prop="roleValue"
                label="角色值"
              />
              <el-table-column
                label="操作"
                width="85"
              >
                <template slot-scope="scope">
                  <el-button type="text" size="mini" @click="updateRoleClick(scope.row),saveType = 'update'">修改</el-button>
                  <el-button style="color:#f56c6c" type="text" size="mini" @click.native.prevent="deleteRoleClick(scope.$index,scope.row,roleList)">删除</el-button>
                </template>
              </el-table-column>
            </el-table>
          </el-row>
        </div>
      </el-col>
      <el-col :span="10">
        <div class="t-block">
          <div style=" margin-bottom: 4px; font-size: large;">资源</div>
          <el-table
            :data="resourceList"
            border
            height="500"
          >
            <el-table-column
              type="selection"
              width="39"
            />
            <el-table-column
              fixed
              prop="name"
              label="资源名"
              width="100"
            />
            <el-table-column
              prop="path"
              label="通配符"
            />
            <el-table-column
              label="操作"
              width="90"
            >
              <template slot-scope="scope">
                <el-button type="text" size="mini" @click="updateResourceClick(scope.row),saveType = 'update'">修改</el-button>
                <el-button type="text" size="mini" @click="showResourceClick(scope.row)">详细</el-button>
              </template>
            </el-table-column>
          </el-table>
        </div>
      </el-col>
    </el-row>
    <el-dialog title="角色" :visible.sync="roleDialog">
      <el-form ref="form" :model="roleForm" label-width="80px">
        <el-form-item label="角色名">
          <el-input v-model="roleForm.roleName" />
        </el-form-item>
        <el-form-item label="角色值">
          <el-input v-model="roleForm.roleValue" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="saveRoleClick">保 存</el-button>
        <el-button @click="roleDialog = false">取 消</el-button>
      </div>
    </el-dialog>

    <el-dialog title="外层 Dialog" :visible.sync="resourceDialog">

      <div slot="footer" class="dialog-footer">
        <el-button @click="resourceDialog = false">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
// eslint-disable-next-line no-unused-vars
import { roleList, insertRolePost, updateRolePost, deleteRolePost } from '@/api/role'
// eslint-disable-next-line no-unused-vars
import { resourceList } from '@/api/resource'

export default {
  filters: {

  },
  data() {
    return {
      saveType: 'insert',
      roleDialog: false,
      roleForm: {},
      resourceDialog: false,
      resourceForm: {},
      tableData: [{
        date: '2016-05-02',
        name: '王小虎',
        province: '上海',
        city: '普陀区',
        address: '上海市普陀区金沙江路 1518 弄',
        zip: 200333
      }, {
        date: '2016-05-04',
        name: '王小虎',
        province: '上海',
        city: '普陀区',
        address: '上海市普陀区金沙江路 1517 弄',
        zip: 200333
      }, {
        date: '2016-05-01',
        name: '王小虎',
        province: '上海',
        city: '普陀区',
        address: '上海市普陀区金沙江路 1519 弄',
        zip: 200333
      }, {
        date: '2016-05-03',
        name: '王小虎',
        province: '上海',
        city: '普陀区',
        address: '上海市普陀区金沙江路 1516 弄',
        zip: 200333
      }],
      resourceList: [],
      roleList: []
    }
  },
  created() {
    this.loadRole()
    this.loadResource()
  },
  methods: {
    saveRoleClick() {
      if (this.saveType === 'insert') {
        insertRolePost(this.roleForm).then((resource) => {
          console.log(resource.data.data)
          this.roleForm = {}
          this.roleDialog = false
        })
      } else if (this.saveType === 'update') {
        updateRolePost(this.roleForm).then((resource) => {
          console.log(resource.data.data)
          this.roleForm = {}
          this.roleDialog = false
        })
      }
    },
    updateRoleClick(row) {
      this.roleDialog = true
      this.roleForm = row
      console.log(row)
    },
    updateRolePost() {
      this.saveRoleClick('update')
    },
    deleteRoleClick(index, row, rows) {
      deleteRolePost(row.id).then((resource) => {
        console.log(resource.data.data)
        rows.splice(index, 1)
      })
    },
    showResourceClick(row) {
      console.log(row)
    },
    updateResourceClick(row) {
      this.resourceDialog = true
      console.log(row)
    },
    handleClick(row) {
      console.log(row)
    },
    loadResource() {
      resourceList().then((response) => {
        console.log(response.data.data)
        this.resourceList = response.data.data
      })
    },
    loadRole() {
      roleList().then(response => {
        this.roleList = response.data.data
      })
    }
  }
}
</script>
