package jzoffer.first;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口
 * 有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * @author ll
 */
public class Main64 {

    public static void main(String[] args) {
        ArrayList<Integer> list = maxInWindows(new int[]{1,3,5,7,9,11,13,15}, 4);
        for (Integer integer : list) {
            System.out.print(integer + ",");
        }
    }

    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if(size <= 0 || num == null || num.length == 0) {
            return list;
        }
        // 双端队列存储最大值下标
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while(!deque.isEmpty()) {
                if(i - deque.peekFirst() >= size) {
                    deque.pollFirst();
                } else if(num[i] > num[deque.peekLast()]) {
                    deque.pollLast();
                } else {
                    break;
                }
            }
            deque.offerLast(i);
            if(i >= size - 1) {
                list.add(num[deque.peekFirst()]);
            }
        }
        return list;
    }
}
