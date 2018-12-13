package com.solo.damocles.lab.reflect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 奥迪汽车
 *
 * @author zhangjt13666@hundsun.com
 * @date 2018/12/10 1:46 PM
 */
public class AudiCar extends Car {
    private static final Logger logger = LoggerFactory.getLogger(AudiCar.class);

    /**
     * 运行
     */
    @Override
    protected void run() {
        logger.info("{}品牌{}颜色汽车在运行", this.brand, this.color);
    }
}
