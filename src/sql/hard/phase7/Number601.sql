-- 601. 体育馆的人流量


-- 表：Stadium
-- +---------------+---------+
-- | Column Name   | Type    |
-- +---------------+---------+
-- | id            | int     |
-- | visit_date    | date    |
-- | people        | int     |
-- +---------------+---------+
-- visit_date 是表的主键
-- 每日人流量信息被记录在这三列信息中：序号 (id)、日期 (visit_date)、 人流量 (people)
-- 每天只有一行记录，日期随着 id 的增加而增加
--  
--
-- 编写一个 SQL 查询以找出每行的人数大于或等于 100 且 id 连续的三行或更多行记录。
--
-- 返回按 visit_date 升序排列的结果表。
--
-- 查询结果格式如下所示。
--
-- Stadium table:
-- +------+------------+-----------+
-- | id   | visit_date | people    |
-- +------+------------+-----------+
-- | 1    | 2017-01-01 | 10        |
-- | 2    | 2017-01-02 | 109       |
-- | 3    | 2017-01-03 | 150       |
-- | 4    | 2017-01-04 | 99        |
-- | 5    | 2017-01-05 | 145       |
-- | 6    | 2017-01-06 | 1455      |
-- | 7    | 2017-01-07 | 199       |
-- | 8    | 2017-01-09 | 188       |
-- +------+------------+-----------+
--
-- Result table:
-- +------+------------+-----------+
-- | id   | visit_date | people    |
-- +------+------------+-----------+
-- | 5    | 2017-01-05 | 145       |
-- | 6    | 2017-01-06 | 1455      |
-- | 7    | 2017-01-07 | 199       |
-- | 8    | 2017-01-09 | 188       |
-- +------+------------+-----------+
-- id 为 5、6、7、8 的四行 id 连续，并且每行都有 >= 100 的人数记录。
-- 请注意，即使第 7 行和第 8 行的 visit_date 不是连续的，输出也应当包含第 8 行，因为我们只需要考虑 id 连续的记录。
-- 不输出 id 为 2 和 3 的行，因为至少需要三条 id 连续的记录。
--
-- 来源：力扣（LeetCode）
-- 链接：https://leetcode-cn.com/problems/human-traffic-of-stadium
-- 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



-- 如果只是找出全部人流量不少于100的记录不难，难点在于如何查找连续的三天，一个想法是，查 3 张表，让三个结果 id 连续
--
--
-- SELECT a.*
-- FROM stadium as a,stadium as b,stadium as c
-- where (a.id = b.id-1 and b.id+1 = c.id)
--   and (a.people>=100 and b.people>=100 and c.people>=100);
-- 但是这样输出会有问题，比如 5,6,7,8 号人流量不少于100，但是只输出了 5,6号，根本原因在于，我们将 a 的 id 设为三个连续值中最小值，所以只返回了每 3 个连续值中最小的一个，同理可想到，我们再将 a 的 id 设为三个连续值中中间值和最大值，可以得到全部的连续 3 个值
--
--
-- SELECT a.*
-- FROM stadium as a,stadium as b,stadium as c
-- where ((a.id = b.id-1 and b.id+1 = c.id) or
--        (a.id-1 = b.id and a.id+1 = c.id) or
--        (a.id-1 = c.id and c.id-1 = b.id))
--   and (a.people>=100 and b.people>=100 and c.people>=100);
-- 但是这样还有个问题，比如 5,6,7,8，6 既是 5,6,7 的中间值也是 6,7,8 的最小值，所以还要去重，也许 id 不按序排列，再排序 id，最终得到答案
--
--
-- SELECT distinct a.*
-- FROM stadium as a,stadium as b,stadium as c
-- where ((a.id = b.id-1 and b.id+1 = c.id) or
--        (a.id-1 = b.id and a.id+1 = c.id) or
--        (a.id-1 = c.id and c.id-1 = b.id))
--   and (a.people>=100 and b.people>=100 and c.people>=100)
-- order by a.id;


SELECT DISTINCT
	a.*
FROM
	Stadium AS a,
	Stadium AS b,
	Stadium AS c
WHERE
	a.people >= 100
	AND b.people >= 100
	AND c.people >= 100
	AND (
	( a.id = b.id - 1 AND b.id = c.id - 1 )
	OR ( b.id = a.id - 1 AND a.id = c.id - 1 )
	OR ( b.id = c.id - 1 AND c.id = a.id - 1 )
	)
ORDER BY
	a.visit_date ASC;