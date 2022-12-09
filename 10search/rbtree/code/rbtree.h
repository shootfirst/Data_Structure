# include <iostream>

using namespace std;

enum RBTColor {RED, BLACK};

template <Class T>

class RBTree {
    class RBTNode {
        public:
            RBTColor color_;
            T key_;
            RBTNode *left_;
            RBTNode *right_;
            RBTNode *parent_;

            RBTNode (T value, RBTColor color, RBTNode *p, RBTNode *l, RBTNode *r):
                key_(value), color_(c), parent_(p), left_(l), right_(r) {}
    };

    private:
        RBTNode<T> *root_;

    public:
        RBTree() { root = nullptr; };
        ~RBTree() {};

        RBTNode<T> find(T key);
        void insert(T key);
        void delete(T key);

    private:
        void left_rotate(RBTNode<T>* &root, RBTNode<T> *x);
        void right_rotate(RBTNode<T>* &root, RBTNode<T> *y);
        RBTNode<T> find(RBTNode<T>* root, T key);
        void insert(RBTNode<T>* &root, RBTNode<T> *node);
        void insert_fix(RBTNode<T>* &root, RBTNode<T> *node);
        void delete(RBTNode<T>* &root, RBTNode<T> *node);
        void delete_fix(RBTNode<T>* &root, RBTNode<T> *node, RBTNode<T> *parent);

};


