# ALTER TABLE customer DROP INDEX customer_fk_1;
# ALTER TABLE customer DROP FOREIGN KEY customer_fk_1;
# ALTER TABLE customer DROP course_id;
#
# ALTER TABLE customer ADD COLUMN employee_id INT;
# ALTER TABLE customer ADD FOREIGN KEY (employee_id) REFERENCES  employee(id);
#
# update customer set employee_id=3 where customer_name='annie';
# update customer set employee_id=4 WHERE customer_name='brain';
# update customer set employee_id=5 WHERE customer_name='cindy';
#
# CREATE TABLE customer_course (
#   id INT AUTO_INCREMENT PRIMARY KEY ,
#   customer_id INT,
#   course_id INT,
#   FOREIGN KEY (customer_id) REFERENCES customer(id),
#   FOREIGN KEY (course_id) REFERENCES course(id)
# );
#
# ALTER  TABLE date RENAME TO date_course;

ALTER TABLE date_course DROP FOREIGN KEY date_course_ibfk_1;
ALTER TABLE date_course DROP customer_id;

ALTER TABLE date_course ADD COLUMN course_id INT;
ALTER TABLE date_course ADD FOREIGN KEY (course_id) REFERENCES course(id);