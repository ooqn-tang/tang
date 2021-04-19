<template>
  <div class="row">
    <div class="col-md-9 column">
      <ul id="blog-list" class="list-group">
        <li class="list-group-item">
          <router-link to="/post/2d50d3a614c94e9fa47663dbcb40ab2e" class="blog-title"><p>asdf</p></router-link>
          <div class="blog-synopsis">a啊</div>
          <div>
            <span class="date-color">2021.03.27</span>
            <router-link to="/author/admin" class="pull-right">管理员</router-link>
          </div>
        </li>
        <li class="list-group-item">
          <a>获取</a>
        </li>
      </ul>
    </div>
    <div class="col-md-3 column">
      <div>
        <div class="list-group">
          <a class="list-group-item active" >广播<span class="pull-right">🎇</span></a>
          <a target="_blank" href="http://www.ttcxy.net/post/098384e9a34d438480289ad23c8625ba" class="list-group-item">公众号推荐列表</a>
        </div>
        <div class="panel panel-default">
          <div class="panel-body">
            <p>
              <a
                href="https://ttcxy.net/post/0b0d396713a54e2fbf714478d740e53e"
                target="_blank"
                >关于</a
              >
            </p>
            <p>
              <a
                href="https://ttcxy.net/post/98b255d539f743e193e398bfa9b97cfd"
                target="_blank"
                >友情链接</a
              >
            </p>
            <p>
              <a href="http://beian.miit.gov.cn" target="_blank"
                >湘ICP备20009234号</a
              >
            </p>
            <a href="/map" class="hidden">地图</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "blog",
  data() {
    return {
      msg: 'Hello Vue 3.0 + Vite',
       messageList: [{},{}],
    }
  },
  components: {
    
  },
  methods: {
    edit(e) {
      this.msg = e
    },
    getVal(e) {
      console.log(e)
    }
  }
}
</script>

<style scoped lang="scss">
.red {
  color: red;
}
</style>