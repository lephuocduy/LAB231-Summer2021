USE MASTER
GO

IF EXISTS (SELECT * FROM SYS.DATABASES WHERE NAME = 'LPD2') DROP DATABASE LPD2
GO

CREATE DATABASE LPD2
GO

USE LPD2
GO
CREATE TABLE tblRoles
(
	roleID nvarchar(10) NOT NULL PRIMARY KEY,
	roleName nvarchar(100) NOT NULL
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
	userID nvarchar(50) NOT NULL PRIMARY KEY,
	userName nvarchar(100) NOT NULL,
	password nvarchar(500) NOT NULL,
	email nvarchar(50) NOT NULL,
	phoneNumber nvarchar(10) NOT NULL,
	photo nvarchar(500) NOT NULL,
	statusPromotion bit NOT NULL,
	promotionDate datetime NULL,
	rank int NULL,
	roleID nvarchar(10) NOT NULL FOREIGN KEY
						REFERENCES tblRoles(roleID),
	statusUserID nvarchar(10) NOT NULL FOREIGN KEY
						REFERENCES tblStatusUser(statusUserID)
)
GO

CREATE TABLE tblHistories
(
	historyID int IDENTITY(1,1) NOT NULL PRIMARY KEY,
	historyDate datetime NOT NULL,
	historyRank int NOT NULL,
	userID nvarchar(50) NOT NULL FOREIGN KEY
						REFERENCES tblUsers(userID)
)
GO

USE LPD2
GO

INSERT INTO tblRoles VALUES(N'AD', N'Admin')
INSERT INTO tblRoles VALUES(N'US', N'User')
GO

INSERT INTO tblStatusUser VALUES(N'Active', N'Active')
INSERT INTO tblStatusUser VALUES(N'Inactive', N'Inactive')
GO

INSERT INTO tblUsers VALUES(N'admin',N'Admin',N'6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b',N'admin@gmail.com',N'0123456789',N'maleAdmin.jpg',0,null,null,N'AD',N'Active')
INSERT INTO tblUsers VALUES(N'user',N'User',N'6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b',N'user@gmail.com',N'0123456789',N'user1.jpg',0,null,null,N'US',N'Active')
GO


