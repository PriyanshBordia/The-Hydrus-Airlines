drop database airline_database;

create database airline_database;

use airline_database; 

create table login(username varchar(20) primary key , password varchar(20) );
create table flight(f_code varchar(10) primary key , f_name varchar(20), src varchar(30), dst varchar(30) , cap int);
create table passenger(p_code int auto_increment , nationality varchar(15), name varchar(20), age varchar(3) ,  gender varchar(10), ph_no varchar(15), passport_no varchar(20), primary key (p_code));
create table booking(pnr_no int auto_increment primary key , f_code varchar(10) , p_code int , foreign key (f_code) references flight (f_code) , foreign key (p_code) references passenger (p_code));  
create table cancel (pnr_no int , cancellation_no int auto_increment primary key);	

insert into flight (f_code, f_name, src, dst, cap) values ('JA9011', 'Jet Airways', 'Mumbai', 'Delhi' , 900);
insert into flight (f_code, f_name, src, dst, cap) values ('JA9012', 'Jet Airways', 'Mumbai', 'Jaipur' , 600);
insert into flight (f_code, f_name, src, dst, cap) values ('JA9013', 'Jet Airways', 'Mumbai', 'Lucknow' , 200);
insert into flight (f_code, f_name, src, dst, cap) values ('JA9014', 'Jet Airways', 'Delhi', 'Mumbai' , 900);
insert into flight (f_code, f_name, src, dst, cap) values ('JA9015', 'Jet Airways', 'Delhi', 'Lucknow' , 950);
insert into flight (f_code, f_name, src, dst, cap) values ('JA9016', 'Jet Airways', 'Delhi', 'Jaipur' , 550);
insert into flight (f_code, f_name, src, dst, cap) values ('JA9017', 'Jet Airways', 'Jaipur', 'Delhi' , 500);
insert into flight (f_code, f_name, src, dst, cap) values ('JA9018', 'Jet Airways', 'Jaipur', 'Mumbai' , 100);
insert into flight (f_code, f_name, src, dst, cap) values ('JA9019', 'Jet Airways', 'Jaipur', 'Lucknow' , 800);
insert into flight (f_code, f_name, src, dst, cap) values ('JA9020', 'Jet Airways', 'Lucknow', 'Mumbai' , 550);
insert into flight (f_code, f_name, src, dst, cap) values ('JA9021', 'Jet Airways', 'Lucknow', 'Delhi' , 900);
insert into flight (f_code, f_name, src, dst, cap) values ('JA9022', 'Jet Airways', 'Lucknow', 'Jaipur' , 660);



insert into login (username , password) values ('admin' , 'hello');
