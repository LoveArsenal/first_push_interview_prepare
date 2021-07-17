package sync_aid;

import java.util.concurrent.Semaphore;

/**
 * @author Chang
 * @description 信号量，多抢多个资源
 * @create 2021-07-14 11:04
 */
public class SemaphoreDemo {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++) {

            new Thread(() -> {

                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " 抢到车位");
                    Thread.sleep(2);
                    System.out.println(Thread.currentThread().getName() + " 离开车位");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }

            }, String.valueOf(i)).start();
        }
    }
}
