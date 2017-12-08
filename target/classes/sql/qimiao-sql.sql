---后台用户表
CREATE TABLE `users_tb` (
`id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '后台账号ID' ,
`user_phone`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号(用户手机号码)' ,
`password`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码' ,
`time`  datetime NULL COMMENT '创建时间' ,
PRIMARY KEY (`id`),
UNIQUE INDEX `user_phone` (`user_phone`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1
ROW_FORMAT=COMPACT
;

---新闻表news_tb
CREATE TABLE `news_tb` (
`news_id`  int(11) NOT NULL AUTO_INCREMENT ,
`title`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '新闻标题' ,
`type`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '新闻类型' ,
`content`  longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '新闻内容' ,
`time`  datetime NOT NULL COMMENT '时间' ,
`pic_total`  int(10) NOT NULL COMMENT '图片总数' ,
`status`  int(10) NOT NULL COMMENT '新闻状态' ,
PRIMARY KEY (`news_id`),
UNIQUE INDEX `title` (`title`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=79
ROW_FORMAT=COMPACT
;

---新闻图片表img_tb
CREATE TABLE `img_tb` (
`img_id`  int(11) NOT NULL AUTO_INCREMENT COMMENT '图片id' ,
`img_src`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片路径' ,
`news_id`  int(11) NOT NULL COMMENT '新闻id(外键)' ,
`img_num`  int(11) NOT NULL COMMENT '图片顺序' ,
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

---状态表：status_tb
CREATE TABLE `status_tb` (
`status_id`  int(10) NOT NULL AUTO_INCREMENT COMMENT '状态ID' ,
`status`  int(10) NOT NULL COMMENT '状态(1,2)' ,
`annotation`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态中文(上架、下架)' ,
PRIMARY KEY (`status_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1
ROW_FORMAT=COMPACT
;



