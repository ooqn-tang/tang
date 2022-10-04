<template>
  <router-view />
</template>

<script>
export default {
  data() {
    return {
      count:0,
    };
  },
  created() {
    this.initWebSocket();
  },
  destroyed() {
    this.$store.state.ws.close() //离开路由之后断开websocket连接
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
      this.$store.state.ws.send(JSON.stringify({ test: "12345" }));
      this.count = 0
    },
    websocketonerror() {
      //连接建立失败重连
      this.count++;
      if(this.count < 10){
        this.initWebSocket();
      }
    },
    websocketonmessage(e) {
      let messageList = JSON.parse(e.data)
      console.log(e.data)
      messageList.forEach((item, index) => {
        let to = item.to
        if (this.$store.state.message[to] == undefined) {
          this.$store.state.message[to] = [item]
        } else {
          this.$store.state.message[to].push(item)
        }
        this.$store.state.gang[to] = item
        localStorage.setItem("gang", JSON.stringify(this.$store.state.gang))
      })
    },
    websocketclose(e) {
      //关闭
      console.log("断开连接", e);
    },
  },
};
</script>