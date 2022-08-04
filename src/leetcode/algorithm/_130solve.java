package leetcode.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class _130solve {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'O','O','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        TwoDimensionalArray.printArrays(board);
        System.out.println("================");
        MySolution.solve(board);
        TwoDimensionalArray.printArrays(board);
    }
    static class MySolution {
        static public void solve(char[][] board) {
            for (int i = 1; i < board[0].length - 1; i++) {
                if (board[0][i] == 'O'){
                    dfs(1,i,board);
                }
                if (board[i][board[i].length - 1] == 'O'){
                    dfs(i,board[i].length - 2,board);
                }
                if (board[board.length - 1][i] == 'O'){
                    dfs(board.length - 2,i,board);
                }
                if (board[i][0] == 'O'){
                    dfs(i,1,board);
                }
            }
            for (int i = 1; i < board[0].length - 1; i++) {
                for (int j = 1; j < board.length - 1; j++) {
                    if (board[i][j] == 'O')
                        board[i][j] = 'X';
                    else if (board[i][j] == '*')
                        board[i][j] = 'O';
                }
            }
        }
        public static void dfs(int i,int j,char[][] board){
            if (i > board[0].length - 1 || i < 1 || j > board.length - 1 || j < 1)
                return;
            if (board[i][j] == 'O'){
                board[i][j] = '*';
                dfs(i + 1, j, board);
                dfs(i - 1, j, board);
                dfs(i, j - 1, board);
                dfs(i, j + 1, board);
            }
        }
    }
    class Solution {
        int n, m;

        public void solve(char[][] board) {
            n = board.length;
            if (n == 0) {
                return;
            }
            m = board[0].length;
            for (int i = 0; i < n; i++) {
                dfs(board, i, 0);
                dfs(board, i, m - 1);
            }
            for (int i = 1; i < m - 1; i++) {
                dfs(board, 0, i);
                dfs(board, n - 1, i);
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 'A') {
                        board[i][j] = 'O';
                    } else if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        public void dfs(char[][] board, int x, int y) {
            if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
                return;
            }
            board[x][y] = 'A';
            dfs(board, x + 1, y);
            dfs(board, x - 1, y);
            dfs(board, x, y + 1);
            dfs(board, x, y - 1);
        }
    }
    class Solution2 {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        public void solve(char[][] board) {
            int n = board.length;
            if (n == 0) {
                return;
            }
            int m = board[0].length;
            Queue<int[]> queue = new LinkedList<int[]>();
            for (int i = 0; i < n; i++) {
                if (board[i][0] == 'O') {
                    queue.offer(new int[]{i, 0});
                    board[i][0] = 'A';
                }
                if (board[i][m - 1] == 'O') {
                    queue.offer(new int[]{i, m - 1});
                    board[i][m - 1] = 'A';
                }
            }
            for (int i = 1; i < m - 1; i++) {
                if (board[0][i] == 'O') {
                    queue.offer(new int[]{0, i});
                    board[0][i] = 'A';
                }
                if (board[n - 1][i] == 'O') {
                    queue.offer(new int[]{n - 1, i});
                    board[n - 1][i] = 'A';
                }
            }
            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];
                for (int i = 0; i < 4; i++) {
                    int mx = x + dx[i], my = y + dy[i];
                    if (mx < 0 || my < 0 || mx >= n || my >= m || board[mx][my] != 'O') {
                        continue;
                    }
                    queue.offer(new int[]{mx, my});
                    board[mx][my] = 'A';
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 'A') {
                        board[i][j] = 'O';
                    } else if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }

}
