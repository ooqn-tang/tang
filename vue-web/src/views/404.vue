<template>

 <div class="common-layout">
    <el-container>
      <el-header style="">Header</el-header>
      <el-container>
        <el-aside width="200px">Aside</el-aside>
        <el-main>Main</el-main>
      </el-container>
    </el-container>
  </div>
</template>
<script>
export default {
  name: "error",
  data() {
    return {
    };
  },
  components: {
  },
  methods: {
  },
  mounted(){
  }
};
</script>
<style lang="scss">
body{
    overflow-y: scroll;
}
</style>