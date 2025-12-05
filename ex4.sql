CREATE TABLE Department (
    Department_Number INT PRIMARY KEY,
    Department_Name VARCHAR(100)
);
CREATE TABLE Employee (
    Employee_Number INT PRIMARY KEY,
    Employee_Name VARCHAR(100),
    Department_Number INT,
    FOREIGN KEY (Department_Number) REFERENCES Department(DepartmentID)
);
#1 : Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT e.Employee_Number, e.Employee_Name, d.Department_Name
FROM Employee e
INNER  JOIN Department d ON e.Department_Number = d.DepartmentID;
#2 : Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010
SELECT 
    a.Username,
    a.Email,
    a.FullName,
    a.DepartmentID,
    a.PositionID ,
    a.CreateDate ,
    d.DepartmentID , 
    d.Department_Name, 
    e.ExamID 
    
FROM account a
INNER JOIN department d ON a.DepartmentID = d.DepartmentID
INNER JOIN position p   ON a.PositionID = p.PositionID
INNER JOIN exam e ON a.PositionID = e.ExamID 
INNER JOIN answer a1 ON a.DepartmentID = a1.AnswerID

WHERE a.CreateDate > '2010-12-20';
#3 : Viết lệnh để lấy ra tất cả các developer
SELECT *
FROM account a
INNER JOIN position p ON a.PositionID = p.PositionID
WHERE p.PositionName = 'Dev';
 
 # 4 :Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT d.DepartmentID, d.Department_Name, COUNT(a.Email) AS totalEmployees
FROM Department d
JOIN Account a ON d.DepartmentID = a.DepartmentID
GROUP BY d.DepartmentID, d.Department_Name
HAVING COUNT(a.Email) > 0;
 
 # 5 : Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều
 SELECT q.QuestionID, q.Content, COUNT(eq.ExamID) AS UsedCount
FROM Question q
JOIN ExamQuestion eq ON q.QuestionID = eq.QuestionID
GROUP BY q.QuestionID, q.Content
HAVING COUNT(eq.ExamID) > 1     
ORDER BY UsedCount DESC;
 
 # 6 :Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
 SELECT 
    cq.CategoryID,
    cq.CategoryName,
    COUNT(q.QuestionID) AS TotalQuestion
FROM CategoryQuestion cq
LEFT JOIN Question q 
        ON cq.CategoryID = q.CategoryID
GROUP BY cq.CategoryID, cq.CategoryName
ORDER BY TotalQuestion DESC;
 CREATE TABLE CategoryQuestion (
    CategoryID INT AUTO_INCREMENT PRIMARY KEY,
    CategoryName VARCHAR(100) NOT NULL
);
 
 # 7 :Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
 SELECT 
    q.QuestionID,
    q.Content,
    COUNT(eq.ExamID) AS TotalExamUsed
FROM Question q
LEFT JOIN ExamQuestion eq 
        ON q.QuestionID = eq.QuestionID
GROUP BY q.QuestionID, q.Content
ORDER BY TotalExamUsed DESC;


 # 8 : Lấy ra Question có nhiều câu trả lời nhất
 SELECT 
    q.QuestionID,
    q.Content,
    COUNT(a.AnswerID) AS TotalAnswer
FROM Question q
INNER JOIN Answer a 
        ON q.QuestionID = a.QuestionID
GROUP BY q.QuestionID, q.Content
ORDER BY TotalAnswer DESC
LIMIT 1;
 
 # 9 :Thống kê số lượng account trong mỗi group
 SELECT 
    g.GroupID,
    g.GroupName,
    COUNT(ga.AccountID) AS TotalAccount
FROM `Group` g
LEFT JOIN GroupAccount ga 
        ON g.GroupID = ga.GroupID
GROUP BY g.GroupID, g.GroupName
ORDER BY TotalAccount DESC;

 
 # 10 :Tìm chức vụ có ít người nhất
SELECT 
    p.PositionID,
    p.PositionName,
    COUNT(a.Email) AS TotalAccount
FROM Position p
LEFT JOIN Account a 
        ON p.PositionID = a.PositionID
GROUP BY p.PositionID, p.PositionName
ORDER BY TotalAccount ASC
LIMIT 1;

 #11 : Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
 
 SELECT 
    q.QuestionID,
    q.Content AS QuestionContent,
    cq.CategoryName,
    a.FullName AS CreatorName,
    ans.AnswerID,
    ans.Content AS AnswerContent,
    ans.isCorrect
FROM Question q
INNER JOIN CategoryQuestion cq 
        ON q.CategoryID = cq.CategoryID
INNER JOIN Account a 
        ON q.CreatorID = a.Email
LEFT JOIN Answer ans
        ON q.QuestionID = ans.QuestionID
ORDER BY q.QuestionID, ans.AnswerID;
 #12 :Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của
 # question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, …
SELECT 
    q.QuestionID,
    q.Content AS QuestionContent,
    q.CreateDate,
    cq.CategoryName,
    a.Email AS CreatorID,
    a.FullName AS CreatorName,
    a.Email AS CreatorEmail,
    ans.AnswerID,
    ans.Content AS AnswerContent,
    ans.isCorrect
FROM Question q

INNER JOIN CategoryQuestion cq 
        ON q.CategoryID = cq.CategoryID
INNER JOIN Account a 
        ON q.CreatorID = a.Email

LEFT JOIN Answer ans
        ON q.QuestionID = ans.QuestionID

WHERE q.QuestionID = 1   
ORDER BY ans.AnswerID;

 #13 :Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
 SELECT 
    tq.TypeName,
    COUNT(q.QuestionID) AS TotalQuestion
FROM TypeQuestion tq
LEFT JOIN Question q 
        ON tq.TypeID = q.TypeID
GROUP BY tq.TypeName;
 
 #14 :Lấy ra group không có account nào
 SELECT 
    g.GroupID,
    g.GroupName
FROM `Group` g
LEFT JOIN GroupAccount ga 
        ON g.GroupID = ga.GroupID
WHERE ga.AccountID IS NULL;
 
 #15 :Lấy ra question không có answer nào.
SELECT 
    q.QuestionID,
    q.Content
FROM Question q
LEFT JOIN Answer a 
        ON q.QuestionID = a.QuestionID
WHERE a.Email IS NULL;

#16 

SELECT a.*
FROM Account a
INNER JOIN GroupAccount ga 
        ON a.Email = ga.AccountID
WHERE ga.GroupID = 1

UNION

SELECT a.*
FROM Account a
INNER JOIN GroupAccount ga 
        ON a.Email = ga.AccountID
WHERE ga.GroupID = 2;
#17  
SELECT 
    g.GroupID,
    g.GroupName,
    COUNT(ga.AccountID) AS TotalMember
FROM `Group` g
LEFT JOIN GroupAccount ga 
        ON g.GroupID = ga.GroupID
GROUP BY g.GroupID, g.GroupName
HAVING COUNT(ga.AccountID) > 5

UNION

SELECT 
    g.GroupID,
    g.GroupName,
    COUNT(ga.AccountID) AS TotalMember
FROM `Group` g
LEFT JOIN GroupAccount ga 
        ON g.GroupID = ga.GroupID
GROUP BY g.GroupID, g.GroupName
HAVING COUNT(ga.AccountID) < 7;

