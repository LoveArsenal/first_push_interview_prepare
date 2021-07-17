package sort;

import java.util.Arrays;

/**
 * @author Chang
 * @description 复习插入排序
 * @create 2021-06-25 9:33
 */
public class InsertSortTest {

    public static void main(String[] args) {

        int[] arr = {3, 1, 7, 4, 2, 6};
        System.out.println(Arrays.toString(arr));

        // 插入排序是从1索引开始，将无序的数字插入到有序的数列中
        for (int i = 1; i < arr.length; i++) {

            // 取出当前元素
            int cur = arr[i];
            int j = i - 1;

            // 遍历有序数列
            for (; j >= 0 && arr[j] > cur; j--) {       // 注意这个cur是精髓！意味着通过遍历找到应该插入的位置！！
                // 此时需要位移
                arr[j + 1] = arr[j];
            }

            if (j != i - 1) {
                arr[j + 1] = cur;
            }

        }
        System.out.println(Arrays.toString(arr));
    }
}
