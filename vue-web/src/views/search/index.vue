<template>
  <div class="row">
    <div class="col-lg-8">
      <div class="input-group mb-2">
        <input type="text" class="form-control search-input" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="button-addon2">
        <button class="btn btn-outline-secondary search-button" type="button" id="button-addon2">搜索</button>
      </div>
      <div class="card mb-2">
         <div class="card-body p-0">
           <nav class="nav">
              <a class="nav-link" :class="selectTag == 'Java'?'nav-link-active':''" @click="selectTagClick('Java')">博客</a>
              <a class="nav-link" :class="selectTag == 'Python'?'nav-link-active':''" @click="selectTagClick('Python')">视频</a>
              <a class="nav-link" :class="selectTag == '前端'?'nav-link-active':''" @click="selectTagClick('前端')">文件</a>
              <a class="nav-link" :class="selectTag == '数据库'?'nav-link-active':''" @click="selectTagClick('数据库')">作者</a>
              <a class="nav-link" :class="selectTag == '面试'?'nav-link-active':''" @click="selectTagClick('面试')">标签</a>
              <a class="nav-link" :class="selectTag == '面试'?'nav-link-active':''" @click="selectTagClick('面试')">专辑</a>
            </nav>
         </div>
       </div>

       <ul class="list-group mb-2">
            <li class="list-group-item">
              <a class="blog-title">
                <strong><p>啊手动阀</p></strong>
                </a>
              <div class="blog-synopsis" style="color: #5f5a5a;">啊手动阀手动阀啊手动阀手动阀手动阀啊手动阀手动阀啊手动阀手动阀啊手动阀手动阀手动阀啊手动阀手动阀啊手动阀手动阀啊手动阀手动阀手动阀啊手动阀手动阀啊手动阀手动阀啊手动阀手动阀手动阀啊手动阀手动阀</div>
              <div>
                <span class="date-color" style="font-size: 16px;color: #5f5a5a;">2020.02.02</span>
                <span > . <span style="font-size: 16px;color: #dc3545;">Java</span></span>
                <a class="float-end">asdfasdf</a>
              </div>
            </li>
            <li class="list-group-item">
              <a>加载中...</a>
            </li>
       </ul>
    </div>
    <div class="col-lg-4">
      <div class="list-group mb-2">
        <notice></notice>
      </div>
      <div class="card mb-2">
        <div class="card-body">
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
    
  
</template>

<script>
export default {
  name: "search_index",
  data() {
    return {
    };
  },
  computed: {
    
  },
  created() {
  },
  methods: {
   
  },
  mounted(){
    
  }
};
</script>