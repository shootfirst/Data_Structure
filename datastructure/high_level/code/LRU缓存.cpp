class LRUCache {
    // https://leetcode.cn/problems/lru-cache/
public:
    struct Node {
        int key;
        int value;
        Node* prev;
        Node* next;

        Node(int k, int v, Node* p, Node* n) {
            key = k;
            value = v;
            prev = p;
            next = n;
        }
    };

    Node* head;
    Node* tail;
    int cap;
    int len = 0;
    unordered_map<int, Node*> hashtable;

    LRUCache(int capacity) {
        cap = capacity;
        head = new Node(-1, -1, nullptr, nullptr);
        tail = new Node(-1, -1, nullptr, nullptr);
        tail->prev = head;
        head->next = tail;
    }
    
    int get(int key) {
        if (hashtable.count(key)) {
            hashtable[key]->prev->next = hashtable[key]->next;
            hashtable[key]->next->prev = hashtable[key]->prev;

            hashtable[key]->prev = head;
            hashtable[key]->next = head->next;
            head->next->prev = hashtable[key];
            head->next = hashtable[key];
           
            return hashtable[key]->value;
        }
        return -1;
    }
    
    void put(int key, int value) {
        if (get(key) != -1) {
            hashtable[key]->value = value;
            return;
        }

        auto node = new Node(key, value, nullptr, nullptr);
        len++;
        while (len > cap) {
            auto to_del = tail->prev;
            tail->prev = tail->prev->prev;
            tail->prev->next = tail;
            hashtable.erase(to_del->key);
            delete to_del;
            len--;
        }

        hashtable[key] = node;
        node->prev = head;
        node->next = head->next;
        head->next->prev = node;
        head->next = node;

    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */