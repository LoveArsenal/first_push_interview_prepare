package sort;

import java.util.Arrays;

/**
 * @author Chang
 * @description 学习希尔排序
 * 希尔排序是一种高效的插入排序，也称为缩小增量排序，是冲破O(n^2)的第一批算法
 * @create 2021-06-25 11:20
 */
public class ShellSortTest {

    public static void main(String[] args) {

        int arr[] = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0}; // 10
        System.out.println(Arrays.toString(arr));

        sort(arr);
        System.out.println(Arrays.toString(arr));

    }
    // int arr[] = {8,9,1,7,2,3,5,4,6,0};
    // 希尔增量为gap=length/2=5
    // 构造增量序列 {n/2,(n/2)/2,...,1}
    // 数据分组结果 [8,3][9,5][1,4][7,6][2,0]
    // 对5组进行插入排序
    // gap = 5/2 =2
    // 重新分组 [3,1,0,9,7],[5,6,8,4,2]
    // gap = 2/2 =1
    // 只有一组[0,2,1,4,3,5,7,6,9,8]


    // 代码实现上不需要分组，从第gap个元素开始，逐个跨组处理
    public static void sort(int[] arr) {

        // 间隔5、2、1
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {

            for (int i = gap; i < arr.length; i++) {
                // 从gap打头，进入分组
                for (int j = i; j - gap >= 0; j = j - gap) {    // 插入排序此处是，注意一定要有那种依次替换的感觉
                    if (arr[j] < arr[j - gap]) {                // 也就是，arr[j]和arr[j-gap]去比，gap是唯一变量
                        int temp = arr[j - gap];                // 如果 j-gap 大于等于0，就证明还可以去比较
                        arr[j - gap] = arr[j];                  // 当gap等于1的时候就相当于最朴素的插入排序
                        arr[j] = temp;
                    }
                }

            }

        }


    }


}
