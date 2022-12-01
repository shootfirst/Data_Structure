class WordDictionary {

    Map<Character, WordDictionary> children;
    private boolean flag = false;

    public WordDictionary() {
        this.children = new HashMap();
    }

    public void addWord(String word) {
        WordDictionary cur = this;
        int length = word.length();
        char[] char_vec = word.toCharArray();
        for (int i = 0; i < length; i++) {
            WordDictionary child;
            if (cur.children.get(char_vec[i]) == null) {
                child = new WordDictionary();
                cur.children.put(char_vec[i], child);
            } else {
                child = cur.children.get(char_vec[i]);
            }
            cur = child;
        }
        cur.flag = true;
    }

    public boolean search_recursion(String word, int i, WordDictionary cur) {
        if (i == word.length() && cur.flag) return true;
        else if (i == word.length() && !cur.flag) return false;
        else if (cur.children.get(word.charAt(i)) != null) {
            cur = cur.children.get(word.charAt(i));
            return search_recursion(word, i + 1, cur);
        } else if (word.charAt(i) == '.') {
            Iterator < Character > iterator = cur.children.keySet().iterator();
            while (iterator.hasNext()) {
                Character key = iterator.next();
                if(search_recursion(word, i + 1, cur.children.get(key))) return true;
            }
            return false;
        }
        else {
            return false;
        }
    }

    public boolean search(String word) {
        return search_recursion(word, 0, this);
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
