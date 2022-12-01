class Trie {

    private Map<Character, Trie> children;
    private boolean flag = false;

    Trie() {
        this.children = new HashMap();
    }

    void insert(String word) {
        Trie cur = this;
        int length = word.length();
        char[] char_vec = word.toCharArray();
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
        cur.flag = true;
    }

    boolean search(String word) {
        Trie cur = this;
        int length = word.length();
        char[] char_vec = word.toCharArray();

        for (int i = 0; i < length; i++) {
            if (cur.children.get(char_vec[i]) != null) {
                cur = cur.children.get(char_vec[i]);
            } else {
                return false;
            }
        }

        return cur.flag;
    }

    boolean startsWith(String prefix) {
        Trie cur = this;
        int length = prefix.length();
        char[] char_vec = prefix.toCharArray();

        for (int i = 0; i < length; i++) {
            if (cur.children.get(char_vec[i]) != null) {
                cur = cur.children.get(char_vec[i]);
            } else {
                return false;
            }
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */