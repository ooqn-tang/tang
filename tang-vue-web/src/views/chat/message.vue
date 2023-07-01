<template>
  <div style="    height: 100%;">
    <div id="r-body-head"  style="border-right: 1px solid;">
      <div class="message-nc">
        ❌首页
      </div>
      <div class="float-right message-nc">个人中心</div>
    </div>
    <div id="message-item-body" style="border-right: 1px solid;">
      
    </div>
    <div style="height:150px;width:100%">
        <textarea class="message-input" v-model="text" style="float:left;resize: none;border-top: 1px solid;border-right: 1px solid;padding: 5px;"></textarea>
        <button class="send-but" style="float:left;border-top: 1px solid;border-right: 1px solid;" @click="send()">发送</button>
    </div>
  </div>
</template>
  
<script setup>
function send(){
  let message = {
    to: $route.params.id,
    text: text,
    type: "message"
  }
  $store.state.ws.send(JSON.stringify(message));
}
</script>
  