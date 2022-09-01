# Leetcode
记录我通过leetcode复习巩固数据结构的笔记

## Binary Search

二分查找一般由三个主要部分组成：

+ 预处理 —— 如果集合未排序，则进行排序。

+ 二分查找 —— 使用循环或递归在每次比较后将查找空间划分为两半。

+ 后处理 —— 在剩余空间中确定可行的候选者。

### 模板1

int binarySearch(int[] nums, int target){

  if(nums == null || nums.length == 0)
  
    return -1;

  int left = 0, right = nums.length - 1;
  
  while(left <= right){
  
    // Prevent (left + right) overflow
    
    int mid = left + (right - left) / 2;
    
    if(nums[mid] == target){ return mid; }
    
    else if(nums[mid] < target) { left = mid + 1; }
    
    else { right = mid - 1; }
    
  }

  // End Condition: left > right
  
  return -1;
  
}

例题：https://leetcode.cn/leetbook/read/binary-search/xexoac/

关键属性

+ 二分查找的最基础和最基本的形式。
+ 查找条件可以在不与元素的两侧进行比较的情况下确定（或使用它周围的特定元素）。
+ 不需要后处理，因为每一步中，你都在检查是否找到了元素。如果到达末尾，则知道未找到该元素。

区分语法

+ 初始条件：left = 0, right = length-1
+ 终止：left > right
+ 向左查找：right = mid-1
+ 向右查找：left = mid+1













































