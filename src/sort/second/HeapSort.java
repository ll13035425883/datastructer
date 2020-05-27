package sort.second;

/**
 * 堆排序
 *
 * @Author ll
 * @Date 2020/5/26 22:47
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,1,1,5,3,5,6,7,3,2};
        int len = arr.length;
        for(int i = len / 2 - 1; i >= 0; i--) {
            adjustHead(arr, i, len);
        }
        while (len-- > 0) {
            swap(arr, 0, len);
            adjustHead(arr, 0, len);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void adjustHead(int[] arr, int i, int len) {
        if(len < 0) {
            return;
        }
        int temp = arr[i];
        for(int k = 2 * i + 1; k < len; k = k * 2 + 1) {
            if(k + 1 < len && arr[k] < arr[k + 1]) {
                k++;
            }
            if(arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            }
        }
        arr[i] = temp;
    }

}
