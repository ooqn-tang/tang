<template>
  <ul class="list-group article-list">
    <li class="list-group-item" v-for="(item, index) in subjectList">
      <router-link :to="{ name: 'subject_post', params: { subject_id: item.subjectId } }">
        <strong v-text="item.subjectName"></strong>
      </router-link>
      <div class="btn-group float-end">
        <button class="btn btn-outline-danger float-end btn-sm" @click="deleteClick(item.subjectId, index)"
          v-if="isThisUser">删除</button>
        <button class="btn btn-outline-danger float-end btn-sm" @click="updateClick(item)" v-if="isThisUser" data-bs-toggle="modal"
          data-bs-target="#exampleModal">修改</button>
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
import { useRoute } from 'vue-router'
import { useAuthorStore } from '@common/user'

import request from '@common/request'

let authorStore = useAuthorStore()
let route = useRoute()

let close = ref(null)
let isThisUser = ref(false)
let subjectList = ref([])
let dataFrom = ref({
  subjectId: "",
  subjectName: "",
  synopsis: ""
})

let saveType = ref("update")
let thisUsername = route.params.username

function selectSubjectListByUsername(username) {
  request({
    url: `/api/subject/username/${username}`,
    method: 'GET',
  }).then((res) => {
    subjectList.value = res.data
  })
}

function save() {
  if (saveType.value == "insert") {
    request({
      url: `/api/subject`,
      method: 'POST',
      data: dataFrom.value
    }).then((res) => {
      subjectList.value.unshift(res.data)
      close.value.click()
    })
  } else {
    request({
      url: `/api/subject`,
      method: 'PUT',
      data: dataFrom.value
    }).then((res) => {
      alert(JSON.stringify(res.data))
      close.value.click()
    })
  }

}

function updateClick(item) {
  dataFrom.value.subjectId = item.subjectId;
  dataFrom.value.subjectName = item.subjectName;
  dataFrom.value.synopsis = item.synopsis;
  saveType.value = 'update'
}

function deleteClick(subjectId, index) {
  if (confirm("确认删除吗？")) {
    request({
      url: `/api/subject/${subjectId}`,
      method: 'DELETE'
    }).then((res) => {
      subjectList.value.splice(index, 1);
    })
  }
}

onMounted(() => {
  selectSubjectListByUsername(thisUsername)
  isThisUser.value = thisUsername == authorStore.author.username
})

</script>

<style scoped></style>