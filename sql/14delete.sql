# DELETE : 특정 행(row, record)을 삭제
DELETE
FROM Customers
WHERE CustomerID = 100;

DELETE
FROM Customers
WHERE CustomerID = 96;

SELECT *
FROM Customers
WHERE CustomerID = 96;

DELETE FROM Customers
WHERE Country IS NULL;

# 연습
# 공급자 테이블에서
# 28, 29번 공급자 삭제 하기
SELECT *
FROM Suppliers
WHERE SupplierID = 28;

DELETE
FROM Suppliers
WHERE SupplierID = 28;

SELECT *
FROM Suppliers
WHERE SupplierID = 29;

DELETE
FROM Suppliers
WHERE SupplierID = 29;

# 공급자 테이블의 모든 레코드 삭제하기
DELETE
FROM Suppliers;

SELECT *
FROM Suppliers;