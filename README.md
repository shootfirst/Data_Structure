# Leetcode
记录我通过leetcode复习巩固数据结构的笔记

## Binary Search

首先为了标出二分查找重点需要注意的地方，我们先写一道例题

二分查找最简单例题：https://leetcode.cn/leetbook/read/binary-search/xexoac/

我认为一共有两个重点，这也是我写二分时稍微犹豫之处，其他地方我都是一气呵成。

+ 第一：判断条件循环退出条件

+ 第二：修改左右指针的条件以及对左右指针的修改

下面，我列出二分查找的几个模板

### 模板1

`
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
`

即上面那个例题的题解，适合










































