class Solution {
    public String replaceWords(ListString dictionary, String sentence) {
        Trie root = new Trie();

        for (String s  dictionary) root.insert(s);

        String[] res = sentence.split(" ");

        for (int i = 0; i  res.length; i++) {
            if (root.startsWith(res[i]) != null) res[i] = root.startsWith(res[i]);
        }

        StringBuilder sb = new StringBuilder();

        for (String s  res) {
            sb.append(s);
            sb.append(" ");
        }

        return sb.toString().substring(0, sb.length() - 1);
    }
}

class Trie {

    private MapCharacter, Trie children;
    private boolean flag = false;

    Trie() {
        this.children = new HashMap();
    }

    void insert(String word) {
        Trie cur = this;
        int length = word.length();
        char[] char_vec = word.toCharArray();
        for (int i = 0; i  length; i++) {
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

    String startsWith(String prefix) {
        Trie cur = this;
        int length = prefix.length();
        char[] char_vec = prefix.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i  length; i++) {
            if (cur.children.get(char_vec[i]) != null) {
                if (cur.flag) return sb.toString();
                sb.append(char_vec[i]);

                cur = cur.children.get(char_vec[i]);
            } else {
                if (cur.flag) return sb.toString();
                else return null;
            }
        }

        return sb.toString();
    }
}