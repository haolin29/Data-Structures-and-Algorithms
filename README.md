# Data Structures and Algorithms

## 九章Ladder

### Binary Search

Given an sorted array, find the first/last/any position of target in array.

如果需要优化O(n)的时间复杂度，那么只能是O(log n)的二分法。

核心要点：一次loop，丢掉一半的数

最后停下的两个指针的处理

### Binary Tree

Outline

1. Binary Tree DFS Traversal
   - preorder/inorder/postorder
   - divide and conquer
2. BFS traversal
3. BST

postorder Traversal using stack (left before than right).


分治思想来解决问题。

往下传递的参数是什么？返回的参数又是什么？

### Dynamic Programming

凡是做二维数组的动态规划就初始化第0行和第0列。


几种类型的动态规划：

坐标型

切割型

区间型


### Arrays

Sorted Array
Partition Array





### Search

BFS

Queue(分层的话 3层循环， 不分层两层循环) + Hashmap(避免重复访问) 

适用范围：根据一个点找到所有的点，找到最短的距离

时间复杂度： O(m)， m是边数，每个点只遍历一次

Word Ladder（隐式图搜索）



DFS

 (Backtracking：想好helper的定义是什么)

找出所有的方案

经典问题： Subsets（O(2^n)），Permutation(On!)



时间复杂度怎么计算

$方案数 \times 构造每个方案的代价$
