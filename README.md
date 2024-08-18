# Project Overview
**Console Application**: Java app that reads a single CSV file from the specified directory, parses the data, and sends each record as a JSON `POST` request to the REST API.  

**API**: SpringBoot API that accepts `POST` requests with customer data, stores the data in a PostgreSQL database, and provides a `GET` endpoint to retrieve customer information based on customer reference.

**Database**: PostgresSQL database contains a single table: `customers`, which is used to store the records as found in the CSV file. 

**Expected CSV File Sample**:
```csv
Customer Ref,Customer Name,Address Line 1,Address Line 2,Town,County,Country,Postcode
1,John Doe,123 Main Street,Apt 2,Anytown,Some County,USA,12345
```

## Console Application
**Scope:**
An executable application that will read a CSV file from the `./console-app/app/src/main/.../resources` directory,
validate that each record contains the required data, then add each customer record to the database through the
SpringBoot API.

**Assumptions:** 
- The CSV file format is assumed to be fixed with the specified columns.
- Customer Ref in the CSV file are unique per record.
- all CSV data is required for a record to be published to the database.
- Error handling and data validation should be implemented to handle potential issues with CSV data.

**Limitations:**
- Only one CSV file can be ingested at a time
- `GET` is only used to retrieve the records that were added from the CSV file

**Further Reading:**
More information on starting the console application can be found in: `./console-app/README.md`

## SpringBoot API
**Scope:**
A Java API that integrates with a PostgreSQL database for adding and retrieving records.

**API Reasoning:**
Java + SpringBoot were chosen for its ability to quickly create REST APIs that can be used in conjunction with
Spring Data JPA to simplify database interactions, reducing boilerplate code.


**API Spec:**

| Endpoint                           | Notes                                                                                                                                                                                                    |
|------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| POST /api/v1/customer/             | Requires the following JSON body: </br> `{"customerRef": int,"customerName": string,"addressLine1": string,"addressLine2": string,"town": string,"county": string,"country": string,"postcode": string}` |
| GET /api/v1/customer/{customerRef} | Returns customer data                                                                                                                                                                                    |


**Assumptions:**
- The integrated PostgreSQL database contains the following configuration
   - host: `localhost`
   - port: `5432`
   - username: `postgres`
   - password: `demoproject`
   - database definition: as specified in `./sql/init.sql`
- The API will not validate data other than if fields are missing

**Limitations:**
- Only a `POST` and `GET` endpoint are implemented

**Further Reading:**
More information on starting the console application can be found in: `./api/README.md`

# Technology Stack
### Console Application

| Tech | Note |
|-|-|
| Java | language |
| JUnit | For testing |
| Gradle | Build tool |

### API

| Tech | Note |
| --- | --- |
| Java | language |
| JUnit and Spring MockMvc | For API testing |
| Spring Boot | Framework for building the REST API |
| Spring Data JPA | For database interactions |
| Gradle | Build tool |

### Database

| Tech | Note |
|-|-|
| PostgreSQL | Database for storing customer data |
| Docker | For containerizing the PostgreSQL instance and easy deployment |


# Project Structure 

```txt
| .
├── api/
│   ├── Note: source code for the Java SpringBoot API
│   └── src/
│       ├── main/
│       │   └──  Note: application code
│       └── test/
│           └── Notes:  API test code
├── console-app/
│   ├── Note: source code for the Java console application 
│   └── src/
│       ├── main/
│       │   ├── Note: application code
│       │   └── resources/
│       │       └── Note: contains sample .csv file for ingestion
│       └── test/
│           └── Notes: test code
└── sql/
    └── Note: Dockerfile and init.sql for the PostgreSQL database
```
