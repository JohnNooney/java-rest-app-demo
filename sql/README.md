### Prerequisites
* Docker installed and running on your system.

### Building the Docker Image
Build the Docker image:
```bash
docker build -t postgres-image .
```
Replace `my-postgres-image` with your desired image name.

### Running the Docker Container
```bash
docker run -d --name postgres -p 5432:5432 postgres-image
```

This command will start the Postgres container using the specified image. The Dockerfile handles environment variables, volume mounting, and port exposure.

### Accessing the Database
Once the container is running, you can connect to the Postgres database using the following connection details:
* Host: `localhost`
* Port: `5432`
* Database: `customerdb`
* User: `postgres`
* Password: `demoproject` 


#### CLI Access
Use the below command in a CLI instance to connect to the Docker contianer:
```bash
docker exec -it my_postgres psql -U postgres
```

Some useful psql commands:
```bash
# List databases
\l

# Switch databases
\c <database name>

# List tables
\dt

# List table details
\d <table name>
```