# Leetcode
记录我通过leetcode复习巩固数据结构的笔记。首先我在此总结几个最常见的知识：快速排序、归并排序、堆排序、kruscal、prime、dijkstra、bellman-ford、floyd、并查集、二叉树三种
迭代遍历
## Array String

数组和字符串是最基本的两个数据结构（其实还有链表，这个以后说）。下面的二分查找、区间问题、矩阵操作、双指针、滑动窗口、排序等线性表相关算法也是基于此

为何单独讨论字符串类型？

+ 字符串的基本操作对象通常是字符串整体或者其子串

+ 字符串操作比其他数据类型更复杂（例如比较、连接操作），字符串连接可能会造成底层的复制，时间复杂度很高，如java：

  - 如果你确实希望你的字符串是可变的，则可以使用 toCharArray 将其转换为字符数组
  
  - 如果你经常必须连接字符串，最好使用一些其他的数据结构，如 StringBuilder
  
  
下面的模块将是和数组相关算法的特训，二分法、双指针、滑动窗口、前缀和、排序等
  

## Binary Search

二分查找一般由三个主要部分组成：

+ 预处理 —— 如果集合未排序，则进行排序。

+ 二分查找 —— 使用循环或递归在每次比较后将查找空间划分为两半。

+ 后处理 —— 在剩余空间中确定可行的候选者。

### 模板1

#### 关键属性

+ 二分查找的最基础和最基本的形式
+ 查找条件可以在不与元素的两侧进行比较的情况下确定（或使用它周围的特定元素）
+ 不需要后处理，因为每一步中，你都在检查是否找到了元素。如果到达末尾，则知道未找到该元素

#### 区分语法

+ 初始条件：left = 0, right = length-1
+ 终止：left > right
+ 向左查找：right = mid-1
+ 向右查找：left = mid+1

### 模板2

分成两个部分：

#### 关键属性

+ 确定右边，使用左边逼近
+ 查找条件需要访问元素的直接右邻居。
+ 使用元素的右邻居来确定是否满足条件，并决定是向左还是向右。
+ 保证查找空间在每一步中至少有 2 个元素。
+ 需要进行后处理。 当你剩下 1 个元素时，循环 / 递归结束。 需要评估剩余元素是否符合条件。
 

#### 区分语法

+ 初始条件：left = 0, right = length - 1
+ 终止：left == right
+ 向左查找：right = mid
+ 向右查找：left = mid+1

#### 关键属性

+ 确定左边，使用右边逼近
+ 查找条件需要访问元素的直接左邻居。
+ 使用元素的左邻居来确定是否满足条件，并决定是向左还是向右。
+ 保证查找空间在每一步中至少有 2 个元素。
+ 需要进行后处理。 当你剩下 1 个元素时，循环 / 递归结束。 需要评估剩余元素是否符合条件。


#### 区分语法

+ 初始条件：left = 0, right = length - 1
+ 求中间值：mid = (right-left+1) / 2 + left
+ 终止：left == right
+ 向左查找：right = mid - 1
+ 向右查找：left = mid

### 模板三

模板三相当于模板二两方法的结合

关键属性

+ 搜索条件需要访问元素的直接左右邻居。
+ 使用元素的邻居来确定它是向右还是向左。
+ 保证查找空间在每个步骤中至少有 3 个元素。
+ 需要进行后处理。 当剩下 2 个元素时，循环 / 递归结束。 需要评估其余元素是否符合条件。
 
区分语法

初始条件：left = 0, right = length-1
终止：left + 1 == right
向左查找：right = mid
向右查找：left = mid

上述三个模板可以应付各种二分查找情况，可是，万一有的题目，没有明显地指出要使用二分查找，该怎么办呢？

### 难以察觉的二分法

#### 寻找重复数

https://leetcode.cn/problems/find-the-duplicate-number/

