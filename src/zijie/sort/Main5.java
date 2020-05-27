package zijie.sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

/**
 * 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1018/
 * @author ll
 */
public class Main5 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        int[] smallHeap = new int[k];
        Arrays.fill(smallHeap, Integer.MIN_VALUE);
        for (int i = 0; i < nums.length; i++) {
            if(smallHeap[0] < nums[i]) {
                smallHeap[0] = nums[i];
                adjustHeap(smallHeap, 0, k);
            }
        }
        return smallHeap[0];
    }

    public static void adjustHeap(int[] nums, int i, int len) {
        int temp = nums[i];
        for(int k = 2 * i + 1;k < len;k = 2 * k + 1) {
            if(k + 1 < len && nums[k + 1] < nums[k]) {
                k++;
            }
            if(nums[k] < temp) {
                nums[i] = nums[k];
                i = k;
            }
        }
        nums[i] = temp;
    }


    public static int quickSortHelper(int[] nums, int low, int high) {
        int p = nums[low];
        int i = low, j = high;
        while(i < j) {
            while(j > i && p <= nums[j]) {
                j--;
            }
            if (j > i) {
                nums[i++] = nums[j];
            }
            while(j > i && p >= nums[i]) {
                i++;
            }
            if(j > i) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = p;
        return i;
    }
}
