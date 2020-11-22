<template>
  <div class="app-container">
    <div class="t-block">
      <el-row>
        <el-button type="primary">添加资源</el-button>
        <el-button type="warning">添加角色</el-button>
      </el-row>
    </div>

    <div class="t-block">
      <el-table
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      type="selection"
      width="39">
    </el-table-column>
    <el-table-column
      fixed
      prop="date"
      label="用户名"
      width="150">
    </el-table-column>
    <el-table-column
      prop="name"
      label="昵称"
      width="120">
    </el-table-column>
    <el-table-column
      prop="province"
      label="地区"
      width="120">
    </el-table-column>
    <el-table-column
      prop="city"
      label="角色"
      width="120">
    </el-table-column>
    <el-table-column
      prop="address"
      label="IP">
    </el-table-column>
    <el-table-column
      prop="zip"
      label="最近登录"
      width="120">
    </el-table-column>
    <el-table-column
      label="操作"
      width="50">
      <template slot-scope="scope">
        <el-button type="text" size="mini" @click="infoClick(scope.row)">详细</el-button>
      </template>
    </el-table-column>
  </el-table>
    </div>
    
  </div>
</template>

<script>
import { getList } from '@/api/table'

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
        }]
    }
  },
  created() {
    
  },
  methods: {
    handleClick(row) {
        console.log(row);
      }
  }
}
</script>
