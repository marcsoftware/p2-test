DROP DATABASE IF EXISTS project1;
CREATE DATABASE project1;
\c project1;

CREATE TABLE user_accounts(
   id serial PRIMARY KEY,
   username VARCHAR (50) UNIQUE NOT NULL,
   password VARCHAR (50) NOT NULL
  
);




