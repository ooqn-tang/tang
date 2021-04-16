<template>
<router-view/>
  
</template>

<script>

export default {
  name: 'App',
  created() {
    // 移除路由
    this.$router.removeRoute('detail');
    // 添加路由
    this.$router.addRoute({
      path: '/detail',
      name: 'detail',
      component: () => import('./views/detail/index.vue')
    });
  }
}
</script>
