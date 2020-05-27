package df;

import java.util.Arrays;

public class Bag {

    // https://www.cnblogs.com/mqk100/p/11319417.html

    public static int getMaxValue(int[] weight, int[] value, int w, int n) {
        // 创建一个二维数组，横列是物品的价值，竖列是物品的重量
        int[][] table = new int[n + 1][w + 1];
        //物品
        for (int i = 1; i <= n; i++) {
            //背包大小
            for (int j = 1; j <= w; j++) {
                if (weight[i] > j) {
                    //当前物品i的重量比背包容量j大，装不下，肯定就是不装
                    table[i][j] = table[i - 1][j];
                } else {
                    //装得下，Max{装物品i， 不装物品i}
                    table[i][j] = Math.max(table[i - 1][j], table[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        // 蓝色代码注释结束
        return table[n][w];
    }

    public static int coinChange(int[] coins, int amount) {

        int[][] w = new int[coins.length + 1][amount + 1];
        for(int i = 1;i <= coins.length;i++) {
            for(int j = 0;j <= amount;j++) {
                if(coins[i-1] > j) {
                    w[i][j] = w[i-1][j];
                } else {
                    int n = j / coins[i-1];
                    if(j % coins[i-1] == 0) {
                        w[i][j] = n;
                    } else {
                        w[i][j] = w[i-1][j];
                        for(int k = 1;k <= n;k++) {
                            w[i][j] = Math.min(w[i][j],w[i-1][j-coins[i-1]*k] + k);
                        }
                    }
                }
            }
        }
        return w[coins.length][amount] == 0 ? -1:w[coins.length][amount];
    }

    public static void main(String[] args) {
//        int n = 5, w = 10;                    //物品个数，背包容量
//        // 红色代码注释开始
//        int[] value = {0,6, 3, 5, 4, 6};     //各个物品的价值
//        int[] weight = {0,2, 2, 6, 5, 4};    //各个物品的重量
//        // 红色代码注释结束
//        System.out.println(getMaxValue(weight, value, w, n));
        Arrays.sort(new int[]{1,2,5,10});
        System.out.println(coinChange(new int[]{1,2,5,10},27));
    }

}
