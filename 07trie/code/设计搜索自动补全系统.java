class AutocompleteSystem {

    Trie root;
    StringBuilder cache;


    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new Trie();
        cache = new StringBuilder();
        for (int i = 0; i < times.length; i++) root.insert(sentences[i], times[i]);
    }

    public List<String> input(char c) {
        if (c == '#') {
            root.insert(cache.toString(), 1);
            cache = new StringBuilder();
            return new LinkedList();
        } else {
            cache.append(c);
            return root.get(cache.toString());
        }
    }
}

class Trie {
    Map<Character, Trie> children;
    boolean flag;
    int cnt;

    public Trie() {
        this.children = new HashMap();
        this.flag = false;
        this.cnt = 0;
    }

    public void insert(String key, int val) {
        Trie cur = this;
        int length = key.length();
        char[] char_vec = key.toCharArray();
        for (int i = 0; i < length; i++) {
            Trie child;
            if (cur.children.get(char_vec[i]) == null) {
                child = new Trie();
                cur.children.put(char_vec[i], child);
            } else {
                child = cur.children.get(char_vec[i]);
            }
            cur = child;
        }
        cur.cnt += val;
        cur.flag = true;
    }

    public List<String> get(String prefix) {
        Trie cur = this;
        int length = prefix.length();
        char[] char_vec = prefix.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            if (cur.children.get(char_vec[i]) != null) {
                cur = cur.children.get(char_vec[i]);
                sb.append(char_vec[i]);
            } else {
                return new LinkedList();
            }
        }

        LinkedList<String> res = new LinkedList();
        LinkedList<Integer> time = new LinkedList();
        getAllString(cur, res, sb, time);

        return quickSort(res, time);
    }

    public void getAllString
            (Trie cur, LinkedList<String> res, StringBuilder sb, LinkedList<Integer> time) {
        if (cur.flag) {
            res.add(sb.toString());
            time.add(cur.cnt);
        }
        Iterator < Character > iterator = cur.children.keySet().iterator();
        while (iterator.hasNext()) {
            Character key = iterator.next();
            sb.append(key);
            getAllString(cur.children.get(key), res, sb, time);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public LinkedList<String> quickSort
            (LinkedList<String> res, LinkedList<Integer> time) {
        String[] sarr = new String[res.size()];
        res.toArray(sarr);
        Integer[] iarr = new Integer[time.size()];
        time.toArray(iarr);

        sort(sarr, iarr, 0, time.size() - 1);
        LinkedList<String> ans = new LinkedList();
        for (int i = 1; i <= 3 && sarr.length - i >= 0; i++) ans.add(sarr[sarr.length - i]);


        return ans;
    }

    public void sort(String[] sarr, Integer[] iarr, int start, int end) {
        if (start >= end) return;
        int mid = partition(sarr, iarr, start, end);

        if (mid <= iarr.length - 3) {
            sort(sarr, iarr, mid + 1, end);
        } else {
            sort(sarr, iarr, mid + 1, end);
            sort(sarr, iarr, start, mid - 1);
        }
    }

    public int partition(String[] sarr, Integer[] iarr, int start, int end) {
        int left = start + 1, right = end;
        while (left < right) {
            while (left < right &&
                    (iarr[left] < iarr[start] || (iarr[left] == iarr[start] &&
                            sarr[left].compareTo(sarr[start]) >= 0))
            ) left++;
            while (right > left &&
                    (iarr[right] > iarr[start] || (iarr[right] == iarr[start] &&
                            sarr[right].compareTo(sarr[start]) <= 0))
            ) right--;
            if (left < right) {
                swap(left, right, sarr, iarr);
                left++;
                right--;
            }
        }
        if (right == left &&
                (iarr[right] > iarr[start] || (iarr[right] == iarr[start] &&
                        sarr[right].compareTo(sarr[start]) <= 0))
        ) right--;
        swap(start, right, sarr, iarr);
        return right;
    }

    public void swap(int a, int b, String[] sarr, Integer[] iarr) {
        int tmpi = iarr[a];
        iarr[a] = iarr[b];
        iarr[b] = tmpi;
        String tmps = sarr[a];
        sarr[a] = sarr[b];
        sarr[b] = tmps;
    }

}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */