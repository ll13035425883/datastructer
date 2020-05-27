package sort.first;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆排序
 * 平均时间复杂度： O(nlogn)
 * 最好时间复杂度： O(nlogn)
 * 最坏时间复杂度： O(nlogn)
 * 空间复杂度： O(1)
 * 不稳定
 * @author ll
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,6,2,4,7,3,8,6};
        heapSort(arr);
        for (int a : arr) {
            System.out.print(a + ",");
        }
    }

    /**
     * 大根堆
     * @param arr
     */
    public static void heapSort(int[] arr) {
        if(arr == null || arr.length == 0) {
            return;
        }
        int len = arr.length;
        // 建大根堆
        for(int i = len / 2 - 1;i >= 0;i--) {
            adjustHeap(arr, i, len);
        }
        // 出堆
        while(len-- > 0) {
            swap(arr, 0, len);
            adjustHeap(arr, 0, len);
        }
    }

    /**
     *
     * @param arr
     * @param i  要调整的结点
     * @param len
     */
    public static void adjustHeap(int[] arr, int i, int len) {
        if(len <= 0) {
            return;
        }
        int temp = arr[i];
        for(int k = 2 * i + 1;k < len;k = 2 * k + 1) {
            if(k + 1 < len && arr[k + 1] > arr[k]) {
                k++;
            }
            if(arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            }
        }
        arr[i] = temp;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
