# 大数据类型

主要是哈希表、trie树、堆、位图的灵活使用和分治思想的运用。

参考链接：https://blog.51cto.com/u_8887390/3308860

+ 海量日志数据，提取出某日访问百度次数最多的那个IP

+ 搜索引擎会通过日志文件把用户每次检索使用的所有检索串都记录下来，每个查询串的长度为1-255字节。假设目前有一千万个记录（这些查询串的重复度比较高，虽然总数是1千万，但如果除去
  复后，不超过3百万个。一个查询串的重复度越高，说明查询它的用户越多，也就是越热门。）请你统计最热门的10个查询串，要求使用的内存不能超过1G
  
+ 有10个文件，每个文件1G，每个文件的每一行存放的都是用户的query，每个文件的query都可能重复。要求你按照query的频度排序

+ 给定a、b两个文件，各存放50亿个url，每个url各占64字节，内存限制是4G，让你找出a、b文件共同的url

+ 在2.5亿个整数中找出不重复的整数，注，内存不足以容纳这2.5亿个整数

+ 给40亿个不重复的unsigned int的整数，没排过序的，然后再给一个数，如何快速判断这个数是否在那40亿个数当中（二分法。妙）