我们定义cnt[i]表示nums数组中小于等于i的数有多少个，假设我们重复的数是target，那么 [1,target-1]里的所有数满足cnt[i] == i，[target,n] 里的所有数满足icnt[i] = i + 1具有单
调性。借助此性质，类似于求诸如 1 2 3 4 6 7这样数组的断点下标，这个数组断点是6，下标为4。这样我们可以使用二分查找来写了

#### 找出第 k 小的距离对

https://leetcode.cn/problems/find-k-th-smallest-pair-distance/

先对数组进行排序，然后我们设立距离区间，left为0，right为数组最末尾数减去数组第一个数，构成距离区间[left,right]。要想求出第k小的距离，我们只需要先求出mid，注意这里使用
二分法第二模板的左固定，右逼近。在数组中使用on时间复杂度算法，即双指针求出距离对小于等于mid的个数，来和k比较，这样就可以进行二分

#### 分割数组的最大值

https://leetcode.cn/problems/split-array-largest-sum/

首先求出数组区间和最大值的最小值left与最大值right（有点绕，慢慢看哦），最小值是数组中最大值，最大值是整个数组的和。以[left,right]为区间，用二分法求出这个区间最小满足段数
为m的数即可。

#### 总结

可以看到，上面三个例题是根本没有显示提示你使用二分法，我在刷leetcode时还是专项写二分，写这些题时我知道要使用二分，可是就是不知道在哪里使用二分。如果没有提示使用二分，
可能根本是不会想到去使用二分。但是写完后，发现这三个题中的后两个（第一个纯属是强行二分），一般是涉及到求某个值，而这个值我们是可以求出这个值所在的区间，在数组中求相关要
求值，如找出第 k 小的距离对的求小于等于某个值x的距离对数量，分割数组的最大值求数组之和最大值小于等于某个值x的子数组段数。这些x都落在二分法区间，而求的过程则时间复杂度都
必须低于不使用二分法的时间复杂度，比如上两个题不使用二分法时间复杂度为n^2，使用二分法，求的过程只有on，加上外层二分法的时间复杂度为ologn，总的为onlogn。


## Sliding Window Double Pointer

这算是数组算法中一个很重要的模块，这一个模块一共有近70题，可以说量是很多的了

循环不变量」是指我们在编写代码的过程中，要一直循序不变的性质，这样的性质是根据要解决的问题，由我们自己定义的。「循环不变量」是我们写对一个问题的基础，保证了在「初始化」
「循环遍历」「结束」这三个阶段相同的性质，使得一个问题能够被正确解决。著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。不管是「滑动窗口」还是「双指针」
问题，其实都是在完成任务的过程中使用了一些变量帮助我们以线性时间复杂度完成题目交给的任务，理解它们基于对问题本身的理解，大家在做题的过程中需要体会这两种算法都是对暴力解
法的优化。理解循环不变量，利用循环不变量。

滑动窗口类题目分三步：

+ 初始化：将相关窗口变量初始化

+ 保持：保持窗口内的性质滑动下去

+ 结束：结束窗口滑动，问题得到解决

区间不同的定义决定了不同的初始化逻辑、遍历过程中的逻辑

### 固定长度滑动窗口

这一类较为简单，滑动窗口大小固定

https://leetcode.cn/problems/grumpy-bookstore-owner/

注意思维转化，有的是在两边的区间，这个时候可以转化为中间的区间

https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/

### 不定长的滑动窗口

相对于上面的定长，这个不定长滑动窗口一般是这个形式：右指针右移到刚好满足条件，然后左指针右移到刚好不满足条件，循环往复。同时可能需要数据结构来记录相关数据，如前缀和

https://leetcode.cn/problems/minimum-window-substring/

我有几个题解是错误解法，没有使用哈希表或者其他数据结构记录相关信息导致时间复杂度过大

### 计数类问题

计算数量问题往往需要使用相关数据结构，如哈希表记录相关数据

这两题诠释了滑动窗口里的变通

