package jzoffer.first;

/**
 * 统计一个数字在排序数组中出现的次数。
 * @author ll
 */
public class Main37 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,3,3,3};
        System.out.println(getNumberOfK(arr, 3));
    }

    public static int getNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0) {
            return 0;
        }
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            // 找到k
            if(k == array[i] && !flag) {
                if(i == array.length - 1) {
                    count = 1;
                } else {
                    count = i + 1;
                }
                flag = true;
            }
            // 遍历到k之后的数，结束循环
            if(k != array[i] && flag) {
                count = i - count + 1;
                break;
            }
            if(flag && i == array.length - 1) {
                count = i - count + 2;
            }
        }
        return count;
    }
}
