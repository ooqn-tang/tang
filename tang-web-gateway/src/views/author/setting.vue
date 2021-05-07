<template>
  <form style="margin:10px">
    <div class="row mb-3">
      <label for="inputEmail3" class="col-sm-2 col-form-label">用户名</label>
      <div class="col-sm-10">
        <input type="email" class="form-control" id="inputEmail3" />
      </div>
    </div>
    <div class="row mb-3">
      <label for="inputPassword3" class="col-sm-2 col-form-label"
        >昵称</label
      >
      <div class="col-sm-10">
        <input type="password" class="form-control" id="inputPassword3" />
      </div>
    </div>
    <div class="row mb-3">
      <label for="inputPassword3" class="col-sm-2 col-form-label"
        >邮箱</label
      >
      <div class="col-sm-10">
        <input type="password" class="form-control" id="inputPassword3" />
      </div>
    </div>
    <div class="row mb-3">
      <label for="inputPassword3" class="col-sm-2 col-form-label"
        >签名</label
      >
      <div class="col-sm-10">
        <input type="password" class="form-control" id="inputPassword3" />
      </div>
    </div>
    <button type="submit" class="btn btn-primary">Sign in</button>
  </form>
</template>

<script>
export default {
  name: "author_setting",
  data() {
    return {};
  },
  components: {},
  methods: {},
  mounted() {},
};
</script>

<style lang="scss">
body {
  overflow-y: scroll;
}
</style>