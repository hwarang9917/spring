# sql 주석
# 실행 되지 않는 코드
# 설명용으로 사용
# ctrl /

SELECT *
FROM Customers;

# ctrl enter
# 쿼리(sql) 실행
# 한 명령문(쿼리)는 ;으로 끝남

SELECT *
FROM Employees;

# 쿼리는 대소문자 구분안함
SELECT *
FROM Employees;

select *
from Employees;

# 키워드는 대문자,
# 테이블,컬럼명은 소문자
SELECT *
FROM Employees;


# SELECT, FROM
SELECT *
FROM Employees;
SELECT *
FROM Categories;
SELECT *
FROM Suppliers;

# 데이터들은 행과 열의 조합으로 저장되어 있다.
# 테이블 : 행과 열의 조합으로 데이터를 저장한 곳

# 9개의 행, 6개의 열
# Employees
SELECT *
FROM Employees;

# 8개의 행, 3개의 열
# Categories
SELECT *
FROM Categories;

# 3행, 3열
# Shippers
SELECT *
FROM Shippers;

# SELECT : 열을 선택
# FROM : 테이블 지정
# WHERE : 행을 선택(filter)

SELECT *
FROM Shippers;
SELECT *
FROM Customers;

# 연습 : Employees 테이블 조회
SELECT *
FROM Employees;