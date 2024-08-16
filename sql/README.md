### Prerequisites
* Docker installed and running on your system.

### Building the Docker Image
Build the Docker image:
```bash
docker build -t my-postgres-image .
```
Replace `my-postgres-image` with your desired image name.

### Running the Docker Container
```bash
docker run -d --name my-postgres-container my-postgres-image
```

This command will start the Postgres container using the specified image. The Dockerfile handles environment variables, volume mounting, and port exposure.

### Accessing the Database
Once the container is running, you can connect to the Postgres database using the following connection details:
* Host: `localhost`
* Port: `5432`
* Database: `postgres` (default)
* User: `postgres`
* Password: `demoproject` 