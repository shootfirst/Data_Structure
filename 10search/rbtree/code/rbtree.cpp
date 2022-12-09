include "rbtree.h"

template <Class T>

RBTNode<T>* RBTree<T>::find(T key) {
    return find(root_, key);
}

RBTNode<T>* RBTree<T>::find(RBTNode<T>* root, T key) {
    if (root == nullptr || x->key_ = key) return root;
    else if (key < x->key_) return find(x->left_, key);
    else return find(x->right_, key);
}

void lRBTree<T>::left_rotate(RBTNode<T>* &root, RBTNode<T> *x) {
    auto y = x->right_;

    x->right_ = y->left_;
    if (y->left_ != nullptr) y->left_->parent_ = x;

    y->parent_ = x->parent_;

    if (y->parent_ == nullptr) root_ = y;
    else {
        if (x->parent_->left_ == x) {
            x->parent_->left_ = y;
        } else {
            x->parent_->right_ = y;
        }
    }

    y->left_ = x;
    x->parent_ = y;
}


void RBTree<T>::right_rotate(RBTNode<T>* &root, RBTNode<T> *y) {
    auto x = y->left_;

    y->left_ = x->right_;
    if (x->right_ != nullptr) x->right_->parent_ = y;

    x->parent_ = y->parent_;

    if (x->parent_ == nullptr) root_ = x;
    else {
        if (y->parent_->left_ == y) {
            y->parent_->left_ = x;
        } else {
            y->parent_->right_ = x;
        }
    }

    x->right_ = y;
    y->parent_ = x;
}

void RBTree<T>::insert(T key) {
    insert(root, new RBTNode<T>(key, BLACK, nullptr, nullptr, nullptr));
}

void RBTree<T>::insert(RBTNode<T>* &root, RBTNode<T> *node) {
    RBTNode<T> *y = nullptr;
    RBTNode<T> *x = root;

    while ( x != nullptr) {
        y = x;
        if (node->key < x->key) x = x->left;
        else x = x->right;
    }

    node->parent_ = y;
    if (y != nullptr) {
        if (node->key_ < y->key_) y->left_ = node;
        else y->right_ = node;
    }
    else root_ = node;

    // 新插入节点都为红色
    node->color = RED;
}

void RBTree<T>::insert_fix(RBTNode<T>* &root, RBTNode<T> *node) {
    RBTNode<T> *parent, *gparent;

    while ((parent = node->parent) && parent->color_ == RED) {
        gparent = parent->parent;

        // 父亲是祖父的左孩子
        if (parent == gparent->left_) {

            // case1: 叔叔是红色
            {
                RBTNode<T> *uncle = gparent->right_;
                if (uncle && uncle->color_ == RED) {
                    uncle->color_ = BLACK;
                    parent->color_ = BLACK;
                    gparent->color_ = RED;
                    node = gparent;
                    continue;
                }
            }

            // case2: 叔叔是黑色，当前节点是右孩子，即，祖父孙三节点不在一条线
            if (parent_->right_ = node) {
                // 拉到一条线
                RBTNode<T> *tmp;
                left_rotate(root, parent);
                tmp = parent;
                parent = node;
                node = tmp;
            }

            // case3: 叔叔是黑色，当前节点是左孩子，即，祖父孙三节点在一条线
            parent->color_ = BLACK;
            gparent->color_ = RED;
            right_rotate(root_, gparent);

        // 父亲是右孩子
        } else {
            // case1: 叔叔是红色
            {
                RBTNode<T> *uncle = gparent->left_;
                if (uncle && uncle->color_ == RED) {
                    uncle->color_ = BLACK;
                    parent->color_ = BLACK;
                    gparent->color_ = RED;
                    node = gparent;
                    continue;
                }
            }

            // case2: 叔叔是黑色，当前节点是左孩子，即，祖父孙三节点不在一条线
            if (parent_->right_ = node) {
                // 拉到一条线
                RBTNode<T> *tmp;
                right_rotate(root, parent);
                tmp = parent;
                parent = node;
                node = tmp;
            }

            // case3: 叔叔是黑色，当前节点是左孩子，即，祖父孙三节点在一条线
            parent->color_ = BLACK;
            gparent->color_ = RED;
            left_rotate(root_, gparent);
        }
    }

    root_->color_ = BLACK;
}