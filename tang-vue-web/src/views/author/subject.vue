<template>
  <ul class="list-group article-list">
    <li class="list-group-item" v-for="(item, index) in subjectList" :key="index">
      <router-link :to="{ name: 'subject_post', params: { subject_id: item.subjectId } }">
        <strong v-text="item.subjectName"></strong>
      </router-link>
      <div class="btn-group float-end">
        <button class="btn btn-outline-danger float-end blog-btn" @click="deleteClick(item.subjectId, index)">删除</button>
        <button class="btn btn-outline-danger float-end blog-btn" data-bs-toggle="modal" data-bs-target="#exampleModal"
          v-if="isThisUser" @click="updateClick(item.subjectId, item.subjectName, item.synopsis)">修改</button>
      </div>
      <div>
        {{ item.synopsis }}
      </div>
    </li>
    <li class="list-group-item " v-if="isThisUser">
      <a data-bs-toggle="modal" data-bs-target="#exampleModal" @click="dataFrom = {}, saveType = 'insert'">创建专辑</a>
    </li>
  </ul>

  <!-- Modal -->
  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">专辑</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">专辑名</label>
            <input class="form-control" id="exampleFormControlInput1" v-model="dataFrom.subjectName">
          </div>
          <div class="mb-3">
            <label for="exampleFormControlTextarea1" class="form-label">描述</label>
            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"
              v-model="dataFrom.synopsis"></textarea>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" ref="close">关闭</button>
          <button type="button" class="btn btn-primary" @click="save">保存</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { onMounted, ref } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { useStore } from 'vuex'

import request from 'utils/request'

let store = useStore()
let router = useRouter()
let route = useRoute()

let close = ref(null)
let isThisUser = ref(false)
let thisItem = ref({});
let subjectList = ref([])
let dataFrom = ref({
  subjectId: "",
  subjectName: "",
  synopsis: ""
})

let saveType = ref("update")// insert
let thisUsername = route.params.username

function selectSubjectListByUsername(username){
  request({
    url: `/api/subject/username/${username}`,
    method: 'GET',
  }).then((response) => {
    subjectList.value = response.data
  })
}

function save(){
  if (saveType.value == "insert") {
    request({
      url: `/api/subject`,
      method: 'POST',
      data: dataFrom.value
    }).then((response) => {
      subjectList.value.unshift(response.data)
      close.value.click()
    })
  } else {
    request({
      url: `/api/subject`,
      method: 'PUT',
      data: dataFrom.value
    }).then((response) => {
      alert(JSON.stringify(response.data))
    })
  }

}

function updateClick(subjectId, subjectName, synopsis){
  dataFrom.value.subjectId = subjectId;
  dataFrom.value.subjectName = subjectName;
  dataFrom.value.synopsis = synopsis;
  saveType.value = 'update'
}

function deleteClick(subjectId, index){
  if(confirm("确认删除吗？")){
    request({
      url: `/api/subject/${subjectId}`,
      method: 'DELETE'
    }).then((response) => {
      subjectList.value.splice(index, 1);
    })
  }
}

onMounted(() => {
  selectSubjectListByUsername(thisUsername)
  isThisUser.value = thisUsername == store.state.username
})

</script>

<style scoped>
body {
  overflow-y: scroll;
}
</style>