 # Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo
#trước 1 năm trước
DELIMITER $$
CREATE TRIGGER trg_group_check_createdate
BEFORE INSERT ON `Group`
FOR EACH ROW
BEGIN
    IF NEW.CreateDate < DATE_SUB(CURDATE(), INTERVAL 1 YEAR) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'CreateDate must be within 1 year';
    END IF;
END $$
DELIMITER ;

#Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào
#department "Sale" nữa, khi thêm thì hiện ra thông báo "Department
#"Sale" cannot add more user"
DELIMITER $$
CREATE TRIGGER trg_no_add_user_to_sale
BEFORE INSERT ON Account
FOR EACH ROW
BEGIN
    DECLARE dep_name VARCHAR(50);
    SELECT Department_Name INTO dep_name
    FROM Department WHERE DepartmentID = NEW.DepartmentID;

    IF dep_name = 'Sale' THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
    END IF;
END $$
DELIMITER ;


#Question 3: Cấu hình 1 group có nhiều nhất là 5 user
DELIMITER $$
CREATE TRIGGER trg_group_max_5_user
BEFORE INSERT ON GroupAccount
FOR EACH ROW
BEGIN
    DECLARE total INT;
    SELECT COUNT(*) INTO total
    FROM GroupAccount
    WHERE GroupID = NEW.GroupID;

    IF total >= 5 THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Group can contain max 5 users';
    END IF;
END $$
DELIMITER ;


#Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question
DELIMITER $$
CREATE TRIGGER trg_exam_max_10_question
BEFORE INSERT ON ExamQuestion
FOR EACH ROW
BEGIN
    DECLARE total INT;
    SELECT COUNT(*) INTO total
    FROM ExamQuestion
    WHERE ExamID = NEW.ExamID;

    IF total >= 10 THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Exam can contain max 10 questions';
    END IF;
END $$
DELIMITER ;

#Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là
#admin@gmail.com (đây là tài khoản admin, không cho phép user xóa),
#còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông
#tin liên quan tới user đó
DELIMITER $$
CREATE TRIGGER trg_no_delete_admin
BEFORE DELETE ON Account
FOR EACH ROW
BEGIN
    IF OLD.Email = 'admin@gmail.com' THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Cannot delete admin account';
    END IF;
END $$
DELIMITER ;


#Question 6: Không sử dụng cấu hình default cho field DepartmentID của table
#Account, hãy tạo trigger cho phép người dùng khi tạo account không điền
#vào departmentID thì sẽ được phân vào phòng ban "waiting Department"
DELIMITER $$
CREATE TRIGGER trg_account_default_department
BEFORE INSERT ON Account
FOR EACH ROW
BEGIN
    IF NEW.DepartmentID IS NULL THEN
        SELECT DepartmentID INTO NEW.DepartmentID
        FROM Department
        WHERE Department_Name = 'waiting Department';
    END IF;
END $$
DELIMITER ;

#Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi
#question, trong đó có tối đa 2 đáp án đúng.
DELIMITER $$
CREATE TRIGGER trg_answer_limit
BEFORE INSERT ON Answer
FOR EACH ROW
BEGIN
    DECLARE total_answer INT;
    DECLARE total_correct INT;

    SELECT COUNT(*) INTO total_answer
    FROM Answer WHERE QuestionID = NEW.QuestionID;

    IF total_answer >= 4 THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Max 4 answers per question';
    END IF;

    IF NEW.isCorrect = 1 THEN
        SELECT COUNT(*) INTO total_correct
        FROM Answer WHERE QuestionID = NEW.QuestionID AND isCorrect = 1;

        IF total_correct >= 2 THEN
            SIGNAL SQLSTATE '45000'
                SET MESSAGE_TEXT = 'Max 2 correct answers allowed';
        END IF;
    END IF;

END $$
DELIMITER ;

#Question 8: Viết trigger sửa lại dữ liệu cho đúng:
#Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định
#Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database
DELIMITER $$
CREATE TRIGGER trg_fix_gender
BEFORE INSERT ON Account
FOR EACH ROW
BEGIN
    IF NEW.Gender IN ('nam', 'Nam', 'NAM') THEN
        SET NEW.Gender = 'M';
    ELSEIF NEW.Gender IN ('nu', 'nữ', 'Nữ', 'NU') THEN
        SET NEW.Gender = 'F';
    ELSEIF NEW.Gender IN ('khong xac dinh', 'chua xac dinh', 'U') THEN
        SET NEW.Gender = 'U';
    END IF;
END $$
DELIMITER ;

#Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày
DELIMITER $$
CREATE TRIGGER trg_no_delete_exam_2days
BEFORE DELETE ON Exam
FOR EACH ROW
BEGIN
    IF OLD.CreateDate >= DATE_SUB(CURDATE(), INTERVAL 2 DAY) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Cannot delete an exam created within 2 days';
    END IF;
END $$
DELIMITER ;

#Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các
#question khi question đó chưa nằm trong exam nào
DELIMITER $$
CREATE TRIGGER trg_no_edit_question_if_in_exam
BEFORE UPDATE ON Question
FOR EACH ROW
BEGIN
    IF EXISTS(SELECT 1 FROM ExamQuestion WHERE QuestionID = OLD.QuestionID) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Cannot update question already in an exam';
    END IF;
END $$
DELIMITER ;

#Question 12: Lấy ra thông tin exam trong đó:
#Duration <= 30 thì sẽ đổi thành giá trị "Short time"
#30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
#Duration > 60 thì sẽ đổi thành giá trị "Long time"
SELECT 
    ExamID,
    Title,
    Duration,
    CASE
        WHEN Duration <= 30 THEN 'Short time'
        WHEN Duration <= 60 THEN 'Medium time'
        ELSE 'Long time'
    END AS DurationType
FROM Exam;

#Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên
#là the_number_user_amount và mang giá trị được quy định như sau:
#Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
#Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
#Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher
SELECT 
    g.GroupID,
    g.GroupName,
    COUNT(ga.AccountID) AS total_user,
    CASE
        WHEN COUNT(ga.AccountID) <= 5 THEN 'few'
        WHEN COUNT(ga.AccountID) <= 20 THEN 'normal'
        ELSE 'higher'
    END AS the_number_user_amount
FROM `Group` g
LEFT JOIN GroupAccount ga ON g.GroupID = ga.GroupID
GROUP BY g.GroupID;

#Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào
#không có user thì sẽ thay đổi giá trị 0 thành "Không có User"
SELECT
    d.DepartmentID,
    d.Department_Name,
    CASE
        WHEN COUNT(a.AccountID) = 0 THEN 'Không có User'
        ELSE COUNT(a.AccountID)
    END AS total_user
FROM Department d
LEFT JOIN Account a ON d.DepartmentID = a.DepartmentID
GROUP BY d.DepartmentID;
