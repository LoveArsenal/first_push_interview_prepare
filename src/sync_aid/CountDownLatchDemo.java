package sync_aid;

import java.util.concurrent.CountDownLatch;

/**
 * @author Chang
 * @description 秦灭六国
 * @create 2021-07-14 10:37
 */
public class CountDownLatchDemo {


    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(6);

        for (int i = 1; i <= 7; i++) {

            final int code = i;

            new Thread(() -> {

                if ("秦国".equals(Country.findCountry(code).getMsg())) {
                    try {
                        latch.await();
                        System.out.println("秦国统一天下");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(Country.findCountry(code).getMsg() + " 被秦灭");
                    latch.countDown();
                }

            }, Country.findCountry(i).getMsg()).start();
        }


    }

}
