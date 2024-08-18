### Prerequisites
* JDK17 Installed
* Gradle Installed

### Building the API
```bash
gradle build
```

### Testing the API
```bash
gradle test
```

### Running the API
```bash
gradle bootRun
```

One the SpringBoot API starts it will be available on `localhost:8081`

### Sample CURL Requests
POST
```bash
curl --location 'http://localhost:8081/api/v1/customer' \
--header 'Content-Type: application/json' \
--data '{
    "customerRef":"123",
    "customerName":"Jimmy John",
    "addressLine1":"Smallville Lane",
    "addressLine2":"Apt. 3",
    "county": "Small County",
    "town": "Smallville",
    "country":"USA",
    "postcode":"12345"
}'
```

GET
```bash
curl --location 'http://localhost:8081/api/v1/customer/1'
```