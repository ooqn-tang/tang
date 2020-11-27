<template>
  <div class="app-container">
    <div class="t-block">
      <el-row>
        <el-button type="primary">添加资源</el-button>
        <el-button type="warning">添加角色</el-button>
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
              style="width: 100%"
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
                width="120"
              />
              <el-table-column
                prop="createTime"
                label="描述"
              />
              <el-table-column
                label="操作"
                width="50"
              >
                <template slot-scope="scope">
                  <el-button type="text" size="mini" @click="infoClick(scope.row)">详细</el-button>
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
            style="width: 100%"
            height="500"
          >
            <el-table-column
              type="selection"
              width="39"
            />
            <el-table-column
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
              width="50"
            >
              <template slot-scope="scope">
                <el-button type="text" size="mini" @click="infoClick(scope.row)">详细</el-button>
              </template>
            </el-table-column>
          </el-table>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
// eslint-disable-next-line no-unused-vars
import { roleList } from '@/api/role'
// eslint-disable-next-line no-unused-vars
import { resourceList } from '@/api/resource'

export default {
  filters: {

  },
  data() {
    return {
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
