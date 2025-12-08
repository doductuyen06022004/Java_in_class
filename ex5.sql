#1 Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
CREATE OR REPLACE VIEW vw_employee_sale AS
SELECT 
    a.AccountID,
    a.FullName,
    a.Email,
    d.DepartmentName
FROM Account a
JOIN Department d 
    ON a.DepartmentID = d.DepartmentID
WHERE d.DepartmentName = 'Sale';
#2 Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
CREATE OR REPLACE VIEW vw_account_most_groups AS
SELECT 
    a.AccountID,
    a.FullName,
    a.Email,
    COUNT(ga.GroupID) AS total_groups
FROM Account a
JOIN GroupAccount ga
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
    d.DepartmentName,
    COUNT(a.AccountID) AS total_employee
FROM Department d
LEFT JOIN Account a
    ON d.DepartmentID = a.DepartmentID
GROUP BY d.DepartmentID, d.DepartmentName
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

