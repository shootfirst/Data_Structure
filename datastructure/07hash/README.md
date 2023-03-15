# 哈希表

这里将会介绍哈希表数据结构，同时会介绍哈希算法思想的运用

哈希表是一种查找表，一般由哈希函数，数组和链表共同实现（java中还会有红黑树）

[哈希表的设计](./code/设计哈希映射.cpp)


## 哈希冲突解决方法

+ 闭散列（开放定址法）

+ 开散列（拉链法）


## 哈希表与其他数据结构结合

### LRU与LFU

+ [带更新顺序的字典](./code/LRU缓存.cpp)

+ [带频率顺序的字典](./code/LFU缓存.cpp)
