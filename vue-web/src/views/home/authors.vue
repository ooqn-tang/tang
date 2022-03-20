<template>
  <div class="row">
    <div class="col-md-9 mb-2">
      <div class="row">
        <div
          class="col-xl-3 col-lg-4 col-md-4 col-12 mb-2 move-p-lr-0"
          v-for="(item, index) in authorList"
          :key="index">
          <div class="card move-b-lr-0">
            <div class="card-body">
              <p class="card-text text-truncate">
                <router-link target="_blank" :to="{name:'author_video',params:{username:item.username}}">
                  <strong v-text="item.nickname"></strong>
                </router-link>
              </p>
              <p class="card-text text-truncate">简介：{{item.signature}}</p>
              <!-- <p class="card-text text-truncate">文章数：{{item.count}}</p> -->
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
        <info></info>
      </div>
    </div>
  </div>
</template>

<script>
import request from 'utils/request'
export default {
  name: "authors",
  data() {
    return {
      authorList: [],
    };
  },
  methods: {
    authorListArticleCount(){
      request({
        url: '/api/author/authorListArticleCount',
        method: 'GET'
      }).then((response) => {
        this.authorList = response.data.list
      })
    }
  },
  mounted() {
    this.authorListArticleCount()
  },
};
</script>

<style lang="scss">
body {
  overflow-y: scroll;
}
</style>