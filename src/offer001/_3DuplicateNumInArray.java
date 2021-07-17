package offer001;

/**
 * @author Chang
 * @description 面试题3
 * @create 2021-07-06 8:04
 */
public class _3DuplicateNumInArray {

    public static void main(String[] args) {

        int arr[] = {2, 3, 5, 4, 3, 2, 6, 7};

        duplicate(arr);
    }

    private static void duplicate(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int m;

            while ((m = arr[i]) != i) {

                if (arr[m] == m) {
                    System.out.println("重复数字是: " + m);
                    break;
                }

                if (arr[m] != m) {
                    int tmp = arr[m];
                    arr[m] = m;
                    arr[i] = tmp;
                }
            }

        }
    }

}
