class Solution {

    int ans = 0;
    char [] arr;
    int [] visit;
    public int numTilePossibilities(String tiles) {
        arr = tiles.toCharArray();
        Arrays.sort(arr);
        visit = new int[arr.length];
        LinkedList<Character> path = new LinkedList();
        for (int i = 0; i < arr.length; i++)
            dfs(i, path);
        return ans;
    }

    public void dfs(int start, LinkedList<Character> path) {
        if (visit[start] == 1) return;
        // 剪枝
        if (start > 0 && visit[start - 1] == 0 && arr[start - 1] == arr[start]) return;
        path.add(arr[start]);
        ans++;
        visit[start] = 1;
        for (int i = 0; i < arr.length; i++)
            dfs(i, path);
        visit[start] = 0;
        path.removeLast();


    }

}