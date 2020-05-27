package jzoffer.first;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出是第一个重复的数字2。
 * @author ll
 */
public class Main50 {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,0,2,5,3};
        int[] temp = new int[1];
        System.out.println(duplicate2(arr, arr.length, temp));
        System.out.println(temp[0]);
    }

    /**
     * 解法一
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public static boolean duplicate(int[] numbers,int length,int[] duplication) {
        if(numbers == null || length <= 1) {
            return false;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            if(numbers[i] == numbers[i + 1]) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    /**
     * 解法二
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public static boolean duplicate2(int[] numbers,int length,int[] duplication) {
        if(numbers == null || length <= 1) {
            return false;
        }
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if(hashMap.get(numbers[i]) == null) {
                hashMap.put(numbers[i], -1);
            } else {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }
}
