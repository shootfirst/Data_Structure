class Solution {
    int pos = 0;
    char[] arr;
    int m;
    int n;
    char[][] board;
    boolean [][] visit;
    int [][]direction = new int [][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        arr = word.toCharArray();
        m = board.length;
        n = board[0].length;
        this.board = board;
        visit = new boolean[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j)) return true;
            }
        }

        return false;
    }

    public boolean dfs(int x, int y) {

        if (pos == arr.length - 1) return board[x][y] == arr[pos];
        if (board[x][y] != arr[pos]) return false;
        
        visit[x][y] = true;
        pos += 1;
        for (int[] dir : direction) {
            x += dir[0];
            y += dir[1];
            if (!ifOut(x, y) && !visit[x][y])
                if (dfs(x, y)) return true;
            y -= dir[1];
            x -= dir[0];
        }
        pos -= 1;
        visit[x][y] = false;

        return false;
    }




    public boolean ifOut(int x, int y) {
        return x < 0 || y < 0 || x >= m || y >= n;
    }
}