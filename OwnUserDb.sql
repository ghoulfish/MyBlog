CREATE  TABLE blog.users (
id int AUTO_INCREMENT,
username VARCHAR(20) NOT NULL ,
password VARCHAR(20) NOT NULL ,
enabled TINYINT NOT NULL DEFAULT 1 ,
role varchar(20) NOT NULL,
PRIMARY KEY (id));
  
INSERT INTO blog.users(username,password ,role) VALUES ('jack','jack','ROLE_ADMIN');
INSERT INTO blog.users(username,password,role) VALUES ('peter','peter','ROLE_USER');