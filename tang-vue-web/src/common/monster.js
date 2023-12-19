export class MonsterSocket {

    constructor(websocketUrl){
        this.messageFunctionList = {}
        this.messageHeader = {}
        this.socket = new WebSocket(websocketUrl);
        this.messageQueue = [];
        this.socket.onopen = (e) => {
            console.log(e);
            this.sendAll();
        }
        this.socket.onmessage = (me) => {
            let msg = JSON.parse(me.data);
            if(msg.code != null){
                this.messageHeader[msg.code](msg)
            }else{
                this.messageFunctionList[msg.messageId](msg);
            }
        }
        this.socket.onclose = (ce) => {}
        this.socket.onerror = (e) => {}
    }

    setHeader(code, callback){
        this.messageHeader[code] = callback;
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

    login(callback){
        this.send({
             code:"Login",
             params:{
                jwt:localStorage.getItem("jwt")
            } 
        }, callback);
    }

    sendMessage(message, username, callback){
        this.send({
            code:"SendMessage",
            params:{
                username: username,
                text: message
            } 
        }, callback);
    }

    /**
     * 获取好友列表
     */
    watchList(callback){
        this.send({
            code:"WatchList"
        }, callback);
    }
    /**
     * 加载消息列表
     */
    messageList(memberName, callback){
        this.send({
            code:"MessageList",
            params:{
                memberName:memberName
            }
        }, callback);
    }

    
}