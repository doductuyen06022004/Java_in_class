# Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó.
DELIMITER $$
CREATE PROCEDURE sp_get_account_by_department_name (
    IN p_department_name VARCHAR(50)
)
BEGIN
    SELECT a.*
    FROM Account a
    JOIN Department d ON a.DepartmentID = d.DepartmentID
    WHERE d.Department_Name = p_department_name;
END $$
DELIMITER ;
# Question 2: Tạo store để in ra số lượng account trong mỗi group.
DELIMITER $$
CREATE PROCEDURE sp_count_account_in_group ()
BEGIN
    SELECT g.GroupID, g.GroupName, COUNT(ga.AccountID) AS total_account
    FROM `Group` g
    LEFT JOIN GroupAccount ga ON g.GroupID = ga.GroupID
    GROUP BY g.GroupID, g.GroupName;
END $$
DELIMITER ;
# Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại.
DELIMITER $$
CREATE PROCEDURE sp_count_question_by_type_current_month ()
BEGIN
    SELECT t.TypeName, COUNT(q.QuestionID) AS total_question
    FROM TypeQuestion t
    LEFT JOIN Question q 
        ON t.TypeID = q.TypeID
        AND MONTH(q.CreateDate) = MONTH(CURDATE())
        AND YEAR(q.CreateDate) = YEAR(CURDATE())
    GROUP BY t.TypeName;
END $$
DELIMITER ;
# Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất.\
DELIMITER $$
CREATE PROCEDURE sp_get_type_id_max_question ()
BEGIN
    SELECT TypeID
    FROM Question
    GROUP BY TypeID
    ORDER BY COUNT(QuestionID) DESC
    LIMIT 1;
END $$
DELIMITER ;
# Question 5: Sử dụng store ở question 4 để tìm ra tên của type question.
DELIMITER $$

CREATE PROCEDURE sp_get_type_name_max_question ()
BEGIN
    SELECT t.TypeName
    FROM TypeQuestion t
    WHERE t.TypeID = (
        SELECT TypeID
        FROM Question
        GROUP BY TypeID
        ORDER BY COUNT(QuestionID) DESC
        LIMIT 1
    );
END $$
DELIMITER ;
#Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa chuỗi của người dùng nhập vào.
DELIMITER $$
CREATE PROCEDURE sp_search_group_or_user (
    IN p_keyword VARCHAR(50)
)
BEGIN
    SELECT 'GROUP' AS Type, GroupName AS Name
    FROM `Group`
    WHERE GroupName LIKE CONCAT('%', p_keyword, '%')
    UNION
    SELECT 'ACCOUNT', Username
    FROM Account
    WHERE Username LIKE CONCAT('%', p_keyword, '%');
END $$
DELIMITER ;
# Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và trong store sẽ tự động gán 
# username sẽ giống email nhưng bỏ phần @..mail đi
# positionID: sẽ có default là developer
# departmentID: sẽ được cho vào 1 phòng chờ
# Sau đó in ra kết quả tạo thành công
DELIMITER $$
CREATE PROCEDURE sp_create_account_auto (
    IN p_fullname VARCHAR(50),
    IN p_email VARCHAR(50)
)
BEGIN
    DECLARE v_username VARCHAR(50);
    DECLARE v_position_id INT;
    DECLARE v_department_id INT;
    SELECT PositionID INTO v_position_id
    FROM Position
    WHERE PositionName = 'Developer'
    LIMIT 1;
    SELECT DepartmentID INTO v_department_id
    FROM Department
    WHERE Department_Name = 'Phòng chờ'
    LIMIT 1;
    SET v_username = SUBSTRING_INDEX(p_email, '@', 1);
    INSERT INTO Account (FullName, Email, Username, PositionID, DepartmentID, CreateDate)
    VALUES (p_fullname, p_email, v_username, v_position_id, v_department_id, NOW());
    SELECT 'Tạo account thành công' AS message;
END $$
DELIMITER ;
# Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất
DELIMITER $$
CREATE PROCEDURE sp_get_longest_question_by_type (
    IN p_type_name VARCHAR(30)
)
BEGIN
    SELECT q.*
    FROM Question q
    JOIN TypeQuestion t ON q.TypeID = t.TypeID
    WHERE t.TypeName = p_type_name
    ORDER BY LENGTH(q.Content) DESC
    LIMIT 1;
END $$
DELIMITER ;
# Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
DELIMITER $$
CREATE PROCEDURE sp_delete_exam_by_id (
    IN p_exam_id INT
)
BEGIN
    DELETE FROM Exam
    WHERE ExamID = p_exam_id;
END $$
DELIMITER ;
# Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử dụng store ở câu 9 để xóa) Sau đó in số lượng record đã remove từ các table liên quan trong khi removing
DELIMITER $$
CREATE PROCEDURE sp_delete_exam_3years_ago ()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE v_exam_id INT;
    DECLARE v_count INT DEFAULT 0;
    DECLARE cur CURSOR FOR
        SELECT ExamID
        FROM Exam
        WHERE CreateDate < DATE_SUB(CURDATE(), INTERVAL 3 YEAR);
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
    OPEN cur;
    exam_loop: LOOP
        FETCH cur INTO v_exam_id;
        IF done THEN
            LEAVE exam_loop;
        END IF;
        CALL sp_delete_exam_by_id(v_exam_id);
        SET v_count = v_count + 1;
    END LOOP;
    CLOSE cur;
    SELECT v_count AS total_exam_removed;
END $$
DELIMITER ;
# Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được chuyển về phòng ban default là phòng ban chờ việc
DELIMITER $$
CREATE PROCEDURE sp_delete_department_by_name (
    IN p_department_name VARCHAR(50)
)
BEGIN
    DECLARE v_department_id INT;
    SELECT DepartmentID INTO v_department_id
    FROM Department
    WHERE Department_Name = p_department_name;
    UPDATE Account
    SET DepartmentID = 1
    WHERE DepartmentID = v_department_id;
    DELETE FROM Department
    WHERE DepartmentID = v_department_id;
END $$
DELIMITER ;
# Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay
DELIMITER $$

CREATE PROCEDURE sp_count_question_by_month_current_year ()
BEGIN
    SELECT MONTH(CreateDate) AS month, COUNT(*) AS total_question
    FROM Question
    WHERE YEAR(CreateDate) = YEAR(CURDATE())
    GROUP BY MONTH(CreateDate);
END $$
DELIMITER ;
# Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6 tháng gần đây nhất (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong tháng")
DELIMITER $$

CREATE PROCEDURE sp_count_question_last_6_months ()
BEGIN
    SELECT 
        m.month_value AS month,
        CASE 
            WHEN COUNT(q.QuestionID) = 0 
                THEN 'không có câu hỏi nào trong tháng'
            ELSE CAST(COUNT(q.QuestionID) AS CHAR)
        END AS total_question
    FROM (
        SELECT MONTH(DATE_SUB(CURDATE(), INTERVAL n MONTH)) AS month_value
        FROM (
            SELECT 0 n UNION SELECT 1 UNION SELECT 2 
            UNION SELECT 3 UNION SELECT 4 UNION SELECT 5
        ) t
    ) m
    LEFT JOIN Question q 
        ON MONTH(q.CreateDate) = m.month_value
        AND q.CreateDate >= DATE_SUB(CURDATE(), INTERVAL 6 MONTH)
    GROUP BY m.month_value
    ORDER BY m.month_value;
END $$

DELIMITER ;



