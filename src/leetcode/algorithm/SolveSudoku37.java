package leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

public class SolveSudoku37 {
    public static void main(String[] args) {
        char[][] sudoku = {
                  {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
      Solution.solveSudoku(sudoku);
    }
    static class Solution {


        static  public void solveSudoku(char[][] board) {
             boolean[][] line = new boolean[9][9];
             boolean[][] column = new boolean[9][9];
             boolean[][][] block = new boolean[3][3][9];
             boolean valid = false;
             List<int[]> spaces = new ArrayList<int[]>();
                    for (int i = 0; i < 9; ++i) {
                        for (int j = 0; j < 9; ++j) {
                            if (board[i][j] == '.') {
                                spaces.add(new int[]{i, j});
                            } else {
                                int digit = board[i][j] - '0' - 1;
                                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                            }
                        }
                    }

                    dfs(board, 0,line,column,block,valid,spaces);
                }

                public static void dfs(char[][] board, int pos,boolean[][] line,boolean[][] column, boolean[][][] block,boolean valid, List<int[]> spaces) {
                    if (pos == spaces.size()) {
                        valid = true;
                        return;
                    }

                    int[] space = spaces.get(pos);
                    int i = space[0], j = space[1];
                    for (int digit = 0; digit < 9 && !valid; ++digit) {
                        if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                            line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                            board[i][j] = (char) (digit + '0' + 1);
                            dfs(board, pos + 1,line,column,block,valid,spaces);
                            line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
                        }
                    }
                }

    }
}
