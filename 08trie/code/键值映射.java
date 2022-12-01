class MapSum {

    class Trie {
        private Map<Character, Trie> children;
        private boolean flag = false;
        private int cnt = 0;

        public Trie() {
            this.children = new HashMap();
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
                cur.cnt += val;
            }
            cur.flag = true;
        }

        public void delete(String key, int val) {
            Trie cur = this;
            int length = key.length();
            char[] char_vec = key.toCharArray();
            for (int i = 0; i < length; i++) {
                Trie child;
                if (cur.children.get(char_vec[i]) == null) {
                    return;
                } else {
                    child = cur.children.get(char_vec[i]);
                    child.cnt -= val;
                }
                cur = child;
            }
            cur.flag = true;
        }

        public int sum(String prefix) {
            Trie cur = this;
            int length = prefix.length();
            char[] char_vec = prefix.toCharArray();

            for (int i = 0; i < length; i++) {
                if (cur.children.get(char_vec[i]) != null) {
                    cur = cur.children.get(char_vec[i]);
                } else {
                    return 0;
                }
            }

            return cur.cnt;
        }
    }

    private Map<String, Integer> strMap;
    private Trie root;

    public MapSum() {
        this.strMap = new HashMap();
        this.root = new Trie();
    }



    public void insert(String key, int val) {
        if (strMap.get(key) != null) {
            System.out.println((Integer)strMap.get(key));
            root.delete(key, (Integer)strMap.get(key));
        }
        root.insert(key, val);
        strMap.put(key, val);
    }

    public int sum(String prefix) {
        return root.sum(prefix);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */