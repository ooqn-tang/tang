<template>
  <div class="row">
    <div class="col-lg-12 move-p-lr-0">
      <div class="card mb-2 move-b-lr-0">
        <div class="card-body p-0">
          <nav class="nav">
            <a
              class="nav-link"
              :class="selectTag == 'Java' ? 'nav-link-active' : ''"
              @click="selectTagClick('Java')"
              >动画</a
            >
            <a
              class="nav-link"
              :class="selectTag == 'Python' ? 'nav-link-active' : ''"
              @click="selectTagClick('Python')"
              >知识</a
            >
            <a
              class="nav-link"
              :class="selectTag == '前端' ? 'nav-link-active' : ''"
              @click="selectTagClick('前端')"
              >生活</a
            >
            <a
              class="nav-link"
              :class="selectTag == '数据库' ? 'nav-link-active' : ''"
              @click="selectTagClick('数据库')"
              >舞蹈</a
            >
            <a
              class="nav-link"
              :class="selectTag == '面试' ? 'nav-link-active' : ''"
              @click="selectTagClick('面试')"
              >游戏</a
            >
            <a
              class="nav-link"
              :class="selectTag == '面试' ? 'nav-link-active' : ''"
              @click="selectTagClick('面试')"
              >科技</a
            >
            <a
              class="nav-link"
              :class="selectTag == 'Java' ? 'nav-link-active' : ''"
              @click="selectTagClick('Java')"
              >影视</a
            >
            <a
              class="nav-link"
              :class="selectTag == 'Python' ? 'nav-link-active' : ''"
              @click="selectTagClick('Python')"
              >资讯</a
            >
            <a
              class="nav-link"
              :class="selectTag == '前端' ? 'nav-link-active' : ''"
              @click="selectTagClick('前端')"
              >鬼畜</a
            >
            <a
              class="nav-link"
              :class="selectTag == '数据库' ? 'nav-link-active' : ''"
              @click="selectTagClick('数据库')"
              >时尚</a
            >
            <a
              class="nav-link"
              :class="selectTag == '面试' ? 'nav-link-active' : ''"
              @click="selectTagClick('面试')"
              >放映厅</a
            >
            <a
              class="nav-link"
              :class="selectTag == '面试' ? 'nav-link-active' : ''"
              @click="selectTagClick('面试')"
              >影视</a
            >
          </nav>
        </div>
      </div>
      <div class="row">

      <div class="col-xl-12 col-lg-12 col-md-12 col-12 mb-2">
          <div class="card move-b-lr-0">
            <div class="card-body">
             <textarea class="form-control mb-2"></textarea>
              <div style="line-height:38px">
                  所在标签
                  <button class="btn btn-secondary float-end">发布</button>
              </div>
            </div>
          </div>
        </div>


        <div
          class="col-xl-3 col-lg-4 col-md-4 col-12 mb-2"
          v-for="(item, index) in laokeList"
          :key="index"
        >
          <div class="card move-b-lr-0">
            <div class="card-body">
              <div>
                <a href="/author/eHlw" target="_blank" class="">平安喜乐</a>
                <span class="date-color float-end" style="font-size: 16px">2021.09.16</span>
              </div>
              Some quick fasdfasd fasdfa sdfasdfasd fasdf asdf asdfexa mple text to
              build <a href="#">更多</a>
              <div>
                  <span style="font-size: 16px; color: rgb(220, 53, 69)">前端</span>
                  <span class=" float-end">评论(1)</span> 
                  <span class=" float-end"> 点赞(1)</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "laoke_index",
  data() {
    return {
      laokeList: [{}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}],
    };
  },
  computed: {},
  created() {},
  methods: {},
  mounted() {},
};
</script>