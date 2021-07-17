package sync_aid;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Chang
 * @description 到齐开会
 * @create 2021-07-14 10:59
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,()->{

            System.out.println("到齐开会啦！");
        });

        for(int i=0;i<5;i++){

            new Thread(()->{

                System.out.println("到了");

                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            },String.valueOf(i)).start();
        }
    }
}
