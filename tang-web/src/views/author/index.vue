<template>
  <div class="row clearfix">
    <div class="col-md-4 col-md-push-8">
      <div class="panel panel-default">
        <div class="panel-body">
          <strong>管理员</strong>
          <button class="pull-right btn btn-default btn-xs">订阅</button>
          <hr />
          <div>简介：<span>不得了的人物</span></div>
        </div>
      </div>
      <div class="panel panel-default">
        <div class="panel-body">
          <div class="btn-group W100">
            <button class="btn btn-default btn-sm W20 W50">博客</button>
            <button class="btn btn-default btn-sm W20 W50">推荐</button>
          </div>
        </div>
      </div>
      <div class="visible-md-block visible-lg-block">
        <div>
          <div class="list-group">
            <a class="list-group-item active" >广播<span class="pull-right">🎇</span></a>
            <a target="_blank" href="http://www.ttcxy.net/post/098384e9a34d438480289ad23c8625ba" class="list-group-item">公众号推荐列表</a>
          </div>
          <div class="panel panel-default">
            <div class="panel-body">
              <p>
                <a href="https://ttcxy.net/post/0b0d396713a54e2fbf714478d740e53e" target="_blank">关于</a>
              </p>
              <p>
                <a href="https://ttcxy.net/post/98b255d539f743e193e398bfa9b97cfd" target="_blank">友情链接</a>
              </p>
              <p>
                <a href="http://beian.miit.gov.cn" target="_blank">湘ICP备20009234号</a>
              </p>
              <a href="/map" class="hidden">地图</a>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="col-md-8 col-md-pull-4">
      <ul id="blog-list" class="list-group">
        <li class="list-group-item">
          <a target="_blank" href="/post/2d50d3a614c94e9fa47663dbcb40ab2e" class="blog-title"><p>asdf</p></a>
          <div class="blog-synopsis">a啊</div>
          <div>
            <span>2021.03.27</span>
            <div class="btn-group pull-right">
            </div>
          </div>
        </li>
        <li class="list-group-item">
          <a target="_blank" href="/post/32a67ad14d9842d6abeabb4f9507d32b" class="blog-title" ><p>object</p></a>
          <div class="blog-synopsis"></div>
          <div>
            <span>2020.12.29</span>
            <div class="btn-group pull-right">
            </div>
          </div>
        </li>
        <li class="list-group-item">
          <a>获取</a>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "author",
  data() {
    return {};
  },
  components: {},
  methods: {
    
  },
  mounted(){
    this.$route.params.username
  }
};
</script>

<style scoped lang="scss">
</style>