<template>
    <div class="row H100">
        <div class="col-md-4 H100 pb-2">
            <div class="H100" style="display: flex;flex-direction: column;height: 100%;padding: 0px;">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Recipient's username"
                        aria-label="Recipient's username" aria-describedby="button-addon2">
                    <button class="btn btn-outline-secondary" type="button" id="button-addon2">搜索</button>
                </div>
                <div class="box"
                    style="height: 100%;flex-grow: 1;overflow-y: auto;padding: 5px;border: 1px solid #dee2e6;margin: 5px 0px;">
                    <div class="box-list">
                        <div v-for="item in memeberList">
                            <p>{{ item.nickname }}</p>
                            <p style="color: #bbbbbb;">{{ item.signature }}</p>
                        </div>
                    </div>
                </div>
                <div class="btn-group btn-group-sm" role="group" aria-label="Basic radio toggle button group">
                    <button class="btn btn-outline-primary">消息</button>
                    <button class="btn btn-outline-primary">好友</button>
                    <button class="btn btn-outline-primary">我的</button>
                </div>
            </div>
        </div>
        <div class="col-md-8 H100 pb-2 pc">
            <div class="H100" style="display: flex;flex-direction: column;height: 100%;padding: 0px;">
                <div class="card">
                    <div class="card-body" style="padding: 6px 10px;vertical-align:top;display: inline-block;">

                        <span class="align-middle">这是文本</span>

                        <span style="float: right;">
                            ✖️
                        </span>

                    </div>
                </div>
                <div class="box"
                    style="height: 100%;flex-grow: 1;overflow-y: auto;padding: 5px;border: 1px solid #dee2e6;margin: 5px 0px;">
                    <div class="box-list">
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
                        <div>asdf</div>
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
import { useAuthorStore } from "@common/user";
import { MonsterSocket } from "@common/monster"
import { refresh } from "@gateway/apis/utils";
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