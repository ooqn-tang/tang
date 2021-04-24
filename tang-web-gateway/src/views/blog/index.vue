<template>
  <div class="row">
    <div class="col-md-9 column">
      <ul id="blog-list" class="list-group">
        <li class="list-group-item" v-for="(item,index) in blogData" :key="index">
          <router-link :to="{name: 'post', params: { id: item.blogId }}" class="blog-title"><p v-text="item.title"></p></router-link>
          <div class="blog-synopsis">{{item.synopsis}}</div>
          <div>
            <span class="date-color">{{item.createDate}}</span>
            <router-link :to="{name:'author',params:{username:item.username}}" class="pull-right">{{item.nickname}}</router-link>
          </div>
        </li>
        <li class="list-group-item">
          <a @click="loadBlog()">获取</a>
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
import { blogList } from "/@/api/blog"
export default {
  name: "blog",
  data() {
    return {
      param:{
        page:1
      },
      blogData:[],
      thisBlogPage:{},
      msg: 'Hello Vue 3.0 + Vite',
       messageList: [{},{}],
    }
  },
  components: {
    
  },
  methods: {
    loadBlog(){
      if(this.param.page > 0){
        blogList(this.param).then((response) => {
          this.thisBlogPage = response.data
          this.blogData = this.blogData.concat(response.data.list)
          this.param.page = response.data.nextPage
        })
      }
      
    }
  },
  mounted(){
    this.loadBlog()
  }
}
</script>

<style scoped lang="scss">
.red {
  color: red;
}
</style>