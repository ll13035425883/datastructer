package jzoffer.first;

import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,
 * 他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很
 * 快的找出所有和为S的连续正数序列? Good Luck!
 *
 * 输出所有和为S的连续正数序列。
 * 序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * @author ll
 */
public class Main41 {

    /**
     * 滑动窗口
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> continuousSequence = findContinuousSequence(3);
        for (ArrayList<Integer> list : continuousSequence) {
            for (int i = 0; i < list.size(); i++) {
                if(i != list.size() - 1) {
                    System.out.print(list.get(i) + ",");
                } else {
                    System.out.println(list.get(i));
                }
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int target) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if(target <= 0) {
            return lists;
        }
        // left: 左边界   right: 右边界
        int left = 1, right = 1, sum = 0;
        for(;right < target;right++) {
                sum += right;
                // 左边界右移
                while(sum > target) {
                    sum -= left++;
                }
                if(sum == target) {
                    ArrayList<Integer> list = new ArrayList<>();
                    for(int i = left;i <= right;i++) {
                        list.add(i);
                    }
                    lists.add(list);
                }
        }
        return lists;
    }
}