https://leetcode.cn/problems/subarrays-with-k-different-integers/

https://leetcode.cn/problems/number-of-subarrays-with-bounded-maximum/

### 使用数据结构维护窗口性质

主要是单调队列的使用

https://leetcode.cn/problems/sliding-window-maximum/

这个很难，以后慢慢研究

https://leetcode.cn/problems/sliding-window-median/

### 双指针

滑动窗口就是双指针的一部分，我们最需要注意的就是左右指针移动的条件和时机

https://leetcode.cn/problems/container-with-most-water/

注意后处理最后遗漏情况

https://leetcode.cn/problems/long-pressed-name/

### 总结

对于滑动窗口和双指针这一类题型，首先，滑动窗口是特殊的双指针题型，分为定长和不定长滑动窗口，前者的实现十分简单，而后者注意滑动的条件，一般是右指针滑到满足条件，然后左指针
滑到刚好不满足条件，重复即可。同时在滑动窗口中，有时候要稍微变通一下，才能更好的使用滑动窗口。同时在滑动的同时，我们有时候需要相应的数据结构来记录数据信息，如deque、二叉
搜索树、哈希表等，这样可以大大减少我们的时间复杂度。同时对于后处理也十分重要，常常因为初值的设立导致最后会有情况遗漏。

## LinkedList

和数组一样，链表也是常见的线性表

### 链表中的双指针

这里的双指针和数组的双指针会有很大的差别，主要还是快慢指针的运用

常见的三个问题：

判断链表是否有环以及环入口点

https://leetcode.cn/problems/linked-list-cycle/

https://leetcode.cn/problems/linked-list-cycle-ii/

判断两个链表是否交叉

https://leetcode.cn/problems/intersection-of-two-linked-lists/

删除倒数第N个节点

https://leetcode.cn/problems/remove-nth-node-from-end-of-list/

一般是通过设立快慢指针，快指针是慢指针速度两倍，注意null判断

### 链表中的经典问题

其实上面的题目也是经典问题，首先是各大厂最长考的反转链表，有递归和迭代法

https://leetcode.cn/problems/reverse-linked-list/solution/

移除链表元素，我在此则使用了伪头节点

https://leetcode.cn/problems/remove-linked-list-elements/

奇偶链表，注意双指针的使用

https://leetcode.cn/problems/odd-even-linked-list/

回文链表，是前面经典题目的结合，反转前一半链表和后一半对比，注意链表奇偶长度和双指针、反转链表的使用，是一个比较综合的题目

https://leetcode.cn/problems/palindrome-linked-list/

### 总结

链表中的问题，可以从上述经典问题发散，由上述经典问题组合而成，注意保存pre节点的情况，注意快慢指针，注意头节点和尾节点处理，灵活使用递归，注意null的判断


## Prefix

前缀和也是线性表中一个较为关键的算法，经常以一种优化方式出现在其他算法的环节中。

### 一维前缀和

https://leetcode.cn/problems/range-sum-query-immutable/

### 二维前缀和

几乎都是以此为模板：

https://leetcode.cn/problems/range-sum-query-2d-immutable/

### 前缀和与后缀和

和前缀和定义一样，经常前缀和和后缀和一起出现对一些问题进行优化：

https://leetcode.cn/problems/flip-string-to-monotone-increasing/

### 前缀积和前缀异或

和前缀和也是类似的

https://leetcode.cn/problems/product-of-array-except-self/

### 差分

差分和前缀和互为逆运算，前缀和可以方便查询，而一旦对原数组进行修改，就需要重新计算前缀和，因此它适用于多次查询的问题。而差分数组则恰好相反，它方便修改，但是每次查
询都需要遍历一遍差分数组来获得原数组

https://leetcode.cn/problems/car-pooling/

## Sort

十大排序算法，提供时间复杂度分类

#### on^2

冒泡排序、选择排序、插入排序

#### nlogn

希尔排序、堆排序、快速排序、归并排序

