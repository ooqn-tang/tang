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
                <div class="btn-group btn-group-sm" role="group" aria-label="Basic radio toggle button group">
                    <input type="radio" class="btn-check" name="btnradio" id="btnradio1" autocomplete="off" checked>
                    <label class="btn btn-outline-primary" for="btnradio1">消息</label>

                    <input type="radio" class="btn-check" name="btnradio" id="btnradio2" autocomplete="off">
                    <label class="btn btn-outline-primary" for="btnradio2">好友</label>

                    <input type="radio" class="btn-check" name="btnradio" id="btnradio3" autocomplete="off">
                    <label class="btn btn-outline-primary" for="btnradio3">我的</label>
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
                    <input type="text" class="form-control" placeholder="Recipient's username"
                        aria-label="Recipient's username" aria-describedby="button-addon2">
                    <button class="btn btn-outline-secondary" type="button" id="button-addon2">搜索🔍</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { useAuthorStore } from "@common/user";
import { MonsterSocket } from "@common/monster"

let authorStore = useAuthorStore();

function websocketonerror() { console.log("error"); };

function websocketclose() { console.log("close"); };

let monsterUrl = import.meta.env.VITE_BASE_API_WS + "_monster/" + authorStore.username
var monsterSocket = new MonsterSocket(monsterUrl, websocketclose, websocketonerror);
// monsterSocket.send({
//     code:"9000",
//     params: {
//         jwt:localStorage.getItem("jwt")
//     }
// },function(msg){
//     console.log(msg)
//     alert("登录成功")
// })

</script>
<style scoped>
* {
    -moz-user-select: none;
    /* Firefox */
    -webkit-user-select: none;
    /* WebKit内核 */
    -ms-user-select: none;
    /* IE10及以后 */
    -khtml-user-select: none;
    /* 早期浏览器 */
    -o-user-select: none;
    /* Opera */
    user-select: none;
    /* CSS3属性 */
}
</style>
