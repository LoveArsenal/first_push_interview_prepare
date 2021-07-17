package block_queue;

/**
 * @author Chang
 * @description 使用wait()和notify()方法实现生产者消费者
 * @create 2021-07-14 14:04
 */
public class ProdConsuPremitive {


    public static void main(String[] args) {

        Umbrella umbrella = new Umbrella();

        new Thread(() -> {

            for (int i = 0; i < 5; i++) {
                umbrella.produceUmbrella();
            }

        }, "A").start();

        new Thread(() -> {

            for (int i = 0; i < 5; i++) {
                umbrella.consumeUmbrella();
            }

        }, "B").start();
    }

}

class Umbrella {

    private int number = 0;

//    private ReentrantLock lock = new ReentrantLock();

//    private Condition condition = lock.newCondition();

    public synchronized void produceUmbrella() {

//        lock.lock();


        while (number != 0) {

//                    condition.await();
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        notify();           // 唤醒消费线程，但是持有对象锁，依然会先完成生产

//        while (number == 0)
        System.out.println(Thread.currentThread().getName() + "生产了雨伞，数量 " + ++number);
//            condition.signal();
        this.notify();
//        try {
//            this.wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//            lock.unlock();
    }

    public synchronized void consumeUmbrella() {

//        lock.lock();

//
        while (number == 0) {

            try {
//                    condition.await();
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println(Thread.currentThread().getName() + "消费了雨伞，数量 " + --number);

//            condition.signal();

        this.notify();
//        lock.unlock();
//        try {
//            wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

}