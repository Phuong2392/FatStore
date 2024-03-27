use FatStore;
CREATE TABLE Accounts (
    username VARCHAR(50) PRIMARY KEY,
    phone VARCHAR(10),
    password VARCHAR(10),
    email VARCHAR(100),
	isactive bit,
	isadmin bit,
	address varchar(max)
);

Create table Categories(
	id int IDENTITY(1,1) PRIMARY KEY,
	name nvarchar(100)
);

Create table Orders(
	id int IDENTITY(1,1) PRIMARY KEY,
	createdate datetime,
	price float,
	username VARCHAR(50),
	productid int
);

Create table Products(
	id int IDENTITY(1,1) PRIMARY KEY,
	createdate datetime,
	description nvarchar(max),
	name nvarchar(100),
	price float,
	quantity int,
	cateid int
);
ALTER TABLE Orders
ADD CONSTRAINT fk_username
FOREIGN KEY (username) REFERENCES accounts(username);

ALTER TABLE Products
ADD CONSTRAINT fk_cateid
FOREIGN KEY (cateid) REFERENCES Categories(id);

ALTER TABLE Orders
ADD CONSTRAINT fk_productid
FOREIGN KEY (productid) REFERENCES Products(id);

ALTER TABLE Products
ADD image VARCHAR(max);

INSERT INTO Categories(name) VALUES ('Nam');
INSERT INTO Categories(name) VALUES ('Nữ');
INSERT INTO Categories(name) VALUES ('Ba lô');

INSERT INTO Accounts(username,phone,password, email, isactive, isadmin, address ) VALUES ('PhuongNTK', '0767038890', '123', 'nguyen020392@gmail.com',1,1, '1/24 Ho Thi Ky');
INSERT INTO Accounts(username,phone,password, email, isactive, isadmin, address ) VALUES ('LinhNguyen', '0767038823', '123', 'nguyen02@gmail.com',1,1, '1 Ho Thi Ky');
INSERT INTO Accounts(username,phone,password, email, isactive, isadmin, address ) VALUES ('PhuongNguyen', '0767034533', '123', 'nguyen0203@gmail.com',1,0, '1/26 Ho Thi Ky');