package lc;

import java.util.*;

/**
 * 使数组唯一的最小增量
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 *
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 * @author ll
 */
public class Main945 {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,2,1,7};
        System.out.println(minIncrementForUnique(arr));
    }

    /**
     * O(nlogn)
     * @param A
     * @return
     */
    public static int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int move = 0;
        // 比如排完过后是A[1,2,2,2,3]，A[2]+1后就是[1,2,3,2,3]，这时候A[3]就比A[2]小了，需要move两次
        for (int i = 1; i < A.length; i++) {
            if(A[i] <= A[i - 1]) {
                int pre = A[i];
                A[i] = A[i - 1] + 1;
                move += A[i] - pre;
            }
        }
        return move;
    }

    public static int minIncrementForUnique2(int[] A) {
        if(A == null || A.length <= 1) {
            return 0;
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if(list1.contains(A[i])) {
                list2.add(A[i]);
            } else {
                list1.add(A[i]);
            }
        }
        Collections.sort(list2);
        for (int i = list2.size() - 1; i >= 0; i--) {
            int k = list2.get(i);
            while(list2.contains(k) || list1.contains(k)) {
                k++;
                count++;
            }
            list2.remove(i);
            list2.add(k);
        }
        return count;
    }


}
