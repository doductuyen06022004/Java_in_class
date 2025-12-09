#1 Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
CREATE OR REPLACE VIEW vw_employee_sale AS
SELECT 
    a.AccountID,
    a.FullName,
    a.Email,
    d.Department_Name
FROM Account a
JOIN Department d 
    ON a.DepartmentID = d.DepartmentID
WHERE d.Department_Name = 'Sale';
#2 Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
CREATE OR REPLACE VIEW vw_account_most_groups AS
SELECT 
    a.AccountID,
    a.FullName,
    a.Email,
    COUNT(ga.GroupID) AS total_groups
FROM Account a
JOIN groupaccount ga
    ON a.AccountID = ga.AccountID
GROUP BY a.AccountID, a.FullName, a.Email
HAVING COUNT(ga.GroupID) = (
    SELECT MAX(group_count)
    FROM (
        SELECT COUNT(GroupID) AS group_count
        FROM GroupAccount
        GROUP BY AccountID
    ) AS t
);



#3 Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ
# được coi là quá dài) và xóa nó đi 
CREATE OR REPLACE VIEW vw_question_long_content AS
SELECT 
    QuestionID,
    Content,
      CHAR_LENGTH(Content) AS content_length
FROM Question
WHERE LENGTH(Content) > 300;


#4  Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
CREATE OR REPLACE VIEW vw_department_most_employee AS
SELECT 
    d.DepartmentID,
    d.Department_Name,
    COUNT(a.AccountID) AS total_employee
FROM department d
LEFT JOIN Account a
    ON d.DepartmentID = a.DepartmentID
GROUP BY d.DepartmentID, d.Department_Name
HAVING COUNT(a.AccountID) = (
    SELECT MAX(emp_count)
    FROM (
        SELECT COUNT(a2.AccountID) AS emp_count
        FROM Department d2
        LEFT JOIN Account a2
            ON d2.DepartmentID = a2.DepartmentID
        GROUP BY d2.DepartmentID
    ) AS t
);

#5 Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo.
CREATE OR REPLACE VIEW vw_question_creator_nguyen AS
SELECT 
    q.QuestionID,
    q.Content,
    q.CreateDate,
    a.FullName AS CreatorName
FROM Question q
JOIN Account a
    ON q.CreatorID = a.AccountID
WHERE a.FullName LIKE 'Nguyễn%';


SELECT 
    TABLE_NAME,
    COLUMN_NAME,
    CONSTRAINT_NAME
FROM information_schema.KEY_COLUMN_USAGE
WHERE REFERENCED_TABLE_NAME = 'account'
  AND REFERENCED_COLUMN_NAME = 'Email'
  AND TABLE_SCHEMA = 'testing_system';
#drop FOREIGN KEY
ALTER TABLE exam DROP FOREIGN KEY exam_ibfk_1;
ALTER TABLE `group` DROP FOREIGN KEY group_ibfk_1;
ALTER TABLE groupaccount DROP FOREIGN KEY groupaccount_ibfk_2;
ALTER TABLE question DROP FOREIGN KEY question_ibfk_2;