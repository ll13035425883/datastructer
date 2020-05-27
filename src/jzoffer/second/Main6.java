package jzoffer.second;

/**
 * @Author ll
 * @Date 2020/4/28 22:37
 */
public class Main6 {
    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     * @param args
     */
    public static void main(String[] args) {

    }

    public static int minNumberInRotateArray(int [] array) {
        if(array == null || array.length == 0) {
            return 0;
        }
        int left = 0, right = array.length - 1, mid = 0;
        while(array[left] >= array[right]) {
            // 如果此时数组只剩下两个数值,最小的就是右边
            if(right - left == 1) {
                mid = right;
                break;
            }
            mid = (left + right) / 2;
            // 假如最左边和中间以及最右边值都相等，只能进行顺序查找，如{1,1,1,0,1}
            if(array[left] == array[mid] && array[mid] == array[right]) {
                return orderFind(array, left, right);
            } else if(array[mid] >= array[left]){
                left = mid;
            } else if(array[mid] <= array[right]) {
                right = mid;
            }
        }

        return array[mid];
    }

    public static int orderFind(int[] array, int left, int right) {
        int min = array[left];
        for (int i = left + 1; i <= right; i++)
        {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

}
