-- 1285. 找到连续区间的开始和结束数字


-- 表：Logs
--
-- +---------------+---------+
-- | Column Name   | Type    |
-- +---------------+---------+
-- | log_id        | int     |
-- +---------------+---------+
-- id 是上表的主键。
-- 上表的每一行包含日志表中的一个 ID。
--  
--
-- 后来一些 ID 从 Logs 表中删除。编写一个 SQL 查询得到 Logs 表中的连续区间的开始数字和结束数字。
--
-- 将查询表按照 start_id 排序。
--
-- 查询结果格式如下面的例子：
--
-- Logs 表：
-- +------------+
-- | log_id     |
-- +------------+
-- | 1          |
-- | 2          |
-- | 3          |
-- | 7          |
-- | 8          |
-- | 10         |
-- +------------+
--
-- 结果表：
-- +------------+--------------+
-- | start_id   | end_id       |
-- +------------+--------------+
-- | 1          | 3            |
-- | 7          | 8            |
-- | 10         | 10           |
-- +------------+--------------+
-- 结果表应包含 Logs 表中的所有区间。
-- 从 1 到 3 在表中。
-- 从 4 到 6 不在表中。
-- 从 7 到 8 在表中。
-- 9 不在表中。
-- 10 在表中。
--
-- 来源：力扣（LeetCode）
-- 链接：https://leetcode-cn.com/problems/find-the-start-and-end-number-of-continuous-ranges
-- 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。




SELECT
	a.log_id AS start_id,
	min( b.log_id ) AS end_id
FROM
	( SELECT log_id FROM LOGS WHERE log_id - 1 NOT IN ( SELECT * FROM LOGS ) ) AS a,
	( SELECT log_id FROM LOGS WHERE log_id + 1 NOT IN ( SELECT * FROM LOGS ) ) AS b
WHERE
	b.log_id >= a.log_id
GROUP BY
	a.log_id;