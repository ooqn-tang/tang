<template>
  <a class="list-group-item active">TOP<span class="float-end">🎇</span></a>
  <a v-for="(item,index) in advList" :key="index" v-bind:href="item.url" class="list-group-item">{{item.title}}</a>
</template>

<script>
import {loadNotice} from '/@/api/notice'
export default {
  name: 'notice',
  data() {
    return {
      count: 0,
      advList:[]
    }
  },
  created() {
  },
  methods: {
    loadNotice(){
        loadNotice().then((response) => {
            this.advList = response.data
        })
    }
  },
  mounted(){
      this.loadNotice()
  }
}
</script>
