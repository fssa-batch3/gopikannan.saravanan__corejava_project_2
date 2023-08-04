use pin;
INSERT INTO userdata (userid, user_name, user_mail, user_pwd) VALUES (1, "Gopikannan", "gopikannan2906@gmail.com", "Wonder@2002");
ALTER TABLE userdata MODIFY COLUMN userid INT AUTO_INCREMENT  ;
INSERT INTO userdata ( user_name, user_mail, user_pwd) VALUES ( "Kutty", "kutyy2907@gmail.com", "Wonder@2002");
select * from userdata;


CREATE TABLE fundraisedetails (
  fundraise_id INT AUTO_INCREMENT,
  name VARCHAR(50),
  emailid VARCHAR(50),
  mobileno VARCHAR(20),
  cause VARCHAR(50),
  image_url VARCHAR(200),
  title VARCHAR(100),
  story TEXT,
  amount_expected DECIMAL(10, 2),
  PRIMARY KEY (fundraise_id)
);

select * from userdata;
select * from fundraisedetails;
describe   fundraisedetails;
delete from fundraisedetails;
 
delete from userdata;
ALTER TABLE userdata

DROP COLUMN user_phno,
DROP COLUMN useraddress,
DROP COLUMN userbankname,
DROP COLUMN useracco,
DROP COLUMN userifsc ;




