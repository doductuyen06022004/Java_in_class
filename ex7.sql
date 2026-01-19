CREATE DATABASE ThucTap;
USE ThucTap;

CREATE TABLE GiangVien (
    magv INT PRIMARY KEY,
    hoten VARCHAR(100) NOT NULL,
    luong DECIMAL(10,2) CHECK (luong > 0)
);

CREATE TABLE SinhVien (
    masv INT PRIMARY KEY,
    hoten VARCHAR(100) NOT NULL,
    namsinh INT,
    quequan VARCHAR(100)
);

CREATE TABLE DeTai (
    madt INT PRIMARY KEY,
    tendt VARCHAR(100) NOT NULL,
    kinhphi DECIMAL(10,2),
    NoiThucTap VARCHAR(100)
);

CREATE TABLE HuongDan (
    id INT PRIMARY KEY AUTO_INCREMENT,
    masv INT,
    madt INT,
    magv INT,
    ketqua VARCHAR(50),

    CONSTRAINT fk_hd_sv FOREIGN KEY (masv) REFERENCES SinhVien(masv),
    CONSTRAINT fk_hd_dt FOREIGN KEY (madt) REFERENCES DeTai(madt),
    CONSTRAINT fk_hd_gv FOREIGN KEY (magv) REFERENCES GiangVien(magv)
);

CREATE TABLE HuongDan (
    id INT PRIMARY KEY AUTO_INCREMENT,
    masv INT,
    madt INT,
    magv INT,
    ketqua VARCHAR(50),

    CONSTRAINT fk_hd_sv FOREIGN KEY (masv) REFERENCES SinhVien(masv),
    CONSTRAINT fk_hd_dt FOREIGN KEY (madt) REFERENCES DeTai(madt),
    CONSTRAINT fk_hd_gv FOREIGN KEY (magv) REFERENCES GiangVien(magv)
    
);


-- Giảng viên
INSERT INTO GiangVien VALUES
(1, 'Nguyen Van A', 15000000),
(2, 'Tran Thi B', 16000000),
(3, 'Le Van C', 17000000);

-- Sinh viên
INSERT INTO SinhVien VALUES
(101, 'Pham Minh Tuan', 2002, 'Ha Noi'),
(102, 'Nguyen Thi Lan', 2001, 'Hai Phong'),
(103, 'Le Hoang Nam', 2000, 'Da Nang');

-- Đề tài
INSERT INTO DeTai VALUES
(201, 'CONG NGHE SINH HOC', 5000000, 'Vien Sinh Hoc'),
(202, 'TRI TUE NHAN TAO', 7000000, 'Cong ty AI');

-- Hướng dẫn
INSERT INTO HuongDan (masv, madt, magv, ketqua) VALUES
(101, 201, 1, 'Dat'),
(102, 202, 2, 'Dat');

SELECT sv.*
FROM SinhVien sv
LEFT JOIN HuongDan hd ON sv.masv = hd.masv
WHERE hd.masv IS NULL;



SELECT COUNT(*) AS SoSinhVien
FROM HuongDan hd
JOIN DeTai dt ON hd.madt = dt.madt
WHERE dt.tendt = 'CONG NGHE SINH HOC';

CREATE VIEW SinhVienInfo AS
SELECT 
    sv.masv,
    sv.hoten,
    IFNULL(dt.tendt, 'Chưa có') AS tendt
FROM SinhVien sv
LEFT JOIN HuongDan hd ON sv.masv = hd.masv
LEFT JOIN DeTai dt ON hd.madt = dt.madt;

SELECT * FROM SinhVienInfo;

DELIMITER $$

CREATE TRIGGER trg_check_namsinh
BEFORE INSERT ON SinhVien
FOR EACH ROW
BEGIN
    IF NEW.namsinh <= 1900 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'năm sinh phải > 1900';
    END IF;
END$$

DELIMITER ;

INSERT INTO SinhVien VALUES (104, 'Test SV', 1890, 'HN');
ALTER TABLE HuongDan DROP FOREIGN KEY fk_hd_sv;
DELIMITER $$

CREATE TRIGGER trg_delete_huongdan
BEFORE DELETE ON SinhVien
FOR EACH ROW
BEGIN
    DELETE FROM HuongDan
    WHERE masv = OLD.masv;
END$$

DELIMITER ;

DELETE FROM SinhVien WHERE masv = 102;
