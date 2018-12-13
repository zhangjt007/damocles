package com.solo.damocles.lab.rocketmq.schedule;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

/**
 * 发送预定的消息
 *
 * @author zhangjt13666@hundsun.com
 * @date 2018/12/13 10:32 AM
 */
public class ScheduledMessageProducer {
    public static void main(String[] args) throws Exception {

        // Instantiate a producer to send scheduled messages
        DefaultMQProducer producer = new DefaultMQProducer("SCHEDULED_PRO_GROUP");
        producer.setNamesrvAddr("localhost:9876");
        // Launch producer
        producer.start();
        int totalMessagesToSend = 100;
        for (int i = 0; i < totalMessagesToSend; i++) {
            Message message = new Message("TestTopic", ("Hello scheduled message " + i).getBytes());
            // This message will be delivered to consumer 10 seconds later.
            message.setDelayTimeLevel(3);
            // Send the message
            producer.send(message);
        }
        // Shutdown producer after use.
        producer.shutdown();
    }
}
