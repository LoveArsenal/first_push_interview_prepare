package block_queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Chang
 * @description 使用lock来解决消费者模式
 * @create 2021-07-14 13:54
 */
public class ProducerConsumerTradition {

    public static void main(String[] args) {

        Cake cake = new Cake();

        // change in master
        
        new Thread(() -> {

            for (int i = 0; i < 5; i++) {
                cake.produceCake();
            }

        }, "A").start();

        new Thread(() -> {

            for (int i = 0; i < 5; i++) {
                cake.consumeCake();
            }

        }, "B").start();
    }

}

class Cake {

    private int number = 0;

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void produceCake() {

        lock.lock();

        try {

            while (number != 0) {
                // 有蛋糕跳过不生产
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + "生产了蛋糕，数量 " + ++number);
            condition.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            lock.unlock();
        }
    }

    public void consumeCake() {

        lock.lock();

        try {

            while (number == 0) {

                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + "消费了蛋糕，数量 " + --number);
            condition.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            lock.unlock();
        }
    }

}