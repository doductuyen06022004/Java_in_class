SELECT * FROM testing_system.trainee;GenderGenderGenderTraining_Class
INSERT INTO `testing_system`.`trainee` (`TraineeID`, `Full_Name`, `Birth_Date`, `Gender`, `ET_IQ`, `ET_Gmath`, `ET_English`, `Training_Class`, `Evaluation_Notes`, `VTI_Account`) VALUES ('3', 'tuyen', '2000-05-12', 'male', '4', '6', '7', 'ed_023', '6', 'c');
INSERT INTO `testing_system`.`trainee` (`TraineeID`, `Full_Name`, `Birth_Date`, `Gender`, `ET_IQ`, `ET_Gmath`, `ET_English`, `Training_Class`, `Evaluation_Notes`, `VTI_Account`) VALUES ('4', 'tuyen', '1999-02-21', 'male', '9', '9', '9', 'ed_21', 'f', 'd');
INSERT INTO `testing_system`.`trainee` (`TraineeID`, `Full_Name`, `Birth_Date`, `Gender`, `ET_IQ`, `ET_Gmath`, `ET_English`, `Training_Class`, `Evaluation_Notes`, `VTI_Account`) VALUES ('5', 'tuyen', '2001-11-03', 'male', '6', '4', '7', 'ed_21', 's', 'e');
INSERT INTO `testing_system`.`trainee` (`TraineeID`, `Full_Name`, `Birth_Date`, `Gender`, `ET_IQ`, `ET_Gmath`, `ET_English`, `Training_Class`, `Evaluation_Notes`, `VTI_Account`) VALUES ('6', 'tuyen', '1997-10-22', 'male', '9', '5', '4', 'ed_21', 'a', 'f');
INSERT INTO `testing_system`.`trainee` (`TraineeID`, `Full_Name`, `Birth_Date`, `Gender`, `ET_IQ`, `ET_Gmath`, `ET_English`, `Training_Class`, `Evaluation_Notes`, `VTI_Account`) VALUES ('7', 'tuyen', '1997-10-22', 'male', '9', '9', '9', 'ed_21', 'v', 'g');
INSERT INTO `testing_system`.`trainee` (`TraineeID`, `Full_Name`, `Birth_Date`, `Gender`, `ET_IQ`, `ET_Gmath`, `ET_English`, `Training_Class`, `Evaluation_Notes`, `VTI_Account`) VALUES ('8', 'tuyen', '1998-07-05', 'male', '9', '9', '9', 'ed_21', 'x', 'h');
INSERT INTO `testing_system`.`trainee` (`TraineeID`, `Full_Name`, `Birth_Date`, `Gender`, `ET_IQ`, `ET_Gmath`, `ET_English`, `Training_Class`, `Evaluation_Notes`, `VTI_Account`) VALUES ('9', 'tuyen', '2001-03-15', 'male', '9', '9', '9', 'ed_21', 's', 'y');
INSERT INTO `testing_system`.`trainee` (`TraineeID`, `Full_Name`, `Birth_Date`, `Gender`, `ET_IQ`, `ET_Gmath`, `ET_English`, `Training_Class`, `Evaluation_Notes`, `VTI_Account`) VALUES ('10', 'tuyen', '1997-06-08', 'male', '9', '9', '9', 'ed_21', 'f', 'k');
UPDATE `testing_system`.`trainee` SET `VTI_Account` = 'b' WHERE (`TraineeID` = '2');
SELECT * FROM Department;

SELECT DepartmentID FROM department
WHERE  DepartmentName = 'Sale';

SELECT * FROM Account
ORDER BY LENGTH(fullname) DESC
LIMIT 1;

SELECT g.GroupName
FROM `Group` g
JOIN GroupAccount ga ON g.GroupID = ga.groupID
WHERE ga.GroupID < '2019-12-20';
DESCRIBE GroupAccount;

SELECT *
FROM Account
WHERE DepartmentID = 3
ORDER BY LENGTH(FullName) DESC
LIMIT 1;

SELECT DISTINCT g.GroupName
FROM `Group` g
JOIN GroupAccount ga ON g.GroupID = ga.GroupID
WHERE ga.JoinDate < '2019-12-20';

SELECT QuestionID
FROM Answer
GROUP BY QuestionID
HAVING COUNT(AnswerID) >= 4;

SELECT ExamID
FROM Exam
WHERE Duration >= 60
  AND CreateDate < '2019-12-20';
  
  SELECT *
FROM `Group`
ORDER BY CreateDate DESC
LIMIT 5;

SELECT COUNT(*) AS NumEmployees
FROM Account
WHERE DepartmentID = 2;

SELECT *
FROM Account
WHERE FullName LIKE 'D%o';

SET SQL_SAFE_UPDATES = 0;
DELETE FROM Exam
WHERE CreateDate < '2019-12-20';
SET SQL_SAFE_UPDATES = 1;

SET SQL_SAFE_UPDATES = 0;
DELETE FROM Question
WHERE content LIKE 'câu hỏi%';
SET SQL_SAFE_UPDATES = 1;

UPDATE Account
SET FullName = 'Nguyễn Bá Lộc',
    Email = 'loc.nguyenba@vti.com.vn'
WHERE PositionID  = 5;

SELECT * FROM `Group` WHERE GroupID = 1;