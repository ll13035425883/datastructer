package sort.first;

import java.util.Arrays;

/**
 * 归并排序
 * 平均时间复杂度： O(nlogn)
 * 最好时间复杂度： O(nlogn)
 * 最坏时间复杂度： O(nlogn)
 * 空间复杂度： O(n)
 * 稳定
 * @author ll
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,6,2,4,7,3,8,6};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }

    public static void mergeSort(int[] arr, int start, int end, int[] temp) {
        if(start < end) {
            int mid = (start + end) >> 1;
            mergeSort(arr, start, mid, temp);
            mergeSort(arr, mid + 1, end, temp);
            merge(arr, start, mid, end, temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int p1 = left, p2 = mid + 1, k = left;
        while(p1 <= mid && p2 <= right) {
            if(arr[p1] < arr[p2]) {
                temp[k++] = arr[p1++];
            } else {
                temp[k++] = arr[p2++];
            }
        }
        while(p1 <= mid) {
            temp[k++] = arr[p1++];
        }
        while(p2 <= right) {
            temp[k++] = arr[p2++];
        }
        // 排好序赋值会原数组
        for(int i = left;i <= right;i++) {
            arr[i] = temp[i];
        }
    }

}
