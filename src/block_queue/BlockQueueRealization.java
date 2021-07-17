package block_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Chang
 * @description 使用阻塞队列完成生产者消费者
 * @create 2021-07-14 16:30
 */
public class BlockQueueRealization {

    public static void main(String[] args) {

        SharedSource sharedSource = new SharedSource(new ArrayBlockingQueue<>(10));

        new Thread(()->{

            try {
                sharedSource.pollEle();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"B").start();


        new Thread(()->{

            try {
                sharedSource.offerEle();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(3);
            sharedSource.setFLAG(false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

class SharedSource {

    // 由main线程控制
    private volatile boolean FLAG = true;

    public void setFLAG(boolean FLAG) {
        this.FLAG = FLAG;
    }

    private AtomicInteger atomicInteger = new AtomicInteger();

    private BlockingQueue<String> blockingQueue = null;

    public SharedSource(BlockingQueue<String> blockingQueue) {

        this.blockingQueue = blockingQueue;
    }

    public void offerEle() throws InterruptedException {

        while (FLAG) {

            int data = atomicInteger.incrementAndGet();
            boolean result = blockingQueue.offer(String.valueOf(data), 1, TimeUnit.SECONDS);
            if (result) {
                System.out.println(Thread.currentThread().getName() + "  插入队列" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "  插入队列" + data + "失败");

            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("main线程终止了生产");

    }

    public void pollEle() throws InterruptedException {

        while (FLAG) {

            String result = blockingQueue.poll(1, TimeUnit.SECONDS);
            if (result != null && !"".equals(result)) {
                System.out.println(Thread.currentThread().getName() + "  从队列取出" + result + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "  从队列取出失败");
            }

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("main线程终止了消费");

    }


}
