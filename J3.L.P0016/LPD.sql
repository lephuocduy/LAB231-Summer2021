USE MASTER
GO

IF EXISTS (SELECT * FROM SYS.DATABASES WHERE NAME = 'LPD') DROP DATABASE LPD
GO

CREATE DATABASE LPD
GO

USE LPD
GO
CREATE TABLE tblRoles
(
	roleID nvarchar(10) NOT NULL PRIMARY KEY,
	rolename nvarchar(100) NOT NULL
)
GO

CREATE TABLE tblStatusUser
(
	statusUserID nvarchar(10) NOT NULL PRIMARY KEY,
	statusUsername nvarchar(100) NOT NULL
)
GO

CREATE TABLE tblUsers
(
	email nvarchar(50) NOT NULL PRIMARY KEY,
	fullname nvarchar(100) NOT NULL,
	password nvarchar(50) NULL,
	phoneNumber nvarchar(10) NULL,
	address nvarchar(500) NULL,
	createUserDate date NULL,
	roleID nvarchar(10) NOT NULL FOREIGN KEY
						REFERENCES tblRoles(roleID),
	statusUserID nvarchar(10) NOT NULL FOREIGN KEY
						REFERENCES tblStatusUser(statusUserID)
)
GO

CREATE TABLE tblCategorys
(
	categoryID nvarchar(10) NOT NULL PRIMARY KEY,
	categoryName nvarchar(100) NOT NULL,
)
GO

CREATE TABLE tblProducts
(
	productID nvarchar(10) NOT NULL PRIMARY KEY,
	productName nvarchar(100) NOT NULL,
	quantity int NOT NULL,
	image nvarchar(300) NOT NULL,
	color nvarchar(50) NOT NULL,
	createProductDate date NULL,
	levelUser int NOT NULL,
	status bit NULL,
	categoryID nvarchar(10) NOT NULL FOREIGN KEY
						REFERENCES tblCategorys(categoryID)
)
GO

CREATE TABLE tblStatusRequest
(
	statusRequestID nvarchar(10) NOT NULL PRIMARY KEY,
	statusRequestname nvarchar(100) NOT NULL
)
GO

CREATE TABLE tblRequests
(
	requestID int NOT NULL PRIMARY KEY,
	bookDate datetime NULL,
	bookingUntil date NULL,
	email nvarchar(50) NOT NULL FOREIGN KEY
						REFERENCES tblUsers(email),
	statusRequestID nvarchar(10) NOT NULL FOREIGN KEY
						REFERENCES tblStatusRequest(statusRequestID)
)
GO

CREATE TABLE tblRequestsDetails
(
	detailID int IDENTITY(1,1) NOT NULL PRIMARY KEY,
	quantity int NOT NULL,
	requestID int NOT NULL FOREIGN KEY 
					REFERENCES tblRequests(requestID),
	productID nvarchar(10) NOT NULL FOREIGN KEY
						REFERENCES tblProducts(productID)
)
GO

USE LPD
GO

INSERT INTO tblRoles VALUES(N'LD', N'Leader')
INSERT INTO tblRoles VALUES(N'AD', N'Admin')
INSERT INTO tblRoles VALUES(N'US', N'User')
GO

INSERT INTO tblStatusUser VALUES(N'New', N'New')
INSERT INTO tblStatusUser VALUES(N'Active', N'Active')
GO

INSERT INTO tblUsers VALUES(N'leader@gmail.com',N'leader',N'1',N'0123456789',N'q9',CAST(N'2021-05-05' AS Date),N'LD',N'Active')
INSERT INTO tblUsers VALUES(N'admin@gmail.com',N'admin',N'1',N'0123456789',N'q9',CAST(N'2021-05-05' AS Date),N'AD',N'Active')
INSERT INTO tblUsers VALUES(N'user@gmail.com',N'user',N'1',N'0123456789',N'q9',CAST(N'2021-05-05' AS Date),N'US',N'Active')
INSERT INTO tblUsers VALUES(N'user2@gmail.com',N'user2',N'1',N'0123456789',N'q9',CAST(N'2021-05-05' AS Date),N'US',N'New')
GO

