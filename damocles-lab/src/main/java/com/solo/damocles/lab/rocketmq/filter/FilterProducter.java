package com.solo.damocles.lab.rocketmq.filter;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * SQL功能可以通过发送消息时输入的属性进行一些计算。在RocketMQ定义的语法下，您可以实现一些有趣的逻辑。这是一个例子：
 * <p>
 * ------------
 * | 消息|
 * | ---------- | a> 5 AND b ='abc'
 * | a = 10 | --------------------> Gotten
 * | b ='abc'|
 * | c = true |
 * ------------
 * ------------
 * | 消息|
 * | ---------- | a> 5 AND b ='abc'
 * | a = 1 | -------------------->错过了
 * | b ='abc'|
 * | c = true |
 * ------------
 * 文法
 * RocketMQ仅定义了一些支持此功能的基本语法。您也可以轻松扩展它。
 * <p>
 * 数值比较，如>，>=，<，<=，BETWEEN，=;
 * 字符比较，如=，<>，IN;
 * IS NULL或IS NOT NULL;
 * 逻辑AND，OR，NOT，
 * 常量类型是：
 * <p>
 * 数字，如123,3.1415;
 * 字符，如'abc'，必须用单引号制作;
 * NULL，特殊常数;
 * 布尔值，TRUE或FALSE;
 *
 * @author zhangjt13666@hundsun.com
 * @date 2018/12/13 11:04 AM
 */
public class FilterProducter {
    public static void main(String[] args) throws Exception {
        //Instantiate with a producer group name.
        DefaultMQProducer producer = new
                DefaultMQProducer("FILTER_PRO_GROUP");
        // Specify name server addresses.
        producer.setNamesrvAddr("localhost:9876");
        //Launch the instance.
        producer.start();
        for (int i = 0; i < 10; i++) {
            //Create a message instance, specifying topic, tag and message body.
            Message msg = new Message("TopicTest", "TagA",
                    ("Hello RocketMQ ").getBytes(RemotingHelper.DEFAULT_CHARSET)
            );
            msg.putUserProperty("a", String.valueOf(i));
            //Call send message to deliver message to one of brokers.
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
    }
}
