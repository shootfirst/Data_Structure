class Trie {
    // https://leetcode.cn/problems/implement-trie-prefix-tree/
public:
    unordered_map<char, Trie*> children;
    bool flag;

    Trie() {
        children = unordered_map<char, Trie*>();
        flag = false;
    }
    
    void insert(string word) {
        auto res = this;
        for (auto c : word) {
            if (!res->children[c]) {
                res->children[c] = new Trie;
            }
            res = res->children[c];
        }
        res->flag = true;
    }
    
    bool search(string word) {
        auto res = this;
        for (auto c : word) {
            if (!res->children[c]) {
                return false;
            }
            res = res->children[c];
        }
        return res->flag;
    }
    
    bool startsWith(string prefix) {
        auto res = this;
        for (auto c : prefix) {
            if (!res->children[c]) {
                return false;
            }
            res = res->children[c];
        }
        return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */