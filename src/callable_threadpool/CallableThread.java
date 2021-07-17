package callable_threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Chang
 * @description 使用Callable方式创建线程
 * @create 2021-07-14 18:30
 */

public class CallableThread {

    static class MyThread implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {

            System.out.println(Thread.currentThread().getName() + "come");

            return 200;
        }
    }

    public static void main(String[] args) {

        FutureTask<Integer> task_a = new FutureTask<>(new MyThread());
        Thread thread = new Thread(task_a);
        thread.start();
        try {
            System.out.println(task_a.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
