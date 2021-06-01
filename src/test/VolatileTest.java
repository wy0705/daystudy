package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VolatileTest {
    public volatile int i = 0;

    public void increase() {
        i++;
    }

    public static void main(String args[]) throws InterruptedException {
        List<Thread> threadList = new ArrayList<>();
        VolatileTest test = new VolatileTest();
        for (int j = 0; j < 10000; j++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    test.increase();
                }
            });
            thread.start();
            threadList.add(thread);
        }

        // 等待所有线程执行完毕
        for (Thread thread : threadList) {
            thread.join();
        }
        System.out.print(test.i);// 输出9995
    }

}
