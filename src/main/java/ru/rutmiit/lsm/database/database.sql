CREATE DATABASE postgres;
USE postgres;

CREATE TABLE "userAccount" (
                               "idUserAccount" SERIAL PRIMARY KEY,
                               "firstName" varchar(200) NOT NULL,
                               "lastName" varchar(200) NOT NULL,
                               "userName" varchar(200) NOT NULL,
                               "password" varchar(200) NOT NULL
);

INSERT INTO "userAccount" ("firstName", "lastName", "userName", password)
VALUES ('Vadim', 'Lushin', 'admin', '123456');

CREATE TABLE "addBook" (
                           "id" varchar(200) NOT NULL,
                           "title" varchar(200) NOT NULL,
                           "author" varchar(200) NOT NULL,
                           "publisher" varchar(200) NOT NULL,
                           "quantity" int NOT NULL,
                           "isAvail" boolean DEFAULT TRUE,
                           PRIMARY KEY (id)
);

CREATE TABLE "addMember" (
                             "memberID" varchar(200) NOT NULL,
                             "name" varchar(200) NOT NULL,
                             "email" varchar(200) NOT NULL,
                             "phone" varchar(200) NOT NULL,
                             "gender" varchar(6) NOT NULL CHECK (gender IN ('female', 'male')),
                             PRIMARY KEY ("memberID")
);

CREATE TABLE "issuedBooks" (
                               "bookID" varchar(200) NOT NULL,
                               "memberID" varchar(200) NOT NULL,
                               "issueTime" timestamp DEFAULT CURRENT_TIMESTAMP,
                               "renew_count" integer DEFAULT 0,
                               PRIMARY KEY ("bookID", "memberID"),
                               FOREIGN KEY ("bookID") REFERENCES "addBook" ("id"),
                               FOREIGN KEY ("memberID") REFERENCES "addMember" ("memberID")
);