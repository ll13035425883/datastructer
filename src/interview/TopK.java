package interview;

import sort.first.HeapSort;
import sort.first.QuickSort;

import java.util.Arrays;

/**
 * 海量数据中找到Top k小数据
 * @author ll
 */
public class TopK {

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,2,4,2,2,3,1,4};
        int k = 7;
//        int[] topK = solution1(arr, k);
        int[] topK = solution2(arr, k);
        for (int i : topK) {
            System.out.print(i + ",");
        }
    }

    /**
     * 快排解决
     * 时间复杂度： O(n)
     * 最坏时间复杂度： O(n*n)
     * 空间复杂度： O(log n)
     * @param arr
     * @param k
     * @return
     */
    public static int[] solution1(int[] arr, int k) {
        if(k <= 0 || arr.length == 0) {
            return new int[0];
        }
        k--;
        int p = -1, low = 0;
        while(true) {
            if(p < k) {
                p = QuickSort.partition(arr, p + 1, arr.length - 1);
            } else if(p > k) {
                p = QuickSort.partition(arr, low, p - 1);
            } else {
                break;
            }
            if(p < k) {
                low = p + 1;
            }
        }
        int[] topKMin = Arrays.copyOfRange(arr, 0, k + 1);
        return topKMin;
    }

    /**
     * 堆解决
     * 时间复杂度： O(n*log k)
     * 空间复杂度： O(k)
     * @param arr
     * @param k
     * @return
     */
    public static int[] solution2(int[] arr, int k) {
        if(k <= 0 || arr.length == 0) {
            return new int[0];
        }
        // 创建长度为k的大根堆数组
        int[] topKMin = new int[k];
        Arrays.fill(topKMin, Integer.MAX_VALUE);
        for (int i : arr) {
            if(i < topKMin[0]) {
                topKMin[0] = i;
                // 维护大根堆
                HeapSort.adjustHeap(topKMin, 0, topKMin.length);
            }
        }
        return topKMin;
    }

}
