<template>
  
</template>

<script>
export default {
  name: 'nav',
  props: {
    title:"哔哩哔哩"
  },
  emits: ['edit', 'update:modelValue'],
  data() {
    return {
      count: 0
    }
  },
  created() {
  },
  methods: {
    edit(){
      this.$emit('edit', this.msg + this.count)
    }
  }
}
</script>
