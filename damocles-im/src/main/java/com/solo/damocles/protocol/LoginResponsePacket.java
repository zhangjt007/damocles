package com.solo.damocles.protocol;

import lombok.Data;

import static com.solo.damocles.protocol.Command.LOGIN_RESPONSE;

/**
 * LoginResponsePacket
 *
 * @author zhangjt13666@hundsun.com
 * @date 2018/12/3 6:13 PM
 */
@Data
public class LoginResponsePacket extends Packet {

    private boolean success;
    private String reason;

    /**
     * 指令
     *
     * @return
     */
    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}
