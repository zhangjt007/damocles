package com.solo.damocles.lab.jvm;

/**
 * 创建线程导致内存溢出异常
 * VM Args：-Xss2M（这时候不妨设置大些）
 *
 * 运行会死机，当心
 * 运行会死机，当心
 *
 * @author zhangjt13666@hundsun.com
 * @date 2018/12/14 3:46 PM
 */
public class JavaVMStackOOM {
    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
