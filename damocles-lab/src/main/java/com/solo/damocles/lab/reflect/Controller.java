package com.solo.damocles.lab.reflect;

import com.sun.tools.javac.util.Assert;

/**
 * 控制器类
 *
 * @author zhangjt13666@hundsun.com
 * @date 2018/12/10 1:49 PM
 */
public class Controller {
    public static void main(String[] args) {
        String object = "ss";
        Assert.checkNonNull(object,"不能为空");
    }
}
