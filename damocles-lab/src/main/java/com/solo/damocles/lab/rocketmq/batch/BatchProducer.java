package com.solo.damocles.lab.rocketmq.batch;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * 为何批量？
 * 批量发送消息可提高传递小消息的性能。
 * 使用限制
 * 同一批次的消息应该具有：相同的主题，相同的waitStoreMsgOK和没有计划支持。
 * 此外，一批邮件的总大小不应超过1MiB。
 * 如何使用批处理
 * 如果您一次只发送不超过1MiB的消息，则很容易使用批处理：
 *
 * @author zhangjt13666@hundsun.com
 * @date 2018/12/13 9:33 AM
 */
public class BatchProducer {
    public static void main(String[] args) throws Exception {
        //Instantiate with a producer group name.
        DefaultMQProducer producer = new
                DefaultMQProducer("BATCH_PRO_GROUP");
        // Specify name server addresses.
        producer.setNamesrvAddr("localhost:9876");
        //Launch the instance.
        producer.start();
        String topic = "BatchTest";
        List<Message> messages = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            messages.add(new Message(topic, "TagA", "OrderID00" + i, ("Hello world " + i).getBytes()));
        }
        //then you could split the large list into small ones:
        ListSplitter splitter = new ListSplitter(messages);
        while (splitter.hasNext()) {
            try {
                List<Message> listItem = splitter.next();
                producer.send(listItem);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
    }
}