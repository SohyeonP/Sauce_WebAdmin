CREATE TABLE boss
(
  `boss_id`  INT      NOT NULL, 
  `name`    VARCHAR(45)  NOT NULL, 
  `phone`   VARCHAR(45)  NOT NULL, 
  `birthday`  VARCHAR(45)  NOT NULL, 
  `email`   VARCHAR(45)  NOT NULL, 
  `username`  VARCHAR(45)  NOT NULL, 
  `password`  VARCHAR(45)  NOT NULL, 
  `createdAt` DATETIME    NOT NULL, 
  `updateAt`  DATETIME    NOT NULL, 
  CONSTRAINT PK_boss PRIMARY KEY (boss_id)
);
ALTER TABLE boss;