#### on

计数排序、基数排序、桶排序


## Queue Stack

栈与队列是特殊的线性表，注意队列实现栈和栈实现队列两个经典例题

## Heap

堆也是二叉树，可以分为小顶堆和大顶堆。


## Binary Tree

分类：

满二叉树、完全二叉树、二叉搜索树和平衡二叉搜索树（avl）

存储方式：

链式、顺序

### 遍历：

深度优先遍历（前序遍历、中序遍历、后续遍历）和广度优先遍历（层序遍历）

方式：迭代法使用栈和队列（前面讲过栈用于dfs，队列用于bfs），重点是迭代法

#### 前序遍历：

https://leetcode.cn/problems/binary-tree-preorder-traversal/

#### 中序遍历：

https://leetcode.cn/problems/binary-tree-inorder-traversal/

#### 后序遍历：

https://leetcode.cn/problems/binary-tree-postorder-traversal/

以上的迭代法没有统一风格，统一风格的写法见代码随想录

#### 层序遍历：

https://leetcode.cn/problems/binary-tree-level-order-traversal/

以后的问题，一定要思考如何使用二叉树的哪些遍历，递归还是非递归来解决问题！！！


### 构造二叉树：

#### 从中序与后序遍历序列构造二叉树

https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

#### 从前序与中序遍历序列构造二叉树

https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

#### 从中序与后序遍历序列构造二叉树

https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

只有前序遍历和后序遍历是不能构造二叉树的


### 二叉树经典题目：

这些经典题目都有递归和迭代解法，我写的是递归法，而迭代法我则一般指明思路，有的也写了迭代法。

对于递归法，这里注意递归三部曲：注意递归参数与返回值，注意终止条件，注意单层递归逻辑

#### 翻转二叉树：

https://leetcode.cn/problems/invert-binary-tree/

#### 对称二叉树：

https://leetcode.cn/problems/symmetric-tree/

#### 二叉树最大深度：

https://leetcode.cn/problems/maximum-depth-of-binary-tree/

#### 二叉树最小深度：

https://leetcode.cn/problems/minimum-depth-of-binary-tree/

#### 相同的树

https://leetcode.cn/problems/same-tree/

#### 完全二叉树的节点个数：

https://leetcode.cn/problems/count-complete-tree-nodes/

#### 平衡二叉树：

https://leetcode.cn/problems/balanced-binary-tree/

有些使用迭代比递归难很多，而且效率低，例如本题。

#### 合并二叉树

https://leetcode.cn/problems/merge-two-binary-trees/

#### 左叶子之和

https://leetcode.cn/problems/sum-of-left-leaves/

#### 找树左下角的值

https://leetcode.cn/problems/find-bottom-left-tree-value/

此题递归要难于迭代，注意递归法的使用细节




以上题，确定递归三部曲都是问题不大，而下面的三题，则是有明显地渗入回溯算法思想



#### 二叉树的所有路径:

https://leetcode.cn/problems/binary-tree-paths/


#### 路径总和

https://leetcode.cn/problems/path-sum/

https://leetcode.cn/problems/path-sum-ii/


#### 二叉树的最近公共祖先

https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/


### 二叉搜索树bst

下面的题目则涉及到二叉搜索树，二叉搜索树bst是特殊的二叉树，性质不多bb



#### 二叉搜索树中的搜索

https://leetcode.cn/problems/search-in-a-binary-search-tree/

#### 二叉搜索树中的插入操作

https://leetcode.cn/problems/insert-into-a-binary-search-tree/

#### 删除二叉搜索树中的节点

https://leetcode.cn/problems/delete-node-in-a-bst/



#### 二叉搜索树的最小绝对差

https://leetcode.cn/problems/minimum-absolute-difference-in-bst/

#### 二叉搜索树中的众数

https://leetcode.cn/problems/find-mode-in-binary-search-tree/

#### 将有序数组转换为二叉搜索树

