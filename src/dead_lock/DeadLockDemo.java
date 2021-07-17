package dead_lock;

/**
 * @author Chang
 * @description 死锁
 * @create 2021-07-15 0:49
 */

class SharedResource implements Runnable{

    String lockA = null;
    String lockB = null;

    public SharedResource(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    public void operate(){

        synchronized (lockA){

            System.out.println(Thread.currentThread().getName() + "拿到了锁" + lockA + "正在申请" + lockB);

            synchronized (lockB){
                System.out.println("never");
            }
        }
    }

    @Override
    public void run() {
        operate();
    }
}

public class DeadLockDemo {

    public static void main(String[] args) {

        new Thread(new SharedResource("lockA","lockB"),"A").start();
        new Thread(new SharedResource("lockB","lockA"),"B").start();
    }

}
