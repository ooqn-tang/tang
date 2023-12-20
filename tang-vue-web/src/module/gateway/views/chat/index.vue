<template>
    <div class="row h100">
        <div class="col-md-4 h100 pb-2" :class="mh == 'left' ? '' : 'm-h'">
            <div class="h100" style="display: flex;flex-direction: column;height: 100%;padding: 0px;">
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
                    <div class="box-list">
                        <div v-for="item in memeberList" @click="selectMember(item); mh = 'right'"
                            v-show="item.username != authorStore.username">
                            <p>{{ item.nickname }}</p>
                            <p style="color: #bbbbbb;">{{ item.signature }}&nbsp;</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-8 h100 pb-2" :class="mh == 'right' ? '' : 'm-h'">
            <div class="h100" style="display: flex;flex-direction: column;height: 100%;padding: 0px;">
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
                    <div class="box-list">
                        <div v-for="item in messageList" style="border-bottom: 0;">
                            <p style="color: rgb(8, 78, 184);font-weight: bold;">{{ item.sendName }}</p>
                            <p style="border: 1px solid black;border-radius: 5px;padding: 5px;">{{ item.content }}&nbsp;</p>
                        </div>
                    </div>
                </div>
                <div class="input-group input-group-sm">
                    <input v-model="message" type="text" class="form-control" placeholder="Recipient's username"
                        aria-label="Recipient's username" aria-describedby="button-addon2">
                    <button class="btn btn-outline-secondary" type="button" id="button-addon2"
                        @click="sendMessage()">发送</button>
                </div>
            </div>
        </div>
    </div>


    <div class="modal fade show modal-rgba modal-lg">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">聊天室</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="mb-3">
                            <label for="recipient-name" class="col-form-label">用户地址:</label>
                            <input type="text" class="form-control" id="recipient-name"
                                placeholder="账号地址 @bobcbui:ooqn.com">
                        </div>
                        <div class="mb-3">
                            <label for="recipient-name" class="col-form-label">邮箱/手机号：</label>
                            <input type="text" class="form-control" id="recipient-name">
                        </div>
                        <div class="mb-3">
                            <label for="message-text" class="col-form-label">密码：</label>
                            <input type="text" class="form-control" id="recipient-name">
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary">登录</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { onMounted, ref } from "vue";
import { refresh } from "@gateway/apis/utils";

import { useAuthorStore } from "@common/user";
import { MonsterSocket } from "@common/monster"

let authorStore = useAuthorStore();


let mh = ref("right");
let message = ref("");
let messageList = ref([])
let member = ref({});

let monsterUrl = import.meta.env.VITE_BASE_API_WS + "_monster/" + authorStore.username;
var monsterSocket = new MonsterSocket(monsterUrl);

monsterSocket.setHeader("Message", (msg) => {
    messageList.value.push(msg.data)
    console.log(msg)
})

monsterSocket.setHeader("MessageList", (msg) => {
    messageList.value.push(msg.data)
    console.log(msg.data)
})

monsterSocket.login((msg) => {
    console.log(JSON.stringify(msg))
})

function sendMessage() {
    let send = {
        acceptName: member.value.username,
        sendName: authorStore.username,
        content: message.value,
        createTime: new Date(),
        updateTime: new Date()
    }
    messageList.value.push(send);
    message.value = "";
    monsterSocket.sendMessage(message.value, member.value.username, (msg) => {
        if (msg.status == 200) {
            console.log(msg.message);

        }
    })
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
.bbbb {
    flex-grow: 1;
    overflow-y: hidden;
}

body {
    overflow-y: hidden;
}

.modal-rgba {
    background: rgba(0, 0, 0, 0.075);
}
</style>