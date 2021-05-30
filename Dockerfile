FROM postgres:9.6.14

COPY database/init.sql /docker-entrypoint-initdb.d
