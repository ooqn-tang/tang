<template>
  <router-view/>
</template>
<script>
export default {
  name: 'App',
  created() {
   this.$store.state.username = localStorage.getItem("username")
  }
}
</script>
