package com.soup.memo.mq.rabbitmq.workertask;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * rabbitmq sender
 *
 * @author zhaoyi
 */
@Slf4j
public class NewTask {

    private static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            // 声明一个队列是幂等的，即只有不存在的情况下才会创建，已存在则不会创建
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = produceMsg();
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            log.info(" [x] Send '{}'", message);
        }
    }

    /**
     * 生成任务，每个点假设为一个耗时任务，需要花费1秒
     * @return 工作任务消息
     */
    private static String produceMsg() {
        return "hello...";
    }
}
