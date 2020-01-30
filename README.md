# EmployeeManager
Spring MVC project to perform CRUD operations.
When we run this application on http://localhost:8080/ContactManager/, it shows employee contact details.
User can Edit and Delete existing information. 
User can save new contact details.
"ApiController" file in project contains rest api for to perform CRUD operations. We can consume these API's from front-end. I am trying to consume from ReactJS. 
We can test using PostMan. The response data will be in json formate.
http://localhost:8080/ContactManager/contacts

In order to run this application first we need to create db called contactdb in mysql
connect to mysql shell
 MySQL  JS > \sql
Switching to SQL mode... Commands end with ;
 MySQL  SQL > \connect --mysql root@localhost:3306
 
  > create table contact(
                             contact_id int(11) not null auto_increment,
                             name varchar(45) not null,
                             email varchar(45) not null,
                             address varchar(45) not null,
                             phone varchar(45) not null,
                             primary key(contact_id)
                          );

 
 

