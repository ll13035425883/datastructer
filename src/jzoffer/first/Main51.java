package jzoffer.first;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素
 * B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 * @author ll
 */
public class Main51 {
    public static void main(String[] args) {

    }

    /**
     * https://www.nowcoder.com/questionTerminal/94a4d381a68b47b7a8bed86f2975db46?f=discussion
     * @param A
     * @return
     */
    public static int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if(length != 0) {
            B[0] = 1;
            // 计算下三角连乘
            for(int i = 1;i < length;i++) {
                B[i] = B[i - 1] * A[i - 1];
            }
            int temp = 1;
            // 计算上三角
            for(int j = length - 2;j >= 0;j--) {
                temp *= A[j + 1];
                B[j] *= temp;
            }
        }
        return B;
    }

    public static int[] multiply2(int[] A) {
        if(A == null || A.length <= 1) {
            return A;
        }
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = multiplyHelper(A, i);
        }
        return B;
    }

    public static int multiplyHelper(int[] arr, int i) {
        int m = 1;
        for (int j = 0; j < arr.length; j++) {
            if(j == i) {
                continue;
            }
            m *= arr[j];
        }
        return m;
    }

}
