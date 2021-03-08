-- 1098. 小众书籍


-- 书籍表 Books：
--
-- +----------------+---------+
-- | Column Name    | Type    |
-- +----------------+---------+
-- | book_id        | int     |
-- | name           | varchar |
-- | available_from | date    |
-- +----------------+---------+
-- book_id 是这个表的主键。
-- 订单表 Orders：
--
-- +----------------+---------+
-- | Column Name    | Type    |
-- +----------------+---------+
-- | order_id       | int     |
-- | book_id        | int     |
-- | quantity       | int     |
-- | dispatch_date  | date    |
-- +----------------+---------+
-- order_id 是这个表的主键。
-- book_id  是 Books 表的外键。
--  
--
-- 你需要写一段 SQL 命令，筛选出过去一年中订单总量 少于10本 的 书籍 。
--
-- 注意：不考虑 上架（available from）距今 不满一个月 的书籍。并且 假设今天是 2019-06-23 。
--
--  
--
-- 下面是样例输出结果：
--
-- Books 表：
-- +---------+--------------------+----------------+
-- | book_id | name               | available_from |
-- +---------+--------------------+----------------+
-- | 1       | "Kalila And Demna" | 2010-01-01     |
-- | 2       | "28 Letters"       | 2012-05-12     |
-- | 3       | "The Hobbit"       | 2019-06-10     |
-- | 4       | "13 Reasons Why"   | 2019-06-01     |
-- | 5       | "The Hunger Games" | 2008-09-21     |
-- +---------+--------------------+----------------+
--
-- Orders 表：
-- +----------+---------+----------+---------------+
-- | order_id | book_id | quantity | dispatch_date |
-- +----------+---------+----------+---------------+
-- | 1        | 1       | 2        | 2018-07-26    |
-- | 2        | 1       | 1        | 2018-11-05    |
-- | 3        | 3       | 8        | 2019-06-11    |
-- | 4        | 4       | 6        | 2019-06-05    |
-- | 5        | 4       | 5        | 2019-06-20    |
-- | 6        | 5       | 9        | 2009-02-02    |
-- | 7        | 5       | 8        | 2010-04-13    |
-- +----------+---------+----------+---------------+
--
-- Result 表：
-- +-----------+--------------------+
-- | book_id   | name               |
-- +-----------+--------------------+
-- | 1         | "Kalila And Demna" |
-- | 2         | "28 Letters"       |
-- | 5         | "The Hunger Games" |
-- +-----------+--------------------+
--
-- 来源：力扣（LeetCode）
-- 链接：https://leetcode-cn.com/problems/unpopular-books
-- 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



SELECT
	b.book_id,
	b.NAME
FROM
	Books AS b
	LEFT JOIN Orders AS o ON b.book_id = o.book_id
	AND o.dispatch_date BETWEEN '2018-06-23'
	AND '2019-06-23'
WHERE
	b.available_from <= '2019-05-23'
GROUP BY
	b.book_id
HAVING
	ifnull( sum( o.quantity ), 0 ) < 10;