<template>
  <div class="row">
    <div class="col-md-6 mb-2">
      <div class="mb-2">
        <input class="form-control" list="datalistOptions" id="exampleDataList" placeholder="Type to search...">
        <datalist id="datalistOptions">
          <option value="San Francisco" />
          <option value="New York" />
          <option value="Seattle" />
          <option value="Los Angeles" />
          <option value="Chicago" />
        </datalist>
      </div>
      <div class="mb-2">
        <div class="card ">
          <div class="card-body" style="height: 6.5em;">
            <div class="input-group" style="height: 100%;">
              <textarea v-model="form.text" class="form-control" id="textarea" style="height: 100%;"></textarea>
              <button class="btn btn-outline-secondary" type="button" id="button-addon2" @click="insertEssay">发送</button>
            </div>
          </div>
        </div>
      </div>
      <div class="mb-2" v-for="(item, index) in essayList" :key="index">
        <div class="card ">
          <div class="card-body">
            <p>{{ item.author.nickname }} <span class="float-end">{{ item.createTime }}</span></p>
            <div>{{ item.text }}</div>
            <div class="row">
              <div class="col-md-3">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chat-left-dots" viewBox="0 0 16 16">
                  <path d="M14 1a1 1 0 0 1 1 1v8a1 1 0 0 1-1 1H4.414A2 2 0 0 0 3 11.586l-2 2V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12.793a.5.5 0 0 0 .854.353l2.853-2.853A1 1 0 0 1 4.414 12H14a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                  <path d="M5 6a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"/>
                </svg>
              </div>
              <div class="col-md-3">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cursor" viewBox="0 0 16 16">
                  <path d="M14.082 2.182a.5.5 0 0 1 .103.557L8.528 15.467a.5.5 0 0 1-.917-.007L5.57 10.694.803 8.652a.5.5 0 0 1-.006-.916l12.728-5.657a.5.5 0 0 1 .556.103zM2.25 8.184l3.897 1.67a.5.5 0 0 1 .262.263l1.67 3.897L12.743 3.52 2.25 8.184z"/>
                </svg>
              </div>
              <div class="col-md-3">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart" viewBox="0 0 16 16">
                  <path d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"/>
                </svg>
              </div>
              <div class="col-md-2">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart" viewBox="0 0 16 16">
                  <path d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"/>
                </svg>
              </div>
              <div class="col-md-1" style="text-align: right;">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart" viewBox="0 0 16 16">
                  <path d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"/>
                </svg>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="col-md-3 mb-2">
      <ul class="list-group">
        <li class="list-group-item active">相关</li>
        <li class="list-group-item">A second item</li>
        <li class="list-group-item">A third item</li>
        <li class="list-group-item">A fourth item</li>
        <li class="list-group-item">And a fifth one</li>
        <li class="list-group-item">An item</li>
        <li class="list-group-item">A second item</li>
        <li class="list-group-item">A third item</li>
        <li class="list-group-item">A fourth item</li>
        <li class="list-group-item">And a fifth one</li>
        <li class="list-group-item">An item</li>
        <li class="list-group-item">A second item</li>
        <li class="list-group-item">A third item</li>
        <li class="list-group-item">A fourth item</li>
        <li class="list-group-item">And a fifth one</li>
        <li class="list-group-item">An item</li>
        <li class="list-group-item">A second item</li>
      </ul>
    </div>
    <div class="col-md-3 mb-2">
      <ul class="list-group">
        <li class="list-group-item active">推荐</li>
        <li class="list-group-item">A second item</li>
        <li class="list-group-item">A third item</li>
        <li class="list-group-item">A fourth item</li>
        <li class="list-group-item">And a fifth one</li>
        <li class="list-group-item">An item</li>
        <li class="list-group-item">A second item</li>
        <li class="list-group-item">A third item</li>
        <li class="list-group-item">A fourth item</li>
        <li class="list-group-item">And a fifth one</li>
        <li class="list-group-item">An item</li>
        <li class="list-group-item">A second item</li>
        <li class="list-group-item">A third item</li>
        <li class="list-group-item">A fourth item</li>
        <li class="list-group-item">And a fifth one</li>
        <li class="list-group-item">An item</li>
        <li class="list-group-item">A second item</li>
      </ul>
    </div>
  </div>
</template>

<script setup>

import request from "utils/request";
import { onMounted, ref } from "vue";

let page = ref({
  number: 0
});
let essayList = ref([]);
let form = {
  text: ""
};

function loadEssay() {
  request({
    url: `/api/essay`,
    method: "get",
    params: { page: page.value.number }
  }).then((res) => {
    page.value = res.data;
    essayList.value = essayList.value.concat(res.data.content);
  });
};

function insertEssay() {
  request({
    url: `/api/essay`,
    method: "post",
    data: form
  }).then((res) => {
    form = {};
    essayList.value.unshift(res.data);
  });
};

function next() {
  if (!page.last) {
    page.value.number += 1;
    loadEssay();
  }
};

onMounted(() => {
  loadEssay();
});
</script>

<style scoped>
strong p,
.card-body p {
  margin: 0px;
}

.red {
  color: red;
}

.t-nav-link {
  margin: 0 20px;
  line-height: 40px;
  float: left;
}


strong p,
.card-body p {
  margin: 0px;
}

.red {
  color: red;
}

.t-nav-link {
  margin: 0 20px;
  line-height: 40px;
  float: left;
}

#textarea {

  resize: none;

}
</style>