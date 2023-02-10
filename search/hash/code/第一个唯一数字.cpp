class FirstUnique {
private:
    // 维护出现一次的value和it的映射关系
    unordered_map<int, list<int>::iterator> m_;
    // 出现超过一次的key均被加入进来
    unordered_set<int> m2_;
    // 出现一次的key
    list<int> l_;
public:
    FirstUnique(vector<int>& nums) {
        m_ = unordered_map<int, list<int>::iterator>();
        m2_ = unordered_set<int>();
        l_ = list<int>();
        for (auto num : nums) {
            add(num);
        }
    }
    
    int showFirstUnique() {
        if (l_.empty()) {
            return -1;
        }
        return l_.front();
    }
    
    void add(int value) {
        if (m_.count(value) != 0) {
            // 出现一次
            auto it = m_[value];
            m_.erase(value);
            l_.erase(it);
            // 加入到出现超过一次的集合m
            m2_.insert(value);
        } else if (m2_.count(value) != 0) {
            // 出现超过一次，直接返回
            return;
        } else {
            // 没有出现过，加入
            l_.push_back(value);
            m_[value] = --l_.end();
        }
    }
};

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique* obj = new FirstUnique(nums);
 * int param_1 = obj->showFirstUnique();
 * obj->add(value);
 */