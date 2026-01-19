DROP TRIGGER IF EXISTS trigger_create_Time;
DELIMITER $$
CREATE TRIGGER trigger_create_Time
BEFORE INSERT ON `Question`
FOR EACH ROW
BEGIN
    IF NEW.`CreateDate` > NOW() THEN
        SET NEW.`CreateDate` = NOW();
    END IF;
END $$

DELIMITER ;

-- Xóa question có id = 2
DELETE 
FROM `Question`
WHERE QuestionID = 2;
-- Xóa trigger cũ nếu tồn tại
DROP TRIGGER IF EXISTS trigger_delete_question;
DELIMITER $$
-- Tạo trigger xóa answer khi question bị xóa
CREATE TRIGGER trigger_delete_question
BEFORE DELETE ON `Question`
FOR EACH ROW
BEGIN
    -- Xóa tất cả answer thuộc question đang bị xóa
    DELETE 
    FROM Answer
    WHERE question_ID = OLD.id;
END $$
DELIMITER ;
