package com.solo.damocles.lab.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池导致的内存溢出异常
 * VM Args：-XX:PermSize=10M -XX:MaxPermSize=10M
 * 仅在JDK 1.6会出现异常
 *
 * @author zhangjt13666@hundsun.com
 * @date 2018/12/14 4:00 PM
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        //使用List保持着常量池引用，避免Full GC回收常量池行为
        List<String> list = new ArrayList<>();
        //10MB的PermSize在integer范围内足够产生OOM了
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
