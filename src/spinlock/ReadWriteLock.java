package spinlock;

/**
 * @author Chang
 * @description
 * @create 2021-07-13 21:58
 */
public class ReadWriteLock {

    public static void main(String[] args) {

        for (int i = 1; i < 6; i++) {
            final int tempInt = i;
            System.out.println(tempInt);
        }
    }
}
