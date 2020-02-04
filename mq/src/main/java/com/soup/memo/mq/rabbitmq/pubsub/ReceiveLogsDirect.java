package com.soup.memo.mq.rabbitmq.pubsub;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * 日志消息消费者
 *
 * @author zhaoyi
 */
@Slf4j
public class ReceiveLogsDirect {

    private static final String LOG_EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(LOG_EXCHANGE_NAME, "direct");
        // 当消费者连接到的时候，生成一个新的、非持久化，且连接断开后，队列自动删除的队列
        String queueName = channel.queueDeclare().getQueue();

        String[] logLevels = new String[] {"info", "error", "warning"};
        Arrays.stream(logLevels).forEach(level -> {
            try {
                channel.queueBind(queueName, LOG_EXCHANGE_NAME, level);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        log.info(" [*] Waiting for consume message ");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            log.info(" [x] Received '{}'", message);
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {});
    }

}
