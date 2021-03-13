-- 571. 给定数字的频率查询中位数


-- Numbers 表保存数字的值及其频率。
--
-- +----------+-------------+
-- |  Number  |  Frequency  |
-- +----------+-------------|
-- |  0       |  7          |
-- |  1       |  1          |
-- |  2       |  3          |
-- |  3       |  1          |
-- +----------+-------------+
-- 在此表中，数字为 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 2, 3，所以中位数是 (0 + 0) / 2 = 0。
--
-- +--------+
-- | median |
-- +--------|
-- | 0.0000 |
-- +--------+
-- 请编写一个查询来查找所有数字的中位数并将结果命名为 median 。
--
-- 来源：力扣（LeetCode）
-- 链接：https://leetcode-cn.com/problems/find-median-given-frequency-of-numbers
-- 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



select avg(t.number) as median
from
(
   select n1.number, n1.frequency,
   (select sum(frequency) from numbers n2 where n2.number<=n1.number) as asc_frequency,
   (select sum(frequency) from numbers n3 where n3.number>=n1.number) as desc_frequency
   from numbers n1
) t
where t.asc_frequency>= (select sum(frequency) from numbers)/2
and t.desc_frequency>= (select sum(frequency) from numbers)/2;