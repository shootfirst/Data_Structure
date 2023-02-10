class Leaderboard {
private:
    unordered_map<int, int> m_;
    multiset<int> t_;
public:
    Leaderboard() {
        m_ = unordered_map<int, int>();
        t_ = multiset<int>();
    }
    
    void addScore(int playerId, int score) {
        if (m_.count(playerId) == 0) {
            m_[playerId] = score;
        } else {
            auto it = t_.lower_bound(m_[playerId]);
            t_.erase(it);
            m_[playerId] += score;
        }
        t_.insert(m_[playerId]);
    }
    
    int top(int K) {
        int ans = 0;
        int i = 0;
        for (auto it = t_.rbegin(); i < K; i++, it++) {
            ans += *it;
        }
        return ans;
    }
    
    void reset(int playerId) {
        auto it = t_.lower_bound(m_[playerId]);
        t_.erase(it);
        m_.erase(playerId);
    }
};

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard* obj = new Leaderboard();
 * obj->addScore(playerId,score);
 * int param_2 = obj->top(K);
 * obj->reset(playerId);
 */