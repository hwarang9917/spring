SELECT COUNT(*)
FROM Customers;
# INSERT INTO : 새 데이터(record, row) 입력
INSERT INTO Customers
(CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country)
VALUES ('92', 'donald', 'trump',
        'new york', 'CA', '1234', 'usa');

INSERT INTO Customers
(CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country)
VALUES ('93', 'elon', 'musk',
        'la', 'TA', '5678', 'usa');

INSERT INTO Customers
(CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country)
VALUES (94, 'park', 'jisung',
        'suwon', 'suwon', 9090, 'korea');

INSERT INTO Customers
    (CustomerName, ContactName, Address, City, PostalCode, Country)
VALUES ('son', 'hm',
        '강남', '강남', 8080, 'korea');

INSERT INTO Customers
    (CustomerName, ContactName, Address, City, PostalCode, Country)
VALUES ('cha', 'bum', '수원', '서울', 3030, 'korea');

SELECT *
FROM Customers
ORDER BY CustomerID DESC;

# 연습 :
# Categories 테이블에 새 레코드 2개 입력해보기
INSERT INTO Categories
    (CategoryName, Description)
VALUES ('snacks', 'cookies');

INSERT INTO Categories
    (CategoryName, Description)
VALUES ('toys', 'cars');

SELECT *
FROM Categories
ORDER BY CategoryID DESC;

# Products 테이블에 새 레코드 2개 입력해보기
INSERT INTO Products
    (ProductName, SupplierID, CategoryID, Unit, Price)
VALUES ('ASD',1010,3020,'10unit',12.30);

SELECT *
FROM Products
ORDER BY ProductID DESC;

INSERT INTO Categories (CategoryName, Description)
VALUES('스마트폰', null);

INSERT INTO Categories (CategoryName, Description)
VALUES('휴대폰','');

# Products 테이블에 새 레코드 2개 입력해보기
INSERT INTO Products
(ProductName, SupplierID, CategoryID, Unit, Price)
VALUES ('라떼', 1, 1, 'ml', 10.00);

INSERT INTO Products
(ProductName, SupplierID, CategoryID, Unit, Price)
VALUES ('선풍기', 2, 3, '개', 300.00);

SELECT *
FROM Products
ORDER BY ProductID DESC;

INSERT INTO Customers
(CustomerName)
VALUES ('손흥민');

# 의도적으로 null로 남김
INSERT INTO Customers
(CustomerName, ContactName)
VALUES ('트럼프', NULL);

# NULL과 ''은 다름
INSERT INTO Customers
(CustomerName, ContactName, Address)
VALUES ('도날드', NULL, '');

SELECT *
FROM Customers
ORDER BY CustomerID DESC;

# null : 값이 없다

#연습:
#카테고리테이블에 새 데이터를 넣기(Description 은 null로 남기기)
INSERT INTO Categories
(CategoryName, Description)
VALUES ('핸드폰', NULL);
INSERT INTO Categories
(CategoryName)
VALUES ('책');

SELECT *
FROM Categories
ORDER BY CategoryID DESC;
#카테고리테이블에 새 데이터를 넣기(Description 은 ''로 넣기)
INSERT INTO Categories
(CategoryName, Description)
VALUES ('물티슈', '');

# DELETE : 기존 데이터(record, row)  삭제

# UPDATE : 기존 데이터 수정

# DELETE : 기존 데이터(record, row) 삭제

# UPDATE : 기존 데이터 수정