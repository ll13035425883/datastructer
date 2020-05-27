package jzoffer.second;

import java.util.ArrayList;

/**
 * @Author ll
 * @Date 2020/4/29 16:39
 */
public class Main19 {
    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
     * 1  2  3  4
     * 5  6  7  8
     * 9  10 11 12
     * 13 14 15 16
     * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = printMatrix(new int[][]{{1,2,3,4},
                                                                {5,6,7,8},
                                                                {9,10,11,12},
                                                                {13,14,15,16}});
        for (Integer i : arrayList) {
            System.out.print(i + ", ");
        }

    }

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        int count = 0, point = 0;
        int n = matrix.length * matrix[0].length;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while(arrayList.size() < n) {
            point = count++ % 4;
            if(point == 0) {
                // left -> right
                for(int i = left;i <= right;i++) {
                    arrayList.add(matrix[top][i]);
                }
                top++;
            } else if(point == 1) {
                // top -> bottom
                for(int i = top;i <= bottom;i++) {
                    arrayList.add(matrix[i][right]);
                }
                right--;
            } else if(point == 2) {
                // right -> left
                for(int i = right;i >= left;i--) {
                    arrayList.add(matrix[bottom][i]);
                }
                bottom--;
            } else if(point == 3) {
                // bottom -> top
                for(int i = bottom;i >= top;i--) {
                    arrayList.add(matrix[i][left]);
                }
                left++;
            }
        }
        return arrayList;
    }
}
