<template>
  <div class="app-container">
    <div class="t-block">
      <el-row>
        <el-button type="primary" @click="resourceDialog = true,resourceForm = {},saveType = 'insert'">添加资源</el-button>
        <el-button type="primary" @click="roleDialog = true,roleForm = {},saveType = 'insert'">添加角色</el-button>
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
                  <el-button type="text" size="mini" @click="updateRoleClick(scope.row), saveType='update'">修改</el-button>
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
              width="120"
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
                <el-button type="text" size="mini" @click="updateResourceClick(scope.row),resourceDialog=true, saveType='update'">修改</el-button>
                <el-button style="color:#f56c6c" type="text" size="mini" @click.native.prevent="deleteResourceClick(scope.$index,scope.row,roleList)">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
        </div>
      </el-col>
    </el-row>
    <!-- 角色 -->
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
        <el-button @click="insertRoleClick">保 存</el-button>
        <el-button @click="roleDialog = false">取 消</el-button>
      </div>
    </el-dialog>
    <!-- 资源 -->
    <el-dialog title="资源" :visible.sync="resourceDialog">
      <el-form ref="form" :model="roleForm" label-width="80px">
        <el-form-item label="资源名">
          <el-input v-model="resourceForm.name" />
        </el-form-item>
        <el-form-item label="通配符">
          <el-input v-model="resourceForm.path" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="insertResourceClick">保 存</el-button>
        <el-button @click="resourceDialog = false">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
// eslint-disable-next-line no-unused-vars
import { roleList, insertRolePost, updateRolePost, deleteRolePost } from '@/api/role'
// eslint-disable-next-line no-unused-vars
import { resourceList, insertResourcePost, updateResourcePost, deleteResourcePost } from '@/api/resource'

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
      tableData: [],
      resourceList: [],
      roleList: []
    }
  },
  created() {
    this.loadRole()
    this.loadResource()
  },
  methods: {
    // 添加角色按钮
    insertRoleClick() {
      if (this.saveType === 'insert') {
        insertRolePost(this.roleForm).then((result) => {
          console.log(result.data.data)
          this.roleForm = {}
          this.roleDialog = false
          this.loadRole()
        })
      } else if (this.saveType === 'update') {
        updateRolePost(this.roleForm).then((result) => {
          console.log(result.data.data)
          this.roleForm = {}
          this.roleDialog = false
          this.loadRole()
        })
      }
    },
    // 删除角色按钮
    deleteRoleClick(index, row, rows) {
      deleteRolePost(row.id).then((result) => {
        console.log(result.data.data)
        rows.splice(index, 1)
      })
    },
    // 更新角色按钮
    updateRoleClick(row) {
      this.roleDialog = true
      this.roleForm = JSON.parse(JSON.stringify(row))
      console.log(row)
    },
    // 加载角色列表
    loadRole() {
      roleList().then(result => {
        this.roleList = result.data.data
      })
    },
    // 保存资源按钮
    insertResourceClick() {
      if (this.saveType === 'insert') {
        insertResourcePost(this.resourceForm).then(result => {
          console.log(result)
          this.loadResource()
        })
      } else if (this.saveType === 'update') {
        updateResourcePost(this.resourceForm).then(result => {
          console.log(result)
          this.loadResource()
          this.resourceDialog = false
        })
      }
    },
    // 删除资源按钮
    deleteResourceClick(index, row, data) {
      deleteResourcePost(row.id).then(result => {
        console.log(result)
        this.loadResource()
      })
    },
    // 更新资源按钮
    updateResourceClick(row) {
      this.resourceDialog = true
      this.resourceForm = JSON.parse(JSON.stringify(row))
      console.log(row)
    },
    // 加载资源列表
    loadResource() {
      resourceList().then((result) => {
        console.log(result.data.data)
        this.resourceList = result.data.data
      })
    }
  }
}
</script>
