package com.soup.memo.mq.rabbitmq.pubsub;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * 日志示例，基于发布/订阅
 *
 * @author zhaoyi
 */
@Slf4j
public class EmitLog {

    private static final String LOG_EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");

        try (Connection connection = connectionFactory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(LOG_EXCHANGE_NAME, "fanout");
            String message = "use fanout exchage send massage!";
            channel.basicPublish(LOG_EXCHANGE_NAME, "", null, message.getBytes());
            log.info(" [x] Send '{}'", message);
        }
    }

}
