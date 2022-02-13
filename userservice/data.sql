use `userservice`;

DROP TABLE IF EXISTS `USER_SERVICE_HEALTH`;

CREATE TABLE `USER_SERVICE_HEALTH` (
   `health_id` int AUTO_INCREMENT  PRIMARY KEY,
   `type` varchar(100) NOT NULL,
   `description` varchar(200) NOT NULL,
   `createdAt` datetime DEFAULT NULL,
   `updatedAt` datetime DEFAULT NULL
);

INSERT INTO `USER_SERVICE_HEALTH` (`type`,`description`,`createdAt`, `updatedAt`)
 VALUES ('HEALTH','userservice miroservice and database health is good.', CURDATE(), CURDATE());
