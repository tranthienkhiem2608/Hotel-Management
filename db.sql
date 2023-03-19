use hotelmanagementsystem;

DROP TABLE users;
Drop table account;
Drop table drivers;
Drop table room;
CREATE TABLE Users (
  id varchar(20) PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  age INT,
  gender ENUM('male', 'female') NOT NULL,
  position ENUM('manager', 'receptionist', 'waiter', 'housekeeping', 'room service', 'security') NOT NULL,
  salary varchar(20) NOT NULL,
  phone VARCHAR(20),
  email VARCHAR(50) UNIQUE
);

CREATE TABLE ACCOUNT (
  id varchar(20) NOT NULL,
  password VARCHAR(255) NOT NULL,
  keyAnswer VARCHAR(50) NOT NULL,
  count int not null,
  primary key(id),
  foreign key(id) REFERENCES users(id)
);


CREATE TABLE Drivers (
  name VARCHAR(50) NOT NULL,
  age INT,
  gender ENUM('male', 'female') NOT NULL,
  phone VARCHAR(50),
  carBrand VARCHAR(50),
  Available ENUM('yes', 'no') NOT NULL,
  location VARCHAR(50)
);

CREATE TABLE Room (
  roomNumber INT AUTO_INCREMENT,
  availability ENUM('available', 'occupied') NOT NULL,
  cleaningStatus ENUM('dirty', 'cleaned') NOT NULL,
  price int NOT NULL,
  bedType ENUM('Single bed', 'Double bed', 'King bed') NOT NULL,
  primary key(roomNumber)
);

CREATE TABLE Customer (
  document VARCHAR(255) NOT NULL,
  numberID VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  gender ENUM('male', 'female') NOT NULL,
  country VARCHAR(255) NOT NULL,
  roomNumber int NOT NULL,
  checkintime DATETIME NOT NULL,
  deposit DECIMAL(10, 2) NOT NULL,
  PRIMARY KEY (numberID),
  FOREIGN KEY (roomNumber) REFERENCES room(roomNumber)
);

CREATE TABLE HistoryCustomer (
  document VARCHAR(255) NOT NULL,
  numberID VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  gender ENUM('male', 'female') NOT NULL,
  country VARCHAR(255) NOT NULL,
  room VARCHAR(255) NOT NULL,
  checkintime DATETIME NOT NULL,
  deposit DECIMAL(10, 2) NOT NULL,
  PRIMARY KEY (numberID),
  foreign key (numberID) REFERENCES Customer(numberID)
);



INSERT INTO Users (id, name, age, gender, position, salary, phone, email)
VALUES
('ma01', 'Le Viet Luc', 20, 'male', 'manager', 5000, '0398123458', 'lucle@gmail.com');

INSERT INTO ACCOUNT (id, password, keyAnswer, count)
VALUES
('ma01', 'lucle1102', 'pho', 1);

INSERT INTO Drivers (name, age, gender, phone, carBrand, Available, location) 
VALUES
('trung nguyen', 22, 'male', '0983114326', 'Toyota vios', 'yes', 'airport');

insert into room(roomNumber, availability, cleaningStatus, price, bedType)
VALUES(101, 'occupied', 'cleaned', 300, 'King bed');

INSERT INTO Customer (document, numberID, name, gender, country, roomNumber, checkintime, deposit)
VALUES ('CMND', 123456789, 'Nguyen Van A', 'male', 'Vietnam', '101', '2023-03-17 14:30:00', 100.00);

