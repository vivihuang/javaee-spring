ALTER TABLE customer_course DROP FOREIGN KEY customer_course_ibfk_1;
ALTER TABLE customer_course DROP FOREIGN KEY customer_course_ibfk_2;

DROP TABLE customer_course;

RENAME TABLE date_course TO date_course_customer;

ALTER TABLE date_course_customer ADD COLUMN customer_id INT;
ALTER TABLE date_course_customer ADD FOREIGN KEY (customer_id) REFERENCES customer(id);
