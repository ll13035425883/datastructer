package jzoffer.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读
 * 取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * @author ll
 */
public class Main63 {

    private static List<Integer> list;
    /**
     * 保留最中间值的下标
     */
    private static int[] median;

    public static void main(String[] args) {
        int[] arr = new int[]{5,2,3,4,1,6,7,0,8};
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
            System.out.println(arr[i] + "-->" + getMedian());
        }
    }

    public static void insert(Integer num) {
        if(list == null) {
            list = new ArrayList<>();
            list.add(num);
            median = new int[2];
            return;
        }
        list.add(num);
        Collections.sort(list);
        if(list.size() % 2 == 0) {
            median[1] = median[0] + 1;
        } else {
            median[0] = median[1];
        }
    }

    public static Double getMedian() {
        if(list == null) {
            return null;
        }
        if(list.size() == 1) {
            return list.get(0) / 1.0;
        }
        return (list.get(median[0]) + list.get(median[1])) / 2.0;
    }
}
