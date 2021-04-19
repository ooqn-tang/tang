<template>
  
</template>

<script>
export default {
  name: 'nav',
  props: {
    title:"堂堂程序员",
    isLogin:True
  },
  emits: ['edit', 'update:modelValue'],
  data() {
    return {
      count: 0
    }
  },
  created() {
    console.log(666)
  },
  methods: {
    edit(){
      this.$emit('edit', this.msg + this.count)
    }
  }
}
</script>
