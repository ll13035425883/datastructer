package sort.first;

/**
 * 冒泡排序
 * 平均时间复杂度： O(n*n)
 * 最好时间复杂度： O(n)
 * 最坏时间复杂度： O(n*n)
 * 空间复杂度： O(1)
 * 稳定
 * @author ll
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,6,2,4,7,3,8,6,12,1,-1,2,33};
        bubbleSort(arr);
        for (int a : arr) {
            System.out.print(a + ",");
        }
    }

    /**
     * 从小到大
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int temp;
        boolean flag = false;
        // 排序次数
        for (int i = 0; i < arr.length - 1; i++) {
            // 每次将大数排到最后
            System.out.println("第" + (i + 1) + "趟");
            for(int j = 0;j < arr.length - 1 - i;j++) {
                if(arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if(!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }

}
