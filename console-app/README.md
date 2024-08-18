### Prerequisites
* JDK17 Installed
* Gradle Installed
* PostgreSQL Database running - see `../sql/README.md`
* SpringBoot API running - see `../api/README.md`

### Building the Console App
```bash
gradle build
```

### Testing the Console App
```bash
gradle test
```

### Running the Console App
```bash
gradle run
```

Once the application starts it will automatically read the `sample-data.csv` file in the resources directory to upload to the database.
