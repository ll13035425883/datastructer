package sort.first;

/**
 * 直接选择排序
 * 平均时间复杂度： O(n*n)
 * 最好时间复杂度： O(n*n)
 * 最坏时间复杂度： O(n*n)
 * 空间复杂度： O(1)
 * 稳定
 * @author ll
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,6,2,4,7,3,8,6};
        selectSort(arr);
        for (int a : arr) {
            System.out.print(a + ",");
        }
    }

    public static void selectSort(int[] arr) {
        int k = 0;
        for(int i = 0;i < arr.length - 1;i++) {
            int min = Integer.MAX_VALUE;
            for(int j = i;j < arr.length;j++) {
                if(arr[j] < min) {
                    min = arr[j];
                    k = j;
                }
            }
            swap(arr, i, k);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
