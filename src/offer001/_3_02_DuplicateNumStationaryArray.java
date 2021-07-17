package offer001;

/**
 * @author Chang
 * @description 不让改变原有数组，找出任意一个重复的数字
 * 数字范围 1-n，而数组长度是n+1
 * @create 2021-07-10 12:59
 */
public class _3_02_DuplicateNumStationaryArray {


    public static void main(String[] args) {

        Integer arr[] = {2, 3, 4, 5, 3, 6, 7, 2, 1};        // 1-7
//        hashArr(arr);
//        Integer hashSet[] = new Integer[7];
//        System.out.println(hashSet[0]);       // Integer数组默认值是null

        binarySearch(arr);
    }

    private static void binarySearch(Integer[] arr) {

        // 起始的数字范围
        int start = 1;
        int end = arr.length - 1;

        while (end >= start) {

            int middle = ((end - start) >> 1) + start;
            int count = countTimes(arr, start, middle);

            if (end == start) {

                if (count > 1) {
                    System.out.println("重复数字： " + start);
                    break;
                } else
                    break;
            }

            if (count > middle - start + 1) {

                end = middle - 1;

            } else {

                start = middle + 1;
            }
        }

    }

    /**
     * 计算某个范围中所有数字的出现个数
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private static int countTimes(Integer[] arr, int start, int end) {

        int count = 0;
        for (int item : arr) {
            if (item >= start && item <= end)
                count++;
        }
        return count;
    }

    /**
     * 使用hash表的方式做出解法，不好的是会造成O(n)的空间复杂度浪费
     *
     * @param arr
     */
    public static void hashArr(Integer arr[]) {

        Integer[] hashSet = new Integer[arr.length];

        for (int i = 0; i < arr.length; i++) {

            if (hashSet[arr[i]] == null) {

                hashSet[arr[i]] = arr[i];
            } else {

                System.out.println("其中一个重复的值是： " + arr[i]);
            }
        }

    }
}
