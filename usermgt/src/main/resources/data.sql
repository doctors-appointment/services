use `usermgt`;

DROP TABLE IF EXISTS `USER_MGT_HEALTH`;

CREATE TABLE `USER_MGT_HEALTH` (
   `health_id` int AUTO_INCREMENT  PRIMARY KEY,
   `type` varchar(100) NOT NULL,
   `description` varchar(200) NOT NULL,
   `createdAt` datetime DEFAULT NULL,
   `updatedAt` datetime DEFAULT NULL
);

INSERT INTO `USER_MGT_HEALTH` (`type`,`description`,`createdAt`, `updatedAt`)
 VALUES ('HEALTH','usermgt service and database health is good.', CURDATE(), CURDATE());
