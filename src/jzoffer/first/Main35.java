package jzoffer.first;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,
 * 求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * @author ll
 */
public class Main35 {

    private static int count = 0;

    public static void mergeSort(int[] arr, int start, int end, int[] temp) {
        if(start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid, temp);
            mergeSort(arr, mid + 1, end, temp);
            merge(arr, start, mid, end, temp);
        }
    }

    public static void merge(int[] arr, int start, int mid, int end, int[] temp) {
        int p1 = start, p2 = mid + 1, k = start;
        while(p1 <= mid && p2 <= end) {
            if(arr[p1] > arr[p2]) {
                // 左边比右边大，逆序
                temp[k++] = arr[p2++];
                // p1 -- mid的所有数都和arr[p2]构成逆序对
                count += (mid - p1 + 1) % 1000000007;
            } else  {
                temp[k++] = arr[p1++];
            }
        }
        while(p1 <= mid) {
            temp[k++] = arr[p1++];
        }
        while(p2 <= end) {
            temp[k++] = arr[p2++];
        }
        for(int i = start;i <= end;i++) {
            arr[i] = temp[i];
        }
    }

    /**
     * 思路：
     * 先把数组分隔成子数组，先统计出子数组内部的逆序对的数目，然后再统计出两个相邻子数组
     * 之间的逆序对的数目。在统计逆序对的过程中，还需要对数组进行排序。如果对排序算法很熟
     * 悉，我们不难发现这个排序的过程就是归并排序。
     */
    public int inversePairs(int [] array) {
        int[] temp = new int[array.length];
        mergeSort(array, 0, array.length - 1, temp);
        return count;
    }

    public static void main(String[] args) {
        Main35 main35 = new Main35();
        System.out.println(main35.inversePairs(new int[]{364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575}));

    }
}
