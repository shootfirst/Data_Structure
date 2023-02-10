class SnapshotArray {
private:
    int id_;
    unordered_map<int, map<int, int>> data_;
public:
    SnapshotArray(int length) {
        id_ = 0;
    }
    
    void set(int index, int val) {
        data_[index][id_] = val;
    }
    
    int snap() {
        return id_++;
    }
    
    int get(int index, int snap_id) {
        auto it = data_[index].upper_bound(snap_id);
        if (it == data_[index].begin()) {
            return 0;
        }
        it--;
        return it->second;
    }
};

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray* obj = new SnapshotArray(length);
 * obj->set(index,val);
 * int param_2 = obj->snap();
 * int param_3 = obj->get(index,snap_id);
 */