https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/



#### 二叉搜索树的最近公共祖先

比对简单的二叉树找公共祖先简单的多

https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/


#### 修剪二叉搜索树

https://leetcode.cn/problems/trim-a-binary-search-tree/

#### 把二叉搜索树转换为累加树

https://leetcode.cn/problems/convert-bst-to-greater-tree/





## UnionFind

并查集这种数据结构，主要是为了解决网络中的连通性

并查集数据结构关键在于两个方法，find和union，一个是查找根节点，一个是合并。

判断两个点是否连通等效于判断两个点的根节点是否一致。合并两个时找到其中一个根节点，修改其根节点为另一个节点

两种实现：

+ quick find 所有同一个集合中都指向一个根节点，高度唯一，find时间复杂度为o1，但是合并时需要找出所有修改其为新根节点，时间复杂度on

+ quick union find时需要一直find直到找到根节点，而union则直接简单合并两个节点即可，二者时间复杂度均为oh，h为并查集高度

总体来说后者稍微高效，但是这二者最坏情况都会出现一条线，怎么在更深层次优化呢？

+ 按秩合并的并查集：优化union，通过给每个顶点记录高度，合并的时候矮的被高的合并即可。时间复杂度均为ologn

+ 路径压缩优化的并查集：优化find，每次find遍历时将遍历过路途的元素的父节点全部修改为根节点即可。时间复杂度均为ologn

将上述两者优化方法合并，时间复杂度均为αn，线性时间复杂度

https://leetcode.cn/problems/number-of-provinces/












## Graph

图，生活中最常见的数据结构，也是目前介绍过的最复杂的数据结构，其实，树也是一种特殊的图。

图可以分为有向图和无向图，加权和非加权图。

术语：顶点、边、路径、路径长度、环、负权环、连通性、度、入度、出度

### 图的存储

#### 邻接矩阵

使用二维数组来存图

#### 邻接表

在每个边处使用链表存储所有边

以上这两个是最常见的

### 和图相关的算法

#### dfs和bfs

这里先简要介绍dfs和bfs，后面还会有专题

遍历所有顶点和遍历两点间所有路径

https://leetcode.cn/problems/all-paths-from-source-to-target/

#### 最小生成树算法

什么是生成树？生成树 指的是无向图中，具有该图的全部顶点且边数最少的连通子图。最小生成树指的是加权无向图中总权重最小的生成树。注意是加权无向图！！！

##### 切分定理

切分：将图切成两个部分，称之为一个切分

横切边：如果一条边连接的两个顶点属于切分的两个部分，这个边称为横切边

切分定理：在一幅连通加权无向图中，给定任意的切分，如果有一条横切边的权值严格小于所有其他横切边，则这条边必然属于图的最小生成树中的一条边。

##### kruscal算法

思路：将所有边升序排列，取不会组成环的加入，直到凑齐n-1条边

时间复杂度：eloge 空间复杂度：v

##### prime算法

思路，将所有点分为两个不相交集合，一个是已经加入，一个是没有加入。将点加入到已加入集合的条件是已加入集合为空或者该点不在已加入集合中并且该点和已加入顶点中组成的边
是已加入集合中散发出去的边中的最小值。重复这个过程直到已加入集合中包含所有顶点为止

二者都使用的贪心思想

时间复杂度：ElogV（普通二叉堆） 空间复杂度：v

#### 单源最短路径算法

##### dijkstra算法

不能解决负权图

https://leetcode.cn/problems/network-delay-time/

##### bellman-ford算法

可以解决负权图，建立在这个定理之上：在一个有 N 个顶点的非负权环图中，两点之间的最短路径最多经过 N-1条边。

不适用于负权环图，但是可以检测负权环，即经过n-1次循环后，第n次循环还是出现距离减少，则证明有负权环

使用动态规划，从最多经过0条边到其他点的最短距离迭代到最多经历n-1条边到其他点的最短距离

