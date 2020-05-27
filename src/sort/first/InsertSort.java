package sort.first;

/**
 * 直接插入排序
 * 平均时间复杂度： O(n*n)
 * 最好时间复杂度： O(n)
 * 最坏时间复杂度： O(n*n)
 * 空间复杂度： O(1)
 * 稳定
 * @author ll
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,6,2,4,7,3,8,6};
        insertSort(arr);
        for (int a : arr) {
            System.out.print(a + ",");
        }
    }

    public static void insertSort(int[] arr) {
        if(arr == null || arr.length <= 1) {
            return;
        }
        int j, temp;
        for(int i = 1;i < arr.length;i++) {
            j = i;
            temp = arr[i];
            while(j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

}
