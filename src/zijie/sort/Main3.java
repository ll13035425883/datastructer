package zijie.sort;

/**
 * 搜索旋转排序数组
 * https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1017/
 * @author ll
 */
public class Main3 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{3, 1}, 1));
    }

    /**
     * 思路：二分之后，至少有一边是有序的，通过有序的一边的范围判断下一个low和high的位置
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int mid;
        while(low <= high) {
            mid = (low + high) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            // 左边升序
            if(nums[mid] >= nums[low]) {
                // 判断目标元素是否在有序边
                if(nums[low] <= target && target < nums[mid]) {
                    // 左边区间找
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // 右边升序
            else {
                // 判断目标元素是否在有序边
                if(target <= nums[high] && target > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
