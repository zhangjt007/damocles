package com.solo.damocles.lab.others;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * IdentityHashMap学习测试
 * IdentityHashMap: Key引用相等即==
 * HashMap： key使用equal判断相等
 *
 * @author zhangjt13666@hundsun.com
 * @date 2018/12/11 10:25 AM
 */
public class IdentityHashMapTest {

    private static final Logger logger = LoggerFactory.getLogger(IdentityHashMapTest.class);

    public static void main(String[] args) {
        String a = "a";
        String aa = new String("a");
        String aaa = new String("a");
        Map identityHashMap = new IdentityHashMap();
        identityHashMap.put(a, "a");
        identityHashMap.put(aa, "aa");
        identityHashMap.put(aaa, "aaa");
        logger.info("IdentityHashMap size is :{}", identityHashMap.size());
        Map hashMap = new HashMap(3);
        hashMap.put(a, "a");
        hashMap.put(aa, "aa");
        hashMap.put(aaa, "aaa");
        logger.info("HashMap size is :{}", hashMap.size());
    }
}
