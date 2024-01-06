<template>
    <div class="row h-100">
        <div class="col-md-4 h-100 pb-2" :class="mh == 'left' ? '' : 'm-h'">
            <div class="h-100" style="display: flex;flex-direction: column;height: 100%;padding: 0px;">
                <div class="input-group" style="margin-bottom: 1px;">
                    <input type="text" class="form-control" aria-label="Text input with segmented dropdown button">
                    <button type="button" class="btn btn-outline-secondary">搜索</button>
                    <button type="button" class="btn btn-outline-secondary dropdown-toggle dropdown-toggle-split"
                        data-bs-toggle="dropdown" aria-expanded="false">
                        <span class="visually-hidden">Toggle Dropdown</span>
                    </button>
                    <ul class="dropdown-menu dropdown-menu-end">
                        <li><a class="dropdown-item" href="#">增加好友</a></li>
                        <li><a class="dropdown-item" href="#">增加群</a></li>
                        <li><a class="dropdown-item" href="#">创建群</a></li>
                    </ul>
                </div>
              
                <div class="box"
                    style="height: 100%;flex-grow: 1;overflow-y: auto;padding: 5px;border: 1px solid #dee2e6;margin: 5px 0px 0px 0px;">
                    <div class="box-list" style="height: 0;">
                        <div v-for="item in memeberList" @click="selectMember(item); mh = 'right'" class="border-bottom"
                            v-show="item.username != authorStore.author.username">
                            <p>{{ item.nickname }}</p>
                            <p style="color: #bbbbbb;">{{ item.signature }}&nbsp;</p>
                        </div>
                    </div>
                </div>

                <div class="btn-group" role="group" aria-label="Basic outlined example" style="margin: 5px 0px 0 0;">
                    <button type="button" class="btn" :class="type == 'message' ? 'btn-primary' : 'btn-outline-primary'" @click="changeTab('message')">消息</button>
                    <button type="button" class="btn" :class="type == 'contacts' ? 'btn-primary' : 'btn-outline-primary'" @click="changeTab('contacts')">通讯录</button>
                    <button type="button" class="btn" :class="type == 'me' ? 'btn-primary' : 'btn-outline-primary'" @click="changeTab('me')">我的</button>
                </div>
            </div>
           
        </div>
        <div class="col-md-8 h-100 pb-2" :class="mh == 'right' ? '' : 'm-h'">
            <div class="h-100" style="display: flex;flex-direction: column;height: 100%;padding: 0px;">
                <div class="card" style="border: 1px solid rgb(222, 226, 230);">
                    <div class="card-body" style="padding: 6px 10px;vertical-align:top;display: inline-block;">
                        <span class="align-middle">{{ member.nickname }}</span>
                        <span style="float: right;" @click="mh = 'left'">
                            ✖️
                        </span>
                    </div>
                </div>
                <div class="box"
                    style="height: 100%;flex-grow: 1;overflow-y: auto;padding: 5px;border: 1px solid #dee2e6;margin: 5px 0px;">
                    <div class="box-list" style="height: 0;">
                        <div v-for="item in messageList">
                            <p style="color: rgb(8, 78, 184);font-weight: bold;">{{ item.sendName }}</p>
                            <p class="border rounded p-2">{{ item.content }}&nbsp;</p>
                        </div>
                    </div>
                </div>
                <div class="input-group">
                    <input v-model="message" type="text" class="form-control" placeholder="Recipient's username"
                        aria-label="Recipient's username" aria-describedby="button-addon2">
                    <button class="btn btn-outline-secondary" type="button" id="button-addon2"
                        @click="sendMessage()">发送</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { onMounted, ref,inject  } from "vue";
import { refresh } from "@gateway/apis/utils";

import { useAuthorStore } from "@common/user";

let authorStore = useAuthorStore();

// 获取url中的参数 type
let type = ref(new URLSearchParams(window.location.search).get("type"))
if(type.value == null){
    type.value = "message"
}

let mh = ref("left");
let message = ref("");
let messageList = ref([])
let member = ref({});
let monsterSocket = inject("$ms");


monsterSocket.setHeader("Message", (msg) => {
    messageList.value.push(msg.data)
    console.log(msg)
})

monsterSocket.setHeader("MessageList", (msg) => {
    messageList.value.push(msg.data)
    console.log(msg.data)
})

function changeTab(tab){
    type.value = tab
    // 修改url中的参数 ，更改type = tab
    let url = new URL(window.location.href)
    url.searchParams.set("type", tab)
    window.history.pushState({}, 0, url)
}

function sendMessage() {
    let send = {
        acceptName: member.value.username,
        sendName: authorStore.author.username,
        content: message.value,
        createTime: new Date(),
        updateTime: new Date()
    }
    messageList.value.push(send);
    
    monsterSocket.sendMessage(message.value, member.value.username, (msg) => {
        if (msg.status == 200) {
            console.log(msg.message);

        }
    });
    message.value = "";
}

function selectMember(item) {
    member.value = item;
    monsterSocket.messageList(item.username, (msg) => {
        if (msg.status == 200) {
            messageList.value = msg.data
        }
    })
}

let memeberList = ref([])

monsterSocket.watchList((msg) => {
    if (msg.status == 200) {
        memeberList.value = msg.data;
    }
})

</script>
<style>
.modal-rgba {
    background: rgba(0, 0, 0, 0.075);
}
</style>