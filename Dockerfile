version: '3'
services:
  db1:
    image: postgres:latest
    container_name: db1
    environment:
      - POSTGRES_PASSWORD=test
    ports:
      - "5432:5432"