# graph
## 最短路径算法

### dijkstra

```
void dijkstra() {
    for (int i = 1; i < n; i++) {
        int min = get_not_visit_and_min();
        for (int j = 0; j < n; j++) {
            des[j] = min(des[j], des[min] + matrix[min][j]);
        }
    }
}
```

[网络延迟时间](./code/网络延迟时间.java)

### floyd

```
void floyd() {
    for (int k = 0; k < n; k++) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = Math.min(a[i][j], a[i][k] + a[k][j]);
            }
        }
    }
}
```

### bellman-ford

```
void bellman_ford() {
    for (int k = 1; k <= n; k++) {
        for (auto &path : paths) {
            dp[k][path[1]] = min(dp[k][path[1]], dp[k - 1][path[0]] + path[2]);
        }
    }
}
```

[K站中转内最便宜的航班](./code/K站中转内最便宜的航班.java)



## 最小生成树算法

### kruscal

```
void kruscal() {
    add_edge_to_heap();
    while !set_full() {
        Edge e = pop();
        if !in_same_set {
            add_to_set()
        }
    }
}
```

[连接所有点的最小费用](./code/连接所有点的最小费用.java)



## TSL旅行商问题

### 不能重复行走

[售货员的难题](./code/售货员的难题.cpp)

### 可以重复行走

[访问所有节点的最短路径](./code/访问所有节点的最短路径.cpp)



## 树

树是特殊的图

### 树上dfs

类似于二叉树上的dfs与回溯

[收集树上所有苹果的最少时间](./code/收集树上所有苹果的最少时间.cpp)

### 换根dp

输入一个用邻接表表示的树，没有固定根节点，需要已每一个节点作为根来遍历，换根的时候，注意只需要对两个节点进行修改即可

[树中距离之和](./code/树中距离之和.cpp)



## 拓扑排序

### 树中拓扑排序

把树看成：根是中心，其他子节点向外围扩散！

[收集树中金币](./code/收集树中金币.cpp)

### DAG中拓扑排序

[平行课程](./code/平行课程.java)

### 拓扑排序（DAG）dp

注意汇集前置所有节点的信息再做决定，这是拓扑排序（DAG）上动态规划的关键

[并行课程III](./code/并行课程III.cpp)






