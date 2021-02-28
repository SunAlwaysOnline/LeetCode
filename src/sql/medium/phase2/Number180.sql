-- 180. 连续出现的数字


-- 表：Logs
--
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | id          | int     |
-- | num         | varchar |
-- +-------------+---------+
-- id 是这个表的主键。
--  
--
-- 编写一个 SQL 查询，查找所有至少连续出现三次的数字。
--
-- 返回的结果表中的数据可以按 任意顺序 排列。
--
--  
--
-- 查询结果格式如下面的例子所示：
--
--  
--
-- Logs 表：
-- +----+-----+
-- | Id | Num |
-- +----+-----+
-- | 1  | 1   |
-- | 2  | 1   |
-- | 3  | 1   |
-- | 4  | 2   |
-- | 5  | 1   |
-- | 6  | 2   |
-- | 7  | 2   |
-- +----+-----+
--
-- Result 表：
-- +-----------------+
-- | ConsecutiveNums |
-- +-----------------+
-- | 1               |
-- +-----------------+
-- 1 是唯一连续出现至少三次的数字。
--
-- 来源：力扣（LeetCode）
-- 链接：https://leetcode-cn.com/problems/consecutive-numbers
-- 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



SELECT DISTINCT
	( l1.Num ) AS ConsecutiveNums
FROM
	LOGS AS l1,
	LOGS AS l2,
	LOGS AS l3
WHERE
	l1.id = l2.id - 1
	AND l2.id = l3.id - 1
	AND l1.Num = l2.Num
	AND l2.Num = l3.Num;