DROP DATABASE IF EXISTS project2;
CREATE DATABASE project2;
\c project2;

CREATE TABLE user_accounts(
   id serial PRIMARY KEY,
   username VARCHAR (50) UNIQUE NOT NULL,
   password VARCHAR (50) NOT NULL
  
);




