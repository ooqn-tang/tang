<template>
  <el-tabs v-model="activeName" class="demo-tabs" @tab-click="handleClick">
    <el-tab-pane label="类目管理" name="first">参数配置</el-tab-pane>
    <el-tab-pane label="Config" name="second">Config</el-tab-pane>
    <el-tab-pane label="Role" name="third">Role</el-tab-pane>
    <el-tab-pane label="Task" name="fourth">Task</el-tab-pane>
  </el-tabs>
</template>

<script>
import request from "utils/request";
export default {
  name: "admin_system",
  data() {
    return {
      routeName: this.$route.name,
      activeName: 'first'
    };
  },
  created() {},
  methods: {},
  mounted() {},
};
</script>