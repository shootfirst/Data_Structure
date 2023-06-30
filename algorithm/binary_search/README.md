# binary search

二分查找，分为三个模板：`精确查找` `查找左边界` `查找右边界`

精确查找:
```
mid = (left + right) / 2
小于：left = mid + 1
大于：right = mid - 1
跳出循环：left > mid
```

左边界：
```
mid = (left + right) / 2
小于：left = mid + 1
大于：right = mid（可能是答案，不能冒进）
跳出循环：left == right
```

右边界
```
mid = (left + right + 1) / 2
小于：left = mid（可能是答案）
大于：right = mid - 1
跳出循环：left == right
```

## 明确二分

[寻找旋转排序数组中的最小值II](./code/寻找旋转排序数组中的最小值II.java)

## 二分查找求最值

[分割数组的最大值](./code/分割数组的最大值.java)
