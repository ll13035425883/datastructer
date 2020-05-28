package leetcode100;

import java.util.zip.ZipInputStream;

/**
 * 寻找两个正序数组的中位数
 *
 * @Author ll
 * @Date 2020/5/27 23:45
 */
public class FindMedianSortedArrays {
    /**
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
     *
     * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     *
     * 你可以假设 nums1 和 nums2 不会同时为空。
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     *
     * 则中位数是 (2 + 3)/2 = 2.5
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int i1 = 0, i2 = 0;
        int p = 0;
        while (i1 < nums1.length && i2 < nums2.length) {
            if(nums1[i1] < nums2[i2]) {
                nums[p++] = nums1[i1++];
            } else {
                nums[p++] = nums2[i2++];
            }
        }
        while (i1 < nums1.length) {
            nums[p++] = nums1[i1++];
        }
        while (i2 < nums2.length) {
            nums[p++] = nums2[i2++];
        }
        if(nums.length % 2 != 0) {
            return nums[nums.length / 2];
        } else {
            return (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2.0;
        }
    }
}
