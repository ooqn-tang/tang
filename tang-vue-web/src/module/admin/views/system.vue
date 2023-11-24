<template>
  system
</template>

<script setup>
import { ref } from "vue";
import { useRoute, useRouter } from "vue-router";
import { useAuthorStore } from "@utils/user";
import { NButton, NSpace, NDataTable, NModal, NCard, NForm, NFormItem, NInput } from "naive-ui";

let router = useRouter();
let route = useRoute();
let authorStore = useAuthorStore();

let routeName = ref(route.name);
let activeName = ref('first')

</script>