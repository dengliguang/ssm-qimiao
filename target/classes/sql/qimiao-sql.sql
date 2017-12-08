---��̨�û���
CREATE TABLE `users_tb` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '��̨�˺�ID' ,
`user_phone`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '�˺�(�û��ֻ�����)' ,
`password`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '����' ,
`time`  datetime NULL COMMENT '����ʱ��' ,
PRIMARY KEY (`id`),
UNIQUE INDEX `user_phone` (`user_phone`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1
ROW_FORMAT=COMPACT
;

---���ű�news_tb
CREATE TABLE `news_tb` (
`news_id`  int(11) NOT NULL AUTO_INCREMENT ,
`title`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '���ű���' ,
`type`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '��������' ,
`content`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '��������' ,
`time`  datetime NOT NULL COMMENT 'ʱ��' ,
`pic_total`  int(10) NOT NULL COMMENT 'ͼƬ����' ,
`status`  int(10) NOT NULL COMMENT '����״̬' ,
PRIMARY KEY (`news_id`),
UNIQUE INDEX `title` (`title`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=79
ROW_FORMAT=COMPACT
;

---����ͼƬ��img_tb
CREATE TABLE `img_tb` (
`img_id`  int(11) NOT NULL AUTO_INCREMENT COMMENT 'ͼƬid' ,
`img_src`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ͼƬ·��' ,
`news_id`  int(11) NOT NULL COMMENT '����id(���)' ,
`img_num`  int(11) NOT NULL COMMENT 'ͼƬ˳��' ,
PRIMARY KEY (`img_id`),
FOREIGN KEY (`news_id`) REFERENCES `news_tb` (`news_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
UNIQUE INDEX `img_src` (`img_src`) USING BTREE ,
UNIQUE INDEX `img_num` (`img_num`) USING BTREE ,
INDEX `news_id` (`news_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=4
ROW_FORMAT=COMPACT
;

---״̬��status_tb
CREATE TABLE `status_tb` (
`status_id`  int(10) NOT NULL AUTO_INCREMENT COMMENT '״̬ID' ,
`status`  int(10) NOT NULL COMMENT '״̬(1,2)' ,
`annotation`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '״̬����(�ϼܡ��¼�)' ,
PRIMARY KEY (`status_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1
ROW_FORMAT=COMPACT
;



