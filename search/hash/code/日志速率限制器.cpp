class Logger {
    struct Record {
        int time_;
        string content_;
        Record(string& content, int time) : time_(time), content_(content) {};
    };
private:
    unordered_set<string> m_;
    queue<Record> q_;

public:
    Logger() {
        q_ = queue<Record>();
        m_ = unordered_set<string>();
    }
    
    bool shouldPrintMessage(int timestamp, string message) {
        while (!q_.empty() && q_.front().time_ <= timestamp - 10) {
            m_.erase(q_.front().content_);
            q_.pop();
        }

        if (m_.count(message) == 0) {
            m_.insert(message);
            q_.push(Record(message, timestamp));
            return true;
        }
        return false;
    }
};

/**
 * Your Logger object will be instantiated and called as such:
 * Logger* obj = new Logger();
 * bool param_1 = obj->shouldPrintMessage(timestamp,message);
 */