https://leetcode.cn/problems/cheapest-flights-within-k-stops/

#### 拓扑排序

##### Kahn 算法

思路：首先将所有入度为0的课入队，然后将图中所有入度为队列中顶点的顶点入度减去相应的值，重复此循环直到队列为空

使用条件：

有向无环图
「图」中至少有一个顶点「入度」为 0 。如果「图」中所有顶点都有「入度」，则代表所有顶点都至少有一个前置顶点，那么这个就没有顶点可以作为「拓扑排序」的起点。

https://leetcode.cn/problems/course-schedule-ii/






## Depth First Search

在线性数据结构中，按顺序一个一个看到所有元素，成为线性遍历。但是在非线性数据结构中，元素间的组织方式变的十分复杂，就有了不同的遍历行为，常见的可以分为深度优先遍历和
广度优先遍历。这里我们探索深度优先遍历dfs。

+ 深度优先遍历，只要前面有可以走的路，就会一直向前走，直到无路可走才会返回

+ 无路可走的两种情况：遇到墙；遇到已经走过的路

+ 在无路可走的时候，我们原路返回到最近有没有走过路的路口，尝试继续没有走过的路径

在深度优先遍历的过程中，需要将当前遍历到的结点的相邻结点暂时保存起来，以便在回退的时候可以继续访问它们。遍历到的结点的顺序呈现后进先出的特点，因此深度优先遍历可
以通过栈实现。再者，深度优先遍历有明显的递归结构。我们知道支持递归实现的数据结构也是栈。因此实现深度优先遍历有以下两种方式：

+ 编写递归方法；
+ 编写栈，通过迭代的方式实现

建议采用递归


### dfs应用于树和图相关性质

对于树，最重要的是后序遍历，要仔细体会使用叶子节点传上来的信息，题目则是我们之前写过的二叉树例题，这里说两个经典类型的：二叉树公共祖先、二叉树所有路径

对于图，主要是以下

+ 获得图（树）的一些属性,如最大深度、最小深度

+ 计算检测图是否含有环图连通分量

+ 检测图中是否有环（注意有向图dfs判断是否有环）

+ 二分图检测

  - 图的深度优先遍历需要记录哪些结点是否访问过
  - 完成深度优先遍历可能还需要携带其它信息，这个问题里其它信息，就是遍历 color，表示语义是：对顶点 i 尝试染色 color
  - 注意体会递归函数的返回值对于完成一个任务的作用，这道题里递归函数的返回值是是否染色成功


+ 拓扑排序（实际上就算后序遍历，有环则直接退出）


下面的三大块主题，回溯和剪枝是一个类型，都是在抽象的空间进回溯和剪枝，而最后一个主题则是在二维平面的实际空间进行回溯和剪枝




### 回溯

回溯算法用于遍历状态空间得到问题所有解，注意是状态空间，状态空间可以抽象成画图

回溯是dfs中特有，主要是回退时对状态变量的恢复重置:

+ 引用传递的值需要恢复

+ 值传递的值，无需恢复

+ 广度优先遍历需要保存每一层所有状态，空间过于大，所以很少使用回溯，故说是dfs特有

相对于暴力搜索，回溯是有方向的遍历。

死死研究下面四个题目，体会回溯的思想！！！

#### N 皇后

最经典的回溯算法问题，仔细分析细节，后面的都是这个套路

https://leetcode.cn/problems/n-queens/

#### 数独

和上面思路一样，同样经典，但是这个是找到唯一答案后返回，所以注意二者处理的不同

https://leetcode.cn/problems/sudoku-solver/

总结：写之前，一定要根据题目意思，确定状态变量，确定终点

#### 全排列

https://leetcode.cn/problems/permutations/

#### 括号生成

https://leetcode.cn/problems/generate-parentheses/




### 剪枝

回溯算法本质上是对空间的遍历，时间复杂度过高，如果能够尽可能地提早直到当前分支不能得到结果，我们可以直接剪枝

