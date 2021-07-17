package jvm;

/**
 * @author Chang
 * @description 通过str.intern()感受一下jvm的调优指令
 * @create 2021-07-14 21:20
 */
public class StringInternDemo {

    public static void main(String[] args) {
/*
        int i = 100;
        while (i > 0) {

            String str = new String("abcdefghigklmnopqrestuvwxyz").intern();

        }
*/
        String abc = new String("abc");
        String abc2 = new String("abc");
        System.out.println(abc == abc2);


    }
}