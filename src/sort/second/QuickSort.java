package sort.second;

/**
 * @Author ll
 * @Date 2020/5/27 9:32
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4,5,6,3,1,3,6,7,7,9};
        sort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static void sort(int[] arr, int low, int high) {
        if(low < high) {
            int p = partitioner(arr, low, high);
            partitioner(arr, low, p - 1);
            partitioner(arr, p + 1, high - 1);
        }
    }

    public static int partitioner(int[] arr, int low, int high) {
        int temp = arr[low];
        int i = low, j = high;
        while (i < j) {
            while (i < j && temp <= arr[j]) {
                j--;
            }
            if(i < j) {
                arr[i++] = arr[j];
            }
            while (i < j && temp >= arr[i]) {
                i++;
            }
            if(i < j) {
                arr[j--] = arr[i];
            }
        }
        arr[i] = temp;
        return i;
    }
}
