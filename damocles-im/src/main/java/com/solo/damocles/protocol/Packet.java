package com.solo.damocles.protocol;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 通信协议抽象对象类
 *
 * @author zhangjt13666@hundsun.com
 * @date 2018/12/3 3:35 PM
 */
@Data
public abstract class Packet {
    /**
     * 协议版本
     */
    @JSONField(deserialize = false, serialize = false)
    private Byte version = 1;

    /**
     * 指令
     *
     * @return
     */
    @JSONField(serialize = false)
    public abstract Byte getCommand();

}
