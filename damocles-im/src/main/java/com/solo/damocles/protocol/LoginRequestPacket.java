package com.solo.damocles.protocol;

import lombok.Data;

/**
 * 登录请求报文
 *
 * @author zhangjt13666@hundsun.com
 * @date 2018/12/3 3:41 PM
 */
@Data
public class LoginRequestPacket extends Packet {

    private Integer userId;

    private String username;

    private String password;

    /**
     * 指令
     *
     * @return
     */
    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }
}
