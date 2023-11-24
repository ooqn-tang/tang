<template>
  <div class="row">
    <div class="col-md-9 mb-2">
      <div class="card ">
        <div class="card-body">
          
        </div>
      </div>
    </div>
    <div class="col-md-3 mb-2">
      <notice></notice>
      <info></info>
    </div>
  </div>
</template>

<script setup>
import request from "@common/request";
import { onMounted, ref } from "vue";

import notice from '@components/notice.vue';
import info from '@components/info.vue';

let dynamicList = ref([{}]);


function loadDynamic() {
  request({
    url: `/api/message`,
    method: "GET",
  }).then((res) => {
    dynamicList.value = res.data;
  });
};


onMounted(() => {
  loadDynamic();
});

</script>

<style scoped>
body {
  overflow-y: scroll;
}
</style>