<template>
  <div class="row">
    <div class="col-md-9 mb-2">
      <div class="card ">
        <div class="card-body">
          <ul class="list-group article-list">
            <li
              class="list-group-item"
              v-for="(item, index) in dynamicList"
              :key="index"
            >
              <div class="row">
                <div class="col">
                  <a target="_blank" :href="item.url">{{ item.nickname }}{{item.title}}</a><span class="float-end">{{item.createDate}}</span>
                  <br/>
                  {{item.text}}
                </div>
              </div>
            </li>
          </ul>
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
import request from "utils/request";
import { onMounted, ref } from "vue";

import notice from 'components/notice.vue';
import info from 'components/info.vue';

let dynamicList = ref([{}]);


function loadDynamic(){
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