<template>
  <div id="body">
    <div id="message">
      <div id="message-head">
        <div class="message-nc">聊天</div>
      </div>
      <div id="message-body">
        
      </div>
    </div>
    <div id="r-body-body">
      <router-view />
    </div>
  </div>
</template>

<script>
export default {
  name: "chat",
  data() {
    return {
    };
  },
  computed: {},
  watch: {
  },
  destroyed() {
    this.$store.state.ws.close() //离开路由之后断开websocket连接
  },
  created() {
    this.initWebSocket();
  },
  methods: {
    initWebSocket() {
      try{
        this.$store.state.ws = new WebSocket(import.meta.env.VITE_BASE_API_WS + "api/ws/" + localStorage.getItem("jwt"));
        this.$store.state.ws.onmessage = this.websocketonmessage;
        this.$store.state.ws.onopen = this.websocketonopen;
        this.$store.state.ws.onerror = this.websocketonerror;
        this.$store.state.ws.onclose = this.websocketclose;
      }catch(e){
        console.log(e)
      }
    },
    websocketonopen() {

    },
    websocketonerror() {
      this.initWebSocket();
    },
    websocketonmessage(e) {
      console.log(e.data)
    },
    websocketclose(e) {
      console.log("断开连接", e);
    },
  },
  mounted() {
  }
}
</script>

<style>
  html,body{
    margin: 0;
    padding: 0;
    height: 100%;
}
body{
  overflow-y: hidden !important;
  background-color: #f3e4d2;
}
*{
    box-sizing: border-box;
    word-wrap:break-word
}
#app{
    margin: auto;
    height: 100%;
    width: 100%;
}
a{
    text-decoration: none;
    color: black;
}
img{
  max-width: 300px !important;
}

.message-item {
  border: 1px solid black;
  background: #dfd4c9;
  border-radius: 5px;
  margin: 4px;
  padding: 3px;
}
.message-input {
  width: calc(100% - 55px);
  height: 100%;
}
.send-but{
  height: 100%;
  width: 55px;
}
#message-item-body{
  height: calc(100% - 200px);overflow-y: scroll;
}

@media (max-width: 768px) {
  #message-item-body{
    height: calc(100% - 50px);
  }


}

#body{
    height: 100%;
}
#message{
    border-right: 1px solid black;
    width: 300px;
    height: 100%;
    float: left;
}
#message-tx{
    padding: 3px;
    border-radius: 5px;
    border: 1px solid red;
    height: 40px;
    width: 40px;
    float: left;
}
.message-nc{
    padding-left: 5px;
    float: left;
    font-weight:bold;
    line-height: 40px;
}
#r-body{
    height: 100%;
    width:calc(100% - 300px);
    float: right;
}
#message-head,#r-body-head{
    height: 50px;
    border-bottom: 1px solid black;
    background-color: rgb(115, 168, 247);
    padding: 4px;
}
#message-body{
    height: calc(100% - 50px);
    background-color: blanchedalmond;
     overflow-y: scroll;
}
#r-body-body{
    background-color: blanchedalmond;
    width: calc(100% - 300px);
    height: 100%;
    float: right;
}


.b1-p1-mb-1{
    border: 1px solid black;
    padding: 3px;
    margin-bottom: 3px;
}
.m-t-l-r-5{
  margin-top: 4px;
  margin-left: 4px;
  margin-right: 4px;
}
.br-5{
  border-radius: 5px;
}
.head-button{
  line-height: 34px;
  margin-left: 3px;
}
.float-right{
  float: right;
}
#syy{
  display: none;
}


#plaza{
  display: none;
}

@media (max-width: 768px) {
  #plaza{
    display: block;
  }
  #message{
    display: none;
  }   
  #syy{
    display: initial;
  }
  #r-body{
    width: 100%;    
  }
  #sz,#tc{
    display: block;
  }
  #app{
    max-height: 100%;
    max-width: 100%;
    padding: 0;
  }
}
</style>