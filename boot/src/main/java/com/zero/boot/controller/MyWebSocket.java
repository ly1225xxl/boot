package com.zero.boot.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
//每个客户端连接成功的时候在后台都会创建一个相应的MyWebsocket类
@Controller
@ServerEndpoint("/websocket")
public class MyWebSocket {
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static CopyOnWriteArraySet<MyWebSocket> websocketPools = new CopyOnWriteArraySet<MyWebSocket>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    @RequestMapping(value="viewsocket")
    public String viewSocket(){
        System.out.println("view webSocket!");
        return "sendmessage";
    }

    /**
     * 连接建立成功调用的方法
     * @param session 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        websocketPools.add(this);
    }

    @OnClose
    public void onClose() {
        websocketPools.remove(this);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        for (MyWebSocket item : websocketPools) {
            try {
                item.send(message);
            } catch (IOException e) {
            //TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private void send(String message) throws IOException {
        this.session.getAsyncRemote().sendText(message);
        //this.session.getBasicRemote().sendText(message);

    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }
}