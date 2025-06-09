# ALIAS (AS) : 컬럼이나 테이블에 별칭 주기
SELECT CustomerName, ContactName
FROM Customers;

SELECT CustomerName AS Name, ContactName AS Contact
FROM Customers;

# AS : 생략 가능
SELECT CustomerName Name, ContactName Contact
FROM Customers;

#
SELECT AVG(Price)
FROM Products;

SELECT AVG(Price) AS 평균가격
FROM Products;

SELECT AVG(Price) 평균가격
FROM Products;

SELECT AVG(Price) '평균 가격'
FROM Products;

SELECT AVG(Price) `평균 가격`
FROM Products;

# 테이블에 별칭 주기
SELECT p.ProductName, c.CategoryName
FROM Products AS p,
     Categories AS c;

SELECT p.ProductName, c.CategoryName
FROM Products p,
     Categories c;