DROP TABLE IF EXISTS Position;

DROP TABLE IF EXISTS Trainee;
CREATE TABLE `Group`(
    GroupID INT AUTO_INCREMENT PRIMARY KEY,
    GroupName VARCHAR(35),
    CreatorID INT,
    CreateDate DATE
);
CREATE TABLE Position (
    PositionID INT AUTO_INCREMENT PRIMARY KEY,
    PositionName VARCHAR(30)
);

CREATE TABLE Account(
    Email VARCHAR(50),
    Username VARCHAR(50),
    FullName VARCHAR(50),
    DepartmentID INT,
    PositionID INT,
    CreateDate DATE,
    PRIMARY KEY (Email),
    FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID),
    FOREIGN KEY (PositionID) REFERENCES Position (PositionID) 
);

CREATE TABLE `Group`(
    GroupID INT AUTO_INCREMENT PRIMARY KEY,
    GroupName VARCHAR(35),
    CreatorID VARCHAR(50),
    CreateDate DATE,
    FOREIGN KEY (CreatorID) REFERENCES Account(Email)
);

CREATE TABLE GroupAccount (
    GroupID INT,
    AccountID VARCHAR(50),
    JoinDate DATE,
    FOREIGN KEY (GroupID) REFERENCES `Group`(GroupID),
    FOREIGN KEY (AccountID) REFERENCES Account(Email)
);

CREATE TABLE TypeQuestion (
    TypeID INT AUTO_INCREMENT PRIMARY KEY,
    TypeName VARCHAR(53)
);

CREATE TABLE Question (
    QuestionID INT AUTO_INCREMENT PRIMARY KEY,
    Content VARCHAR(100),
    CategoryID INT,
    TypeID INT,
    CreatorID VARCHAR(50),
    CreateDate DATE,
    FOREIGN KEY (TypeID) REFERENCES TypeQuestion(TypeID),
    FOREIGN KEY (CreatorID) REFERENCES Account(Email)
);

CREATE TABLE Answer (
    AnswerID INT AUTO_INCREMENT PRIMARY KEY,
    Content VARCHAR(50),
    QuestionID INT,
    isCorrect ENUM ('dung','sai'),
    FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID)
);

CREATE TABLE Exam (
    ExamID INT AUTO_INCREMENT PRIMARY KEY,
    Code VARCHAR(20),
    Title VARCHAR(50),
    CategoryID INT,
    Duration INT,
    CreatorID VARCHAR(50),
    CreateDate DATE,
    FOREIGN KEY (CreatorID) REFERENCES Account(Email)
);

CREATE TABLE ExamQuestion (
    ExamID INT,
    QuestionID INT,
    FOREIGN KEY (ExamID) REFERENCES Exam(ExamID),
    FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID)
);

CREATE TABLE Trainee (
    TraineeID INT AUTO_INCREMENT PRIMARY KEY,
    Full_Name VARCHAR(100) NOT NULL,
    Birth_Date DATE NOT NULL,
    Gender ENUM('male', 'female', 'unknown') NOT NULL DEFAULT 'unknown',
    ET_IQ INT NOT NULL CHECK (ET_IQ BETWEEN 0 AND 20),
    ET_Gmath INT NOT NULL CHECK (ET_Gmath BETWEEN 0 AND 20),
    ET_English INT NOT NULL CHECK (ET_English BETWEEN 0 AND 50),
    Training_Class VARCHAR(20),
    Evaluation_Notes TEXT,
    VTI_Account VARCHAR(50) UNIQUE
);
DROP DATABASE testing_system;
CREATE DATABASE testing_system;

INSERT INTO Position (PositionName)
VALUES 
('Dev'),
('Test'),
('PM'),
('PM');

INSERT INTO Department (DepartmentName)
VALUES 
('Sale'),
('Marketing'),
('IT'),
('HR');
INSERT INTO Account (Email, Username, FullName, DepartmentID, PositionID, CreateDate)
VALUES
('a5@gmail.com', 'user1', 'Do Duc Tuyen', 3, 1, '2024-05-05'),
('a6@gmail.com', 'user2', 'Do Duc Tuyen', 3, 2, '2024-05-10'),
('a7@gmail.com', 'user3', 'Do Duc Tuyen', 1, 3, '2024-05-12'),
('a8@gmail.com', 'user4', 'Do Duc Tuyen', 2, 1, '2024-05-20');
INSERT INTO `Group` (GroupName, CreatorID, CreateDate)
VALUES
('Group Java', 'a1@gmail.com', '2024-05-20'),
('Group SQL', 'a2@gmail.com', '2024-05-21'),
('Group Python', 'a3@gmail.com', '2024-05-22');
INSERT INTO GroupAccount (GroupID, AccountID, JoinDate)
VALUES
(1, 'a1@gmail.com', '2024-05-21'),
(1, 'a2@gmail.com', '2024-05-22'),
(2, 'a3@gmail.com', '2024-05-25'),
(3, 'a4@gmail.com', '2024-05-27');
INSERT INTO TypeQuestion (TypeName)
VALUES 
('Essay'),
('Multiple Choice');
INSERT INTO Question (Content, CategoryID, TypeID, CreatorID, CreateDate)
VALUES
('Câu hỏi Java cơ bản?', 1, 2, 'a1@gmail.com', '2024-06-01'),
('Câu hỏi SQL cơ bản?', 1, 1, 'a2@gmail.com', '2024-06-02'),
('Câu hỏi HTML là gì?', 1, 2, 'a3@gmail.com', '2024-06-03');
INSERT INTO Answer (Content, QuestionID, isCorrect)
VALUES
('Java là OOP', 1, 'dung'),
('Java không phải OOP', 1, 'sai'),
('SQL dùng để truy vấn', 2, 'dung'),
('HTML là ngôn ngữ dựng layout', 3, 'dung');
INSERT INTO Exam (Code, Title, CategoryID, Duration, CreatorID, CreateDate)
VALUES
('EX01', 'Đề Java', 1, 60, 'a1@gmail.com', '2025-06-10'),
('EX02', 'Đề SQL', 1, 45, 'a2@gmail.com', '2024-06-11');
INSERT INTO ExamQuestion (ExamID, QuestionID)
VALUES
(1, 1),
(1, 3),
(2, 2);
INSERT INTO Department (departmentName)
VALUES ('IT');