INSERT INTO tblCategorys VALUES(N'I',N'Item')
INSERT INTO tblCategorys VALUES(N'E',N'Electronice')
INSERT INTO tblCategorys VALUES(N'O',N'Other')
GO

INSERT INTO tblProducts VALUES(N'P-001',N'Chair-1',20,N'https://noithatmanhphat.vn/hm_content/uploads/auto-save/o8vVJtN2RNqF7sY4edjdBcPb838zobalvYRrPE8ORzdKqimRh_FYJpWvwRhjcaIH5CZVeYWb3RkYfR8XbOvFwbkzwzq72A18dPak-PpACvZquLP-gNm8Gkxrct98WzuGA_qW8Lca.jpg',N'Black',CAST(N'2021-03-20' AS Date),0,1,N'I')
INSERT INTO tblProducts VALUES(N'P-002',N'Chair-2',30,N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRv3p1ZvoqATLk7e3FjmyLR0aunWQ3m6kXC3zduvFkeeQSbG5RbLowVt2UINxExYFhp4HK3XGEW&usqp=CAc',N'White',CAST(N'2021-05-07' AS Date),0,1,N'I')
INSERT INTO tblProducts VALUES(N'P-003',N'Chair-3',15,N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTPw6OI_oOk1Tb9x9gvmSO8B8jWW8qlfQIaEAPB8bNUR3257ZdMQLomCmbAbuDhd6X2BfWoY7I&usqp=CAc',N'Blue',CAST(N'2021-05-06' AS Date),0,1,N'I')
INSERT INTO tblProducts VALUES(N'P-004',N'Chair-4',20,N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSE62cernUBPk-IqPjCquhgVswDEIqdT7i6LHNZo9RslcANopAsWf3qOExxA5ZNeWlWf1lklnkc&usqp=CAc',N'Red',CAST(N'2021-04-05' AS Date),0,1,N'I')
INSERT INTO tblProducts VALUES(N'P-005',N'Chair-5',10,N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQM2TGCIAh9vxdrvF4c74S2nvmX2lSvdV-xXw&usqp=CAU',N'Yellow',CAST(N'2021-02-13' AS Date),0,1,N'I')
INSERT INTO tblProducts VALUES(N'P-006',N'Table-1',15,N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSYr3Q-xLuXnNrb4gQxQdpU0Q4EOfYKyJQHnSpBkskwVACnkujUjzaRi4AvJFAMnQp27gvLBOWd&usqp=CAc',N'Black',CAST(N'2021-05-05' AS Date),0,1,N'I')
INSERT INTO tblProducts VALUES(N'P-007',N'Table-2',15,N'https://chanbanvanphong.com.vn/images/companies/1/G%C3%B3c%20%C3%9D%20T%C6%B0%E1%BB%9Fng/b%C3%A0n%20l%C3%A0m%20vi%E1%BB%87c%20ch%E1%BB%AF%20L/ban-lam-viec-chu-L-chan-sat-lap-rap-2.jpg?1539244237978',N'Black',CAST(N'2021-03-03' AS Date),0,1,N'I')
INSERT INTO tblProducts VALUES(N'P-008',N'Table-3',10,N'https://noithatrof.com/wp-content/uploads/2017/06/B%C3%A0n-l%C3%A0m-vi%E1%BB%87c-nh%C3%A2n-vi%C3%AAn-RAT120S-1.png',N'White',CAST(N'2021-04-03' AS Date),0,1,N'I')
INSERT INTO tblProducts VALUES(N'P-009',N'Table-4',20,N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSmKhCXDTJ4ryAh7wLNfwNSgQXPR36a-AGOtd3SAO7tJf9fl1TUjp5wknODTH1OCfMoGJHhDYoA&usqp=CAc',N'White',CAST(N'2021-06-06' AS Date),0,1,N'I')
INSERT INTO tblProducts VALUES(N'P-0010',N'Table-5',10,N'https://cdn.fitin.vn/cms-ecom/thumbs/1200x1200/product-tmp/2020/05/18/ban-basic-3-trang-v1-1589769367.jpg',N'White',CAST(N'2021-05-13' AS Date),0,1,N'I')
INSERT INTO tblProducts VALUES(N'P-0011',N'IMac',20,N'https://images.fpt.shop/unsafe/filters:quality(90):format(webp)/fptshop.com.vn/uploads/images/tin-tuc/101132/Originals/iMac-2013-1.jpg',N'White',CAST(N'2021-05-23' AS Date),0,1,N'E')
INSERT INTO tblProducts VALUES(N'P-0012',N'MacMini',20,N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTsqeXdhpl-9hYQPhNLfYQbbP1uUcFUERbZxKE3QeyDb8RgcJxd-4CcbYwgARK4DI1VDvEm2TNQ&usqp=CAc',N'White',CAST(N'2021-02-03' AS Date),0,1,N'E')
INSERT INTO tblProducts VALUES(N'P-0013',N'Macbook Air',30,N'https://fptshop.com.vn/Content/Images/uploaded/Laptop%20IMG/Apple/Macbook%20Air%2011%20-%2017.jpg',N'Silver',CAST(N'2021-04-02' AS Date),0,1,N'E')
INSERT INTO tblProducts VALUES(N'P-0014',N'Macbook Pro',30,N'https://fptshop.com.vn/Content/Images/uploaded/Laptop%20IMG/Apple/Macbook%20Air%2011%20-%2017.jpg',N'Silver',CAST(N'2021-05-22' AS Date),0,1,N'E')
INSERT INTO tblProducts VALUES(N'P-0015',N'Macbook Air M1',20,N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCXbum29I8jjD_D5c8xZJE8Yz5PkO8rgAQHxzAzeK6zeOjK9n3TKOtNxA3hxyMjBZSaAnyrJHl&usqp=CAc',N'Gold',CAST(N'2021-05-03' AS Date),0,1,N'E')
INSERT INTO tblProducts VALUES(N'P-0016',N'Macbook Pro M1',15,N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkUk3R4kvLnTgzZvi61wCSBEu1nhpnh4AHBGCyA4ARpPULvCOQbzC9lsgi_VDg-7ZfrMH5wuQ&usqp=CAc',N'Grey',CAST(N'2021-05-03' AS Date),0,1,N'E')
INSERT INTO tblProducts VALUES(N'P-0017',N'Pillow-1',50,N'https://dathangsi.vn/upload/products/2019/08/0357-10811001732_553100731.jpg',N'Yellow',CAST(N'2021-05-18' AS Date),0,1,N'O')
INSERT INTO tblProducts VALUES(N'P-0018',N'Pillow-2',40,N'https://tumuado.com/wp-content/uploads/2020/04/goi-ngu-trua-da-nang-cho-dan-van-phong-cao-cap-1-scaled.jpg',N'Blue',CAST(N'2021-05-03' AS Date),0,1,N'O')
INSERT INTO tblProducts VALUES(N'P-0019',N'Room-1',2,N'https://phonghoitruong.com.vn/wp-content/uploads/2016/08/Phong-hop-nho.jpg',N'Black',CAST(N'2021-05-02' AS Date),0,1,N'O')
INSERT INTO tblProducts VALUES(N'P-0020',N'Room-2',2,N'https://noithatmienbac.vn/images/image/kienthuc/ghe-phong-hop-chan-quy-dep.jpg',N'White',CAST(N'2021-06-23' AS Date),0,1,N'O')
INSERT INTO tblProducts VALUES(N'P-0021',N'BigRoom',1,N'https://amthanhanhsangviet.com/wp-content/uploads/2018/03/1.amthanhansangviet-e1534298767617.jpg',N'Black',CAST(N'2021-05-03' AS Date),0,1,N'O')

INSERT INTO tblProducts VALUES(N'P-0022',N'Chair-1LD',20,N'https://noithatmanhphat.vn/hm_content/uploads/auto-save/o8vVJtN2RNqF7sY4edjdBcPb838zobalvYRrPE8ORzdKqimRh_FYJpWvwRhjcaIH5CZVeYWb3RkYfR8XbOvFwbkzwzq72A18dPak-PpACvZquLP-gNm8Gkxrct98WzuGA_qW8Lca.jpg',N'Black',CAST(N'2021-03-03' AS Date),1,1,N'I')
INSERT INTO tblProducts VALUES(N'P-0023',N'Chair-2LD',30,N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRv3p1ZvoqATLk7e3FjmyLR0aunWQ3m6kXC3zduvFkeeQSbG5RbLowVt2UINxExYFhp4HK3XGEW&usqp=CAc',N'White',CAST(N'2021-04-03' AS Date),1,1,N'I')
INSERT INTO tblProducts VALUES(N'P-0024',N'Chair-3LD',15,N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTPw6OI_oOk1Tb9x9gvmSO8B8jWW8qlfQIaEAPB8bNUR3257ZdMQLomCmbAbuDhd6X2BfWoY7I&usqp=CAc',N'Blue',CAST(N'2021-04-03' AS Date),1,1,N'I')
INSERT INTO tblProducts VALUES(N'P-0025',N'Chair-4LD',20,N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSE62cernUBPk-IqPjCquhgVswDEIqdT7i6LHNZo9RslcANopAsWf3qOExxA5ZNeWlWf1lklnkc&usqp=CAc',N'Red',CAST(N'2021-05-03' AS Date),1,1,N'I')
INSERT INTO tblProducts VALUES(N'P-0026',N'Chair-5LD',10,N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQM2TGCIAh9vxdrvF4c74S2nvmX2lSvdV-xXw&usqp=CAU',N'Yellow',CAST(N'2021-03-03' AS Date),1,1,N'I')
INSERT INTO tblProducts VALUES(N'P-0027',N'Table-1LD',15,N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSYr3Q-xLuXnNrb4gQxQdpU0Q4EOfYKyJQHnSpBkskwVACnkujUjzaRi4AvJFAMnQp27gvLBOWd&usqp=CAc',N'Black',CAST(N'2021-05-03' AS Date),1,1,N'I')
INSERT INTO tblProducts VALUES(N'P-0028',N'Table-2LD',15,N'https://chanbanvanphong.com.vn/images/companies/1/G%C3%B3c%20%C3%9D%20T%C6%B0%E1%BB%9Fng/b%C3%A0n%20l%C3%A0m%20vi%E1%BB%87c%20ch%E1%BB%AF%20L/ban-lam-viec-chu-L-chan-sat-lap-rap-2.jpg?1539244237978',N'Black',CAST(N'2021-03-03' AS Date),1,1,N'I')
INSERT INTO tblProducts VALUES(N'P-0029',N'Table-3LD',10,N'https://noithatrof.com/wp-content/uploads/2017/06/B%C3%A0n-l%C3%A0m-vi%E1%BB%87c-nh%C3%A2n-vi%C3%AAn-RAT120S-1.png',N'White',CAST(N'2021-05-03' AS Date),1,1,N'I')
INSERT INTO tblProducts VALUES(N'P-0030',N'Table-4LD',20,N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSmKhCXDTJ4ryAh7wLNfwNSgQXPR36a-AGOtd3SAO7tJf9fl1TUjp5wknODTH1OCfMoGJHhDYoA&usqp=CAc',N'White',CAST(N'2021-05-03' AS Date),1,1,N'I')
INSERT INTO tblProducts VALUES(N'P-0031',N'Table-5LD',10,N'https://cdn.fitin.vn/cms-ecom/thumbs/1200x1200/product-tmp/2020/05/18/ban-basic-3-trang-v1-1589769367.jpg',N'White',CAST(N'2021-05-03' AS Date),1,1,N'I')
INSERT INTO tblProducts VALUES(N'P-0032',N'IMacLD',20,N'https://images.fpt.shop/unsafe/filters:quality(90):format(webp)/fptshop.com.vn/uploads/images/tin-tuc/101132/Originals/iMac-2013-1.jpg',N'White',CAST(N'2021-05-03' AS Date),1,1,N'E')
INSERT INTO tblProducts VALUES(N'P-0033',N'MacMiniLD',20,N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTsqeXdhpl-9hYQPhNLfYQbbP1uUcFUERbZxKE3QeyDb8RgcJxd-4CcbYwgARK4DI1VDvEm2TNQ&usqp=CAc',N'White',CAST(N'2021-04-03' AS Date),1,1,N'E')
INSERT INTO tblProducts VALUES(N'P-0034',N'Macbook AirLD',30,N'https://fptshop.com.vn/Content/Images/uploaded/Laptop%20IMG/Apple/Macbook%20Air%2011%20-%2017.jpg',N'Silver',CAST(N'2021-04-03' AS Date),1,1,N'E')
INSERT INTO tblProducts VALUES(N'P-0035',N'Macbook ProLD',30,N'https://fptshop.com.vn/Content/Images/uploaded/Laptop%20IMG/Apple/Macbook%20Air%2011%20-%2017.jpg',N'Silver',CAST(N'2021-05-03' AS Date),1,1,N'E')
INSERT INTO tblProducts VALUES(N'P-0036',N'Macbook Air M1LD',20,N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCXbum29I8jjD_D5c8xZJE8Yz5PkO8rgAQHxzAzeK6zeOjK9n3TKOtNxA3hxyMjBZSaAnyrJHl&usqp=CAc',N'Gold',CAST(N'2021-03-03' AS Date),1,1,N'E')
INSERT INTO tblProducts VALUES(N'P-0037',N'Macbook Pro M1LD',15,N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkUk3R4kvLnTgzZvi61wCSBEu1nhpnh4AHBGCyA4ARpPULvCOQbzC9lsgi_VDg-7ZfrMH5wuQ&usqp=CAc',N'Grey',CAST(N'2021-05-03' AS Date),1,1,N'E')
INSERT INTO tblProducts VALUES(N'P-0038',N'Pillow-1LD',50,N'https://dathangsi.vn/upload/products/2019/08/0357-10811001732_553100731.jpg',N'Yellow',CAST(N'2021-05-03' AS Date),1,1,N'O')
INSERT INTO tblProducts VALUES(N'P-0039',N'Pillow-2LD',40,N'https://tumuado.com/wp-content/uploads/2020/04/goi-ngu-trua-da-nang-cho-dan-van-phong-cao-cap-1-scaled.jpg',N'Blue',CAST(N'2021-05-03' AS Date),1,1,N'O')
INSERT INTO tblProducts VALUES(N'P-0040',N'Room-1LD',2,N'https://phonghoitruong.com.vn/wp-content/uploads/2016/08/Phong-hop-nho.jpg',N'Black',CAST(N'2021-05-03' AS Date),1,1,N'O')
INSERT INTO tblProducts VALUES(N'P-0041',N'Room-2LD',2,N'https://noithatmienbac.vn/images/image/kienthuc/ghe-phong-hop-chan-quy-dep.jpg',N'White',CAST(N'2021-05-24' AS Date),1,1,N'O')
INSERT INTO tblProducts VALUES(N'P-0042',N'BigRoomLD',1,N'https://amthanhanhsangviet.com/wp-content/uploads/2018/03/1.amthanhansangviet-e1534298767617.jpg',N'Black',CAST(N'2021-05-24' AS Date),1,1,N'O')
GO

INSERT INTO tblStatusRequest VALUES(N'New', N'New')
INSERT INTO tblStatusRequest VALUES(N'Delete', N'Delete')
INSERT INTO tblStatusRequest VALUES(N'Accept', N'Accept')
GO