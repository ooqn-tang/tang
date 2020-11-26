<template>
  <div class="app-container">
    <div class="t-block">
      <el-row>
        <el-col :span="12">
          <el-button type="primary">添加成员</el-button>
          <el-button type="warning">授权</el-button>
          <el-button type="danger">禁用</el-button>
        </el-col>
        <el-col :span="12">
          <el-input v-model="form.inputText" placeholder="请输入内容" clearable @change="change" />
        </el-col>
      </el-row>
    </div>

    <div class="t-block">
      <el-table v-loading="loading" :data="memberDataList" border style="width: 100%;" height="500">
        <el-table-column type="selection" width="39" />
        <el-table-column fixed prop="utsMember.username" label="用户名" width="100" />
        <el-table-column prop="utsMember.nickname" label="昵称" width="150" />
        <el-table-column prop="utsMember.mail" label="邮箱" width="200" />
        <el-table-column prop="utsMember.createTime" label="注册时间" width="95" />
        <el-table-column prop="utsMember.state" label="状态" width="50" />
        <el-table-column prop="utsMember.state" label="角色">
          <template slot-scope="scope">
            <el-tag v-for="item in scope.row.utsRoleDto" :key="item.id" style="margin-right: 10px;">{{ item.name }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column label="操作" width="50" style="border-right: 0px;">
          <template slot-scope="scope">
            <el-button type="text" size="mini" @click="infoClick(scope.row)">详细</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
import { memberList } from '@/api/member'

export default {
  filters: {},
  data() {
    return {
      form: {
        inputText: ''
      },
      loading: true,
      memberDataList: [
        {
          date: '2016-05-02',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }
      ]
    }
  },
  created() {
    this.member()
  },
  methods: {
    member() {
      memberList().then((response) => {
        this.memberDataList = response.data.data
        this.loading = false
      })
    },
    change(param) {
      console.log(param)
    }
  }
}
</script>
