-- 1350. 院系无效的学生

-- 院系表: Departments
--
-- +---------------+---------+
-- | Column Name   | Type    |
-- +---------------+---------+
-- | id            | int     |
-- | name          | varchar |
-- +---------------+---------+
-- id 是该表的主键
-- 该表包含一所大学每个院系的 id 信息
--  
--
-- 学生表: Students
--
-- +---------------+---------+
-- | Column Name   | Type    |
-- +---------------+---------+
-- | id            | int     |
-- | name          | varchar |
-- | department_id | int     |
-- +---------------+---------+
-- id 是该表的主键
-- 该表包含一所大学每个学生的 id 和他/她就读的院系信息
--  
--
-- 写一条 SQL 语句以查询那些所在院系不存在的学生的 id 和姓名
--
-- 可以以任何顺序返回结果
--
-- 下面是返回结果格式的例子
--
-- Departments 表:
-- +------+--------------------------+
-- | id   | name                     |
-- +------+--------------------------+
-- | 1    | Electrical Engineering   |
-- | 7    | Computer Engineering     |
-- | 13   | Bussiness Administration |
-- +------+--------------------------+
--
-- Students 表:
-- +------+----------+---------------+
-- | id   | name     | department_id |
-- +------+----------+---------------+
-- | 23   | Alice    | 1             |
-- | 1    | Bob      | 7             |
-- | 5    | Jennifer | 13            |
-- | 2    | John     | 14            |
-- | 4    | Jasmine  | 77            |
-- | 3    | Steve    | 74            |
-- | 6    | Luis     | 1             |
-- | 8    | Jonathan | 7             |
-- | 7    | Daiana   | 33            |
-- | 11   | Madelynn | 1             |
-- +------+----------+---------------+
--
-- 结果表:
-- +------+----------+
-- | id   | name     |
-- +------+----------+
-- | 2    | John     |
-- | 7    | Daiana   |
-- | 4    | Jasmine  |
-- | 3    | Steve    |
-- +------+----------+
--
-- John, Daiana, Steve 和 Jasmine 所在的院系分别是 14, 33, 74 和 77， 其中 14, 33, 74 和 77 并不存在于院系表
--
-- 来源：力扣（LeetCode）
-- 链接：https://leetcode-cn.com/problems/students-with-invalid-departments
-- 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



SELECT
	s.id AS id,
	s.NAME AS NAME
FROM
	Students AS s
	LEFT JOIN Departments AS d ON s.department_id = d.id
WHERE
	d.id IS NULL;