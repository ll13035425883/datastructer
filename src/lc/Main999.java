package lc;

/**
 * 车的可用捕获量
 * https://leetcode-cn.com/problems/available-captures-for-rook/
 * @author ll
 */
public class Main999 {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','R','.','.','.','p'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},};
        System.out.println(numRookCaptures(board));

    }

    public static int numRookCaptures(char[][] board) {
        boolean flag = true;
        int i = 0, j = 0, k, count = 0;
        for (i = 0; i < board.length; i++) {
            for (j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'R') {
                    flag = false;
                    break;
                }
            }
            if(!flag) {
                break;
            }
        }
        k = j - 1;
        while(k >= 0) {
            if(board[i][k] == 'p') {
                count++;
                break;
            }
            if(board[i][k] == 'B') {
                break;
            }
            k--;
        }
        k = j + 1;
        while(k < board[0].length) {
            if(board[i][k] == 'p') {
                count++;
                break;
            }
            if(board[i][k] == 'B') {
                break;
            }
            k++;
        }
        k = i - 1;
        while(k >= 0) {
            if(board[k][j] == 'p') {
                count++;
                break;
            }
            if(board[k][j] == 'B') {
                break;
            }
            k--;
        }
        k = i + 1;
        while(k < board.length) {
            if(board[k][j] == 'p') {
                count++;
                break;
            }
            if(board[k][j] == 'B') {
                break;
            }
            k++;
        }
        return count;
    }
}
