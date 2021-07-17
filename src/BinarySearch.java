import org.junit.Test;

/**
 * @author Chang
 * @description 二分法查找
 * @create 2021-01-28 7:33
 */
public class BinarySearch {
    /*
        自己实现
     */
    @Test
    public void test1() {
        int nums[] = new int[]{-1, 0, 3, 5, 9, 12};
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;

        int target = 9;

        for (; left <= right; ) {
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target == nums[mid]) {
//                return mid;
                System.out.println(mid);
                break;
            } else {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }

    }

    /*
        标准模板1
     */
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // End Condition: left > right
        return -1;
    }

    @Test
    public void test() {
        long x = 2147395599;
        long mid = x * x;
        System.out.println(mid);
    }


    /*
        对于模板1的练习：实现int sqrt(int x)求x的平方根
     */
    @Test
    public void test2() {
        long x = 2147395599L;
        long left = 1;
        long right = x;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if ((mid * mid) < x) {
                left = mid + 1;
            } else if ((mid * mid) > x) {
                right = mid - 1;
            } else {
//                return mid;
                System.out.println(mid);
            }
        }
        System.out.println(right);
    }

    /*
        正确写法
     */
    public int mySqrt(int x) {
        //    int x = 9;
        int ans = -1;
        if (x < 2) {
            return x;
        }
        // if(x<0){return -1;}
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return ans;
    }

    @Test
    public void testSpirl() {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int dot = 0; //记录螺旋点
        //先找旋转的点
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                dot = i;
                break;
            }
        }
        //前段有序递增的序列进行折半
        int left = 0;
        int right = dot;
        boolean isExtend = false;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                System.out.println("索引是" + mid);
                break;
            }
            if (left > right && isExtend == false) {
                isExtend = true;
                left = dot + 1;
                right = nums.length - 1;
            }
        }
//        if (!isFind) {
//        left = dot + 1;
//        right = nums.length - 1;
//        while (left <= right) {
////                int mid = left + (right - left) / 2;
////                if (nums[mid] < target) {
////                    left = mid + 1;
////                } else if (nums[mid] > target) {
////                    right = mid - 1;
////                }else{
////                    isFind = true;
////                    System.out.println("索引是" + mid);
////                    break;
////                }
//        }
//    }
    }

    /*
    模板二：查找空间留两位，添加后处理
    int binarySearch(int[] nums, int target){
  if(nums == null || nums.length == 0)
    return -1;

  int left = 0, right = nums.length;
  while(left < right){
    // Prevent (left + right) overflow
    int mid = left + (right - left) / 2;
    if(nums[mid] == target){ return mid; }
    else if(nums[mid] < target) { left = mid + 1; }
    else { right = mid; }
  }

  // Post-processing:
  // End Condition: left == right
  if(left != nums.length && nums[left] == target) return left;
  return -1;
}
     */

    /*
        使用模板二找出第一个错误版本
        第一个错误版本意味着，需要先找到一个false
        再找到相邻的下一个是true
     */
    @Test
    public void testVersionControl() {
        int left = 1;
        int n = 5;
        int right = n;      //总个数
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (!isBadVersion(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }


        }
//        return left;
    }

    private boolean isBadVersion(int mid) {
        return true;
    }

    /*
        模板二:判断峰值元素
     */
    @Test
    public void testTopEle() {
        int nums[] = new int[]{1, 2, 1, 3, 5, 6, 4};
        if (nums.length == 1) {
//            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;

            } else if (nums[mid] > nums[mid + 1]) {
                right = mid;
            }

        }
        if (left != nums.length) {
//            return nums[left];
        }
//        return -1;
    }


    /*
        模板二：假设按照升序排序的数组在预先未知的某个点上进行了旋转。
        例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
        请找出其中最小的元素。

        思路：遍历数组找到变化点，变化点就是最小值，但这可能会浪费时间
        使用二分搜索是更好的解决方法。
     */
    @Test
    public void testRev() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        //遍历找到旋转的点
//        int iRev;
//        for (iRev = 0; iRev < nums.length-1; iRev++) {
//            if(nums[iRev]>nums[iRev+1]){
//                iRev +=1;
//                break;
//            }
//        }

        /*
            二分搜索
            思路：抓住数组是有序的特点，如果nums[mid]>nums[left]则证明期间没有旋转点

         */

        if (nums.length == 1) {
//            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        if (nums[right] > nums[0]) {
//            return nums[0];
        }
        while (left < right) {
            int mid = left + (right - left) / 2;


            if (nums[mid - 1] > nums[mid]) {
//                return mid;
            }
            if (nums[mid] > nums[mid + 1]) {
//                return mid+1;
            }

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
//        return -1;

    }



    /*
        模板三：
            给定一个按照升序排列的整数数组 nums，和一个目标值 target。
            找出给定目标值在数组中的开始位置和结束位置。
            如果数组中不存在目标值 target，返回 [-1, -1]。
            进阶：
            你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
            示例 1：
            输入：nums = [5,7,7,8,8,10], target = 8
            输出：[3,4]
     */

    @Test
    public void testModel3() {
        int[] nums = {5, 7, 7, 8, 8, 10};

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            
        }
    }
}

