package jzoffer.second;

import sun.awt.geom.AreaOp;

/**
 * @Author ll
 * @Date 2020/4/29 10:49
 */
public class Main13 {
    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
     * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,3,4,7,9,8};
        reOrderArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 时间换空间
     * @param array
     */
    public static void reOrderArray(int [] array) {
        if(array == null || array.length <= 1) {
            return;
        }
        // j: 前面奇数后的第一个偶数
        for (int i = 0, j = 0; i < array.length; i++) {
            if(array[i] % 2 != 0) {
                if(i != j) {
                    int temp = array[i];
                    for(int k = i - 1;k >= j;k--) {
                        array[k + 1] = array[k];
                    }
                    array[j] = temp;
                }
                j++;
            }
        }
    }

}
