package sort.first;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 快速排序
 * 平均时间复杂度： O(nlogn)
 * 最好时间复杂度： O(nlogn)
 * 最坏时间复杂度： O(n*n)
 * 空间复杂度： O(nlogn)
 * 不稳定
 * @author ll
 */
public class QuickSort {
    public static void main(String[] args) {
        String s = "297312312300321355325339377303293343349293306349303319309341305325360301294329314356299335321303325382313308321375298352303322320291329316336324307313303310291349298332" +
                "386361306323311334373320319333300337323398327316314326311359311381330306293323314338335376298317329294365319356340346379335331295323354380342354314292356338373320356313367298341298330" +
                "346317364331292297340295346367311311313312295338349291298314321307358296330325305367295336370338301325313299302313335331313328348303332345337296312318292305321308319342327380314358329" +
                "372303348340352307296344329310293390346334337316352337292348308316331391327353365340330377382317390372347297359353296363335327326312295291321322295334326319310320317353341332330324303";
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length() - 2; i += 3) {
            list.add(Integer.parseInt(s.substring(i, i + 3)));
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        quickSort2(arr, 0, arr.length - 1);
        System.out.println(1 + ": " +arr[arr.length - 1]);
        for (int i = arr.length - 2; i >= 0; i--) {
            if(arr[i] != arr[i + 1]) {
                System.out.println(arr.length - i + ": " + arr[i]);
            }

        }
    }

    /**
     * 递归快排
     * @param arr
     * @param low
     * @param high
     */
    public static void quickSort1(int[] arr, int low, int high) {
        if(low < high) {
            int p = partition(arr, low, high);
            quickSort1(arr, low, p - 1);
            quickSort1(arr, p + 1, high);
        }
    }

    /**
     * 非递归快排
     * @param arr
     * @param low
     * @param high
     */
    public static void quickSort2(int[] arr, int low, int high) {
        if(low >= high) {
            return;
        }
        int p;
        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);
        while(!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();
            p = partition(arr, low, high);
            if(p - 1 > low) {
                stack.push(low);
                stack.push(p - 1);
            }
            if(high > p + 1) {
                stack.push(p + 1);
                stack.push(high);
            }
        }
    }

    /**
     * 分区
     * @param arr
     * @param low
     * @param high
     */
    public static int partition(int[] arr, int low, int high) {
        int temp = arr[low];
        int i = low, j = high;
        while(i < j) {
            while(i < j && temp < arr[j]) {
                j--;
            }
            if(i < j) {
                arr[i] = arr[j];
                i++;
            }
            while(i < j && temp > arr[i]) {
                i++;
            }
            if(i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = temp;
        return i;
    }

}
