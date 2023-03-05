create database hotelmanagementsystem;
use hotelmanagementsystem;
create table Users(
	`id` varchar(100) NOT NULL,
    `username` varchar(100) NOT NULL,
	`password` varchar(255) NOT NULL,
    `email` varchar(255) NOT NULL,
    `phone` varchar(255) NOT NULL,
    `type` enum('Manager','Receptionist') NOT NULL,
    `answer` varchar(255) NOT NULL
);

insert into Users values('ma01','lucle', 'lucle1102','luc11le@gmail.com','0996699669','Manager','pho');
insert into Users values('re01','philips', 'philips11','tintruong@gmail.com','098765432','Receptionist','bun');

select * from Users;