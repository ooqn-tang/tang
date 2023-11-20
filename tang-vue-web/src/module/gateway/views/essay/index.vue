<template>
  <div class="row">
        <div class="col-md-6 mb-2">
      <div class="mb-2">
        <input class="form-control" list="datalistOptions" id="exampleDataList" v-model="form.tagName" placeholder="输入标签">
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
          <div class="card-body">
            <div class="input-group">
              <textarea v-model="form.text" class="form-control" rows="3"  placeholder="输入的内容不包含标签的内容会在最后追加标签中的内容。" id="textarea"></textarea>
              <button class="btn btn-outline-secondary" type="button" id="button-addon2" @click="insertEssay">发送</button>
            </div>
          </div>
        </div>
      </div>
      <div class="mb-2" v-for="(item, index) in essayList" :key="index">
        <div class="card ">
          <div class="card-body">
            <p>{{ item.author.nickname }} <span class="float-end">{{ item.createTime }}</span></p>
            <div>{{ item.text }}  <span class="badge text-bg-primary">#{{ item.tagName }}</span></div>
            <div class="row">
              <div class="col-4">
                <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-chat-dots tag" viewBox="0 0 16 16">
                  <path d="M5 8a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm4 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm3 1a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"/>
                  <path d="m2.165 15.803.02-.004c1.83-.363 2.948-.842 3.468-1.105A9.06 9.06 0 0 0 8 15c4.418 0 8-3.134 8-7s-3.582-7-8-7-8 3.134-8 7c0 1.76.743 3.37 1.97 4.6a10.437 10.437 0 0 1-.524 2.318l-.003.011a10.722 10.722 0 0 1-.244.637c-.079.186.074.394.273.362a21.673 21.673 0 0 0 .693-.125zm.8-3.108a1 1 0 0 0-.287-.801C1.618 10.83 1 9.468 1 8c0-3.192 3.004-6 7-6s7 2.808 7 6c0 3.193-3.004 6-7 6a8.06 8.06 0 0 1-2.088-.272 1 1 0 0 0-.711.074c-.387.196-1.24.57-2.634.893a10.97 10.97 0 0 0 .398-2z"/>
                </svg>
              </div>
              <div class="col-4" style="text-align: center;">
                <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-balloon-heart tag" viewBox="0 0 16 16">
                  <path fill-rule="evenodd" d="m8 2.42-.717-.737c-1.13-1.161-3.243-.777-4.01.72-.35.685-.451 1.707.236 3.062C4.16 6.753 5.52 8.32 8 10.042c2.479-1.723 3.839-3.29 4.491-4.577.687-1.355.587-2.377.236-3.061-.767-1.498-2.88-1.882-4.01-.721L8 2.42Zm-.49 8.5c-10.78-7.44-3-13.155.359-10.063.045.041.089.084.132.129.043-.045.087-.088.132-.129 3.36-3.092 11.137 2.624.357 10.063l.235.468a.25.25 0 1 1-.448.224l-.008-.017c.008.11.02.202.037.29.054.27.161.488.419 1.003.288.578.235 1.15.076 1.629-.157.469-.422.867-.588 1.115l-.004.007a.25.25 0 1 1-.416-.278c.168-.252.4-.6.533-1.003.133-.396.163-.824-.049-1.246l-.013-.028c-.24-.48-.38-.758-.448-1.102a3.177 3.177 0 0 1-.052-.45l-.04.08a.25.25 0 1 1-.447-.224l.235-.468ZM6.013 2.06c-.649-.18-1.483.083-1.85.798-.131.258-.245.689-.08 1.335.063.244.414.198.487-.043.21-.697.627-1.447 1.359-1.692.217-.073.304-.337.084-.398Z"/>
                </svg>
              </div>
              <div class="col-4" style="text-align: right;">
                <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-cursor tag" viewBox="0 0 16 16">
                  <path d="M14.082 2.182a.5.5 0 0 1 .103.557L8.528 15.467a.5.5 0 0 1-.917-.007L5.57 10.694.803 8.652a.5.5 0 0 1-.006-.916l12.728-5.657a.5.5 0 0 1 .556.103zM2.25 8.184l3.897 1.67a.5.5 0 0 1 .262.263l1.67 3.897L12.743 3.52 2.25 8.184z"/>
                </svg>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    
    <div class="col-md-3 mb-2">
      <ul class="list-group">
        <li class="list-group-item active">推荐标签</li>
        <li class="list-group-item" v-for="(item,index) in tagList" @click="selectTag(item)">{{ item.text }}</li>
      </ul>
    </div>
    <div class="col-md-3 mb-2">
      <ul class="list-group">
        <li class="list-group-item active">最近使用</li>
        <li class="list-group-item" v-for="(item,index) in tagList" @click="selectTag(item)">{{ item.text }}</li>
      </ul>
    </div>
  </div>
</template>

<script setup>

import request from "@utils/request";
import { onMounted, ref } from "vue";

let page = ref({
  number: 0
});
let essayList = ref([]);
let form = ref({
  text: "",
  tagName:""
});

form.value.text = ''

let tagList = ref([
  {text:'Test1'},
  {text:'Test2'},
  {text:'Java'},
  {text:'C#'},
  {text:'Python'}
])

function loadEssay() {
  request({
    url: `/api/essay`,
    method: "get",
    params: { page: page.number }
  }).then((res) => {
    page = res.data;
    for (const obj of res.data.content) {
      essayList.value.push(obj)
    }
  });
};

function insertEssay() {
  request({
    url: `/api/essay`,
    method: "post",
    data: form.value
  }).then((res) => {
    form.value = {};
    essayList.value.unshift(res.data);
  });
};

function next() {
  if (!page.value.last) {
    page.value.number += 1;
    loadEssay();
  }
};

function selectTag(item){
  form.value.tagName = item.text
}

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

.tag:hover{
 color: cadetblue;
}

</style>