CREATE TABLE employee (
  id INT AUTO_INCREMENT PRIMARY KEY,
  employee_name VARCHAR (50) ,
  role VARCHAR (20)
);

INSERT INTO employee VALUES (NULL ,"harper","hr");
INSERT INTO employee VALUES (NULL ,"david","op");
INSERT INTO employee VALUES (NULL ,"brooklyn","coach");
INSERT INTO employee VALUES (NULL ,"romeo","coach");
INSERT INTO employee VALUES (NULL ,"cruz","coach");

CREATE TABLE user (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_name VARCHAR (50) ,
  password VARCHAR (20) ,
  employee_id INT ,
  FOREIGN KEY (employee_id) REFERENCES employee(id)
);

INSERT INTO user VALUES (NULL ,"harper","admin",1);
INSERT INTO user VALUES (NULL ,"david","admin",2);
INSERT INTO user VALUES (NULL ,"brooklyn","admin",3);
INSERT INTO user VALUES (NULL ,"romeo","admin",4);
INSERT INTO user VALUES (NULL ,"cruz","admin",5);