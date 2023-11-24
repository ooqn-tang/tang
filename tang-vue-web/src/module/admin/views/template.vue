<template>
  <div style="height: calc(100%);">
    <Codemirror border :options="cmOptions"></Codemirror>
  </div>
</template>
  
<script setup>
import { ref } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useAuthorStore } from "@common/user";
import Codemirror from 'codemirror-editor-vue3';

import "codemirror/addon/display/placeholder.js";
import "codemirror/mode/javascript/javascript.js";
import "codemirror/addon/display/placeholder.js";
import "codemirror/theme/dracula.css";
import "v-contextmenu/dist/themes/default.css";

let router = useRouter();
let route = useRoute();
let authorStore = useAuthorStore();

let cmOptions = ref({
    mode: "text/javascript", // Language mode
    theme: "dracula", // Theme
})

</script>
<style>
  .codemirror-container {
    display: block !important;
   }
</style>