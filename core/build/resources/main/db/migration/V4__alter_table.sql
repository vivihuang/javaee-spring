

update customer set course_id=1 where customer_name= 'annie';
update customer set course_id=2 WHERE customer_name='brain';
update customer set course_id=3 WHERE customer_name='cindy';

drop table course_arrangement;

CREATE TABLE date (
  id INT AUTO_INCREMENT PRIMARY KEY,
  date DATE ,
  customer_id INT ,
  FOREIGN KEY (customer_id) REFERENCES customer(id)
);
