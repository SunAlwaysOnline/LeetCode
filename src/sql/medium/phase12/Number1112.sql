-- 1112. 每位学生的最高成绩


-- 表：Enrollments
--
-- +---------------+---------+
-- | Column Name   | Type    |
-- +---------------+---------+
-- | student_id    | int     |
-- | course_id     | int     |
-- | grade         | int     |
-- +---------------+---------+
-- (student_id, course_id) 是该表的主键。
--
--  
--
-- 编写一个 SQL 查询，查询每位学生获得的最高成绩和它所对应的科目，若科目成绩并列，取 course_id 最小的一门。查询结果需按 student_id 增序进行排序。
--
-- 查询结果格式如下所示：
--
-- Enrollments 表：
-- +------------+-------------------+
-- | student_id | course_id | grade |
-- +------------+-----------+-------+
-- | 2          | 2         | 95    |
-- | 2          | 3         | 95    |
-- | 1          | 1         | 90    |
-- | 1          | 2         | 99    |
-- | 3          | 1         | 80    |
-- | 3          | 2         | 75    |
-- | 3          | 3         | 82    |
-- +------------+-----------+-------+
--
-- Result 表：
-- +------------+-------------------+
-- | student_id | course_id | grade |
-- +------------+-----------+-------+
-- | 1          | 2         | 99    |
-- | 2          | 2         | 95    |
-- | 3          | 3         | 82    |
-- +------------+-----------+-------+
--
-- 来源：力扣（LeetCode）
-- 链接：https://leetcode-cn.com/problems/highest-grade-for-each-student
-- 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



SELECT
	student_id,
	course_id,
	grade
FROM
	(
	  SELECT *, row_number ( ) over ( PARTITION BY student_id ORDER BY grade DESC, course_id ASC ) AS rw
	  FROM Enrollments
	) t
WHERE
	rw = 1
ORDER BY
	student_id ASC;