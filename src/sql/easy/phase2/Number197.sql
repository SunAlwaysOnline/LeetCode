-- 197. 上升的温度


-- 表 Weather
--
-- +---------------+---------+
-- | Column Name   | Type    |
-- +---------------+---------+
-- | id            | int     |
-- | recordDate    | date    |
-- | temperature   | int     |
-- +---------------+---------+
-- id 是这个表的主键
-- 该表包含特定日期的温度信息
--  
--
-- 编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 id 。
--
-- 返回结果 不要求顺序 。
--
-- 查询结果格式如下例：
--
-- Weather
-- +----+------------+-------------+
-- | id | recordDate | Temperature |
-- +----+------------+-------------+
-- | 1  | 2015-01-01 | 10          |
-- | 2  | 2015-01-02 | 25          |
-- | 3  | 2015-01-03 | 20          |
-- | 4  | 2015-01-04 | 30          |
-- +----+------------+-------------+
--
-- Result table:
-- +----+
-- | id |
-- +----+
-- | 2  |
-- | 4  |
-- +----+
-- 2015-01-02 的温度比前一天高（10 -> 25）
-- 2015-01-04 的温度比前一天高（20 -> 30）
--
-- 来源：力扣（LeetCode）
-- 链接：https://leetcode-cn.com/problems/rising-temperature
-- 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



SELECT
	w2.id
FROM
	Weather AS w1
	JOIN Weather AS w2 ON datediff( w2.recordDate, w1.recordDate )= 1
WHERE
	w2.Temperature > w1.Temperature;