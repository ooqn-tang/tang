<template>
  <div class="row">
    <div class="col-lg-12 move-p-lr-0">
      <div class="card mb-2 move-b-lr-0">
         <div class="card-body p-0">
           <nav class="nav">
              <a class="nav-link" :class="selectTag == 'Java'?'nav-link-active':''" @click="selectTagClick('Java')">动画</a>
              <a class="nav-link" :class="selectTag == 'Python'?'nav-link-active':''" @click="selectTagClick('Python')">知识</a>
              <a class="nav-link" :class="selectTag == '前端'?'nav-link-active':''" @click="selectTagClick('前端')">生活</a>
              <a class="nav-link" :class="selectTag == '数据库'?'nav-link-active':''" @click="selectTagClick('数据库')">舞蹈</a>
              <a class="nav-link" :class="selectTag == '面试'?'nav-link-active':''" @click="selectTagClick('面试')">游戏</a>
              <a class="nav-link" :class="selectTag == '面试'?'nav-link-active':''" @click="selectTagClick('面试')">科技</a>
              <a class="nav-link" :class="selectTag == 'Java'?'nav-link-active':''" @click="selectTagClick('Java')">影视</a>
              <a class="nav-link" :class="selectTag == 'Python'?'nav-link-active':''" @click="selectTagClick('Python')">资讯</a>
              <a class="nav-link" :class="selectTag == '前端'?'nav-link-active':''" @click="selectTagClick('前端')">鬼畜</a>
              <a class="nav-link" :class="selectTag == '数据库'?'nav-link-active':''" @click="selectTagClick('数据库')">时尚</a>
              <a class="nav-link" :class="selectTag == '面试'?'nav-link-active':''" @click="selectTagClick('面试')">放映厅</a>
              <a class="nav-link" :class="selectTag == '面试'?'nav-link-active':''" @click="selectTagClick('面试')">影视</a>
            </nav>
         </div>
       </div>
       <div class="row">
        <div class="col-xl-3 col-lg-4 col-md-4 col-12 mb-2 move-p-lr-0" v-for="(item,index) in videoList" :key="index">
          <div class="card move-b-lr-0">
            <img src="/kittens.jpg" class="card-img-top" alt="...">
            <div class="card-body">
              <p class="card-text text-truncate">Some quick example text to build</p>
            </div>
          </div>
        </div>
       </div>
    </div>
  </div>
    
  
</template>

<script>
export default {
  name: "video_index",
  data() {
    return {
      videoList:[{},{},{},{},{},{},{},{},{},{},{},{}]
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