package spinlock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Chang
 * @description 使用自旋锁来控制线程，“改变线程状态” 处于运行状态但是一直在循环等锁！
 * @create 2021-07-13 20:57
 */
public class SpinLock {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void getLock() {

        Thread thread = Thread.currentThread();

        for (; !atomicReference.compareAndSet(null, thread); ) {

            System.out.println(thread.getName() + " 正在等待");
        }
        // 抢到了锁，则可以执行其他操作
        System.out.println("线程 " + thread.getName() + " 得到了锁");
    }

    public void unLock() {

        Thread thread = Thread.currentThread();

        System.out.println("线程 " + thread.getName() + " 释放了锁  ");

        atomicReference.compareAndSet(thread, null);

    }


    public static void main(String[] args) throws InterruptedException {

       final SpinLock spinLock = new SpinLock();

        new Thread(() -> {
            spinLock.getLock();
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLock.unLock();
        }, "B").start();

        new Thread(() -> {
            spinLock.getLock();
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLock.unLock();
        }, "A").start();



    }

}
