package sort.second;

/**
 * @Author ll
 * @Date 2020/5/27 10:04
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1,2,4,6,2,4,7,3,8,6};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static void mergeSort(int[] arr, int low, int high, int[] temp) {
        if(low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid, temp);
            mergeSort(arr, mid + 1, high, temp);
            merge(arr, low, mid, high, temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int p = left, p1 = mid + 1;
        int k = left;
        while (p <= mid && p1 <= right) {
            if(arr[p] < arr[p1]) {
                temp[k++] = arr[p++];
            } else {
                temp[k++] = arr[p1++];
            }
        }
        while (p <= mid) {
            temp[k++] = arr[p++];
        }
        while (p1 <= right) {
            temp[k++] = arr[p1++];
        }
        for(int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }

}
