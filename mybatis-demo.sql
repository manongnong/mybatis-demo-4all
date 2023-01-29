CREATE DATABASE `mybatis-demo` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

-- `mybatis-demo`.demo_user definition

CREATE TABLE `demo_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_code` varchar(100) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `age` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `mybatis-demo`.demo_user (user_code,user_name,age) VALUES ('tom','托姆1',12);
INSERT INTO `mybatis-demo`.demo_user (user_code,user_name,age) VALUES ('lucy','托姆1',22);
