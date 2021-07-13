<template>
  <a v-for="(item,index) in advList" :key="index" v-bind:href="item.url" class="list-group-item">{{item.title}}</a>
</template>

<script>
import {loadAdvertise} from '/@/api/advertise'
export default {
  name: 'advertise',
  data() {
    return {
      count: 0,
      advList:[]
    }
  },
  created() {
    console.log(666)
  },
  methods: {
    loadAdvertise(){
        loadAdvertise().then((response) => {
            this.advList = response.data
        })
    }
  },
  mounted(){
      this.loadAdvertise()
  }
}
</script>
