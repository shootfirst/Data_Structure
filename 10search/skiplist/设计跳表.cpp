class Skiplist {
public:
    //跳表最大高度默认为8，redis中为32，太大会浪费空间
    static const int level_ = 8;

    //跳表节点
    struct Node {
        int val_;
        vector<Node*> next_;

        Node(int val) : val_(val) {
            next_.resize(level_, NULL);
        }
    };

    Node *head;
    Skiplist() {
        head = new Node(-1);
    }

    ~Skiplist() {
        delete head;
    }

    void find(int target, vector<Node*>& pre) {
        auto p = head;
        for (int i = level_ - 1; i >= 0; i--) {
            while (p->next_[i] && p->next_[i]->val_ < target) p = p->next_[i];
            pre[i] = p;
        }
    }
    
    bool search(int target) {
        vector<Node*> pre(level_);
        find(target, pre);
        auto p = pre[0];
        return p->next_[0] && p->next_[0]->val_ == target;
    }
    
    void add(int num) {
        vector<Node*> pre(level_);
        find(num, pre);

        auto new_node = new Node(num);
        for (int i = 0; i < level_; i++) {
            // 类似普通链表插入
            new_node->next_[i] = pre[i]->next_[i];
            pre[i]->next_[i] = new_node;
            // 50%概率继续插入
            if (rand() % 2) break;
        }
        
    }
    
    bool erase(int num) {
        vector<Node*> pre(level_);
        find(num, pre);

        // 判断要删除节点是否存在，不存在则直接返回错误
        auto to_delete = pre[0]->next_[0];
        if (!to_delete || to_delete->val_ != num) return false;

        for (int i = 0; i < level_; i++) {
            //若该层没有，则直接结束
            if(!pre[i]->next_[i] || pre[i]->next_[i]->val_ != num) return true;
            // 类似普通链表删除
            pre[i]->next_[i] = pre[i]->next_[i]->next_[i];
        }
        delete to_delete;
        return true;
    }
};

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist* obj = new Skiplist();
 * bool param_1 = obj->search(target);
 * obj->add(num);
 * bool param_3 = obj->erase(num);
 */