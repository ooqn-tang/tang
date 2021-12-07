<template>
  <div class="row">
    <div class="col-md-9 mb-2 move-p-lr-0">
      <div class="row">
        <div
          class="col-xl-3 col-lg-4 col-md-4 col-12 mb-2 move-p-lr-0"
          v-for="(item, index) in authorList"
          :key="index">
          <div class="card move-b-lr-0">
            <div class="card-body">
              <p class="card-text text-truncate">
                <router-link target="_blank" :to="{name:'author_blog',params:{username:item.username}}">
                  <strong v-text="item.nickname"></strong>
                </router-link>
              </p>
              <p class="card-text text-truncate">简介：{{item.signature}}</p>
              <p class="card-text text-truncate">文章数：{{item.count}}</p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="col-md-3 mb-2 move-p-lr-0">
      <div class="list-group mb-2 move-b-lr-0">
        <notice></notice>
      </div>
      <div class="card mb-2 move-b-lr-0">
        <div class="card-body">
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
</template>

<script>
import { authorListBlogCount } from '/@/api/author.js'
export default {
  name: "author_list",
  data() {
    return {
      authorList: [{}, {}, {}, {}, {}, {}],
    };
  },
  methods: {
    authorListBlogCount(){
      authorListBlogCount().then((response) => {
        this.authorList = response.data.list
      })
    }
  },
  mounted() {
    this.authorListBlogCount()
  },
};
</script>

<style lang="scss">
body {
  overflow-y: scroll;
}
</style>