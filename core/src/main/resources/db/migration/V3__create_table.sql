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

CREATE TABLE customer (
  id INT AUTO_INCREMENT PRIMARY KEY ,
  customer_name VARCHAR (50) ,
  employee_id INT,
  FOREIGN KEY (employee_id) REFERENCES employee(id)
);

INSERT INTO customer VALUES (NULL ,"annie",1);
INSERT INTO customer VALUES (NULL ,"brain",2);
INSERT INTO customer VALUES (NULL ,"cindy",3);

CREATE TABLE course (
  id INT AUTO_INCREMENT PRIMARY KEY ,
  course_name VARCHAR (50),
  employee_id INT ,
  FOREIGN KEY (employee_id) REFERENCES employee(id)
);

INSERT INTO course VALUES (NULL ,"瑜伽",1);
INSERT INTO course VALUES (NULL ,"拳击",2);
INSERT INTO course VALUES (NULL ,"肚皮舞",3);

CREATE TABLE course_arrangement (
  id INT AUTO_INCREMENT PRIMARY KEY ,
  date DATE ,
  course_id INT ,
  customer_id INT ,
  FOREIGN KEY (course_id) REFERENCES course(id),
  FOREIGN KEY (customer_id) REFERENCES customer(id)
);
