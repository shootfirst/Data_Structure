# 数位dp

https://leetcode.cn/problems/numbers-at-most-n-given-digit-set/solution/by-lfool-epqy/

## 模板

凡是数位dp，按此模板来即可

```
private List<Integer> list = new ArrayList<>();
public void getAllNum(int n) {
    char[] s = Integer.toString(n).toCharArray();
    // 处于第 0 位的时候，选择是被限制的，只能选择不超过第 0 位的值，最高位是第0位
    traversal(s, 0, 0, true);
    // list 就是所有数的集合啦
}
// 从第 i 位开始遍历
// path 记录路径
// isLimit 如图所示，为了防止大小超过 n
private void traversal(char[] s, int i, int path, boolean isLimit) {
    // 结束条件
    if (i == s.length) {
        list.add(path);
        return ;
    }
    // 确定选择的上界
    // 如果 isLimit 为 true，那么可选择的上界不能超过该位的值；否则可以一直选择到 9
    int up = isLimit ? s[i] - '0' : 9;
    for (int d = 0; d <= up; d++) {
        // 递归遍历下一位
        // 下一位的 isLimit 确定方法：当前位被限制了，而且选择的值是上界
        // 继续按照上图，举个例子：当处于第 0 位时，isLimit 为 true，
        // 如果此时选择上界 1，那么遍历第 1 位的时候也是被限制的；
        // 但是如果此时选择的不是上界 1，那么遍历第 1 位的时候就没有被限制
        traversal(s, i + 1, path * 10 + d, isLimit && d == up);
    }
}
```





