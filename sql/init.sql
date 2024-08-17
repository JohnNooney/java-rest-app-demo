CREATE DATABASE customerdb;

\c customerdb

CREATE TABLE customers (
  customerRef INT PRIMARY KEY,
  customerName VARCHAR(100),
  addressLine1 VARCHAR(100),
  addressLine2 VARCHAR(100),
  town VARCHAR(50),
  county VARCHAR(50),
  country VARCHAR(50),
  postcode VARCHAR(20)
);