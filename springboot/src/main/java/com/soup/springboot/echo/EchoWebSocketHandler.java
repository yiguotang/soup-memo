package com.soup.springboot.echo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * <p>
 *     处理文本的websocket
 *     {@link TextWebSocketHandler} 适配器设计模式
 * </p>
 *
 * @author zhaoyi
 * @date 2020-01-01 17:28
 * @since 1.0
 */
@Slf4j
public class EchoWebSocketHandler extends TextWebSocketHandler {

    private EchoService echoService;

    public EchoWebSocketHandler(EchoService echoService) {
        this.echoService = echoService;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("websocket 连接建立");
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String echoMessage = this.echoService.getMessage(message.getPayload());
        session.sendMessage(new TextMessage(echoMessage));
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.error("websocket 传输错误");
        session.close(CloseStatus.SERVER_ERROR);
    }
}
