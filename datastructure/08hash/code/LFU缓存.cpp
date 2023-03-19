class LFUCache {
    using KV = pair<int, int>;
    // 使用桶维护访问次数和kv对的关系,K key, V cnt
    vector<list<KV>> cnt_list_;
    // K value
    using MV = pair<int, list<KV>::iterator>;
    // K key
    unordered_map<int, MV> m_;
    int capacity_;

public:
    LFUCache(int capacity) {
        capacity_ = capacity;
    }
    
    int get(int key) {
        if (m_.count(key) == 0) {
            return -1;
        }
        int ans = m_[key].first;
        auto key_node = m_[key].second;
        int cnt = key_node->second;
        if (cnt_list_.size() == cnt + 1) {
            cnt_list_.push_back({});
        }
        auto val = *key_node;
        val.second++;

        cnt_list_[cnt].erase(key_node);
        cnt_list_[cnt + 1].push_front(val);
        m_[key].second = cnt_list_[cnt + 1].begin();
        return ans;
    }
    
    void put(int key, int value) {
        if (capacity_ == 0) {
            return;
        }
        if (m_.count(key) != 0) {
            m_[key].first = value;
            get(key);
            return;
        } 
        if (m_.size() == capacity_) {
            int cnt = 0;
            while (cnt < cnt_list_.size() && cnt_list_[cnt].empty()) {
                cnt++;
            }
            auto removed = --cnt_list_[cnt].end();
            int remove_key = removed->first;
            
            m_.erase(remove_key);
            cnt_list_[cnt].pop_back();
        }
        // insert
        if(cnt_list_.empty())
            cnt_list_.push_back({});
        cnt_list_[0].push_front({key, 0});
        m_[key] = {value, cnt_list_[0].begin()};
    }
};

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache* obj = new LFUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */