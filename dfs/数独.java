class Solution {
    char[][] board;
    boolean[][] col = new boolean [9][9];
    boolean[][] row = new boolean [9][9];
    boolean[][][] block = new boolean [3][3][9];
    boolean valid = false;
    ArrayList<int[]> dot = new ArrayList();

    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    dot.add(new int[]{i, j});
                } else {
                    col[i][board[i][j] - 49] =
                            row[j][board[i][j] - 49] = block[i / 3][j / 3][board[i][j] - 49] = true;
                }
            }
        }
        dfs(0);
    }

    public void dfs(int pos) {
        if (pos == dot.size()) {
            valid = true;
            return;
        }
        int[] d = dot.get(pos);
        int i = d[0], j = d[1];
        for (int val = 1; val <= 9 && !valid; val++) {
            if (!col[i][val - 1] &&
                    !row[j][val - 1] && !block[i / 3][j / 3][val - 1]) {

                col[i][val - 1] = row[j][val - 1] = block[i / 3][j / 3][val - 1] = true;
                board[i][j] = (char)(val + 48);
                dfs(pos + 1);
                col[i][val - 1] = row[j][val - 1] = block[i / 3][j / 3][val - 1] = false;
            }
        }

    }
}