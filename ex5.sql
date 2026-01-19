DELIMITER $$
CREATE PROCEDURE sp_get_department_name_by_id(
    IN p_DepartmentID varchar 
)
BEGIN
    SELECT Department_Name
    FROM Department 
    WHERE DepartmentID = p_DepartmentID;
END $$
DELIMITER ;
CALL sp_get_department_name_by_id(2);


#Viết procedure, them các account chưa có trong group nào vào 1 group được truyền vào từ input
#Nếu tất cả account đã ở trong group thì thông báo message “Tất cả account đã đc tham gia vào group”

# b1 dem so luong account
# b2 dem so luong account da tham group vao group
# b3 so sanh, neu 2 thang nay bang nhau thi throw message, neu khong bang nhau thi sang b4
# b4 tim cac account chua co trong group sau do them vao group dc truyen vao tu input

drop procedure if exists add_account_to_group;
delimiter $$
create procedure add_account_to_group(in i_group_id int)
    begin
        #b1 dem so luong account
        declare account_number int;
        declare account_join_group int;
        select count(accountid) into account_number from account;
        #b2 dem so luong account tham gia vao group
        select count(DISTINCT accountid) into account_join_group from group_account;
        # b3
        IF account_number = account_join_group THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Tất cả account đã tham gia vào group';
        END IF;
        #b4
        insert into group_account(group_id, accountid, join_date)
        select i_group_id, account.accountid , now()
        from account
        where account.accountid not in (
            select accountid
            from group_account
        );
    end $$
delimiter ;
call add_account_to_group(1);


delimiter ; 

DELIMITER $$
Set global u
CREATE FUNCTION fn_get_department_name(p_DepartmentID INT)
RETURNS VARCHAR(50)
DETERMINISTIC
BEGIN
    DECLARE deptName VARCHAR(50);

    SELECT Department_Name
    INTO deptName
    FROM department
    WHERE DepartmentID = p_DepartmentID;

    RETURN deptName;
END $$

DELIMITER ;
SELECT fn_get_department_name(54);


DELIMITER $$

USE `testing_system`$$

CREATE FUNCTION max_acc_group ()
RETURNS INTEGER
BEGIN
    declare max_ag int;

    SELECT
        account_id
    INTO max_ag FROM
        group_account ga
    GROUP BY account_id
    HAVING COUNT(group_id) = (
        SELECT
            MAX(num)
        FROM
            (SELECT
                COUNT(group_id) num
             FROM
                group_account
             GROUP BY account_id) t
    );

    RETURN max_ag;
END$$

DELIMITER ;
select testing_system.max_acc_group();

