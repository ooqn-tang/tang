<template>
  <div class="row H100">
    <div class="col-md-4 H100 pb-2">
      <div class="card H100">
        <div class="card-body H100" style="display: flex;flex-direction: column;height: 100%;">
          <div class="input-group">
            <input type="text" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="button-addon2">
            <button class="btn btn-outline-secondary" type="button" id="button-addon2">添加</button>
          </div>
          <div class="box-list" style="height: 100%;flex-grow: 1;overflow-y: auto;padding: 5px;border: 1px solid rgb(199, 199, 199);margin: 5px 0px;">
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
          <div class="btn-group  btn-group-sm" role="group" aria-label="Basic checkbox toggle button group">
            <input type="checkbox" class="btn-check" id="btncheck1" autocomplete="off">
            <label class="btn btn-outline-primary" for="btncheck1">消息</label>

            <input type="checkbox" class="btn-check" id="btncheck2" autocomplete="off">
            <label class="btn btn-outline-primary" for="btncheck2">好友</label>

            <input type="checkbox" class="btn-check" id="btncheck3" autocomplete="off">
            <label class="btn btn-outline-primary" for="btncheck3">我的</label>
          </div>
        </div>
      </div>
    </div>
    <div class="col-md-8 H100 pb-2">
      <div class="card H100">
        <div class="card-body H100">
          啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useAuthorStore } from "@common/user";

let authorStore = useAuthorStore();

let ws;

function initWebSocket(){
  try{
    ws = new WebSocket(import.meta.env.VITE_BASE_API_WS + "_monster/agreement?token=123456789");
    ws.onmessage = websocketonmessage;
    ws.onopen = websocketonopen;
    ws.onerror = websocketonerror;
    ws.onclose = websocketclose;
  }catch(e){
    console.log(e)
  }
};

function websocketonopen(){

};

function websocketonerror(){
  
};

function websocketonmessage(e){
  console.log(e.data)
};

function websocketclose(e){
  console.log("断开连接", e);
};

initWebSocket();

</script>
