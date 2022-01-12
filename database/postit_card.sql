
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- 表结构
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL DEFAULT '',
  `body` text NOT NULL,
  `publication_date` datetime NOT NULL,
  `expiration_date` datetime NOT NULL,
  `is_visible` tinyint(4) unsigned NOT NULL COMMENT '1-可见 0-不可见',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=814 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;

DROP FUNCTION IF EXISTS `rand_string`;
-- 字符串随机函数
CREATE FUNCTION `rand_string`(n INT) RETURNS varchar(255) CHARSET latin1
BEGIN
DECLARE chars_str varchar(100) DEFAULT 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';
DECLARE return_str varchar(255) DEFAULT '' ;
DECLARE i INT DEFAULT 0;
WHILE i < n DO
SET return_str = concat(return_str,substring(chars_str , FLOOR(1 + RAND()*62 ),1));
SET i = i +1;
END WHILE;
RETURN return_str;
END;

DROP FUNCTION IF EXISTS `rand_enum`;
-- 01枚举随机函数
CREATE FUNCTION `rand_enum`() RETURNS TINYINT(4)

BEGIN
	declare res TINYINT;
	IF (ROUND(RAND()*10) > 5) THEN
		SET res=1;
ELSE
		SET res=0;
END IF;
RETURN res;
END;

DROP PROCEDURE IF EXISTS `add_cards`;
-- 批量插入存储过程
CREATE  PROCEDURE `add_cards`(IN n int)
BEGIN
  DECLARE i INT DEFAULT 1;
    WHILE (i <= n ) DO
      INSERT into card  (title,body,expiration_date,publication_date,is_visible )
			VALUEs (rand_string(RAND()*100),rand_string(RAND()*100),now() ,now(),rand_enum());
			set i=i+1;
END WHILE;
END
-- 调用存储过程 生成学号后三位数据 201915030406
CALL add_cards(406)