条件通常是具体问题具体分析

#### 全排列 II

https://leetcode.cn/problems/permutations-ii/

如这个剪枝就算重复的不能算

#### 火柴拼正方形

https://leetcode.cn/problems/matchsticks-to-square/

这个剪枝则是重复的直接跳过

#### 拆分字符串使唯一子字符串的数目最大

https://leetcode.cn/problems/split-a-string-into-the-max-number-of-unique-substrings/

#### 子集 

https://leetcode.cn/problems/subsets/

https://leetcode.cn/problems/subsets-ii/

#### 活字印刷

https://leetcode.cn/problems/letter-tile-possibilities/



### 二维平面的搜索问题

#### 单词搜索

https://leetcode.cn/problems/word-search/

很经典的二维平面搜索

#### 岛屿的最大面积

https://leetcode.cn/problems/max-area-of-island/

很经典的二维平面搜索

#### 被围绕的区域

https://leetcode.cn/problems/surrounded-regions/



## BFS

特别注意：将结点添加到队列以后，一定要马上标记为「已经访问」，否则相同结点会重复入队


### bfs在树中的运用

主要是层序遍历，参考之前树的题型


### 二维平面搜索

#### 岛屿的最大面积

https://leetcode.cn/problems/max-area-of-island/

#### 太平洋大西洋水流问题

https://leetcode.cn/problems/pacific-atlantic-water-flow/


### 抽象成图论问题

有一些问题问我们最短、最少、最小，可以尝试将它们转换为求解无权图的最短路径的问题求解。

对于这一类问题，最重要的一点在于分析出这一类问题的图结构，也就是对图形问题建模。依然是要注意到这些问题的背后是一个无权图的最短路径问题，因此可以使用广度优先遍历

#### 完全平方数

https://leetcode.cn/problems/perfect-squares/

#### 零钱兑换

https://leetcode.cn/problems/coin-change/

#### 跳跃游戏 III

https://leetcode.cn/problems/jump-game-iii/



### 拓扑排序

拓扑排序有两种实现：深度优先遍历、广度优先遍历。
深度优先遍历。类似于二叉树的后续遍历得到拓扑排序，这种思路比较冷门，不要求深入学习。

事实上，拓扑排序的更经典的实现是广度优先遍历。广度优先遍历在思想层面上更简单，编码也相对容易。还有一个好处：我们一直向大家强调了只有有向无环图才存在拓扑排序：

用深度优先遍历得到拓扑序，须要在遍历的过程中检测有向图是否存在环；而应用「广度优先遍历」，我们只需要在有向图中执行一次广度优先遍历，在结束以后，就能够得到这个有向图是
不是存在环，在不存在环的时候，输出拓扑排序的结果。也就是说，广度优先遍历还可以帮助我们检测有向图是否存在环。

#### 火星词典

https://leetcode.cn/problems/alien-dictionary/



### 双向 BFS 与多源 BFS

双向广度优先遍历，分别从起始状态和目标状态开始，以交替的方式扩展每一层，当两边搜索的状态列表有交集的时候，表示搜索过程相遇，搜索终止。双向 BFS 等价于单向 BFS，但是避免
了单向 BFS 在层数很深的时候状态结点的大规模扩散。多源也是类似。

#### 单词接龙

https://leetcode.cn/problems/word-ladder/

#### 腐烂的橘子

https://leetcode.cn/problems/rotting-oranges/

#### 最小基因变化

https://leetcode.cn/problems/minimum-genetic-mutation/






## Dynamic Programming

动态规划，以前对dp怀有恐惧心理，今天我要亲手打破这恐惧

对于dp，我们按这几步来分析，无论是简单题还是困难题

+ 确定dp数组（dp table）以及下标的含义

+ 确定递推公式

+ dp数组如何初始化

+ 确定遍历顺序

+ 举例推导dp数组





























  

































































































