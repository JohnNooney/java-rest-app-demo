CREATE TABLE Customers (
  CustomerRef SERIAL PRIMARY KEY,
  CustomerName VARCHAR(100),
  AddressLine1 VARCHAR(100),
  AddressLine2 VARCHAR(100),
  Town VARCHAR(50),
  County VARCHAR(50),
  Country VARCHAR(50),
  Postcode VARCHAR(20)
);