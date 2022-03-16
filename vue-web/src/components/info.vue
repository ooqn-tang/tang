<template>
  <div class="card-header" @click="zz = true">
  赞助
  </div>
  <div class="card-body" v-if="zz">
    <img src="/kittens.jpg" style="width:100%">
  </div>
</template>

<script>
export default {
  name: 'info',
  data() {
    return {
      count: 0,
      advList:[],
      zz:false
    }
  },
  created() {
  },
  methods: {
  },
  mounted(){
    
  }
}
</script>
