<template>
  <div class="row">
    <div class="col-xl-12 col-lg-12 col-md-12 col-12 mb-2 move-p-lr-0">
      <div class="card move-b-lr-0">
        <div class="card-body">
          <label for="exampleFormControlTextarea1" class="form-label"
            >消息</label
          >
          <label for="exampleFormControlTextarea1" class="form-label float-end"
            >{{laokeForm.text.length}}/200</label
          >
          <textarea
            class="form-control mb-2"
            placeholder="最多200字"
            v-model="laokeForm.text"
            maxlength="200"
            rows="5"
          ></textarea>
          <div style="line-height: 38px">
            <div class="input-group">
              <select
                class="form-select"
                id="inputGroupSelect04"
                aria-label="Example select with button addon"
                v-model="laokeForm.type"
              >
                <option value="0" selected>唠嗑</option>
                <option value="1">问题</option>
                <option value="2">想法</option>
              </select>
              <button class="btn btn-outline-secondary" type="button" @click="sendLaoke()">
                发送
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
    
    <div class="col-xl-3 col-lg-4 col-md-4 col-12 mb-2 move-p-lr-0" v-for="(item, index) in laokeList" :key="index">
      <div class="card move-b-lr-0">
        <div class="card-body" >
          <div>
            <a :href="'/author/' + item.nickname" target="_blank" class="">{{item.nickname}}</a>
            <span class="date-color float-end" style="font-size: 16px">{{item.createDate}}</span>
          </div>
          <div class="text-truncate" @click="thisItem = item" data-bs-target="#lkMsg" data-bs-toggle="modal">
            {{item.text}}
            <div @click="thisItem = item">
              <span style="font-size: 16px; color: #198754" v-if="item.type == 0">唠嗑</span>
              <span style="font-size: 16px; color: #dc3545" v-if="item.type == 1">问题</span>
              <span style="font-size: 16px; color: #fd7e14" v-if="item.type == 2">想法</span>
              <span class="float-end">评论(1)</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div
    class="modal fade"
    id="lkMsg"
    tabindex="-1"
    aria-labelledby="lkMsgLabel"
    aria-hidden="true"
  >
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="lkMsgLabel">评论</h5>
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></button>
        </div>
        <!-- form-control -->
        <div class="modal-body move-p-lr-0">
          <div class="card mb-2 move-b-lr-0">
            <div class="card-body">
              <div>
                <a href="/author/eHlw" target="_blank" class="">{{thisItem.nickname}}</a>
                <span class="date-color float-end" style="font-size: 16px">2021.09.16</span>
              </div>
              <div>
                {{thisItem.text}}
              </div>
            </div>
          </div>
          <div class="input-group mb-2 move-b-lr-0">
            <input
              type="text"
              class="form-control"
              placeholder="Recipient's username"
              aria-label="Recipient's username"
              aria-describedby="button-addon2"
            />
            <button
              class="btn btn-outline-secondary"
              type="button"
              id="button-addon2"
            >
              发送
            </button>
          </div>

          <div
            class="card mb-2 move-b-lr-0"
            style="background: #f3f2f2"
            v-for="(item, index) in lst"
            :key="index"
          >
            <div class="card-body">
              <div style="font-size: 15px">
                <a href="/author/eHlw" target="_blank" class="">平安喜乐</a>
                <span class="date-color float-end">2021.09.16</span>
              </div>
              This is some text within a card body.
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { sendLaoke,loadLaoke,deleteLaoke } from "/@/api/laoke"
export default {
  name: "laoke_index",
  data() {
    return {
      laokeList: [],
      lst: [{},{},{},{}],
      message:"",
      thisItem:{},
      laokeForm:{
        text:"",
        type:"0",
      },
      msgForm:{
        comment:""
      }
    };
  },
  computed: {},
  created() {},
  methods: {
    openMsg(item){
      this.thisItem = item
    },
    sendLaoke(){
      sendLaoke(this.laokeForm).then((response) => {
        this.laokeForm.text = ""
        this.loadLaoke()
      })
    },
    sendMsg(){
      sendMsg(this.msgForm).then((response) => {

      })
    },
    loadLaoke(){
      loadLaoke().then((response) => {
        this.laokeList = response.data.list
      })
    },
    loadMsg(id){
      loadMsg(id).then((response) => {

      })
    },
    deleteLaoke(id){
      deleteLaoke(id).then((response) => {
        
      })
    },
    deleteMsg(id){
      deleteMsg(id).then((response) => {
        
      })
    }
  },
  mounted() {
    this.loadLaoke()
  },
};
</script>