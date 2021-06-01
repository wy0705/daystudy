package test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class XdTest {

    // 方式1：使用原子类
    // AtomicInteger  num = 0;// 这种方式的话++操作就可以保证原子性了，而不需要再加锁了
    private int num = 0;

    // 方式2：使用lock，每个对象都是有锁，只有获得这个锁才可以进行对应的操作
    Lock lock = new ReentrantLock();
    public  void add1(){
        lock.lock();
        try {
            num++;
        }finally {
            lock.unlock();
        }
    }

    // 方式3：使用synchronized，和上述是一个操作，这个是保证方法被锁住而已，上述的是代码块被锁住
    public synchronized void add2(){
        num++;
    }
}
