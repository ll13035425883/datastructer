package jzoffer.first;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 对应每个测试案例，输出两个数，小的先输出。
 * @author ll
 */
public class Main42 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        ArrayList<Integer> numbers = findNumbersWithSum2(arr, 15);
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }

    /**
     * 时间复杂度O(n*n)
     * 牛客网测试: 12ms
     * @param array
     * @param sum
     * @return
     */
    public static ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean flag = true;
        for (int i = 0; i < array.length - 1 && flag; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[i] + array[j] == sum) {
                    list.add(array[i]);
                    list.add(array[j]);
                    flag = false;
                    break;
                }
            }
        }
        return list;
    }

    /**
     * 时间复杂度O(n)
     * 牛客网测试: 17ms
     * @param array
     * @param sum
     * @return
     */
    public static ArrayList<Integer> findNumbersWithSum2(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0, right = array.length - 1;
        while(left < right) {
            if(array[left] + array[right] == sum) {
                list.add(array[left]);
                list.add(array[right]);
                break;
            } else if(array[left] + array[right] < sum) {
                left++;
            } else {
                right--;
            }
        }
        return list;
    }
}
