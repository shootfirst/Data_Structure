class Solution {
    //https://leetcode.cn/problems/minimum-genetic-mutation/
    public int minMutation(String start, String end, String[] bank) {
        Set<String> list = new HashSet();
        for (String s: bank) list.add(s);
        list.add(start);
        if (list.size() == 0 || !list.contains(end)) return -1;

        char[] ccc = new char [] {'A', 'C', 'T', 'G'};

        Set<String> visit = new HashSet();
        visit.add(start);

        Set<String> b = new HashSet();
        Set<String> e = new HashSet();
        b.add(start);
        e.add(end);

        int step = 0;


        while (!b.isEmpty() && !e.isEmpty()) {
            if (b.size() > e.size()) {
                Set<String> tmp = b;
                b = e;
                e = tmp;
            }
            Set<String> res = new HashSet();
            for (String s : b) {
                char[] arr = s.toCharArray();

                for (int k = 0; k < arr.length; k++) {
                    // 注意保存
                    char o = arr[k];
                    for (char c : ccc) {
                        arr[k] = c;
                        String ss = new String(arr);
                        if (list.contains(ss)) {
                            if (e.contains(ss)) return step + 1;
                            if (!visit.contains(ss)) {
                                visit.add(ss);
                                res.add(ss);
                            }
                        }
                    }
                    // 注意恢复
                    arr[k] = o;
                }
            }
            b = res;
            step++;
        }

        return -1;
    }
}