<template>
  <div class="row clearfix">
    <div class="col-md-4 col-md-push-8">
      <div class="card margin-bottom10">
        <div class="card-body ">
          <strong>管理员</strong>
          <button class="btn btn-outline-warning float-end" style="padding: 0px 5px 0px 3px;font-size: 13px;">订阅</button>
          <hr />
          <div>简介：<span>不得了的人物</span></div>
        </div>
      </div>
      <div class="list-group margin-bottom10">
        <a class="list-group-item active" >广播<span class="pull-right">🎇</span></a>
        <a target="_blank" href="http://www.ttcxy.net/post/098384e9a34d438480289ad23c8625ba" class="list-group-item">公众号推荐列表</a>
      </div>
    </div>
    <div class="col-md-8 col-md-pull-4">
      <div class="card">
        <div class="card-header">
          <ul class="nav nav-tabs card-header-tabs">
            <li class="nav-item">
              <a class="nav-link active" aria-current="true" href="#">博客</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">专栏</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">收藏</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">设置</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">关于</a>
            </li>
          </ul>
        </div>
        <div class="card-body blog-list">
          <ul class="list-group">
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