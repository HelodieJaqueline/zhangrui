package com.zhangrui.ws;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class WritingWebSocketClient implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(WritingWebSocketClient.class);
    private static final String WS_URL = "ws://xxx";

    private static final String WSS_URL = "wss://xxx";
    private static final long HEARTBEAT_INTERVAL = 10; // 心跳间隔(秒)

    private WebSocketClient webSocketClient;
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    @Override
    public void run(String... args) throws Exception {
        connectWebSocket();
    }

    private void connectWebSocket() throws URISyntaxException {
        webSocketClient = new WebSocketClient(new URI(WS_URL)) {
            @Override
            public void onOpen(ServerHandshake handshakedata) {
                log.info("WebSocket连接已建立");
                // 启动心跳
                startHeartbeat();
            }

            @Override
            public void onMessage(String message) {
                if ("health".equals(message)) {
                    log.info("收到心跳响应:{}", message);
                } else {
                    log.info("收到消息: {}", message);
                }
            }

            @Override
            public void onClose(int code, String reason, boolean remote) {
                log.warn("连接关闭，代码: {}, 原因: {}, 远端关闭: {}", code, reason, remote);
                // 尝试重连
                scheduleReconnect();
            }

            @Override
            public void onError(Exception ex) {
                log.error("WebSocket错误", ex);
            }
        };

        // 设置连接超时
        webSocketClient.setConnectionLostTimeout(60);
        webSocketClient.connect();
    }

    private void startHeartbeat() {
        scheduler.scheduleAtFixedRate(() -> {
            if (webSocketClient != null && webSocketClient.isOpen()) {
                try {
                    webSocketClient.send("ping");
                    log.debug("发送心跳ping");
                } catch (Exception e) {
                    log.error("发送心跳失败", e);
                }
            }
        }, HEARTBEAT_INTERVAL, HEARTBEAT_INTERVAL, TimeUnit.SECONDS);
    }

    private void scheduleReconnect() {
        scheduler.schedule(() -> {
            log.info("尝试重新连接...");
            try {
                connectWebSocket();
            } catch (URISyntaxException e) {
                log.error("重新连接失败", e);
            }
        }, 5, TimeUnit.SECONDS); // 5秒后重试
    }
}
