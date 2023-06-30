class LRUCache {
    // https://leetcode.cn/problems/lru-cache/
private:
    int capacity_;
    unordered_map<int, list<pair<int, int>>::iterator> m;
    list<pair<int, int>> l;
public:
    LRUCache(int capacity) {
        capacity_ = capacity;
        m = unordered_map<int, list<pair<int, int>>::iterator>();
        l = list<pair<int, int>>();
    }
    
    int get(int key) {
        if (m.count(key) == 0) {
            return -1;
        }
        // move to head
        auto kv = *m[key];
        l.erase(m[key]);
        l.push_front(kv);
        // update 
        m[key] = l.begin();
        return kv.second;
    }
    
    void put(int key, int value) {
        if (m.count(key) == 0) { 
            // add key,value
            l.push_front({key, value});
            m[key] = l.begin();
            while (m.size() > capacity_) {
                auto kv = l.back();
                m.erase(kv.first);
                l.pop_back();
            }
        } else {
            // move to head
            auto kv = *m[key];
            l.erase(m[key]);
            l.push_front({key, value});
            // update 
            m[key] = l.begin();
        }
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */