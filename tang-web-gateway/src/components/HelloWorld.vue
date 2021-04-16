<template>
  <slot></slot>
  <h1>{{ msg }}</h1>
  <button @click="edit();count++">count is: {{ count }}</button>
  <p>Edit <code>components/HelloWorld.vue</code> to test hot module replacement.</p>
  <input :value="modelValue" @input="$emit('update:modelValue', $event.target.value)"/>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String,
    modelValue: String
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
