package jzoffer.first;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * @author ll
 */
public class Main40 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,3,3,3,4,4,7,8,9,9,7,8};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        findNumsAppearOnce(arr, num1, num2);
        System.out.println(num1[0] + " -- " + num2[0]);
    }

    public static void findNumsAppearOnce(int [] array,int[] num1 , int[] num2) {
        if(array == null) {
            return;
        }
        if(array.length == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num : array) {
            if(hashMap.get(num) == null) {
                hashMap.put(num, 1);
            } else {
                hashMap.remove(num);
            }
        }
        int i = 0;
        for(Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if(i++ == 0) {
                num1[0] = entry.getKey();
            } else {
                num2[0] = entry.getKey();
            }
        }
    }
}
