<template>
  <div class="row">
    <div class="col-lg-8 move-p-lr-0">
      <div class="input-group mb-2 move-search">
        <input type="text" class="form-control search-input" v-model="form.wb" placeholder="请输入" aria-label="请输入" aria-describedby="button-addon2">
        <button class="btn btn-outline-secondary search-button" type="button" id="button-addon2" @click="so">搜索</button>
      </div>
       <ul class="list-group mb-2 move-b-lr-0">
            <li class="list-group-item" v-for="(item,index) in videoList" :key="index">
              
              <div class="article-synopsis" style="color: #5f5a5a;">
                <img :src="item.coverUrl" style="max-width: 100%;">
              </div>
              <a class="article-title"><strong><p>{{item.title}}</p></strong></a>
              <div>
                <span class="date-color" style="font-size: 16px;color: #5f5a5a;">2020.02.02</span>
                <span > . <span style="font-size: 16px;color: #dc3545;">Java</span></span>
                <a class="float-end">{{item.nickname}}</a>
              </div>
            </li>
       </ul>
    </div>
    <div class="col-lg-4 move-p-lr-0">
      <div class="list-group mb-2 move-b-lr-0">
        <notice></notice>
      </div>
      <div class="card mb-2 move-b-lr-0">
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
import request from 'src/utils/request'
export default {
  name: "search_index",
  data() {
    return {
      searchText:"视频",
      form:{

      },
      videoList:[],
      videoData:{

      }
    };
  },
  computed: {
    
  },
  created() {
  },
  methods: {
   so(){
    this.form.page = this.videoData.nextPage
    request({
      url: '/api/video/so',
      method: 'GET',
      params:this.form
    }).then((response) => {
      this.videoList = response.data.list
    })
   }
  },
  mounted(){
    
  }
};
</script>