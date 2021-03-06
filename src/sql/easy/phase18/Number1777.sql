-- 1777. 每家商店的产品价格


-- 表：Products
--
-- +-------------+---------+
-- | Column Name | Type    |
-- +-------------+---------+
-- | product_id  | int     |
-- | store       | enum    |
-- | price       | int     |
-- +-------------+---------+
-- (product_id,store) 是这个表的主键。
-- store 字段是枚举类型，它的取值为以下三种 ('store1', 'store2', 'store3') 。
-- price 是该商品在这家商店中的价格。
--  
--
-- 写出一个 SQL 查询语句，查找每种产品在各个商店中的价格。
--
-- 可以以 任何顺序 输出结果。
--
-- 查询结果格式如下例所示：
--
-- Products 表：
-- +-------------+--------+-------+
-- | product_id  | store  | price |
-- +-------------+--------+-------+
-- | 0           | store1 | 95    |
-- | 0           | store3 | 105   |
-- | 0           | store2 | 100   |
-- | 1           | store1 | 70    |
-- | 1           | store3 | 80    |
-- +-------------+--------+-------+
-- Result 表：
-- +-------------+--------+--------+--------+
-- | product_id  | store1 | store2 | store3 |
-- +-------------+--------+--------+--------+
-- | 0           | 95     | 100    | 105    |
-- | 1           | 70     | null   | 80     |
-- +-------------+--------+--------+--------+
-- 产品 0 的价格在商店 1 为 95 ，商店 2 为 100 ，商店 3 为 105 。
-- 产品 1 的价格在商店 1 为 70 ，商店 3 的产品 1 价格为 80 ，但在商店 2 中没有销售。
--
-- 来源：力扣（LeetCode）
-- 链接：https://leetcode-cn.com/problems/products-price-for-each-store
-- 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



SELECT
	p.product_id,
	a.price AS store1,
	b.price AS store2,
	c.price AS store3
FROM
	Products AS p
	LEFT JOIN ( SELECT * FROM Products WHERE store = 'store1' ) AS a ON p.product_id = a.product_id
	LEFT JOIN ( SELECT * FROM Products WHERE store = 'store2' ) AS b ON p.product_id = b.product_id
	LEFT JOIN ( SELECT * FROM Products WHERE store = 'store3' ) AS c ON p.product_id = c.product_id
GROUP BY
	p.product_id;