package com.soup.memo.mq.rabbitmq.pubsub;

import cn.hutool.core.util.RandomUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * 日志示例
 *
 * @author zhaoyi
 */
@Slf4j
public class EmitDirectLog {

    private static final String LOG_EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");

        try (Connection connection = connectionFactory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(LOG_EXCHANGE_NAME, "direct");

            String severity = getLogLevel();
            String message = "use direct exchage send " + severity + " massage!";

            channel.basicPublish(LOG_EXCHANGE_NAME, severity, null, message.getBytes());
            log.info(" [x] Send '{}' '{}'", severity, message);
        }
    }

    private static String getLogLevel() {
        String[] logLevels = new String[] {"info", "error", "warning"};

        return RandomUtil.randomEle(logLevels);
    }

}
