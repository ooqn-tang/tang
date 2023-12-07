export class MonsterSocket {

    constructor(wsUrl, close, error) {
        this.messageList = {}
        this.ws = new WebSocket(wsUrl)
        this.ws.onmessage = function (msg) {
            let messageBody = JSON.parse(msg);
            messageList[messageBody.messageId]();
        };
        this.ws.onopen = function () {
            console.log("onopen")
        }
        this.ws.onclose = close;
        this.ws.onerror = error;
    }

    send(message, fun) {
        if (this.ws.readyState != 0) {
            message.messageId = new Date().getTime();
            let messageJsonStr = JSON.stringify(message);
            this.ws.send(messageJsonStr);
            messageList[message.messageId] = fun;
        }
    }
}