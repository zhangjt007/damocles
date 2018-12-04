package com.solo.damocles.serialize;

import com.alibaba.fastjson.JSON;

/**
 * JSON序列化实现类
 *
 * @author zhangjt13666@hundsun.com
 * @date 2018/12/3 4:26 PM
 */
public class JSONSerializer implements Serializer {
    /**
     * 序列化算法
     *
     * @return
     */
    @Override
    public byte getSerializerAlogrithm() {
        return SerializerAlogrithm.JSON;
    }

    /**
     * java 对象转换成二进制
     *
     * @param object
     */
    @Override
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    /**
     * 二进制转换成 java 对象
     *
     * @param clazz
     * @param bytes
     */
    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }
}
