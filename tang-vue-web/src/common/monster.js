export class MonsterSocket {

    constructor(websocketUrl){
        this.messageFunctionList = {}
        this.socket = new WebSocket(websocketUrl);
        this.messageQueue = [];
        this.socket.onopen = (e) => {
            console.log(e);
            this.sendAll();
        }
        this.socket.onmessage = (me) => {
            let msg = JSON.parse(me.data);
            this.messageFunctionList[msg.messageId](msg);
        }
        this.socket.onclose = (ce) => {}
        this.socket.onerror = (e) => {}
    }

    send(obj, callback){
        obj.messageId = Math.random();
        this.messageFunctionList[obj.messageId] = callback;
        this.messageQueue.push(obj);
        this.sendAll();
    }

    sendAll(){
        while(this.messageQueue.length > 0 && this.socket.readyState === 1){
            let message = this.messageQueue.shift();
            this.socket.send(JSON.stringify(message))
        }
    }
}