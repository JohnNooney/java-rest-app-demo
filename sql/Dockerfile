FROM postgres:latest

COPY init.sql /docker-entrypoint-initdb.d/

ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=demoproject

VOLUME /var/lib/postgresql/data

EXPOSE 5432

HEALTHCHECK CMD pg_isready -d "postgres