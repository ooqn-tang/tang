<template>
  <div id="loginModal" class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title text-center">登录</h4>
      </div>
      <div id="model-body" class="modal-body">
        <label>邮箱 / 用户名：</label>
        <div class="form-group">
          <input
            type="text"
            placeholder="用户名"
            autocomplete="off"
            class="form-control"
          />
        </div>
        <label>密码：</label>
        <div class="form-group">
          <input
            type="password"
            placeholder="密码"
            autocomplete="off"
            class="form-control"
          />
        </div>
        <label>验证码</label>
        <div class="input-group">
          <input type="text" class="form-control" />
          <span class="input-group-addon" style="padding: 0px">
            <img alt="验证码" src="/verify?t=1618561217000" height="32"/></span>
        </div>
      </div>
      <div class="modal-footer">
        <div class="btn-group W100" style="margin-bottom: 10px">
          <button type="button" class="btn btn-primary W100">登录</button>
        </div>
        <div class="btn-group W100" style="margin-bottom: 10px">
          <a type="button" class="btn btn-default W33">账户登录</a>
          <a type="button" class="btn btn-default W33">注册账户</a>
          <a type="button" class="btn btn-default W34">忘记密码</a>
        </div>
        <div class="btn-group W100">
          <a href="/" type="button" class="btn btn-default W100">返回首页</a>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "login",
  data() {
    return {};
  },
  components: {},
  methods: {},
};
</script>

<style scoped lang="scss">
</style>