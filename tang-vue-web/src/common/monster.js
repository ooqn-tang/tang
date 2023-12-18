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

    getUserInfo(callback){
        this.send({ code:1000 }, callback);
    }

    loginByToken(callback){
        this.send({
             code:9000,
             params:{
                jwt:localStorage.getItem("jwt")
            } 
        }, callback);
    }

    sendMessage(message, callback){
        this.send({
            code:2001,
            params:{
                text: message
            } 
        }, callback);
    }

    /**
     * 获取好友列表
     */
    loadMember(callback){
        this.send({
            code:1003
        }, callback);
    }

    
}