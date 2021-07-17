package offer001;

/**
 * @author Chang
 * @description 面试题4： 二维数组查找
 * @create 2021-07-06 9:22
 */
public class _4BiArraySearch {

    public static void main(String[] args) {

        int arr[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int target = 7;

        // int i = 0;
        // int j = arr[0].length -1;
        // arr[0][arr[0].length-1]     // 右上角的数
        for (int i = 0, j = arr[0].length - 1; i < arr.length && j >= 0; ) {
            if (arr[i][j] > target) {
                j--;
            }
            if (arr[i][j] < target){
                i++;
            }
            if(arr[i][j]==target){
                System.out.println("存在，位置是(" + i + "," + j + ")");
                break;
            }
        }
    }
}
