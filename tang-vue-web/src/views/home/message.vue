<template>
  <div class="row">
    <div class="col-md-9 mb-2 move-p-lr-0">
      <div class="card move-b-lr-0">
        <div class="card-body" style="padding: 0">
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
    <div class="col-md-3 mb-2 move-p-lr-0">
      <div class="list-group mb-2 move-b-lr-0">
        <notice></notice>
      </div>
      <div class="card mb-2 move-b-lr-0">
        <info></info>
      </div>
    </div>
  </div>
</template>

<script setup>
import request from "utils/request";
import { onMounted, ref } from "vue";
import { useRouter, useRoute } from "vue-router";
import { useStore } from "vuex";

const route = useRoute();
const router = useRouter();
const store = useStore();

let authorList = ref([]);
let select = ref("");
let vList = ref([{}, {}, {}, {}, {}]);
let dynamicList = ref([]);

function selectTag(type){
  select.value = type;
  request({
    url: `/api/message`,
    method: "GET",
    params: { type: type },
  }).then((res) => {
    dynamicList.value = res.data;
  });
};

function authorListArticleCount(){
  request({
    url: `/api/author/authorListArticleCount`,
    method: "GET",
  }).then((res) => {
    authorList.value = res.data.list;
  });
};

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