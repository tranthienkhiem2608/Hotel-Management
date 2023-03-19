use htotelmangementsystem;

DROP TABLE users;
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
  id varchar(20) PRIMARY KEY,
  password VARCHAR(255) NOT NULL,
  keyAnswer VARCHAR(50) NOT NULL
);


CREATE TABLE Drivers (
  name VARCHAR(50) NOT NULL,
  age INT,
  gender ENUM('male', 'female') NOT NULL,
  carCompany VARCHAR(50),
  carBrand VARCHAR(50),
  Available ENUM('yes', 'no') NOT NULL,
  location VARCHAR(50)
);

CREATE TABLE Room (
  roomNumber INT PRIMARY KEY,
  availability ENUM('available', 'occupied') NOT NULL,
  cleaningStatus ENUM('dirty', 'cleaned') NOT NULL,
  price DECIMAL(10, 2) NOT NULL,
  bedType ENUM('Single bed', 'Double bed', 'King bed') NOT NULL
);

INSERT INTO Users (id, name, age, gender, position, salary, phone, email)
VALUES
('ma01', 'Le Viet Luc', 20, 'male', 'manager', 5000, '0398123458', 'lucle@gmail.com');

INSERT INTO ACCOUNT (id, password, keyAnswer)
VALUES
('ma01', 'lucle1102', 'pho')


