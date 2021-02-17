-- 577. 员工奖金


-- 选出所有 bonus < 1000 的员工的 name 及其 bonus。
--
-- Employee 表单
--
-- +-------+--------+-----------+--------+
-- | empId |  name  | supervisor| salary |
-- +-------+--------+-----------+--------+
-- |   1   | John   |  3        | 1000   |
-- |   2   | Dan    |  3        | 2000   |
-- |   3   | Brad   |  null     | 4000   |
-- |   4   | Thomas |  3        | 4000   |
-- +-------+--------+-----------+--------+
-- empId 是这张表单的主关键字
-- Bonus 表单
--
-- +-------+-------+
-- | empId | bonus |
-- +-------+-------+
-- | 2     | 500   |
-- | 4     | 2000  |
-- +-------+-------+
-- empId 是这张表单的主关键字
-- 输出示例：
--
-- +-------+-------+
-- | name  | bonus |
-- +-------+-------+
-- | John  | null  |
-- | Dan   | 500   |
-- | Brad  | null  |
-- +-------+-------+
--
-- 来源：力扣（LeetCode）
-- 链接：https://leetcode-cn.com/problems/employee-bonus
-- 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



SELECT
	e.NAME,
	b.bonus
FROM
	Employee AS e
	LEFT JOIN Bonus AS b ON e.empId = b.empId
WHERE
	b.bonus IS NULL
	OR b.bonus < 1000;