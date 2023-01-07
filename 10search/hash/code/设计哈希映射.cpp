class MyHashMap {
private:
    // 使用开放定址法
    const int N = 20011;
    using KV = pair<int, int>;
    vector<KV> hash_vec;

    int hash(int key) {
        return key % N;
    }
public:

    MyHashMap() {
        hash_vec = vector(N, KV(-1, -1));
    }
    
    void put(int key, int value) {
        int index = hash(key);
        // 如果数组满了会卡里面死循环
        while (hash_vec[index].first != -1 && hash_vec[index].first != key) {
            index = (index + 1) % N;
        }
        hash_vec[index] = {key, value};
    }
    
    int get(int key) {
        int index = hash(key);
        // 如果数组满了会卡里面死循环
        while (hash_vec[index].first != -1 && hash_vec[index].first != key) {
            index = (index + 1) % N;
        }
        return hash_vec[index].second;
    }
    
    void remove(int key) {
        int index = hash(key);
        // 如果数组满了会卡里面死循环
        while (hash_vec[index].first != -1 && hash_vec[index].first != key) {
            index = (index + 1) % N;
        }
        // 线性探测法只能使用置位删除，并且需要和空位置区分开
        hash_vec[index] = {-2, -1};
    }
};

class MyHashMap {
private:
    // 使用拉链法
    const int N = 20011;
    using KV = pair<int, int>;
    vector<list<KV>> hash_vec;

    int hash(int key) {
        return key % N;
    }
public:

    MyHashMap() {
        hash_vec = vector(N, list<KV>());
    }
    
    void put(int key, int value) {
        int index = hash(key);
        for (auto it = hash_vec[index].begin(); it != hash_vec[index].end(); it++) {
            if (it->first == key) {
                it->second = value;
                return;
            }
        }
        hash_vec[index].push_front({key, value});
    }
    
    int get(int key) {
        int index = hash(key);
        for (auto it = hash_vec[index].begin(); it != hash_vec[index].end(); it++) {
            if (it->first == key) {
                return it->second;
            }
        }
        return -1;
    }
    
    void remove(int key) {
        int index = hash(key);
        for (auto it = hash_vec[index].begin(); it != hash_vec[index].end(); it++) {
            if (it->first == key) {
                hash_vec[index].erase(it);
                return;
            }
        }
        return;
    }
};


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */