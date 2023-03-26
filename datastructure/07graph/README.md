# graph



## 术语

加权图、有向图、无向图、顶点、边、路径、路径长度、环、负权环、连通性、度、入度、出度



## 表示方法

+ 邻接矩阵

+ 邻接表



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

不能重复行走

[售货员的难题](./code/售货员的难题.cpp)

可以重复行走

将邻接表换成弗洛伊德矩阵



